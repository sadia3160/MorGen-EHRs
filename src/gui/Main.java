package gui;

import com.formdev.flatlaf.FlatDarculaLaf;
import com.formdev.flatlaf.FlatIntelliJLaf;
import com.formdev.flatlaf.FlatLightLaf;
import com.formdev.flatlaf.themes.FlatMacLightLaf;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main{

    public static void main(String[] args) {

        try{
            UIManager.setLookAndFeel(new FlatLightLaf());
            UIManager.put("Button.arc", 21);

        } catch (Exception e) {
            e.printStackTrace();
            return;
        }

        SwingUtilities.invokeLater( () -> {  log(); } );

    }
    private static void log(){
        LoginPage login = new LoginPage();
    }
}
