package com.masai.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.masai.exception.EmployeeException;
import com.masai.model.Employee;
import com.masai.model.EmployeeDTO;
import com.masai.service.EmployeeService;


@RestController
public class EmployeeController {
     @Autowired
	private EmployeeService eService;
	
	@PostMapping("/employees")
	public ResponseEntity<Employee> registerEmployeeHandler(@Valid @RequestBody Employee employee) throws EmployeeException{
		
	Employee emp =	eService.registerEmployee(employee);
		
	return new ResponseEntity<Employee>(emp ,HttpStatus.CREATED);
	}
	
	
	@GetMapping("/employees/{id}")
	public ResponseEntity<Employee> getEmployeeByIdHandler(@PathVariable("id") Integer id) throws EmployeeException{
		
		Employee emp = eService.getEmployeeById(id);
		
		return new ResponseEntity<Employee>(emp, HttpStatus.OK);
	}
	
	
	@GetMapping("/employees")
	public ResponseEntity<java.util.List<Employee>> getAllEmployeeHandler() throws EmployeeException{
		
	List<Employee> emp = eService.getAllEmployeeDetails();
	 return new ResponseEntity<List<Employee>>(emp, HttpStatus.OK);
	
	}
	
	@DeleteMapping("/employees/{id}")
	public ResponseEntity<Employee> deleteEmployeeByIdHandler(@PathVariable("id") Integer id) throws EmployeeException{
		
	Employee emp = 	eService.deleteEmployeeById(id);
	
	return new ResponseEntity<Employee>(emp, HttpStatus.OK);
	}
	
	
	@GetMapping("/getemployees/{address}")
	public ResponseEntity<List<Employee>> getEmployeeByAddress(@PathVariable("address") String address) throws EmployeeException{
		
		List<Employee> emp = eService.getEmployeeDetailsByAddress(address);
		
		return new ResponseEntity<List<Employee>>(emp,HttpStatus.OK);
		
	}
	
	@GetMapping("/getemployeesname/{id}")
	public ResponseEntity<String[]> getNameAndAddressByIdHandler(@PathVariable ("id") Integer id) throws EmployeeException{
		
		String[] st = eService.getNameAndAddressOfEmplyeeById(id);
		
		return new ResponseEntity<String[]>(st,HttpStatus.OK);
		
	}
	
	
	@PutMapping("/employees")
	public ResponseEntity<Employee> updateEmployeeHandler(@RequestBody Employee employee) throws EmployeeException{
		
		Employee emp = eService.updateEmployee(employee);
		
		return new ResponseEntity<Employee>(emp,HttpStatus.OK);
	}
	

	
	
	
	
}
