package VIEW;

import CONTROLER.ConexionDB_Est;
import MODEL.Estudiante;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Eliminar {
    private JTextField txt_cedula;
    private JButton btn_Eliminar;
    private JLabel txt_error;
    private JPanel panelEliminar;
    private JFrame form2;
    public void iniciar() {
        form2 = new JFrame("Eliminar");
        form2.setContentPane(panelEliminar);
        form2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        form2.pack();
        form2.setVisible(true);
    }

    public Eliminar() {
        btn_Eliminar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ConexionDB_Est obj = new ConexionDB_Est();
                ArrayList<Estudiante> listaEst = obj.getListaEstudiantes();
                String cedula=txt_cedula.getText();
                for (Estudiante estudiante: listaEst){
                    if (cedula.equals(estudiante.cedula)){
                        obj.eliminarEstudiante(cedula);
                    }
                }
                form2.dispose();
            }
        });
    }
}
