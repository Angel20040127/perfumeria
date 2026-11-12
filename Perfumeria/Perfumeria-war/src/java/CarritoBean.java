
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Named(value = "carritoBean")
@SessionScoped
public class CarritoBean implements Serializable {

    public static class ItemCarrito implements Serializable {
        private AdminBean.PerfumeAdmin perfume;
        private int cantidad;

        public ItemCarrito(AdminBean.PerfumeAdmin perfume, int cantidad) {
            this.perfume = perfume;
            this.cantidad = cantidad;
        }

        public AdminBean.PerfumeAdmin getPerfume() { return perfume; }
        public void setPerfume(AdminBean.PerfumeAdmin perfume) { this.perfume = perfume; }

        public int getCantidad() { return cantidad; }
        public void setCantidad(int cantidad) { this.cantidad = cantidad; }

        public double getSubtotal() {
            return perfume.getPrecio() * cantidad;
        }
    }

    private List<ItemCarrito> listaCarrito = new ArrayList<>();

    public void agregarProducto(AdminBean.PerfumeAdmin perfume) {
        boolean encontrado = false;
        for (ItemCarrito item : listaCarrito) {
            if (item.getPerfume().getNombre().equals(perfume.getNombre())) {
                item.setCantidad(item.getCantidad() + 1);
                encontrado = true;
                break;
            }
        }
        if (!encontrado) {
            listaCarrito.add(new ItemCarrito(perfume, 1));
        }
    }

    public void incrementarCantidad(ItemCarrito item) {
        item.setCantidad(item.getCantidad() + 1);
    }

    public void disminuirCantidad(ItemCarrito item) {
        if (item.getCantidad() > 1) {
            item.setCantidad(item.getCantidad() - 1);
        } else {
            listaCarrito.remove(item);
        }
    }

    public void eliminarProducto(ItemCarrito item) {
        listaCarrito.remove(item);
    }

    public List<ItemCarrito> getListaCarrito() {
        return listaCarrito;
    }

    public int getCantidadCarrito() {
        int total = 0;
        for (ItemCarrito item : listaCarrito) {
            total += item.getCantidad();
        }
        return total;
    }
}