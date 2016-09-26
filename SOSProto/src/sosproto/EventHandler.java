/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sosproto;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.List;
import javafx.scene.control.Alert;
import javax.swing.JOptionPane;

/**
 *
 * @author user
 */
public class EventHandler {

    private final String scriptFilePath = System.getProperty("user.dir") + "\\SOSProto\\sosproto\\Scripts\\SubjectOutlineSummariser";
    private final List<String> summary = new ArrayList<>();
    
    public EventHandler() {
    }

    public void initPython(String filePath) {
        int exitCode = runPythonScript(filePath);
        switch (exitCode) {
            case 0:
                JOptionPane.showMessageDialog(null, "PDF Parsed!");
                if(writeSummaryToFile()){
                    JOptionPane.showMessageDialog(null, "Summary Text file creation successful!");
                }
                break;
            case 2:
            case 6:
                JOptionPane.showMessageDialog(null, "Please open a valid file.");
                SOSProto.allForms.openDirectory();
            default:
                break;
        }
        System.out.println("Python Exit code: " + exitCode);
    }

    public int runPythonScript(String filePath) {
        String runPyCmd = "python SummariseSubjectOutline.py --path \"" + filePath + "\"";
        String s;
        try {
            Process p;
            p = Runtime.getRuntime().exec(runPyCmd, null,
                    new File(scriptFilePath));

            BufferedReader stdInput = new BufferedReader(new InputStreamReader(p.getInputStream()));

            System.out.println("Here is the standard output of the command:\n");
            while ((s = stdInput.readLine()) != null) {
                summary.add(s);
            }
        } catch (IOException ex) {
            Logger.getLogger(SOSProto.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "DEBUG:" + ex);
        }
        int exitCode = Integer.parseInt(summary.get(summary.size() - 1));

        return exitCode;
    }

    private boolean writeSummaryToFile() {
        try {
            File file = new File("Outline Summary.txt");
            file.createNewFile();
            FileWriter writer = new FileWriter(file);
            for (String s : summary) {
                writer.append(s);
                writer.append("\r\n");
            }
            writer.flush();
            writer.close();
            return true;
        } catch (IOException e) {
            return false;
        }
    }
    
    public boolean loginParsing(String user, String pass){
        DatabaseManager manager = new DatabaseManager();
        String[] data = manager.getUser();
        if(user.equals(data[0]) && pass.equals(data[1])){
            SOSProto.allForms.openDirectory();
            //Open directory
            //dispose window
            //allForms.openDirectory();
            return true;
        }
        else{
            return false;
        }
    }

}
