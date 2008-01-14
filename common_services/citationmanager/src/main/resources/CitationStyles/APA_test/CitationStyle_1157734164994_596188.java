/*
 * Generated by JasperReports - 08.09.06 18:49
 */
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.fill.*;

import java.util.*;
import java.math.*;
import java.text.*;
import java.io.*;
import java.net.*;

import java.util.*;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.*;


/**
 *
 */
public class CitationStyle_1157734164994_596188 extends JREvaluator
{


    /**
     *
     */
    private JRFillParameter parameter_REPORT_RESOURCE_BUNDLE = null;
    private JRFillParameter parameter_REPORT_CLASS_LOADER = null;
    private JRFillParameter parameter_REPORT_TIME_ZONE = null;
    private JRFillParameter parameter_XML_DATA_DOCUMENT = null;
    private JRFillParameter parameter_REPORT_DATA_SOURCE = null;
    private JRFillParameter parameter_REPORT_LOCALE = null;
    private JRFillParameter parameter_REPORT_URL_HANDLER_FACTORY = null;
    private JRFillParameter parameter_REPORT_PARAMETERS_MAP = null;
    private JRFillParameter parameter_REPORT_CONNECTION = null;
    private JRFillParameter parameter_IS_IGNORE_PAGINATION = null;
    private JRFillParameter parameter_REPORT_VIRTUALIZER = null;
    private JRFillParameter parameter_REPORT_SCRIPTLET = null;
    private JRFillParameter parameter_REPORT_MAX_COUNT = null;
    private JRFillField field_volume = null;
    private JRFillField field_sequencenr = null;
    private JRFillField field_publisheraddress = null;
    private JRFillField field_title = null;
    private JRFillField field_physicaldescription = null;
    private JRFillField field_titleofseries = null;
    private JRFillField field_enddateofevent = null;
    private JRFillField field_dateofevent = null;
    private JRFillField field_date = null;
    private JRFillField field_nameofevent = null;
    private JRFillField field_datetype = null;
    private JRFillField field_issue = null;
    private JRFillField field_sourcetitle = null;
    private JRFillField field_placeofevent = null;
    private JRFillField field_sourcecreatorfullname = null;
    private JRFillField field_publishername = null;
    private JRFillField field_genre = null;
    private JRFillField field_publicationstatus = null;
    private JRFillVariable variable_PAGE_NUMBER = null;
    private JRFillVariable variable_COLUMN_NUMBER = null;
    private JRFillVariable variable_REPORT_COUNT = null;
    private JRFillVariable variable_PAGE_COUNT = null;
    private JRFillVariable variable_COLUMN_COUNT = null;
    private JRFillVariable variable_CS_1_CSLD_1_P_default_E_1 = null;
    private JRFillVariable variable_CS_1_CSLD_1_P_default_E_2 = null;
    private JRFillVariable variable_CS_1_CSLD_1_P_default_E_3 = null;
    private JRFillVariable variable_CS_1_CSLD_2_P_default_E_1 = null;
    private JRFillVariable variable_CS_1_CSLD_2_P_default_E_2 = null;
    private JRFillVariable variable_CS_1_CSLD_2_P_default_E_3 = null;
    private JRFillVariable variable_CS_1_CSLD_2_P_default_E_4 = null;
    private JRFillVariable variable_CS_1_CSLD_1 = null;
    private JRFillVariable variable_CS_1_CSLD_2 = null;
    private JRFillVariable variable_citation = null;


    /**
     *
     */
    public void customizedInit(
        Map pm,
        Map fm,
        Map vm
        )
    {
        initParams(pm);
        initFields(fm);
        initVars(vm);
    }


    /**
     *
     */
    private void initParams(Map pm)
    {
        parameter_REPORT_RESOURCE_BUNDLE = (JRFillParameter)pm.get("REPORT_RESOURCE_BUNDLE");
        parameter_REPORT_CLASS_LOADER = (JRFillParameter)pm.get("REPORT_CLASS_LOADER");
        parameter_REPORT_TIME_ZONE = (JRFillParameter)pm.get("REPORT_TIME_ZONE");
        parameter_XML_DATA_DOCUMENT = (JRFillParameter)pm.get("XML_DATA_DOCUMENT");
        parameter_REPORT_DATA_SOURCE = (JRFillParameter)pm.get("REPORT_DATA_SOURCE");
        parameter_REPORT_LOCALE = (JRFillParameter)pm.get("REPORT_LOCALE");
        parameter_REPORT_URL_HANDLER_FACTORY = (JRFillParameter)pm.get("REPORT_URL_HANDLER_FACTORY");
        parameter_REPORT_PARAMETERS_MAP = (JRFillParameter)pm.get("REPORT_PARAMETERS_MAP");
        parameter_REPORT_CONNECTION = (JRFillParameter)pm.get("REPORT_CONNECTION");
        parameter_IS_IGNORE_PAGINATION = (JRFillParameter)pm.get("IS_IGNORE_PAGINATION");
        parameter_REPORT_VIRTUALIZER = (JRFillParameter)pm.get("REPORT_VIRTUALIZER");
        parameter_REPORT_SCRIPTLET = (JRFillParameter)pm.get("REPORT_SCRIPTLET");
        parameter_REPORT_MAX_COUNT = (JRFillParameter)pm.get("REPORT_MAX_COUNT");
    }


