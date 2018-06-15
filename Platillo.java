/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cliente;

import cliente.Utilidades;

/**
 *
 * @author Jorge
 */
public final class Platillo extends Utilidades {
    private String nombre, codigo,tamPorcion, piezasPorPorcion, caloriasPorPorcion, caloriasPorPieza, precio, DetalleDescripcion;
    private boolean disponible;
    
    public Platillo(String nombre){
        this.nombre=nombre;
        codigo="";
        tamPorcion="";
        piezasPorPorcion="";
        caloriasPorPorcion="";
        caloriasPorPieza="";
        precio="";
        DetalleDescripcion="";
        disponible=false;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getTamPorcion() {
        return tamPorcion;
    }

    public void setTamPorcion(String tamPorcion) {
        this.tamPorcion = tamPorcion;
    }

    public String getPiezasPorPorcion() {
        return piezasPorPorcion;
    }

    public void setPiezasPorPorcion(String piezasPorPorcion) {
        this.piezasPorPorcion = piezasPorPorcion;
    }

    public String getCaloriasPorPorcion() {
        return caloriasPorPorcion;
    }

    public void setCaloriasPorPorcion(String caloriasPorPorcion) {
        this.caloriasPorPorcion = caloriasPorPorcion;
    }

    public String getCaloriasPorPieza() {
        return caloriasPorPieza;
    }

    public void setCaloriasPorPieza(String caloriasPorPieza) {
        this.caloriasPorPieza = caloriasPorPieza;
    }

    public String getPrecio() {
        return precio;
    }

    public void setPrecio(String precio) {
        this.precio = precio;
    }

    public String getDetalleDescripcion() {
        return DetalleDescripcion;
    }

    public void setDetalleDescripcion(String DetalleDescripcion) {
        this.DetalleDescripcion = DetalleDescripcion;
    }

    public boolean isDisponible() {
        return disponible;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }
     
    @Override
    public String extraerDato(String tag, String dish) {
        return super.extraerDato(tag, dish); //To change body of generated methods, choose Tools | Templates.
    }
    public void extraerPlatilloXML(String nombrePlatillo){
        setNombre(extraerDato("nombre",nombre));
        setCodigo(extraerDato("codigo", nombre));
        setTamPorcion(extraerDato("tamPorcion", nombre));
        setPiezasPorPorcion(extraerDato("piezasPorPorcion", nombre));
        setCaloriasPorPorcion(extraerDato("caloriasPorPorcion", nombre));
        setCaloriasPorPieza(extraerDato("caloriasPorPieza", nombre));
        setPrecio(extraerDato("precio", nombre));
        disponible=("true".equals(extraerDato("disponible", nombre)));
    }
    
}
