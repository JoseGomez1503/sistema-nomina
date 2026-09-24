package com.nomina.modelo;

/**
 * Representa a un empleado temporal con salario fijo.
 */
public class EmpleadoTemporal extends Empleado {

    private final double salarioMensual;
    private final String duracionContrato;

    public EmpleadoTemporal(
            String nombre,
            String identificacion,
            double salarioMensual,
            String duracionContrato) {

        super(nombre, identificacion);
        this.salarioMensual = salarioMensual;
        this.duracionContrato = duracionContrato;
    }

    @Override
    public double calcularSalarioBruto() {
        return salarioMensual;
    }

    public double getSalarioMensual() {
        return salarioMensual;
    }

    public String getDuracionContrato() {
        return duracionContrato;
    }
}