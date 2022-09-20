/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.StringTokenizer;
import util.MyValidation;

/**
 *
 * @author tklin
 */
public class DeptList extends ArrayList<Department>{
    
    public void loadFromFile(String fName){
        try {
            File f = new File(fName);
            if (!f.exists()) {
                return;
            }
            FileReader fr = new FileReader(f);
            BufferedReader bf = new BufferedReader(fr);
            String details;
            while ((details = bf.readLine()) != null) {
                StringTokenizer stk = new StringTokenizer(details, "|");
                String deptID = stk.nextToken().toUpperCase();
                String deptName = stk.nextToken();
                String createDateStr = stk.nextToken().trim();
                String lastUpdateDateStr = stk.nextToken().trim();
                Date createDate = null;
                Date lastUpdateDate = null;
                SimpleDateFormat fomater = new SimpleDateFormat("dd-mm-yyyy");
                if (!createDateStr.equalsIgnoreCase("null")) {
                    createDate = fomater.parse(createDateStr);
                }
                if (!lastUpdateDateStr.equalsIgnoreCase("null")) {
                    lastUpdateDate = fomater.parse(lastUpdateDateStr);
                }
                Department newDept = new Department(deptID, deptName, createDate, lastUpdateDate);
                this.add(newDept);
            }
            bf.close(); fr.close();
        } catch (Exception e) {
            System.out.println(e);
        }   
    }
    public void writeToFile(String fName){
        if(this.isEmpty()){
            System.out.println("Empty list!");
            return;
        }
        try {
            File f = new File(fName);
            FileWriter fw = new FileWriter(f);
            PrintWriter pw = new PrintWriter(fw);
            for(Department x: this){
                pw.println(x.getDeptID()+ "|" + x.getDeptName() + "|" + MyValidation.convertDateFormat(x.getCreateDate()) + "|" + MyValidation.convertDateFormat(x.getLastUpdateDate()));
            }
            pw.close(); fw.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
