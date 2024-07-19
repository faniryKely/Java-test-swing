package org.app.Swing;

import jdk.swing.interop.DispatcherWrapper;
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
    private JTextField tfEmail;
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
                JOptionPane.showMessageDialog(RegistrationForm.this, "User registered successfully!");
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
        String firstName = tfName.getText();
        String lastName = tfFirstName.getText();
        String email = tfEmail.getText();
        String password = new String(passwordField.getPassword());
        String confirmPassword = new String(confirmPsw.getPassword());

        if(firstName.isEmpty() || lastName.isEmpty() || email.isEmpty() || password.isEmpty() || confirmPassword.isEmpty()) {
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

       LoginService service = new LoginService();
       user =  service.SaveUser(new User(
                firstName,
                lastName,
                email,
                password
        ));
        if(user != null) {
            dispose();
        } else {
            JOptionPane.showMessageDialog(this, "Something went wrong", "Try Again", JOptionPane.ERROR_MESSAGE);
        }

    }
    public User user;

}
