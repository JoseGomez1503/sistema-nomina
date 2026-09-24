package com.nomina;

import com.nomina.modelo.EmpleadoAsalariado;
import com.nomina.modelo.EmpleadoComision;
import com.nomina.modelo.EmpleadoPorHoras;
import com.nomina.modelo.EmpleadoTemporal;
import com.nomina.modelo.ResultadoNomina;
import com.nomina.servicio.CalculadoraNomina;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculadoraNominaTest {

    private CalculadoraNomina calculadora;

    @BeforeEach
    void prepararPrueba() {
        calculadora = new CalculadoraNomina();
    }

    @Test
    void calcularSeguroSocialYPension() {

        double resultado =
                calculadora.calcularSeguroSocialYPension(2_000_000);

        assertEquals(
                80_000,
                resultado,
                0.01
        );
    }

    @Test
    void calcularARL() {

        double resultado =
                calculadora.calcularARL(2_000_000);

        assertEquals(
                10_440,
                resultado,
                0.01
        );
    }

    @Test
    void calcularNominaEmpleadoAsalariado() {

        EmpleadoAsalariado empleado =
                new EmpleadoAsalariado(
                        "Juan Perez",
                        "1001",
                        2_000_000,
                        6
                );

        ResultadoNomina resultado =
                calculadora.calcularNomina(empleado);

        assertEquals(
                2_200_000,
                resultado.getSalarioBruto(),
                0.01
        );

        assertEquals(
                88_000,
                resultado.getSeguridadSocialYPension(),
                0.01
        );

        assertEquals(
                11_484,
                resultado.getArl(),
                0.01
        );

        assertEquals(
                1_000_000,
                resultado.getBonoAlimentacion(),
                0.01
        );

        assertEquals(
                0,
                resultado.getFondoAhorro(),
                0.01
        );

        assertEquals(
                2_100_516,
                resultado.getSalarioNeto(),
                0.01
        );
    }

    @Test
    void calcularFondoAhorroEmpleadoPorHoras() {

        EmpleadoPorHoras empleado =
                new EmpleadoPorHoras(
                        "Maria Gomez",
                        "2001",
                        20_000,
                        45,
                        2,
                        true
                );

        ResultadoNomina resultado =
                calculadora.calcularNomina(empleado);

        assertEquals(
                950_000,
                resultado.getSalarioBruto(),
                0.01
        );

        assertEquals(
                19_000,
                resultado.getFondoAhorro(),
                0.01
        );

        assertEquals(
                888_041,
                resultado.getSalarioNeto(),
                0.01
        );
    }

    @Test
    void empleadoPorHorasQueNoAceptaFondoNoTieneDescuento() {

        EmpleadoPorHoras empleado =
                new EmpleadoPorHoras(
                        "Pedro Torres",
                        "2002",
                        20_000,
                        40,
                        3,
                        false
                );

        ResultadoNomina resultado =
                calculadora.calcularNomina(empleado);

        assertEquals(
                0,
                resultado.getFondoAhorro(),
                0.01
        );
    }

    @Test
    void empleadoComisionRecibeBonoAlimentacion() {

        EmpleadoComision empleado =
                new EmpleadoComision(
                        "Carlos Martinez",
                        "3001",
                        1_500_000,
                        0.05,
                        25_000_000
                );

        ResultadoNomina resultado =
                calculadora.calcularNomina(empleado);

        assertEquals(
                1_000_000,
                resultado.getBonoAlimentacion(),
                0.01
        );
    }

    @Test
    void empleadoTemporalNoRecibeBonoAlimentacion() {

        EmpleadoTemporal empleado =
                new EmpleadoTemporal(
                        "Ana Rodriguez",
                        "4001",
                        1_800_000,
                        "6 meses"
                );

        ResultadoNomina resultado =
                calculadora.calcularNomina(empleado);

        assertEquals(
                0,
                resultado.getBonoAlimentacion(),
                0.01
        );
    }
}