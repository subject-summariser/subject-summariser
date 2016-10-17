/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MVC.Models;

import java.util.LinkedList;

/**
 *
 * @author Andy and Melisa
 */
public class SubjectOutlineSummary {
    
    private int SubjectNb;
    private String SubjectName;
    private String KeyContacts;
    private String SubjectContent;
    private LinkedList<Assessment> Assessments;
    private String MinimumReq;
    private String SuppAssessments;
    private String LateAssessmentPenalty;
    private String ReqTexts;

    public SubjectOutlineSummary()
    {
        Assessments = new LinkedList<>();
        KeyContacts = null;
        SubjectContent = null;
        MinimumReq = null;
        SuppAssessments = null;
        LateAssessmentPenalty = null;
        ReqTexts = null;
    }

    public int getSubjectNb() {
        return SubjectNb;
    }

    public String getSubjectName() {
        return SubjectName;
    }
    
    public void setSubjectNb(int SubjectNb) {
        this.SubjectNb = SubjectNb;
    }

    public void setKeyContacts(String KeyContacts) {
        this.KeyContacts = KeyContacts;
    }

    public void setSubjectContent(String SubjectContent) {
        this.SubjectContent = SubjectContent;
    }

    public void setAssessments(LinkedList<Assessment> Assessments) {
        this.Assessments = Assessments;
    }

    public void setMinimumReq(String MinimumReq) {
        this.MinimumReq = MinimumReq;
    }

    public void setSuppAssessments(String SuppAssessments) {
        this.SuppAssessments = SuppAssessments;
    }

    public void setLateAssessmentPenalty(String LateAssessmentPenalty) {
        this.LateAssessmentPenalty = LateAssessmentPenalty;
    }

    public void setReqTexts(String ReqTexts) {
        this.ReqTexts = ReqTexts;
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

    public void addAssessments(Assessment assessments) {
        Assessments.add(assessments);
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
