/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.io.Serializable;
import java.math.BigInteger;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author sebas
 */
@Entity
@Table(name = "direcciones")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Direcciones.findAll", query = "SELECT d FROM Direcciones d"),
    @NamedQuery(name = "Direcciones.findById", query = "SELECT d FROM Direcciones d WHERE d.id = :id"),
    @NamedQuery(name = "Direcciones.findByCalle", query = "SELECT d FROM Direcciones d WHERE d.calle = :calle"),
    @NamedQuery(name = "Direcciones.findByCiudad", query = "SELECT d FROM Direcciones d WHERE d.ciudad = :ciudad"),
    @NamedQuery(name = "Direcciones.findByCodigoPostal", query = "SELECT d FROM Direcciones d WHERE d.codigoPostal = :codigoPostal"),
    @NamedQuery(name = "Direcciones.findByColonia", query = "SELECT d FROM Direcciones d WHERE d.colonia = :colonia"),
    @NamedQuery(name = "Direcciones.findByEsPrincipal", query = "SELECT d FROM Direcciones d WHERE d.esPrincipal = :esPrincipal"),
    @NamedQuery(name = "Direcciones.findByEstado", query = "SELECT d FROM Direcciones d WHERE d.estado = :estado"),
    @NamedQuery(name = "Direcciones.findByNumeroExterior", query = "SELECT d FROM Direcciones d WHERE d.numeroExterior = :numeroExterior"),
    @NamedQuery(name = "Direcciones.findByNumeroInterior", query = "SELECT d FROM Direcciones d WHERE d.numeroInterior = :numeroInterior"),
    @NamedQuery(name = "Direcciones.findByReferencias", query = "SELECT d FROM Direcciones d WHERE d.referencias = :referencias"),
    @NamedQuery(name = "Direcciones.findByUsuarioId", query = "SELECT d FROM Direcciones d WHERE d.usuarioId = :usuarioId"),
    @NamedQuery(name = "Direcciones.findByTelefono", query = "SELECT d FROM Direcciones d WHERE d.telefono = :telefono")})
public class Direcciones implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "calle")
    private String calle;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "ciudad")
    private String ciudad;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "codigo_postal")
    private String codigoPostal;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "colonia")
    private String colonia;
    @Column(name = "es_principal")
    private Boolean esPrincipal;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "estado")
    private String estado;
    @Size(max = 255)
    @Column(name = "numero_exterior")
    private String numeroExterior;
    @Size(max = 255)
    @Column(name = "numero_interior")
    private String numeroInterior;
    @Size(max = 255)
    @Column(name = "referencias")
    private String referencias;
    @Column(name = "usuario_id")
    private BigInteger usuarioId;
    @Size(max = 255)
    @Column(name = "telefono")
    private String telefono;

    public Direcciones() {
    }

    public Direcciones(Long id) {
        this.id = id;
    }

    public Direcciones(Long id, String calle, String ciudad, String codigoPostal, String colonia, String estado) {
        this.id = id;
        this.calle = calle;
        this.ciudad = ciudad;
        this.codigoPostal = codigoPostal;
        this.colonia = colonia;
        this.estado = estado;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getCodigoPostal() {
        return codigoPostal;
    }

    public void setCodigoPostal(String codigoPostal) {
        this.codigoPostal = codigoPostal;
    }

    public String getColonia() {
        return colonia;
    }

    public void setColonia(String colonia) {
        this.colonia = colonia;
    }

    public Boolean getEsPrincipal() {
        return esPrincipal;
    }

    public void setEsPrincipal(Boolean esPrincipal) {
        this.esPrincipal = esPrincipal;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getNumeroExterior() {
        return numeroExterior;
    }

    public void setNumeroExterior(String numeroExterior) {
        this.numeroExterior = numeroExterior;
    }

    public String getNumeroInterior() {
        return numeroInterior;
    }

    public void setNumeroInterior(String numeroInterior) {
        this.numeroInterior = numeroInterior;
    }

    public String getReferencias() {
        return referencias;
    }

    public void setReferencias(String referencias) {
        this.referencias = referencias;
    }

    public BigInteger getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(BigInteger usuarioId) {
        this.usuarioId = usuarioId;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
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
        if (!(object instanceof Direcciones)) {
            return false;
        }
        Direcciones other = (Direcciones) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.Direcciones[ id=" + id + " ]";
    }
    
}
