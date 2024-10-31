
package SCS;

import java.util.Scanner;

public class ClinicRecordsLogs {
    
    public void addLogs(){
        config conf = new  config();
        Scanner sc = new Scanner(System.in);
        
        System.out.println(" - Student List - ");
        Student st = new Student();
        st.viewStudents();
        System.out.println(" - Medicine List - ");
        Medicine md = new Medicine();
        md.viewMedicine();
        
         int stid;
                while (true) {
                System.out.print("Enter Student ID: ");
                if (sc.hasNextInt()) {
                    stid = sc.nextInt();
                    if (conf.getSingleValues("SELECT ID  FROM Students  WHERE ID = ?", stid) != 0) {
                        break;
                    } else {
                        System.out.println("Selected Student doesn't exist.");
                    }
                } else {
                    System.out.println("Invalid input. Please enter a integer Student ID.");
                    sc.next(); 
                }
            }
        
        
       int medid;
                while (true) {
                System.out.print("Enter Medicine ID: ");
                if (sc.hasNextInt()) {
                    medid = sc.nextInt();
                    if (conf.getSingleValues("SELECT Medicine_ID FROM Medicine  WHERE Medicine_ID = ?", medid) != 0) {
                        break;
                    } else {
                        System.out.println("Selected Medicine doesn't exist.");
                    }
                } else {
                    System.out.println("Invalid input. Please enter a integer Medicine ID.");
                    sc.next(); 
                }
            }
                
        System.out.print("Enter Quantity: ");
        double quan = sc.nextDouble();
        
       String quantityQuery = "SELECT Quantity FROM Medicine WHERE Medicine_ID = ?";
    double currentQuantity = conf.getSingleValues(quantityQuery, medid);
    
   
    if (quan > currentQuantity) {
        System.out.println("Insufficient quantity available. Only " + currentQuantity + " available.");
        return; 
    }
        
        System.out.print("Enter Date (YYYY - MM - DD): ");
        String dates = sc.next();
        
        System.out.print("Time in: ");
        String timein = sc.next();
        
        System.out.print("Time out: ");
        String timeout = sc.next();
        
        System.out.print("Program: ");
        String prog = sc.next();
        
        System.out.print("Year & Section: ");
        String year = sc.next();
        
        System.out.print("Emergency Contact No. : ");
        String contact = sc.next();
        sc.nextLine();
        System.out.print("Reason for Visit: ");
        String reason = sc.nextLine();
        
        String sqlrecords = "INSERT INTO ClinicRecordsLog (Student_ID, Medicine_ID, Quantity, Date, Time_In, Time_Out, Program, Year_and_Section, Emergency_Contact_No, Reason_Visit) VALUES  (?,?,?,?,?,?,?,?,?,?)";
        
        conf.addRecords(sqlrecords, stid, medid, quan, dates,timein, timeout,prog,year,contact,reason);
        double newQuantity = currentQuantity - quan; 
    String updateQuantitySql = "UPDATE Medicine SET Quantity = ? WHERE Medicine_ID = ?";
    conf.updateRecord(updateQuantitySql, newQuantity, medid);
        
    }
    public void viewLogsRecords(){
        
        
        String view = "SELECT Logs_ID, First_name, Last_name, Program, Year_and_Section, Medicine_Name, Date, Time_In, Time_Out, Reason_Visit FROM ClinicRecordsLog "
                + "LEFT JOIN Students ON Students.ID = ClinicRecordsLog.Student_ID "
                + "LEFT JOIN Medicine ON Medicine.Medicine_ID = ClinicRecordsLog.Medicine_ID";
        String[] header = {"Logs ID", "First Name", "Last Name", "Program", "Year and Section", "Medicine Name", "Date", "Time In", "Time Out", "Reason"};
        String [] column = {"Logs_ID","First_name", "Last_name", "Program", "Year_and_Section", "Medicine_Name", "Date", "Time_In", "Time_Out", "Reason_Visit"};
        
        config conf = new config();
        conf.viewRecords(view, header, column);
        
        
    }
    public void mainRecords(){
        
        ClinicRecordsLogs crl1 = new ClinicRecordsLogs();
        config conf = new  config();
        Scanner sc = new Scanner(System.in);
         
        String rs;        
        do{
        System.out.println(""); 

      
        System.out.println("+---------------------------+");
        System.out.println("|     Clinic Records Menu    |");
        System.out.println("+---------------------------+");
        System.out.println("| 1. Add Records            |");
        System.out.println("| 2. View Records           |");
        System.out.println("| 3. Update Records         |");
        System.out.println("| 4. Delete Records         |");
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
                crl1.addLogs();
                break;
            case 2:
                crl1.viewLogsRecords();
                break;
            case 3:
                 crl1.viewLogsRecords();
                 String sql2 = "UPDATE ClinicRecordsLog SET Date = ?,  Program = ?, Year_and_Section = ?, Reason_Visit = ? WHERE Logs_ID = ?";
                  
                 
                 int ilogs;
                while (true) {
                System.out.print("Enter Clinic Records Log ID to Update : ");
                if (sc.hasNextInt()) {
                    ilogs = sc.nextInt();
                    if (conf.getSingleValues("SELECT Logs_ID  FROM ClinicRecordsLog  WHERE Logs_ID = ?", ilogs) != 0) {
                        break;
                    } else {
                        System.out.println("Selected  Clinic Records Log  doesn't exist.");
                    }
                } else {
                    System.out.println("Invalid input. Please enter a integer  Clinic Records Log  ID.");
                    sc.next(); 
                }
            };
                 
                 System.out.print("Enter new Date: ");
                 String newdate = sc.next();
                 System.out.print("Enter new Program: ");
                 String newprog = sc.next();
                 System.out.print("Enter new Year And Section: ");
                 String newyear = sc.next();
                 sc.nextLine();
                 System.out.print("Enter new Reason Visit: ");
                 String newvisit  = sc.nextLine();
                 
                 conf.updateRecord(sql2, newdate, newprog, newyear, newvisit, ilogs);
                break;
            case 4:
                crl1.viewLogsRecords();
                
                String del =  "DELETE FROM ClinicRecordsLog WHERE Logs_ID = ? ";
                
               
                 int del2;
                while (true) {
                System.out.print("Enter Clinic Records Log ID to Delete: ");
                if (sc.hasNextInt()) {
                    del2 = sc.nextInt();
                    if (conf.getSingleValues("SELECT Logs_ID  FROM ClinicRecordsLog  WHERE Logs_ID = ?", del2) != 0) {
                        break;
                    } else {
                        System.out.println("Selected  Clinic Records Log doesn't exist.");
                    }
                } else {
                    System.out.println("Invalid input. Please enter a integer  Clinic Records Log ID.");
                    sc.next(); 
                }
            };
                
                conf.deleteRecord(del, del2);
                break;
            case 5:
                
                System.out.println("Exiting........");
                break;
                
            
        }    
            System.out.println("");
            System.out.print("Do you want to continue on Clinic Record Log panel? Yes or No: ");
            rs = sc.next();
    }while(rs.equalsIgnoreCase("yes"));
        
        
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
