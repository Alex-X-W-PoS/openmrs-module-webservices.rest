/**
 * This Source Code Form is subject to the terms of the Mozilla Public License,
 * v. 2.0. If a copy of the MPL was not distributed with this file, You can
 * obtain one at http://mozilla.org/MPL/2.0/. OpenMRS is also distributed under
 * the terms of the Healthcare Disclaimer located at http://openmrs.org/license.
 *
 * Copyright (C) OpenMRS Inc. OpenMRS is a registered trademark and the OpenMRS
 * graphic logo is a trademark of OpenMRS Inc.
 */
package org.openmrs.module.webservices.rest.web.v1_0.resource.openmrs1_8;

import java.util.List;



public interface ItemHLBService extends OpenmrsService {
    
    public void setItemHLBDAO(ItemHLBDAO dao);
    
    public ItemHLB saveItemHLB(ItemHLB itemhlb) throws APIException;
    
    public ItemHLB getItemHLB(Integer itemHLBid) throws APIException;
    
    public ItemHLB getItemHLB(String nombre) throws APIException;
    
    public ItemHLB getItemHLBByUuid(String uuid) throws APIException;
    
    public List<ItemHLB> getAllItemHLBs() throws APIException;
    
    public List<ItemHLB> getItemHLBs(String nameFragment) throws APIException;
    
    public void purgeItemHLB(ItemHLB itemhlb) throws APIException;
    
}
