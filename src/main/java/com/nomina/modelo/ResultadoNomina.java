package com.nomina.modelo;

/**
 * Representa el resultado final del cálculo de nómina
 * realizado para un empleado.
 */
public class ResultadoNomina {

    private final double salarioBruto;
    private final double seguridadSocialYPension;
    private final double arl;
    private final double fondoAhorro;
    private final double bonoAlimentacion;
    private final double salarioNeto;

    public ResultadoNomina(
            double salarioBruto,
            double seguridadSocialYPension,
            double arl,
            double fondoAhorro,
            double bonoAlimentacion,
            double salarioNeto) {

        this.salarioBruto = salarioBruto;
        this.seguridadSocialYPension = seguridadSocialYPension;
        this.arl = arl;
        this.fondoAhorro = fondoAhorro;
        this.bonoAlimentacion = bonoAlimentacion;
        this.salarioNeto = salarioNeto;
    }

    public double getSalarioBruto() {
        return salarioBruto;
    }

    public double getSeguridadSocialYPension() {
        return seguridadSocialYPension;
    }

    public double getArl() {
        return arl;
    }

    public double getFondoAhorro() {
        return fondoAhorro;
    }

    public double getBonoAlimentacion() {
        return bonoAlimentacion;
    }

    public double getSalarioNeto() {
        return salarioNeto;
    }
}