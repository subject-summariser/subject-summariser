/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MVC.Models;

//import MVC.Models.Date;

/**
 *
 * @author Melisa
 */
public class Assessment {
    
    private String AssessmentName;
    private String Type;
    private final String Groupwork;
    private final int Weighting;
    private final String Description;
    private final Date DueDate;
    
    public Assessment()
    {
        Groupwork = "Group";
        Weighting = 666;
        Description = "Llamma";
        DueDate = new Date(1, 1, 1);
    }
    
//    public Assessment(String assessmentName, String type, String groupwork, int weighting, String description, Date dueDate)
//    {
//        AssessmentName = assessmentName;
//        Type = type;
//        Groupwork = groupwork;
//        Weighting = weighting;
//        Description = description;
//        DueDate = dueDate;
//    }
    
    public String getAssessmentName() {
        return AssessmentName;
    }

    public void setAssessmentName(String AssessmentName) {
        this.AssessmentName = AssessmentName;
    }

    public String getType() {
        return Type;
    }

    public void setType(String Type) {
        this.Type = Type;
    }

    public String getGroupwork() {
        return Groupwork;
    }    
    
    public int getWeighting() {
        return Weighting;
    }

    public String getDescription() {
        return Description;
    }

    public Date getDueDate() {
        return DueDate;
    }
}
