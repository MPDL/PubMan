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
* or http://www.escidoc.org/license.
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
* Copyright 2006-2012 Fachinformationszentrum Karlsruhe Gesellschaft
* für wissenschaftlich-technische Information mbH and Max-Planck-
* Gesellschaft zur Förderung der Wissenschaft e.V.
* All rights reserved. Use is subject to license terms.
*/


package de.mpg.escidoc.services.common.valueobjects;

import java.util.HashMap;
import java.util.Map;

/**
 * Valueobject representing the export file format data needed for the export.
 *
 * @version $Revision$ $LastChangedDate$ by $Author$
 */

@SuppressWarnings("serial")
public class FileFormatVO extends ValueObject
{

    /**
     * Fixed serialVersionUID to prevent java.io.InvalidClassExceptions like
     * 'de.mpg.escidoc.services.common.valueobjects.ItemVO; local class incompatible: stream classdesc
     * serialVersionUID = 8587635524303981401, local class serialVersionUID = -2285753348501257286' that occur after
     * JiBX enhancement of VOs. Without the fixed serialVersionUID, the VOs have to be compiled twice for testing (once
     * for the Application Server, once for the local test).
     *
     * @author Johannes Mueller
     */
   

    public static final String TEXT_NAME = "txt";
    public static final String TEXT_MIMETYPE = "text/plain";
    
    public static final String PDF_NAME = "pdf";
    public static final String PDF_MIMETYPE = "application/pdf";
    
    public static final String RTF_NAME = "rtf";
    public static final String RTF_MIMETYPE = "application/rtf";
    
    public static final String HTML_PLAIN_NAME = "html_plain";
    public static final String HTML_PLAIN_MIMETYPE = "text/html";
    
    public static final String HTML_LINKED_NAME = "html_linked";
    public static final String HTML_LINKED_MIMETYPE = "text/html";
    
    public static final String HTML_STYLED_NAME = "html_styled";
    public static final String HTML_STYLED_MIMETYPE = "text/html";
    
    public static final String ODT_NAME = "odt";
    public static final String ODT_MIMETYPE = "application/vnd.oasis.opendocument.text";
    
    public static final String SNIPPET_NAME = "snippet";
    public static final String SNIPPET_MIMETYPE = "application/xml";
    
    public static final String ESCIDOC_SNIPPET_NAME = "escidoc_snippet";
    public static final String ESCIDOC_SNIPPET_MIMETYPE = "application/xml";
    
    public static final String XML_NAME = "xml";
    public static final String XML_MIMETYPE = "application/xml";
    
    public static final String ESCIDOC_XML_NAME = "escidoc_xml";
    public static final String ESCIDOC_XML_MIMETYPE = "application/xml";
    
    public static final String ESCIDOC_XML_V13_NAME = "escidoc_xml_v13";
    public static final String ESCIDOC_XML_V13_MIMETYPE = "application/xml";
    
    public static final String EDOC_IMPORT_NAME = "edoc_import";
    public static final String EDOC_IMPORT_MIMETYPE = "application/xml";
    
    public static final String EDOC_EXPORT_NAME = "edoc_export";
    public static final String EDOC_EXPORT_MIMETYPE = "application/xml";
    
    public static final String DOCX_NAME = "docx";
    public static final String DOCX_MIMETYPE = "application/vnd.openxmlformats-officedocument.wordprocessingml.document";

    public static final String DEFAULT_NAME = PDF_NAME;
    public static final String DEFAULT_MIMETYPE = PDF_MIMETYPE;
    
    public static final String DEFAULT_CHARSET = "utf-8";
    
