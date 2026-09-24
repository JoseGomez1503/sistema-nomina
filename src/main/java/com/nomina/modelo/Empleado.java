package com.nomina.modelo;

/**
 * Clase base para representar un empleado.
 */
public abstract class Empleado {

    private final String nombre;
    private final String identificacion;

    public Empleado(String nombre, String identificacion) {
        this.nombre = nombre;
        this.identificacion = identificacion;
    }

    public String getNombre() {
        return nombre;
    }

    public String getIdentificacion() {
        return identificacion;
    }

    /**
     * Calcula el salario bruto según el tipo de empleado.
     */
    public abstract double calcularSalarioBruto();

    /**
     * Indica si el empleado recibe bono de alimentación.
     * Por defecto ningún empleado lo recibe.
     */
    public boolean recibeBonoAlimentacion() {
        return false;
    }

    /**
     * Calcula el aporte al fondo de ahorro.
     * Por defecto no aplica.
     */
    public double calcularFondoAhorro(double salarioBruto) {
        return 0;
    }
}