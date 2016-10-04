/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package omanyteDB;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author christinevinaviles
 */
@Entity
@Table(name = "SOS_ASSESSMENTS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SosAssessments.findAll", query = "SELECT s FROM SosAssessments s"),
    @NamedQuery(name = "SosAssessments.findById", query = "SELECT s FROM SosAssessments s WHERE s.id = :id"),
    @NamedQuery(name = "SosAssessments.findByAssessmentName", query = "SELECT s FROM SosAssessments s WHERE s.assessmentName = :assessmentName"),
    @NamedQuery(name = "SosAssessments.findByAssessmentType", query = "SELECT s FROM SosAssessments s WHERE s.assessmentType = :assessmentType"),
    @NamedQuery(name = "SosAssessments.findByDueDate", query = "SELECT s FROM SosAssessments s WHERE s.dueDate = :dueDate"),
    @NamedQuery(name = "SosAssessments.findByWeighting", query = "SELECT s FROM SosAssessments s WHERE s.weighting = :weighting"),
    @NamedQuery(name = "SosAssessments.findByKeyContacts", query = "SELECT s FROM SosAssessments s WHERE s.keyContacts = :keyContacts"),
    @NamedQuery(name = "SosAssessments.findByRequiredTextsRaw", query = "SELECT s FROM SosAssessments s WHERE s.requiredTextsRaw = :requiredTextsRaw"),
    @NamedQuery(name = "SosAssessments.findByGroupwork", query = "SELECT s FROM SosAssessments s WHERE s.groupwork = :groupwork")})
public class SosAssessments implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Column(name = "ASSESSMENT_NAME")
    private String assessmentName;
    @Column(name = "ASSESSMENT_TYPE")
    private String assessmentType;
    @Column(name = "DUE_DATE")
    @Temporal(TemporalType.DATE)
    private Date dueDate;
    @Column(name = "WEIGHTING")
    private Integer weighting;
    @Column(name = "KEY_CONTACTS")
    private String keyContacts;
    @Column(name = "REQUIRED_TEXTS_RAW")
    private String requiredTextsRaw;
    @Column(name = "GROUPWORK?")
    private Boolean groupwork;

    public SosAssessments() {
    }

    public SosAssessments(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAssessmentName() {
        return assessmentName;
    }

    public void setAssessmentName(String assessmentName) {
        this.assessmentName = assessmentName;
    }

    public String getAssessmentType() {
        return assessmentType;
    }

    public void setAssessmentType(String assessmentType) {
        this.assessmentType = assessmentType;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    public Integer getWeighting() {
        return weighting;
    }

    public void setWeighting(Integer weighting) {
        this.weighting = weighting;
    }

    public String getKeyContacts() {
        return keyContacts;
    }

    public void setKeyContacts(String keyContacts) {
        this.keyContacts = keyContacts;
    }

    public String getRequiredTextsRaw() {
        return requiredTextsRaw;
    }

    public void setRequiredTextsRaw(String requiredTextsRaw) {
        this.requiredTextsRaw = requiredTextsRaw;
    }

    public Boolean getGroupwork() {
        return groupwork;
    }

    public void setGroupwork(Boolean groupwork) {
        this.groupwork = groupwork;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SosAssessments)) {
            return false;
        }
        SosAssessments other = (SosAssessments) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "omanyteDB.SosAssessments[ id=" + id + " ]";
    }
    
}
