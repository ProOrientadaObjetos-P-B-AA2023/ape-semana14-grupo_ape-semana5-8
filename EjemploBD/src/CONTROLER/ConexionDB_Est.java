package CONTROLER;

import MODEL.Estudiante;

import java.sql.*;
import java.util.ArrayList;

public class ConexionDB_Est {
    public Connection concDB;
    public ArrayList<Estudiante> listaEstudiantes;
    public String msj;

    public void setConcDB(String url) {
        try{
            this.concDB=DriverManager.getConnection(url);
        }catch(SQLException sqlException){
            this.msj=sqlException.getMessage();
        }
    }

    public ArrayList<Estudiante> getListaEstudiantes() {
        try{
            listaEstudiantes=new ArrayList<Estudiante>();
            setConcDB("jdbc:sqlite:EjemploBD/bd/DB_EstPOO.db");
            Statement statement= concDB.createStatement();
            ResultSet resultSet= statement.executeQuery("select * from Estudiante");
            while(resultSet.next()){
                listaEstudiantes.add(new Estudiante(resultSet.getString("nombre"),
                        resultSet.getString("cedula"),
                        resultSet.getString("correo"),
                        resultSet.getInt("notaFinal"),
                        resultSet.getString("estado")));
            }
            statement.close();
        }catch(SQLException sqlException){
            this.msj=sqlException.getMessage();
        }
        return listaEstudiantes;
    }
    public String insertarEstudiante(Estudiante est){
        try{
            est.establecerEstado();
            setConcDB("jdbc:sqlite:EjemploBD/bd/DB_EstPOO.db");
            Statement statement= concDB.createStatement();
            String strInsertEst=String.format("insert into Estudiante(nombre, cedula, correo, notaFinal, estado) values('%s', '%s', '%s', %d, '%s')", est.nombre,est.cedula,est.correo,est.notaFinal,est.estado);
            statement.executeUpdate(strInsertEst);
            statement.close();
        }catch(SQLException sqlException){
            this.msj=sqlException.getMessage();
        }
        return msj;
    }
    public void eliminarEstudiante(String cedula) {
        try {
            setConcDB("jdbc:sqlite:EjemploBD/bd/DB_EstPOO.db");
            Statement statement=concDB.createStatement();
            String strDeleteEst="DELETE FROM Estudiante WHERE cedula='"+cedula + "'";
            statement.executeUpdate(strDeleteEst);
            statement.close();
        } catch (SQLException sqlException) {
            this.msj = sqlException.getMessage();
        }
    }


}
