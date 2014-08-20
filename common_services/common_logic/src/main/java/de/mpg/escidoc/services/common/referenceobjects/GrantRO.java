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

package de.mpg.escidoc.services.common.referenceobjects;


/**
 * The class for Grant references.
 * 
 * 
 * 
 */
public class GrantRO extends ReferenceObject implements Cloneable
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
    private static final long serialVersionUID = 1L;

    /**
     * Creates a new instance.
     */
    public GrantRO()
    {
        super();
    }

    /**
     * Copy constructor.
     * 
     * @author Thomas Diebaecker
     * @param other The instance to copy.
     */
    public GrantRO(GrantRO other)
    {
        super(other);
    }
    
    /**
     * {@inheritDoc}
     * @author Thomas Diebaecker
     */
    @Override
    public Object clone()
    {
        return new GrantRO(this);
    }

    /**
     * Helper method for JiBX transformations. This method helps JiBX to determine if this is a 'create' or an 'update'
     * transformation.
     * 
     * @return boolean true if the reference of this AffiliationVO is set
     */
    public boolean alreadyExistsInFramework()
    {
        return (getObjectId() != null);
    }

    /**
     * Creates a new instance with the given objectId.
     * 
     * @param objectId The id of the object.
     */
    public GrantRO(String objectId)
    {
        super(objectId);
    }

}