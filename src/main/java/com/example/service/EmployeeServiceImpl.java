package com.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.model.Employee;
import com.example.repository.EmployeeRepository;

@Service()
public class EmployeeServiceImpl implements EmployeeService {
@Autowired()	
private	EmployeeRepository er;


public Employee get(Long id) {
	return er.findById(id).get();
}

	public boolean checkuser(Long id) {
		return er.existsById(id);
	}
	public boolean checklogin(Long id, String password) {
		if (checkuser(id)) {
			Employee emp = get(id);
			if(emp.getPassword().equals(password)) {
				return true;
			}
			else {
				return false;
			}
		}
		else {
			return false;
		}
	}

	
}
