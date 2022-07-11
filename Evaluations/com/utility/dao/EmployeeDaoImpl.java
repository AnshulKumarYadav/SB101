package com.utility.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.utility.util.DBUtil;
import com.utility.bean.Employee;
import com.utility.exception.EmployeeException;

public class EmployeeDaoImpl implements EmployeeDao{

	@Override
	public String saveEmployeeDetails(Employee employee) {
		
String message = "Not inserted";
		
		try(Connection conn = DBUtil.provideConnection()) {
			
			PreparedStatement ps = conn.prepareStatement("INSERT INTO employee VALUES(?,?,?,?)");
			ps.setInt(1, employee.getEid());
			ps.setString(2, employee.getName());
			ps.setString(3, employee.getAddress());
			ps.setInt(4, employee.getSalary());
			
			int x = ps.executeUpdate();
			
			if(x>0)
			{
				message = x+" rows affected";
			}
			
		} catch (SQLException e2) {
			
		}
		
		return message;
		
		
	}

	@Override
	public Employee getEmployeeById(int empId) throws EmployeeException {
		
		Employee e = null;
		try(Connection conn = DBUtil.provideConnection()) {
		PreparedStatement ps = conn.prepareStatement("select * from employee where empId=?");
		ps.setInt(1, empId);
		
		ResultSet rs = ps.executeQuery();
		
		if(rs.next())
		{
			e = new Employee(rs.getInt("empId"),rs.getString("name"),rs.getString("address"),rs.getInt("salary"));
		}
		throw new EmployeeException("Problem in get employee");
		
		} catch (SQLException e2) {
			e2.getMessage();
		}
	

	return e;
		
	}

	@Override
	public List<Employee> getAllEmployees() {
		List<Employee> e = new ArrayList<>();
		
		 try(Connection conn = DBUtil.provideConnection()) {
				
				PreparedStatement ps = conn.prepareStatement("select * from employee");
				
				ResultSet rs = ps.executeQuery();
				
				while(rs.next())
				{
					e.add(new Employee(rs.getInt("empId"),rs.getString("name"),rs.getString("address"),rs.getInt("salary")));
				}
				
				
			} catch (SQLException e2) {
				
			}
		
		return e;
	}

	@Override
	public String deleteEmployee(int empId) throws EmployeeException {
		 String message = "Not Deleted";
		 
		 try(Connection conn = DBUtil.provideConnection()) {
				
				PreparedStatement ps = conn.prepareStatement("delete from employee where empId = ?");
				ps.setInt(1, empId);
				
				
				int x = ps.executeUpdate();
				
				if(x>0)
				{
					message = x+"  row Deleted";
				}
				
				throw new EmployeeException("Problem in deleted items");
				
		 } catch (SQLException e) {
				e.getMessage();
			}
				return message;
				
			
}
}
