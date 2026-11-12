/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author sebas
 */
@Entity
@Table(name = "notificacion_compra")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "NotificacionCompra.findAll", query = "SELECT n FROM NotificacionCompra n"),
    @NamedQuery(name = "NotificacionCompra.findById", query = "SELECT n FROM NotificacionCompra n WHERE n.id = :id"),
    @NamedQuery(name = "NotificacionCompra.findByAsunto", query = "SELECT n FROM NotificacionCompra n WHERE n.asunto = :asunto"),
    @NamedQuery(name = "NotificacionCompra.findByCreadoEn", query = "SELECT n FROM NotificacionCompra n WHERE n.creadoEn = :creadoEn"),
    @NamedQuery(name = "NotificacionCompra.findByDestinatario", query = "SELECT n FROM NotificacionCompra n WHERE n.destinatario = :destinatario"),
    @NamedQuery(name = "NotificacionCompra.findByEnviadoEn", query = "SELECT n FROM NotificacionCompra n WHERE n.enviadoEn = :enviadoEn"),
    @NamedQuery(name = "NotificacionCompra.findByEstado", query = "SELECT n FROM NotificacionCompra n WHERE n.estado = :estado"),
    @NamedQuery(name = "NotificacionCompra.findByIntentos", query = "SELECT n FROM NotificacionCompra n WHERE n.intentos = :intentos"),
    @NamedQuery(name = "NotificacionCompra.findByPedidoId", query = "SELECT n FROM NotificacionCompra n WHERE n.pedidoId = :pedidoId"),
    @NamedQuery(name = "NotificacionCompra.findByProximoIntento", query = "SELECT n FROM NotificacionCompra n WHERE n.proximoIntento = :proximoIntento"),
    @NamedQuery(name = "NotificacionCompra.findByReferenciaPago", query = "SELECT n FROM NotificacionCompra n WHERE n.referenciaPago = :referenciaPago"),
    @NamedQuery(name = "NotificacionCompra.findByUltimoError", query = "SELECT n FROM NotificacionCompra n WHERE n.ultimoError = :ultimoError")})
public class NotificacionCompra implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "asunto")
    private String asunto;
    @Basic(optional = false)
    @NotNull
    @Column(name = "creado_en")
    @Temporal(TemporalType.TIMESTAMP)
    private Date creadoEn;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 2147483647)
    @Column(name = "cuerpo")
    private String cuerpo;
    @Size(max = 255)
    @Column(name = "destinatario")
    private String destinatario;
    @Column(name = "enviado_en")
    @Temporal(TemporalType.TIMESTAMP)
    private Date enviadoEn;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "estado")
    private String estado;
    @Basic(optional = false)
    @NotNull
    @Column(name = "intentos")
    private int intentos;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "pedido_id")
    private String pedidoId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "proximo_intento")
    @Temporal(TemporalType.TIMESTAMP)
    private Date proximoIntento;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 150)
    @Column(name = "referencia_pago")
    private String referenciaPago;
    @Size(max = 100)
    @Column(name = "ultimo_error")
    private String ultimoError;

    public NotificacionCompra() {
    }

    public NotificacionCompra(Long id) {
        this.id = id;
    }

    public NotificacionCompra(Long id, String asunto, Date creadoEn, String cuerpo, String estado, int intentos, String pedidoId, Date proximoIntento, String referenciaPago) {
        this.id = id;
        this.asunto = asunto;
        this.creadoEn = creadoEn;
        this.cuerpo = cuerpo;
        this.estado = estado;
        this.intentos = intentos;
        this.pedidoId = pedidoId;
        this.proximoIntento = proximoIntento;
        this.referenciaPago = referenciaPago;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAsunto() {
        return asunto;
    }

    public void setAsunto(String asunto) {
        this.asunto = asunto;
    }

    public Date getCreadoEn() {
        return creadoEn;
    }

    public void setCreadoEn(Date creadoEn) {
        this.creadoEn = creadoEn;
    }

    public String getCuerpo() {
        return cuerpo;
    }

    public void setCuerpo(String cuerpo) {
        this.cuerpo = cuerpo;
    }

    public String getDestinatario() {
        return destinatario;
    }

    public void setDestinatario(String destinatario) {
        this.destinatario = destinatario;
    }

    public Date getEnviadoEn() {
        return enviadoEn;
    }

    public void setEnviadoEn(Date enviadoEn) {
        this.enviadoEn = enviadoEn;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public int getIntentos() {
        return intentos;
    }

    public void setIntentos(int intentos) {
        this.intentos = intentos;
    }

    public String getPedidoId() {
        return pedidoId;
    }

    public void setPedidoId(String pedidoId) {
        this.pedidoId = pedidoId;
    }

    public Date getProximoIntento() {
        return proximoIntento;
    }

    public void setProximoIntento(Date proximoIntento) {
        this.proximoIntento = proximoIntento;
    }

    public String getReferenciaPago() {
        return referenciaPago;
    }

    public void setReferenciaPago(String referenciaPago) {
        this.referenciaPago = referenciaPago;
    }

    public String getUltimoError() {
        return ultimoError;
    }

    public void setUltimoError(String ultimoError) {
        this.ultimoError = ultimoError;
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
        if (!(object instanceof NotificacionCompra)) {
            return false;
        }
        NotificacionCompra other = (NotificacionCompra) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.NotificacionCompra[ id=" + id + " ]";
    }
    
}
