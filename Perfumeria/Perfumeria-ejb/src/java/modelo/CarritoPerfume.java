/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

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
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author sebas
 */
@Entity
@Table(name = "carrito_perfume")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CarritoPerfume.findAll", query = "SELECT c FROM CarritoPerfume c"),
    @NamedQuery(name = "CarritoPerfume.findById", query = "SELECT c FROM CarritoPerfume c WHERE c.id = :id"),
    @NamedQuery(name = "CarritoPerfume.findByCantidad", query = "SELECT c FROM CarritoPerfume c WHERE c.cantidad = :cantidad")})
public class CarritoPerfume implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "cantidad")
    private int cantidad;
    @JoinColumn(name = "carrito_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Carrito carritoId;
    @JoinColumn(name = "perfume_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Perfume perfumeId;

    public CarritoPerfume() {
    }

    public CarritoPerfume(Long id) {
        this.id = id;
    }

    public CarritoPerfume(Long id, int cantidad) {
        this.id = id;
        this.cantidad = cantidad;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public Carrito getCarritoId() {
        return carritoId;
    }

    public void setCarritoId(Carrito carritoId) {
        this.carritoId = carritoId;
    }

    public Perfume getPerfumeId() {
        return perfumeId;
    }

    public void setPerfumeId(Perfume perfumeId) {
        this.perfumeId = perfumeId;
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
        if (!(object instanceof CarritoPerfume)) {
            return false;
        }
        CarritoPerfume other = (CarritoPerfume) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.CarritoPerfume[ id=" + id + " ]";
    }
    
}
