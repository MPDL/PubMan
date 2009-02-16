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

package de.mpg.escidoc.services.cone.util;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.log4j.Logger;

import de.mpg.escidoc.services.cone.ModelList;
import de.mpg.escidoc.services.cone.ModelList.Model;
import de.mpg.escidoc.services.framework.PropertyReader;

/**
 * Helper class for result pattern.
 *
 * @author franke (initial creation)
 * @author $Author$ (last modification)
 * @version $Revision$ $LastChangedDate$
 *
 */
public class PatternHelper
{
    
    private static final Logger logger = Logger.getLogger(PatternHelper.class);
    
    private static final String REGEX_BRACKETS = "<[^>]+>";
    
    /**
     * Hide constructor.
     */
    private PatternHelper()
    {
        
    }
    
    /**
     * Reads the result pattern from the {@link Model} and builds up results.
     * 
     * @param modelName A string representing the model.
     * @param currentSubject The identifier of the resource.
     * @param poMap The data.
     * @return A list of {@link Pair} containing the results in different languages.
     * @throws Exception Any exception.
     */
    public static List<Pair> buildObjectFromPattern(String modelName, String currentSubject, TreeFragment poMap) throws Exception
    {
     
        Set<String> languages = new HashSet<String>();
        if (ModelList.getInstance().getModelByAlias(modelName).isLocalizedResultPattern())
        {
            for (List<LocalizedTripleObject> objects : poMap.values())
            {
                for (LocalizedTripleObject object : objects)
                {
                    if (object.getLanguage() == null)
                    {
                        languages.add("");
                    }
                    else
                    {
                        languages.add(object.getLanguage());
                    }
                }
            }
        }
        if (ModelList.getInstance().getModelByAlias(modelName).isGlobalResultPattern())
        {
            languages.add("");
        }
        
        List<Pair> results = new ArrayList<Pair>();
        
        for (String pattern : ModelList.getInstance().getModelByAlias(modelName).getResultPattern())
        {
            String[] patternPieces = pattern.split("\\n");
            
            if (languages.size() == 0)
            {
                List<String> result = new ArrayList<String>();
                result.add("");
                
                for (String line : patternPieces)
                {
                    List<String> strings = new ArrayList<String>();
                    strings.add(line);
                    
                    for (String predicate : poMap.keySet())
                    {
                        List<String> newStrings = new ArrayList<String>();
                        
                        for (String string : strings)
                        {
                            List<String> rep = replacePattern(poMap, string, predicate, "");
                            newStrings.addAll(rep);
                        }
                        if (newStrings.size() > 0)
                        {
                            strings = newStrings;
                        }
                    }
                    
                    List<String> newResult = new ArrayList<String>();
                    for (String string : strings)
                    {
                        String singleString = string;
                        singleString = singleString.replaceAll(REGEX_BRACKETS, "");
                        String newString = null;
                        while (!singleString.equals(newString))
                        {
                            newString = singleString;
                            singleString = replaceTokens(singleString);
                        }
                        if (singleString.startsWith(":"))
                        {
                            singleString = "";
                        }
                        else if (singleString.contains(":"))
                        {
                            singleString = singleString.substring(singleString.indexOf(":") + 1);
                        }
                        newResult.add(singleString);
                    }
                    strings = newResult;
                    
                    newResult = new ArrayList<String>();
                    for (String oldResult : result)
                    {
                        for (String string : strings)
                        {
                            newResult.add(oldResult + string);
                        }
                    }
                    result = newResult;

                }
                for (String string : result)
                {
                    results.add(new Pair(null, string));
                }
                
            }
            else
            {
                for (String lang : languages)
                {
                    List<String> result = new ArrayList<String>();
                    result.add("");
                    
                    for (String line : patternPieces)
                    {
                        List<String> strings = new ArrayList<String>();
                        strings.add(line);
                        
                        for (String predicate : poMap.keySet())
                        {
                            List<String> newStrings = new ArrayList<String>();
                            
                            for (String string : strings)
                            {
                                List<String> rep = replacePattern(poMap, string, predicate, lang);
                                newStrings.addAll(rep);
                            }
                            if (newStrings.size() > 0)
                            {
                                strings = newStrings;
                            }
                        }
                        List<String> newResult = new ArrayList<String>();
                        for (String string : strings)
                        {
                            String singleString = string;
                            singleString = singleString.replaceAll(REGEX_BRACKETS, "");
                            String newString = null;
                            while (!singleString.equals(newString))
                            {
                                newString = singleString;
                                singleString = replaceTokens(singleString);
                            }
                            if (singleString.startsWith(":"))
                            {
                                singleString = "";
                            }
                            else if (singleString.contains(":"))
                            {
                                singleString = singleString.substring(singleString.indexOf(":") + 1);
                            }
                            newResult.add(singleString);
                        }
                        strings = newResult;
                        
                        newResult = new ArrayList<String>();

                        for (String oldResult : result)
                        {
                            for (String string : strings)
                            {
                                newResult.add(oldResult + string);
                            }
                        }
                        result = newResult;
                    }
                    if (!"".equals(lang))
                    {
                        for (String string : result)
                        {
                            if (!"".equals(string))
                            {
                                results.add(new Pair(lang, string));
                            }
                        }
                    }
                    else
                    {
                        for (String string : result)
                        {
                            if (!"".equals(string))
                            {
                                results.add(new Pair(null, string));
                            }
                        }
                    }
                }
            }
        }
        return results;
    }