    /**
     *
     */
    private void initFields(Map fm)
    {
        field_volume = (JRFillField)fm.get("volume");
        field_sequencenr = (JRFillField)fm.get("sequencenr");
        field_publisheraddress = (JRFillField)fm.get("publisheraddress");
        field_title = (JRFillField)fm.get("title");
        field_physicaldescription = (JRFillField)fm.get("physicaldescription");
        field_titleofseries = (JRFillField)fm.get("titleofseries");
        field_enddateofevent = (JRFillField)fm.get("enddateofevent");
        field_dateofevent = (JRFillField)fm.get("dateofevent");
        field_date = (JRFillField)fm.get("date");
        field_nameofevent = (JRFillField)fm.get("nameofevent");
        field_datetype = (JRFillField)fm.get("datetype");
        field_issue = (JRFillField)fm.get("issue");
        field_sourcetitle = (JRFillField)fm.get("sourcetitle");
        field_placeofevent = (JRFillField)fm.get("placeofevent");
        field_sourcecreatorfullname = (JRFillField)fm.get("sourcecreatorfullname");
        field_publishername = (JRFillField)fm.get("publishername");
        field_genre = (JRFillField)fm.get("genre");
        field_publicationstatus = (JRFillField)fm.get("publicationstatus");
    }


    /**
     *
     */
    private void initVars(Map vm)
    {
        variable_PAGE_NUMBER = (JRFillVariable)vm.get("PAGE_NUMBER");
        variable_COLUMN_NUMBER = (JRFillVariable)vm.get("COLUMN_NUMBER");
        variable_REPORT_COUNT = (JRFillVariable)vm.get("REPORT_COUNT");
        variable_PAGE_COUNT = (JRFillVariable)vm.get("PAGE_COUNT");
        variable_COLUMN_COUNT = (JRFillVariable)vm.get("COLUMN_COUNT");
        variable_CS_1_CSLD_1_P_default_E_1 = (JRFillVariable)vm.get("CS_1_CSLD_1_P_default_E_1");
        variable_CS_1_CSLD_1_P_default_E_2 = (JRFillVariable)vm.get("CS_1_CSLD_1_P_default_E_2");
        variable_CS_1_CSLD_1_P_default_E_3 = (JRFillVariable)vm.get("CS_1_CSLD_1_P_default_E_3");
        variable_CS_1_CSLD_2_P_default_E_1 = (JRFillVariable)vm.get("CS_1_CSLD_2_P_default_E_1");
        variable_CS_1_CSLD_2_P_default_E_2 = (JRFillVariable)vm.get("CS_1_CSLD_2_P_default_E_2");
        variable_CS_1_CSLD_2_P_default_E_3 = (JRFillVariable)vm.get("CS_1_CSLD_2_P_default_E_3");
        variable_CS_1_CSLD_2_P_default_E_4 = (JRFillVariable)vm.get("CS_1_CSLD_2_P_default_E_4");
        variable_CS_1_CSLD_1 = (JRFillVariable)vm.get("CS_1_CSLD_1");
        variable_CS_1_CSLD_2 = (JRFillVariable)vm.get("CS_1_CSLD_2");
        variable_citation = (JRFillVariable)vm.get("citation");
    }


