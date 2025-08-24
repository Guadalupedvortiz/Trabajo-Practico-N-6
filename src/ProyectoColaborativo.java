
abstract class Tarea {
    protected String nombre;
    protected String responsable;
    protected int inicio;
    protected int fin;

    public Tarea(String nombre, String responsable, int inicio, int fin) {
        this.nombre = nombre;
        this.responsable = responsable;
        this.inicio = inicio;
        this.fin = fin;
    }

    public int calcularTiempo() {
        return fin - inicio;
    }

    public abstract void mostrarInfo();
}


class Limpieza extends Tarea {
    public Limpieza(String responsable, int inicio, int fin) {
        super("Limpieza", responsable, inicio, fin);
    }

    @Override
    public void mostrarInfo() {
        System.out.println(nombre + " | Responsable: " + responsable +
                " | Inicio: " + inicio + " | Fin: " + fin +
                " | Duración: " + calcularTiempo() + " días");
    }
}

class Ordenanza extends Tarea {
    public Ordenanza(String responsable, int inicio, int fin) {
        super("Ordenanza", responsable, inicio, fin);
    }

    @Override
    public void mostrarInfo() {
        System.out.println(nombre + " | Responsable: " + responsable +
                " | Inicio: " + inicio + " | Fin: " + fin +
                " | Duración: " + calcularTiempo() + " días");
    }
}

class Seguridad extends Tarea {
    public Seguridad(String responsable, int inicio, int fin) {
        super("Seguridad", responsable, inicio, fin);
    }

    @Override
    public void mostrarInfo() {
        System.out.println(nombre + " | Responsable: " + responsable +
                " | Inicio: " + inicio + " | Fin: " + fin +
                " | Duración: " + calcularTiempo() + " días");
    }
}

class Pintura extends Tarea {
    public Pintura(String responsable, int inicio, int fin) {
        super("Pintura", responsable, inicio, fin);
    }

    @Override
    public void mostrarInfo() {
        System.out.println(nombre + " | Responsable: " + responsable +
                " | Inicio: " + inicio + " | Fin: " + fin +
                " | Duración: " + calcularTiempo() + " días");
    }
}

class Alumbrado extends Tarea {
    public Alumbrado(String responsable, int inicio, int fin) {
        super("Alumbrado", responsable, inicio, fin);
    }

    @Override
    public void mostrarInfo() {
        System.out.println(nombre + " | Responsable: " + responsable +
                " | Inicio: " + inicio + " | Fin: " + fin +
                " | Duración: " + calcularTiempo() + " días");
    }
}


public class ProyectoColaborativo {
    public static void main(String[] args) {
        Tarea[] tareas = {
                new Limpieza("Ana", 1, 3),
                new Ordenanza("Luis", 2, 5),
                new Seguridad("Carlos", 1, 4),
                new Pintura("Marta", 3, 6),
                new Alumbrado("José", 2, 7)
        };

        System.out.println(" INFORME DE TAREAS DEL PROYECTO COLABORATIVO:");
        System.out.println("--------------------------------------------------");
        for (Tarea t : tareas) {
            t.mostrarInfo();
        }

        System.out.println("--------------------------------------------------");
        int totalDuracion = 0;
        for (Tarea t : tareas) {
            totalDuracion += t.calcularTiempo();
        }
        System.out.println("️ Duración total combinada de todas las tareas: " + totalDuracion + " días");
    }
}