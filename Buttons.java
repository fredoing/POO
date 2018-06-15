/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cliente;

/**
 * @author Jorge
 */
public interface Buttons {

    /**
     *Método que da el color de inicio a un botón.
     * @param panel el cual simulará ser el botón.
     */
    public void setColorInicial(javax.swing.JPanel panel);
    
    /**
     *Método el cual da el color de salida a un botón, con el fin de que parezca que al presionarlo, el usuario "está" sobre el botón
     * @param panel el cual representará el botón
     */
    public void setColorSalida(javax.swing.JPanel panel);
    
    /**
     *Se asegura de cambiar los colores necesarios y "hundir" la etiqueta para la acción de presionar botón
     * @param panel el cual cambiará al color original al ser presionado
     * @param etiqueta que será la elegida para poner un borde "lowered"
     */
    public void presionar(javax.swing.JPanel panel, javax.swing.JLabel etiqueta);

    /**
     *Se asegura de cambiar los colores necesarios y "elevar" la etiqueta para la acción de soltar el botón.
     * @param panel El panel que cambiará ahora al color final.
     * @param etiqueta que será la elegida para poner un borde "raised"
     */
    public void soltar(javax.swing.JPanel panel, javax.swing.JLabel etiqueta);
}
