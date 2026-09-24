package com.nomina;

import com.nomina.modelo.Empleado;
import com.nomina.modelo.EmpleadoAsalariado;
import com.nomina.modelo.EmpleadoComision;
import com.nomina.modelo.EmpleadoPorHoras;
import com.nomina.modelo.EmpleadoTemporal;
import com.nomina.modelo.ResultadoNomina;
import com.nomina.servicio.CalculadoraNomina;

/**
 * Clase principal del Sistema de Nómina.
 */
public class App {

    public static void main(String[] args) {

        System.out.println("========================================");
        System.out.println("       SISTEMA DE NÓMINA");
        System.out.println("========================================");

        CalculadoraNomina calculadora = new CalculadoraNomina();

        // Empleado asalariado con más de 5 años.
        EmpleadoAsalariado asalariado =
                new EmpleadoAsalariado(
                        "Juan Perez",
                        "1001",
                        2_000_000,
                        6
                );

        // Empleado por horas con horas extras.
        EmpleadoPorHoras porHoras =
                new EmpleadoPorHoras(
                        "Maria Gomez",
                        "1002",
                        20_000,
                        45,
                        2,
                        true
                );

        // Empleado por comisión.
        // El porcentaje 0.05 representa una comisión del 5 %.
        EmpleadoComision comision =
                new EmpleadoComision(
                        "Carlos Martinez",
                        "1003",
                        1_500_000,
                        0.05,
                        25_000_000
                );

        // Empleado temporal.
        EmpleadoTemporal temporal =
                new EmpleadoTemporal(
                        "Ana Rodriguez",
                        "1004",
                        1_800_000,
                        "6 meses"
                );

        mostrarNomina(asalariado, calculadora);
        mostrarNomina(porHoras, calculadora);
        mostrarNomina(comision, calculadora);
        mostrarNomina(temporal, calculadora);
    }

    /**
     * Calcula y muestra la nómina de un empleado.
     */
    private static void mostrarNomina(
            Empleado empleado,
            CalculadoraNomina calculadora) {

        ResultadoNomina resultado =
                calculadora.calcularNomina(empleado);

        System.out.println();
        System.out.println("----------------------------------------");
        System.out.println("Empleado: " + empleado.getNombre());
        System.out.println(
                "Identificación: " + empleado.getIdentificacion());

        System.out.printf(
                "Salario bruto: $%,.2f%n",
                resultado.getSalarioBruto());

        System.out.printf(
                "Seguro Social y Pensión (4%%): $%,.2f%n",
                resultado.getSeguridadSocialYPension());

        System.out.printf(
                "ARL (0,522%%): $%,.2f%n",
                resultado.getArl());

        System.out.printf(
                "Fondo de ahorro: $%,.2f%n",
                resultado.getFondoAhorro());

        System.out.printf(
                "Bono alimentación: $%,.2f%n",
                resultado.getBonoAlimentacion());

        System.out.printf(
                "SALARIO NETO: $%,.2f%n",
                resultado.getSalarioNeto());

        System.out.println("----------------------------------------");
    }
}