package training;
import java.util.*;
class PermanentEmployees extends Employees{
	public static Hashtable<Integer,PermanentEmployees> permanentHashtable=new Hashtable<>();
	int empId;
	String empName;
	int empSalary;
	String empType;
	PermanentEmployees(int empId,String empName,int empSalary,String empType) {
		this.empId=empId;
		this.empName=empName;
		this.empSalary=empSalary;
		this.empType=empType;
	}
	@Override
	public String toString() {
		return "PermanentEmployees [empId=" + empId + ", empName=" + empName + ", empSalary=" + empSalary + ", empType=" + empType + "]";
	}
}
class PartTimeEmployees extends Employees {
	public static Hashtable<Integer,PartTimeEmployees> partTimeHashtable=new Hashtable<>();
	int empId;
	String empName;
	int empSalary;
	String empType;
	PartTimeEmployees(int empId,String empName,int empSalary,String empType) {
		this.empId=empId;
		this.empName=empName;
		this.empSalary=empSalary;
		this.empType=empType;
	}
	@Override
	public String toString() {
		return "PartTimeEmployees [empId=" + empId + ", empName=" + empName + ", empSalary=" + empSalary + ", empType=" + empType + "]";
	}
}
class ContractEmployees extends Employees {
	public static Hashtable<Integer,ContractEmployees> contractHashtable=new Hashtable<>();
	int empId;
	String empName;
	int empSalary;
	String empType;
	ContractEmployees(int empId,String empName,int empSalary,String empType) {
		this.empId=empId;
		this.empName=empName;
		this.empSalary=empSalary;
		this.empType=empType;
	}
	@Override
	public String toString() {
		return "ContractEmployees [empId=" + empId + ", empName=" + empName + ", empSalary=" + empSalary + ", empType="
				+ empType + "]";
	}
}

public class Employees {
public static void main(String[] args) {
	Scanner sc=new Scanner(System.in);
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
		if(empType.equals("Permanent")) 
			PermanentEmployees.permanentHashtable.put(empId, new PermanentEmployees(empId,empName,empSalary,empType));
		else if(empType.equals("PartTime"))
			PartTimeEmployees.partTimeHashtable.put(empId, new PartTimeEmployees(empId,empName,empSalary,empType));
		else if(empType.equals("Contract"))
			ContractEmployees.contractHashtable.put(empId, new ContractEmployees(empId,empName,empSalary,empType));
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
    	       if(empType.equals("Permanent")) 
    	    	   PermanentEmployees.permanentHashtable.put(empId, new PermanentEmployees(empId,empName,empSalary,empType));
    	       else if(empType.equals("PartTime"))
    	    	   PartTimeEmployees.partTimeHashtable.put(empId, new PartTimeEmployees(empId,empName,empSalary,empType));
    	       else if(empType.equals("Contract"))
    				ContractEmployees.contractHashtable.put(empId, new ContractEmployees(empId,empName,empSalary,empType));
    			else
    				System.out.println("No Such Type");
    	        break;
    	case 2:System.out.print("Want to modify employee detail in 1.PermanentList ,2.PartTimeList ,3.ContractList");
	            int user2 =sc.nextInt();
	            if(user2==1) {
	               System.out.print("Enter empId to modify: ");
                   int id1=sc.nextInt();
                   if(PermanentEmployees.permanentHashtable.containsKey(id1)) {
                	   int salary=sc.nextInt();
                	  PermanentEmployees.permanentHashtable.get(id1).empSalary=salary;
                    }
                    else
                	   System.out.println("No Employee found with that id");
                }
	            else if(user2==2) {
	            	System.out.print("Enter empId to modify: ");
                    int id4=sc.nextInt();
                    if(PartTimeEmployees.partTimeHashtable.containsKey(id4)) {
             	       int salary=sc.nextInt();
             	      PartTimeEmployees.partTimeHashtable.get(id4).empSalary=salary;
                     }
                     else
             	    System.out.println("No Employee found with that id");
                } 
	            else {
	            	 System.out.print("Enter empId to remove: ");
	                   int id2=sc.nextInt();
	                   if(ContractEmployees.contractHashtable.containsKey(id2)) {
	                	   int salary=sc.nextInt();
	                	  ContractEmployees.contractHashtable.get(id2).empSalary=salary;
	                   }
	                   else
	                	   System.out.println("No Employee found with that id");
	            }
	            break;
    	case 3:System.out.print("Want to delete employee in 1.PermanentList ,2.PartTimeList ,3.ContractList");
	           int userChoice =sc.nextInt();
	           if(userChoice==1) {
	        	   System.out.print("Enter empId to remove: ");
	                int id=sc.nextInt();
	                if(PermanentEmployees.permanentHashtable.containsKey(id))
	    	            PermanentEmployees.permanentHashtable.remove(id);
	                else
	                	System.out.println("No Employee found with that id");
	           }
	           else if(userChoice==2) {
	        	   System.out.print("Enter empId to remove: ");
                   int id1=sc.nextInt();
                   if(PartTimeEmployees.partTimeHashtable.containsKey(id1))
	    	        PartTimeEmployees.partTimeHashtable.remove(id1);
                   else
                	   System.out.println("No Employee found with that id");
	           }
	           else {
	        	   System.out.print("Enter empId to remove: ");
                   int id2=sc.nextInt();
                   if(ContractEmployees.contractHashtable.containsKey(id2))
	    	            ContractEmployees.contractHashtable.remove(id2);
                   else
                	   System.out.println("No Employee found with that id");
	           }
	            break;   
    	case 4:System.out.println(PermanentEmployees.permanentHashtable);
               System.out.println(PartTimeEmployees.partTimeHashtable);
               System.out.println(ContractEmployees.contractHashtable);
               break;
       default: System.out.println("No such operation");   
    }
    System.out.println("Do you want to continue[yes/no]:");
    sc.nextLine();
    input=sc.nextLine();
    }while(input.equals("yes"));   
}
}
