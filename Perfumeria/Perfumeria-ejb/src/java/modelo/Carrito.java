/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.io.Serializable;
import java.util.List;
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
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author sebas
 */
@Entity
@Table(name = "carrito")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Carrito.findAll", query = "SELECT c FROM Carrito c"),
    @NamedQuery(name = "Carrito.findById", query = "SELECT c FROM Carrito c WHERE c.id = :id"),
    @NamedQuery(name = "Carrito.findBySubtotal", query = "SELECT c FROM Carrito c WHERE c.subtotal = :subtotal")})
public class Carrito implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "subtotal")
    private double subtotal;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "carritoId")
    private List<CarritoPerfume> carritoPerfumeList;

    public Carrito() {
    }

    public Carrito(Long id) {
        this.id = id;
    }

    public Carrito(Long id, double subtotal) {
        this.id = id;
        this.subtotal = subtotal;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }

    @XmlTransient
    public List<CarritoPerfume> getCarritoPerfumeList() {
        return carritoPerfumeList;
    }

    public void setCarritoPerfumeList(List<CarritoPerfume> carritoPerfumeList) {
        this.carritoPerfumeList = carritoPerfumeList;
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
        if (!(object instanceof Carrito)) {
            return false;
        }
        Carrito other = (Carrito) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.Carrito[ id=" + id + " ]";
    }
    
}
