/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MVC.Controllers;

import javax.swing.JFrame;

/**
 *
 * @author Andy
 */
public class ViewController {
    
    public static int userID;
    
    public ViewController()
    {
    }
    
    public void OpenNewFrame(JFrame closeFrame, JFrame openFrame)
    {
        closeFrame.setVisible(false);
        closeFrame.dispose();
        openFrame.setVisible(true);
    }
    
    public int getUserID()
    {
        return userID;
    }
    
    public void setUserID(int id)
    {
        userID = id;
    }
    
}
