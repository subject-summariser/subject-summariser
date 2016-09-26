/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sosproto;

import javax.swing.JOptionPane;

/**
 *
 * @author user
 */
public class SOSProto {
    /**
     * @param args the command line arguments
     */
    public static FormHandler allForms = new FormHandler();
    public static void main(String[] args) {
        System.out.println("Hello World!");
        
        LoginJFrame initialScreen = new LoginJFrame();
        initialScreen.setVisible(true);
    }
}
