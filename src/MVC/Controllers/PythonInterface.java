/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MVC.Controllers;

import MVC.Models.Assessment;
import MVC.Models.SubjectOutlineSummary;
import MVC.Models.Date;

import java.io.*;
import java.util.*;
import javax.swing.JOptionPane;

/**
 *
 * @author Josh, Andy and Mel
 */
public class PythonInterface {
    
    private final String scriptFilePath = System.getProperty("user.dir") + "\\src\\PDFParser";
    private final List<String> summary = new ArrayList<>();
    
    private SubjectOutlineSummary sos = new SubjectOutlineSummary();
    private Assessment ass;
        
    public PythonInterface()
    {
    }
    
    public void toSOS(String s)
    {      
        String splitStr[] = s.split(": ", 2);
        
        switch (splitStr[0])
        {
            case ("<Subject"):
                String subjStr[] = splitStr[1].split(" ", 2);
                sos.setSubjectNb(Integer.parseInt(subjStr[0]));
                sos.setSubjectName(subjStr[1]);
                break;
            case ("<Contact"):
                sos.setKeyContacts(splitStr[1]);
                break;
            case ("<Content"):
                sos.setSubjectContent(splitStr[1]);
                break;
            case ("<Minimum requirements"):
                sos.setMinimumReq(splitStr[1]);
                break;
            case ("<Supplementary assessments"):
                sos.setSuppAssessments(splitStr[1]);
                break;
            case ("<Late Penalty"):
                sos.setLateAssessmentPenalty(splitStr[1]);
                break;
            case ("<Required texts"):
                sos.setReqTexts(splitStr[1]);
                break;
            case ("<Task"):
                ass = new Assessment();
                ass.setAssessmentName(splitStr[1]);
                break;
            case ("<Type"):
                if (ass != null)
                {
                    ass.setType(splitStr[1]);
                }
                break;
            case ("<Weight"):
                if (ass != null)
                {
                    splitStr[1] = splitStr[1].replace("%", "");
                    ass.setWeighting(Integer.parseInt(splitStr[1]));
                }
                break;
            case ("<Due"):
                if (ass != null && !(splitStr[1].equals("Due date not found")))  ////////////////////////////
                {
                    String dateStr[] = splitStr[1].split("/", 3);
                    Date date = new Date(Integer.parseInt(dateStr[0]),
                                         Integer.parseInt(dateStr[1]),
                                         Integer.parseInt(dateStr[2]));
                    ass.setDueDate(date);
                }
                break;
            case ("<Group"):
                ass.setGroupwork(splitStr[1]);
                break;
            case ("<Description"):
                ass.setDescription(splitStr[1]);
                sos.addAssessment(ass);
                break;
            default:
                System.out.println("toSOS: unexpected field found");
                break;
        }
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
        String currentField = "";
        try {
            Process p;
            p = Runtime.getRuntime().exec(runPyCmd, null,
                    new File(scriptFilePath));

            BufferedReader stdInput = new BufferedReader(new InputStreamReader(p.getInputStream()));

            System.out.println("Here is the standard output of the command:\n");
            while ((s = stdInput.readLine()) != null) {
                summary.add(s);                             
                System.out.println(summary.toString());
                
                if (s.startsWith("<"))
                {
                    currentField = s;
                }
                else if (s.equals(">"))
                {
                    toSOS(currentField);
                }
                else
                {
                    currentField += "\n" + s;
                }
            }
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
