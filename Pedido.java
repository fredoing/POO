/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iiiprogra;

/**
 *
 * @author josca
 */
public class Pedido extends Cliente {
    private String fecha;
    private int pedido;
    
    enum TipoPedido{
        SITIO, LLEVAR, EXPRESS
    }
    private TipoPedido tipopedido;
    
    
    /**
     * @return the fecha
     */
    public String getFecha() {
        return fecha;
    }

    /**
     * @param fecha the fecha to set
     */
    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    /**
     * @return the pedido
     */
    public int getPedido() {
        return pedido;
    }

    /**
     * @param pedido the pedido to set
     */
    public void setPedido(int pedido) {
        this.pedido = pedido;
    }
    
    public void ProcesarPedido(){
        
    }
    public void ObtenerListaAlimentos(){
        
    }
    public void EliminarAlimento(){
        
    }
    public void CalcularCosto(){
        
    }
    public void CalcularCalorias(){
        
    }
    public void LlenarInfoCliente(){
        
    }
    public void NotificarCosto(){
        
    }

}
