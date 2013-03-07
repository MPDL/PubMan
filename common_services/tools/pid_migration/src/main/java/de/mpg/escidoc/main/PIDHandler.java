package de.mpg.escidoc.main;

import java.io.IOException;

import org.apache.commons.httpclient.HttpException;
import org.apache.log4j.Logger;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;

public class PIDHandler extends IdentityHandler
{
    private static Logger logger = Logger.getLogger(PIDHandler.class);

    private PreHandler preHandler;
    private PIDMigrationManager pidMigrationManager;
    
    private boolean inLastRelsExt = false;
    private boolean inObjectPid = false;
    private boolean inVersionPid = false;
    private boolean inReleasePid = false;
    
    public PIDHandler(PreHandler preHandler)
    {
        this.preHandler = preHandler;
    }
    
    public void setPIDMigrationManager(PIDMigrationManager mgr)
    {
        this.pidMigrationManager = mgr;
    }

    @Override
    public void startElement(String uri, String localName, String name, Attributes attributes) throws SAXException
    {
        logger.debug("startElement uri=<" + uri + "> localName = <" + localName + "> name = <" + name + "> attributes = <" + attributes + ">");
        
        super.startElement(uri, localName, name, attributes);
        
        if ("foxml:datastreamVersion".equals(name) && preHandler.getLastCreatedRelsExtId() != null 
                && preHandler.getLastCreatedRelsExtId().equals(attributes.getValue("ID")))
        {
            inLastRelsExt = true;
        }
        else if (inLastRelsExt && "prop:pid".equals(name))
        {
            inObjectPid = true;
        }
        else if (inLastRelsExt && "version:pid".equals(name))
        {
            inVersionPid = true;
        }
        else if (inLastRelsExt && "release:pid".equals(name))
        {
            inReleasePid = true;
        }
    }

    @Override
    public void content(String uri, String localName, String name, String content) throws SAXException
    {
        logger.debug("content      uri=<" + uri + "> localName = <" + localName + "> name = <" + name + "> content = <" + content + ">");
        
        // fallback if pidcache isn't reachable
        String oldContent = content;
        
        if (inObjectPid || inVersionPid || inReleasePid)
        {
            try
            {
                content = pidMigrationManager.getPid();
            }
            catch (HttpException e)
            {
                logger.warn("Error getting PID", e);
            }
            catch (IOException e)
            {
                logger.warn("Error getting PID", e);
            }
            finally
            {
                content = oldContent;
            }
        }
        
        if (inObjectPid)
        {       
            logger.debug("content setting PID " + content);
          
            inObjectPid = false;
        }
        else if (inVersionPid)
        {
            logger.debug("content setting versionPID " + content);
          
            inVersionPid = false;
            
        }
        else if (inReleasePid)
        {
            logger.debug("content setting releasePID " + content);
          
            inReleasePid = false;
            
        }
        super.content(uri, localName, name, content );
    }
    
    @Override
    public void endElement(String uri, String localName, String name) throws SAXException
    {
        logger.debug("endElement   uri=<" + uri + "> localName = <" + localName + "> name = <" + name + "> ");
        if ("foxml:datastreamVersion".equals(name))
        {
            inLastRelsExt = false;
        } 
        
        super.endElement(uri, localName, name);
    }

}
