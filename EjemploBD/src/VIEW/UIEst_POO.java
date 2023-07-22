package VIEW;

import CONTROLER.ConexionDB_Est;
import MODEL.Estudiante;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.util.ArrayList;

public class UIEst_POO {
    private JTable tbl_Mostrar;
    private JPanel panelprincipal;
    private JButton modificarButton;
    private JButton btn_Eliminar;
    private JButton btn_Agregar;
    private JButton btn_act;
    private JTextField txt_Buscador;
    private JButton buscarButton;
    private JLabel txt_err;
    String []titulos= {"Nombre","Cedula","Correo","Nota","Estado"};

    DefaultTableModel defaultTableModel= new DefaultTableModel(null,titulos);

    public void mostrarDatosTabla(){
        ConexionDB_Est obj = new ConexionDB_Est();
        ArrayList<Estudiante> listaEst = obj.getListaEstudiantes();
        if (!listaEst.isEmpty()) {
            String[][] datos = new String[listaEst.size()][5];
            for (int i = 0; i < listaEst.size(); i++) {
                datos[i][0]=listaEst.get(i).nombre;
                datos[i][1]=listaEst.get(i).cedula;
                datos[i][2]=listaEst.get(i).correo;
                datos[i][3]=String.valueOf(listaEst.get(i).notaFinal);
                datos[i][4]=listaEst.get(i).estado;
            }
            defaultTableModel.setDataVector(datos, titulos);
            tbl_Mostrar.setModel(defaultTableModel);
        }
    }
    public UIEst_POO() {
        tbl_Mostrar.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                super.componentResized(e);
                mostrarDatosTabla();
            }
        });
        btn_Agregar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Agregar agregar= new Agregar();
                agregar.iniciar();
                mostrarDatosTabla();
            }
        });
        btn_act.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mostrarDatosTabla();
            }
        });
        btn_Eliminar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Eliminar eliminar= new Eliminar();
                eliminar.iniciar();
            }
        });
        modificarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Modificar modificar= new Modificar();
                modificar.iniciar();
            }
        });
        buscarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String dt= txt_Buscador.getText();
                ConexionDB_Est c= new ConexionDB_Est();
                ArrayList<Estudiante> lstEst= c.getListaEstudiantes();
                ArrayList<Estudiante> mostrarEst= new ArrayList<>();
                for (Estudiante estudiante: lstEst){
                    if (dt.equals(estudiante.nombre)){
                        mostrarEst.add(estudiante);
                    }else if (dt.equals(estudiante.cedula)){
                        mostrarEst.add(estudiante);
                    }else if (dt.equals(estudiante.correo)){
                        mostrarEst.add(estudiante);
                    }else if (dt.equals(String.valueOf(estudiante.notaFinal))){
                        mostrarEst.add(estudiante);
                    }
                }
                if (!mostrarEst.isEmpty()) {
                    String[][] datos = new String[mostrarEst.size()][5];
                    for (int i = 0; i < mostrarEst.size(); i++) {
                        datos[i][0] = mostrarEst.get(i).nombre;
                        datos[i][1] = mostrarEst.get(i).cedula;
                        datos[i][2] = mostrarEst.get(i).correo;
                        datos[i][3] = String.valueOf(mostrarEst.get(i).notaFinal);
                        datos[i][4] = mostrarEst.get(i).estado;
                    }
                    defaultTableModel.setDataVector(datos, titulos);
                    tbl_Mostrar.setModel(defaultTableModel);
                    txt_err.setText("");
                } else {
                    txt_err.setText("No se encontraron datos para la búsqueda");
                }
            }
        });
    }

    public static void main(String[] args) {
        JFrame inicio= new JFrame("Steven si cobra");
        inicio.pack();
        inicio.setContentPane(new UIEst_POO().panelprincipal);
        inicio.setVisible(true);
    }
}
