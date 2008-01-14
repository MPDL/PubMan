/*
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

package de.mpg.escidoc.services.util;

import java.io.IOException;
import javax.servlet.http.HttpServletResponse;
import javax.xml.rpc.ServiceException;
import org.apache.axis.encoding.Base64;
import org.apache.commons.httpclient.Header;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.methods.PostMethod;
import de.fiz.escidoc.om.ContextHandlerRemote;
import de.mpg.escidoc.services.framework.PropertyReader;
import de.mpg.escidoc.services.framework.ServiceLocator;

/**
 * Utility class to deal with the framework interfaces.
 *
 * @author franke (initial creation)
 * @author $Author: mfranke $ (last modification)
 * @version $Revision: 131 $ $LastChangedDate: 2007-11-21 18:53:43 +0100 (Wed, 21 Nov 2007) $
 *
 */
public class FrameworkUtil
{
    // Admin user handle
    private static String adminUserHandle = null;

    /**
     * Hidden constructor.
     */
    protected FrameworkUtil()
    {

    }

    /**
     * Retrieves all contexts visible to the logged in admin user.
     * @return An XML containing a list of the retrieved contexts.
     */
    public static String getAllContexts()
    {
        if (adminUserHandle == null)
        {
            loginAdminUser();
        }
        try
        {
            ContextHandlerRemote cHandler = ServiceLocator.getContextHandler(adminUserHandle);
            return cHandler.retrieveContexts("<param></param>");
        }
        catch (Exception e)
        {
            throw new RuntimeException("Error", e);
        }
    }

    /**
     * Login the admin user.
     */
    private static void loginAdminUser()
    {
        try
        {
            String adminLogin = PropertyReader.getProperty("framework.admin.username");
            String adminPasword = PropertyReader.getProperty("framework.admin.password");
            adminUserHandle = loginUser(adminLogin, adminPasword);
        }
        catch (Exception e)
        {
            throw new RuntimeException("Error", e);
        }
    }

    /**
     * Logs in the given user.
     *
     * @param userid
     * @param password
     * @return the user handle.
     * @throws HttpException
     * @throws IOException
     * @throws ServiceException
     */
    private static String loginUser(final String userid, final String password) throws IOException, ServiceException
    {
        // post the login data
        PostMethod postMethod = new PostMethod(ServiceLocator.getFrameworkUrl() + "/um/loginResults");
        postMethod.addParameter("survey", "LoginResults");
        postMethod.addParameter("target", "http://localhost:8888");
        postMethod.addParameter("login", userid);
        postMethod.addParameter("password", password);
        HttpClient client = new HttpClient();
        client.executeMethod(postMethod);
        if (HttpServletResponse.SC_SEE_OTHER != postMethod.getStatusCode())
        {
            throw new HttpException("Wrong status code: " + postMethod.getStatusCode());
        }
        // String response = postMethod.getResponseBodyAsString();
        String userHandle = null;
        Header[] headers = postMethod.getResponseHeaders();
        for (int i = 0; i < headers.length; ++i)
        {
            if ("Location".equals(headers[i].getName()))
            {
                String location = headers[i].getValue();
                int index = location.indexOf('=');
                userHandle = new String(Base64.decode(location.substring(index + 1, location.length())));
            }
        }
        if (userHandle == null)
        {
            throw new ServiceException("User not logged in.");
        }
        return userHandle;
    }
}
