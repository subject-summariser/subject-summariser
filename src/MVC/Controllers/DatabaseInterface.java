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

/**
 *
 * @author user
 */

public final class DatabaseInterface {
        
    private final String connectionString = "jdbc:derby://localhost:1527/sos_db;create=true;user=omanyte;password=bake";
    private static Statement SQLStatement = null;
    private int keyNumber;
    
    public DatabaseInterface()
    {
        keyNumber = getRowCount();
        keyNumber++;
        System.out.println("Row count = " + keyNumber);
    }
    
    public Connection connectToDB()
    {
        
        try
        {
           Connection dbConnection = DriverManager.getConnection(connectionString);
           System.out.println("Connection to database successful!");
           return dbConnection;
        }
        catch(SQLException e)
        {
            System.out.println("Failure connecting to database: " + e.getSQLState());
            return null;
        }
    }
    
    public void disconnectFromDB(Connection dbConnection)
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

    public PreparedStatement insertUserDetails(String firstName, String lastName, boolean isActive, String email, int subjectID) throws SQLException
    {
        Connection dbConnection = connectToDB();
        
        String rawQuery = "INSERT INTO OMANYTE.\"USER\" VALUES(?, ?, ?, ?, ?, ?)";
        PreparedStatement insertDetailsStatement = dbConnection.prepareStatement(rawQuery);
        
        insertDetailsStatement.setInt(1, keyNumber);
        insertDetailsStatement.setString(2, firstName);
        insertDetailsStatement.setString(3, lastName);
        insertDetailsStatement.setBoolean(4, isActive);
        insertDetailsStatement.setString(5, email);
        insertDetailsStatement.setInt(6, subjectID);
        insertDetailsStatement.execute();
        
        disconnectFromDB(dbConnection);
        
        return insertDetailsStatement;
    }
    
    public PreparedStatement insertPassword(String password) throws SQLException
    {
        //Note: password should be hashed before passing it as a parameter to this method
        Connection dbConnection = connectToDB();
        String rawQuery = "INSERT INTO OMANYTE.\"PASSWORD\" VALUES(?, ?, ?)";
        PreparedStatement insertPassword = dbConnection.prepareStatement(rawQuery);
        
        insertPassword.setInt(1, keyNumber);
        insertPassword.setString(2, password);
        insertPassword.setInt(3, keyNumber);
        insertPassword.execute();
        
        disconnectFromDB(dbConnection);
        
        return insertPassword;
    }
    
    public boolean executeRegister(String firstName, String lastName, boolean isActive, String email, int subjectID, String password)
    {
        try
        {
            insertUserDetails(firstName, lastName, isActive, email, subjectID);
            insertPassword(password);
            keyNumber++;
            return true;
        }
        catch(SQLException e)
        {
            System.out.print(e.getSQLState());
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
