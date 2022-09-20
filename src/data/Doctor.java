/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import java.util.Date;
import java.util.Objects;
import util.MyValidation;

/**
 *
 * @author tklin
 */
public class Doctor {
    private String doctorID;
    private String doctorName;
    private Boolean sex;
    private String address;
    private String deptID;
    private Date createDate;
    private Date lastUpdateDate;

    public Doctor(String doctorID, String doctorName, Boolean sex, String address, String deptID, Date createDate, Date lastUpdateDate) {
        this.doctorID = doctorID;
        this.doctorName = doctorName;
        this.sex = sex;
        this.address = address;
        this.deptID = deptID;
        this.createDate = createDate;
        this.lastUpdateDate = lastUpdateDate;
    }

    

    public Doctor(String doctorID) {
        this.doctorID = doctorID;
    }

    public String getDoctorID() {
        return doctorID;
    }

    public void setDoctorID(String doctorID) {
        this.doctorID = doctorID;
    }

    public String getDoctorName() {
        return doctorName;
    }

    public void setDoctorName(String doctorName) {
        this.doctorName = doctorName;
    }

    public Boolean getSex() {
        return sex;
    }

    public void setSex(Boolean sex) {
        this.sex = sex;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
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

    public String getDeptID() {
        return deptID;
    }

    public void setDeptID(String deptID) {
        this.deptID = deptID;
    }

    @Override
    public boolean equals(Object obj) { 
          return this.doctorID.equalsIgnoreCase(((Doctor)obj).getDoctorID());
    }

    @Override
    public String toString() {
        return doctorID + "|" + doctorName + "|" + sex + "|" + address + "|" + deptID + "|" + 
                MyValidation.convertDateFormat(createDate) + "|" + MyValidation.convertDateFormat(lastUpdateDate);
    }
 
}
