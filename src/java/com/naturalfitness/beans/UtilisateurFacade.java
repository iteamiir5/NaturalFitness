/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.naturalfitness.beans;

import com.naturalfitness.models.Utilisateur;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Abdellatif
 */
@Stateless
public class UtilisateurFacade extends AbstractFacade<Utilisateur> {

    @PersistenceContext(unitName = "NaturalFitnessPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public UtilisateurFacade() {
        super(Utilisateur.class);
    }
    
}
