package org.app;

import org.app.Model.Player;
import org.app.Model.User;
import org.app.Service.LoginService;
import org.app.Swing.FormSignIn;
import org.app.Swing.RegistrationForm;

import javax.swing.*;


public class Main {
    public static void main(String[] args) throws  Exception {
        RegistrationForm form = new RegistrationForm(null);
        Player user = form.player;
        LoginService service = new LoginService();
        service.saveUser(user);


    }
}