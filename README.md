# Java-Template-Engine (SortedList, Templates & Strategies)

Proyecto en **Java** que implementa una pequeña librería de **plantillas
de generación de texto** basada en: - **Colecciones genéricas** (incluye
una `SortedList` compatible con `List`). - **Lambdas y funciones** para
rellenar huecos de texto. - **Plantillas condicionales e iteradoras**
(`addWhen`, `addForEach`). - **Patrón Strategy** para añadir
comportamientos transversales (timestamp, mayúsculas, persistencia en
fichero).

El proyecto está dividido en cuatro apartados progresivos: listas
ordenadas, plantillas simples, plantillas condicionales/iteradoras y
estrategias.

------------------------------------------------------------------------

## Estructura del proyecto

Archivos principales:

-   `SortedList.java`: lista genérica que mantiene los elementos
    ordenados y permite añadir criterios de desempate.
-   `Person.java`: clase de dominio con nombre, fecha de nacimiento,
    edad y lista de mascotas.
-   `Mascot.java`: clase de dominio usada en las plantillas iteradoras.
-   `Template.java`: núcleo del motor de plantillas (add, addWhen,
    addForEach, emit, withSortingCriteria, withOptions).
-   `Strategy.java`: interfaz del patrón Strategy para modificar el
    texto generado.
-   `TimeStamper.java`: estrategia que añade la fecha actual al inicio
    del texto.
-   `UpperCaser.java`: estrategia que convierte el texto a mayúsculas.
-   `FilePersister.java`: estrategia que guarda el texto generado en
    ficheros.

------------------------------------------------------------------------

## Apartado 1 --- SortedList

**Objetivo:** implementar una lista genérica que mantenga sus elementos
**siempre ordenados**.

-   `SortedList<T>` es compatible con `java.util.List`.
-   El orden principal es el **orden natural** de `T`.
-   Se pueden añadir **criterios de desempate** con
    `addCriterion(Comparator<? super T>)`.
-   Si dos elementos son iguales según el orden natural, se aplica el
    primer `Comparator`. Si siguen siendo iguales, se prueba el
    siguiente, y así sucesivamente.

------------------------------------------------------------------------

## Apartado 2 --- Template: plantillas simples

**Objetivo:** crear una clase genérica `Template<T>` para generar texto
a partir de objetos.

-   Se construye con llamadas encadenadas a
    `add(String plantilla, Function<T, ?>... lambdas)`.
-   Las plantillas usan `##` como **huecos**.
-   Cada lambda recibe un objeto `T` y devuelve el valor a insertar en
    un hueco.
-   `emit()` devuelve un `Map<T, String>` con el texto generado para
    cada objeto.
-   `emit(T obj)` genera el texto solo para un objeto concreto.

------------------------------------------------------------------------

## Apartado 3 --- Plantillas condicionales e iteradoras

Se extiende `Template` con dos nuevos métodos:

### `addWhen(...)`

-   La plantilla **solo se emite** si se cumple una condición
    (`Predicate<T>`).

### `addForEach(...)`

-   Permite iterar sobre una **colección asociada al objeto** (por
    ejemplo, las mascotas de una persona).
-   Por cada elemento de la colección, se emite una copia de la
    plantilla.

------------------------------------------------------------------------

## Apartado 4 --- Estrategias (Patrón Strategy)

Se introduce un diseño extensible mediante el **patrón Strategy**:

-   `TimeStamper<T>`: añade la fecha actual al inicio del texto.
-   `UpperCaser<T>`: convierte todo el texto a mayúsculas.
-   `FilePersister<T>`: guarda el texto generado en ficheros con nombres
    derivados del objeto.

Las estrategias se añaden con `withOptions(...)` y se aplican **en
cadena**.

------------------------------------------------------------------------

## Cómo ejecutar

1.  Compila el proyecto con tu IDE o con `javac`.
2.  Ejecuta las clases de prueba para ver:
    -   Ordenación con `SortedList`.
    -   Generación de texto con `Template`.
    -   Uso de `addWhen` y `addForEach`.
    -   Aplicación de estrategias.

------------------------------------------------------------------------

## Autor

Santiago de Prada Lorenzo
