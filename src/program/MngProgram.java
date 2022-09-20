/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package program;

import data.HospitalMng;
import ui.Menu;

/**
 *
 * @author tklin
 */
public class MngProgram {

    public static void main(String[] args) {
        Menu mainMenu = new Menu("Hospital Management");
        mainMenu.addNewOption("1. Show information");
        mainMenu.addNewOption("2. Add information");
        mainMenu.addNewOption("3. Update information");
        mainMenu.addNewOption("4. Delete information");
        mainMenu.addNewOption("5. Search information");
        mainMenu.addNewOption("6. Store data to file");
        mainMenu.addNewOption("7. Exit");
        
        Menu subMenu1 = new Menu("Show information");
        subMenu1.addNewOption("1. Show doctor list");
        subMenu1.addNewOption("2. Show department list");
        
        Menu subMenu2 = new Menu("Add new information");
        subMenu2.addNewOption("1. Add new doctor");
        subMenu2.addNewOption("2. Add new department");
        
        Menu subMenu3 = new Menu("Update information");
        subMenu3.addNewOption("1. Update doctor");
        subMenu3.addNewOption("2. Update department");
        
        Menu subMenu4 = new Menu("Delete information");
        subMenu4.addNewOption("1. Delete doctor");
        subMenu4.addNewOption("2. Delete department");
        
        Menu subMenu5 = new Menu("Search information");
        subMenu5.addNewOption("1. Search doctor");
        subMenu5.addNewOption("2. Search department");

        int choice = 0;
        int sChoice = 0;
        HospitalMng hospitalMng = new HospitalMng();
        
        do {
            mainMenu.printMenu();
            choice = mainMenu.getChoice();
            switch (choice) {
                case 1:
                    subMenu1.printMenu();
                    sChoice = subMenu1.getChoice();
                    switch (sChoice){
                        case 1:
                            hospitalMng.showDoctorInfor();
                            break;
                        case 2: 
                            hospitalMng.showDeptInfor();
                            break;
                    }
                    break;
                case 2: 
                    subMenu2.printMenu();
                    sChoice = subMenu2.getChoice();
                    switch (sChoice){
                        case 1:
                            hospitalMng.addDoctor();
                            break;
                        case 2: 
                            hospitalMng.addDepartment();
                            break;

                    }
                    break;
                case 3: 
                    subMenu3.printMenu();
                    sChoice = subMenu3.getChoice();
                    switch (sChoice){
                        case 1:
                            hospitalMng.updateDoctor();
                            break;
                        case 2: 
                            hospitalMng.updateDepartment();
                            break;
                    }
                    break;
                case 4:
                    subMenu4.printMenu();
                    sChoice = subMenu4.getChoice();
                    switch (sChoice){
                        case 1:
                            hospitalMng.removeDoctor();
                            break;
                        case 2: 
                            hospitalMng.removeDepartment();
                            break;
                    }
                    break;
                case 5: 
                    subMenu5.printMenu();
                    sChoice = subMenu5.getChoice();
                    switch (sChoice){
                        case 1:
                            hospitalMng.searchDoctor();
                            break;
                        case 2: 
                            hospitalMng.searchDepartment();
                            break;
                    }
                    break;
                case 6:
                    hospitalMng.saveData();
                    break;
            }

        } while (choice != 7);

    }
}
