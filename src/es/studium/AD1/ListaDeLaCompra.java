package es.studium.AD1;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ListaDeLaCompra implements Serializable {
    private String nombreLista; // Nombre de la lista de la compra
    private List<ArticuloAComprar> articulos; // Lista de artículos

    // Constructor por defecto
    public ListaDeLaCompra() {
        this.nombreLista = "Lista Sin Nombre";
        this.articulos = new ArrayList<>();
    }

    // Constructor que recibe el nombre de la lista
    public ListaDeLaCompra(String nombreLista) {
        this.nombreLista = nombreLista;
        this.articulos = new ArrayList<>();
    }

    // Getter para el nombre de la lista
    public String getNombreLista() {
        return nombreLista;
    }

    // Setter para el nombre de la lista
    public void setNombreLista(String nombreLista) {
        this.nombreLista = nombreLista;
    }

    // Método para agregar un artículo a la lista
    public void agregarProductoAComprar(ArticuloAComprar articulo) {
        articulos.add(articulo);
    }

    // Método para eliminar un artículo de la lista
    public void eliminarArticulo(String descripcionArticulo) {
        articulos.removeIf(articulo -> articulo.getDescripcion().equalsIgnoreCase(descripcionArticulo));
    }

    // Método para obtener la lista de artículos
    public List<ArticuloAComprar> getArticulos() {
        return articulos;
    }

    // Persistir la lista en un archivo
    public void guardarLista() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(nombreLista + ".dat"))) {
            oos.writeObject(this);
            System.out.println("Lista guardada en " + nombreLista + ".dat");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Recuperar la lista desde un archivo
    public static ListaDeLaCompra cargarLista(String nombreLista) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(nombreLista + ".dat"))) {
            return (ListaDeLaCompra) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Lista de la Compra: ").append(nombreLista).append("\n");
        for (ArticuloAComprar articulo : articulos) {
            sb.append(articulo.toString()).append("\n");
        }
        return sb.toString();
    }
}
