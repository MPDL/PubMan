/*
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

package de.mpg.escidoc.services.structuredexportmanager;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Source;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.URIResolver;
import javax.xml.transform.stream.StreamSource;

import net.sf.saxon.TransformerFactoryImpl;

import org.apache.log4j.Logger;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

import de.mpg.escidoc.services.common.util.LocalURIResolver;
import de.mpg.escidoc.services.common.util.ResourceUtil;
import de.mpg.escidoc.services.framework.PropertyReader;

/**
 * Structured Export Manager. 
 * Converts PubMan item-list to one of the structured formats.   
 *
 * @author Vlad Makarenko (initial creation)
 * @author $Author$ (last modification)
 * @version $Revision$ $LastChangedDate$
 *
 */ 

public class StructuredExport implements StructuredExportHandler {


	private final static Logger logger = Logger.getLogger(StructuredExport.class);
	
	private final static String PATH_TO_RESOURCES = "";
	private final static String PATH_TO_SCHEMAS = PATH_TO_RESOURCES + "schemas/";
	private final static String EXPLAIN_FILE = "explain-structured-formats.xml";
    private static final Map<String, String> XSLT_FILE_LIST =   
    	new HashMap<String, String>()   
    	{  
			{
			put( "MARCXML",		"pubman_to_marc.xsl"	);  	
	    		put( "ENDNOTE",		"eSciDoc_to_EndNote.xsl"	);  
	    		put( "BIBTEX", 		"eSciDoc_to_BibTeX.xsl"			);  
	    		put( "CSV", 		"Faces_to_CSV.xsl"				);  
	    		put( "XML", 		"escidoc-publication-v2_2_escidoc-publication-v1.xsl"				);  
	    		put( "EDOC_EXPORT", "escidoc2edoc_export.xsl" );  
	    		put( "EDOC_IMPORT", "escidoc2edoc_import.xsl" );  
	    		put( "ESCIDOC_XML", "escidoc-xml-v13-to-v12.xsl");
	    		put( "ESCIDOC_XML_V13", null);
	    	}  
    	};	
	public StructuredExport()
	{
//		 Use Saxon for XPath2.0 support
        //System.setProperty("javax.xml.transform.TransformerFactory", "net.sf.saxon.TransformerFactoryImpl");
	}
	


	/* (
	 * Takes PubMan item-list and converts it to specified exportFormat. Uses XSLT.   
	 * @see de.mpg.escidoc.services.endnotemanager.StructuredExportHandler#getOutputString(java.lang.String, java.lang.String)
	 */
	
	public byte[] getOutput(String itemList, String exportFormat)
			throws StructuredExportXSLTNotFoundException,
			StructuredExportManagerException 
	{
			// check itemList
			if (itemList == null) 
				throw new StructuredExportManagerException("Item list is null");
			
			//check format
			HashMap<String, String> fh = getFormatsHash();
			if ( !fh.containsKey(exportFormat) ) 
				throw new StructuredExportManagerException("Format: " + exportFormat + " is not supported");
			
			//return itemList XML in case of XML export
			/*if ( "XML".equals(exportFormat) )
			{
		    	 
		    	 TransformationBean trans = new TransformationBean(true);
		    	 
		    	 byte[] v1 = null;
		    	 try 
		    	 {
					v1 = trans.transform(itemList.getBytes("UTF-8"), 
							new Format("escidoc-publication-item-list-v2", "application/xml", "UTF-8"), 
							new Format("escidoc-publication-item-list-v1", "application/xml", "UTF-8"), 
							"escidoc"
					);
		    	 }
		    	 catch (Exception e) 
		    	 {
		    		 throw new StructuredExportManagerException("Problems by escidoc v2 to v1 transformation:", e);	
		    	 } 				
				return v1;
			}
			else */if ( "ESCIDOC_XML_V13".equalsIgnoreCase(exportFormat) )
			{
				return itemList.getBytes();
			}/*
			else if ("EDOC_EXPORT".equalsIgnoreCase(exportFormat) || "EDOC_IMPORT".equalsIgnoreCase(exportFormat))
			{
				TransformationBean trans = new TransformationBean(true);
				byte[] edoc = null;
		    	 try 
		    	 {
		    		 edoc = trans.transform(itemList.getBytes("UTF-8"), 
							new Format("escidoc", "application/xml", "UTF-8"), 
							new Format(exportFormat.toLowerCase(), "application/xml", "UTF-8"), 
							"escidoc"
					);
		    	 }
		    	 catch (Exception e) 
		    	 {
		    		 throw new StructuredExportManagerException("Problems by transformation: escidoc publication items to " + exportFormat.toLowerCase() + " format: ", e);	
		    	 } 				
				return edoc;				
			}*/
			
			// xml source
			javax.xml.transform.Source xmlSource =
				new javax.xml.transform.stream.StreamSource(new StringReader(itemList));
			
			// result
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
//			StringWriter sw = new StringWriter();
			javax.xml.transform.Result result =
//				new javax.xml.transform.stream.StreamResult(sw);
			new javax.xml.transform.stream.StreamResult(baos);

			// create an instance of TransformerFactory
			javax.xml.transform.TransformerFactory transFact =
				javax.xml.transform.TransformerFactory.newInstance("net.sf.saxon.TransformerFactoryImpl", null);

			//set URIResolver for xsl:include or xsl:import
			transFact.setURIResolver(
					new URIResolver() {
						public Source resolve(String href, String base)
								throws TransformerException	{
//							logger.info("href: " + href);
//							logger.info("base: " + base);
							if( href != null && href.toLowerCase().startsWith( "http://" ) )
				        	{	
				        		return new StreamSource(href + base);
				        	}
							else
							{
								InputStream is;
								try {
									is = ResourceUtil.getResourceAsStream(PATH_TO_SCHEMAS + href, StructuredExport.class.getClassLoader());
								} catch (IOException e) {
									throw new TransformerException(e);
								}
								return new StreamSource(is);
							}
						}
					}
			);
			
			String xsltFileName;
			try 
			{
				
				
				xsltFileName = PATH_TO_SCHEMAS + fh.get(exportFormat);
				// xslt source
				javax.xml.transform.Source xsltSource =
					new javax.xml.transform.stream.StreamSource(
							ResourceUtil.getResourceAsStream(xsltFileName, StructuredExport.class.getClassLoader())
				);
					
				
				 javax.xml.transform.Transformer trans = 
					 transFact.newTransformer(xsltSource);
					
				logger.debug("Transformer:" + trans);
				 
				trans.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
				
				// URLs to the pubman_instance and to the coreservice_instance 
				// defined as parameters to be able to test the EDOC_* exports in different instances
				// see http://jira.mpdl.mpg.de/browse/PUBMAN-1867
				trans.setParameter("pubman_instance", PropertyReader.getProperty("escidoc.pubman.instance.url"));
				trans.setParameter("pubman_instance_context_path", PropertyReader.getProperty("escidoc.pubman.instance.context.path"));
				trans.setParameter("coreservice_instance", PropertyReader.getProperty("escidoc.framework_access.framework.url"));
				
				
//				logger.info("ENCODING:" + trans.getOutputProperty(OutputKeys.ENCODING)) ;
				
				trans.transform(xmlSource, result);
				
//				return sw.toString().getBytes();
				return baos.toByteArray();
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				throw new StructuredExportXSLTNotFoundException("File not found:" + e);
			} catch (TransformerConfigurationException e) {
				// TODO Auto-generated catch block
				throw new StructuredExportManagerException(e);
			} catch (TransformerException e) {
				// TODO Auto-generated catch block
				throw new StructuredExportManagerException(e);
			} catch (URISyntaxException e) {
				throw new StructuredExportManagerException("Problems by setParameters:", e);
			}
	}	


