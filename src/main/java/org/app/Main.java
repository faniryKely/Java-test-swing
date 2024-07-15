package org.app;

import javax.swing.*;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;
import java.awt.*;

public class Main {
    public static void main(String[] args) throws  Exception {
        UIManager.setLookAndFeel(new NimbusLookAndFeel());

        MyWindow window = new MyWindow();
        window.setVisible(true);

        window.setLocationRelativeTo(null);
        window.setSize(800, 600);
    }
}