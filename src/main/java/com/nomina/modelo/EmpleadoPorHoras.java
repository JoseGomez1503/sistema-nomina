package com.nomina.modelo;

import com.nomina.validacion.ValidadorEmpleado;

/**
 * Representa a un empleado cuyo salario depende
 * de las horas trabajadas.
 */
public class EmpleadoPorHoras extends Empleado {

    private static final double LIMITE_HORAS_NORMALES = 40;
    private static final double RECARGO_HORA_EXTRA = 1.5;
    private static final double PORCENTAJE_FONDO_AHORRO = 0.02;

    private final double tarifaPorHora;
    private final double horasTrabajadas;
    private final int aniosEmpresa;
    private final boolean aceptaFondoAhorro;

    public EmpleadoPorHoras(
            String nombre,
            String identificacion,
            double tarifaPorHora,
            double horasTrabajadas,
            int aniosEmpresa,
            boolean aceptaFondoAhorro) {

        super(nombre, identificacion);

        ValidadorEmpleado.validarHoras(horasTrabajadas);

        this.tarifaPorHora = tarifaPorHora;
        this.horasTrabajadas = horasTrabajadas;
        this.aniosEmpresa = aniosEmpresa;
        this.aceptaFondoAhorro = aceptaFondoAhorro;
    }

    @Override
    public double calcularSalarioBruto() {

        if (horasTrabajadas <= LIMITE_HORAS_NORMALES) {
            return horasTrabajadas * tarifaPorHora;
        }

        double horasExtras =
                horasTrabajadas - LIMITE_HORAS_NORMALES;

        double salarioNormal =
                LIMITE_HORAS_NORMALES * tarifaPorHora;

        double salarioHorasExtras =
                horasExtras
                * tarifaPorHora
                * RECARGO_HORA_EXTRA;

        return salarioNormal + salarioHorasExtras;
    }

    @Override
    public double calcularFondoAhorro(double salarioBruto) {

        if (aniosEmpresa > 1 && aceptaFondoAhorro) {
            return salarioBruto * PORCENTAJE_FONDO_AHORRO;
        }

        return 0;
    }

    public double getTarifaPorHora() {
        return tarifaPorHora;
    }

    public double getHorasTrabajadas() {
        return horasTrabajadas;
    }

    public int getAniosEmpresa() {
        return aniosEmpresa;
    }

    public boolean isAceptaFondoAhorro() {
        return aceptaFondoAhorro;
    }
}