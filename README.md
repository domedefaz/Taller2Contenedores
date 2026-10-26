# Taller Practico: Simulador de Descuentos con Quarkus
**Asignatura:** Programacion Avanzada II  
**Estudiante:** Domenica Defaz  
**Rama de Git:** Tarea3  

---

## 1. Descripcion del Proyecto
Aplicacion desarrollada en Java con el framework Quarkus para aplicar conceptos de Inversion de Control (IoC), Inyeccion de Dependencias (DI), CDI, Qualifiers, Scopes (`@ApplicationScoped`, `@Dependent`) y ciclo de vida de componentes gestionados por el contenedor ArC, ejecutada mediante consola.

---

## 2. Preguntas de Analisis

### En que parte del ejercicio se aplica IoC y en cual DI?
- **IoC (Inversion de Control):** Se aplica al delegar la creacion, inicializacion y gestion del ciclo de vida de los componentes (`VentaService`, `DescuentoRegular`, `DescuentoVIP`, `Auditoria`) al contenedor CDI de Quarkus (ArC) mediante anotaciones, sin utilizar el operador `new` manualmente.
- **DI (Inyeccion de Dependencias):** Se aplica mediante el uso de la anotacion `@Inject`. En el proyecto se demostro mediante **inyeccion por atributo** (en `Auditoria` dentro de `VentaService`) y **inyeccion por constructor** (inyectando los qualificadores de `CalculadoraDescuento` en el constructor de `VentaService`).

### Que funcion cumplen los Qualifiers y por que son necesarios?
Los Qualifiers (`@Named("regular")` y `@Named("vip")`) permiten diferenciar las multiples implementaciones de la interfaz `CalculadoraDescuento` (`DescuentoRegular` y `DescuentoVIP`). Son necesarios para evitar ambiguedades en el contenedor CDI al momento de inyectar la dependencia adecuada en el punto de inyeccion.

### Cual es la diferencia entre @ApplicationScoped y @Dependent?
- **`@ApplicationScoped`**: Mantiene una **unica instancia** (Singleton) compartida durante todo el tiempo de vida de la aplicacion.
- **`@Dependent`**: Es el ambito por defecto; se crea una **nueva instancia** cada vez que el componente es inyectado o requerido por otro objeto.

### Por que las instancias @ApplicationScoped pueden reutilizarse entre varias ventas?
Porque el contenedor ArC las crea e inicializa una sola vez al inicio de la aplicacion y guarda la referencia en memoria, permitiendo que todas las peticiones o metodos que las necesiten compartan la misma instancia.

### Que sucederia si se elimina el Qualifier de un punto de inyeccion de CalculadoraDescuento?
El contenedor CDI de Quarkus (ArC) lanzaria una excepcion de ambiguedad en tiempo de compilacion o inicio (*AmbiguousDependencyException*), debido a que no sabria cual de las dos clases (`DescuentoRegular` o `DescuentoVIP`) inyectar.

---

## 3. Evidencia de Salida en Consola

```text
***** SIMULADOR DE DESCUENTOS QUARKUS *****
Instancia de Descuento Regular
Instancia de Descuento VIP
Instancia de VentaService
Instancia de Auditoria (Dependent)
Instancia de Descuento Regular
--- AUDITORIA DE VENTA ---
Tipo Cliente: REGULAR | Monto: $100.0 | Descuento: 5 % ($5.0) | Total Final: $95.0
--------------------------
Instancia de Descuento VIP
--- AUDITORIA DE VENTA ---
Tipo Cliente: VIP | Monto: $200.0 | Descuento: 15 % ($30.0) | Total Final: $170.0
--------------------------
--- AUDITORIA DE VENTA ---
Tipo Cliente: REGULAR | Monto: $300.0 | Descuento: 5 % ($15.0) | Total Final: $285.0
--------------------------
--- AUDITORIA DE VENTA ---
Tipo Cliente: VIP | Monto: $500.0 | Descuento: 15 % ($75.0) | Total Final: $425.0
--------------------------
***** FIN DE LA EJECUCION *****