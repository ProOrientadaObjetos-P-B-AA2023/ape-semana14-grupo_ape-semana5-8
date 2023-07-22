package VIEW;

import CONTROLER.ConexionDB_Est;
import MODEL.Estudiante;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Modificar {
    private JPanel panelAgregar;
    private JTextField txt_nombre;
    private JTextField txt_nota;
    private JTextField txt_correo;
    private JTextField txt_cedula;
    private JButton btn_OKagregar;
    private JButton buscarButton;
    public String cedula;
    private JFrame form2;


    public void iniciar() {
        form2 = new JFrame("Modificar");
        form2.setContentPane(panelAgregar);
        form2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        form2.pack();
        form2.setVisible(true);
    }

    public Modificar() {
        buscarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cedula= txt_cedula.getText();
                ConexionDB_Est obj = new ConexionDB_Est();
                ArrayList<Estudiante> listaEst = obj.getListaEstudiantes();
                for (Estudiante estudiante: listaEst){
                    if (cedula.equals(estudiante.cedula)){
                        txt_nombre.setText(estudiante.nombre);
                        txt_correo.setText(estudiante.correo);
                        txt_nota.setText(String.valueOf(estudiante.notaFinal));
                    }
                }
            }
        });
        btn_OKagregar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ConexionDB_Est conexionDB_est= new ConexionDB_Est();
                conexionDB_est.eliminarEstudiante(cedula);
                String nombre= txt_nombre.getText();
                String cedulaEst= txt_cedula.getText();
                String correo= txt_correo.getText();
                int nota= Integer.parseInt(txt_nota.getText());
                conexionDB_est.insertarEstudiante(new Estudiante(nombre,cedulaEst,correo,nota));
                form2.dispose();
            }
        });
    }
}
