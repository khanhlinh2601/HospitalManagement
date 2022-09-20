/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import java.util.ArrayList;
import java.util.Date;
import util.MyValidation;

/**
 *
 * @author tklin
 */
public class HospitalMng {

    DeptList deptList;
    DoctorList doctorList;

    public HospitalMng() {
        deptList = new DeptList();
        doctorList = new DoctorList();
        deptList.loadFromFile("departments.dat");
        doctorList.loadFromFile("doctors.dat");
    }

    //:	Show	information
    public void showDoctorInfor() {
        if (doctorList.isEmpty()) {
            System.out.println("The doctor is empty");
        } else {
            System.out.println("Found " + doctorList.size() + " doctor(s) from the file: ");
            for (Doctor x : doctorList) {
                System.out.println(x.toString());
            }
        }
    }
    public void showDeptInfor(){
        if (deptList.isEmpty()) {
            System.out.println("The department is empty");

        } else {
            System.out.println("Found " + deptList.size() + " departments(s) from the file: ");
            for (Department x : deptList) {
                System.out.println(x.toString());
            }
        }
    }

    //Add infor
    public void addDoctor() {
        String doctorID, doctorName, address, deptID;
        Boolean sex, check;
        Date createDate, lastUpdateDate;
        int pos;
        do {
            doctorID = MyValidation.getString("Input doctor ID: ", "Doctor ID is  invalid!", false);
            pos = doctorList.indexOf(new Doctor(doctorID));
            if (pos >= 0) {
                System.out.println("The doctor id already exists. "
                        + "Input another one!");
            }
        } while (pos != -1);
        doctorName = MyValidation.getString("Input doctor name: ", "Invalid!", false);
        sex = MyValidation.getBoolean("Female? (Y/N)", "Invalid!", false);
        address = MyValidation.getString("Input the address: ", "Invalid!", false);
        do {
            deptID = MyValidation.getString("Input department ID: ", "Department ID is invalid!", false);
            check = containsDepartment(deptID);
            if (!check) {
                System.out.println("The department ID is not existed in the department list. "
                        + "Input another one!");
            }
        } while (!check);
        createDate = new Date();
        lastUpdateDate = null;
        doctorList.add(new Doctor(doctorID, doctorName, sex, address, deptID, createDate, lastUpdateDate));
        System.out.println("A doctor is added sucessfully!");
    }

    public void addDepartment() {
        String deptID, deptName;
        Date createDate, lastUpdateDate;
        int pos;
        do {
            deptID = MyValidation.getString("Input department ID: ", "Department ID is  invalid!", false);
            pos = deptList.indexOf(new Department(deptID));
            if (pos >= 0) {
                System.out.println("The department ID already exists. "
                        + "Input another one!");
            }
        } while (pos != -1);
        deptName = MyValidation.getString("Input department name:  ", "Invalid!", false);
        createDate = new Date();
        lastUpdateDate = null;
        deptList.add(new Department(deptID, deptName, createDate, lastUpdateDate));
        System.out.println("A department is added sucessfully!");
    }
    public boolean containsDepartment(String deptID){
        for (Department x : deptList) {
            if(deptID.trim().equalsIgnoreCase(x.getDeptID())) return true;
        }
        return false;
    }

    //update info
    public void updateDoctor() {
        String doctorID, doctorName, address, deptID;
        Boolean sex;
        Date lastUpdateDate;
        doctorID = MyValidation.getString("Input doctor ID do you want update: ", "Doctor ID is invalid!", false);
        int pos = doctorList.indexOf(new Doctor(doctorID));
        if (pos == -1) {
            System.out.println("Doctor does not exist");
            return;
        }
        doctorName = MyValidation.getString("Input doctor name: ", "Invalid!", true);
        sex = MyValidation.getBoolean("Female? (Y/N)", "Invalid!", true); //kiểm tra lại trường hợp bỏ trống
        address = MyValidation.getString("Input the address: ", "Invalid!", true);
        do {
            deptID = MyValidation.getString("Input department ID: ", "Department ID is invalid!", true);
            if (deptID.isEmpty()) {
                break; //nếu bỏ trống thì không kiểm tra có tồn tại hay không
            }
            pos = deptList.indexOf(new Department(deptID));
            if (pos == -1) {
                System.out.println("The departmentID is not existed in the department list"
                        + "Input another one!");
            }
        } while (pos == -1);
        lastUpdateDate = new Date(System.currentTimeMillis());
        if (!doctorName.isEmpty()) {
            doctorList.get(pos).setDoctorName(doctorName);
        }
        if (!address.isEmpty()) {
            doctorList.get(pos).setAddress(address);
        }
        if (!deptID.isEmpty()) {
            doctorList.get(pos).setDeptID(deptID);
        }
        if (sex != null) {
            doctorList.get(pos).setSex(sex);
        }
        doctorList.get(pos).setLastUpdateDate(lastUpdateDate);
        System.out.println("The doctor information after update: ");
        System.out.println(doctorList.get(pos).toString());
    }

