/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MVC.Models;

import java.util.Date;

/**
 *
 * @author Andy
 */
public class Assessment {
    
    private String assName;
    private String assType;
    private int assWeight;
    private Date dueDate;
    private Boolean groupWork;
    
    public Assessment()
    {
    }

    public String getAssName() {
        return assName;
    }

    public void setAssName(String assName) {
        this.assName = assName;
    }

    public String getAssType() {
        return assType;
    }

    public void setAssType(String assType) {
        this.assType = assType;
    }

    public int getAssWeight() {
        return assWeight;
    }

    public void setAssWeight(int assWeight) {
        this.assWeight = assWeight;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    public Boolean getGroupWork() {
        return groupWork;
    }

    public void setGroupWork(Boolean groupWork) {
        this.groupWork = groupWork;
    }
    
    
}
