package training;
import java.util.*;
import java.sql.DriverManager;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.*;

public class Employees {
public static void main(String[] args) {
	Scanner sc=new Scanner(System.in);
	Logger logger=Logger.getLogger("Employees");
	
	Connection conn=null;
	try{
	conn=(Connection)DriverManager.getConnection("jdbc:mysql://localhost:3306/employees","root","Chebolu@03");
	if(conn!=null){
	System.out.println("Connected");
	
	PreparedStatement insertpermanentstmt;
	PreparedStatement insertparttimestmt;
	PreparedStatement insertcontractstmt;
	PreparedStatement updatepermanentstmt;
	PreparedStatement updateparttimestmt;
	PreparedStatement updatecontractstmt;
	PreparedStatement deletepermanentstmt;
	PreparedStatement deleteparttimestmt;
	PreparedStatement deletecontractstmt;
	PreparedStatement selectpermanentstmt;
	PreparedStatement selectparttimestmt;
	PreparedStatement selectcontractstmt;
	
	
    for(int i=0;i<5;i++) {
    	System.out.println("Enter empId");
		int empId=sc.nextInt();
		sc.nextLine();
		System.out.println("Enter empName");
		String empName=sc.nextLine();
		System.out.println("Enter empSalary");
		int empSalary=sc.nextInt();
		sc.nextLine();
		System.out.println("Enter empType");
		String empType=sc.nextLine();
		if(empType.equals("Permanent")) {
		 	 insertpermanentstmt=conn.prepareStatement("insert into permanenthashtable values(?,?,?,?)");
		     insertpermanentstmt.setInt(1, empId);
		     insertpermanentstmt.setString(2, empName);
		     insertpermanentstmt.setInt(3, empSalary);
		     insertpermanentstmt.setString(4, empType);
		     insertpermanentstmt.executeUpdate();			     	     
		}
		else if(empType.equals("PartTime")) {
			insertparttimestmt=conn.prepareStatement("insert into parttimehashtable values(?,?,?,?)");
			insertparttimestmt.setInt(1, empId);
			insertparttimestmt.setString(2, empName);
			insertparttimestmt.setInt(3, empSalary);
			insertparttimestmt.setString(4, empType);
			insertparttimestmt.executeUpdate();     
		}
		else if(empType.equals("Contract")) {
			insertcontractstmt=conn.prepareStatement("insert into contracthashtable values(?,?,?,?)");
			insertcontractstmt.setInt(1, empId);
			insertcontractstmt.setString(2, empName);
			insertcontractstmt.setInt(3, empSalary);
			insertcontractstmt.setString(4, empType);
			insertcontractstmt.executeUpdate();		     
			}
		else
			System.out.println("No Such Type");
		
    }
    String input;
	do {
    	System.out.print("1.Create ,2.Modify ,3.Delete ,4.List all employees");
        int n=sc.nextInt();
    switch(n) {
    	case 1:System.out.println("Enter empId");
		       int empId=sc.nextInt();
		       sc.nextLine();
		       System.out.println("Enter empName");
		       String empName=sc.nextLine();
		       System.out.println("Enter empSalary");
		       int empSalary=sc.nextInt();
		       sc.nextLine();
		       System.out.println("Enter empType");
		       String empType=sc.nextLine();
    	       if(empType.equals("Permanent")) {   	    	  
    	    	   insertpermanentstmt=conn.prepareStatement("insert into permanenthashtable values(?,?,?,?)");
  		           insertpermanentstmt.setInt(1, empId);
  		           insertpermanentstmt.setString(2, empName);
  		           insertpermanentstmt.setInt(3, empSalary);
  		           insertpermanentstmt.setString(4, empType);
  		           insertpermanentstmt.executeUpdate();
  		            
    	       }
    	       else if(empType.equals("PartTime")) {   	    	   
    	    	   insertparttimestmt=conn.prepareStatement("insert into parttimehashtable values(?,?,?,?)");
   			       insertparttimestmt.setInt(1, empId);
   			       insertparttimestmt.setString(2, empName);
   			       insertparttimestmt.setInt(3, empSalary);
   			       insertparttimestmt.setString(4, empType);
   			       insertparttimestmt.executeUpdate();  			        
    	       }
    	       else if(empType.equals("Contract")) {   				
    	    	    insertcontractstmt=conn.prepareStatement("insert into contracthashtable values(?,?,?,?)");
    				insertcontractstmt.setInt(1, empId);
    				insertcontractstmt.setString(2, empName);
    				insertcontractstmt.setInt(3, empSalary);
    				insertcontractstmt.setString(4, empType);
    				insertcontractstmt.executeUpdate();    				
    				}
    			else 
    				System.out.println("No Such Type");
    	      logger.log(Level.INFO, "Employee info is added...");
    	      break;
    	case 2:System.out.print("Want to modify employee detail in 1.PermanentList ,2.PartTimeList ,3.ContractList");
	            int user2 =sc.nextInt();
	            if(user2==1) {
	               System.out.print("Enter empId to modify: ");
                   int id1=sc.nextInt();
              	   int salary=sc.nextInt();
                   updatepermanentstmt=conn.prepareStatement("update permanenthashtable set empSalary=? where empId=?");
                   updatepermanentstmt.setInt(1, salary);
                   updatepermanentstmt.setInt(2,id1);
                   updatepermanentstmt.executeUpdate();                 
                }
	            else if(user2==2) {
	            	System.out.print("Enter empId to modify: ");
                    int id4=sc.nextInt();
                    int salary=sc.nextInt();
             	    updateparttimestmt=conn.prepareStatement("update parttimehashtable set empSalary=? where empId=?");
               	    updateparttimestmt.setInt(1, salary);
               	    updateparttimestmt.setInt(2,id4);
               	    updateparttimestmt.executeUpdate();   
                } 
	            else {
	            	 System.out.print("Enter empId to modify: ");
	                   int id2=sc.nextInt();
	                   int salary=sc.nextInt();
	                   updatecontractstmt=conn.prepareStatement("update contracthashtable set empSalary=? where empId=?");
	               	   updatecontractstmt.setInt(1, salary);
	                   updatecontractstmt.setInt(2,id2);
	                   updatecontractstmt.executeUpdate();   
	            }
	            sc.nextLine();
	            logger.log(Level.INFO, "Employee details updated...");
	            break;
    	case 3:System.out.print("Want to delete employee in 1.PermanentList ,2.PartTimeList ,3.ContractList");
	           int userChoice =sc.nextInt();
	           if(userChoice==1) {
	        	   System.out.print("Enter empId to remove: ");
	                int id=sc.nextInt();
	                deletepermanentstmt=conn.prepareStatement("delete from permanenthashtable where empId=?");
	                deletepermanentstmt.setInt(1,id);
	                deletepermanentstmt.executeUpdate();
	           }
	           else if(userChoice==2) {
	        	   System.out.print("Enter empId to remove: ");
                   int id1=sc.nextInt();
                   deleteparttimestmt=conn.prepareStatement("delete from parttimehashtable where empId=?");
	               deleteparttimestmt.setInt(1,id1);
	               deleteparttimestmt.executeUpdate();
	           }
	           else {
	        	   System.out.print("Enter empId to remove: ");
                   int id2=sc.nextInt();
                   deletecontractstmt=conn.prepareStatement("delete from contracthashtable where empId=?");
	               deletecontractstmt.setInt(1,id2);
	               deletecontractstmt.executeUpdate();
	           }
	           logger.log(Level.INFO, "Employee details deleted...");
	           sc.nextLine();
	            break;   
    	case 4:JSONObject permanent=new JSONObject();
    	       JSONObject parttime=new JSONObject();
    	       JSONObject contract=new JSONObject();
               JSONArray permanentArray=new JSONArray();
    	       JSONArray parttimeArray=new JSONArray();
    	       JSONArray contractArray=new JSONArray();
    	
    		   selectpermanentstmt=conn.prepareStatement("select *from permanenthashtable");
    		   ResultSet rs=selectpermanentstmt.executeQuery();
    		   while(rs.next()) {
    			    permanent.put("empId",rs.getInt("empId"));
 			        permanent.put("empName",rs.getString("empName"));
 			        permanent.put("empSalary",rs.getInt("empSalary"));
 			        permanent.put("empType",rs.getString("empType"));
 			        permanentArray.put(permanent);
    		   }
    		   selectparttimestmt=conn.prepareStatement("select *from parttimehashtable");
    		   ResultSet rs1=selectparttimestmt.executeQuery();
    		   while(rs1.next()) {
    			     parttime.put("empId",rs1.getInt("empId"));
    			     parttime.put("empName",rs1.getString("empName"));
    			     parttime.put("empSalary",rs1.getInt("empSalary"));
    			     parttime.put("empType",rs1.getString("empType"));
    			     parttimeArray.put(parttime); 
    		   }
    		   selectcontractstmt=conn.prepareStatement("select *from contracthashtable");
    		   ResultSet rs2=selectcontractstmt.executeQuery();
    		   while(rs2.next()) {
    			     contract.put("empId",rs2.getInt("empId"));
    			     contract.put("empName",rs2.getString("empName"));
    			     contract.put("empSalary",rs2.getInt("empSalary"));
    			     contract.put("empType",rs2.getString("empType"));
    			     contractArray.put(contract);
    		   }
    		   logger.log(Level.INFO, "All Employee details....");
    		   System.out.println(permanentArray);
    		   System.out.println(parttimeArray);
    		   System.out.println(contractArray);
    		   sc.nextLine();
               break;
       default: System.out.println("No such operation");   
                sc.nextLine();
               break;
    }
    System.out.println("Do you want to continue[yes/no]:");
    input=sc.nextLine();
    }while(input.equals("yes")); 
	conn.close();
	}
	}catch(Exception e) {
		System.out.println("NOT Connected");
		logger.log(Level.WARNING, "Database is not connected....");
		}
	}
}
