package Ui;

import model.DataService;
import model.Usuario;

import javax.swing.*;
import java.awt.event.*;

public class AñadirUsuario extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JComboBox comboBoxPais;
    private JTextField textCorreo;
    private JComboBox comboBoxPlataforma;

    private DataService dataService;

    JFrame parent;

    public AñadirUsuario(DataService ds) {

        dataService = ds;
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonOK);
        pack();
        setLocationRelativeTo(parent);

        buttonOK.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onOK();
            }
        });

        buttonCancel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        });

        // call onCancel() when cross is clicked
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                onCancel();
            }
        });

        // call onCancel() on ESCAPE
        contentPane.registerKeyboardAction(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        }, KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
    }

    private void onOK() {
        Usuario usuario = new Usuario();
        usuario.setEmail(textCorreo.getText());
        usuario.setPais(comboBoxPais.getSelectedItem().toString());
        usuario.setPlataforma(comboBoxPlataforma.getSelectedItem().toString());

        if(dataService.guardar(usuario).isEmpty()){
            JOptionPane.showMessageDialog(this, "Error al guardar","",JOptionPane.WARNING_MESSAGE);
        } else dispose();
    }

    private void onCancel() {
        // add your code here if necessary
        dispose();
    }
}
