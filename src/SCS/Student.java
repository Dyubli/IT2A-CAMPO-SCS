package SCS;

import java.util.Scanner;


public class Student {


public void addStudent(){
    
    
        Scanner sc = new Scanner(System.in);
        config conf = new config();
        
        String fname;
        while(true){
        System.out.print("Enter Student First Name: ");
        fname = sc.next();
            if(fname.matches("[a-zA-Z\\s]+")){
                break;
            }
            System.out.println("Invalid Input.Please Enter Again.");}
        
        String lname;
        while(true){
        System.out.print("Enter Student Last Name: ");
        lname = sc.next();
            if(lname.matches("[a-zA-Z\\s]+")){
                break;
            }
            System.out.println("Invalid Input.Please Enter Again.");}
        
        String contact;
        while(true){
        System.out.print("Enter Contact Number: ");
        contact = sc.next();
            if(contact.matches("\\d{11}")){
                break;
            }
            System.out.println("Invalid Input.Please Enter Again.");}
        
        String add;
        while(true){
        System.out.print("Enter Address: ");
        add = sc.next();
            if(add.matches("[a-zA-Z\\s]+")){
                break;
            }
            System.out.println("Invalid Input.Please Enter Again.");}
            
            String gen;
             while (true) {
            System.out.print("Enter Gender (female or male): ");
            gen = sc.next().toLowerCase(); 

            if (gen.equals("female") || gen.equals("male")) {
                break; 
            } else {
                System.out.println("Invalid input. Please enter 'female' or 'male'.");
            }
        }
        String stats;
        while(true){
        System.out.print("Status: ");
        stats = sc.next();
            if(stats.matches("[a-zA-Z\\s]+")){
                break;
            }
            System.out.println("Invalid Input.Please Enter Again.");}
             

        String sql = "INSERT INTO Students (First_name, Last_name, Contact_Info, Address, Gender, Status) VALUES (?, ?, ?, ?, ?, ?)";


        conf.addRecords(sql, fname, lname, contact, add, gen, stats);
    }

    public void viewStudents(){

        String qry = "SELECT * FROM Students";
        String[] hdrs = {"ID", "First Name", "Last Name", "Contact No.", "Address","Gender", "Status"};
        String[] clmns = {"ID", "First_name", "Last_name", "Contact_Info", "Address", "Gender", "Status"};
        
        config conf = new config();
        
        conf.viewRecords(qry, hdrs, clmns);
    }
    
