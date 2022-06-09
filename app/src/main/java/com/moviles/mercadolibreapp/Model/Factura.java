package com.moviles.mercadolibreapp.Model;

import android.os.Parcelable;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

public class Factura implements Serializable {

    public static ArrayList<Car> productos;
    public static String total;
    public static String fecha;

    public Factura(ArrayList<Car> productos, String total, String fecha) {
        this.productos = productos;
        this.total = total;
        this.fecha = fecha;
    }

    public ArrayList<Car> getProductos() {
        return productos;
    }

    public void setProductos(ArrayList<Car> productos) {
        this.productos = productos;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }
}
