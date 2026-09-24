package com.nomina;

import com.nomina.modelo.EmpleadoAsalariado;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class EmpleadoAsalariadoTest {

    @Test
    void empleadoConMasDeCincoAniosRecibeBono() {

        EmpleadoAsalariado empleado =
                new EmpleadoAsalariado(
                        "Juan Perez",
                        "1001",
                        2_000_000,
                        6
                );

        double salarioBruto = empleado.calcularSalarioBruto();

        assertEquals(
                2_200_000,
                salarioBruto,
                0.01
        );
    }

    @Test
    void empleadoConCincoAniosNoRecibeBono() {

        EmpleadoAsalariado empleado =
                new EmpleadoAsalariado(
                        "Pedro Lopez",
                        "1002",
                        2_000_000,
                        5
                );

        double salarioBruto = empleado.calcularSalarioBruto();

        assertEquals(
                2_000_000,
                salarioBruto,
                0.01
        );
    }
}