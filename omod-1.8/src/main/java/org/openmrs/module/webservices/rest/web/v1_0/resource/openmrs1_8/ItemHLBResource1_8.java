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

import io.swagger.models.Model;
import io.swagger.models.ModelImpl;
import io.swagger.models.properties.StringProperty;
import org.openmrs.module.webservices.rest.web.RequestContext;
import org.openmrs.module.webservices.rest.web.RestConstants;
import org.openmrs.module.webservices.rest.web.annotation.Resource;
import org.openmrs.module.webservices.rest.web.representation.DefaultRepresentation;
import org.openmrs.module.webservices.rest.web.representation.FullRepresentation;
import org.openmrs.module.webservices.rest.web.representation.Representation;
import org.openmrs.module.webservices.rest.web.resource.api.PageableResult;
import org.openmrs.module.webservices.rest.web.resource.impl.DelegatingCrudResource;
import org.openmrs.module.webservices.rest.web.resource.impl.DelegatingResourceDescription;
import org.openmrs.module.webservices.rest.web.resource.impl.MetadataDelegatingCrudResource;
import org.openmrs.module.webservices.rest.web.resource.impl.NeedsPaging;
import org.openmrs.module.webservices.rest.web.response.ResponseException;

/**
 * {@link Resource} for {@link Location}, supporting standard CRUD operations
 */
@Resource(name = RestConstants.VERSION_1 + "/itemhlb", supportedClass = ItemHLB.class, supportedOpenmrsVersions = "1.8.*")
public class ItemHLBResource1_8 extends MetadataDelegatingCrudResource<ItemHLB> {
	
	/**
	 * @see DelegatingCrudResource#getRepresentationDescription(Representation)
	 */
	@Override
	public DelegatingResourceDescription getRepresentationDescription(Representation rep) {
		if (rep instanceof DefaultRepresentation) {
			DelegatingResourceDescription description = new DelegatingResourceDescription();
			description.addProperty("uuid");
			description.addProperty("nombre");
			description.addProperty("codigoItem");
			description.addProperty("linea");
			description.addProperty("unidadMedida");
			description.addProperty("codigoSector");
			description.addProperty("cantidadMinimaStock");
			description.addProperty("conIVA");
			description.addLink("full", ".?v=" + RestConstants.REPRESENTATION_FULL);
			return description;
		} else if (rep instanceof FullRepresentation) {
			DelegatingResourceDescription description = new DelegatingResourceDescription();
			description.addProperty("uuid");
			description.addProperty("nombre");
			description.addProperty("codigoItem");
			description.addProperty("linea");
			description.addProperty("unidadMedida");
			description.addProperty("codigoSector");
			description.addProperty("cantidadMinimaStock");
			description.addProperty("conIVA");
			description.addSelfLink();
			return description;
		}
		return null;
	}
	
	/**
	 * @see org.openmrs.module.webservices.rest.web.resource.impl.BaseDelegatingResource#getCreatableProperties()
	 */
	@Override
	public DelegatingResourceDescription getCreatableProperties() {
		DelegatingResourceDescription description = new DelegatingResourceDescription();
		
		description.addRequiredProperty("nombre");
		
		description.addProperty("codigoItem");
		description.addProperty("linea");
		description.addProperty("unidadMedida");
		description.addProperty("codigoSector");
		description.addProperty("cantidadMinimaStock");
		description.addProperty("conIVA");
		
		return description;
	}
	
	/**
	 * @see org.openmrs.module.webservices.rest.web.resource.impl.BaseDelegatingResource#getUpdatableProperties()
	 */
	@Override
	public DelegatingResourceDescription getUpdatableProperties() {
		return getCreatableProperties();
	}
	
	@Override
	public Model getGETModel(Representation rep) {
		ModelImpl modelImpl = (ModelImpl) super.getGETModel(rep);
		if (rep instanceof DefaultRepresentation || rep instanceof FullRepresentation) {
			modelImpl
			        .property("codigoItem", new StringProperty())
			        .property("linea", new StringProperty())
			        .property("unidadMedida", new StringProperty())
			        .property("codigoSector", new StringProperty())
			        .property("cantidadMinimaStock", new IntegerProperty())
			        .property("conIVA", new BooleanProperty());
		}
		return modelImpl;
	}
	
	@Override
	public Model getCREATEModel(Representation rep) {
		return ((ModelImpl) super.getCREATEModel(rep))
		        .property("codigoItem", new StringProperty())
		        .property("linea", new StringProperty())
		        .property("unidadMedida", new StringProperty())
		        .property("codigoSector", new StringProperty())
		        .property("cantidadMinimaStock", new IntegerProperty())
		        .property("conIVA", new BooleanProperty());
	}
	
	@Override
	public Model getUPDATEModel(Representation rep) {
		return getCREATEModel(rep);
	}
	
	/**
	 * @see DelegatingCrudResource#newDelegate()
	 */
	@Override
	public ItemHLB newDelegate() {
		return new ItemHLB();
	}
	
	/**
	 * @see DelegatingCrudResource#save(java.lang.Object)
	 */
	@Override
	public ItemHLB save(ItemHLB itemhlb) {
		return Context.getItemHLBService().saveItemHLB(itemhlb);
	}
	
	/**
	 * Fetches a location by uuid, if no match is found, it tries to look up one with a matching
	 * name with the assumption that the passed parameter is a location name
	 * 
	 * @see DelegatingCrudResource#getByUniqueId(java.lang.String)
	 */
	@Override
	public ItemHLB getByUniqueId(String uuid) {
		ItemHLB itemhlb = Context.getItemHLBService().getItemHLBByUuid(uuid);
		//We assume the caller was fetching by name
		if (itemhlb == null)
			itemhlb = Context.getItemHLBService().getItemHLB(uuid);
		
		return itemhlb;
	}
	
	/**
	 * @see org.openmrs.module.webservices.rest.web.resource.impl.DelegatingCrudResource#purge(java.lang.Object,
	 *      org.openmrs.module.webservices.rest.web.RequestContext)
	 */
	@Override
	public void purge(ItemHLB itemhlb, RequestContext context) throws ResponseException {
		if (itemhlb == null)
			return;
		Context.getItemHLBService().purgeItemHLB(itemhlb);
	}
	
	/**
	 * @see org.openmrs.module.webservices.rest.web.resource.impl.DelegatingCrudResource#doGetAll(org.openmrs.module.webservices.rest.web.RequestContext)
	 */
	@Override
	protected NeedsPaging<ItemHLB> doGetAll(RequestContext context) {
		return new NeedsPaging<ItemHLB>(Context.getItemHLBService().getAllItemHLBs(context.getIncludeAll()), context);
	}
	
	/**
	 * @see org.openmrs.module.webservices.rest.web.resource.impl.DelegatingCrudResource#doSearch(org.openmrs.module.webservices.rest.web.RequestContext)
	 *      A query string and/or a tag uuid can be passed in; if both are passed in, returns an
	 *      intersection of the results; excludes retired locations
	 */
	@Override
	protected PageableResult doSearch(RequestContext context) {
		
		ItemHLBService itemhlbService = Context.getItemHLBService();
		
		String query = context.getParameter("q");
		
		List<ItemHLB> itemhlbsByQuery = null;
		
		if (query != null) {
			itemhlbsByQuery = itemhlbService.getItemHLBs(query);
		}
		
		return new NeedsPaging<ItemHLB>(itemhlbsByQuery, context);
	}
}
