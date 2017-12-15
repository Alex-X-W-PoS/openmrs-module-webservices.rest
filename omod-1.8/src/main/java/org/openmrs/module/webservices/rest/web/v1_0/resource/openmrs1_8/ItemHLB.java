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

import org.openmrs;

public class ItemHLB extends BaseOpenmrsObject {
    
    public static final long serialVersionUID = 75844L; 
    
    private Integer itemHLBid;
    
    private String nombre;
    
    private String codigoItem;
    
    private String linea;
    
    private String unidadMedida;
    
    private String codigoSector;
    
    private Integer cantidadMinimaStock;
    
    private boolean conIVA;
    
    public ItemHLB(){
        
    }
    
    public ItemHLB (Integer itemHLBid){
        this.itemHLBid = itemHLBid;
    }

    public Integer getItemHLBid() {
        return itemHLBid;
    }

    public void setItemHLBid(Integer itemHLBid) {
        this.itemHLBid = itemHLBid;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCodigoItem() {
        return codigoItem;
    }

    public void setCodigoItem(String codigoItem) {
        this.codigoItem = codigoItem;
    }

    public String getLinea() {
        return linea;
    }

    public void setLínea(String linea) {
        this.linea = linea;
    }

    public String getUnidadMedida() {
        return unidadMedida;
    }

    public void setUnidadMedida(String unidadMedida) {
        this.unidadMedida = unidadMedida;
    }

    public String getCodigoSector() {
        return codigoSector;
    }

    public void setCodigoSector(String codigoSector) {
        this.codigoSector = codigoSector;
    }

    public Integer getCantidadMinimaStock() {
        return cantidadMinimaStock;
    }

    public void setCantidadMinimaStock(Integer cantidadMinimaStock) {
        this.cantidadMinimaStock = cantidadMinimaStock;
    }

    public boolean isConIVA() {
        return conIVA;
    }

    public void setConIVA(boolean conIVA) {
        this.conIVA = conIVA;
    }
    
    @Override
    public Integer getId() {
        throw new UnsupportedOperationException();
    }

    @Override
    public void setId(Integer id) {
        throw new UnsupportedOperationException();
    }
    
}