
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

@Named(value = "adminBean")
@SessionScoped
public class AdminBean implements Serializable {

    private String nombre;
    private String descripcion;
    private String categoria;
    private double precio;
    private int existencias;
    private String imagenUrl = "https://images.unsplash.com/photo-1523293182086-7651a899d37f?w=300";
    
    // Referencia para identificar qué perfume estamos editando
    private PerfumeAdmin perfumeEnEdicion = null;

    private static List<PerfumeAdmin> listaPerfumesAdmin = new ArrayList<>();

    static {
        if (listaPerfumesAdmin.isEmpty()) {
            listaPerfumesAdmin.add(new PerfumeAdmin(1L, "Chanel N° 5", "Dama", "Fragancia elegante y clásica.", 1200.00, 10, "https://images.unsplash.com/photo-1541643600914-78b084683601?w=300"));
            listaPerfumesAdmin.add(new PerfumeAdmin(2L, "Dior Sauvage", "Caballero", "Aroma fresco y amaderado.", 1500.00, 15, "https://images.unsplash.com/photo-1523293182086-7651a899d37f?w=300"));
            listaPerfumesAdmin.add(new PerfumeAdmin(3L, "CK One", "Unisex", "Fragancia limpia y juvenil.", 950.00, 20, "https://images.unsplash.com/photo-1594035910387-fea47794261f?w=300"));
            listaPerfumesAdmin.add(new PerfumeAdmin(4L, "La Vie Est Belle", "Dama", "Notas dulces y florales.", 1350.00, 12, "https://images.unsplash.com/photo-1583445013765-46c20c4a6772?w=300"));
        }
    }

    public static class PerfumeAdmin implements Serializable {
        private Long id;
        private String nombre;
        private String categoria;
        private String descripcion;
        private double precio;
        private int existencias;
        private String imagenUrl;

        public PerfumeAdmin(Long id, String nombre, String categoria, String descripcion, double precio, int existencias, String imagenUrl) {
            this.id = id;
            this.nombre = nombre;
            this.categoria = categoria;
            this.descripcion = descripcion;
            this.precio = precio;
            this.existencias = existencias;
            this.imagenUrl = imagenUrl;
        }

        public Long getId() { return id; }
        public String getNombre() { return nombre; }
        public void setNombre(String nombre) { this.nombre = nombre; }
        public String getCategoria() { return categoria; }
        public void setCategoria(String categoria) { this.categoria = categoria; }
        public String getDescripcion() { return descripcion; }
        public void setDescripcion(String descripcion) { this.descripcion = descripcion; }
        public double getPrecio() { return precio; }
        public void setPrecio(double precio) { this.precio = precio; }
        public int getExistencias() { return existencias; }
        public void setExistencias(int existencias) { this.existencias = existencias; }
        public String getImagenUrl() { return imagenUrl; }
        public void setImagenUrl(String imagenUrl) { this.imagenUrl = imagenUrl; }
    }

    public List<PerfumeAdmin> getListaPerfumes() {
        return listaPerfumesAdmin;
    }

    public void guardarPerfume() {
        if (perfumeEnEdicion == null) {
            // Crear Nuevo registro
            Long nuevoId = System.currentTimeMillis(); // ID único basado en tiempo
            PerfumeAdmin nuevo = new PerfumeAdmin(nuevoId, nombre, categoria, descripcion, precio, existencias, imagenUrl);
            listaPerfumesAdmin.add(nuevo);
            FacesContext.getCurrentInstance().addMessage(null, 
                new FacesMessage(FacesMessage.SEVERITY_INFO, "Éxito", "Perfume agregado correctamente."));
        } else {
            // Actualizar registro existente
            perfumeEnEdicion.setNombre(nombre);
            perfumeEnEdicion.setCategoria(categoria);
            perfumeEnEdicion.setDescripcion(descripcion);
            perfumeEnEdicion.setPrecio(precio);
            perfumeEnEdicion.setExistencias(existencias);
            FacesContext.getCurrentInstance().addMessage(null, 
                new FacesMessage(FacesMessage.SEVERITY_INFO, "Éxito", "Perfume actualizado correctamente."));
        }
        limpiarFormulario();
    }

    public void cargarParaEditar(PerfumeAdmin perfume) {
        this.perfumeEnEdicion = perfume;
        this.nombre = perfume.getNombre();
        this.categoria = perfume.getCategoria();
        this.descripcion = perfume.getDescripcion();
        this.precio = perfume.getPrecio();
        this.existencias = perfume.getExistencias();
    }

    public void eliminarPerfume(PerfumeAdmin perfume) {
        listaPerfumesAdmin.remove(perfume);
        if (perfumeEnEdicion != null && perfumeEnEdicion.equals(perfume)) {
            limpiarFormulario();
        }
        FacesContext.getCurrentInstance().addMessage(null, 
            new FacesMessage(FacesMessage.SEVERITY_WARN, "Eliminado", "El perfume ha sido eliminado."));
    }

    public void limpiarFormulario() {
        this.perfumeEnEdicion = null;
        this.nombre = "";
        this.descripcion = "";
        this.categoria = "";
        this.precio = 0.0;
        this.existencias = 0;
    }

    // Getters y Setters
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public String getDescripcion() { return descripcion; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }
    public String getCategoria() { return categoria; }
    public void setCategoria(String categoria) { this.categoria = categoria; }
    public double getPrecio() { return precio; }
    public void setPrecio(double precio) { this.precio = precio; }
    public int getExistencias() { return existencias; }
    public void setExistencias(int existencias) { this.existencias = existencias; }
}