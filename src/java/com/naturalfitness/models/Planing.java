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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Abdellatif
 */
@Entity
@Table(name = "planing")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Planing.findAll", query = "SELECT p FROM Planing p")
    , @NamedQuery(name = "Planing.findById", query = "SELECT p FROM Planing p WHERE p.id = :id")
    , @NamedQuery(name = "Planing.findByIdCours", query = "SELECT p FROM Planing p WHERE p.idCours = :idCours")
    , @NamedQuery(name = "Planing.findByDatePlaning", query = "SELECT p FROM Planing p WHERE p.datePlaning = :datePlaning")
    , @NamedQuery(name = "Planing.findByHeureD", query = "SELECT p FROM Planing p WHERE p.heureD = :heureD")
    , @NamedQuery(name = "Planing.findByHeureF", query = "SELECT p FROM Planing p WHERE p.heureF = :heureF")})
public class Planing implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id")
    private Integer id;
    @Column(name = "idCours")
    private Integer idCours;
    @Column(name = "datePlaning")
    @Temporal(TemporalType.DATE)
    private Date datePlaning;
    @Size(max = 10)
    @Column(name = "heureD")
    private String heureD;
    @Size(max = 10)
    @Column(name = "heureF")
    private String heureF;
    @JoinColumn(name = "id", referencedColumnName = "id", insertable = false, updatable = false)
    @OneToOne(optional = false, fetch = FetchType.EAGER)
    private Cours cours;

    public Planing() {
    }

    public Planing(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getIdCours() {
        return idCours;
    }

    public void setIdCours(Integer idCours) {
        this.idCours = idCours;
    }

    public Date getDatePlaning() {
        return datePlaning;
    }

    public void setDatePlaning(Date datePlaning) {
        this.datePlaning = datePlaning;
    }

    public String getHeureD() {
        return heureD;
    }

    public void setHeureD(String heureD) {
        this.heureD = heureD;
    }

    public String getHeureF() {
        return heureF;
    }

    public void setHeureF(String heureF) {
        this.heureF = heureF;
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
        if (!(object instanceof Planing)) {
            return false;
        }
        Planing other = (Planing) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.naturalfitness.models.Planing[ id=" + id + " ]";
    }
    
}
