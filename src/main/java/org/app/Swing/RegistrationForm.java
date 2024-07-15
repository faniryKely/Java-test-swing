package org.app.Swing;

import javax.swing.*;
import java.awt.*;

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
        setVisible(true);
    }


}
