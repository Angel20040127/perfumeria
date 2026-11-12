
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import perfumeria.bean.LoginBean;

@Named(value = "catalogoBean")
@SessionScoped
public class CatalogoBean implements Serializable {
    
    private String categoriaActual = "Todos";
    private AdminBean.PerfumeAdmin perfumeSeleccionado;
    private boolean mostrarDialogo = false;

    @Inject
    private CarritoBean carritoBean;

    @Inject
    private LoginBean loginBean;

    @Inject
    private AdminBean adminBean; // Inyectamos AdminBean para sincronizar la lista de perfumes

    public List<AdminBean.PerfumeAdmin> getListaPerfumes() {
        List<AdminBean.PerfumeAdmin> todos = adminBean.getListaPerfumes();

        if ("Todos".equals(categoriaActual)) {
            return todos;
        }
        
        List<AdminBean.PerfumeAdmin> filtrados = new ArrayList<>();
        for (AdminBean.PerfumeAdmin p : todos) {
            if (p.getCategoria().equalsIgnoreCase(categoriaActual)) {
                filtrados.add(p);
            }
        }
        return filtrados;
    }

    public void filtrarPor(String categoria) {
        this.categoriaActual = categoria;
    }

    public void prepararConfirmacion(AdminBean.PerfumeAdmin perfume) {
        if (loginBean == null || !loginBean.isLogueado()) {
            FacesContext.getCurrentInstance().addMessage(null, 
                new FacesMessage(FacesMessage.SEVERITY_WARN, "Acceso Restringido", "Debes iniciar sesión para agregar productos al carrito."));
            return;
        }

        this.perfumeSeleccionado = perfume;
        this.mostrarDialogo = true;
    }

    public void confirmarAgregarAlCarrito() {
        if (perfumeSeleccionado != null && carritoBean != null) {
            carritoBean.agregarProducto(perfumeSeleccionado);
            FacesContext.getCurrentInstance().addMessage(null, 
                new FacesMessage(FacesMessage.SEVERITY_INFO, "¡Éxito!", perfumeSeleccionado.getNombre() + " se ha añadido al carrito."));
        }
        this.mostrarDialogo = false;
        this.perfumeSeleccionado = null;
    }

    public void cancelarConfirmacion() {
        this.mostrarDialogo = false;
        this.perfumeSeleccionado = null;
    }

    public String getCategoriaActual() { return categoriaActual; }
    public void setCategoriaActual(String categoriaActual) { this.categoriaActual = categoriaActual; }
    
    public AdminBean.PerfumeAdmin getPerfumeSeleccionado() { return perfumeSeleccionado; }
    public boolean isMostrarDialogo() { return mostrarDialogo; }
    public void setMostrarDialogo(boolean mostrarDialogo) { this.mostrarDialogo = mostrarDialogo; }

    public int getCantidadCarrito() {
        return (carritoBean != null) ? carritoBean.getCantidadCarrito() : 0;
    }
}