/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.naturalfitness.beans;

import com.naturalfitness.models.Secretaire;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Abdellatif
 */
@Stateless
public class SecretaireFacade extends AbstractFacade<Secretaire> {

    @PersistenceContext(unitName = "NaturalFitnessPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public SecretaireFacade() {
        super(Secretaire.class);
    }
    
}
