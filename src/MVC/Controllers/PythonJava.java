/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MVC.Controllers;

import MVC.Models.Assessment;
import MVC.Models.SubjectOutlineSummary;

import java.io.*;
import java.util.*;
import javax.swing.JOptionPane;

/**
 *
 * @author Andy
 */
public class PythonJava {
    
    private final String scriptFilePath = System.getProperty("user.dir") + "\\src\\PDFParser";
    private final List<String> summary = new ArrayList<>();
    
    SubjectOutlineSummary sos = new SubjectOutlineSummary();
    Assessment ass = new Assessment();
        
    public PythonJava()
    {
    }
    
    public void toSOS()
    {      
        // Fix to be dynamic
        sos.setSubjectName(summary.get(1));
        sos.addAssessment(summary.get(2), summary.get(3));
        sos.addAssessment(summary.get(4), summary.get(5));
        sos.addAssessment(summary.get(6), summary.get(7));
    }
    
    public boolean initPython(String filePath) 
    {
        int exitCode = runPythonScript(filePath);
        
        switch (exitCode) {
            case 0:
                JOptionPane.showMessageDialog(null, "PDF Parsed!");
//              Python-Java Interface
                break;
            case 2:
            case 6:
                JOptionPane.showMessageDialog(null, "Please open a valid file.");
//              Re-open ChooseOutlineFrame
                
            default:
                break;
        }
        System.out.println("Python Exit code: " + exitCode);
        return true;
    }

    public int runPythonScript(String filePath) 
    {
        String runPyCmd = "python SummariseSubjectOutline.py --path \"" + filePath + "\"";
        String s;
        try {
            Process p;
            p = Runtime.getRuntime().exec(runPyCmd, null,
                    new File(scriptFilePath));

            BufferedReader stdInput = new BufferedReader(new InputStreamReader(p.getInputStream()));

            System.out.println("Here is the standard output of the command:\n");
            while ((s = stdInput.readLine()) != null) {
                summary.add(s);                             ///////////////////////////////
                System.out.println(summary.toString());     /////////////////////////////
            }
            toSOS();                                        ///////////////////////////////
        } catch (IOException ex) {
//            Logger.getLogger(SOSProto.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "DEBUG:" + ex);
        }
        int exitCode = Integer.parseInt(summary.get(summary.size() - 1));

        return exitCode;
    }
    
    public SubjectOutlineSummary getSOS() {
        return sos;
    }
}
