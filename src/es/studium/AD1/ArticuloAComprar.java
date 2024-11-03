package es.studium.AD1;

import java.io.Serializable;

public class ArticuloAComprar implements Serializable {
    private String descripcion; // Descripción del artículo
    private int cantidad; // Cantidad del artículo
    private String unidad; // Unidad de medida

    // Constructor
    public ArticuloAComprar(String descripcion, int cantidad, String unidad) {
        this.descripcion = descripcion;
        this.cantidad = cantidad;
        this.unidad = unidad;
    }

    // Getters
    public String getDescripcion() {
        return descripcion;
    }

    public int getCantidad() {
        return cantidad;
    }

    public String getUnidad() {
        return unidad;
    }

    @Override
    public String toString() {
        return cantidad + " " + unidad + " de " + descripcion;
    }
}


