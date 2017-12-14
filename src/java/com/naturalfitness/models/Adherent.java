/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.naturalfitness.models;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Abdellatif
 */
@Entity
@Table(name = "adherent")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Adherent.findAll", query = "SELECT a FROM Adherent a")
    , @NamedQuery(name = "Adherent.findById", query = "SELECT a FROM Adherent a WHERE a.id = :id")
    , @NamedQuery(name = "Adherent.findByCin", query = "SELECT a FROM Adherent a WHERE a.cin = :cin")
    , @NamedQuery(name = "Adherent.findBySexe", query = "SELECT a FROM Adherent a WHERE a.sexe = :sexe")
    , @NamedQuery(name = "Adherent.findByDateNaissance", query = "SELECT a FROM Adherent a WHERE a.dateNaissance = :dateNaissance")})
public class Adherent implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id")
    private Integer id;
    @Size(max = 50)
    @Column(name = "cin")
    private String cin;
    @Size(max = 50)
    @Column(name = "sexe")
    private String sexe;
    @Column(name = "dateNaissance")
    @Temporal(TemporalType.DATE)
    private Date dateNaissance;
    @JoinColumn(name = "id", referencedColumnName = "id", insertable = false, updatable = false)
    @OneToOne(optional = false, fetch = FetchType.EAGER)
    private Utilisateur utilisateur;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "adherent", fetch = FetchType.EAGER)
    private Abonnement abonnement;

    public Adherent() {
    }

    public Adherent(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCin() {
        return cin;
    }

    public void setCin(String cin) {
        this.cin = cin;
    }

    public String getSexe() {
        return sexe;
    }

    public void setSexe(String sexe) {
        this.sexe = sexe;
    }

    public Date getDateNaissance() {
        return dateNaissance;
    }

    public void setDateNaissance(Date dateNaissance) {
        this.dateNaissance = dateNaissance;
    }

    public Utilisateur getUtilisateur() {
        return utilisateur;
    }

    public void setUtilisateur(Utilisateur utilisateur) {
        this.utilisateur = utilisateur;
    }

    public Abonnement getAbonnement() {
        return abonnement;
    }

    public void setAbonnement(Abonnement abonnement) {
        this.abonnement = abonnement;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Adherent)) {
            return false;
        }
        Adherent other = (Adherent) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.naturalfitness.models.Adherent[ id=" + id + " ]";
    }
    
}
