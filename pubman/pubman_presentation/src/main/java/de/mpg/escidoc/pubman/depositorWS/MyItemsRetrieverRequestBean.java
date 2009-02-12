package de.mpg.escidoc.pubman.depositorWS;

import java.util.ArrayList;
import java.util.List;

import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;
import javax.naming.InitialContext;

import org.apache.log4j.Logger;

import de.mpg.escidoc.pubman.common_presentation.BaseListRetrieverRequestBean;
import de.mpg.escidoc.pubman.desktop.Login;
import de.mpg.escidoc.pubman.itemList.PubItemListSessionBean;
import de.mpg.escidoc.pubman.itemList.PubItemListSessionBean.SORT_CRITERIA;
import de.mpg.escidoc.pubman.util.CommonUtils;
import de.mpg.escidoc.pubman.util.LoginHelper;
import de.mpg.escidoc.pubman.util.PubItemVOPresentation;
import de.mpg.escidoc.services.common.XmlTransforming;
import de.mpg.escidoc.services.common.valueobjects.FilterTaskParamVO;
import de.mpg.escidoc.services.common.valueobjects.ItemVO;
import de.mpg.escidoc.services.common.valueobjects.FilterTaskParamVO.Filter;
import de.mpg.escidoc.services.common.valueobjects.publication.PubItemVO;
import de.mpg.escidoc.services.common.xmltransforming.wrappers.ItemVOListWrapper;
import de.mpg.escidoc.services.framework.PropertyReader;
import de.mpg.escidoc.services.framework.ServiceLocator;

/**
 * This bean is an implementation of the BaseListRetrieverRequestBean class for the My Items workspace.
 * It uses the PubItemListSessionBean as corresponding BasePaginatorListSessionBean and adds additional functionality for filtering the items by their state.
 *
 * @author Markus Haarlaender (initial creation)
 * @author $Author$ (last modification)
 * @version $Revision$ $LastChangedDate$
 *
 */
public class MyItemsRetrieverRequestBean extends BaseListRetrieverRequestBean<PubItemVOPresentation, PubItemListSessionBean.SORT_CRITERIA>
{
    private static Logger logger = Logger.getLogger(MyItemsRetrieverRequestBean.class);
    public static String BEAN_NAME = "MyItemsRetrieverRequestBean";
   
    /**
     * The GET parameter name for the item state.
     */
    protected static String parameterSelectedItemState = "itemState";
    
    /**
     * The total number of records
     */
    private int numberOfRecords;
    
    /**
     * The menu entries of the item state filtering menu
     */
    private List<SelectItem> itemStateSelectItems;
    
    /**
     * The currently selected item state.
     */
    private String selectedItemState;
    
    public MyItemsRetrieverRequestBean()
    {
        super((PubItemListSessionBean)getSessionBean(PubItemListSessionBean.class));
        logger.info("RenderResponse: "+FacesContext.getCurrentInstance().getRenderResponse());
        logger.info("ResponseComplete: "+FacesContext.getCurrentInstance().getResponseComplete());
       
        
    }
    
    /**
     * Checks if the user is logged in. If not, redirects to the login page.
     */
    protected void checkLogin()
    {
        LoginHelper loginHelper = (LoginHelper)getSessionBean(LoginHelper.class);
        Login login = (Login) getSessionBean(Login.class);
        
        //if not logged in redirect to login page
        if(!loginHelper.isLoggedIn())
        {
            try
            {
                login.loginLogout();
            }
            catch (Exception e){
                error("Could not redirect to login!");
            }
           
        }
        
    }

    @Override
    public void init()
    {
        checkLogin();
    }

    @Override
    public int getTotalNumberOfRecords()
    {
        return numberOfRecords;
    }

    @Override
    public List<PubItemVOPresentation> retrieveList(int offset, int limit, SORT_CRITERIA sc)
    {
        List<PubItemVOPresentation> returnList = new ArrayList<PubItemVOPresentation>();
        try
        {
            
            
            LoginHelper loginHelper = (LoginHelper) getSessionBean(LoginHelper.class);
            InitialContext initialContext = new InitialContext();
            XmlTransforming xmlTransforming = (XmlTransforming) initialContext.lookup(XmlTransforming.SERVICE_NAME);
      
            checkSortCriterias(sc);
            
            // define the filter criteria
            FilterTaskParamVO filter = new FilterTaskParamVO();
            
            Filter f1 = filter.new OwnerFilter(loginHelper.getAccountUser().getReference());
            filter.getFilterList().add(0,f1);
            Filter f2 = filter.new FrameworkItemTypeFilter(PropertyReader.getProperty("escidoc.framework_access.content-model.id.publication"));
            filter.getFilterList().add(f2);
            
            if (selectedItemState.toLowerCase().equals("withdrawn"))
            {
                //use public status instead of version status here
                Filter f3 = filter.new ItemPublicStatusFilter(PubItemVO.State.WITHDRAWN);
                filter.getFilterList().add(0,f3);
            }
            else if (selectedItemState.toLowerCase().equals("all"))
            {
               //no more filters
            }
            else
            {
                Filter f3 = filter.new ItemStatusFilter(PubItemVO.State.valueOf(selectedItemState));
                filter.getFilterList().add(0,f3);
                
                //all public status except withdrawn
                Filter f4 = filter.new ItemPublicStatusFilter(PubItemVO.State.IN_REVISION);
                filter.getFilterList().add(0,f4);
                Filter f5 = filter.new ItemPublicStatusFilter(PubItemVO.State.PENDING);
                filter.getFilterList().add(0,f5);
                Filter f6 = filter.new ItemPublicStatusFilter(PubItemVO.State.SUBMITTED);
                filter.getFilterList().add(0,f6);
                Filter f7 = filter.new ItemPublicStatusFilter(PubItemVO.State.RELEASED);
                filter.getFilterList().add(0,f7);
            }
               
                
            
                
            
            
            Filter f10 = filter.new OrderFilter(sc.getSortPath(), sc.getSortOrder());
            filter.getFilterList().add(f10);

            Filter f8 = filter.new LimitFilter(String.valueOf(limit));
            filter.getFilterList().add(f8);
            Filter f9 = filter.new OffsetFilter(String.valueOf(offset));
            filter.getFilterList().add(f9);
            
           
           
      
            
            String xmlparam = xmlTransforming.transformToFilterTaskParam(filter); 
          
            String xmlItemList = ServiceLocator.getItemHandler(loginHelper.getESciDocUserHandle()).retrieveItems(xmlparam);

            ItemVOListWrapper itemList = (ItemVOListWrapper) xmlTransforming.transformToItemListWrapper(xmlItemList);

            List<PubItemVO> pubItemList = new ArrayList<PubItemVO>();
            for(ItemVO item : itemList.getItemVOList())
            {
                pubItemList.add(new PubItemVO(item));
            }
            
            numberOfRecords = Integer.parseInt(itemList.getNumberOfRecords());
            returnList = CommonUtils.convertToPubItemVOPresentationList(pubItemList);
        }
        catch (Exception e)
        {
            logger.error("Error in retrieving items", e);
            error("Error in retrieving items");
            numberOfRecords = 0; 
        }
        return returnList;

    }

