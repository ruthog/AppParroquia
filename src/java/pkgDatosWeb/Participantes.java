/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkgDatosWeb;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Usuario
 */
@Entity
@Table(name = "participantes")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Participantes.findAll", query = "SELECT p FROM Participantes p")
    , @NamedQuery(name = "Participantes.findById", query = "SELECT p FROM Participantes p WHERE p.id = :id")
    , @NamedQuery(name = "Participantes.findByNombre", query = "SELECT p FROM Participantes p WHERE p.nombre = :nombre")
    , @NamedQuery(name = "Participantes.findByApellido1", query = "SELECT p FROM Participantes p WHERE p.apellido1 = :apellido1")
    , @NamedQuery(name = "Participantes.findByApellido2", query = "SELECT p FROM Participantes p WHERE p.apellido2 = :apellido2")
    , @NamedQuery(name = "Participantes.findByEdad", query = "SELECT p FROM Participantes p WHERE p.edad = :edad")
    , @NamedQuery(name = "Participantes.findByEmail", query = "SELECT p FROM Participantes p WHERE p.email = :email")
    , @NamedQuery(name = "Participantes.findByTelefono", query = "SELECT p FROM Participantes p WHERE p.telefono = :telefono")
    , @NamedQuery(name = "Participantes.findByMovil", query = "SELECT p FROM Participantes p WHERE p.movil = :movil")
    , @NamedQuery(name = "Participantes.findByUsuario", query = "SELECT p FROM Participantes p WHERE p.usuario = :usuario")
    , @NamedQuery(name = "Participantes.findByPassword", query = "SELECT p FROM Participantes p WHERE p.password = :password")})
public class Participantes implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "Id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "Nombre")
    private String nombre;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "Apellido_1")
    private String apellido1;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "Apellido_2")
    private String apellido2;
    @Column(name = "Edad")
    private Integer edad;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Size(max = 45)
    @Column(name = "Email")
    private String email;
    @Size(max = 9)
    @Column(name = "Telefono")
    private String telefono;
    @Size(max = 9)
    @Column(name = "Movil")
    private String movil;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "Usuario")
    private String usuario;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "Password")
    private String password;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idParticipante")
    private Collection<ActivParticipantes> activParticipantesCollection;

    public Participantes() {
    }

    public Participantes(Integer id) {
        this.id = id;
    }

    public Participantes(Integer id, String nombre, String apellido1, String apellido2, String usuario, String password) {
        this.id = id;
        this.nombre = nombre;
        this.apellido1 = apellido1;
        this.apellido2 = apellido2;
        this.usuario = usuario;
        this.password = password;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido1() {
        return apellido1;
    }

    public void setApellido1(String apellido1) {
        this.apellido1 = apellido1;
    }

    public String getApellido2() {
        return apellido2;
    }

    public void setApellido2(String apellido2) {
        this.apellido2 = apellido2;
    }

    public Integer getEdad() {
        return edad;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getMovil() {
        return movil;
    }

    public void setMovil(String movil) {
        this.movil = movil;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @XmlTransient
    public Collection<ActivParticipantes> getActivParticipantesCollection() {
        return activParticipantesCollection;
    }

    public void setActivParticipantesCollection(Collection<ActivParticipantes> activParticipantesCollection) {
        this.activParticipantesCollection = activParticipantesCollection;
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
        if (!(object instanceof Participantes)) {
            return false;
        }
        Participantes other = (Participantes) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pkgDatosWeb.Participantes[ id=" + id + " ]";
    }
    
}
