/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.itson.areshop.entidades;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import mx.itson.areshop.persistencia.Conexion;

/**
 *
 * @author Michelle
 */
public class Producto {

 
    /**
     *  Donde se definen  los datos de producto
     */
    
    private int id;
    private String nombre;
    private String marca;
    private String descripcion;
    private int cantidad;
    private String precio;
    private int total;

    /*
    El metodo obtener todos nos sirve para declarar el encabezado de un método, 
    basta con escribir el tipo que retorna, seguido del nombre del método 
    y entre paréntesis la lista de parámetros.
    */
    public static List<Producto>  obtenerTodos(){
     List<Producto> producto = new ArrayList<>();
     try{
         Connection conexion = Conexion.obtener();
         Statement statement = conexion.createStatement();
          ResultSet resultSet = statement.executeQuery("SELECT * FROM areshop.productos");
         
         while (resultSet.next()){
             Producto p = new Producto();
             p.setId(resultSet.getInt(1));
             p.setNombre(resultSet.getString(2));
             p.setMarca(resultSet.getString(3));
             p.setDescripcion(resultSet.getString(4));
             p.setCantidad(resultSet.getInt(5));
             p.setPrecio(resultSet.getNString(6));
             p.setTotal(resultSet.getInt(7));
             
             producto.add(p);
         }
         
          } catch (Exception ex){
           System.out.println("Ocurrio un error" + ex.getMessage());
       }
       
       return producto;
    }
       /**
        * get:Nos permite acceder a los valores de los atributos.
        * set:Su función permite brindar acceso a propiedades especificas 
        * para poder asignar un valor fuera de la clase.
        * @return 
        */

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
     /**
     * @return the precio
     */
    public String getPrecio() {
        return precio;
    }

    /**
     * @param precio the precio to set
     */
    public void setPrecio(String precio) {
        this.precio = precio;
    }
    
   
    /**
     * @return the total
     */
    public int getTotal() {
        return total;
    }

    /**
     * @param total the total to set
     */
    public void setTotal(int total) {
        this.total = total;
    }

  
}
