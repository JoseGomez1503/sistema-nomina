package com.nomina;

import com.nomina.modelo.EmpleadoPorHoras;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class EmpleadoPorHorasTest {

    @Test
    void calcularSalarioSinHorasExtras() {

        EmpleadoPorHoras empleado =
                new EmpleadoPorHoras(
                        "Maria Gomez",
                        "2001",
                        20_000,
                        40,
                        1,
                        false
                );

        assertEquals(
                800_000,
                empleado.calcularSalarioBruto(),
                0.01
        );
    }

    @Test
    void calcularSalarioConHorasExtras() {

        EmpleadoPorHoras empleado =
                new EmpleadoPorHoras(
                        "Maria Gomez",
                        "2001",
                        20_000,
                        45,
                        2,
                        true
                );

        assertEquals(
                950_000,
                empleado.calcularSalarioBruto(),
                0.01
        );
    }

    @Test
    void horasNegativasGeneranError() {

        assertThrows(
                IllegalArgumentException.class,
                () -> new EmpleadoPorHoras(
                        "Maria Gomez",
                        "2001",
                        20_000,
                        -5,
                        2,
                        false
                )
        );
    }
}