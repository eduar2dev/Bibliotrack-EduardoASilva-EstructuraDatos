# Control de Biblioteca Central 'Bibliotrack'

**Universidad de Pinar del Río "Hermanos Saíz Montes de Oca"**  
**Facultad de Ciencias Técnicas**  
**Carrera:** Ingeniería Informática (2do Año - Curso por Encuentros)  
**Asignatura:** Estructuras de Datos I  
**Estudiante #8:** Eduardo Alejandro Silva Hernández

---

## 1. Descripción del Ejercicio
Este proyecto resuelve el ejercicio asignado al **Estudiante #8** del Examen Parcial Individual para el dominio **Control de Biblioteca Central 'Bibliotrack'**.

El sistema gestiona un catálogo de libros utilizando únicamente nuestra propia implementación de lista dinámica (`ArrayList<E>`) basada en la interfaz `List<E>` estudiada en conferencia, sin utilizar librerías externas ni colecciones de `java.util`.

* **Entidad asignada:** `Libro` (`isbn`: String, `titulo`: String, `autor`: String, `anioPublicacion`: int, `ejemplaresDisponibles`: int).
* **Método principal implementado:** `public int eliminarLibrosSinEjemplares()`

---

## 2. Estructura del Proyecto
El código fuente se encuentra dentro de la carpeta `src` y está dividido en 5 archivos bajo el paradigma de Programación Orientada a Objetos (POO):

1. **`List.java`**: Interfaz genérica `List<E>` que define los métodos base de la estructura (`add`, `remove`, `get`, `size`, `clear`, `isEmpty`).
2. **`ArrayList.java`**: Implementación propia de la lista dinámica usando un arreglo interno `Object[] items` con capacidad inicial de 10 elementos (`capacity = 10`), control de tamaño (`size`) y crecimiento dinámico mediante los métodos `isFull()` y `Expand()`.
3. **`Libro.java`**: Clase que representa cada libro de la biblioteca con sus 5 atributos privados, su constructor, métodos *getters* y método `toString()`.
4. **`Biblioteca.java`**: Clase que administra el catálogo (`ArrayList<Libro>`) y contiene la lógica del método evaluado `eliminarLibrosSinEjemplares()`.
5. **`Main.java`**: Clase principal donde se ejecutan los casos de prueba normales y casos límite para comprobar el funcionamiento del algoritmo.

---

## 3. Explicación del Algoritmo (`eliminarLibrosSinEjemplares`)
El método recorre el `ArrayList<Libro>` buscando todos los libros cuyos ejemplares disponibles sean menores o iguales a cero (`<= 0`) para eliminarlos de la colección y devolver cuántos fueron borrados en total:

1. Primero se comprueba si la lista está vacía con `this.catalogo.isEmpty()`. Si está vacía, retorna `0` de inmediato sin producir errores.
2. Se utiliza un ciclo `while (i < this.catalogo.size())` para revisar cada posición de la lista obteniendo el libro con `this.catalogo.get(i)`.
3. Si `libroActual.getEjemplaresDisponibles() <= 0`, se elimina el libro llamando a `this.catalogo.remove(i)` y se suma 1 al contador `contadorEliminados`.
4. **Detalle importante sobre el índice `i`:** Cuando se elimina un libro en la posición `i`, el método `remove(int index)` de nuestro `ArrayList` desplaza todos los elementos que están a la derecha una posición hacia la izquierda (`items[i] = items[i + 1]`). Por esta razón, **cuando borramos un libro no incrementamos `i++`**, ya que el siguiente libro pasa a ocupar la casilla `i` actual y debe ser revisado en la siguiente vuelta del ciclo. Solo se hace `i++` cuando el libro actual tiene ejemplares disponibles y no se elimina.

---

## 4. Casos de Prueba Validados en `Main.java`
* **Prueba 1 (Lista vacía):** Se ejecuta el método con el catálogo recién creado (`size = 0`). Retorna `0` eliminados.
* **Prueba 2 (Todos los libros disponibles):** Se insertan libros con ejemplares mayores a 0 (`5` y `3` copias). El método recorre la lista sin borrar ninguno y retorna `0`.
* **Prueba 3 (Escenario normal y casos bordes):** Se prueba con 6 libros mezclando un libro agotado al inicio (posición 0), dos libros sin ejemplares seguidos en el medio (incluyendo `0` y un número negativo `-1`) y un libro agotado al final. El método elimina correctamente los 4 libros sin saltarse ninguno y deja los 2 libros disponibles.
* **Prueba 4 (Vaciamiento total):** Se insertan únicamente libros con `0` ejemplares. El método los elimina todos y se comprueba con `isEmpty()` que la lista queda vacía (`true`).

---

## 5. Presentación para la Exposición Oral
El documento de diapositivas para la defensa oral se encuentra incluido directamente en la raíz de este repositorio en el archivo:
* [Presentacion.pdf](./Presentacion_EduardoSilva-v2.pdf)

---

## 6. Declaración sobre el Uso de Inteligencia Artificial
Cumpliendo con las indicaciones de la Guía Oficial del Examen Parcial Individual, declaro de forma transparente que utilicé asistencia de Inteligencia Artificial (Google Gemini) como apoyo de estudio para repasar el funcionamiento interno del `ArrayList` visto en clase, organizar los casos de prueba límite en la clase `Main`, dar formato a este archivo `README.md` y estructurar el diseño de las diapositivas de apoyo. Todo el código fue revisado, probado en IntelliJ IDEA y comprendido en su totalidad para la defensa oral del proyecto.
