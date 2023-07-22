package VIEW;

import CONTROLER.ConexionDB_Est;
import MODEL.Estudiante;

import javax.swing.*;
import java.util.ArrayList;

public class TestEstudiante {
    public static void main(String[] args) {
        ConexionDB_Est obj= new ConexionDB_Est();
        System.out.println(obj.insertarEstudiante(new Estudiante("Josue","110456789","josuesa@utpl.edu.ec",8)));
        ArrayList<Estudiante> listaEst=obj.getListaEstudiantes();
        for(Estudiante est: listaEst){
            System.out.println(est);
        }
    }
}
