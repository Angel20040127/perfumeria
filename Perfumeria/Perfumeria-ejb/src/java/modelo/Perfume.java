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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author sebas
 */
@Entity
@Table(name = "perfume")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Perfume.findAll", query = "SELECT p FROM Perfume p"),
    @NamedQuery(name = "Perfume.findById", query = "SELECT p FROM Perfume p WHERE p.id = :id"),
    @NamedQuery(name = "Perfume.findByDescripcion", query = "SELECT p FROM Perfume p WHERE p.descripcion = :descripcion"),
    @NamedQuery(name = "Perfume.findByImagenUrl", query = "SELECT p FROM Perfume p WHERE p.imagenUrl = :imagenUrl"),
    @NamedQuery(name = "Perfume.findByMarca", query = "SELECT p FROM Perfume p WHERE p.marca = :marca"),
    @NamedQuery(name = "Perfume.findByNombre", query = "SELECT p FROM Perfume p WHERE p.nombre = :nombre"),
    @NamedQuery(name = "Perfume.findByNotasBase", query = "SELECT p FROM Perfume p WHERE p.notasBase = :notasBase"),
    @NamedQuery(name = "Perfume.findByNotasMiddle", query = "SELECT p FROM Perfume p WHERE p.notasMiddle = :notasMiddle"),
    @NamedQuery(name = "Perfume.findByNotasTop", query = "SELECT p FROM Perfume p WHERE p.notasTop = :notasTop"),
    @NamedQuery(name = "Perfume.findByPrecio", query = "SELECT p FROM Perfume p WHERE p.precio = :precio"),
    @NamedQuery(name = "Perfume.findByStock", query = "SELECT p FROM Perfume p WHERE p.stock = :stock")})
public class Perfume implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 500)
    @Column(name = "descripcion")
    private String descripcion;
    @Size(max = 255)
    @Column(name = "imagen_url")
    private String imagenUrl;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "marca")
    private String marca;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "nombre")
    private String nombre;
    @Size(max = 255)
    @Column(name = "notas_base")
    private String notasBase;
    @Size(max = 255)
    @Column(name = "notas_middle")
    private String notasMiddle;
    @Size(max = 500)
    @Column(name = "notas_top")
    private String notasTop;
    @Basic(optional = false)
    @NotNull
    @Column(name = "precio")
    private double precio;
    @Basic(optional = false)
    @NotNull
    @Column(name = "stock")
    private int stock;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "perfumeId")
    private List<CarritoPerfume> carritoPerfumeList;

    public Perfume() {
    }

    public Perfume(Long id) {
        this.id = id;
    }

    public Perfume(Long id, String descripcion, String marca, String nombre, double precio, int stock) {
        this.id = id;
        this.descripcion = descripcion;
        this.marca = marca;
        this.nombre = nombre;
        this.precio = precio;
        this.stock = stock;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getImagenUrl() {
        return imagenUrl;
    }

    public void setImagenUrl(String imagenUrl) {
        this.imagenUrl = imagenUrl;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNotasBase() {
        return notasBase;
    }

    public void setNotasBase(String notasBase) {
        this.notasBase = notasBase;
    }

    public String getNotasMiddle() {
        return notasMiddle;
    }

    public void setNotasMiddle(String notasMiddle) {
        this.notasMiddle = notasMiddle;
    }

    public String getNotasTop() {
        return notasTop;
    }

    public void setNotasTop(String notasTop) {
        this.notasTop = notasTop;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
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
        if (!(object instanceof Perfume)) {
            return false;
        }
        Perfume other = (Perfume) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.Perfume[ id=" + id + " ]";
    }
    
}
