package com.example.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


import org.apache.logging.log4j.LogManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.exception.ResourceNotFoundException;
import com.example.model.Employee;
import com.example.repository.EmployeeRepository;
import com.example.service.EmployeeService;

@RestController
@CrossOrigin(origins="http://localhost:4200")
@RequestMapping("/api/v1/")
public class EmployeeController {

	@Autowired
	private EmployeeRepository er;
	@Autowired
	private EmployeeService es;
	
    private static final org.apache.logging.log4j.Logger logger =  LogManager.getLogger(EmployeeController.class);

	
	// get all employee
	
	@GetMapping("/employees")
	public List<Employee> getAllEmployees(){
		logger.info("Info log entered in list of Employee controller");
		return er.findAll();
		
		
	}
	
	// create employee rest api
			@PostMapping("/employees")
			public Employee createEmployee(@RequestBody Employee emp) {
				logger.info("Info log entered in save controller");
				return er.save(emp);
			}
			
			
			//get employee by id rest api
			@GetMapping("employees/{id}")
			public ResponseEntity<Employee> getEmployeeById(@PathVariable long id){
				logger.info("Info log entered in getEmployeeById controller");
				Employee emp=er.findById(id)
						.orElseThrow(()->new ResourceNotFoundException("Employee not exist with id:"+id));
				return ResponseEntity.ok(emp);
			}
			
			//update employee rest api
			@PutMapping("/employees/{id}")
			public ResponseEntity<Employee> updateEmployee(@PathVariable long id,@RequestBody Employee employeeDetails){
				logger.info("Info log entered in update controller");
				Employee emp=er.findById(id)
						.orElseThrow(()->new ResourceNotFoundException("Employee not exist with id:"+id));
				emp.setName(employeeDetails.getName());
				emp.setEmail(employeeDetails.getEmail());
				emp.setPassword(employeeDetails.getPassword());
				logger.info("Updated recored and now going to save");
				Employee updatedEmployee =er.save(emp);
				System.out.println(updatedEmployee);
				return ResponseEntity.ok(updatedEmployee);
			}
			//Delete employee rest api
			@DeleteMapping("/employees/{id}")
			public ResponseEntity< Map<String , Boolean>> deleteEmployee(@PathVariable long id){
				Employee emp=er.findById(id)
						.orElseThrow(()->new ResourceNotFoundException("Employee not exist with id:"+id));
				er.delete(emp);
				Map<String ,Boolean> response=new HashMap<>();
				response.put("deleted", Boolean.TRUE);
				
				return ResponseEntity.ok(response);
		
			}
			

			@PostMapping("employees/login")
			public boolean check(@RequestBody Employee empl) {
				return es.checklogin(empl.getId(), empl.getPassword());
				
			}
}
