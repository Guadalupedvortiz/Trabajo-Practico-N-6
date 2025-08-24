import java.util.ArrayList;
import java.util.List;


interface DispositivoIoT {
    void encender();
    void apagar();
    void mostrarHistorial();
}


abstract class DispositivoBase implements DispositivoIoT {
    protected String nombre;
    protected List<String> historial = new ArrayList<>();

    public DispositivoBase(String nombre) {
        this.nombre = nombre;
    }

    public void encender() {
        historial.add(nombre + " encendido");
        System.out.println(nombre + " está encendido.");
    }

    public void apagar() {
        historial.add(nombre + " apagado");
        System.out.println(nombre + " está apagado.");
    }

    public void mostrarHistorial() {
        System.out.println("Historial de " + nombre + ":");
        for (String estado : historial) {
            System.out.println(" - " + estado);
        }
    }
}


class SensorTemperatura extends DispositivoBase {
    public SensorTemperatura(String nombre) {
        super(nombre);
    }
}

class CamaraSeguridad extends DispositivoBase {
    public CamaraSeguridad(String nombre) {
        super(nombre);
    }
}

class AltavozInteligente extends DispositivoBase {
    public AltavozInteligente(String nombre) {
        super(nombre);
    }
}

class LuzSensorial extends DispositivoBase {
    public LuzSensorial(String nombre) {
        super(nombre);
    }
}

class Alarma extends DispositivoBase {
    public Alarma(String nombre) {
        super(nombre);
    }
}


public class SistemaIoT {
    public static void main(String[] args) {
        DispositivoIoT sensor = new SensorTemperatura("Sensor 1");
        DispositivoIoT camara = new CamaraSeguridad("Cámara 1");
        DispositivoIoT altavoz = new AltavozInteligente("Altavoz 1");
        DispositivoIoT luz = new LuzSensorial("Luz 1");
        DispositivoIoT alarma = new Alarma("Alarma 1");

        sensor.encender();
        camara.encender();
        altavoz.apagar();
        luz.encender();
        alarma.apagar();

        sensor.mostrarHistorial();
        camara.mostrarHistorial();
        altavoz.mostrarHistorial();
        luz.mostrarHistorial();
        alarma.mostrarHistorial();
    }
}
