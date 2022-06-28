package unit5.eval1.Question2;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.spi.FileSystemProvider;

public class Main {
	
	public static void main(String[] args) throws Exception {
		Employee employee = new Employee(12, "Harsh", new Address("U.P","Aligarh","202001"), "harsh2345@gmail.com", "Random33");
		
		
		FileOutputStream fos = new FileOutputStream("emp.txt") ;
		ObjectOutputStream oos =  new ObjectOutputStream(fos);
		
		oos.writeObject(employee);
		
		oos.close();
		
		System.out.println("Serialization is  done.........");
		System.out.println("******************************");
		
		
		FileInputStream fis = new FileInputStream("emp.txt");
		ObjectInputStream ois =  new ObjectInputStream(fis);
		
		Object o = ois.readObject();
		
		Employee e = (Employee)o;
		
		System.out.println("The Employee Id is "+e.getEmpId());
		System.out.println("The Employee Name is "+e.getEmpName());
		System.out.println("The Employee State is "+e.getAddress().getState());
		System.out.println("The Employee City is "+e.getAddress().getCity());
		System.out.println("The Employee City Pincode is "+e.getAddress().getCity());
		System.out.println("The Employee Email : "+e.getEmail());
		System.out.println("Password :"+e.getPassword());
		
		System.out.println("Deserialization is done.............");
		
		ois.close();
		
		
	}
	
	
	
}
