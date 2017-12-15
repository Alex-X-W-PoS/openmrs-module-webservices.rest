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



import org.openmrs.api.APIException;

import org.springframework.transaction.annotation.Transactional;

@Transactional
public class ItemHLBServiceImpl extends BaseOpenmrsService implements ItemHLBService {
    
    private ItemHLBDAO dao;
    
    @Override
    public void setItemHLBDAO(ItemHLBDAO dao) {
	this.dao = dao;
    }
    
    @Override
     public ItemHLB saveItemHLB(ItemHLB itemhlb) throws APIException {
        if (itemhlb.getNombre() == null) {
            throw new APIException("ItemHLB.name.required", (Object[]) null);
	}
        
        return dao.saveItemHLB(itemhlb);
    }
     
    @Override
    @Transactional(readOnly = true)
    public ItemHLB getItemHLB(Integer itemHLBid) throws APIException {
        return dao.getItemHLB(itemHLBid);
    }
    
    @Override
    @Transactional(readOnly = true)
    public ItemHLB getItemHLB(String nombre) throws APIException {
        return dao.getItemHLB(nombre);
    }
    
    @Override
    @Transactional(readOnly = true)
    public ItemHLB getItemHLBByUuid(String uuid) throws APIException {
        return dao.getItemHLBByUuid(uuid);
    }
    
    @Override
    @Transactional(readOnly = true)
    public List<ItemHLB> getAllItemHLBs() throws APIException {
        return dao.getAllItemHLBs();
    }
    
    @Override
    @Transactional(readOnly = true)
    public List<ItemHLB> getItemHLBs(String nameFragment) throws APIException {
        return dao.getItemHLBs(nameFragment);
    }
    
    @Override
    public void purgeItemHLB(ItemHLB itemhlb) throws APIException {
        return dao.deleteItemHLB(itemhlb);
    }
}