    /**
     * @param poMap
     * @param line
     * @param strings
     * @param predicate
     * @return
     */
    private static List<String> replacePattern(TreeFragment poMap, String line, String predicate, String lang)
    {
        List<String> strings = new ArrayList<String>();
        if (line.contains("<" + predicate + ">"))
        {
            for (LocalizedTripleObject value : poMap.get(predicate))
            {
                try
                {
                    if (lang.equals(value.getLanguage()) || "".equals(value.getLanguage()) || ("".equals(lang) && value.getLanguage().equals(PropertyReader.getProperty("escidoc.cone.language.default"))))
                    {
                        strings.add(line.replace("<" + predicate + ">", value.toString()));
                    }
                }
                catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }
        }
        else if (line.contains("<" + predicate + "|"))
        {
            for (LocalizedTripleObject value : poMap.get(predicate))
            {
                try
                {
                    if (value instanceof TreeFragment && lang.equals(value.getLanguage()) || "".equals(value.getLanguage()) || ("".equals(lang) && value.getLanguage().equals(PropertyReader.getProperty("escidoc.cone.language.default"))))
                    {
                        TreeFragment treeValue = (TreeFragment) value;
                        for (String subPredicate : treeValue.keySet())
                        {
                            strings.addAll(replacePattern(treeValue, line.replace("<" + predicate + "|", "<"), subPredicate, lang));
                        }
                    }
                }
                catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }
        }
        return strings;
    }

    /**
     * @param string
     * @return
     */
    private static String replaceTokens(String string)
    {
        string = string.replaceAll("AND\\{[^,\\}]+(,[^,\\}]+)*\\}", "a");
        string = string.replaceAll("AND\\{,[^\\}]*\\}|AND\\{[^\\}]*,\\}|AND\\{[^\\}]*,,[^\\}]*\\}", "");
        string = string.replaceAll("OR\\{[^\\}]*[^,\\}]+[^\\}]*\\}", "o");
        string = string.replaceAll("OR\\{,*\\}", "");
        string = string.replace("NOT\\{\\}", "n");
        string = string.replace("NOT\\{[^}]+\\}", "");
        return string;
    }

    public static String escapeForItqlObject(String result)
    {
        return result.replace("'", "\\'");
    }
    
    public static String escapeForSqlObject(String result)
    {
        return result.replace("'", "\\'");
    }
}
