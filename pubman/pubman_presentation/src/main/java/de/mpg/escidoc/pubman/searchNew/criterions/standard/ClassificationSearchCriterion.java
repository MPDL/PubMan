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
package de.mpg.escidoc.pubman.searchNew.criterions.standard;

import de.mpg.escidoc.pubman.searchNew.criterions.SearchCriterionBase.SearchCriterion;



public class ClassificationSearchCriterion extends StandardSearchCriterion {

	
	private String classificationType;
	
	public ClassificationSearchCriterion() {
		
	}

	@Override
	public String[] getCqlIndexes(Index indexName) {
		
		switch(indexName)
		{
			case ESCIDOC_ALL : return new String[] {"escidoc.publication.subject"};
			case ITEM_CONTAINER_ADMIN : return new String[] {"\"/md-records/md-record/publication/subject\""};
		}
		return null;
		
	}
	
	
	@Override
	public String toQueryString() {
		return getSearchCriterion().name() + "=\"" + escapeForQueryString(getClassificationType())  + "||" + escapeForQueryString(getSearchString()) + "\""; 
	}

	@Override
	public void parseQueryStringContent(String content) {
		
		
		setClassificationType(unescapeForQueryString(content.split("\\|\\|")[0]));
		setSearchString(unescapeForQueryString(content.split("\\|\\|")[1]));
	}

	public String getClassificationType() {
		return classificationType;
	}

	public void setClassificationType(String classificationType) {
		this.classificationType = classificationType;
	}
	
	/*
	@Override
	public SearchCriterion getSearchCriterion() {
		return SearchCriterion.CLASSIFICATION;
	}
	*/


	

}
