/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author sebas
 */
@Entity
@Table(name = "pedidos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Pedidos.findAll", query = "SELECT p FROM Pedidos p"),
    @NamedQuery(name = "Pedidos.findById", query = "SELECT p FROM Pedidos p WHERE p.id = :id"),
    @NamedQuery(name = "Pedidos.findByClienteNombre", query = "SELECT p FROM Pedidos p WHERE p.clienteNombre = :clienteNombre"),
    @NamedQuery(name = "Pedidos.findByCreadoEn", query = "SELECT p FROM Pedidos p WHERE p.creadoEn = :creadoEn"),
    @NamedQuery(name = "Pedidos.findByDescuento", query = "SELECT p FROM Pedidos p WHERE p.descuento = :descuento"),
    @NamedQuery(name = "Pedidos.findByDestinatarioEnvio", query = "SELECT p FROM Pedidos p WHERE p.destinatarioEnvio = :destinatarioEnvio"),
    @NamedQuery(name = "Pedidos.findByDireccionEnvio", query = "SELECT p FROM Pedidos p WHERE p.direccionEnvio = :direccionEnvio"),
    @NamedQuery(name = "Pedidos.findByEnvio", query = "SELECT p FROM Pedidos p WHERE p.envio = :envio"),
    @NamedQuery(name = "Pedidos.findByEstado", query = "SELECT p FROM Pedidos p WHERE p.estado = :estado"),
    @NamedQuery(name = "Pedidos.findByMoneda", query = "SELECT p FROM Pedidos p WHERE p.moneda = :moneda"),
    @NamedQuery(name = "Pedidos.findBySubtotal", query = "SELECT p FROM Pedidos p WHERE p.subtotal = :subtotal"),
    @NamedQuery(name = "Pedidos.findByTelefono", query = "SELECT p FROM Pedidos p WHERE p.telefono = :telefono"),
    @NamedQuery(name = "Pedidos.findByTotal", query = "SELECT p FROM Pedidos p WHERE p.total = :total"),
    @NamedQuery(name = "Pedidos.findByClienteEmail", query = "SELECT p FROM Pedidos p WHERE p.clienteEmail = :clienteEmail"),
    @NamedQuery(name = "Pedidos.findByFechaCreacion", query = "SELECT p FROM Pedidos p WHERE p.fechaCreacion = :fechaCreacion")})
public class Pedidos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "id")
    private String id;
    @Size(max = 255)
    @Column(name = "cliente_nombre")
    private String clienteNombre;
    @Column(name = "creado_en")
    @Temporal(TemporalType.TIMESTAMP)
    private Date creadoEn;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "descuento")
    private BigDecimal descuento;
    @Size(max = 255)
    @Column(name = "destinatario_envio")
    private String destinatarioEnvio;
    @Size(max = 255)
    @Column(name = "direccion_envio")
    private String direccionEnvio;
    @Column(name = "envio")
    private BigDecimal envio;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 9)
    @Column(name = "estado")
    private String estado;
    @Size(max = 10)
    @Column(name = "moneda")
    private String moneda;
    @Column(name = "subtotal")
    private BigDecimal subtotal;
    @Size(max = 255)
    @Column(name = "telefono")
    private String telefono;
    @Column(name = "total")
    private BigDecimal total;
    @Size(max = 255)
    @Column(name = "cliente_email")
    private String clienteEmail;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_creacion")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaCreacion;
    @OneToMany(mappedBy = "pedidoId")
    private List<ItemPedido> itemPedidoList;

    public Pedidos() {
    }

    public Pedidos(String id) {
        this.id = id;
    }

    public Pedidos(String id, String estado, Date fechaCreacion) {
        this.id = id;
        this.estado = estado;
        this.fechaCreacion = fechaCreacion;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getClienteNombre() {
        return clienteNombre;
    }

    public void setClienteNombre(String clienteNombre) {
        this.clienteNombre = clienteNombre;
    }

    public Date getCreadoEn() {
        return creadoEn;
    }

    public void setCreadoEn(Date creadoEn) {
        this.creadoEn = creadoEn;
    }

    public BigDecimal getDescuento() {
        return descuento;
    }

    public void setDescuento(BigDecimal descuento) {
        this.descuento = descuento;
    }

    public String getDestinatarioEnvio() {
        return destinatarioEnvio;
    }

    public void setDestinatarioEnvio(String destinatarioEnvio) {
        this.destinatarioEnvio = destinatarioEnvio;
    }

    public String getDireccionEnvio() {
        return direccionEnvio;
    }

    public void setDireccionEnvio(String direccionEnvio) {
        this.direccionEnvio = direccionEnvio;
    }

    public BigDecimal getEnvio() {
        return envio;
    }

    public void setEnvio(BigDecimal envio) {
        this.envio = envio;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getMoneda() {
        return moneda;
    }

    public void setMoneda(String moneda) {
        this.moneda = moneda;
    }

    public BigDecimal getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(BigDecimal subtotal) {
        this.subtotal = subtotal;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public String getClienteEmail() {
        return clienteEmail;
    }

    public void setClienteEmail(String clienteEmail) {
        this.clienteEmail = clienteEmail;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    @XmlTransient
    public List<ItemPedido> getItemPedidoList() {
        return itemPedidoList;
    }

    public void setItemPedidoList(List<ItemPedido> itemPedidoList) {
        this.itemPedidoList = itemPedidoList;
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
        if (!(object instanceof Pedidos)) {
            return false;
        }
        Pedidos other = (Pedidos) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.Pedidos[ id=" + id + " ]";
    }
    
}