    /**
     * Checks if the selected sorting criteria is currently available. If not (empty string), it displays a warning message to the user.
     * @param sc The sorting criteria to be checked
     */
    protected void checkSortCriterias(SORT_CRITERIA sc)
    {
        if  (sc.getSortPath()== null || sc.getSortPath().equals(""))
        {
            error(getMessage("depositorWS_sortingNotSupported").replace("$1", getLabel("ENUM_CRITERIA_"+sc.name())));
            //getBasePaginatorListSessionBean().redirect();
        }
        
    }

  
    /**
     * Sets the current item state filter
     * @param itemStateSelectItem
     */
    public void setItemStateSelectItems(List<SelectItem> itemStateSelectItem)
    {
        this.itemStateSelectItems = itemStateSelectItem;
    }

    /**
     * Sets and returns the menu entries of the item state filter menu.
     * @return
     */
    public List<SelectItem> getItemStateSelectItems()
    {
        itemStateSelectItems = new ArrayList<SelectItem>();
        itemStateSelectItems.add(new SelectItem("all", getLabel("EditItem_NO_ITEM_SET")));
        itemStateSelectItems.add(new SelectItem(PubItemVO.State.PENDING.name(), getLabel(i18nHelper.convertEnumToString(PubItemVO.State.PENDING))));
        itemStateSelectItems.add(new SelectItem(PubItemVO.State.SUBMITTED.name(), getLabel(i18nHelper.convertEnumToString(PubItemVO.State.SUBMITTED))));
        itemStateSelectItems.add(new SelectItem(PubItemVO.State.RELEASED.name(), getLabel(i18nHelper.convertEnumToString(PubItemVO.State.RELEASED))));
        itemStateSelectItems.add(new SelectItem(PubItemVO.State.WITHDRAWN.name(), getLabel(i18nHelper.convertEnumToString(PubItemVO.State.WITHDRAWN))));
        itemStateSelectItems.add(new SelectItem(PubItemVO.State.IN_REVISION.name(), getLabel(i18nHelper.convertEnumToString(PubItemVO.State.IN_REVISION))));
        
        return itemStateSelectItems;
    }
    
    /**
     * Sets the selected item state filter
     * @param selectedItemState
     */
    public void setSelectedItemState(String selectedItemState)
    {
        this.selectedItemState = selectedItemState;
        getBasePaginatorListSessionBean().getParameterMap().put(parameterSelectedItemState, selectedItemState);
    }

    /**
     * Returns the currently selected item state filter
     * @return
     */
    public String getSelectedItemState()
    {
        return selectedItemState;
    }
    
    /**
     * Returns the label for the currently selected item state.
     * @return
     */
    public String getSelectedItemStateLabel()
    {
        String returnString = "";
        if (getSelectedItemState()!=null && !getSelectedItemState().equals("all"))
        {
            returnString =  getLabel(i18nHelper.convertEnumToString(PubItemVO.State.valueOf(getSelectedItemState())));
        }
        return returnString;
        
    }
    
    /**
     * Called by JSF whenever the item state menu is changed. 
     * @return
     */
    public String changeItemState()
    {
            try
            {
               
                getBasePaginatorListSessionBean().setCurrentPageNumber(1);
                getBasePaginatorListSessionBean().redirect();
            }
            catch (Exception e)
            {
               error("Could not redirect");
            }
            return "";
        
    }
    
    

    /**
     * Reads out the item state parameter from the HTTP GET request and sets an default value if it is null.
     */
    @Override
    public void readOutParameters()
    {
        String selectedItemState = getExternalContext().getRequestParameterMap().get(parameterSelectedItemState);
        if (selectedItemState==null)
        {
            setSelectedItemState("all");
        }
        else
        {
            setSelectedItemState(selectedItemState);
        }
        
    }

    @Override
    public String getType()
    {
        return "MyItems";
    }
    
    @Override
    public String getListPageName()
    {
        return "DepositorWSPage.jsp";
    }
    
   
    
  
}
