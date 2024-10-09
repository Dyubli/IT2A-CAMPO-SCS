
package SCS;

import java.util.Scanner;

public class SCS {
    
    public static void main(String[] args) {
       String resp;
       
    do{
        SCS test = new SCS();
        Scanner sc = new Scanner(System.in);
        
        System.out.println("1. ADD");
        System.out.println("2. VIEW");
        System.out.println("3. UPDATE");
        System.out.println("4. DELETE");
        System.out.println("5. EXIT");
        
        System.out.print("Enter Action: ");
        int action = sc.nextInt();
        
        switch(action){
            case 1:
                test.addStudents();
            break;
            case 2:
                test.viewStudents();
            break;                
            case 3:
                test.viewStudents();
                test.updateStudents();
            break;           
            case 4:
                test.viewStudents();
                test.deleteStudents();
                test.viewStudents();
            break;
        }
            System.out.print("Do you want to Continue?");
            resp = sc.next();
            
        }
        while(resp.equalsIgnoreCase ("yes"));
                System.out.println("Thank you!"); 
    }
    
    public void addStudents(){
        Scanner sc = new Scanner(System.in);
        config conf = new config();
        System.out.print("Student First Name: ");
        String fname = sc.next();
        System.out.print("Last Name: ");
        String lname = sc.next();
        System.out.print("Program: ");
        String program = sc.next();
        System.out.print ("Year: ");
        String year = sc.next();
        System.out.print("Section: ");
        String section = sc.next();
        System.out.print("Reason: ");
        String reason = sc.next();

        String sql = "INSERT INTO Students (First_name, Last_name, Program, Year, Section, Reason) VALUES (?, ?, ?, ?, ?, ?)";


        conf.addRecords(sql, fname, lname, program, year, section, reason);
    }
    
    public void viewStudents(){
        String qry = "SELECT * FROM Students";
        String[] hdrs = {"ID", "First Name", "Last Name", "Program", "Year","Section", "Reason"};
        String[] clmns = {"ID", "First_name", "Last_name", "Program", "Year", "Section", "Reason"};
        
        config conf = new config();
        
        conf.viewRecords(qry, hdrs, clmns);
    }
    public void updateStudents(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the ID to update: ");
        int id = sc.nextInt();
        
        System.out.print("Enter new First Name: ");
        String nfname = sc.next();
        System.out.print("Enter new Last Name: ");
        String nlname = sc.next();
        System.out.print("Enter new Program: ");
        String nprogram = sc.next();
        System.out.print("Enter new Year: ");
        String nyear = sc.next();
        System.out.print("Enter new Section: ");
        String nsection = sc.next();
        System.out.print("Enter new Reason: ");
        String nreason = sc.next();
        
        String qry = " UPDATE Students SET First_Name = ?, Last_Name = ?, Program = ? , Year = ?, Section = ?, Reason = ? WHERE ID = ?";
        
        config conf = new config();
        conf.updateRecord (qry, nfname, nlname, nprogram, nsection, nyear, nreason, id);
        
    }
    public void deleteStudents(){
        Scanner sc = new Scanner (System.in);
        System.out.print("Enter the ID to delete: ");
        int id = sc.nextInt();
        
        String qry = "DELETE FROM Students WHERE ID = ?";
        
        config conf = new config();
        conf.deleteRecord(qry, id);
                
    }
    }

    
    
