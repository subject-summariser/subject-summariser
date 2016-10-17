/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MVC.Controllers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author user
 */

public final class DatabaseInterface {
        
    private final String connectionString = "jdbc:derby://localhost:1527/sos_db;create=true;user=omanyte;password=bake";
    private static Statement SQLStatement = null;
    private int keyID;
    
    public DatabaseInterface()
    {
        keyID = getRowCount();
        keyID++;
        System.out.println("Row count = " + keyID);
    }
    
    private Connection connectToDB()
    {
        try
        {
           Connection dbConnection = DriverManager.getConnection(connectionString);
           System.out.println("Connection to database successful!");
           return dbConnection;
        }
        catch(SQLException e)
        {
            System.out.println("Failure connecting to database: " + e.getSQLState() + " " + e);
            return null;
        }
    }
    
    private void disconnectFromDB(Connection dbConnection)
    {
        try
        {
            dbConnection.close();
        }
        catch(SQLException e)
        {
            System.out.println("Failure trying to disconnect: " + e.getSQLState());
        }
    }

    //Password should be hashed before it is passed through this method
    public String[] selectUser(String email, String password)
    {
        String data[] = new String[3];
        Connection dbConnection = connectToDB();
        ResultSet loginData;
        
        String rawQuery = 
                "Select u.EMAIL, p.PASSWORD, u.ID From OMANYTE.\"USER\" "
                + "u join OMANYTE.PASSWORD p on u.ID = p.USER_ID "
                + "Where u.EMAIL like '%" + email + "%' AND p.PASSWORD = '" + password + "'";
        
        try
        {
            PreparedStatement selectEmailAndPassword = dbConnection.prepareStatement(rawQuery);

            loginData = selectEmailAndPassword.executeQuery();
            while(loginData.next())
            {
                data[0] = loginData.getString(1);
                data[1] = loginData.getString(2);
                data[2] = Integer.toString(loginData.getInt(3));
            }
        }
        catch(SQLException e)
        {
            System.out.println("Failure at selectUser: " + e.getSQLState() + " " + e);
        }

        
        disconnectFromDB(dbConnection);
        return data;
    }
    
    public boolean checkDuplicateEmail(String email)
    {
        Connection dbConnection = connectToDB();
        String anEmail = null;
        String rawQuery = "SELECT * FROM OMANYTE.\"USER\" WHERE EMAIL LIKE '" + email + "'";
        ResultSet emailData;
        
        try
        {
            PreparedStatement selectEmail = dbConnection.prepareStatement(rawQuery);
            emailData = selectEmail.executeQuery();
            
            while(emailData.next())
            {
                anEmail = emailData.getString(1);
            }
        }
        catch (SQLException e)
        {
            System.out.println("Failure at checkEmail" + e.getSQLState() + " " + e);
        }
        return anEmail == null;
    }
    
    public boolean authenticateUser(ResultSet data)
    {
        String email = null;
        String password = null;
        try 
        {
            while(data.next())
            {
                email = data.getString(1);
                password = data.getString(1);
            }
        } 
        catch (SQLException e) 
        {
            System.out.println("Failed at authentication:" + e.getSQLState() + " " + e);
        }
        return !(email == null || password == (null));
    }
    
    private boolean insertUserDetails(String firstName, String lastName, boolean isActive, String email, int subjectID)
    {
        Connection dbConnection = connectToDB();
        boolean success = true;
        String rawQuery = "INSERT INTO OMANYTE.\"USER\" VALUES(?, ?, ?, ?, ?, ?)";
        
        try
        {
            PreparedStatement insertDetailsStatement = dbConnection.prepareStatement(rawQuery);

            insertDetailsStatement.setInt(1, keyID);
            insertDetailsStatement.setString(2, firstName);
            insertDetailsStatement.setString(3, lastName);
            insertDetailsStatement.setBoolean(4, isActive);
            insertDetailsStatement.setString(5, email);
            insertDetailsStatement.setInt(6, subjectID);
            insertDetailsStatement.execute();         
        }
        catch(SQLException e)
        {
            System.out.println("Failure at inserting password: " + e.getSQLState());
            success = false;            
        }
        finally
        {
            disconnectFromDB(dbConnection);            
        }

        return success;
    }
    
    private boolean insertPassword(String password)
    {
        //Note: password should be hashed before passing it as a parameter to this method
        Connection dbConnection = connectToDB();
        boolean success = true;
        String rawQuery = "INSERT INTO OMANYTE.\"PASSWORD\" VALUES(?, ?, ?)";
        try
        {
            PreparedStatement insertPassword = dbConnection.prepareStatement(rawQuery);
            insertPassword.setInt(1, keyID);
            insertPassword.setString(2, password);
            insertPassword.setInt(3, keyID);
            insertPassword.execute();
        }
        catch(SQLException e)
        {
            System.out.println("Failure at inserting password: " + e.getSQLState() + " " + e);
            success = false;
        }
        finally
        {
            disconnectFromDB(dbConnection);
        }
        
        return success;
    }
    
    //Put into different class
    public boolean executeUserRegistration(String firstName, String lastName, boolean isActive, String email, int subjectID, String password)
    {
        if(insertUserDetails(firstName, lastName, isActive, email, subjectID) && insertPassword(password))
        {
            keyID++;
            return true;
        }
        else
        {
            discardQueryChanges();
            return false;
        }
    }
    
    private int getRowCount()
    {
        ResultSet rawData;
        Connection dbConnection = connectToDB();
        int rowCount = -1;
        try
        {
            SQLStatement = dbConnection.createStatement();
            rawData = SQLStatement.executeQuery("SELECT COUNT(*) FROM OMANYTE.\"USER\"");
            while(rawData.next())
            {
                rowCount = Integer.parseInt(rawData.getString(1));
            }
            SQLStatement.close();
            }
        catch(SQLException e)
        {
            System.out.println("Failure at getRowCount: " + e.getSQLState() + " " + e);
        }
        return rowCount;
    }
    
    private void discardQueryChanges()
    {
        
    }
}
