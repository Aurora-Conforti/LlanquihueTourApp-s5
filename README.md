# LlanquihueTourApp

## Descripción
Sistema de gestión de tours de la agencia **Llanquihue Tour**, ubicada en la comuna de Llanquihue, Región de Los Lagos. El sistema lee los datos de los tours desde un archivo `.txt`, los convierte en objetos Java almacenados en un `ArrayList` (aplicando una relación de composición entre `Tour` y `OperadorTuristico`), y permite recorrer, filtrar y buscar el catálogo por consola, incluyendo una búsqueda interactiva ingresada por el usuario.

## Autora
- **Nombre:** Aurora Conforti
- **Asignatura:** Desarrollo Orientado a Objetos I
- **Semana:** 5

## Estructura del proyecto

```
LlanquihueTourApp/
├── src/
│   ├── model/
│   │     ├── Tour.java               → Entidad principal (composición con OperadorTuristico)
│   │     └── OperadorTuristico.java  → Clase de composición (operador/guía responsable del tour)
│   ├── util/
│   │     └── ValidadorDatos.java     → Validaciones reutilizables (texto, números, formato de línea)
│   ├── service/
│   │     └── GestorTours.java        → Carga el archivo, valida con try-catch y filtra/busca tours
│   └── app/
│         └── Main.java               → Punto de entrada: muestra catálogo, filtros y búsqueda interactiva
└── resources/
      └── tours.txt                   → Archivo con los datos de los tours
```

## Descripción de los paquetes y clases

| Paquete | Clase | Descripción |
|---|---|---|
| `model` | `Tour` | Representa un tour: nombre, tipo, precio, cupos y su `OperadorTuristico` asociado |
| `model` | `OperadorTuristico` | Operador o guía responsable de ejecutar el tour (relación de **composición** con `Tour`) |
| `util` | `ValidadorDatos` | Métodos estáticos de validación de texto, números y formato de líneas leídas del archivo |
| `service` | `GestorTours` | Lee `tours.txt` con manejo de errores (`try-catch`), almacena en `ArrayList` y ofrece búsqueda/filtrado |
| `app` | `Main` | Ejecuta el flujo completo: carga, muestra el catálogo, aplica filtros y permite búsqueda por consola |

## Relación de composición

La clase `Tour` **contiene** un objeto `OperadorTuristico` como atributo. Un tour no puede existir sin un operador responsable asignado, lo cual refleja que Llanquihue Tour trabaja en conjunto con operadores y guías locales de la zona para ejecutar cada experiencia turística.

## Formato del archivo tours.txt

Cada línea representa un tour con el siguiente formato (6 campos separados por `;`):
```
nombreTour;tipo;precio;cuposDisponibles;nombreOperador;especialidadOperador
```

Ejemplo:
```
Ruta Gastronomica del Lago;gastronomico;45000;8;Marcela Hidalgo;gastronomico
Paseo Lacustre Llanquihue;lacustre;32000;12;Pedro Vidal;lacustre
```

## Validaciones y manejo de errores

- `GestorTours.cargarTours()` envuelve la lectura del archivo en un bloque `try-catch` (`IOException`, `NumberFormatException`).
- Las líneas con cantidad incorrecta de campos, texto vacío o números negativos se **ignoran y se reporta el motivo por consola**, sin detener la ejecución del programa.
- `ValidadorDatos` centraliza la lógica de validación para reutilizarla en cualquier parte del sistema.

## Funcionalidades implementadas en Main

- **Listado completo:** muestra todos los tours cargados, incluyendo el operador asociado a cada uno.
- **Filtro 1:** tours de tipo `gastronomico`.
- **Filtro 2:** tours con precio menor a `$40.000`.
- **Filtro 3:** tours con más de `5 cupos` disponibles.
- **Búsqueda interactiva:** el usuario ingresa una palabra clave por consola (`Scanner`) y el sistema busca coincidencias en el nombre del tour.

## Instrucciones para ejecutar

### Desde terminal:
```bash
# Compilar
javac -d out src/model/*.java src/util/*.java src/service/*.java src/app/*.java

# Ejecutar
java -cp out app.Main
```

### Desde NetBeans:
1. Crear proyecto Java con nombre `LlanquihueTourApp`
2. Crear los paquetes: `model`, `util`, `service`, `app`
3. Crear la carpeta `resources` en la raíz del proyecto y copiar `tours.txt` dentro
4. Copiar cada archivo `.java` en su paquete correspondiente
5. Clic derecho sobre `Main.java` (paquete `app`) → **Run File**
6. Cuando la consola pida una palabra de búsqueda, escribirla y presionar Enter (o solo Enter para omitir)
