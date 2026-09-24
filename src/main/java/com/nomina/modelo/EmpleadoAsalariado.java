package com.nomina.modelo;

/**
 * Representa a un empleado con salario fijo mensual.
 */
public class EmpleadoAsalariado extends Empleado {

    private static final double PORCENTAJE_BONO_ANTIGUEDAD = 0.10;

    private final double salarioMensual;
    private final int aniosEmpresa;

    public EmpleadoAsalariado(
            String nombre,
            String identificacion,
            double salarioMensual,
            int aniosEmpresa) {

        super(nombre, identificacion);
        this.salarioMensual = salarioMensual;
        this.aniosEmpresa = aniosEmpresa;
    }

    @Override
    public double calcularSalarioBruto() {

        if (aniosEmpresa > 5) {
            return salarioMensual
                    + (salarioMensual * PORCENTAJE_BONO_ANTIGUEDAD);
        }

        return salarioMensual;
    }

    @Override
    public boolean recibeBonoAlimentacion() {
        return true;
    }

    public double getSalarioMensual() {
        return salarioMensual;
    }

    public int getAniosEmpresa() {
        return aniosEmpresa;
    }
}