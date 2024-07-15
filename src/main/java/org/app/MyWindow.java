package org.app;

import javax.swing.*;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyWindow extends JFrame {
    private JButton OKButton;
    private JTextField textField;
    public MyWindow() {
        super("Chifoumi");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(new Dimension(650, 400));
        this.setLocationRelativeTo(null);

        JPanel contentPane = (JPanel) this.getContentPane();
        contentPane.setLayout(new FlowLayout());

        textField = new JTextField(20);
        OKButton = new JButton("OK");
        contentPane.add(textField);
        contentPane.add(OKButton);
        contentPane.add(new JButton("Canceled"));

        showName();
    }

    public void showName() {
        OKButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                JOptionPane.showMessageDialog(OKButton, "Created Successfully");
            }
        });
    }

}
