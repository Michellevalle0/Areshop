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
import java.sql.PreparedStatement;
/**
 *
 * @author Michelle
 */
public class Producto {
    
    private int id;
    private String nombre;
    private String marca;
    private String descripcion;
    private int cantidad;

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
             
             producto.add(p);
         }
         
          } catch (Exception ex){
           System.out.println("Ocurrio un error" + ex.getMessage());
       }
       
       return producto;
    }
    
    public static boolean guardar(Producto p) {
       boolean resultado = false;

       try {
            
            Connection con = Conexion.obtener();
            String consulta = "INSERT INTO productos (nombre,marca,descripcion,cantidad) VALUES (?,?,?,?) ";
            PreparedStatement st = con.prepareStatement(consulta);
            st.setString(1, p.getNombre());
            st.setString(2, p.getMarca());
            st.setString(3, p.getDescripcion());
            st.setInt(4,p.getCantidad() );
            resultado = st.execute();

        } catch (Exception e) {
            System.out.println(e);
        }

        return resultado;
    }
       /**
        * 
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

  
}
