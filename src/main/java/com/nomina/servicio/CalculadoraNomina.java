package com.nomina.servicio;

import com.nomina.modelo.Empleado;
import com.nomina.modelo.ResultadoNomina;
import com.nomina.validacion.ValidadorEmpleado;

/**
 * Servicio encargado de realizar los cálculos generales de nómina.
 */
public class CalculadoraNomina {

    private static final double PORCENTAJE_SEGURIDAD_SOCIAL = 0.04;
    private static final double PORCENTAJE_ARL = 0.00522;
    private static final double BONO_ALIMENTACION = 1_000_000;

    public double calcularSeguroSocialYPension(double salarioBruto) {
        return salarioBruto * PORCENTAJE_SEGURIDAD_SOCIAL;
    }

    public double calcularARL(double salarioBruto) {
        return salarioBruto * PORCENTAJE_ARL;
    }

    public double calcularFondoAhorro(
            Empleado empleado,
            double salarioBruto) {

        return empleado.calcularFondoAhorro(salarioBruto);
    }

    public double calcularBonoAlimentacion(Empleado empleado) {

        if (empleado.recibeBonoAlimentacion()) {
            return BONO_ALIMENTACION;
        }

        return 0;
    }

    public ResultadoNomina calcularNomina(Empleado empleado) {

        double salarioBruto =
                empleado.calcularSalarioBruto();

        double seguridadSocialYPension =
                calcularSeguroSocialYPension(salarioBruto);

        double arl =
                calcularARL(salarioBruto);

        double fondoAhorro =
                calcularFondoAhorro(
                        empleado,
                        salarioBruto);

        double bonoAlimentacion =
                calcularBonoAlimentacion(empleado);

        double salarioNeto =
                salarioBruto
                - seguridadSocialYPension
                - arl
                - fondoAhorro;

        ValidadorEmpleado.validarSalarioNeto(
                empleado,
                salarioNeto);

        return new ResultadoNomina(
                salarioBruto,
                seguridadSocialYPension,
                arl,
                fondoAhorro,
                bonoAlimentacion,
                salarioNeto
        );
    }
}