package com.masai.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.masai.model.Employee;
import com.masai.model.EmployeeDTO;

@Repository
public interface EmployeeRepo extends JpaRepository<Employee,Integer> {
	
	
	public List<Employee> findByAddress(String address);
	
	@Query("Select e.empName,e.address from Employee e where e.empld=?1")
	public String[] getNameAndAddressOfEmployeeById(Integer id);

	
//	@Query("Select new com.masai.model.EmployeeDTO(e.name,e.address,e.salary) from Employee e ")
//	public List<EmployeeDTO> getNameAddressAndSalary();
	
}


