public class Biblioteca {
    private ArrayList<Libro> catalogo;

    public Biblioteca() {
        this.catalogo = new ArrayList<Libro>();
    }

    public void agregarLibro(Libro libro) {
        if (libro != null) {
            this.catalogo.add(libro);
        }
    }

    public ArrayList<Libro> getCatalogo() {
        return this.catalogo;
    }

    public int eliminarLibrosSinEjemplares() {
        int contadorEliminados = 0;

        if (this.catalogo.isEmpty()) {
            return 0;
        }

        int i = 0;
        while (i < this.catalogo.size()) {
            Libro libroActual = this.catalogo.get(i);
            if (libroActual.getEjemplaresDisponibles() <= 0) {

                this.catalogo.remove(i);

                contadorEliminados++;

            } else {
                i++;
            }
        }

        return contadorEliminados;
    }

    public void mostrarCatalogo() {
        if (this.catalogo.isEmpty()) {
            System.out.println("El catálogo está vacío]");
            return;
        }
        for (int i = 0; i < this.catalogo.size(); i++) {
            System.out.println(" Posición (" + i + "): " + this.catalogo.get(i).toString());
        }
    }
}
