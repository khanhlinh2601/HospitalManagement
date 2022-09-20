/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import java.util.Date;
import util.MyValidation;

/**
 *
 * @author tklin
 */
public class Department {
    private String deptID;
    private String deptName;
    private Date createDate;
    private Date lastUpdateDate;

    public Department(String depID, String deptName, Date createDate, Date lastUpdateDate) {
        this.deptID = depID;
        this.deptName = deptName;
        this.createDate = createDate;
        this.lastUpdateDate = lastUpdateDate;
    }

    public Department(String depID) {
        this.deptID = depID;
    }

    public String getDeptID() {
        return deptID;
    }

    public void setDeptID(String depID) {
        this.deptID = depID;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getLastUpdateDate() {
        return lastUpdateDate;
    }

    public void setLastUpdateDate(Date lastUpdateDate) {
        this.lastUpdateDate = lastUpdateDate;
    }
    
    
    @Override
    public boolean equals(Object obj) {
        return this.deptID.equalsIgnoreCase(((Department)obj).getDeptID());
    }

    @Override
    public String toString() {
        return deptID + "|" + deptName + "|" + MyValidation.convertDateFormat(createDate) + "|" + MyValidation.convertDateFormat(lastUpdateDate);
    }
    
    
}
