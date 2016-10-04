/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package omanyteDB;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author christinevinaviles
 */
@Entity
@Table(name = "SUBJECT_OUTLINE_SUMMARY")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SubjectOutlineSummary.findAll", query = "SELECT s FROM SubjectOutlineSummary s"),
    @NamedQuery(name = "SubjectOutlineSummary.findById", query = "SELECT s FROM SubjectOutlineSummary s WHERE s.id = :id"),
    @NamedQuery(name = "SubjectOutlineSummary.findBySubjectNumber", query = "SELECT s FROM SubjectOutlineSummary s WHERE s.subjectNumber = :subjectNumber"),
    @NamedQuery(name = "SubjectOutlineSummary.findByAssessmentGroupId", query = "SELECT s FROM SubjectOutlineSummary s WHERE s.assessmentGroupId = :assessmentGroupId"),
    @NamedQuery(name = "SubjectOutlineSummary.findBySubjectPassCriteria", query = "SELECT s FROM SubjectOutlineSummary s WHERE s.subjectPassCriteria = :subjectPassCriteria")})
public class SubjectOutlineSummary implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Column(name = "SUBJECT_NUMBER")
    private Integer subjectNumber;
    @Column(name = "ASSESSMENT_GROUP_ID")
    private Integer assessmentGroupId;
    @Column(name = "SUBJECT_PASS_CRITERIA")
    private String subjectPassCriteria;

    public SubjectOutlineSummary() {
    }

    public SubjectOutlineSummary(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getSubjectNumber() {
        return subjectNumber;
    }

    public void setSubjectNumber(Integer subjectNumber) {
        this.subjectNumber = subjectNumber;
    }

    public Integer getAssessmentGroupId() {
        return assessmentGroupId;
    }

    public void setAssessmentGroupId(Integer assessmentGroupId) {
        this.assessmentGroupId = assessmentGroupId;
    }

    public String getSubjectPassCriteria() {
        return subjectPassCriteria;
    }

    public void setSubjectPassCriteria(String subjectPassCriteria) {
        this.subjectPassCriteria = subjectPassCriteria;
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
        if (!(object instanceof SubjectOutlineSummary)) {
            return false;
        }
        SubjectOutlineSummary other = (SubjectOutlineSummary) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "omanyteDB.SubjectOutlineSummary[ id=" + id + " ]";
    }
    
}
