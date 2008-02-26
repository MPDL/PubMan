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
package de.mpg.escidoc.pubman.breadcrumb;

import java.util.List;

import javax.faces.component.html.HtmlPanelGroup;
import javax.faces.context.FacesContext;

import org.apache.log4j.Logger;

import de.mpg.escidoc.pubman.appbase.FacesBean;

import de.mpg.escidoc.pubman.breadcrumb.ui.BreadcrumbUI;

/**
 * Class for creating bread crumb links acording to the requested page.
 *
 * @author: Tobias Schraut, created 30.05.2007
 * @version: $Revision: 1627 $ $LastChangedDate: 2007-11-28 15:05:47 +0100 (Mi, 28 Nov 2007) $ Revised by ScT:
 *           16.08.2007
 */
public class BreadcrumbNavigation extends FacesBean
{
    public static final String BEAN_NAME = "BreadcrumbNavigation";
    private BreadcrumbItemHistorySessionBean breadcrumbItemHistorySessionBean
        = (BreadcrumbItemHistorySessionBean) getSessionBean(BreadcrumbItemHistorySessionBean.class);
    private HtmlPanelGroup panBreadcrumbList = new HtmlPanelGroup();
    private static Logger logger = Logger.getLogger(BreadcrumbNavigation.class);

    /**
     * Public constructor.
     */
    public BreadcrumbNavigation()
    {
        this.init();
    }

    /**
     * Callback method that is called whenever a page is navigated to, either directly via a URL, or indirectly via page
     * navigation.
     */
    public void init()
    {
        // Perform initializations inherited from the superclass
        super.init();
 
    }
}
