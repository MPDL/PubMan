<?xml version="1.0" encoding="UTF-8"?>
<!--

 CDDL HEADER START

 The contents of this file are subject to the terms of the
 Common Development and Distribution License, Version 1.0 only
 (the "License"). You may not use this file except in compliance
 with the License.

 You can obtain a copy of the license at license/ESCIDOC.LICENSE
 or http://www.escidoc.de/license.
 See the License for the specific language governing permissions
 and limitations under the License.

 When distributing Covered Code, include this CDDL HEADER in each
 file and include the License file at license/ESCIDOC.LICENSE.
 If applicable, add the following below this CDDL HEADER, with the
 fields enclosed by brackets "[]" replaced with your own identifying
 information: Portions Copyright [yyyy] [name of copyright owner]

 CDDL HEADER END


 Copyright 2006-2011 Fachinformationszentrum Karlsruhe Gesellschaft
 für wissenschaftlich-technische Information mbH and Max-Planck-
 Gesellschaft zur Förderung der Wissenschaft e.V.
 All rights reserved. Use is subject to license terms.
-->
<jsp:root version="2.1" xmlns:f="http://java.sun.com/jsf/core" xmlns:h="http://java.sun.com/jsf/html" xmlns:jsp="http://java.sun.com/JSP/Page" xmlns:tr="http://myfaces.apache.org/trinidad">

	<jsp:output doctype-root-element="html"
	       doctype-public="-//W3C//DTD XHTML 1.0 Transitional//EN"
	       doctype-system="http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd" /> 

	<jsp:directive.page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"/>
	<f:view locale="#{InternationalizationHelper.userLocale}">
			<f:loadBundle var="lbl" basename="Label"/>
			<f:loadBundle var="msg" basename="Messages"/>
			<f:loadBundle var="tip" basename="Tooltip"/>
		<html xmlns="http://www.w3.org/1999/xhtml">
			<head>

				<title><h:outputText value="#{ApplicationBean.appTitle}"/></title>

				<jsp:directive.include file="header/ui/StandardImports.jspf" />


			</head>
			<body lang="#{InternationalizationHelper.locale}">
			<h:outputText value="#{LocalTagsPage.beanName}" styleClass="noDisplay" />
			<tr:form usesUpload="true">
			<div class="full wrapper">
			<h:inputHidden id="offset"></h:inputHidden>
			
				<jsp:directive.include file="header/Header.jspf" />

				<div id="content" class="full_area0 clear">
				<!-- begin: content section (including elements that visualy belong to the header (breadcrumb, headline, subheader and content menu)) -->
					<div class="clear">
						<div class="headerSection">
							
						<jsp:directive.include file="header/Breadcrumb.jspf" />
				
							<div id="contentSkipLinkAnchor" class="clear headLine">
								<!-- Headline starts here -->
								<h1><h:outputText value="#{lbl.ViewItemPage}" /></h1>
								<!-- Headline ends here -->
							</div>
						</div>
						<div class="small_marginLIncl subHeaderSection">
							<div class="contentMenu">
							<!-- content menu starts here -->
								<div class="free_area0 sub">
								<!-- content menu lower line starts here -->										
									<!--<h:commandLink id="lnkEditLocalTags" action="loadEditLocalTags" value="#{lbl.actionMenu_lnkEditLocalTags}" rendered="#{!ViewItemFull.isStateWithdrawn and ViewItemFull.isStateReleased and ViewItemFull.isLatestRelease and !ViewItemFull.isCreateNewRevisionDisabled and ViewItemFull.isDepositor}"/> -->
										<!-- Rendering condition for edit local tag:								
											- NOT state withdrawn
											AND
											- item version is latest version
											AND
											(
												- user is moderator AND item is in state Released OR Submitted
											 	OR
											 	- user is owner AND item is in state pending OR in-revision
											)
										-->
								<!-- content menu lower line ends here -->
								</div>
							<!-- content menu ends here -->
							</div>
							<div class="subHeader">
								<!-- Subheadline starts here -->
									&#160;
								<!-- Subheadline ends here -->
							</div>
						</div>
					</div>			
					<div class="full_area0">
						<div class="full_area0 fullItem">
							<div class="full_area0 fullItemControls">
								<span class="full_area0_p5 underRework">
									<h:panelGroup styleClass="seperator" />
									<h:outputLink id="lnkViewLocalTagsPageLocalTags" styleClass="free_area0 actual" value="#contentSkipLinkAnchor">
										<h:outputText value="#{lbl.ViewItemFull_lblSubHeaderLocalTags}" />
									</h:outputLink>
									<h:panelGroup styleClass="seperator" rendered="#{ViewItemFull.hasAudience}"/>
									<h:commandLink id="lnkViewLocalTagsPageAudience" styleClass="free_area0" action="#{AudienceBean.manageAudience}" rendered="#{ViewItemFull.hasAudience}">
										<h:outputText value="#{lbl.AudiencePage}" />
									</h:commandLink>
									<h:panelGroup styleClass="seperator" rendered="false"/>
									<h:outputLink id="lnkViewLocalCollaborator" styleClass="free_area0" value="#{ApplicationBean.appContext}CollaboratorPage.jsp" rendered="false">
										<h:outputText value="#{lbl.CollaboratorPage}" />
									</h:outputLink>
									<h:panelGroup styleClass="seperator" rendered="#{ViewItemFull.isLatestVersion and !ViewItemFull.isStateWithdrawn and ViewItemFull.isLoggedIn and (ViewItemFull.isOwner || ViewItemFull.isModerator)}" />
									<h:commandLink id="lnkViewLocalLog" styleClass="free_area0" action="#{ViewItemFull.showItemLog}" rendered="#{ViewItemFull.isLatestVersion and !ViewItemFull.isStateWithdrawn and ViewItemFull.isLoggedIn and (ViewItemFull.isOwner || ViewItemFull.isModerator)}">
										<h:outputText value="#{lbl.ViewItemLogPage}"/>
									</h:commandLink>
									<h:panelGroup styleClass="seperator" rendered="#{ViewItemFull.isLatestRelease and !ViewItemFull.isStateWithdrawn}" />
									<h:commandLink id="lnkViewLocalStatistics" styleClass="free_area0" action="#{ViewItemFull.showStatistics}" rendered="#{ViewItemFull.isLatestRelease and !ViewItemFull.isStateWithdrawn}">
										<h:outputText value="#{lbl.ViewItemFull_btnItemStatistics}"/>
									</h:commandLink>
									<h:panelGroup styleClass="seperator" rendered="#{ViewItemFull.isLatestRelease and !ViewItemFull.isStateWithdrawn}" />
									<h:commandLink id="lnkViewLocalRevisions" styleClass="free_area0" action="#{ViewItemFull.showRevisions}" rendered="#{ViewItemFull.isLatestRelease and !ViewItemFull.isStateWithdrawn}">
										<h:outputText value="#{lbl.ViewItemFull_btnItemRevisions}"/>
									</h:commandLink>
									<h:panelGroup styleClass="seperator" rendered="#{(!ViewItemFull.isStateWithdrawn and ViewItemFull.isLatestRelease) || (ViewItemFull.isStateWithdrawn and ViewItemFull.pubItem.version.versionNumber > 1) }" />
									<h:commandLink id="lnkViewLocalVersions" styleClass="free_area0" action="#{ViewItemFull.showReleaseHistory}" rendered="#{(!ViewItemFull.isStateWithdrawn and ViewItemFull.isLatestRelease) || (ViewItemFull.isStateWithdrawn and ViewItemFull.pubItem.version.versionNumber > 1) }">
										<h:outputText value="#{lbl.ViewItemFull_btnItemVersions}"/>
									</h:commandLink>
									<h:panelGroup styleClass="seperator" />
									<h:outputLink id="lnkViewLocalUrl" styleClass="free_area0" value="#{ViewItemFull.citationURL}">
										<h:outputText value="#{lbl.ViewItemFull_btnItemView}"/>
									</h:outputLink>
									<h:panelGroup styleClass="seperator" />
								</span>
							</div>
							<div class="full_area0 itemHeader">
								<h:panelGroup styleClass="xLarge_area0 endline" >
									&#160;
								</h:panelGroup>
									<h:panelGroup styleClass="seperator" />
								<h:panelGroup styleClass="free_area0_p8 endline itemHeadline">
									<b><h:outputText value="#{ViewItemFull.pubItem.metadata.title.value}" converter="HTMLSubSupConverter" escape="false"/></b>
								</h:panelGroup>	
								<h:panelGroup layout="block" styleClass="medium_area0_p4 statusArea" >
									<h:panelGroup styleClass="big_imgArea xSmall_marginLExcl withdrawnItem" rendered="#{ViewItemFull.isStateWithdrawn}" />
									<h:panelGroup styleClass="big_imgArea xSmall_marginLExcl pendingItem" rendered="#{ViewItemFull.isStatePending}" />
									<h:panelGroup styleClass="big_imgArea xSmall_marginLExcl submittedItem" rendered="#{ViewItemFull.isStateSubmitted}" />
									<h:panelGroup styleClass="big_imgArea xSmall_marginLExcl releasedItem" rendered="#{ViewItemFull.isStateReleased and !ViewItemFull.isStateWithdrawn}" />
									<h:panelGroup styleClass="big_imgArea xSmall_marginLExcl inRevisionItem" rendered="#{ViewItemFull.isStateInRevision}" />
									<h:outputText styleClass="noDisplay" value="Item is " />
									<h:outputLabel id="lblViewLocalPublicState" styleClass="medium_label endline" style="text-align: center;" rendered="#{ViewItemFull.isStateWithdrawn}">
										<h:outputText value="#{ViewItemFull.itemPublicState}" />
									</h:outputLabel>
									<h:outputLabel id="lblViewLocalItemState" styleClass="medium_label endline" style="text-align: center;" rendered="#{!ViewItemFull.isStateWithdrawn}">
										<h:outputText value="#{ViewItemFull.itemState}" />
									</h:outputLabel>
								</h:panelGroup>
							</div>

							<jsp:directive.include file="localTags/ViewLocalTags.jspf" />

						</div>

					</div>
				<!-- end: content section -->
				</div>
			</div>
			<jsp:directive.include file="footer/Footer.jspf" />
			</tr:form>
			<script type="text/javascript">
				$("input[id$='offset']").submit(function() {
					$(this).val($(window).scrollTop());
				});
				$(document).ready(function () {
					$(window).scrollTop($("input[id$='offset']").val());
					$(window).scroll(function(){$("input[id$='offset']").val($(window).scrollTop());});
				});
			</script>
			</body>
		</html>
	</f:view>
</jsp:root>