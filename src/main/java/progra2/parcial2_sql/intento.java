/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package progra2.parcial2_sql;

import java.sql.Connection;
import java.sql.*;
/**
 *
 * @author Josue
 */
public class intento {
public static void ej1(int id){
    //paso 1 creamos la conexion a la base de datos
        String url = "jdbc:mysql://localhost:3306/tbvendedores?zeroDateTimeBehavior=convertToNull&useSSL=false&useTimezone=true&serverTimezone=UTC";
        try {
            //paso 2 creamos el objeto conexion
            Connection conexion = DriverManager.getConnection(url,"root","");
            //paso 3 creamos el objeto statement
            Statement sentencia = conexion.createStatement();
            //paso 4 creamos la instruccion
            String sql = "SELECT * FROM new_table  where codigo = "+id;
            // paso 5 ejecutamos el query
            ResultSet resultado = sentencia.executeQuery(sql);
            // paso 6. procesar el resultado
            // explicar como se maneja al siguiente registro
            while(resultado.next()){
                System.out.println("id ="+resultado.getInt(1));
                System.out.println("Nombre = "+resultado.getString(2));
                System.out.println("Enero ="+resultado.getInt(3));
                System.out.println("Febrero ="+resultado.getInt(4));
 System.out.println("Marzo ="+resultado.getInt(4));
 System.out.println("Abril ="+resultado.getInt(4));
 System.out.println(" ="+resultado.getInt(4));

            }
        } catch (SQLException ex) {
            System.out.println("Hubo clavo:"+ex.getMessage());
        }
}
  
    
    
      public static void ej2(int id,int nota1){
    //paso 1 creamos la conexion a la base de datos
        String url = "jdbc:mysql://localhost:3306/dbalumnos?zeroDateTimeBehavior=convertToNull&useSSL=false&useTimezone=true&serverTimezone=UTC";
        try {
            //paso 2 creamos el objeto conexion
            Connection conexion = DriverManager.getConnection(url,"root","");
            //paso 3 creamos el objeto statement
            Statement sentencia = conexion.createStatement();
            //paso 4 creamos la instruccion
            String sql = "update tb_alumnos  set nota1 = "+nota1+" where codigo = "+id;
            
            //este print nos sirve para analizar qué instrucción sql se va a ejecutar
            //System.out.println(sql);
            // paso 5 ejecutamos el query
            // tome atención que es diferente del paso 5 de la funcion ej1
            sentencia.execute(sql);
           
        } catch (SQLException ex) {
            System.out.println("Hubo clavo:"+ex.getMessage());
        }
}
    
    
    

    public static void main(String[] args) {
        ej2(4,100);
        ej1(4);
    }
}
