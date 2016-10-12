/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MVC.Models;

import MVC.Models.Assessment;
import java.util.LinkedList;

/**
 *
 * @author Andy and Melisa
 */
public class SubjectOutlineSummary {
    
    private final int SubjectNb;
    private String SubjectName;
    private final String KeyContacts;
    private final String SubjectContent;
    private LinkedList<Assessment> Assessments;
    private final String MinimumReq;
    private final String SuppAssessments;
    private final String LateAssessmentPenalty;
    private final String ReqTexts;
    
//    public SubjectOutlineSummary(int subjectNb, String subjectName, String keyContacts,
//                                 String subjectContent, LinkedList<Assessment> assessments, String minimumReq,
//                                 String suppAssessments, String lateAssessmentPenalty, String reqTexts)
    public SubjectOutlineSummary()
    {
        Assessments = new LinkedList<>(); 
        SubjectNb = 0;
        KeyContacts = "...";
        SubjectContent = "...";
        MinimumReq = "...";
        SuppAssessments = "...";
        LateAssessmentPenalty = "...";
        ReqTexts = "...";
//        SubjectNb = subjectNb;
//        SubjectName = subjectName;
//        KeyContacts = keyContacts;
//        SubjectContent = subjectContent;
//        Assessments = assessments;
//        MinimumReq = minimumReq;
//        SuppAssessments = suppAssessments;
//        LateAssessmentPenalty = lateAssessmentPenalty;
//        ReqTexts = reqTexts;
    }

    public int getSubjectNb() {
        return SubjectNb;
    }

    public String getSubjectName() {
        return SubjectName;
    }
    
    public void setSubjectName(String subjectName) {
        SubjectName = subjectName;
    }

    public String getKeyContacts() {
        return KeyContacts;
    }

    public String getSubjectContent() {
        return SubjectContent;
    }

    public LinkedList<Assessment> getAssessments() {
        return Assessments;
    }

    public void setAssessments(LinkedList<Assessment> assessments) {
        Assessments = assessments;
    }
    
    public void addAssessment(String name, String type) {
        Assessment a = new Assessment();
        a.setAssessmentName(name);
        a.setType(type);
//        Assessments.add(a);
    }

    public String getMinimumReq() {
        return MinimumReq;
    }

    public String getSuppAssessments() {
        return SuppAssessments;
    }

    public String getLateAssessmentPenalty() {
        return LateAssessmentPenalty;
    }

    public String getReqTexts() {
        return ReqTexts;
    }

}
