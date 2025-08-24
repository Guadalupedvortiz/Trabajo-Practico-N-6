import java.time.LocalDate;
import java.util.ArrayList;


abstract class Producto {
    protected String nombre;
    protected double precio;


    public Producto(String nombre, double precio) {
        this.nombre = nombre;
        this.precio = precio;
    }


    public double calcularPrecio() {
        return precio;
    }


    public abstract void mostrarDetalles();
}


class ProductoAlimenticio extends Producto {
    private LocalDate fechaVencimiento;

    public ProductoAlimenticio(String nombre, double precio, LocalDate fechaVencimiento) {
        super(nombre, precio);
        this.fechaVencimiento = fechaVencimiento;
    }


    public boolean estaPorVencer() {
        return fechaVencimiento.isBefore(LocalDate.now().plusDays(7));
    }

    @Override
    public void mostrarDetalles() {
        System.out.println("Alimenticio: " + nombre);
        System.out.println("Precio: $" + precio);
        System.out.println("Fecha de vencimiento: " + fechaVencimiento);
    }
}


class ProductoElectronico extends Producto {
    private int garantiaMeses;

    public ProductoElectronico(String nombre, double precio, int garantiaMeses) {
        super(nombre, precio);
        this.garantiaMeses = garantiaMeses;
    }

    @Override
    public void mostrarDetalles() {
        System.out.println("Electrónico: " + nombre);
        System.out.println("Precio: $" + precio);
        System.out.println("Garantía: " + garantiaMeses + " meses");
    }
}


class Ropa extends Producto {
    private String talle;

    public Ropa(String nombre, double precio, String talle) {
        super(nombre, precio);
        this.talle = talle;
    }

    @Override
    public void mostrarDetalles() {
        System.out.println("Ropa: " + nombre);
        System.out.println("Precio: $" + precio);
        System.out.println("Talle: " + talle);
    }
}


public class Main {
    public static void main(String[] args) {
        // Lista para guardar todos los productos
        ArrayList<Producto> productos = new ArrayList<>();


        productos.add(new ProductoAlimenticio("Fideos", 800, LocalDate.of(2025, 9, 1)));
        productos.add(new ProductoAlimenticio("Arroz", 1000, LocalDate.of(2025, 8, 28)));
        productos.add(new ProductoAlimenticio("Galletas", 650, LocalDate.of(2025, 9, 5)));


        productos.add(new ProductoElectronico("Enchufe macho", 1200, 12));
        productos.add(new ProductoElectronico("Enchufe hembra", 1200, 12));
        productos.add(new ProductoElectronico("Focos LED 50W", 4500, 24));


        productos.add(new Ropa("Medias", 1500, "M"));
        productos.add(new Ropa("Guantes", 1000, "L"));
        productos.add(new Ropa("Bufandas", 3000, "Único"));


        for (Producto p : productos) {
            p.mostrarDetalles();


            if (p instanceof ProductoAlimenticio) {
                boolean porVencer = ((ProductoAlimenticio)p).estaPorVencer();
                System.out.println("¿Está por vencer?: " + (porVencer ? "Sí" : "No"));
            }

            System.out.println("-----------------------------");
        }
    }
}