/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkgDatosWeb;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Usuario
 */
@Entity
@Table(name = "activ_participantes")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ActivParticipantes.findAll", query = "SELECT a FROM ActivParticipantes a")
    , @NamedQuery(name = "ActivParticipantes.findById", query = "SELECT a FROM ActivParticipantes a WHERE a.id = :id")})
public class ActivParticipantes implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "Id")
    private Integer id;
    @JoinColumn(name = "IdActividad", referencedColumnName = "Id")
    @ManyToOne(optional = false)
    private Actividades idActividad;
    @JoinColumn(name = "IdParticipante", referencedColumnName = "Id")
    @ManyToOne(optional = false)
    private Participantes idParticipante;

    public ActivParticipantes() {
    }

    public ActivParticipantes(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Actividades getIdActividad() {
        return idActividad;
    }

    public void setIdActividad(Actividades idActividad) {
        this.idActividad = idActividad;
    }

    public Participantes getIdParticipante() {
        return idParticipante;
    }

    public void setIdParticipante(Participantes idParticipante) {
        this.idParticipante = idParticipante;
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
        if (!(object instanceof ActivParticipantes)) {
            return false;
        }
        ActivParticipantes other = (ActivParticipantes) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pkgDatosWeb.ActivParticipantes[ id=" + id + " ]";
    }
    
}
