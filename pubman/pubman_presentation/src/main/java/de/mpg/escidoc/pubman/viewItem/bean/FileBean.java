/*
*
* CDDL HEADER START
*
* The contents of this file are subject to the terms of the
* Common Development and Distribution License, Version 1.0 only
* (the "License"). You may not use this file except in compliance
* with the License.
*
* You can obtain a copy of the license at license/ESCIDOC.LICENSE
* or http://www.escidoc.de/license.
* See the License for the specific language governing permissions
* and limitations under the License.
*
* When distributing Covered Code, include this CDDL HEADER in each
* file and include the License file at license/ESCIDOC.LICENSE.
* If applicable, add the following below this CDDL HEADER, with the
* fields enclosed by brackets "[]" replaced with your own identifying
* information: Portions Copyright [yyyy] [name of copyright owner]
*
* CDDL HEADER END
*/

/*
* Copyright 2006-2007 Fachinformationszentrum Karlsruhe Gesellschaft
* für wissenschaftlich-technische Information mbH and Max-Planck-
* Gesellschaft zur Förderung der Wissenschaft e.V.
* All rights reserved. Use is subject to license terms.
*/ 

package de.mpg.escidoc.pubman.viewItem.bean;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

import javax.faces.component.html.HtmlCommandButton;
import javax.faces.context.FacesContext;
import javax.faces.event.AbortProcessingException;
import javax.faces.event.ActionEvent;
import javax.faces.event.ActionListener;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpMethod;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.log4j.Logger;

import de.mpg.escidoc.pubman.ApplicationBean;
import de.mpg.escidoc.pubman.CommonSessionBean;
import de.mpg.escidoc.pubman.ItemControllerSessionBean;
import de.mpg.escidoc.pubman.appbase.InternationalizedImpl;
import de.mpg.escidoc.pubman.util.LoginHelper;
import de.mpg.escidoc.services.common.valueobjects.FileVO;
import de.mpg.escidoc.services.common.valueobjects.SearchHitVO;
import de.mpg.escidoc.services.common.valueobjects.ItemVO.State;
import de.mpg.escidoc.services.common.valueobjects.SearchHitVO.SearchHitType;
import de.mpg.escidoc.services.framework.ServiceLocator;
import de.mpg.escidoc.pubman.appbase.FacesBean;

/**
 * Bean for storing the information of files attached to items.
 * 
 * @author: Tobias Schraut, created 25.03.2008
 * @version: $Revision: 1609 $ $LastChangedDate: 2007-11-26 18:21:32 +0100 (Mo, 26 Nov 2007) $
 */
public class FileBean extends FacesBean implements ActionListener 
{
	private static Logger logger = Logger.getLogger(FileBean.class);
	private FileVO file;
	private int position;
	private State itemState;
	private List<SearchHitVO> searchHitList = new ArrayList<SearchHitVO>();
	private List<SearchHitBean> searchHits = new ArrayList<SearchHitBean>();

    /**
     * Public constructor
     * @param file
     * @param position
     * @param itemState
     */
    public FileBean(FileVO file, int position, State itemState)
	{
		this.file = file;
		this.position = position;
		this.itemState = itemState;
	}
    
    /**
     * Second constructor (used if pubitem has fulltext search hits)
     * @param file
     * @param position
     * @param itemState
     * @param resultitem
     */
    public FileBean(FileVO file, int position, State itemState, List<SearchHitVO> searchHitList)
	{
		this.file = file;
		this.position = position;
		this.itemState = itemState;
		this.searchHitList = searchHitList;
		initialize(file, position, itemState, searchHitList);
	}

