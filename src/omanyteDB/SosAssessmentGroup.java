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
@Table(name = "SOS_ASSESSMENT_GROUP")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SosAssessmentGroup.findAll", query = "SELECT s FROM SosAssessmentGroup s"),
    @NamedQuery(name = "SosAssessmentGroup.findById", query = "SELECT s FROM SosAssessmentGroup s WHERE s.id = :id"),
    @NamedQuery(name = "SosAssessmentGroup.findBySosAssessmentId1", query = "SELECT s FROM SosAssessmentGroup s WHERE s.sosAssessmentId1 = :sosAssessmentId1"),
    @NamedQuery(name = "SosAssessmentGroup.findBySosAssessmentId2", query = "SELECT s FROM SosAssessmentGroup s WHERE s.sosAssessmentId2 = :sosAssessmentId2"),
    @NamedQuery(name = "SosAssessmentGroup.findBySosAssessmentId3", query = "SELECT s FROM SosAssessmentGroup s WHERE s.sosAssessmentId3 = :sosAssessmentId3"),
    @NamedQuery(name = "SosAssessmentGroup.findBySosAssessmentId4", query = "SELECT s FROM SosAssessmentGroup s WHERE s.sosAssessmentId4 = :sosAssessmentId4"),
    @NamedQuery(name = "SosAssessmentGroup.findBySosAssessmentId5", query = "SELECT s FROM SosAssessmentGroup s WHERE s.sosAssessmentId5 = :sosAssessmentId5"),
    @NamedQuery(name = "SosAssessmentGroup.findBySosAssessmentId6", query = "SELECT s FROM SosAssessmentGroup s WHERE s.sosAssessmentId6 = :sosAssessmentId6"),
    @NamedQuery(name = "SosAssessmentGroup.findBySosAssessmentId7", query = "SELECT s FROM SosAssessmentGroup s WHERE s.sosAssessmentId7 = :sosAssessmentId7"),
    @NamedQuery(name = "SosAssessmentGroup.findBySosAssessmentId8", query = "SELECT s FROM SosAssessmentGroup s WHERE s.sosAssessmentId8 = :sosAssessmentId8"),
    @NamedQuery(name = "SosAssessmentGroup.findBySosAssessmentId9", query = "SELECT s FROM SosAssessmentGroup s WHERE s.sosAssessmentId9 = :sosAssessmentId9"),
    @NamedQuery(name = "SosAssessmentGroup.findBySosAssessmentId10", query = "SELECT s FROM SosAssessmentGroup s WHERE s.sosAssessmentId10 = :sosAssessmentId10")})
public class SosAssessmentGroup implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Column(name = "SOS_ASSESSMENT_ID1")
    private Integer sosAssessmentId1;
    @Column(name = "SOS_ASSESSMENT_ID2")
    private Integer sosAssessmentId2;
    @Column(name = "SOS_ASSESSMENT_ID3")
    private Integer sosAssessmentId3;
    @Column(name = "SOS_ASSESSMENT_ID4")
    private Integer sosAssessmentId4;
    @Column(name = "SOS_ASSESSMENT_ID5")
    private Integer sosAssessmentId5;
    @Column(name = "SOS_ASSESSMENT_ID6")
    private Integer sosAssessmentId6;
    @Column(name = "SOS_ASSESSMENT_ID7")
    private Integer sosAssessmentId7;
    @Column(name = "SOS_ASSESSMENT_ID8")
    private Integer sosAssessmentId8;
    @Column(name = "SOS_ASSESSMENT_ID9")
    private Integer sosAssessmentId9;
    @Column(name = "SOS_ASSESSMENT_ID10")
    private Integer sosAssessmentId10;

    public SosAssessmentGroup() {
    }

    public SosAssessmentGroup(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getSosAssessmentId1() {
        return sosAssessmentId1;
    }

    public void setSosAssessmentId1(Integer sosAssessmentId1) {
        this.sosAssessmentId1 = sosAssessmentId1;
    }

    public Integer getSosAssessmentId2() {
        return sosAssessmentId2;
    }

    public void setSosAssessmentId2(Integer sosAssessmentId2) {
        this.sosAssessmentId2 = sosAssessmentId2;
    }

    public Integer getSosAssessmentId3() {
        return sosAssessmentId3;
    }

    public void setSosAssessmentId3(Integer sosAssessmentId3) {
        this.sosAssessmentId3 = sosAssessmentId3;
    }

    public Integer getSosAssessmentId4() {
        return sosAssessmentId4;
    }

    public void setSosAssessmentId4(Integer sosAssessmentId4) {
        this.sosAssessmentId4 = sosAssessmentId4;
    }

    public Integer getSosAssessmentId5() {
        return sosAssessmentId5;
    }

    public void setSosAssessmentId5(Integer sosAssessmentId5) {
        this.sosAssessmentId5 = sosAssessmentId5;
    }

    public Integer getSosAssessmentId6() {
        return sosAssessmentId6;
    }

    public void setSosAssessmentId6(Integer sosAssessmentId6) {
        this.sosAssessmentId6 = sosAssessmentId6;
    }

    public Integer getSosAssessmentId7() {
        return sosAssessmentId7;
    }

    public void setSosAssessmentId7(Integer sosAssessmentId7) {
        this.sosAssessmentId7 = sosAssessmentId7;
    }

    public Integer getSosAssessmentId8() {
        return sosAssessmentId8;
    }

    public void setSosAssessmentId8(Integer sosAssessmentId8) {
        this.sosAssessmentId8 = sosAssessmentId8;
    }

    public Integer getSosAssessmentId9() {
        return sosAssessmentId9;
    }

    public void setSosAssessmentId9(Integer sosAssessmentId9) {
        this.sosAssessmentId9 = sosAssessmentId9;
    }

    public Integer getSosAssessmentId10() {
        return sosAssessmentId10;
    }

    public void setSosAssessmentId10(Integer sosAssessmentId10) {
        this.sosAssessmentId10 = sosAssessmentId10;
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
        if (!(object instanceof SosAssessmentGroup)) {
            return false;
        }
        SosAssessmentGroup other = (SosAssessmentGroup) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "omanyteDB.SosAssessmentGroup[ id=" + id + " ]";
    }
    
}