    public void updateDepartment() {
        String deptID, deptName;
        Date lastUpdateDate;
        deptID = MyValidation.getString("Input department ID do you want update: ", "Department ID is  invalid!", false);
        int pos = deptList.indexOf(new Department(deptID));
        if (pos == -1) {
            System.out.println("“Department does not exist");
            return;
        }
        deptName = MyValidation.getString("Input department name: ", "Invalid!", true);
        lastUpdateDate = new Date();
        if (!deptName.isEmpty()) {
            deptList.get(pos).setDeptName(deptName);
        }
        deptList.get(pos).setLastUpdateDate(lastUpdateDate);
        System.out.println("The department information after update: ");
        System.out.println(deptList.get(pos).toString());
        
    }

    //delete
    public void removeDoctor() {
        String doctorID = MyValidation.getString("Input doctor ID do you want delete: ", "Doctor ID is invalid!", false);
        int pos = doctorList.indexOf(new Doctor(doctorID));
        if (pos == -1) {
            System.out.println("Doctor does not exist");
            return;
        }
        boolean confirm = MyValidation.getBoolean("Do you want remove this doctor? (Y/N) ", "Invalid!", false);
        if (confirm) {
            doctorList.remove(pos);
            System.out.println("Remove successfully!");
        } else {
            System.out.println("Remove fail!");
        }
    }

    public void removeDepartment() {
        String deptID = MyValidation.getString("Input department ID do you want delete: ", "Department ID is invalid!", false);
        int pos = deptList.indexOf(new Department(deptID));
        boolean checkDeptID = false;
        if (pos == -1) {
            System.out.println("Department does not exist");
            return;
        }
        for (Doctor x : doctorList) { //kiểm tra xem nó có tồn tại trong doctor list ko, nếu có thì ko xóa
            if (deptID.trim().equalsIgnoreCase(x.getDeptID())) {
                checkDeptID = deptID.trim().equalsIgnoreCase(x.getDeptID());
                break;
            }
        }
        boolean confirm = MyValidation.getBoolean("Do you want remove this department? (Y/N)", "Invalid!", false);
        if (confirm && !checkDeptID) {
            deptList.remove(pos);
            System.out.println("Remove successfully!");
        } else {
            System.out.println("Remove fail!");
        }
    }
    
    //search

    public ArrayList<Doctor> searchDoctorByName(String name) {
        ArrayList<Doctor> result = new ArrayList();
        for (Doctor x : doctorList) {
            if (name.trim().equalsIgnoreCase(x.getDoctorName())) {
                result.add(x);
            }

        }
        return result;
    }

    public void searchDoctor() {
        String doctorName = MyValidation.getString("Input doctor name: ", "Invalid!", false);
        ArrayList<Doctor> result = searchDoctorByName(doctorName);
        if (result.isEmpty()) {
            System.out.println("Not found!");
        } else {
            for (Doctor x : result) {
                System.out.println(x.toString());
            }
        }
    }

    public ArrayList<Department> searchDepartmentById(String id) {
        ArrayList<Department> result = new ArrayList();
        for (Department x : deptList) {
            if (id.trim().equalsIgnoreCase(x.getDeptID())) {
                result.add(x);
            }
        }

        return result;
    }

    public void searchDepartment() {
        String deptId = MyValidation.getString("Input department Id do you want search: ", "Invalid", false);
        ArrayList<Department> result = searchDepartmentById(deptId);
        for (Department x : result) {
            System.out.println(x.toString());
            
        }
    }

    //store data
    public void saveData() {
        doctorList.writeToFile("doctors.dat");
        deptList.writeToFile("departments.dat");
        System.out.println("Store data sucessfully!"); //xem lại, có try catch bên DoctorList và DeptList rồi
    }

}
