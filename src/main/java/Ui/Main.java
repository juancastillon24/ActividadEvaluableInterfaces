package Ui;

import context.ContextService;
import model.DataService;
import model.Usuario;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.logging.Logger;

public class Main extends javax.swing.JFrame {
    private JPanel panel1;
    private JTable table1;
    private JButton añadirUsuarioButton;
    private JButton salirButton;
    private DataService dataService;

    private static Logger logger = Logger.getLogger(Main.class.getName());


    private ArrayList<Usuario> usuarios = new ArrayList<>();

    public Main(DataService ds) {
        dataService=ds;

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Añadir usuario");
        this.setResizable(false);
        this.setSize(800, 600);
        this.setLocationRelativeTo(null);

        this.setContentPane(panel1);

        var modelo = new DefaultTableModel();
        modelo.addColumn("Correo");
        modelo.addColumn("País");
        modelo.addColumn("Plataforma");
        table1.setModel(modelo);

        table1.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        table1.getSelectionModel().addListSelectionListener( (e)->{
                    if(!e.getValueIsAdjusting() && table1.getSelectedRow()>=0 ){
                        System.out.println("seleccionado: "+table1.getSelectedRow());
                        Usuario usuario = usuarios.get(table1.getSelectedRow());

                        ContextService.getInstance().addItem("usuarioSeleccionado",usuario);

                        (new Detalles()).setVisible(true);
                    }
                }
        );


        añadirUsuarioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                (new AñadirUsuario(dataService)).setVisible(true);
                loadDataTable();
            }
        });
        salirButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
    }

    private void loadDataTable() {
        DefaultTableModel modelo = (DefaultTableModel) table1.getModel();
        usuarios = (ArrayList<Usuario>) dataService.obtenerUsuarios();
        modelo.setRowCount(0);
        usuarios.forEach( (u)->{
            var fila =  new Object[]{ u.getEmail(), u.getPais(),u.getPlataforma() };
            modelo.addRow(fila);
        });
    }


    public void start(){
        this.setVisible(true);
    }
}
