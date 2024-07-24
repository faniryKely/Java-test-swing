package org.app.Swing;

import jdk.swing.interop.DispatcherWrapper;
import org.app.Model.Player;
import org.app.Model.User;
import org.app.Service.LoginService;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;

public class RegistrationForm extends JDialog{
    private JTextField tfName;
    private JTextField tfFirstName;
    private JPasswordField passwordField;
    private JPasswordField confirmPsw;
    private JButton btnRegister;
    private JButton btnCancel;
    private JPanel registerPanel;


    public RegistrationForm(JFrame parent) {
        super(parent);
        setTitle("Registration");
        setContentPane(registerPanel);
        setMinimumSize(new Dimension(800, 500));
        setModal(true);
        setLocationRelativeTo(parent);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        btnRegister.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                registerUser();
                JOptionPane.showMessageDialog(RegistrationForm.this, " " + player.getName() + " registered successfully!" ) ;
                JFrame ACCEUIL = new Acceuil();
                ACCEUIL.setVisible(true);
            }
        });
        btnCancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                dispose();
            }
        });

        setVisible(true);
    }

    private void registerUser() {
        // user information
        String name = tfName.getText();
        String lastName = tfFirstName.getText();
        String password = new String(passwordField.getPassword());
        String confirmPassword = new String(confirmPsw.getPassword());

        if(name.isEmpty() || lastName.isEmpty() || password.isEmpty() || confirmPassword.isEmpty()) {
            JOptionPane.showMessageDialog(
                    this,
                    "Please fill all fields",
                    "Try Again",
                    JOptionPane.ERROR_MESSAGE
            );
            return;
        }

        if(!password.equals(confirmPassword)) {
            JOptionPane.showMessageDialog(this, "Passwords do not match", "Try Again", JOptionPane.ERROR_MESSAGE);

        }
        if (password.length() < 8) {
            JOptionPane.showMessageDialog(this, "Password must be at least 8 characters", "Try Again", JOptionPane.ERROR_MESSAGE);

        }

        var service = new LoginService();
       player =  service.saveUser(new Player(
                name,
                lastName,
                password
        ));

        if(player != null) {
            dispose();
        } else {
            JOptionPane.showMessageDialog(this, "Something went wrong", "Try Again", JOptionPane.ERROR_MESSAGE);
        }

    }
    public Player player;

}
