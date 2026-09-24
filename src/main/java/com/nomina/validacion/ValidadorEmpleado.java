package com.nomina.validacion;

import com.nomina.modelo.Empleado;

/**
 * Centraliza las reglas de validación de los empleados.
 */
public final class ValidadorEmpleado {

    private ValidadorEmpleado() {
        // Evita crear instancias de esta clase de utilidad.
    }

    public static void validarHoras(double horasTrabajadas) {

        if (horasTrabajadas < 0) {
            throw new IllegalArgumentException(
                    "Las horas trabajadas no pueden ser negativas.");
        }
    }

    public static void validarVentas(double ventas) {

        if (ventas < 0) {
            throw new IllegalArgumentException(
                    "Las ventas no pueden ser menores que $0.");
        }
    }

    public static void validarSalarioNeto(
            Empleado empleado,
            double salarioNeto) {

        if (salarioNeto < 0) {
            throw new IllegalArgumentException(
                    "El salario neto del empleado "
                    + empleado.getNombre()
                    + " no puede ser negativo.");
        }
    }
}