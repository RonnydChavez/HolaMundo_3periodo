/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.holamundo_3periodo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author ronny
 */
public class HolaMundo_3periodo {

    public static void main(String[] args) throws SQLException {
        System.out.println("Ejecutando operaciones en tabla Alumnos....");
        
        Connection cn= ConexionDB.getConexion();
        if(cn==null){
            System.out.println("no se puede establecer conexión....");
            return;
        }
        PreparedStatement psInsertar=null;
        PreparedStatement psSeleccionar=null;
        PreparedStatement psActualizar=null;
        PreparedStatement psEliminar=null;
        ResultSet rs=null;
        
        
        
        try{
/*
            //El Create
           System.out.println("\n 1. Intentando insertar nuevo alumno....");
           String psInsert="INSERT INTO Alumnos(nombre, correo) VALUES(?,?)";
           psInsertar=cn.prepareStatement(psInsert);
           //asignacion
           psInsertar.setString(1, "Trinidad Cabañas");
           psInsertar.setString(2, "TrinidadElMero@uth.hn");
           //ejecucion
           int filasAfectadas=psInsertar.executeUpdate();
           if(filasAfectadas>0){
               System.out.println("Alumno Insertado con Exito....");
           }
*/
/*
            //la UPDATE
            System.out.println("\n2. Intentando actualizar un alumno....");
             String sqlUpdate = "UPDATE Alumnos SET nombre = ?, correo = ? WHERE id = ?";
             psActualizar = cn.prepareStatement(sqlUpdate);
             psActualizar.setString(1, "Don Quijote");
             psActualizar.setString(2, "ELQuinjote@uth.hn");
             psActualizar.setInt(3, 14);

             int filasActualizadas = psActualizar.executeUpdate();
             if (filasActualizadas > 0) {
                 System.out.println("Alumno Actualizado con Éxito....");
             } else {
                 System.out.println("No se encontró ningún alumno con el ID especificado.");
             }
*/

            //El DELETE
            System.out.println("\n3. Intentando eliminar un alumno....");
            String sqlDelete = "DELETE FROM Alumnos WHERE id = ?";
            psEliminar = cn.prepareStatement(sqlDelete);
            psEliminar.setInt(1, 14);
            int filasEliminadas = psEliminar.executeUpdate();
            if (filasEliminadas > 0) {
                System.out.println("Alumno Elimando con Éxito....");
            } else {
                System.out.println("No se encontró ningún alumno con el ID especificado para eliminar.");
            }

/*
            //EL READ
            System.out.println("\n4 Consulta de lista de Alumno en la Base de Datos");
            String sqlSelect="SELECT id, nombre, correo FROM Alumno";
            psSeleccionar =cn.prepareStatement(sqlSelect);
            rs=psSeleccionar.executeQuery();
            System.out.println("\n===============================================================");
            System.out.println("ID       |nombre         |Correo");
            System.out.println("\n===============================================================");
            while(rs.next()){
                int id=rs.getInt("id");
                String nombre =rs.getString("nombre");
                String Correo =rs.getString("Correo");

                System.out.printf("%-3d | %-20s | %s\n", id, nombre, Correo);

            }
*/
        }catch(SQLException e){
            System.err.println("Ocurrio un error con la base de datos...." + e.getMessage());
        }finally{
            if(rs!= null){
                rs.close();
            }
            if(psInsertar!=null)psInsertar.close();
            if(psSeleccionar !=null)psSeleccionar.close();
            ConexionDB.CerrarCeonxion();
        }
    }
}
