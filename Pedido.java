/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cliente;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

enum TipoPedido{
    SITIO, LLEVAR, EXPRESS
}

/**
 *
 * @author josca
 */
public class Pedido extends Cliente {
    private String fecha;
    private ArrayList<String> pedido;
    private ArrayList<String> cantidad;
    private ArrayList<String> precio;
    private TipoPedido tipopedido;

    /**
     * @return the fecha
     */
    public String getFecha() {
        return fecha;
    }

    /**
     * @return the pedido
     */
    public ArrayList<String> getPedido() {
        return pedido;
    }

    /**
     * @return the cantidad
     */
    public ArrayList<String> getCantidad() {
        return cantidad;
    }

    /**
     * @return the precio
     */
    public ArrayList<String> getPrecio() {
        return precio;
    }

    /**
     * @param fecha the fecha to set
     */
    public void setFecha() {
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
	Date date = new Date();
        this.fecha = dateFormat.format(date);
    }

    /**
     * @param pedido the pedido to set
     */
    public void setPedido(ArrayList<String> pedido) {
        this.pedido = pedido;
    }

    /**
     * @param cantidad the cantidad to set
     */
    public void setCantidad(ArrayList<String> cantidad) {
        this.cantidad = cantidad;
    }

    /**
     * @param precio the precio to set
     */
    public void setPrecio(ArrayList<String> precio) {
        this.precio = precio;
    }

    /**
     * @return the tipopedido
     */
    public TipoPedido getTipopedido() {
        return tipopedido;
    }
    
    public void setNombre(String nombre){
        this.nombre = nombre;
    }
    
    public void setCelular(String cel){
        this.celular = cel;
    }
    
    public void setDir(String dir){
        this.direccion = dir;
    }

    /**
     * @param tipopedido the tipopedido to set
     */
    public void setTipopedido(String tipopedido) {
        if(tipopedido=="En sitio"){  
            this.tipopedido = TipoPedido.SITIO;
        }
        else if(tipopedido=="Llevar"){
            this.tipopedido = TipoPedido.LLEVAR;
        }
        else if(tipopedido=="Express"){
            this.tipopedido = TipoPedido.EXPRESS;
        }
    }
    
    public void procesarPedido(){
        Utilidades util = new Utilidades();
        String tipo = "";
        if (this.getTipopedido()==TipoPedido.SITIO){
            tipo = "En Sitio";
        }
        else if(this.getTipopedido()==TipoPedido.LLEVAR){
            tipo = "Llevar";
        }
        else if(this.getTipopedido()==TipoPedido.EXPRESS){
            tipo = "Express";
        }
        setFecha();
        util.agregaPedido(nombre, celular, direccion, pedido, cantidad, precio, tipo, this.fecha);
        util.vecesP(pedido, cantidad);
    }
    
}