    /**
     * Sets up some extra information concerning full text search hits
     * @param file
     * @param position
     * @param itemState
     * @param resultitem
     */
    protected void initialize(FileVO file, int position, State itemState, List<SearchHitVO> searchHitList)
    {
        // set some html elements which cannot be completely constructed in the jsp
    	
    	String beforeSearchHitString;
    	String searchHitString;
    	String afterSearchHitString;
    	
    	// browse through the list of files and examine which of the files is the one the search result hits where found in
        for(int i = 0; i < searchHitList.size(); i++)
        {
            if(searchHitList.get(i).getType() == SearchHitType.FULLTEXT)
            {    
                if(searchHitList.get(i).getHitReference() != null)
                {
                    if(searchHitList.get(i).getHitReference().equals(this.file.getReference()))
                    {
                        for(int j = 0; j < searchHitList.get(i).getTextFragmentList().size(); j++)
                        {
                            int startPosition = 0;
                            int endPosition = 0;
                            
                            startPosition = searchHitList.get(i).getTextFragmentList().get(j).getHitwordList().get(0).getStartIndex();
                            endPosition = searchHitList.get(i).getTextFragmentList().get(j).getHitwordList().get(0).getEndIndex() + 1;
                            
                            beforeSearchHitString ="..." + searchHitList.get(i).getTextFragmentList().get(j).getData().substring(0, startPosition);
                            searchHitString = searchHitList.get(i).getTextFragmentList().get(j).getData().substring(startPosition, endPosition);
                            afterSearchHitString = searchHitList.get(i).getTextFragmentList().get(j).getData().substring(endPosition) + "...";
                            
                            this.searchHits.add(new SearchHitBean(beforeSearchHitString, searchHitString, afterSearchHitString));
                        }
                    }
                    
                }
                
            }
            
        }
    }
    
    
    
    public String downloadFile()
    {
    	try 
    	{
			downloadFile(this.position);
		}
    	catch (IOException e) 
		{
    		logger.error("Could not download file! ", e);
		} 
    	catch (Exception e) 
    	{
    		logger.error("Could not download file! ", e);
		}
    	return null;
    }

	
	/**
     * Method to examine which file should be downloaded and to trigger the correct download
     * @param event the  event that calls the method and triggers the download
     * @throws AbortProcessingException
     */
    public void processAction(ActionEvent event) throws AbortProcessingException
    {
        // find the index of the the button the user has clicked
        HtmlCommandButton button = (HtmlCommandButton)(event.getSource());
        
        // then find the indexes of the item and the file the clicked button belongs to
        int indexFile = new Integer(button.getId().substring(13));
        try
        {
            this.downloadFile(indexFile);
        }
        catch (Exception e)
        {
            logger.debug("File Download Error: " + e.toString());
        }
    }
    
    /**
     * Prepares the file the user wants to download
     * @author Tobias Schraut
     * @throws IOException
     * @throws Exception
     */
    public void downloadFile(int filePosition) throws IOException, Exception
    {
        LoginHelper loginHelper = (LoginHelper)FacesContext.getCurrentInstance().getApplication().getVariableResolver().resolveVariable(FacesContext.getCurrentInstance(), "LoginHelper");

        // extract the location of the file
        String fileLocation = ServiceLocator.getFrameworkUrl() + this.getItemControllerSessionBean().getCurrentPubItem().getFiles().get(filePosition).getContent();
        String filename = this.getItemControllerSessionBean().getCurrentPubItem().getFiles().get(filePosition).getName(); // Filename suggested in browser Save As dialog
        filename = filename.replace(" ", "_"); // replace empty spaces because they cannot be procesed by the http-response (filename will be cutted after the first empty space)
        String contentType = this.getItemControllerSessionBean().getCurrentPubItem().getFiles().get(filePosition).getMimeType(); // For dialog, try
        
        // application/x-download
        FacesContext facesContext = FacesContext.getCurrentInstance();
        HttpServletResponse response = (HttpServletResponse)facesContext.getExternalContext().getResponse();
        response.setHeader("Content-disposition", "attachment; filename=" + URLEncoder.encode(filename, "UTF-8"));
        response.setContentLength(new Long(this.getItemControllerSessionBean().getCurrentPubItem().getFiles().get(filePosition).getSize()).intValue());
        response.setContentType(contentType);

        byte[] buffer = null;
        if (filePosition != -1)
        {
            try
            {
                GetMethod method = new GetMethod(fileLocation);
                method.setFollowRedirects(false);
                if (loginHelper.getESciDocUserHandle() != null)
                {
                    // downloading by account user
                    addHandleToMethod(method, loginHelper.getESciDocUserHandle());
                }
                
                // Execute the method with HttpClient.
                HttpClient client = new HttpClient();
                client.executeMethod(method);
                OutputStream out = response.getOutputStream();
                InputStream input = method.getResponseBodyAsStream();
                try
                {
                    buffer = new byte[new Long(this.getItemControllerSessionBean().getCurrentPubItem().getFiles().get(filePosition).getSize()).intValue()];
                    int numRead;
                    long numWritten = 0;
                    while ((numRead = input.read(buffer)) != -1) {
                        out.write(buffer, 0, numRead);
                        out.flush();
                        numWritten += numRead;
                    }
                    facesContext.responseComplete();
                }
                catch (IOException e1)
                {
                    logger.debug("Download IO Error: " + e1.toString());
                }
                input.close();
                out.close();
            }
            catch (FileNotFoundException e)
            {
                logger.debug("File not found: " + e.toString());
            }
        }
    }
    
