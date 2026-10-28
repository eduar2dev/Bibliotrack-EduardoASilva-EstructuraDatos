public class Main {
    public static void main(String[] args) {
        Biblioteca biblio = new Biblioteca();

        // 1. Probando primero cuando la biblioteca esta vacia
        System.out.println("Prueba con lista vacia:");
        int borrados = biblio.eliminarLibrosSinEjemplares();
        System.out.println("Cantidad de libros eliminados: " + borrados);
        System.out.println();

        // 2. Agregando libros con ejemplares disponibles para comprobar que debe borrar ninguno
        Libro l1 = new Libro("978-1", "Fundamentos de Programacion", "Luis Joyanes", 2020, 5);
        Libro l2 = new Libro("978-2", "Estructuras de Datos en Java", "Mark Allen", 2018, 3);

        biblio.agregarLibro(l1);
        biblio.agregarLibro(l2);

        System.out.println("Catalogo con todos los libros disponibles:");
        biblio.mostrarCatalogo();
        borrados = biblio.eliminarLibrosSinEjemplares();
        System.out.println("Eliminados: " + borrados);
        System.out.println("Total en lista: " + biblio.getCatalogo().size());
        System.out.println();

        // (Limpio la lista para probar el caso principal)
        biblio.getCatalogo().clear();

        // 3. Caso normal mezclado con casos bordes (al inicio, dos seguidos con 0 o negativo, y al final)
        biblio.agregarLibro(new Libro("101", "Introduccion a Java", "Deitel", 2019, 0));
        biblio.agregarLibro(new Libro("102", "Matematica Discreta", "Rosen", 2017, 4));
        biblio.agregarLibro(new Libro("103", "Sistemas Operativos", "Tanenbaum", 2015, 0));
        biblio.agregarLibro(new Libro("104", "Redes de Computadoras", "Kurose", 2021, -1));
        biblio.agregarLibro(new Libro("105", "Ingenieria de Software", "Pressman", 2022, 6));
        biblio.agregarLibro(new Libro("106", "Bases de Datos", "Silberschatz", 2016, 0));

        System.out.println("Catalogo antes de eliminar los agotados:");
        biblio.mostrarCatalogo();

        borrados = biblio.eliminarLibrosSinEjemplares();
        System.out.println("\nSe eliminaron: " + borrados + " libros sin ejemplares.");

        System.out.println("Catalogo despues de eliminar:");
        biblio.mostrarCatalogo();
        System.out.println("Total en lista ahora: " + biblio.getCatalogo().size());
        System.out.println();

        // 4. Probando cuando todos los libros estan agotados
        biblio.getCatalogo().clear();
        biblio.agregarLibro(new Libro("201", "Compiladores", "Aho", 2012, 0));
        biblio.agregarLibro(new Libro("202", "Fisica General", "Sears", 2014, 0));

        System.out.println("Prueba vaciando todos los libros agotados:");
        borrados = biblio.eliminarLibrosSinEjemplares();
        System.out.println("Eliminados: " + borrados);
        System.out.println("Lista vacia?: " + biblio.getCatalogo().isEmpty());
    }
}
