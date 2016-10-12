/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MVC.Models;

import MVC.Views.Viewable;
import java.util.*;

/**
 *
 * @author Andy
 */
public class User extends Viewable {
    
    private String firstName;
    private String lastName;
    //Separate class for user login?
    private String email;
    private String password; 
    
    private LinkedList<SubjectOutlineSummary> SOS = new LinkedList<>();
    
    public User(String firstName, String lastName, String email, String password) //@param SOS from pdf parser?
    {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
    }
    
//    public void addSOS(SOS sos)
//    {
//        SOS.add(sos);
//        update();
//    }
    
    public String getName()
    {
        return firstName + lastName;
    }
    
    public String getFirstName()
    {
        return firstName;
    }
    
    public String getLastName()
    {
        return lastName;
    }
    
    public String getEmail() 
    {
        return email;
    }

    public String getPassword() 
    {
        return password;
    }

    public void setFirstName(String firstName) 
    {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) 
    {
        this.lastName = lastName;
    }

    public void setEmail(String email) 
    {
        this.email = email;
    }

    public void setPassword(String password) 
    {
        //@param verify_password
        this.password = password;
    }  
}
