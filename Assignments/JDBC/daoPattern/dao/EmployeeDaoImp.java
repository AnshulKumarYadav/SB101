package com.daoPattern.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.daoPattern.bean.Employee;
import com.daoPattern.utility.DBUtil;

public class EmployeeDaoImp implements EmployeeDao {

	@Override
	public String insertDetails(Employee e) {
		
		String message = "Not inserted";
		
		try(Connection conn = DBUtil.provideConnection()) {
			
			PreparedStatement ps = conn.prepareStatement("INSERT INTO employee VALUES(?,?,?,?)");
			ps.setInt(1, e.getEid());
			ps.setString(2, e.getName());
			ps.setString(3, e.getAddress());
			ps.setInt(4, e.getSalary());
			
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
	public int getSalaryByid(int eid) {
		
		int a = -1;
		
	try(Connection conn = DBUtil.provideConnection()) {
			
			PreparedStatement ps = conn.prepareStatement("SELECT  salary FROM  employee where eid=?");
			ps.setInt(1, eid);
			
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next())
			{
				a = rs.getInt("salary");
			}
			
		} catch (SQLException e2) {
			
		}
		
		return a;
	}

	@Override
	public List<Employee> getAllEmployees() {
		
		List<Employee> e = new ArrayList<>();
		
		 try(Connection conn = DBUtil.provideConnection()) {
				
				PreparedStatement ps = conn.prepareStatement("select * from employee");
				
				ResultSet rs = ps.executeQuery();
				
				while(rs.next())
				{
					e.add(new Employee(rs.getInt("eid"),rs.getString("name"),rs.getString("address"),rs.getInt("salary")));
				}
				
				
			} catch (SQLException e2) {
				
			}
		
		return e;
	}

	@Override
	public Boolean provideBonus(int bonus) {
		
		boolean isProvide = false;
		
            try(Connection conn = DBUtil.provideConnection()) {
			
			PreparedStatement ps = conn.prepareStatement("update employee set salary = salary+?");
			ps.setInt(1, bonus);
			
			
			int x = ps.executeUpdate();
			
			if(x>0)
			{
				isProvide = true;
			}
			
		} catch (SQLException e2) {
			
		}
		
		return isProvide;
		
	}

	@Override
	public String insertWithourAddress(int eid,String name,int salary) {
       String message = "Not inserted";
		
		try(Connection conn = DBUtil.provideConnection()) {
			
			PreparedStatement ps = conn.prepareStatement("INSERT INTO employee(eid,name,salary) VALUES(?,?,?)");
			ps.setInt(1, eid);
			ps.setString(2, name);
			ps.setInt(3, salary);
			
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
	public Employee getEmployeeById(int eid) {
		Employee e = null;
		
            try(Connection conn = DBUtil.provideConnection()) {
			
			PreparedStatement ps = conn.prepareStatement("select * from employee where eid=?");
			ps.setInt(1, eid);
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next())
			{
				e = new Employee(rs.getInt("eid"),rs.getString("name"),rs.getString("address"),rs.getInt("salary"));
			}
			
			
		} catch (SQLException e2) {
			
		}
		
	
		return e;
	}

	@Override
	public List<Employee> getEmployeeBySalary(int salary) {
		List<Employee> e = new ArrayList<>();
		
		 try(Connection conn = DBUtil.provideConnection()) {
				
				PreparedStatement ps = conn.prepareStatement("select * from employee where salary<?");
				ps.setInt(1, salary);
				
				ResultSet rs = ps.executeQuery();
				
				while(rs.next())
				{
					e.add(new Employee(rs.getInt("eid"),rs.getString("name"),rs.getString("address"),rs.getInt("salary")));
				}
				
				
			} catch (SQLException e2) {
				
			}
			
		
		
		return e;
	}
	
}
