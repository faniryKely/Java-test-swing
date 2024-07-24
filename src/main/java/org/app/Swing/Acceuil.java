package org.app.Swing;

import javax.swing.*;
import java.awt.*;

public class Acceuil extends JFrame {

    public Acceuil() throws HeadlessException {
        setTitle("Acceuil");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(400,500);

        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBackground(Color.WHITE);
        panel.setBounds(0,0,400,500);
        add(panel);

        JLabel lblNewLabel = new JLabel("Acceuil");
        lblNewLabel.setBounds(22,22,200,100);
        panel.add(lblNewLabel);



    }

    public static void main(String[] args) {

    }
}
