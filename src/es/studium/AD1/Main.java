package es.studium.AD1;

public class Main {
    public static void main(String[] args) {
        // Crear una lista de la compra
        ListaDeLaCompra lista = new ListaDeLaCompra("Lidl");

        // Agregar artículos a la lista
        lista.agregarProductoAComprar(new ArticuloAComprar("Arroz", 3, "Kg"));
        lista.agregarProductoAComprar(new ArticuloAComprar("Leche", 2, "L"));
        lista.agregarProductoAComprar(new ArticuloAComprar("Pan", 5, "U"));

        // Mostrar la lista de la compra
        System.out.println("Contenido inicial de la lista:");
        System.out.println(lista);

        // Guardar la lista en un archivo
        lista.guardarLista();

        // Eliminar un artículo
        lista.eliminarArticulo("Leche");

        // Mostrar la lista de la compra después de la eliminación
        System.out.println("Contenido de la lista después de eliminar la leche:");
        System.out.println(lista);

        // Cargar la lista desde el archivo
        ListaDeLaCompra listaCargada = ListaDeLaCompra.cargarLista("Mercadona");

        // Mostrar la lista cargada
        if (listaCargada != null) {
            System.out.println("Contenido de la lista cargada:");
            System.out.println(listaCargada);
        } else {
            System.out.println("No se pudo cargar la lista.");
        }
    }
}