    /**
     *
     */
    public Object evaluate(int id) throws Throwable
    {
        Object value = null;

        switch (id)
        {
            case 0 : 
            {
                value = (java.lang.Integer)(new Integer(1));
                break;
            }
            case 1 : 
            {
                value = (java.lang.Integer)(new Integer(1));
                break;
            }
            case 2 : 
            {
                value = (java.lang.Integer)(new Integer(1));
                break;
            }
            case 3 : 
            {
                value = (java.lang.Integer)(new Integer(0));
                break;
            }
            case 4 : 
            {
                value = (java.lang.Integer)(new Integer(1));
                break;
            }
            case 5 : 
            {
                value = (java.lang.Integer)(new Integer(0));
                break;
            }
            case 6 : 
            {
                value = (java.lang.Integer)(new Integer(1));
                break;
            }
            case 7 : 
            {
                value = (java.lang.Integer)(new Integer(0));
                break;
            }
            case 8 : 
            {
                value = (java.lang.String)(((((((ScriptletForRepeatableElements_1157731598289)parameter_REPORT_SCRIPTLET.getValue())).getCS_1_CSLD_1_P_default_E_1())).length() > 0 ? ((((ScriptletForRepeatableElements_1157731598289)parameter_REPORT_SCRIPTLET.getValue())).getCS_1_CSLD_1_P_default_E_1()) : ""));
                break;
            }
            case 9 : 
            {
                value = (java.lang.String)(((java.lang.String)field_title.getValue())!=null ? "<style fontName=\"Arial\" fontSize=\"12\" isBold=\"false\" isItalic=\"true\" isUnderline=\"false\" isStrikeThrough=\"false\" pdfFontName=\"Helvetica-Oblique\" forecolor=\"blue\" backcolor=\"yellow\" pdfEncoding=\"Cp1250\" isPdfEmbedded=\"false\">" + (((((ScriptletForRepeatableElements_1157731598289)parameter_REPORT_SCRIPTLET.getValue()).xmlEncode(((java.lang.String)field_title.getValue())))).length() > 0 ? (((ScriptletForRepeatableElements_1157731598289)parameter_REPORT_SCRIPTLET.getValue()).xmlEncode(((java.lang.String)field_title.getValue()))) + "." : "") + "</style>" : "");
                break;
            }
            case 10 : 
            {
                value = (java.lang.String)(((((((ScriptletForRepeatableElements_1157731598289)parameter_REPORT_SCRIPTLET.getValue())).getCS_1_CSLD_1_P_default_E_3())).length() > 0 ? ((((ScriptletForRepeatableElements_1157731598289)parameter_REPORT_SCRIPTLET.getValue())).getCS_1_CSLD_1_P_default_E_3()) : ""));
                break;
            }
            case 11 : 
            {
                value = (java.lang.String)(((java.lang.String)field_genre.getValue())!=null ? "<style fontName=\"Arial\" fontSize=\"12\" isBold=\"true\" isItalic=\"false\" isUnderline=\"false\" isStrikeThrough=\"false\" pdfFontName=\"Helvetica-Bold\" forecolor=\"black\" backcolor=\"white\" pdfEncoding=\"Cp1250\" isPdfEmbedded=\"false\">" + (((((ScriptletForRepeatableElements_1157731598289)parameter_REPORT_SCRIPTLET.getValue()).xmlEncode(((java.lang.String)field_genre.getValue())))).length() > 0 ? "&amp;lt;HERE!!!&amp;gt;" + (((ScriptletForRepeatableElements_1157731598289)parameter_REPORT_SCRIPTLET.getValue()).xmlEncode(((java.lang.String)field_genre.getValue()))) : "") + "</style>" : "");
                break;
            }
            case 12 : 
            {
                value = (java.lang.String)(((((((ScriptletForRepeatableElements_1157731598289)parameter_REPORT_SCRIPTLET.getValue())).getCS_1_CSLD_2_P_default_E_2())).length() > 0 ? ((((ScriptletForRepeatableElements_1157731598289)parameter_REPORT_SCRIPTLET.getValue())).getCS_1_CSLD_2_P_default_E_2()) : ""));
                break;
            }
            case 13 : 
            {
                value = (java.lang.String)(((java.lang.String)field_title.getValue())!=null ? "<style fontName=\"Arial\" fontSize=\"12\" isBold=\"false\" isItalic=\"true\" isUnderline=\"false\" isStrikeThrough=\"false\" pdfFontName=\"Helvetica-Oblique\" forecolor=\"blue\" backcolor=\"yellow\" pdfEncoding=\"Cp1250\" isPdfEmbedded=\"false\">" + (((((ScriptletForRepeatableElements_1157731598289)parameter_REPORT_SCRIPTLET.getValue()).xmlEncode(((java.lang.String)field_title.getValue())))).length() > 0 ? (((ScriptletForRepeatableElements_1157731598289)parameter_REPORT_SCRIPTLET.getValue()).xmlEncode(((java.lang.String)field_title.getValue()))) + "." : "") + "</style>" : "");
                break;
            }
            case 14 : 
            {
                value = (java.lang.String)(((((((ScriptletForRepeatableElements_1157731598289)parameter_REPORT_SCRIPTLET.getValue())).getCS_1_CSLD_2_P_default_E_4())).length() > 0 ? ((((ScriptletForRepeatableElements_1157731598289)parameter_REPORT_SCRIPTLET.getValue())).getCS_1_CSLD_2_P_default_E_4()) : ""));
                break;
            }
            case 15 : 
            {
                value = (java.lang.String)(((((java.lang.String)field_genre.getValue()).equals("Book")||((java.lang.String)field_genre.getValue()).equals("Habilitation")||((java.lang.String)field_genre.getValue()).equals("PHD-Thesis")||((java.lang.String)field_genre.getValue()).equals("Proceedings")||((java.lang.String)field_genre.getValue()).equals("Journal")||((java.lang.String)field_genre.getValue()).equals("Series")||((java.lang.String)field_genre.getValue()).equals("Talk at Event")||((java.lang.String)field_genre.getValue()).equals("Thesis")) ? (((((java.lang.String)variable_CS_1_CSLD_1_P_default_E_1.getValue()) + (((java.lang.String)variable_CS_1_CSLD_1_P_default_E_2.getValue()).length()>0 && ((java.lang.String)variable_CS_1_CSLD_1_P_default_E_1.getValue()).length()>0 ? " " : "") + ((java.lang.String)variable_CS_1_CSLD_1_P_default_E_2.getValue()) + (((java.lang.String)variable_CS_1_CSLD_1_P_default_E_3.getValue()).length()>0 && ((java.lang.String)variable_CS_1_CSLD_1_P_default_E_2.getValue()).length()>0 ? " " : "") + ((java.lang.String)variable_CS_1_CSLD_1_P_default_E_3.getValue())).length() > 0 ? ((java.lang.String)variable_CS_1_CSLD_1_P_default_E_1.getValue()) + (((java.lang.String)variable_CS_1_CSLD_1_P_default_E_2.getValue()).length()>0 && ((java.lang.String)variable_CS_1_CSLD_1_P_default_E_1.getValue()).length()>0 ? " " : "") + ((java.lang.String)variable_CS_1_CSLD_1_P_default_E_2.getValue()) + (((java.lang.String)variable_CS_1_CSLD_1_P_default_E_3.getValue()).length()>0 && ((java.lang.String)variable_CS_1_CSLD_1_P_default_E_2.getValue()).length()>0 ? " " : "") + ((java.lang.String)variable_CS_1_CSLD_1_P_default_E_3.getValue()) + ".\n\n" : "")) : ""));
                break;
            }
            case 16 : 
            {
                value = (java.lang.String)(((((java.lang.String)variable_CS_1_CSLD_2_P_default_E_3.getValue()).indexOf("Mayoral")!=-1) ? (((((java.lang.String)variable_CS_1_CSLD_2_P_default_E_1.getValue()) + (((java.lang.String)variable_CS_1_CSLD_2_P_default_E_2.getValue()).length()>0 && ((java.lang.String)variable_CS_1_CSLD_2_P_default_E_1.getValue()).length()>0 ? " " : "") + ((java.lang.String)variable_CS_1_CSLD_2_P_default_E_2.getValue()) + (((java.lang.String)variable_CS_1_CSLD_2_P_default_E_3.getValue()).length()>0 && ((java.lang.String)variable_CS_1_CSLD_2_P_default_E_2.getValue()).length()>0 ? " " : "") + ((java.lang.String)variable_CS_1_CSLD_2_P_default_E_3.getValue()) + (((java.lang.String)variable_CS_1_CSLD_2_P_default_E_4.getValue()).length()>0 && ((java.lang.String)variable_CS_1_CSLD_2_P_default_E_3.getValue()).length()>0 ? " " : "") + ((java.lang.String)variable_CS_1_CSLD_2_P_default_E_4.getValue())).length() > 0 ? ((java.lang.String)variable_CS_1_CSLD_2_P_default_E_1.getValue()) + (((java.lang.String)variable_CS_1_CSLD_2_P_default_E_2.getValue()).length()>0 && ((java.lang.String)variable_CS_1_CSLD_2_P_default_E_1.getValue()).length()>0 ? " " : "") + ((java.lang.String)variable_CS_1_CSLD_2_P_default_E_2.getValue()) + (((java.lang.String)variable_CS_1_CSLD_2_P_default_E_3.getValue()).length()>0 && ((java.lang.String)variable_CS_1_CSLD_2_P_default_E_2.getValue()).length()>0 ? " " : "") + ((java.lang.String)variable_CS_1_CSLD_2_P_default_E_3.getValue()) + (((java.lang.String)variable_CS_1_CSLD_2_P_default_E_4.getValue()).length()>0 && ((java.lang.String)variable_CS_1_CSLD_2_P_default_E_3.getValue()).length()>0 ? " " : "") + ((java.lang.String)variable_CS_1_CSLD_2_P_default_E_4.getValue()) + ".\n\n" : "")) : ""));
                break;
            }
            case 17 : 
            {
                value = (java.lang.String)((((ScriptletForRepeatableElements_1157731598289)parameter_REPORT_SCRIPTLET.getValue()).cleanCit(((java.lang.String)variable_CS_1_CSLD_1.getValue()) + ((java.lang.String)variable_CS_1_CSLD_1.getValue()))));
                break;
            }
            case 18 : 
            {
                value = (java.lang.String)(((java.lang.String)variable_citation.getValue()));
                break;
            }
            case 19 : 
            {
                value = (java.lang.String)("Page " + ((java.lang.Integer)variable_PAGE_NUMBER.getValue()) + " of ");
                break;
            }
            case 20 : 
            {
                value = (java.lang.String)("" + ((java.lang.Integer)variable_PAGE_NUMBER.getValue()));
                break;
            }
            case 21 : 
            {
                value = (java.util.Date)(new Date());
                break;
            }
           default :
           {
           }
        }
        
        return value;
    }


