package VIEW;

import CONTROLER.ConexionDB_Est;
import MODEL.Estudiante;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Agregar {
    private JPanel panelAgregar;
    private JTextField txt_nombre;
    private JTextField txt_nota;
    private JTextField txt_correo;
    private JTextField txt_cedula;
    private JButton btn_OKagregar;
    private JPanel panelprincipal;
    private JFrame form2;

    public void iniciar() {
        form2 = new JFrame("Agregar");
        form2.setContentPane(panelAgregar);
        form2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        form2.pack();
        form2.setVisible(true);
    }

    public Agregar() {
        btn_OKagregar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nombre = txt_nombre.getText();
                String cedula = txt_cedula.getText();
                String correo = txt_correo.getText();
                int nota = Integer.parseInt(txt_nota.getText());
                ConexionDB_Est ob = new ConexionDB_Est();
                ob.insertarEstudiante(new Estudiante(nombre, correo, cedula, nota));
                form2.dispose();
            }
        });
    }
}
