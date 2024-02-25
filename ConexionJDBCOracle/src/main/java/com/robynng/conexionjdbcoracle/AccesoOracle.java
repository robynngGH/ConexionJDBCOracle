/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.robynng.conexionjdbcoracle;

import java.sql.*;

/**
 *
 * @author Robyn
 */
public class AccesoOracle {

    private Connection con;

    void abrirConexion() {
        try {
        Class.forName("oracle.jdbc.driver.OracleDriver");
        con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE",
                "SYS as SYSDBA", ""); //deleted password for security reasons

        System.out.println("Conexion OK");
        }
        catch (Exception e) {
            e.printStackTrace();
        }

    }

    void cerrarConexion() {
        try {
        System.out.println("Conexión cerrada");
        con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    void mostrarContactos() {
        try {
// Create a statement
        Statement st = con.createStatement();
        ResultSet resul = st.executeQuery("SELECT c.nombre, c.telefono FROM contactos c");
        System.out.println("INFORMACION DE CONTACTOS--------------");
        while (resul.next()) {
//aquí tambien podriamos poner resul.getInt("nif");
            System.out.println("\nNOMBRE: " + resul.getString(1)+ "\nTELEFONO: " + resul.getString(2));
        }
        System.out.println("\n--------------");
        resul.close();
        st.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    void insertarEstudiante(String id, String nombre, String telefono) {
        try {
            Statement st = con.createStatement();
            st.executeUpdate("INSERT INTO misAlumnos VALUES(estudiante('" + id +
                    "',persona('" + nombre + "','" + telefono + "')))");
            st.close();
            System.out.println("Alumno con nombre " + nombre + " insertado.");
        }
        catch (SQLException ex) {
            ex.printStackTrace();
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    
    boolean borrarAlumno(String nombre) {
        int resultado = 0; //recibirá el número de registros borrados
        
        try {
            Statement st = con.createStatement();
            resultado = st.executeUpdate("DELETE FROM misAlumnos a WHERE a.datos_personales.nombre = '" + nombre + "'");
            st.close();
        } 
        catch (SQLException ex) {
            ex.printStackTrace();
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
        return resultado > 0; //devolverá true si se ha eliminado algún registro
    }
    
    void telefonoAlumno(String nombre) {
        try {
        Statement st = con.createStatement();
        ResultSet resul = st.executeQuery("SELECT a.datos_personales.telefono FROM misAlumnos a");
        while (resul.next()) {
            System.out.println("\nTeléfono de " + nombre + ": " + resul.getString(1));
        }
        System.out.println("\n--------------");
        resul.close();
        st.close();
        }
        catch (SQLException ex) {
            ex.printStackTrace();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    void mostrarAlumnos() {
        try {
        Statement st = con.createStatement();
        ResultSet resul = st.executeQuery("SELECT a.id_estudiante, a.datos_personales.nombre,"
                + " a.datos_personales.telefono FROM misAlumnos a");
        System.out.println("INFORMACION DE ALUMNOS--------------");
        while (resul.next()) {
            System.out.println("\nID: " + resul.getString(1)+ "\nNOMBRE: "
                    + resul.getString(2) + "\nTELÉFONO: " + resul.getString(3));
        }
        System.out.println("\n--------------");
        resul.close();
        st.close();
        }
        catch (SQLException ex) {
            ex.printStackTrace();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    void mostrarAdmitidos() {
        try {
        Statement st = con.createStatement();
        ResultSet resul = st.executeQuery("SELECT a.dia, a.matriculado.id_estudiante,"
                + " a.matriculado.datos_personales.nombre, a.matriculado.datos_personales.telefono FROM admitidos a");
        System.out.println("INFORMACION DE ADMITIDOS--------------");
        while (resul.next()) {
            System.out.println("\nDIA: " + resul.getString(1)+ "\nID: "
                    + resul.getString(2) + "\nNOMBRE: " + resul.getString(3) + "\nTELÉFONO: " + resul.getString(4));
        }
        System.out.println("\n--------------");
        resul.close();
        st.close();
        }
        catch (SQLException ex) {
            ex.printStackTrace();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
