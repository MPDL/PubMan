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


package de.mpg.escidoc.services.structuredexportmanager.functions;

import java.util.HashMap;
import java.util.Map;

/**
 * Function extensions for the BibTex export functionality.
 * To be used from the XSLT.   
 * Converts PubMan item-list to one of the structured formats.   
 *
 * @author Vlad Makarenko (initial creation)
 * @author $Author$ (last modification)
 * @version $Revision$ $LastChangedDate$
 *
 */ 

public class BibTex {

    /* 
     * UNICODE -> BibTex mapping
     * not really comprehensive
     *  
     * */
    public static final Map<String, String>  ENTITIES =     
        new HashMap<String, String>()   
        {  
            {
            	/*
            	 * Changes need to be done for the import side too!
            	 * (de.mpg.escidoc.services.transformation.transformations.commonPublicationFormats.BibTexUtil.java)
            	 */
            	put("\\u000A", "\n");
            	put("\u002A", "\\textasteriskcentered");
            	put("\u003C", "\\textless");
            	put("\u003D", "\\textequals");
            	put("\u003E", "\\textgreater");
            	put("\\u005C", "\\textbackslash");
            	put("\u005E", "\\textasciicircum");
            	put("\u005F", "\\textunderscore");
            	put("\u007B", "\\textbraceleft");
            	put("\u007C", "\\textbar");
            	put("\u007D", "\\textbraceright");
            	put("\u007E", "\\textasciitilde");
            	put("\\u0022", "\\textquotedbl");
            	put("\u0023", "\\#");
            	put("\u0024", "\\textdollar");
            	put("\u0025", "\\textpercent");
            	put("\u0026", "\\&");
            	put("\u0027", "\\textquotesingle");
            	put("\u0060", "\\textasciigrave");
            	put("\u00A1", "\\textexclamdown");
            	put("\u00A2", "\\textcent");
            	put("\u00A4", "\\textcurrency");
            	put("\u00A5", "\\textyen");
            	put("\u00A6", "\\textbrokenbar");
            	put("\u00A8", "\\textasciidieresis");
            	put("\u00AA", "\\textordfeminine");
            	put("\u00AB", "\\guillemotleft");
            	put("\u00AE", "\\textregistered");
            	put("\u00AF", "\\textasciimacron");
            	put("\u00B0", "\\textdegree");
            	put("\u00B1", "$\\pm$");
            	put("\u00B4", "\\textasciiacute");
            	put("\u00B5", "$\\micro$");
            	put("\u00B8", "\\textasciicedilla");
            	put("\u00BA", "\\textordmasculine");
            	put("\u00BB", "\\guillemotright");
            	put("\u00BC", "\\textonequarter");
            	put("\u00BD", "\\textonehalf");
            	put("\u00BE", "\\textthreequarters");
            	put("\u00BF", "\\textquestiondown");
            	put("\u00D7", "$\\times$");
            	put("\u00F7", "$\\div$");
            	put("\u00a3", "\\pounds");
            	put("\u00a7", "\\S");
            	put("\u00a9", "\\copyright");
            	put("\u00ac", "$\\neg$");
            	put("\u00b0", "\\mbox{$^\\circ$}");
            	put("\u00b2", "\\mbox{$^2$}");
            	put("\u00b3", "\\mbox{$^3$}");
            	put("\u00b6", "\\P");
            	put("\u00b7", "\\mbox{$\\cdot$}");
            	put("\u00b9", "\\mbox{$^1$}");
            	put("\u00c0", "\\`A");
            	put("\u00c1", "\\'A");
            	put("\u00c2", "\\^A");
            	put("\u00c3", "\\~A");
            	put("\u00c4", "\\\"A");
            	put("\u00c5", "\\AA");
            	put("\u00c6", "\\AE");
            	put("\u00c7", "\\c{C}");
            	put("\u00c8", "\\`E");
            	put("\u00c9", "\\'E");
            	put("\u00ca", "\\^E");
            	put("\u00cb", "\\\"E");
            	put("\u00cc", "\\`I");
            	put("\u00cd", "\\'I");
            	put("\u00ce", "\\^I");
            	put("\u00cf", "\\\"I");
            	put("\u00d0", "\\DH");
            	put("\u00d1", "\\~N");
            	put("\u00d2", "\\`O");
            	put("\u00d3", "\\'O");
            	put("\u00d4", "\\^O");
            	put("\u00d5", "\\~O");
            	put("\u00d6", "\\\"O");
            	put("\u00d8", "\\O");
            	put("\u00d9", "\\`U");
            	put("\u00da", "\\'U");
            	put("\u00db", "\\^U");
            	put("\u00dc", "\\\"U");
            	put("\u00dd", "\\'Y");
            	put("\u00de", "\\TH");
            	put("\u00df", "\\ss");
            	put("\u00e0", "\\`a");
            	put("\u00e1", "\\'a");
            	put("\u00e2", "\\^a");
            	put("\u00e3", "\\~a");
            	put("\u00e4", "\\\"a");
            	put("\u00e5", "\\aa");
            	put("\u00e6", "\\ae");
            	put("\u00e7", "\\c{c}");
            	put("\u00e8", "\\`e");
            	put("\u00e9", "\\'e");
            	put("\u00ea", "\\^e");
            	put("\u00eb", "\\\"e");
            	put("\u00ec", "\\`\\i");
            	put("\u00ed", "\\'\\i");
            	put("\u00ee", "\\^\\i");
            	put("\u00ef", "\\\"\\i");
            	put("\u00f0", "\\dh");
            	put("\u00f1", "\\~n");
            	put("\u00f2", "\\`o");
            	put("\u00f3", "\\'o");
            	put("\u00f4", "\\^o");
            	put("\u00f5", "\\~o");
            	put("\u00f6", "\\\"o");
            	put("\u00f8", "\\o");
            	put("\u00f9", "\\`u");
            	put("\u00fa", "\\'u");
            	put("\u00fb", "\\^u");
            	put("\u00fc", "\\\"u");
            	put("\u00fd", "\\'y");
            	put("\u00fe", "\\th");
            	put("\u00ff", "\\\"y");
            	put("\u01B4", "\\textyhook");
            	put("\u01B7", "\\textEzh");
            	put("\u01DD", "\\texteturned");
            	put("\u01a0", "\\OHORN");
            	put("\u01a1", "\\ohorn");
            	put("\u01a4", "\\textPhook");
            	put("\u01a5", "\\texthtp");
            	put("\u01a9", "\\ESH");
            	put("\u01aa", "\\textlooptoprevesh");
            	put("\u01ab", "\\textpalhookbelow");
            	put("\u01ac", "\\textThook");
            	put("\u01ad", "\\texthtt");
            	put("\u01ae", "\\textTretroflexhook");
            	put("\u01af", "\\UHORN");
            	put("\u01b0", "\\uhorn");
            	put("\u01b2", "\\textVhook");
            	put("\u01b3", "\\textYhook");
            	put("\u01c4", "D\\v{Z}");
            	put("\u01c5", "D\\v{z}");
            	put("\u01c6", "d\\v{z}");
            	put("\u01cd", "\\v{A}");
            	put("\u01ce", "\\v{a}");
            	put("\u01cf", "\\v{I}");
            	put("\u01d0", "\\v\\i");
            	put("\u01d1", "\\v{O}");
            	put("\u01d2", "\\v{o}");
            	put("\u01d3", "\\v{U}");
            	put("\u01d4", "\\v{u}");
            	put("\u01e6", "\\v{G}");
            	put("\u01e7", "\\v{g}");
            	put("\u01e8", "\\v{K}");
            	put("\u01e9", "\\v{k}");
            	put("\u01ea", "\\c{O}");
            	put("\u01eb", "\\c{o}");
            	put("\u01f0", "\\v\\j");
            	put("\u01f4", "\\'G");
            	put("\u01f5", "\\'g");
            	put("\u01fc", "\\'\\AE");
            	put("\u01fd", "\\'\\ae");
            	put("\u01fe", "\\'\\O");
            	put("\u01ff", "\\'\\o");
            	put("\u02A0", "\\texthtq");
            	put("\u02A1", "\\textbarglotstop");
            	put("\u02A2", "\\textbarrevglotstop");
            	put("\u02A3", "\\textdzlig");
            	put("\u02A4", "\\textdyoghlig");
            	put("\u02A5", "\\textdctzlig");
            	put("\u02A6", "\\texttslig");
            	put("\u02A7", "\\texttesh");
            	put("\u02A8", "\\texttctclig");
            	put("\u02B0", "\\h{}");
            	put("\u02B2", "\\j");
            	put("\u02B3", "$^r$");
            	put("\u02B7", "$^w$");
            	put("\u02B8", "$^y$");
            	put("\u02BE", "\\hamza");
            	put("\u02BF", "\\Ayn");
            	put("\u02C8", "\\textprimstress");
            	put("\u02D0", "\\textlengthmark");
            	put("\u02E5", "\\tone5");
            	put("\u02E6", "\\tone4");
            	put("\u02E7", "\\tone3");
            	put("\u02E8", "\\tone2");
            	put("\u02E9", "\\tone1");
            	put("\u02c6", "\\^{}");
            	put("\u02c7", "\\v{}");
            	put("\u02d8", "\\u{}");
            	put("\u02d9", "\\.{}");
            	put("\u02da", "\\r{}");
            	put("\u02db", "\\c{}");
            	put("\u02dc", "\\~{}");
            	put("\u02dd", "\\H{}");
            	put("\u03A0", "$\\Pi$");
            	put("\u03C0", "$\\pi$");
            	put("\u03A1", "$\\Rho$");
            	put("\u03A3", "$\\Sigma$");
            	put("\u03A4", "$\\Tau$");
            	put("\u03A5", "$\\Upsilon$");
            	put("\u03A6", "$\\Phi$");
            	put("\u03A7", "$\\Chi$");
            	put("\u03A8", "$\\Psi$");
            	put("\u03A9", "$\\Omega$");
            	put("\u03B1", "$\\alpha$");
            	put("\u03B2", "$\\beta$");
            	put("\u03B3", "$\\gamma$");
            	put("\u03B4", "$\\delta$");
            	put("\u03B5", "$\\varepsilon$");
            	put("\u03B6", "$\\zeta$");
            	put("\u03B7", "$\\eta$");
            	put("\u03B8", "$\\vartheta$");
            	put("\u03B9", "$\\iota$");
            	put("\u03BA", "$\\kappa$");
            	put("\u03BB", "$\\lambda$");
            	put("\u03BC", "$\\mu$");
            	put("\u03BD", "$\\nu$");
            	put("\u03BE", "$\\xi$");
            	put("\u03BF", "$\\omicron$");
            	put("\u03C1", "$\\varrho$");
            	put("\u03C2", "$\\varsigma$");
            	put("\u03C3", "$\\sigma$");
            	put("\u03C4", "$\\tau$");
            	put("\u03C5", "$\\upsilon$");
            	put("\u03C6", "$\\varphi$");
            	put("\u03C7", "$\\chi$");
            	put("\u03C8", "$\\psi$");
            	put("\u03C9", "$\\omega$");
            	put("\u010a", "\\.C");
            	put("\u010b", "\\.c");
            	put("\u010c", "\\v{C}");
            	put("\u010d", "\\v{c}");
            	put("\u010e", "\\v{D}");
            	put("\u010f", "\\v{d}");
            	put("\u011a", "\\v{E}");
            	put("\u011b", "\\v{e}");
            	put("\u011c", "\\^G");
            	put("\u011d", "\\^g");
            	put("\u011e", "\\u{G}");
            	put("\u011f", "\\u{g}");
            	put("\u012a", "\\=I");
            	put("\u012b", "\\=\\i");
            	put("\u012c", "\\u{I}");
            	put("\u012d", "\\u\\i");
            	put("\u012e", "\\c{I}");
            	put("\u012f", "\\c{i}");
            	put("\u013a", "\\'l");
            	put("\u013b", "\\c{L}");
            	put("\u013c", "\\c{l}");
            	put("\u013d", "\\v{L}");
            	put("\u013e", "\\v{l}");
            	put("\u014a", "\\NG");
            	put("\u014b", "\\ng");
            	put("\u014c", "\\=O");
            	put("\u014d", "\\=o");
            	put("\u014e", "\\u{O}");
            	put("\u014f", "\\u{o}");
            	put("\u015a", "\\'S");
            	put("\u015b", "\\'s");
            	put("\u015c", "\\^S");
            	put("\u015d", "\\^s");
            	put("\u015e", "\\c{S}");
            	put("\u015f", "\\c{s}");
            	put("\u016a", "\\=U");
            	put("\u016b", "\\=u");
            	put("\u016c", "\\u{U}");
            	put("\u016d", "\\u{u}");
            	put("\u016e", "\\r{U}");
            	put("\u016f", "\\r{u}");
            	put("\u017a", "\\'Z");
            	put("\u017b", "\\.Z");
            	put("\u017c", "\\.Z");
            	put("\u017d", "\\v{Z}");
            	put("\u017e", "\\v{z}");
            	put("\u018a", "\\textDhook");
            	put("\u018e", "\\textEreversed");
            	put("\u019b", "\\textcrlambda");
            	put("\u019d", "\\textNhookleft");
            	put("\u025A", "\\textrhookschwa");
            	put("\u025B", "\\textepsilon");
            	put("\u025C", "\\textrevepsilon");
            	put("\u025D", "\\textrhookrevepsilon");
            	put("\u025E", "\\textcloserevepsilon");
            	put("\u025F", "\\textbardotlessj");
            	put("\u026A", "\\textsci");
            	put("\u026B", "\\textltilde");
            	put("\u026C", "\\textbeltl");
            	put("\u026D", "\\textrtaill");
            	put("\u026E", "\\textlyoghlig");
            	put("\u026F", "\\textturnm");
            	put("\u027A", "\\textturnlonglegr");
            	put("\u027B", "\\textturnrrtail");
            	put("\u027C", "\\textlonglegr");
            	put("\u027D", "\\textrtailr");
            	put("\u027E", "\\textfishhookr");
            	put("\u027F", "\\textlhti");
            	put("\u028A", "\\textupsilon");
            	put("\u028B", "\\textvhook");
            	put("\u028C", "\\textturnv");
            	put("\u028D", "\\textturnw");
            	put("\u028E", "\\textturny");
            	put("\u028F", "\\textscy");
            	put("\u029A", "\\textcloseepsilon");
            	put("\u029B", "\\texthtscg");
            	put("\u029C", "\\textsch");
            	put("\u029D", "\\textctj");
            	put("\u029E", "\\textturnk");
            	put("\u029F", "\\textscl");
            	put("\u030B", "\\H{}");
            	put("\u030C", "\\v{}");
            	put("\u030D", "\\textvbaraccent{}");
            	put("\u030E", "\\textdoublevbaraccent{}");
            	put("\u030F", "\\G");
            	put("\u031A", "\\textlangleabove");
            	put("\u031B", "\\textrighthorn");
            	put("\u031C", "\\textsublhalfring{}");
            	put("\u031D", "\\textraising{}");
            	put("\u031E", "\\textlowering{}");
            	put("\u031F", "\\textsubplus{}");
            	put("\u032A", "\\textsubbridge{}");
            	put("\u032B", "\\textsubw{}");
            	put("\u032C", "\\textsubwedge{}");
            	put("\u032D", "\\textsubcircum");
            	put("\u032E", "\\textundertie");
            	put("\u032F", "\\textsubarch{}");
            	put("\u033A", "\\textinvsubbridge{}");
            	put("\u033B", "\\textsubsquare{}");
            	put("\u033C", "\\textseagull{}");
            	put("\u033D", "\\textovercross{}");
            	put("\u034A", "\\textoverw{}");
            	put("\u034B", "\\dottedtilde");
            	put("\u034C", "\\doubletilde");
            	put("\u034D", "\\spreadlips");
            	put("\u034E", "\\whistle");
            	put("\u035D", "\\textdoublebreve");
            	put("\u035E", "\\textdoublemacron");
            	put("\u035F", "\\textdoublemacronbelow");
            	put("\u039A", "$\\Kappa$");
            	put("\u039B", "$\\Lambda$");
            	put("\u039C", "$\\Mu$");
            	put("\u039D", "$\\Nu$");
            	put("\u039E", "$\\Xi$");
            	put("\u039F", "$\\Omicron$");
            	put("\u0100", "\\=A");
            	put("\u0101", "\\=a");
            	put("\u0102", "\\u{A}");
            	put("\u0103", "\\u{a}");
            	put("\u0104", "\\c{A}");
            	put("\u0105", "\\c{a}");
            	put("\u0106", "\\'C");
            	put("\u0107", "\\'c");
            	put("\u0108", "\\^C");
            	put("\u0109", "\\^c");
            	put("\u0110", "\\DJ");
            	put("\u0111", "\\dj");
            	put("\u0112", "\\=E");
            	put("\u0113", "\\=e");
            	put("\u0114", "\\u{E}");
            	put("\u0115", "\\u{e}");
            	put("\u0116", "\\.E");
            	put("\u0117", "\\.e");
            	put("\u0118", "\\c{E}");
            	put("\u0119", "\\c{e}");
            	put("\u0120", "\\.G");
            	put("\u0121", "\\.g");
            	put("\u0122", "\\c{G}");
            	put("\u0123", "\\c{g}");
            	put("\u0124", "\\^H");
            	put("\u0125", "\\^h");
            	put("\u0126", "\\textHbar");
            	put("\u0127", "\\texthbar");
            	put("\u0128", "\\~I");
            	put("\u0129", "\\~\\i");
            	put("\u0130", "\\.I");
            	put("\u0131", "\\i");
            	put("\u0132", "\\IJ");
            	put("\u0133", "\\ij");
            	put("\u0134", "\\^J");
            	put("\u0135", "\\^\\j");
            	put("\u0136", "\\c{K}");
            	put("\u0137", "\\c{k}");
            	put("\u0138", "\\textkra");
            	put("\u0139", "\\'L");
            	put("\u0141", "\\L");
            	put("\u0141", "\\L");
            	put("\u0142", "\\l");
            	put("\u0143", "\\'N");
            	put("\u0144", "\\'n");
            	put("\u0145", "\\c{N}");
            	put("\u0146", "\\c{n}");
            	put("\u0147", "\\v{N}");
            	put("\u0148", "\\v{n}");
            	put("\u0150", "\\H{O}");
            	put("\u0151", "\\H{o}");
            	put("\u0152", "\\OE");
            	put("\u0153", "\\oe");
            	put("\u0154", "\\'R");
            	put("\u0155", "\\'r");
            	put("\u0156", "\\c{R}");
            	put("\u0157", "\\c{r}");
            	put("\u0158", "\\v{R}");
            	put("\u0159", "\\v{r}");
            	put("\u0160", "\\v{S}");
            	put("\u0161", "\\v{s}");
            	put("\u0162", "\\c{T}");
            	put("\u0163", "\\c{t}");
            	put("\u0164", "\\v{T}");
            	put("\u0165", "\\v{t}");
            	put("\u0166", "\\textTstroke");
            	put("\u0167", "\\texttstroke");
            	put("\u0168", "\\~U");
            	put("\u0169", "\\~u");
            	put("\u0170", "\\H{U}");
            	put("\u0171", "\\H{u}");
            	put("\u0172", "\\c{U}");
            	put("\u0173", "\\c{u}");
            	put("\u0174", "\\^W");
            	put("\u0175", "\\^w");
            	put("\u0176", "\\^Y");
            	put("\u0177", "\\^y");
            	put("\u0178", "\\\"Y");
            	put("\u0179", "\\'Z");
            	put("\u0180", "\\textcrb");
            	put("\u0181", "\\textBhook");
            	put("\u0186", "\\textOopen");
            	put("\u0187", "\\textChook");
            	put("\u0188", "\\texthtc");
            	put("\u0189", "\\textDafrican");
            	put("\u0190", "\\textEopen");
            	put("\u0191", "\\textFhook");
            	put("\u0192", "\\textflorin");
            	put("\u0194", "\\textGammaafrican");
            	put("\u0195", "\\hv");
            	put("\u0196", "\\textIotaafrican");
            	put("\u0198", "\\textKhook");
            	put("\u0199", "\\texthtk");
            	put("\u0237", "\\j");
            	put("\u0250", "\\textturna");
            	put("\u0251", "\\textscripta");
            	put("\u0252", "\\textturnscripta");
            	put("\u0253", "\\texthtb");
            	put("\u0254", "\\textopeno");
            	put("\u0255", "\\textctc");
            	put("\u0256", "\\textrtaild");
            	put("\u0257", "\\texthtd");
            	put("\u0258", "\\textreve");
            	put("\u0259", "\\textschwa");
            	put("\u0260", "\\texthtg");
            	put("\u0261", "\\textscriptg");
            	put("\u0262", "\\textscg");
            	put("\u0263", "\\textgamma");
            	put("\u0264", "\\textramshorns");
            	put("\u0265", "\\textturnh");
            	put("\u0266", "\\texthth");
            	put("\u0267", "\\texththeng");
            	put("\u0268", "\\textbari");
            	put("\u0269", "\\textiota");
            	put("\u0270", "\\textturnmrleg");
            	put("\u0271", "\\textltailm");
            	put("\u0272", "\\textnhookleft");
            	put("\u0273", "\\textrtailn");
            	put("\u0274", "\\textscn");
            	put("\u0275", "\\textbaro");
            	put("\u0276", "\\textscoelig");
            	put("\u0277", "\\textcloseomega");
            	put("\u0278", "\\textphi");
            	put("\u0279", "\\textturnr");
            	put("\u0280", "\\textscr");
            	put("\u0281", "\\textinvscr");
            	put("\u0282", "\\textrtails");
            	put("\u0283", "\\textesh");
            	put("\u0284", "\\texthtbardotlessj");
            	put("\u0285", "\\textraisevibyi");
            	put("\u0286", "\\textctesh");
            	put("\u0287", "\\textturnt");
            	put("\u0288", "\\texttretroflexhook");
            	put("\u0289", "\\textbaru");
            	put("\u0290", "\\textrtailz");
            	put("\u0291", "\\textctz");
            	put("\u0292", "\\textyogh");
            	put("\u0293", "\\textctyogh");
            	put("\u0294", "\\textglotstop");
            	put("\u0295", "\\textrevglotstop");
            	put("\u0296", "\\textinvglotstop");
            	put("\u0297", "\\textstretchc");
            	put("\u0298", "\\textbullseye");
            	put("\u0299", "\\textscb");
            	put("\u0300", "\\`{}");
            	put("\u0301", "\\'{}");
            	put("\u0302", "\\^{}");
            	put("\u0303", "\\~{}");
            	put("\u0304", "\\={}");
            	put("\u0306", "\\u{}");
            	put("\u0307", "\\.{}");
            	put("\u0308", "\\\"{}");
            	put("\u030A", "\\r");
            	put("\u0310", "\\textdotbreve{}");
            	put("\u0311", "\\t{}");
            	put("\u0312", "\\textturncommaabove");
            	put("\u0313", "\\textcommaabove");
            	put("\u0314", "\\textrevcommaabove");
            	put("\u0315", "\\textcommaabover");
            	put("\u0316", "\\textsubgrave{}");
            	put("\u0317", "\\textsubacute{}");
            	put("\u0318", "\\textadvancing{}");
            	put("\u0319", "\\textretracting{}");
            	put("\u0320", "\\textsubminus");
            	put("\u0321", "\\textpalhookbelow");
            	put("\u0322", "\\M");
            	put("\u0323", "\\d{}");
            	put("\u0324", "\\textsubumlaut{}");
            	put("\u0325", "\\textsubring{}");
            	put("\u0326", "\\textcommabelow{}");
            	put("\u0327", "\\c{}");
            	put("\u0328", "\\k{}");
            	put("\u0329", "\\textsyllabic{}");
            	put("\u0330", "\\textsubtilde{}");
            	put("\u0331", "\\b{}");
            	put("\u0333", "\\subdoublebar");
            	put("\u0334", "\\textsuperimposetilde");
            	put("\u0335", "\\B");
            	put("\u0336", "\\textlstrokethru");
            	put("\u0337", "\\textsstrikethru");
            	put("\u0338", "\\textlstrikethru");
            	put("\u0339", "\\textsubrhalfring");
            	put("\u0346", "\\overbridge");
            	put("\u0347", "\\subdoublebar");
            	put("\u0348", "\\subdoublevert");
            	put("\u0349", "\\subcorner");
            	put("\u0350", "\\textrightarrowhead");
            	put("\u0351", "\\textlefthalfring");
            	put("\u0354", "\\sublptr");
            	put("\u0355", "\\subrptr");
            	put("\u0356", "\\textrightuparrowhead");
            	put("\u0357", "\\textrighthalfring");
            	put("\u0360", "\\textdoubletilde");
            	put("\u0361", "\\texttoptiebar");
            	put("\u0362", "\\sliding");
            	put("\u0391", "$\\Alpha$");
            	put("\u0392", "$\\Beta$");
            	put("\u0393", "$\\Gamma$");
            	put("\u0394", "$\\Delta$");
            	put("\u0395", "$\\Epsilon$");
            	put("\u0396", "$\\Zeta$");
            	put("\u0397", "$\\Eta$");
            	put("\u0398", "$\\Theta$");
            	put("\u0399", "$\\Iota$");
            	put("\u203E", "\\textoverline"); 
            	put("\u20A1", "$\\textcolonmonetary$");
            	put("\u20A4", "$\\textlira$");
            	put("\u20A6", "$\\textnaira$");
            	put("\u20A9", "$\\textwon$");
            	put("\u20AB", "$\\textdong$");
            	put("\u20AC", "$\\euro$");
            	put("\u21CC", "$\\rightleftharpoons$");
            	put("\u21D2", "$\\Rightarrow$");
            	put("\u21D4", "$\\Leftrightarrow$");
            	put("\u22A0", "$\\boxtimes$");
            	put("\u22A1", "$\\boxdot$");
            	put("\u22A2", "$\\vdash$");
            	put("\u22A3", "$\\dashv$");
            	put("\u22A4", "$\\top$");
            	put("\u22A5", "$\\bot$");
            	put("\u22A9", "$\\Vdash$");
            	put("\u22AA", "$\\Vvdash$");
            	put("\u22AE", "$\\nVdash$");
            	put("\u22B2", "$\\lhd$");
            	put("\u22B3", "$\\rhd$");
            	put("\u22B4", "$\\unlhd$");
            	put("\u22B5", "$\\unrhd$");
            	put("\u22B8", "$\\multimap$");
            	put("\u22BA", "$\\intercal$");
            	put("\u22BB", "$\\veebar$");
            	put("\u22BC", "$\\barwedge$");
            	put("\u22C0", "$\\bigwedge$");
            	put("\u22C1", "$\\bigvee$");
            	put("\u22C2", "$\\bigcap$");
            	put("\u22C3", "$\\bigcup$");
            	put("\u22C4", "$\\diamond$");
            	put("\u22C5", "$\\cdot$");
            	put("\u22C6", "$\\star$");
            	put("\u22C7", "$\\divideontimes$");
            	put("\u22C8", "$\\bowtie$");
            	put("\u22C9", "$\\ltimes$");
            	put("\u22CA", "$\\rtimes$");
            	put("\u22CB", "$\\leftthreetimes$");
            	put("\u22CC", "$\\rightthreetimes$");
            	put("\u22CD", "$\\backsimeq$");
            	put("\u22CE", "$\\curlyvee$");
            	put("\u22CF", "$\\curlywedge$");
            	put("\u22D0", "$\\Subset$");
            	put("\u22D1", "$\\Supset$");
            	put("\u22D2", "$\\Cap$");
            	put("\u22D3", "$\\Cup$");
            	put("\u22D4", "$\\pitchfork$");
            	put("\u22D6", "$\\lessdot$");
            	put("\u22D7", "$\\gtrdot$");
            	put("\u22D8", "$\\lll$");
            	put("\u22D9", "$\\ggg$");
            	put("\u22DA", "$\\lesseqgtr$");
            	put("\u22DB", "$\\gtreqless$");
            	put("\u22DE", "$\\curlyeqprec$");
            	put("\u22DF", "$\\curlyeqsucc$");
            	put("\u22E0", "$\\preccurlyeq$");
            	put("\u22E1", "$\\succcurlyeq$");
            	put("\u22E2", "$\\sqsubseteq$");
            	put("\u22E3", "$\\sqsupseteq$");
            	put("\u22E6", "$\\lnsim$");
            	put("\u22E7", "$\\gnsim$");
            	put("\u22E8", "$\\precnsim$");
            	put("\u22E9", "$\\succnsim$");
            	put("\u22EA", "$\\ntriangleleft$");
            	put("\u22EB", "$\\ntriangleright$");
            	put("\u22EC", "$\\ntrianglelefteq$");
            	put("\u22ED", "$\\ntrianglerighteq$");
            	put("\u22EE", "$\\vdots$");
            	put("\u22EF", "$\\cdots$");
            	put("\u22F1", "$\\ddots$");
            	put("\u25A1", "$\\Box$");
            	put("\u27E8", "$\\langle$");
            	put("\u27E9", "$\\rangle$");
            	put("\u201A", "\\quotesinglbase");
            	put("\u201C", "\\textquotedblleft");
            	put("\u201D", "\\textquotedblright");
            	put("\u201E", "\\quotedblbase");
            	put("\u203A", "\\guilsinglright");
            	put("\u203B", "\\textreferencemark");
            	put("\u203D", "\\textinterrobang");
            	put("\u207A", "\\+");
            	put("\u207B", "\\-");
            	put("\u207C", "$^=$");
            	put("\u207D", "\\(");
            	put("\u207E", "\\)");
            	put("\u219D", "$\\leadsto$");
            	put("\u220B", "$\\ni$");
            	put("\u220C", "$\\ni$");
            	put("\u220F", "$\\prod$");
            	put("\u221A", "$\\surd$");
            	put("\u221D", "$\\propto$");
            	put("\u221E", "$\\infty$");
            	put("\u222A", "$\\cup$");
            	put("\u222B", "$\\int$");
            	put("\u222C", "$\\iint$");
            	put("\u222D", "$\\iiint$");
            	put("\u222E", "$\\oint$");
            	put("\u223C", "$\\sim$");
            	put("\u223D", "$\\backsim$");
            	put("\u224A", "$\\approxeq$");
            	put("\u224D", "$\\asymp$");
            	put("\u224E", "$\\Bumpeq$");
            	put("\u224F", "$\\bumpeq$");
            	put("\u225C", "$\\triangleq$");
            	put("\u226A", "$\\ll$");
            	put("\u226B", "$\\gg$");
            	put("\u226C", "$\\between$");
            	put("\u226D", "$\\asymp$");
            	put("\u226E", "$\\nless$");
            	put("\u226F", "$\\ngtr$");
            	put("\u227A", "$\\prec$");
            	put("\u227B", "$\\succ$");
            	put("\u227C", "$\\preccurlyeq$");
            	put("\u227D", "$\\succcurlyeq$");
            	put("\u227E", "$\\precsim$");
            	put("\u227F", "$\\succsim$");
            	put("\u228A", "$\\subsetneq$");
            	put("\u228B", "$\\supsetneq$");
            	put("\u228E", "$\\uplus$");
            	put("\u228F", "$\\sqsubset$");
            	put("\u229A", "$\\circledcirc$");
            	put("\u229B", "$\\circledast$");
            	put("\u229D", "$\\circleddash$");
            	put("\u229E", "$\\boxplus$");
            	put("\u229F", "$\\boxminus$");
            	put("\u230A", "$\\lfloor$");
            	put("\u230B", "$\\rfloor$");
            	put("\u266D", "$\\flat$");
            	put("\u266E", "$\\natural$");
            	put("\u266F", "$\\sharp$");
            	put("\u2010", "-");
            	put("\u2011", "-");
            	put("\u2012", "--");
            	put("\u2013", "--");
            	put("\u2014", "---");
            	put("\u2018", "\\textquoteleft");
            	put("\u2019", "\\textquoteright");
            	put("\u2020", "\\dag");
            	put("\u2021", "\\ddag");
            	put("\u2022", "\\mbox{$\\bullet$}");
            	put("\u2022", "\\textbullet");
            	put("\u2026", "\\ldots");
            	put("\u2030", "\\textperthousand");
            	put("\u2031", "\\textpertenthousand");
            	put("\u2039", "\\guilsinglleft");
            	put("\u2070", "$^0$");
            	put("\u2071", "\\i");
            	put("\u2074", "\\4");
            	put("\u2075", "\\5");
            	put("\u2076", "\\6");
            	put("\u2077", "\\7");
            	put("\u2078", "\\8");
            	put("\u2079", "\\9");
            	put("\u2116", "$\\textnumero$");
            	put("\u2120", "\\SM");
            	put("\u2122", "$\\texttrademark$");
            	put("\u2190", "$\\leftarrow$");
            	put("\u2191", "$\\uparrow$");
            	put("\u2192", "$\\rightarrow$");
            	put("\u2193", "$\\downarrow$");
            	put("\u2194", "$\\leftrightarrow$");
            	put("\u2195", "$\\updownarrow$");
            	put("\u2200", "$\\forall$");
            	put("\u2201", "$\\complement$");
            	put("\u2202", "$\\partial$");
            	put("\u2203", "$\\exists$");
            	put("\u2204", "$\\nexists$");
            	put("\u2205", "$\\set$");
            	put("\u2206", "$\\Delta$");
            	put("\u2207", "$\\nabla$");
            	put("\u2208", "$\\in$");
            	put("\u2209", "$\\notin$");
            	put("\u2210", "$\\coprod$");
            	put("\u2211", "$\\sum$");
            	put("\u2212", "\\textminus");
            	put("\u2213", "$\\mp$");
            	put("\u2214", "$\\dotplus$");
            	put("\u2216", "$\\setminus$");
            	put("\u2217", "$\\ast$");
            	put("\u2218", "$\\circ$");
            	put("\u2219", "$\\bullet$");
            	put("\u2220", "$\\angle$");
            	put("\u2221", "$\\measuredangle$");
            	put("\u2222", "$\\sphericalangle$");
            	put("\u2223", "$\\mid$");
            	put("\u2224", "$\\nmid$");
            	put("\u2225", "$\\parallel$");
            	put("\u2226", "$\\nparallel$");
            	put("\u2227", "$\\wedge$");
            	put("\u2228", "$\\vee$");
            	put("\u2229", "$\\cap$");
            	put("\u2234", "$\\therefore$");
            	put("\u2235", "$\\because$");
            	put("\u2240", "$\\wr$");
            	put("\u2241", "$\\nsim$");
            	put("\u2243", "$\\simeq$");
            	put("\u2244", "$\\simeq$");
            	put("\u2245", "$\\cong$");
            	put("\u2247", "$\\ncong$");
            	put("\u2248", "$\\approx$");
            	put("\u2249", "$\\approx$");
            	put("\u2250", "$\\doteq$");
            	put("\u2251", "$\\doteqdot$");
            	put("\u2252", "$\\fallingdotseq$");
            	put("\u2253", "$\\risingdotseq$");
            	put("\u2256", "$\\eqcirc$");
            	put("\u2257", "$\\circeq$");
            	put("\u2260", "$\\neq$");
            	put("\u2261", "$\\equiv$");
            	put("\u2262", "$\\equiv$");
            	put("\u2264", "$\\leq$");
            	put("\u2265", "$\\geq$");
            	put("\u2266", "$\\leqq$");
            	put("\u2267", "$\\geqq$");
            	put("\u2268", "$\\lneqq$");
            	put("\u2269", "$\\gneqq$");
            	put("\u2270", "$\\nleq$");
            	put("\u2271", "$\\ngeq$");
            	put("\u2272", "$\\lesssim$");
            	put("\u2273", "$\\gtrsim$");
            	put("\u2274", "$\\lesssim$");
            	put("\u2275", "$\\gtrsim$");
            	put("\u2276", "$\\lessgtr$");
            	put("\u2277", "$\\gtrless$");
            	put("\u2280", "$\\nprec$");
            	put("\u2281", "$\\nsucc$");
            	put("\u2282", "$\\subset$");
            	put("\u2283", "$\\supset$");
            	put("\u2284", "$\\subset$");
            	put("\u2285", "$\\supset$");
            	put("\u2286", "$\\subseteq$");
            	put("\u2287", "$\\supseteq$");
            	put("\u2288", "$\\nsubseteq$");
            	put("\u2289", "$\\nsupseteq$");
            	put("\u2290", "$\\sqsupset$");
            	put("\u2291", "$\\sqsubseteq$");
            	put("\u2292", "$\\sqsupseteq$");
            	put("\u2293", "$\\sqcap$");
            	put("\u2294", "$\\sqcup$");
            	put("\u2295", "$\\oplus$");
            	put("\u2296", "$\\ominus$");
            	put("\u2297", "$\\otimes$");
            	put("\u2298", "$\\oslash$");
            	put("\u2299", "$\\odot$");
            	put("\u2308", "$\\lceil$");
            	put("\u2309", "$\\rceil$");
            	put("\u2660", "$\\spadesuit$");
            	put("\u2661", "$\\heartsuit$");
            	put("\u2662", "$\\diamondsuit$");
            	put("\u2663", "$\\clubsuit$");
            }
        };  
        
    /**
     * Escapes UNICODE string with the BibTex entities
     * @param s 
     * @return escaped String
     */
    public static String texString(String str)
    {
        StringBuffer retstr = new StringBuffer();
        if ( str==null || "".equals(str.trim()) )
        {
        	return null;
        }
        int len = str.length();
        for (int i = 0; i < len; i++) {
           if (ENTITIES.containsKey(Character.toString(str.charAt(i)))) 
           {
               retstr.append(ENTITIES.get(Character.toString(str.charAt(i))));
           } 
           else 
           {
        	   retstr.append(str.charAt(i));
           }
        }
        return retstr.toString();
    }

    
}

