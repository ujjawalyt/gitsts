package com.masai.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.exception.EmployeeException;
import com.masai.model.Employee;
import com.masai.model.EmployeeDTO;
import com.masai.repository.EmployeeRepo;


@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
	private EmployeeRepo eRepo;
	
	@Override
	public Employee registerEmployee(Employee emp) throws EmployeeException {
		
		Employee saveEmployee = eRepo.save(emp);
		return saveEmployee;
	}

	@Override
	public Employee getEmployeeById(Integer empId) throws EmployeeException {
	  
		Optional<Employee>  opt = eRepo.findById(empId);
		if(opt.isPresent()) {
		Employee employee = opt.get();
		return employee;
		}
		
		else {
			throw new EmployeeException("Employee does not exist with this id" + empId);
		}
		
		
	}

	@Override
	public List<Employee> getAllEmployeeDetails() throws EmployeeException {
		
		List<Employee> employee = eRepo.findAll();
		 
		if(employee.size()==0) {
			throw new EmployeeException("No Employee is found ");
		}else {
			return employee;
		}
		
	}

	@Override
	public Employee deleteEmployeeById(Integer empId) throws EmployeeException {
		
		
	Optional<Employee> opt = eRepo.findById(empId);
	
	
	if(opt.isPresent()) {
		
	Employee existingEmployee = opt.get();
	eRepo.delete(existingEmployee);
	return existingEmployee;

	  
	}
	else {
		throw new EmployeeException("Employee not found With this id :"+  empId);
	}
		
	  
	}

	@Override
	public List<Employee> getEmployeeDetailsByAddress(String address) throws EmployeeException {
		
		List<Employee> employee = eRepo.findByAddress(address);
		 
		if(employee.size()==0) {
			throw new EmployeeException("No Employee is found by this address ");
		}else {
			return employee;
		}
		
	
	}

	@Override
	public Employee updateEmployee(Employee emp) throws EmployeeException {
	
		Optional<Employee> opt = eRepo.findById(emp.getEmpld());
		
		
		if(opt.isPresent()) {
			
	
			Employee updateEmployee = eRepo.save(emp);
		return updateEmployee;

		  
		}
		else {
			throw new EmployeeException("Employee not found ");
		}
		
		
		
		
		
	}

	@Override
	public String[] getNameAndAddressOfEmplyeeById(Integer empId) throws EmployeeException {
		
		String [] result = eRepo.getNameAndAddressOfEmployeeById(empId);


		if(result ==null) {
			throw new EmployeeException("Employee does not exis with this id");
		}else 
			
			return result;
		
	
	}

	@Override
	public List<EmployeeDTO> getNameAddressSalaryOfAllEmployee() throws EmployeeException {
	
		
		
//		List<EmployeeDTO> empdto = eRepo.getNameAddressAndSalary();
//		if(empdto==null) {
//			throw new EmployeeException("Employee Dto is not found.");
//		}else {
//			 return empdto;
//		}
//		
//	
//	
		
		
		
		return null;
	}
	
}

	
