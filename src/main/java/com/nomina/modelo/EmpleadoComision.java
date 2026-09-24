package com.nomina.modelo;

import com.nomina.validacion.ValidadorEmpleado;

/**
 * Representa a un empleado con salario base
 * y comisión sobre sus ventas.
 */
public class EmpleadoComision extends Empleado {

    private static final double LIMITE_VENTAS_BONO = 20_000_000;
    private static final double PORCENTAJE_BONO_ADICIONAL = 0.03;

    private final double salarioBase;
    private final double porcentajeComision;
    private final double ventas;

    public EmpleadoComision(
            String nombre,
            String identificacion,
            double salarioBase,
            double porcentajeComision,
            double ventas) {

        super(nombre, identificacion);

        ValidadorEmpleado.validarVentas(ventas);

        this.salarioBase = salarioBase;
        this.porcentajeComision = porcentajeComision;
        this.ventas = ventas;
    }

    @Override
    public double calcularSalarioBruto() {

        double salario =
                salarioBase + (ventas * porcentajeComision);

        if (ventas > LIMITE_VENTAS_BONO) {
            salario += ventas * PORCENTAJE_BONO_ADICIONAL;
        }

        return salario;
    }

    @Override
    public boolean recibeBonoAlimentacion() {
        return true;
    }

    public double getSalarioBase() {
        return salarioBase;
    }

    public double getPorcentajeComision() {
        return porcentajeComision;
    }

    public double getVentas() {
        return ventas;
    }
}