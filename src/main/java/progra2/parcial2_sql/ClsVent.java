/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package progra2.parcial2_sql;

import java.sql.*;

/**
 *
 * @author Josue
 */
public class ClsVent {

    public static void Vendedores(int id) {

        String url = "jdbc:mysql://localhost:3306/tbvendedores?zeroDateTimeBehavior=convertToNull&useSSL=false&useTimezone=true&serverTimezone=UTC";
        try {

            Connection conexion = DriverManager.getConnection(url, "root", "josh27");

            Statement sentencia = conexion.createStatement();

            String sql = "select * from new_table where id = "+id;

            ResultSet resultado = sentencia.executeQuery(sql);

            while (resultado.next()) {
                System.out.println("\nID =" + resultado.getInt(1));
                System.out.println("Nombre = " + resultado.getString(2));
                System.out.println("Enero =" + resultado.getInt(3));
                System.out.println("Febrero =" + resultado.getInt(4));
                System.out.println("Marzo =" + resultado.getInt(5));
                System.out.println("Abril =" + resultado.getInt(6));
                System.out.println("Mayo =" + resultado.getInt(7));
                System.out.println("Junio =" + resultado.getInt(8));
            }
        } catch (SQLException ex) {
            System.out.println("Hubo hay problemas:" + ex.getMessage());
        }
    }

    public static void SumasMesesVentas() {

        String url = "jdbc:mysql://localhost:3306/tbvendedores?zeroDateTimeBehavior=convertToNull&useSSL=false&useTimezone=true&serverTimezone=UTC";
        try {

            Connection conexion = DriverManager.getConnection(url, "root", "josh27");

            Statement sentencia = conexion.createStatement();

            String sql = "Select id, nombre, (enero+febrero+marzo+abril+mayo+junio) from new_table";
//            System.out.println(sql);

            ResultSet resultado = sentencia.executeQuery(sql);

            while (resultado.next()) {
                System.out.println("\nNiv =" + resultado.getInt(1));
                System.out.println("Vendedor = " + resultado.getString(2));
                System.out.println("Total meses venta =" + resultado.getInt(3));
            }

        } catch (SQLException ex) {
            System.out.println("Hubo clavo:" + ex.getMessage());
        }
    }

    public static void Actualizar(int id, String nombre) {
        String url = "jdbc:mysql://localhost:3306/tbvendedores?zeroDateTimeBehavior=convertToNull&useSSL=false&useTimezone=true&serverTimezone=UTC";
        try {

            Connection conexion = DriverManager.getConnection(url, "root", "josh27");

            Statement sentencia = conexion.createStatement();

            String sql = "Update new_tabel set nombre = '" + nombre + "' where id = " + id;
            System.out.println(sql);

            sentencia.execute(sql);

        } catch (SQLException ex) {
            System.out.println("Hubo clavo:" + ex.getMessage());
        }
    }

    public static void Eliminar(int id) {
        int cantidad1 = 0;
        String url = "jdbc:mysql://localhost:3306/tbvendedores?zeroDateTimeBehavior=convertToNull&useSSL=false&useTimezone=true&serverTimezone=UTC";
        try {

            Connection conexion = DriverManager.getConnection(url, "root", "josh27");

            Statement sentencia = conexion.createStatement();

            String sql = "delete from new_table where id = " + id;

            System.out.println(sql);

            sentencia.execute(sql);

        } catch (SQLException ex) {
            System.out.println("Hubo clavo:" + ex.getMessage());
        }
    }

 public static void sumames() {

        String url = "jdbc:mysql://localhost:3306/tbvendedores?zeroDateTimeBehavior=convertToNull&useSSL=false&useTimezone=true&serverTimezone=UTC";
        try {

            Connection conexion = DriverManager.getConnection(url, "root", "josh27");

            Statement sentencia = conexion.createStatement();

            String sql = "select sum(enero), sum(febrero), sum(marzo), sum(abril), sum(mayo), sum(junio) from new_table";

            ResultSet resultado = sentencia.executeQuery(sql);

            while (resultado.next()) {
                System.out.println("\n\nVentas totales por mes ");
                System.out.println("Enero ="+resultado.getInt(1));
                System.out.println("Febrero ="+resultado.getInt(2));
                System.out.println("Marzo ="+resultado.getInt(3));
                System.out.println("Abril ="+resultado.getInt(4));
                System.out.println("Mayo ="+resultado.getInt(5));
                System.out.println("Junio ="+resultado.getInt(6));
            }
        } catch (SQLException ex) {
            System.out.println("Hubo hay problemas:" + ex.getMessage());
        }
    }
    public static void main(String[] args) {
        Vendedores(4);
//SumasMesesVentas();
//     Actualizar(1,"Jisus");
//  Eliminar(2);
//sumames();
    }
}
