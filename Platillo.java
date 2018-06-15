/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cliente;

/**
 *
 * @author Jorge
 */
public final class Platillo extends Utilidades {
    private String nombre, codigo,tamPorcion, piezasPorPorcion, caloriasPorPorcion, caloriasPorPieza, precio, DetalleDescripcion;
    private boolean disponible;
    
    /**Método constructor que se encarga de inicializar el platillo con el nombre y el resto de atributos nulos
     * @param nombre
     */
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

    /**
     *Método que retorna el nombre
     * @return
     */
    public String getNombre() {
        return nombre;
    }

    /**
     *Método que inicializa el nombre en el valor del dato ingresado.
     * @param nombre
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     *Método que retorna el código
     * @return
     */
    public String getCodigo() {
        return codigo;
    }

    /**
     *Método que modifica el calor del atributo código
     * @param codigo
     */
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    /**
     *Método que retorna el tamaño de la porción
     * @return
     */
    public String getTamPorcion() {
        return tamPorcion;
    }

    /**
     *Método que asigna el valor al atributo tamaño de porción
     * @param tamPorcion
     */
    public void setTamPorcion(String tamPorcion) {
        this.tamPorcion = tamPorcion;
    }

    /**
     *Método que retorna piezas por porción
     * @return
     */
    public String getPiezasPorPorcion() {
        return piezasPorPorcion;
    }

    /**
     *Método que asigna el valor ingresado al atributo interno de Piezas por porción
     * @param piezasPorPorcion
     */
    public void setPiezasPorPorcion(String piezasPorPorcion) {
        this.piezasPorPorcion = piezasPorPorcion;
    }

    /**
     *Método que retorna las calorías por porción
     * @return
     */
    public String getCaloriasPorPorcion() {
        return caloriasPorPorcion;
    }

    /**
     *Set que asigna el valor ingresado al atributo interno de calorías por porción
     * @param caloriasPorPorcion
     */
    public void setCaloriasPorPorcion(String caloriasPorPorcion) {
        this.caloriasPorPorcion = caloriasPorPorcion;
    }

    /**
     *Método que retorna las calorías por pieza.
     * @return
     */
    public String getCaloriasPorPieza() {
        return caloriasPorPieza;
    }

    /**
     *Set correspondiente al atributo CaloriasPorPieza
     * @param caloriasPorPieza
     */
    public void setCaloriasPorPieza(String caloriasPorPieza) {
        this.caloriasPorPieza = caloriasPorPieza;
    }

    /**
     *Método que retorna el precio
     * @return
     */
    public String getPrecio() {
        return precio;
    }

    /**
     *Set correspondiente al atributo de precio
     * @param precio
     */
    public void setPrecio(String precio) {
        this.precio = precio;
    }

    /**
     *Método que retorna el detalle de descripción del platillo
     * @return
     */
    public String getDetalleDescripcion() {
        return DetalleDescripcion;
    }

    /**
     *Set correspondiente al detalle de descripción
     * @param DetalleDescripcion
     */
    public void setDetalleDescripcion(String DetalleDescripcion) {
        this.DetalleDescripcion = DetalleDescripcion;
    }

    /**
     *método que nos dice si el objeto está o no disponible
     * @return true/false
     */
    public boolean isDisponible() {
        return disponible;
    }

    /**
     *Set del atributo disponible
     * @param disponible
     */
    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }
     
    @Override
    public String extraerDato(String tag, String dish) {
        return super.extraerDato(tag, dish); //To change body of generated methods, choose Tools | Templates.
    }
    
    /** Método encargado de "setear" toda a información de un determinado platillo, proveniente del xml
     * @param nombrePlatillo
     */
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
