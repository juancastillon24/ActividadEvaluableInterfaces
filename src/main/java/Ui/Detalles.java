package Ui;

import context.ContextService;
import model.Usuario;

import javax.swing.*;
import java.awt.event.*;

public class Detalles extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JLabel lblCorreo;
    private JLabel lblPais;
    private JLabel lblPlataforma;
    private JButton buttonCancel;
    JFrame parent;


    public Detalles() {
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonOK);
        pack();
        setLocationRelativeTo(parent);

        Usuario usuario = (Usuario) ContextService.getInstance().getItem("usuarioSeleccionado").get();

        lblCorreo.setText(usuario.getEmail());
        lblPais.setText(usuario.getPais());
        lblPlataforma.setText(usuario.getPlataforma());
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
        // add your code here
        dispose();
    }
    private void onCancel() {
        dispose();
    }
}
