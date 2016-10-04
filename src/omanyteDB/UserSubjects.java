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
@Table(name = "USER_SUBJECTS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "UserSubjects.findAll", query = "SELECT u FROM UserSubjects u"),
    @NamedQuery(name = "UserSubjects.findById", query = "SELECT u FROM UserSubjects u WHERE u.id = :id"),
    @NamedQuery(name = "UserSubjects.findBySosId1", query = "SELECT u FROM UserSubjects u WHERE u.sosId1 = :sosId1"),
    @NamedQuery(name = "UserSubjects.findBySosId2", query = "SELECT u FROM UserSubjects u WHERE u.sosId2 = :sosId2"),
    @NamedQuery(name = "UserSubjects.findBySosId3", query = "SELECT u FROM UserSubjects u WHERE u.sosId3 = :sosId3"),
    @NamedQuery(name = "UserSubjects.findBySosId4", query = "SELECT u FROM UserSubjects u WHERE u.sosId4 = :sosId4"),
    @NamedQuery(name = "UserSubjects.findBySosId5", query = "SELECT u FROM UserSubjects u WHERE u.sosId5 = :sosId5")})
public class UserSubjects implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Column(name = "SOS_ID1")
    private Integer sosId1;
    @Column(name = "SOS_ID2")
    private Integer sosId2;
    @Column(name = "SOS_ID3")
    private Integer sosId3;
    @Column(name = "SOS_ID4")
    private Integer sosId4;
    @Column(name = "SOS_ID5")
    private Integer sosId5;

    public UserSubjects() {
    }

    public UserSubjects(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getSosId1() {
        return sosId1;
    }

    public void setSosId1(Integer sosId1) {
        this.sosId1 = sosId1;
    }

    public Integer getSosId2() {
        return sosId2;
    }

    public void setSosId2(Integer sosId2) {
        this.sosId2 = sosId2;
    }

    public Integer getSosId3() {
        return sosId3;
    }

    public void setSosId3(Integer sosId3) {
        this.sosId3 = sosId3;
    }

    public Integer getSosId4() {
        return sosId4;
    }

    public void setSosId4(Integer sosId4) {
        this.sosId4 = sosId4;
    }

    public Integer getSosId5() {
        return sosId5;
    }

    public void setSosId5(Integer sosId5) {
        this.sosId5 = sosId5;
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
        if (!(object instanceof UserSubjects)) {
            return false;
        }
        UserSubjects other = (UserSubjects) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "omanyteDB.UserSubjects[ id=" + id + " ]";
    }
    
}
