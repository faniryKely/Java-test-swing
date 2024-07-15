package org.app;

import org.app.Swing.FormSignIn;

import javax.swing.*;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;

public class Main {
    public static void main(String[] args) throws  Exception {
        UIManager.setLookAndFeel(new NimbusLookAndFeel());

        FormSignIn window = new FormSignIn();
        window.setVisible(true);

        window.setLocationRelativeTo(null);
        window.setSize(800, 600);
    }
}