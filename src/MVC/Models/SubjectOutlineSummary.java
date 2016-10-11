/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MVC.Models;

import java.util.LinkedList;

/**
 *
 * @author Andy
 */
public class SubjectOutlineSummary {
  
    private String subjectName;
    private LinkedList<Assessment> assessments;
    private String keyContacts; //Just a String or of type Contact?
    private String passCriteria;
    private String requiredTexts;

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    public LinkedList<Assessment> getAssessments() {
        return assessments;
    }

    public void setAssessments(LinkedList<Assessment> assessments) {
        this.assessments = assessments;
    }
    
    public void addAssessment(Assessment assessment) {
        this.assessments.add(assessment);
    }

    public String getKeyContacts() {
        return keyContacts;
    }

    public void setKeyContacts(String keyContacts) {
        this.keyContacts = keyContacts;
    }

    public String getPassCriteria() {
        return passCriteria;
    }

    public void setPassCriteria(String passCriteria) {
        this.passCriteria = passCriteria;
    }

    public String getRequiredTexts() {
        return requiredTexts;
    }

    public void setRequiredTexts(String requiredTexts) {
        this.requiredTexts = requiredTexts;
    }
    
    public SubjectOutlineSummary() //@param Raw data?
    {
        this.assessments = new LinkedList<>();
    }
}
