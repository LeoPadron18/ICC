/**
 * Clase Recipiente.java que dara los atributos al recipiente o los recipientes segun sea el caso
 * Proyecto 01 ICC
 * Ramirez Padron Angel Leonardo
 */

public class Recipiente implements ServiciosRecipiente {

    private double altura;
    private double radio;
    private double cantidadActual;

    // Metodo Constructor
    public Recipiente(double altura, double radio, double cantidadActual) {
        this.altura = altura;
        this.radio = radio;
        this.cantidadActual = Math.min(cantidadActual, capacidad());
    }

    // Metodos de acceso
    public double getAltura() {
        return altura;
    }

    public double getRadio() {
        return radio;
    }

    public double getCantidadActual() {
        return cantidadActual;
    }

    // Implementacion de los metods de la Interfaz ServiciosRecipiente
    @Override
    public double capacidad() {
        return Math.PI * Math.pow(radio, 2) * altura;
    }

    @Override
    public double capacidadRestante() {
        return capacidad() - cantidadActual;
    }

    @Override
    public boolean estaVacio() {
        return cantidadActual == 0;
    }

    @Override
    public boolean estaLleno() {
        return cantidadActual == capacidad();
    }

    @Override
    public double rellena(double cantidad) {
        double capacidadRestante = capacidadRestante();
        if (cantidad <= capacidadRestante) {
            cantidadActual += cantidad;
            return 0;
        } else {
            cantidadActual = capacidad();
            return cantidad - capacidadRestante;
        }
    }

    @Override
    public double vacia() {
        double cantidad = cantidadActual;
        cantidadActual = 0;
        return cantidad;
    }

    @Override
    public void vierte(Recipiente otro) {
        double cantidadAVertir = Math.min(cantidadActual, otro.capacidadRestante());
        cantidadActual -= cantidadAVertir;
        otro.rellena(cantidadAVertir);
    }

    @Override
    public boolean mismasDimensiones(Recipiente otro) {
        return this.altura == otro.getAltura() && this.radio == otro.getRadio();
    }

    @Override
    public boolean mismaCapacidad(Recipiente otro) {
        return this.capacidad() == otro.capacidad();
    }

    @Override
    public boolean contieneMas(Recipiente otro) {
        return this.cantidadActual > otro.getCantidadActual();
    }

    @Override
    public boolean cabeMas(Recipiente otro) {
        return this.capacidadRestante() > otro.capacidadRestante();
    }

    @Override
    public Recipiente creaContenedorJusto() {
        double nuevaAltura = (cantidadActual / (Math.PI * Math.pow(radio, 2)));
        return new Recipiente(nuevaAltura, radio, 0);
    }

    @Override
    public String muestra() {
        return String.format("Recipiente[Altura: %.2f cm, Radio: %.2f cm, Capacidad: %.2f cm cubicos, Cantidad Actual: %.2f cm cubicos]",
                altura, radio, capacidad(), cantidadActual);
 
            }
}