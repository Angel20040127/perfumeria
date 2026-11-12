package perfumeria.bean;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

@Named(value = "loginBean")
@SessionScoped
public class LoginBean implements Serializable {

    private String usuario;
    private String clave;
    private boolean logueado = false;

    public String iniciarSesion() {
        if ("admin".equals(usuario) && "1234".equals(clave)) {
            logueado = true;
            return "/vistas/administrar.xhtml?faces-redirect=true";
        } 
        else if ("cliente".equals(usuario) && "1234".equals(clave)) {
            logueado = true;
            return "/vistas/cliente.xhtml?faces-redirect=true";
        } 
        else {
            FacesContext.getCurrentInstance().addMessage(null, 
                new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error de acceso", "Usuario o contraseña incorrectos."));
            return null;
        }
    }

    public String cerrarSesion() {
        logueado = false;
        usuario = "";
        clave = "";
        
        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
        
        return "/index.xhtml?faces-redirect=true";
    }

    public boolean esAdmin() {
        return "admin".equalsIgnoreCase(usuario);
    }

    public String getUsuario() { return usuario; }
    public void setUsuario(String usuario) { this.usuario = usuario; }

    public String getClave() { return clave; }
    public void setClave(String clave) { this.clave = clave; }

    public boolean isLogueado() { return logueado; }
    public void setLogueado(boolean logueado) { this.logueado = logueado; }
}