	/* (non-Javadoc)
	 * @see de.mpg.escidoc.services.exportmanager.StructuredExportHandler#explainFormats()
	 */
	public String explainFormats() throws StructuredExportManagerException 
	{
        BufferedReader br;
		try {
	        TransformerFactory factory = new TransformerFactoryImpl();
	        factory.setURIResolver(new LocalURIResolver(PATH_TO_RESOURCES + EXPLAIN_FILE));
			br = new BufferedReader(new InputStreamReader(ResourceUtil.getResourceAsStream(PATH_TO_RESOURCES + EXPLAIN_FILE, StructuredExport.class.getClassLoader()), "UTF-8"));
		} catch (Exception e) {
			throw new StructuredExportManagerException(e); 
		}
        String line = null;
        String result = "";
        try {
			while ((line = br.readLine()) != null)
			{
			    result += line + "\n";
			}
		} catch (IOException e) {
			throw new StructuredExportManagerException(e); 
		}
        return result;
	}


	/* (non-Javadoc)
	 * @see de.mpg.escidoc.services.exportmanager.StructuredExportHandler#getFormatsList()
	 */
	public String[] getFormatsList() throws StructuredExportManagerException
	{
		Set<String> s = getFormatsHash().keySet(); 
		String[] fl = new String[ s.size() ];
		fl = (String[]) s.toArray( fl );
		return fl;
	}
	 
	
	/* (non-Javadoc)
	 * @see de.mpg.escidoc.services.structuredexportmanager.StructuredExportHandler#isStructuredFormat(java.lang.String)
	 */
	public boolean isStructuredFormat(String exportFormat)
	throws StructuredExportManagerException 
	{
		if ( exportFormat == null || exportFormat.trim().equals("") )
		{
			throw new StructuredExportManagerException("Empty export format");
		}
		return getFormatsHash().containsKey(exportFormat);
	}	

	
	
	/**
	 * Generates HashMap of export formats where key is export format id
	 * and value is the name of XSLT file of the export implementation 
	 * @return 
	 * @throws StructuredExportManagerException
	 */
	public HashMap<String, String> getFormatsHash() throws StructuredExportManagerException
	{
		Document doc;
		try {
			doc = createDocumentBuilder().parse(
						new InputSource(new StringReader(explainFormats()))
			);
		} catch (Exception e) {
			throw new StructuredExportManagerException(e); 
		}		
		Element root = doc.getDocumentElement( );
		
		//get all export-format elements
		NodeList formatElements = root.getElementsByTagName("export-format");
		
		HashMap<String, String> fh = new HashMap<String, String>();
		
		for (int i = 0; i < formatElements.getLength( ); i++)
		{ 
			Element n = (Element)formatElements.item(i);
			String id = n.getElementsByTagName("dc:identifier").item(0).getTextContent(); 
			//populate key/value pars
//			logger.info("ID: " + id);
//			logger.info("FILE: " + XSLT_FILE_LIST.get(id));
			fh.put(
					id, 
					XSLT_FILE_LIST.get(id)
			);
		}
		
		return fh;
	}
	
	
    /**
     * Builds new DocumentBuilder
     * @return DocumentBuilder
     * @throws ParserConfigurationException 
     */
    public static DocumentBuilder createDocumentBuilder() throws ParserConfigurationException  
    {
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        dbf.setValidating(false);
        dbf.setIgnoringComments(true);
        dbf.setNamespaceAware(true);

        return dbf.newDocumentBuilder();
    }



}	