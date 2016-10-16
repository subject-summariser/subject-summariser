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
    private String Groupwork;

    public void setGroupwork(String Groupwork) {
        this.Groupwork = Groupwork;
    }

    public void setWeighting(int Weighting) {
        this.Weighting = Weighting;
    }

    public void setDescription(String Description) {
        this.Description = Description;
    }

    public void setDueDate(Date DueDate) {
        this.DueDate = DueDate;
    }
    private int Weighting;
    private String Description;
    private Date DueDate;
    
    public Assessment()
    {
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