    /**
     * Adds a cookie named "escidocCookie" that holds the eScidoc user handle to the provided http method object.
     * @author Tobias Schraut
     * @param method The http method to add the cookie to.
     */
    private void addHandleToMethod(final HttpMethod method, String eSciDocUserHandle)
    {
        // Staging file resource is protected, access needs authentication and
        // authorization. Therefore, the eSciDoc user handle must be provided.
        // Put the handle in the cookie "escidocCookie"
        method.setRequestHeader("Cookie", "escidocCookie=" + eSciDocUserHandle);
    }

    /**
     * Returns the ItemControllerSessionBean.
     * 
     * @return a reference to the scoped data bean (ItemControllerSessionBean)
     */
    protected ItemControllerSessionBean getItemControllerSessionBean()
    {
        ItemControllerSessionBean itemControllerSessionBean = (ItemControllerSessionBean)FacesContext.getCurrentInstance().getApplication().getVariableResolver()
        .resolveVariable(FacesContext.getCurrentInstance(), ItemControllerSessionBean.BEAN_NAME);
        return itemControllerSessionBean;
    }
    
    /**
     * Returns the CommonSessionBean.
     * 
     * @return a reference to the scoped data bean (CommonSessionBean)
     */
    protected CommonSessionBean getCommonSessionBean()
    {
    	CommonSessionBean commonSessionBean = (CommonSessionBean)FacesContext.getCurrentInstance().getApplication().getVariableResolver()
        .resolveVariable(FacesContext.getCurrentInstance(), CommonSessionBean.BEAN_NAME);
        return commonSessionBean;
    }
    
    
    
    /**
     * Returns the ApplicationBean.
     * 
     * @return a reference to the scoped data bean (ApplicationBean)
     */
    protected ApplicationBean getApplicationBean()
    {
        return (ApplicationBean) FacesContext.getCurrentInstance().getApplication().getVariableResolver().resolveVariable(FacesContext.getCurrentInstance(), ApplicationBean.BEAN_NAME);
        
    }
    
    public String getContentCategory()
    {
    	String contentCategory = "";
    	InternationalizedImpl internationalized = new InternationalizedImpl();
    	if(this.file.getContentType() != null)
    	{
    		contentCategory = internationalized.getLabel(this.i18nHelper.convertEnumToString(this.file.getContentType()));
    	}
    	return contentCategory;
    }
    
    public String getVisibility()
    {
    	String visibility = "";
    	InternationalizedImpl internationalized = new InternationalizedImpl();
    	if(this.file.getVisibility() != null)
    	{
    		visibility = internationalized.getLabel(this.i18nHelper.convertEnumToString(this.file.getVisibility()));
    	}
    	return visibility;
    }
    
    public boolean getItemWithdrawn()
    {
    	if(this.itemState.equals(State.WITHDRAWN))
    	{
    		return true;
    	}
    	else
    	{
    		return false;
    	}
    }
    
    public boolean getShowSearchHits()
    {
    	if(this.searchHits != null && this.searchHits.size() > 0)
    	{
    		return true;
    	}
    	else
    	{
    		return false;
    	}
    }

    public FileVO getFile() {
		return file;
	}

	public void setFile(FileVO file) {
		this.file = file;
	}

	public String getFileSize() {
		return this.getCommonSessionBean().computeFileSize(this.file.getSize());
	}

	public List<SearchHitBean> getSearchHits() {
		return searchHits;
	}

	public void setSearchHits(List<SearchHitBean> searchHits) {
		this.searchHits = searchHits;
	}
	
    
}