    public void updateStudents(){
        Scanner sc = new Scanner(System.in);
        config conf = new config ();
        
        System.out.print("Enter Student ID to update: ");
        int ID;
        
        while (true){
            ID =sc.nextInt();
            
            if(conf.getSingleValues("SELECT ID FROM Student WHERE ID = ?", ID) != 0){
                break;
            }else{
                System.out.println("ID not found, Enter Again!");
                sc.next();}
        }
        String fname;
        while(true){
        System.out.print("Enter Student First Name: ");
        fname = sc.next();
            if(fname.matches("[a-zA-Z\\s]+")){
                break;
            }
            System.out.println("Invalid Input.Please Enter Again.");}
        
        String lname;
        while(true){
        System.out.print("Enter Student Last Name: ");
        lname = sc.next();
            if(lname.matches("[a-zA-Z\\s]+")){
                break;
            }
            System.out.println("Invalid Input.Please Enter Again.");}
        
        String contact;
        while(true){
        System.out.print("Enter Contact Number: ");
        contact = sc.next();
            if(contact.matches("\\d{11}")){
                break;
            }
            System.out.println("Invalid Input.Please Enter Again.");}
        
        String add;
        while(true){
        System.out.print("Enter Address: ");
        add = sc.next();
            if(add.matches("[a-zA-Z\\s]+")){
                break;
            }
            System.out.println("Invalid Input.Please Enter Again.");}
            
            String gen;
             while (true) {
            System.out.print("Enter Gender (female or male): ");
            gen = sc.next().toLowerCase(); 

            if (gen.equals("female") || gen.equals("male")) {
                break; 
            } else {
                System.out.println("Invalid input. Please enter 'female' or 'male'.");
            }
        }
        String stats;
        while(true){
        System.out.print("Status: ");
        stats = sc.next();
            if(stats.matches("[a-zA-Z\\s]+")){
                break;
            }
            System.out.println("Invalid Input.Please Enter Again.");}
             

        String sql = "UPDATE Students SET (First_name, Last_name, Contact_Info, Address, Gender, Status) VALUES (?, ?, ?, ?, ?, ?)";


        conf.addRecords(sql, fname, lname, contact, add, gen, stats);
    }
    
 

public void mainStudent(){
    
     Student st = new Student();
    config conf = new config();
    
    
    String resp;
    do{
       
       Scanner sc = new Scanner(System.in);
        System.out.println(""); 
        
       
        System.out.println("+---------------------------+");
        System.out.println("|        STUDENT MENU       |");
        System.out.println("+---------------------------+");
        System.out.println("| 1. Add Student            |");
        System.out.println("| 2. View Students          |");
        System.out.println("| 3. Update Student         |");
        System.out.println("| 4. Delete Student         |");
        System.out.println("| 5. Exit                   |");
        System.out.println("+---------------------------+");
        
        
         int choice;
         while (true) {
                System.out.print("Enter choice: ");
                if (sc.hasNextInt()) {
                    choice = sc.nextInt();
                    if (choice >= 1 && choice <= 5) {
                        break;
                    } else {
                        System.out.println("Please enter a number between 1 and 5.");
                    }
                } else {
                    System.out.println("Invalid input. Please enter a valid number.");
                    sc.next();
                }
            }
         
        
        switch(choice){
            case 1:
                st.addStudent();
            break;
            case 2:
                st.viewStudents();
            break;                
            case 3:
                st.viewStudents();
                String sqlUP = "UPDATE Students SET Contact_Info = ?, Address = ?, Gender = ?, Status = ? WHERE  ID = ?  ";
                
                 int iup;
                while (true) {
                System.out.print("Enter Student ID to update: ");
                if (sc.hasNextInt()) {
                    iup = sc.nextInt();
                    if (conf.getSingleValues("SELECT ID  FROM Students  WHERE ID = ?", iup) != 0) {
                        break;
                    } else {
                        System.out.println("Selected Student doesn't exist.");
                    }
                } else {
                    System.out.println("Invalid input. Please enter a integer Student ID.");
                    sc.next(); 
                }
            }
                
                System.out.print("Enter new Contact No. : ");
                String newcon = sc.next();
                System.out.print("Enter new Address: ");
                String newadd = sc.next();
                System.out.print("Enter new Gender: ");
                String newgen = sc.next();
                System.out.print("Enter new Status: ");
                String newstats = sc.next();
                
                conf.updateRecord(sqlUP, newcon, newadd, newgen, newstats, iup);                
                
             break;      
             
            case 4:
                st.viewStudents();
                String sqdel = "DELETE FROM Students WHERE ID = ? ";
                  int iDELETE;
                while (true) {
                System.out.print("Enter Student ID to Delete: ");
                if (sc.hasNextInt()) {
                    iDELETE = sc.nextInt();
                    if (conf.getSingleValues("SELECT ID  FROM Students  WHERE ID = ?", iDELETE) != 0) {
                        break;
                    } else {
                        System.out.println("Selected Student doesn't exist.");
                    }
                } else {
                    System.out.println("Invalid input. Please enter a integer Student ID.");
                    sc.next(); 
                }
            }
                
                conf.deleteRecord(sqdel, iDELETE);
            break;
            
             case 5:
                   return;
          
        }

            System.out.print("Do you want to Continue? Yes or No: ");
            resp = sc.next();
            
            while(!resp.equalsIgnoreCase("yes") && !resp.equalsIgnoreCase("no")) {
                System.out.println("Invalid input, Enter again: ");
                resp = sc.next();
            }
           
            } while(resp.equalsIgnoreCase("yes"));
            System.out.println("\nThank you!");
            System.exit(0);
            
        }
    
              
    }

    
    
    
    
    
    
    








    

