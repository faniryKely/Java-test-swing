package org.app;

import org.app.Model.User;
import org.app.Swing.FormSignIn;
import org.app.Swing.RegistrationForm;

import javax.swing.*;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;

public class Main {
    public static void main(String[] args) throws  Exception {
        RegistrationForm form = new RegistrationForm(null);
        User user = form.user;
        if(user != null) {
            System.out.println("successful registration " + user.getFirstName());
        } else {
            System.out.println("unsuccessful registration ");
        }
    }
}