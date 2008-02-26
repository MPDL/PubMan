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

package de.mpg.escidoc.pubman.collectionList;

import java.util.ArrayList;
import java.util.List;
import org.apache.log4j.Logger;
import de.mpg.escidoc.pubman.appbase.FacesBean;
import de.mpg.escidoc.pubman.ItemControllerSessionBean;
import de.mpg.escidoc.pubman.collectionList.ui.CollectionListUI;
import de.mpg.escidoc.pubman.util.CommonUtils;
import de.mpg.escidoc.pubman.util.PubCollectionVOPresentation;
import de.mpg.escidoc.services.common.referenceobjects.PubCollectionRO;
import de.mpg.escidoc.services.common.valueobjects.PubCollectionVO;

/**
 * Keeps all attributes that are used for the whole session by the CollectionList.
 * @author:  Thomas Diebäcker, created 12.10.2007
 * @version: $Revision: 1587 $ $LastChangedDate: 2007-11-20 10:54:36 +0100 (Di, 20 Nov 2007) $
 */
public class CollectionListSessionBean extends FacesBean
{
    public static final String BEAN_NAME = "CollectionListSessionBean";
    private static Logger logger = Logger.getLogger(CollectionListSessionBean.class);

    private List<PubCollectionVOPresentation> collectionList = new ArrayList<PubCollectionVOPresentation>();
    private CollectionListUI collectionListUI = null;

    /**
     * Public constructor.
     */
    public CollectionListSessionBean()
    {
        this.collectionList = this.retrieveCollections();
    }

    /**
     * Retrieves all collections for the current user.
     * @return the list of PubCollectionVOs
     */
    private List<PubCollectionVOPresentation> retrieveCollections()
    {
        List<PubCollectionVOPresentation> allCollections = new ArrayList<PubCollectionVOPresentation>();
        
        try
        {
            allCollections = CommonUtils.convertToPubCollectionVOPresentationList(this.getItemControllerSessionBean().retrieveCollections()); 
        }
        catch (Exception e)
        {
            logger.error("Could not create collection list." + "\n" + e.toString());

            allCollections.addAll(this.getDummyCollections(3));            
            
            logger.warn("Continuing with Dummy-Collections.");
        }

        return allCollections;
    }

    private List<PubCollectionVOPresentation> getDummyCollections(int numberofDummies)
    {
        List<PubCollectionVOPresentation> dummyCollections = new ArrayList<PubCollectionVOPresentation>();

        for (int i = 0; i < numberofDummies; i++)
        {
            dummyCollections.add(this.createDummyCollection(i + 1));
        }
        
        return dummyCollections;
    }
    
    private PubCollectionVOPresentation createDummyCollection(int number)
    {
        PubCollectionVOPresentation vo = new PubCollectionVOPresentation(new PubCollectionVO());
        vo.setName("TestCollection " + number + ". DO NOT TRY TO CREATE ITEMS WITH THIS!");
        vo.setDescription("This is the description of the collection No. " + number + ".");
        PubCollectionRO ro = new PubCollectionRO();
        ro.setObjectId("escidoc:dummyCollection" + number);
        vo.setReference(ro);
        
        return vo;
    }
    
    /**
     * Returns a reference to the scoped data bean (the ItemControllerSessionBean). 
     * @return a reference to the scoped data bean
     */
    protected ItemControllerSessionBean getItemControllerSessionBean()
    {
        return (ItemControllerSessionBean)getBean(ItemControllerSessionBean.class);
    }

    public List<PubCollectionVOPresentation> getCollectionList()
    {
        return collectionList;
    }

    public void setCollectionList(List<PubCollectionVOPresentation> collectionList)
    {
        this.collectionList = collectionList;
    }

    public CollectionListUI getCollectionListUI()
    {
        return collectionListUI;
    }

    public void setCollectionListUI(CollectionListUI collectionListUI)
    {
        this.collectionListUI = collectionListUI;
    }
}
