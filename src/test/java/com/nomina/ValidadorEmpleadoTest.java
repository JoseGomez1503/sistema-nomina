package com.nomina;

import com.nomina.modelo.EmpleadoAsalariado;
import com.nomina.validacion.ValidadorEmpleado;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ValidadorEmpleadoTest {

    @Test
    void horasPositivasSonValidas() {

        assertDoesNotThrow(
                () -> ValidadorEmpleado.validarHoras(40)
        );
    }

    @Test
    void horasNegativasGeneranExcepcion() {

        assertThrows(
                IllegalArgumentException.class,
                () -> ValidadorEmpleado.validarHoras(-5)
        );
    }

    @Test
    void ventasPositivasSonValidas() {

        assertDoesNotThrow(
                () -> ValidadorEmpleado.validarVentas(10_000_000)
        );
    }

    @Test
    void ventasNegativasGeneranExcepcion() {

        assertThrows(
                IllegalArgumentException.class,
                () -> ValidadorEmpleado.validarVentas(-500_000)
        );
    }

    @Test
    void salarioNetoPositivoEsValido() {

        EmpleadoAsalariado empleado =
                new EmpleadoAsalariado(
                        "Juan Perez",
                        "1001",
                        2_000_000,
                        6
                );

        assertDoesNotThrow(
                () -> ValidadorEmpleado.validarSalarioNeto(
                        empleado,
                        2_100_516)
        );
    }

    @Test
    void salarioNetoNegativoGeneraExcepcion() {

        EmpleadoAsalariado empleado =
                new EmpleadoAsalariado(
                        "Juan Perez",
                        "1001",
                        2_000_000,
                        6
                );

        assertThrows(
                IllegalArgumentException.class,
                () -> ValidadorEmpleado.validarSalarioNeto(
                        empleado,
                        -100)
        );
    }
}