    /**
     *
     */
    public Object evaluateOld(int id) throws Throwable
    {
        Object value = null;

        switch (id)
        {
            case 0 : 
            {
                value = (java.lang.Integer)(new Integer(1));
                break;
            }
            case 1 : 
            {
                value = (java.lang.Integer)(new Integer(1));
                break;
            }
            case 2 : 
            {
                value = (java.lang.Integer)(new Integer(1));
                break;
            }
            case 3 : 
            {
                value = (java.lang.Integer)(new Integer(0));
                break;
            }
            case 4 : 
            {
                value = (java.lang.Integer)(new Integer(1));
                break;
            }
            case 5 : 
            {
                value = (java.lang.Integer)(new Integer(0));
                break;
            }
            case 6 : 
            {
                value = (java.lang.Integer)(new Integer(1));
                break;
            }
            case 7 : 
            {
                value = (java.lang.Integer)(new Integer(0));
                break;
            }
            case 8 : 
            {
                value = (java.lang.String)(((((((ScriptletForRepeatableElements_1157731598289)parameter_REPORT_SCRIPTLET.getValue())).getCS_1_CSLD_1_P_default_E_1())).length() > 0 ? ((((ScriptletForRepeatableElements_1157731598289)parameter_REPORT_SCRIPTLET.getValue())).getCS_1_CSLD_1_P_default_E_1()) : ""));
                break;
            }
            case 9 : 
            {
                value = (java.lang.String)(((java.lang.String)field_title.getOldValue())!=null ? "<style fontName=\"Arial\" fontSize=\"12\" isBold=\"false\" isItalic=\"true\" isUnderline=\"false\" isStrikeThrough=\"false\" pdfFontName=\"Helvetica-Oblique\" forecolor=\"blue\" backcolor=\"yellow\" pdfEncoding=\"Cp1250\" isPdfEmbedded=\"false\">" + (((((ScriptletForRepeatableElements_1157731598289)parameter_REPORT_SCRIPTLET.getValue()).xmlEncode(((java.lang.String)field_title.getOldValue())))).length() > 0 ? (((ScriptletForRepeatableElements_1157731598289)parameter_REPORT_SCRIPTLET.getValue()).xmlEncode(((java.lang.String)field_title.getOldValue()))) + "." : "") + "</style>" : "");
                break;
            }
            case 10 : 
            {
                value = (java.lang.String)(((((((ScriptletForRepeatableElements_1157731598289)parameter_REPORT_SCRIPTLET.getValue())).getCS_1_CSLD_1_P_default_E_3())).length() > 0 ? ((((ScriptletForRepeatableElements_1157731598289)parameter_REPORT_SCRIPTLET.getValue())).getCS_1_CSLD_1_P_default_E_3()) : ""));
                break;
            }
            case 11 : 
            {
                value = (java.lang.String)(((java.lang.String)field_genre.getOldValue())!=null ? "<style fontName=\"Arial\" fontSize=\"12\" isBold=\"true\" isItalic=\"false\" isUnderline=\"false\" isStrikeThrough=\"false\" pdfFontName=\"Helvetica-Bold\" forecolor=\"black\" backcolor=\"white\" pdfEncoding=\"Cp1250\" isPdfEmbedded=\"false\">" + (((((ScriptletForRepeatableElements_1157731598289)parameter_REPORT_SCRIPTLET.getValue()).xmlEncode(((java.lang.String)field_genre.getOldValue())))).length() > 0 ? "&amp;lt;HERE!!!&amp;gt;" + (((ScriptletForRepeatableElements_1157731598289)parameter_REPORT_SCRIPTLET.getValue()).xmlEncode(((java.lang.String)field_genre.getOldValue()))) : "") + "</style>" : "");
                break;
            }
            case 12 : 
            {
                value = (java.lang.String)(((((((ScriptletForRepeatableElements_1157731598289)parameter_REPORT_SCRIPTLET.getValue())).getCS_1_CSLD_2_P_default_E_2())).length() > 0 ? ((((ScriptletForRepeatableElements_1157731598289)parameter_REPORT_SCRIPTLET.getValue())).getCS_1_CSLD_2_P_default_E_2()) : ""));
                break;
            }
            case 13 : 
            {
                value = (java.lang.String)(((java.lang.String)field_title.getOldValue())!=null ? "<style fontName=\"Arial\" fontSize=\"12\" isBold=\"false\" isItalic=\"true\" isUnderline=\"false\" isStrikeThrough=\"false\" pdfFontName=\"Helvetica-Oblique\" forecolor=\"blue\" backcolor=\"yellow\" pdfEncoding=\"Cp1250\" isPdfEmbedded=\"false\">" + (((((ScriptletForRepeatableElements_1157731598289)parameter_REPORT_SCRIPTLET.getValue()).xmlEncode(((java.lang.String)field_title.getOldValue())))).length() > 0 ? (((ScriptletForRepeatableElements_1157731598289)parameter_REPORT_SCRIPTLET.getValue()).xmlEncode(((java.lang.String)field_title.getOldValue()))) + "." : "") + "</style>" : "");
                break;
            }
            case 14 : 
            {
                value = (java.lang.String)(((((((ScriptletForRepeatableElements_1157731598289)parameter_REPORT_SCRIPTLET.getValue())).getCS_1_CSLD_2_P_default_E_4())).length() > 0 ? ((((ScriptletForRepeatableElements_1157731598289)parameter_REPORT_SCRIPTLET.getValue())).getCS_1_CSLD_2_P_default_E_4()) : ""));
                break;
            }
            case 15 : 
            {
                value = (java.lang.String)(((((java.lang.String)field_genre.getOldValue()).equals("Book")||((java.lang.String)field_genre.getOldValue()).equals("Habilitation")||((java.lang.String)field_genre.getOldValue()).equals("PHD-Thesis")||((java.lang.String)field_genre.getOldValue()).equals("Proceedings")||((java.lang.String)field_genre.getOldValue()).equals("Journal")||((java.lang.String)field_genre.getOldValue()).equals("Series")||((java.lang.String)field_genre.getOldValue()).equals("Talk at Event")||((java.lang.String)field_genre.getOldValue()).equals("Thesis")) ? (((((java.lang.String)variable_CS_1_CSLD_1_P_default_E_1.getOldValue()) + (((java.lang.String)variable_CS_1_CSLD_1_P_default_E_2.getOldValue()).length()>0 && ((java.lang.String)variable_CS_1_CSLD_1_P_default_E_1.getOldValue()).length()>0 ? " " : "") + ((java.lang.String)variable_CS_1_CSLD_1_P_default_E_2.getOldValue()) + (((java.lang.String)variable_CS_1_CSLD_1_P_default_E_3.getOldValue()).length()>0 && ((java.lang.String)variable_CS_1_CSLD_1_P_default_E_2.getOldValue()).length()>0 ? " " : "") + ((java.lang.String)variable_CS_1_CSLD_1_P_default_E_3.getOldValue())).length() > 0 ? ((java.lang.String)variable_CS_1_CSLD_1_P_default_E_1.getOldValue()) + (((java.lang.String)variable_CS_1_CSLD_1_P_default_E_2.getOldValue()).length()>0 && ((java.lang.String)variable_CS_1_CSLD_1_P_default_E_1.getOldValue()).length()>0 ? " " : "") + ((java.lang.String)variable_CS_1_CSLD_1_P_default_E_2.getOldValue()) + (((java.lang.String)variable_CS_1_CSLD_1_P_default_E_3.getOldValue()).length()>0 && ((java.lang.String)variable_CS_1_CSLD_1_P_default_E_2.getOldValue()).length()>0 ? " " : "") + ((java.lang.String)variable_CS_1_CSLD_1_P_default_E_3.getOldValue()) + ".\n\n" : "")) : ""));
                break;
            }
            case 16 : 
            {
                value = (java.lang.String)(((((java.lang.String)variable_CS_1_CSLD_2_P_default_E_3.getOldValue()).indexOf("Mayoral")!=-1) ? (((((java.lang.String)variable_CS_1_CSLD_2_P_default_E_1.getOldValue()) + (((java.lang.String)variable_CS_1_CSLD_2_P_default_E_2.getOldValue()).length()>0 && ((java.lang.String)variable_CS_1_CSLD_2_P_default_E_1.getOldValue()).length()>0 ? " " : "") + ((java.lang.String)variable_CS_1_CSLD_2_P_default_E_2.getOldValue()) + (((java.lang.String)variable_CS_1_CSLD_2_P_default_E_3.getOldValue()).length()>0 && ((java.lang.String)variable_CS_1_CSLD_2_P_default_E_2.getOldValue()).length()>0 ? " " : "") + ((java.lang.String)variable_CS_1_CSLD_2_P_default_E_3.getOldValue()) + (((java.lang.String)variable_CS_1_CSLD_2_P_default_E_4.getOldValue()).length()>0 && ((java.lang.String)variable_CS_1_CSLD_2_P_default_E_3.getOldValue()).length()>0 ? " " : "") + ((java.lang.String)variable_CS_1_CSLD_2_P_default_E_4.getOldValue())).length() > 0 ? ((java.lang.String)variable_CS_1_CSLD_2_P_default_E_1.getOldValue()) + (((java.lang.String)variable_CS_1_CSLD_2_P_default_E_2.getOldValue()).length()>0 && ((java.lang.String)variable_CS_1_CSLD_2_P_default_E_1.getOldValue()).length()>0 ? " " : "") + ((java.lang.String)variable_CS_1_CSLD_2_P_default_E_2.getOldValue()) + (((java.lang.String)variable_CS_1_CSLD_2_P_default_E_3.getOldValue()).length()>0 && ((java.lang.String)variable_CS_1_CSLD_2_P_default_E_2.getOldValue()).length()>0 ? " " : "") + ((java.lang.String)variable_CS_1_CSLD_2_P_default_E_3.getOldValue()) + (((java.lang.String)variable_CS_1_CSLD_2_P_default_E_4.getOldValue()).length()>0 && ((java.lang.String)variable_CS_1_CSLD_2_P_default_E_3.getOldValue()).length()>0 ? " " : "") + ((java.lang.String)variable_CS_1_CSLD_2_P_default_E_4.getOldValue()) + ".\n\n" : "")) : ""));
                break;
            }
            case 17 : 
            {
                value = (java.lang.String)((((ScriptletForRepeatableElements_1157731598289)parameter_REPORT_SCRIPTLET.getValue()).cleanCit(((java.lang.String)variable_CS_1_CSLD_1.getOldValue()) + ((java.lang.String)variable_CS_1_CSLD_1.getOldValue()))));
                break;
            }
            case 18 : 
            {
                value = (java.lang.String)(((java.lang.String)variable_citation.getOldValue()));
                break;
            }
            case 19 : 
            {
                value = (java.lang.String)("Page " + ((java.lang.Integer)variable_PAGE_NUMBER.getOldValue()) + " of ");
                break;
            }
            case 20 : 
            {
                value = (java.lang.String)("" + ((java.lang.Integer)variable_PAGE_NUMBER.getOldValue()));
                break;
            }
            case 21 : 
            {
                value = (java.util.Date)(new Date());
                break;
            }
           default :
           {
           }
        }
        
        return value;
    }


