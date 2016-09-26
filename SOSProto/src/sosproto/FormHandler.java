/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sosproto;

/**
 *
 * @author user
 */
public class FormHandler {
    private LoginJFrame loginWindow;
    private DirectoryForm directoryWindow;    
    
    public void openLogin(){
        loginWindow = new LoginJFrame();
        loginWindow.setVisible(true);
    }
    
    public void closeLogin(){
        loginWindow.dispose();
    }
    
    public void openDirectory(){
        directoryWindow = new DirectoryForm();
        directoryWindow.setVisible(true);
    }
    
    public void closeDirectory(){
        directoryWindow.dispose();
    }
    
}
