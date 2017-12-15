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

import org.apache.commons.lang.StringUtils;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;


public class HibernateItemHLBDAO implements ItemHLBDAO {
    
    private SessionFactory sessionFactory;
    
    @Override
    public void setSessionFactory(SessionFactory sessionFactory) {
	this.sessionFactory = sessionFactory;
    }
    
    @Override
    public ItemHLB saveItemHLB(ItemHLB itemhlb) {
        sessionFactory.getCurrentSession().saveOrUpdate(itemhlb);
        return itemhlb;
    }
    
    @Override
    public ItemHLB getItemHLB(Integer itemHLBid) {
        return (ItemHLB) sessionFactory.getCurrentSession().get(ItemHLB.class, itemHLBid);
    }
    
    @Override
    @SuppressWarnings("unchecked")
    public ItemHLB getItemHLB(String nombre){
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(ItemHLB.class).add(Restrictions.eq("nombre", nombre));
        List<ItemHLB> itemHLBs = criteria.list();
		if (null == itemHLBs || itemHLBs.isEmpty()) {
			return null;
		}
		return itemHLBs.get(0);
    }
    
    @Override
    @SuppressWarnings("unchecked")
    public List<ItemHLB> getAllItemHLBs() {
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(ItemHLB.class);
		criteria.addOrder(Order.asc("nombre"));
		return criteria.list();
    }
    
    @Override
    public void deleteItemHLB(ItemHLB itemhlb) {
	sessionFactory.getCurrentSession().delete(itemhlb);
    }
    
    @Override
    public ItemHLB getItemHLBByUuid(String uuid) {
	return (ItemHLB) sessionFactory.getCurrentSession().createQuery("from ItemHLB l where l.uuid = :uuid").setString(
		    "uuid", uuid).uniqueResult();
    }
    
    @Override
	public List<ItemHLB> getItemHLBs(String nameFragment) {
		
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(ItemHLB.class);
		
		if (StringUtils.isNotBlank(nameFragment)) {
			criteria.add(Restrictions.ilike("nombre", nameFragment, MatchMode.START));
		}
		criteria.addOrder(Order.asc("nombre"));
		return criteria.list();
	}
}