    /**
     *
     */
    public Object evaluateEstimated(int id) throws Throwable
    {
        Object value = null;

        switch (id)
        {
            case 0 : 
            {
                value = (java.lang.Integer)(new Integer(1));
                break;
            }
            case 1 : 
            {
                value = (java.lang.Integer)(new Integer(1));
                break;
            }
            case 2 : 
            {
                value = (java.lang.Integer)(new Integer(1));
                break;
            }
            case 3 : 
            {
                value = (java.lang.Integer)(new Integer(0));
                break;
            }
            case 4 : 
            {
                value = (java.lang.Integer)(new Integer(1));
                break;
            }
            case 5 : 
            {
                value = (java.lang.Integer)(new Integer(0));
                break;
            }
            case 6 : 
            {
                value = (java.lang.Integer)(new Integer(1));
                break;
            }
            case 7 : 
            {
                value = (java.lang.Integer)(new Integer(0));
                break;
            }
            case 8 : 
            {
                value = (java.lang.String)(((((((ScriptletForRepeatableElements_1157731598289)parameter_REPORT_SCRIPTLET.getValue())).getCS_1_CSLD_1_P_default_E_1())).length() > 0 ? ((((ScriptletForRepeatableElements_1157731598289)parameter_REPORT_SCRIPTLET.getValue())).getCS_1_CSLD_1_P_default_E_1()) : ""));
                break;
            }
            case 9 : 
            {
                value = (java.lang.String)(((java.lang.String)field_title.getValue())!=null ? "<style fontName=\"Arial\" fontSize=\"12\" isBold=\"false\" isItalic=\"true\" isUnderline=\"false\" isStrikeThrough=\"false\" pdfFontName=\"Helvetica-Oblique\" forecolor=\"blue\" backcolor=\"yellow\" pdfEncoding=\"Cp1250\" isPdfEmbedded=\"false\">" + (((((ScriptletForRepeatableElements_1157731598289)parameter_REPORT_SCRIPTLET.getValue()).xmlEncode(((java.lang.String)field_title.getValue())))).length() > 0 ? (((ScriptletForRepeatableElements_1157731598289)parameter_REPORT_SCRIPTLET.getValue()).xmlEncode(((java.lang.String)field_title.getValue()))) + "." : "") + "</style>" : "");
                break;
            }
            case 10 : 
            {
                value = (java.lang.String)(((((((ScriptletForRepeatableElements_1157731598289)parameter_REPORT_SCRIPTLET.getValue())).getCS_1_CSLD_1_P_default_E_3())).length() > 0 ? ((((ScriptletForRepeatableElements_1157731598289)parameter_REPORT_SCRIPTLET.getValue())).getCS_1_CSLD_1_P_default_E_3()) : ""));
                break;
            }
            case 11 : 
            {
                value = (java.lang.String)(((java.lang.String)field_genre.getValue())!=null ? "<style fontName=\"Arial\" fontSize=\"12\" isBold=\"true\" isItalic=\"false\" isUnderline=\"false\" isStrikeThrough=\"false\" pdfFontName=\"Helvetica-Bold\" forecolor=\"black\" backcolor=\"white\" pdfEncoding=\"Cp1250\" isPdfEmbedded=\"false\">" + (((((ScriptletForRepeatableElements_1157731598289)parameter_REPORT_SCRIPTLET.getValue()).xmlEncode(((java.lang.String)field_genre.getValue())))).length() > 0 ? "&amp;lt;HERE!!!&amp;gt;" + (((ScriptletForRepeatableElements_1157731598289)parameter_REPORT_SCRIPTLET.getValue()).xmlEncode(((java.lang.String)field_genre.getValue()))) : "") + "</style>" : "");
                break;
            }
            case 12 : 
            {
                value = (java.lang.String)(((((((ScriptletForRepeatableElements_1157731598289)parameter_REPORT_SCRIPTLET.getValue())).getCS_1_CSLD_2_P_default_E_2())).length() > 0 ? ((((ScriptletForRepeatableElements_1157731598289)parameter_REPORT_SCRIPTLET.getValue())).getCS_1_CSLD_2_P_default_E_2()) : ""));
                break;
            }
            case 13 : 
            {
                value = (java.lang.String)(((java.lang.String)field_title.getValue())!=null ? "<style fontName=\"Arial\" fontSize=\"12\" isBold=\"false\" isItalic=\"true\" isUnderline=\"false\" isStrikeThrough=\"false\" pdfFontName=\"Helvetica-Oblique\" forecolor=\"blue\" backcolor=\"yellow\" pdfEncoding=\"Cp1250\" isPdfEmbedded=\"false\">" + (((((ScriptletForRepeatableElements_1157731598289)parameter_REPORT_SCRIPTLET.getValue()).xmlEncode(((java.lang.String)field_title.getValue())))).length() > 0 ? (((ScriptletForRepeatableElements_1157731598289)parameter_REPORT_SCRIPTLET.getValue()).xmlEncode(((java.lang.String)field_title.getValue()))) + "." : "") + "</style>" : "");
                break;
            }
            case 14 : 
            {
                value = (java.lang.String)(((((((ScriptletForRepeatableElements_1157731598289)parameter_REPORT_SCRIPTLET.getValue())).getCS_1_CSLD_2_P_default_E_4())).length() > 0 ? ((((ScriptletForRepeatableElements_1157731598289)parameter_REPORT_SCRIPTLET.getValue())).getCS_1_CSLD_2_P_default_E_4()) : ""));
                break;
            }
            case 15 : 
            {
                value = (java.lang.String)(((((java.lang.String)field_genre.getValue()).equals("Book")||((java.lang.String)field_genre.getValue()).equals("Habilitation")||((java.lang.String)field_genre.getValue()).equals("PHD-Thesis")||((java.lang.String)field_genre.getValue()).equals("Proceedings")||((java.lang.String)field_genre.getValue()).equals("Journal")||((java.lang.String)field_genre.getValue()).equals("Series")||((java.lang.String)field_genre.getValue()).equals("Talk at Event")||((java.lang.String)field_genre.getValue()).equals("Thesis")) ? (((((java.lang.String)variable_CS_1_CSLD_1_P_default_E_1.getEstimatedValue()) + (((java.lang.String)variable_CS_1_CSLD_1_P_default_E_2.getEstimatedValue()).length()>0 && ((java.lang.String)variable_CS_1_CSLD_1_P_default_E_1.getEstimatedValue()).length()>0 ? " " : "") + ((java.lang.String)variable_CS_1_CSLD_1_P_default_E_2.getEstimatedValue()) + (((java.lang.String)variable_CS_1_CSLD_1_P_default_E_3.getEstimatedValue()).length()>0 && ((java.lang.String)variable_CS_1_CSLD_1_P_default_E_2.getEstimatedValue()).length()>0 ? " " : "") + ((java.lang.String)variable_CS_1_CSLD_1_P_default_E_3.getEstimatedValue())).length() > 0 ? ((java.lang.String)variable_CS_1_CSLD_1_P_default_E_1.getEstimatedValue()) + (((java.lang.String)variable_CS_1_CSLD_1_P_default_E_2.getEstimatedValue()).length()>0 && ((java.lang.String)variable_CS_1_CSLD_1_P_default_E_1.getEstimatedValue()).length()>0 ? " " : "") + ((java.lang.String)variable_CS_1_CSLD_1_P_default_E_2.getEstimatedValue()) + (((java.lang.String)variable_CS_1_CSLD_1_P_default_E_3.getEstimatedValue()).length()>0 && ((java.lang.String)variable_CS_1_CSLD_1_P_default_E_2.getEstimatedValue()).length()>0 ? " " : "") + ((java.lang.String)variable_CS_1_CSLD_1_P_default_E_3.getEstimatedValue()) + ".\n\n" : "")) : ""));
                break;
            }
            case 16 : 
            {
                value = (java.lang.String)(((((java.lang.String)variable_CS_1_CSLD_2_P_default_E_3.getEstimatedValue()).indexOf("Mayoral")!=-1) ? (((((java.lang.String)variable_CS_1_CSLD_2_P_default_E_1.getEstimatedValue()) + (((java.lang.String)variable_CS_1_CSLD_2_P_default_E_2.getEstimatedValue()).length()>0 && ((java.lang.String)variable_CS_1_CSLD_2_P_default_E_1.getEstimatedValue()).length()>0 ? " " : "") + ((java.lang.String)variable_CS_1_CSLD_2_P_default_E_2.getEstimatedValue()) + (((java.lang.String)variable_CS_1_CSLD_2_P_default_E_3.getEstimatedValue()).length()>0 && ((java.lang.String)variable_CS_1_CSLD_2_P_default_E_2.getEstimatedValue()).length()>0 ? " " : "") + ((java.lang.String)variable_CS_1_CSLD_2_P_default_E_3.getEstimatedValue()) + (((java.lang.String)variable_CS_1_CSLD_2_P_default_E_4.getEstimatedValue()).length()>0 && ((java.lang.String)variable_CS_1_CSLD_2_P_default_E_3.getEstimatedValue()).length()>0 ? " " : "") + ((java.lang.String)variable_CS_1_CSLD_2_P_default_E_4.getEstimatedValue())).length() > 0 ? ((java.lang.String)variable_CS_1_CSLD_2_P_default_E_1.getEstimatedValue()) + (((java.lang.String)variable_CS_1_CSLD_2_P_default_E_2.getEstimatedValue()).length()>0 && ((java.lang.String)variable_CS_1_CSLD_2_P_default_E_1.getEstimatedValue()).length()>0 ? " " : "") + ((java.lang.String)variable_CS_1_CSLD_2_P_default_E_2.getEstimatedValue()) + (((java.lang.String)variable_CS_1_CSLD_2_P_default_E_3.getEstimatedValue()).length()>0 && ((java.lang.String)variable_CS_1_CSLD_2_P_default_E_2.getEstimatedValue()).length()>0 ? " " : "") + ((java.lang.String)variable_CS_1_CSLD_2_P_default_E_3.getEstimatedValue()) + (((java.lang.String)variable_CS_1_CSLD_2_P_default_E_4.getEstimatedValue()).length()>0 && ((java.lang.String)variable_CS_1_CSLD_2_P_default_E_3.getEstimatedValue()).length()>0 ? " " : "") + ((java.lang.String)variable_CS_1_CSLD_2_P_default_E_4.getEstimatedValue()) + ".\n\n" : "")) : ""));
                break;
            }
            case 17 : 
            {
                value = (java.lang.String)((((ScriptletForRepeatableElements_1157731598289)parameter_REPORT_SCRIPTLET.getValue()).cleanCit(((java.lang.String)variable_CS_1_CSLD_1.getEstimatedValue()) + ((java.lang.String)variable_CS_1_CSLD_1.getEstimatedValue()))));
                break;
            }
            case 18 : 
            {
                value = (java.lang.String)(((java.lang.String)variable_citation.getEstimatedValue()));
                break;
            }
            case 19 : 
            {
                value = (java.lang.String)("Page " + ((java.lang.Integer)variable_PAGE_NUMBER.getEstimatedValue()) + " of ");
                break;
            }
            case 20 : 
            {
                value = (java.lang.String)("" + ((java.lang.Integer)variable_PAGE_NUMBER.getEstimatedValue()));
                break;
            }
            case 21 : 
            {
                value = (java.util.Date)(new Date());
                break;
            }
           default :
           {
           }
        }
        
        return value;
    }


}
