package SCS;

import java.util.Scanner;


public class Medicine {
    
    
    public void  addMedicine(){
        
        Scanner sc = new Scanner(System.in);
        config conf = new  config();
        
        System.out.print("Enter name of Medicine : ");
        String med = sc.next();
        System.out.print("Dosage Form (Tablet, Liquid, Injection): ");
        String dis = sc.next();
        System.out.print("Dosage Strength (500 MG): ");
        String dos = sc.next();
        System.out.print("Side Effects: ");
        String side = sc.next();
        System.out.print("Purpose: ");
        String pur = sc.next();
        System.out.print("Quantity: ");
        double quan = sc.nextDouble();
        System.out.print("Expiration Date (YYYY - MM - DD): ");
        String date = sc.next();
        
        String sqlmed = "INSERT INTO Medicine (Medicine_Name, Dosage_Form, Dosage_Strength, Side_Effects, Pupose, Quantity, Expiration_Date) VALUES(?,?,?,?,?,?,?)";
        conf.addRecords(sqlmed,med, dis,dos,side,pur,quan,date);
       
        
    }
    
    public void viewMedicine(){
        
        String qry = "SELECT * FROM Medicine";
        String[] hdrs = {"Medicine ID", "Name", "Dosage Form", "Dosage Strength", "Side Effects ","Purpose", "Quantity","Expiration Date"};
        String[] clmns = {"Medicine_ID", "Medicine_Name", "Dosage_Form", "Dosage_Strength", "Side_Effects", "Pupose", "Quantity","Expiration_Date"};
        
        config conf = new config();
        
        conf.viewRecords(qry, hdrs, clmns);
       
    }
    
    public void mainMedicine(){
        
        Medicine md = new Medicine();
        config conf = new config();
        Scanner sc = new Scanner(System.in);
        
        String res;
        do{
            
       System.out.println(""); 

        
        System.out.println("+--------------------------+");
        System.out.println("|      Medicine Menu       |");
        System.out.println("+--------------------------+");
        System.out.println("| 1. Add Medicine          |");
        System.out.println("| 2. View Medicine         |");
        System.out.println("| 3. Update Medicine       |");
        System.out.println("| 4. Delete Medicine       |");
        System.out.println("| 5. Exit                  |");
        System.out.println("+--------------------------+");

        
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
                 md.addMedicine();
                 break;
             case 2:
                 md.viewMedicine();
                 break;
             case 3:
                   md.viewMedicine();
                   String sql = "UPDATE Medicine SET  Dosage_Strength = ?, Side_Effects = ?,  Pupose = ?, Expiration_Date = ?, Quantity = ? WHERE Medicine_ID = ?";
                  
                   
                   int up;
                while (true) {
                System.out.print("Enter Medicine ID to Update: ");
                if (sc.hasNextInt()) {
                    up = sc.nextInt();
                    if (conf.getSingleValues("SELECT Medicine_ID FROM Medicine  WHERE Medicine_ID = ?", up) != 0) {
                        break;
                    } else {
                        System.out.println("Selected Medicine doesn't exist.");
                    }
                } else {
                    System.out.println("Invalid input. Please enter a integer Medicine ID.");
                    sc.next(); 
                }
            }

                   
                   System.out.print("Enter new Dosage Strength: ");
                   String newdos = sc.next();
                   System.out.print("Enter new Side Effects: ");
                   String newside = sc.next();
                   System.out.print("Enter new Purpose: ");
                   String newpose = sc.next();
                   System.out.print("Enter new Expiration Date: ");
                   String newdate = sc.next();
                   System.out.println("Enter new Quantity: ");
                   double newquan = sc.nextDouble();
                   
                   conf.updateRecord(sql, newdos, newside, newpose, newdate,newquan,up);
                 break;
             case 4:
                  md.viewMedicine();
                  String sqldel = "DELETE FROM Medicine WHERE Medicine_ID = ?";
                  
                  
                 
                   int id5;
                while (true) {
                System.out.print("Enter Medicine ID to Delete: ");
                if (sc.hasNextInt()) {
                    id5 = sc.nextInt();
                    if (conf.getSingleValues("SELECT Medicine_ID FROM Medicine  WHERE Medicine_ID = ?", id5) != 0) {
                        break;
                    } else {
                        System.out.println("Selected Medicine doesn't exist.");
                    }
                } else {
                    System.out.println("Invalid input. Please enter a integer Medicine ID.");
                    sc.next(); 
                }
            }

                  
                  
                  conf.deleteRecord(sqldel, id5);
                 break;
             case 5:
                 System.out.println("Exiting......");
                 break;
         }
         
            System.out.println("");
            System.out.print("Do you want to continue on Medicine Panel? Yes or No: ");
            res = sc.next();
    }while(res.equalsIgnoreCase("yes"));
        
        
        
    }
    
    }
