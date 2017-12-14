/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.naturalfitness.models;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Abdellatif
 */
@Entity
@Table(name = "abonnement")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Abonnement.findAll", query = "SELECT a FROM Abonnement a")
    , @NamedQuery(name = "Abonnement.findById", query = "SELECT a FROM Abonnement a WHERE a.id = :id")
    , @NamedQuery(name = "Abonnement.findByIdAdherent", query = "SELECT a FROM Abonnement a WHERE a.idAdherent = :idAdherent")
    , @NamedQuery(name = "Abonnement.findByIdCours", query = "SELECT a FROM Abonnement a WHERE a.idCours = :idCours")
    , @NamedQuery(name = "Abonnement.findByDateDebut", query = "SELECT a FROM Abonnement a WHERE a.dateDebut = :dateDebut")
    , @NamedQuery(name = "Abonnement.findByDateFin", query = "SELECT a FROM Abonnement a WHERE a.dateFin = :dateFin")
    , @NamedQuery(name = "Abonnement.findByPrix", query = "SELECT a FROM Abonnement a WHERE a.prix = :prix")})
public class Abonnement implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id")
    private Integer id;
    @Column(name = "idAdherent")
    private Integer idAdherent;
    @Column(name = "idCours")
    private Integer idCours;
    @Column(name = "dateDebut")
    @Temporal(TemporalType.DATE)
    private Date dateDebut;
    @Column(name = "dateFin")
    @Temporal(TemporalType.DATE)
    private Date dateFin;
    @Column(name = "prix")
    private Integer prix;
    @JoinColumn(name = "id", referencedColumnName = "id", insertable = false, updatable = false)
    @OneToOne(optional = false, fetch = FetchType.EAGER)
    private Adherent adherent;
    @JoinColumn(name = "id", referencedColumnName = "id", insertable = false, updatable = false)
    @OneToOne(optional = false, fetch = FetchType.EAGER)
    private Cours cours;

    public Abonnement() {
    }

    public Abonnement(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getIdAdherent() {
        return idAdherent;
    }

    public void setIdAdherent(Integer idAdherent) {
        this.idAdherent = idAdherent;
    }

    public Integer getIdCours() {
        return idCours;
    }

    public void setIdCours(Integer idCours) {
        this.idCours = idCours;
    }

    public Date getDateDebut() {
        return dateDebut;
    }

    public void setDateDebut(Date dateDebut) {
        this.dateDebut = dateDebut;
    }

    public Date getDateFin() {
        return dateFin;
    }

    public void setDateFin(Date dateFin) {
        this.dateFin = dateFin;
    }

    public Integer getPrix() {
        return prix;
    }

    public void setPrix(Integer prix) {
        this.prix = prix;
    }

    public Adherent getAdherent() {
        return adherent;
    }

    public void setAdherent(Adherent adherent) {
        this.adherent = adherent;
    }

    public Cours getCours() {
        return cours;
    }

    public void setCours(Cours cours) {
        this.cours = cours;
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
        if (!(object instanceof Abonnement)) {
            return false;
        }
        Abonnement other = (Abonnement) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.naturalfitness.models.Abonnement[ id=" + id + " ]";
    }
    
}
