package com.nomina;

import com.nomina.modelo.EmpleadoTemporal;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class EmpleadoTemporalTest {

    @Test
    void salarioBrutoEsIgualAlSalarioMensual() {

        EmpleadoTemporal empleado =
                new EmpleadoTemporal(
                        "Ana Rodriguez",
                        "4001",
                        1_800_000,
                        "6 meses"
                );

        assertEquals(
                1_800_000,
                empleado.calcularSalarioBruto(),
                0.01
        );
    }
}