    private static final Map<String, String> formatExtensions =   
    	new HashMap<String, String>()   
    	{  
			{  
                put(TEXT_NAME, "txt");
                put(PDF_NAME, "pdf");
                put(RTF_NAME, "rtf");
                put(HTML_PLAIN_NAME, "html");
                put(HTML_LINKED_NAME, "html");
                put(HTML_STYLED_NAME, "html");
                put(ODT_NAME, "odt");
                put(SNIPPET_NAME, "xml");
                put(ESCIDOC_SNIPPET_NAME, "xml");
                put(XML_NAME, "xml");
                put(ESCIDOC_XML_NAME, "xml");
                put(ESCIDOC_XML_V13_NAME, "xml");
                put(EDOC_IMPORT_NAME, "xml");
                put(EDOC_EXPORT_NAME, "xml");
                put(DEFAULT_NAME, "pdf");
                put(DOCX_NAME, "docx");
	    	}  
    	};
	private static final Map<String, String> formatMimeTypes =   
		new HashMap<String, String>()   
		{  
    		{  
    			put(TEXT_NAME, TEXT_MIMETYPE);
    			put(PDF_NAME, PDF_MIMETYPE);
    			put(RTF_NAME, RTF_MIMETYPE);
    			put(HTML_PLAIN_NAME, HTML_PLAIN_MIMETYPE);
    			put(HTML_LINKED_NAME, HTML_LINKED_MIMETYPE);
    			put(HTML_STYLED_NAME, HTML_STYLED_MIMETYPE);
    			put(ODT_NAME, ODT_MIMETYPE);
    			put(SNIPPET_NAME, SNIPPET_MIMETYPE);
    			put(ESCIDOC_SNIPPET_NAME, ESCIDOC_SNIPPET_MIMETYPE);
    			put(XML_NAME, XML_MIMETYPE);
    			put(ESCIDOC_XML_NAME, ESCIDOC_XML_MIMETYPE);
    			put(ESCIDOC_XML_V13_NAME, ESCIDOC_XML_MIMETYPE);
                put(EDOC_IMPORT_NAME, EDOC_IMPORT_MIMETYPE);
                put(EDOC_EXPORT_NAME, EDOC_EXPORT_MIMETYPE);
    			put(DEFAULT_NAME, DEFAULT_MIMETYPE);
    			put(DOCX_NAME, DOCX_MIMETYPE);
    		}  
		};
	private static final Map<String, String> formatCharsets =   
		new HashMap<String, String>()   
		{  
			{  
				put(TEXT_NAME, DEFAULT_CHARSET);
				put(HTML_PLAIN_NAME, DEFAULT_CHARSET);
				put(HTML_LINKED_NAME, DEFAULT_CHARSET);
				put(HTML_STYLED_NAME, DEFAULT_CHARSET);
				put(SNIPPET_NAME, DEFAULT_CHARSET);
				put(ESCIDOC_SNIPPET_NAME, DEFAULT_CHARSET);
				put(XML_NAME, DEFAULT_CHARSET);
				put(ESCIDOC_XML_NAME, DEFAULT_CHARSET);
				put(ESCIDOC_XML_V13_NAME, DEFAULT_CHARSET);
				put(EDOC_IMPORT_NAME, DEFAULT_CHARSET);
				put(EDOC_EXPORT_NAME, DEFAULT_CHARSET);
			}  
		};
    
    
    
    /**
     * The mime type of FileFormat
     */
    private String mimeType;
    
    /**
     * The name of FileFormat
     */
    private String name;

    /**
     * Delivers the name of the selected file according to name of format.
     */
    public static String getMimeTypeByName(String name)
    {
        name = name == null || name.trim().equals("") ? "" : name.trim();  
        // if name is not in scope of file format, set it to FileFormatVO.PDF_MIMETYPE
        // by default
        return formatMimeTypes.containsKey(name) ? formatMimeTypes.get(name) : formatMimeTypes.get(DEFAULT_NAME);   
    }
    
    /**
     * Delivers the name of the selected file according to name of format.
     */
    public static String getExtensionByName(String name)
    {
    	name = name == null || name.trim().equals("") ? "" : name.trim();  
    	return formatExtensions.containsKey(name) ? formatExtensions.get(name) : formatExtensions.get(DEFAULT_NAME);   
    }
    
    /**
     * Delivers the charset of the selected file according to name of format.
     */
    public static String getCharsetByName(String name)
    {
    	name = name == null || name.trim().equals("") ? "" : name.trim();  
    	return formatCharsets.containsKey(name) ? formatCharsets.get(name) : null;   
    }

    // workaround to find out whether the output format is presented  
    //TODO: should be taken directly from xml description of the export 
    //rather then hardcoded in FileFormatVO class    
    public static boolean isOutputFormatSupported(String outputFormat)
    {
        return !(
                getMimeTypeByName(outputFormat).equals(DEFAULT_MIMETYPE) 
                && !outputFormat.equals(DEFAULT_NAME)
                ); 
    }

    /**
     * get mimeType
     */
    public String getMimeType()
    {
        return mimeType;
    }

    /**
     * set mimeType
     */
    public void setMimeType(String mimeType)
    {
        this.mimeType = mimeType;
    }

    /**
     * get name of the file format
     */
    public String getName()
    {
        return name;
    }

    /**
     * set name of the file format
     */
    public void setName(String name)
    {
        this.name = name;
    }

}
