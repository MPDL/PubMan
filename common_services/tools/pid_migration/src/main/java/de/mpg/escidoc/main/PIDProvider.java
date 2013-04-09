package de.mpg.escidoc.main;

import java.io.IOException;

import javax.naming.NamingException;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.UsernamePasswordCredentials;
import org.apache.commons.httpclient.auth.AuthScope;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.log4j.Logger;

import de.mpg.escidoc.util.Util;

public class PIDProvider
{
    private static Logger logger = Logger.getLogger(PIDProvider.class);   
    
    private static String location;
    private static String user;
    private static String password;
    
    private static HttpClient httpClient;
    
    void init() throws NamingException
    {
        logger.debug("init starting");
        
        location = Util.getProperty("escidoc.pid.pidcache.service.url");
        user = Util.getProperty("escidoc.pidcache.user.name");
        password = Util.getProperty("escidoc.pidcache.user.password");
        httpClient = Util.getHttpClient();
        
        logger.debug("init finished");
    }
    
    public String getPid() throws HttpException, IOException
    {
        logger.debug("getPid starting");
        
        int code;
        String url = location + "/write/create";
        
        PostMethod method = new PostMethod(url);
        method.setParameter("url", url);
        method.setDoAuthentication(true);
        httpClient.getState().setCredentials(new AuthScope("localhost", 8080),
                new UsernamePasswordCredentials(user, password));
        code = httpClient.executeMethod(method);
        
        String pid = Util.getValueFromXml("<pid>", '<', method.getResponseBodyAsString());
        
        logger.debug("getPid finished returning " + pid);
        return pid;
    }
}
