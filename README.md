# Sistema de Nómina

Sistema de nómina desarrollado en Java aplicando Programación Orientada a Objetos (POO), principios SOLID, código limpio, refactorización, validaciones y pruebas unitarias con JUnit.

## Descripción

El proyecto implementa un sistema de nómina para una empresa que cuenta con diferentes tipos de empleados. Cada empleado posee reglas particulares para calcular su salario bruto, beneficios y deducciones.

El sistema permite trabajar con:

- Empleados asalariados.
- Empleados por horas.
- Empleados por comisión.
- Empleados temporales.

## Tecnologías utilizadas

- Java 17
- Maven
- JUnit 5
- Git
- GitHub
- Visual Studio Code

## Estructura del proyecto

```text
src/
├── main/
│   └── java/
│       └── com/nomina/
│           ├── App.java
│           ├── modelo/
│           │   ├── Empleado.java
│           │   ├── EmpleadoAsalariado.java
│           │   ├── EmpleadoPorHoras.java
│           │   ├── EmpleadoComision.java
│           │   ├── EmpleadoTemporal.java
│           │   └── ResultadoNomina.java
│           ├── servicio/
│           │   └── CalculadoraNomina.java
│           └── validacion/
│               └── ValidadorEmpleado.java
└── test/
    └── java/
        └── com/nomina/
            ├── EmpleadoAsalariadoTest.java
            ├── EmpleadoPorHorasTest.java
            ├── EmpleadoComisionTest.java
            ├── EmpleadoTemporalTest.java
            ├── CalculadoraNominaTest.java
            └── ValidadorEmpleadoTest.java
```

## Reglas de negocio

### Empleado asalariado

Recibe un salario mensual fijo.

Cuando tiene más de 5 años trabajando en la empresa, recibe un bono adicional equivalente al 10 % de su salario mensual.

### Empleado por horas

Su salario depende de las horas trabajadas.

Las primeras 40 horas se pagan utilizando la tarifa normal. Las horas superiores a 40 se pagan a 1.5 veces la tarifa normal.

Las horas trabajadas no pueden ser negativas.

### Empleado por comisión

Recibe un salario base más una comisión calculada sobre sus ventas.

Cuando las ventas superan los $20.000.000, recibe adicionalmente un 3 % sobre las ventas.

Las ventas no pueden ser negativas.

El porcentaje ordinario de comisión se proporciona al crear el empleado. En los ejemplos de ejecución se utiliza un 5 %.

### Empleado temporal

Recibe un salario mensual fijo durante el tiempo establecido en su contrato y no recibe bonos o beneficios adicionales.

## Deducciones

El sistema contempla:

- Seguro Social y Pensión: 4 % del salario bruto.
- ARL: 0,522 % definido para este proyecto.
- Fondo de ahorro cuando corresponda.

El sistema valida que el salario neto de un empleado no sea negativo.

## Beneficios

Los empleados asalariados y por comisión reciben un beneficio de alimentación de $1.000.000 mensuales cubierto por la empresa.

Los empleados por horas con más de un año en la empresa pueden acceder voluntariamente a un fondo de ahorro correspondiente al 2 % de su salario.

## Programación Orientada a Objetos

El proyecto utiliza conceptos fundamentales de POO:

- Abstracción mediante la clase abstracta `Empleado`.
- Herencia mediante los diferentes tipos de empleados.
- Encapsulamiento mediante atributos privados.
- Polimorfismo para calcular comportamientos particulares según el tipo de empleado.

## Principios SOLID y código limpio

El diseño separa responsabilidades entre diferentes componentes.

`Empleado` define el comportamiento general que comparten los empleados.

Las clases concretas implementan sus reglas particulares de salario y beneficios.

`CalculadoraNomina` coordina los cálculos generales de nómina sin depender directamente de cada tipo concreto de empleado.

`ValidadorEmpleado` centraliza las reglas de validación.

Durante la refactorización se eliminaron validaciones duplicadas, números mágicos innecesarios y comprobaciones mediante `instanceof`, utilizando polimorfismo para mejorar la extensibilidad y mantenibilidad.

## Pruebas unitarias

Se utilizan pruebas unitarias con JUnit para comprobar, entre otros aspectos:

- Bono por antigüedad.
- Horas normales y horas extras.
- Comisión y bono adicional por ventas.
- Salario del empleado temporal.
- Seguro Social y Pensión.
- ARL.
- Fondo de ahorro.
- Beneficio de alimentación.
- Validación de horas negativas.
- Validación de ventas negativas.
- Validación del salario neto.

Para ejecutar todas las pruebas:

```bash
mvn clean test
```

## Compilación

Para compilar el proyecto:

```bash
mvn clean compile
```

## Ejecución

Después de compilar:

```bash
java -cp target/classes com.nomina.App
```

En Windows también puede utilizarse:

```powershell
java -cp target\classes com.nomina.App
```

## Metodología de desarrollo

Para el desarrollo académico del proyecto se siguió un enfoque iterativo e incremental.

El trabajo se realizó progresivamente mediante:

1. Análisis de los requisitos.
2. Diseño de las clases y responsabilidades.
3. Implementación de los diferentes tipos de empleados.
4. Implementación de las reglas de nómina.
5. Implementación de validaciones.
6. Creación de pruebas unitarias.
7. Refactorización del código.
8. Verificación de las pruebas después de la refactorización.
9. Control de versiones con Git y GitHub.

Este enfoque permitió implementar y verificar el sistema por etapas, manteniendo el comportamiento esperado durante las mejoras realizadas al código.

## Control de versiones

El proyecto utiliza Git para el control de versiones y GitHub como repositorio remoto.

Esto permite mantener evidencia de los cambios realizados y conservar un historial de evolución del software.

## Autores

Proyecto académico desarrollado por el CIPA " Real de Cartagena " para la asignatura de Ingeniería de Software.
