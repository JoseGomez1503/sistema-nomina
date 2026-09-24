package com.nomina;

import com.nomina.modelo.EmpleadoComision;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class EmpleadoComisionTest {

    @Test
    void calcularSalarioSinBonoAdicional() {

        EmpleadoComision empleado =
                new EmpleadoComision(
                        "Carlos Martinez",
                        "3001",
                        1_500_000,
                        0.05,
                        10_000_000
                );

        assertEquals(
                2_000_000,
                empleado.calcularSalarioBruto(),
                0.01
        );
    }

    @Test
    void calcularSalarioConBonoAdicional() {

        EmpleadoComision empleado =
                new EmpleadoComision(
                        "Carlos Martinez",
                        "3001",
                        1_500_000,
                        0.05,
                        25_000_000
                );

        assertEquals(
                3_500_000,
                empleado.calcularSalarioBruto(),
                0.01
        );
    }

    @Test
    void ventasNegativasGeneranError() {

        assertThrows(
                IllegalArgumentException.class,
                () -> new EmpleadoComision(
                        "Carlos Martinez",
                        "3001",
                        1_500_000,
                        0.05,
                        -1
                )
        );
    }
}