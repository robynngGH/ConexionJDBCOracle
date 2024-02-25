/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.robynng.conexionjdbcoracle;

/**
 *
 * @author Robyn
 */
public class ConexionJDBCOracle {

    public static void main(String[] args) {
        AccesoOracle acceso = new AccesoOracle();
        acceso.abrirConexion();
        //acceso.mostrarContactos();
        //acceso.insertarEstudiante("04D", "Marta Lucía", "999000111");
        //acceso.insertarEstudiante("03C", "Javier Roca", "888999000");
        if (acceso.borrarAlumno("Javier Roca"))
            System.out.println("Alumno borrado.");
        else System.out.println("Alumno no encontrado");
        //acceso.telefonoAlumno("Azucena Martínez");
        //acceso.mostrarAlumnos();
        //acceso.mostrarAdmitidos();
        acceso.cerrarConexion();
    }
}
