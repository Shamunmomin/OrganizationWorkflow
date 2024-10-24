package com.tka.OrganizationWorkflow.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tka.OrganizationWorkflow.entity.Country;
import com.tka.OrganizationWorkflow.entity.Employee;
import com.tka.OrganizationWorkflow.service.MainService;

@RestController
@RequestMapping("api")
public class MainController {

	@Autowired
	MainService service;
	
	
//	ADD COUNTRY RECORD
	@PostMapping("addcountry")
	public ResponseEntity<String> addcountry(@RequestBody Country c)
	{
		String msg=service.addcountry(c);
		return ResponseEntity.ok(msg);
	}
	
//	UPDATE COUNTRY RECORD
	@PutMapping("updaterecord/{id}")
	public ResponseEntity<String> updatecountry(@RequestBody Country c, @PathVariable int id)
	{
		String msg= service.updaterecord(c,id);
		
		return ResponseEntity.ok(msg);
	}
	
//	DELETE COUNTRY RECORD
	@DeleteMapping("deleterecord/{id}")
	public ResponseEntity<String> deleterecord(@PathVariable int id)
	{
		String msg=service.deleterecord(id);
		
		return ResponseEntity.ok(msg);
	}
	
//	GET PARTICULER RECORD FROM COUNTRY DATABSE
	@GetMapping("getparticulerrecord/{id}")
	public ResponseEntity<Country> getparticulerrecord(@PathVariable int id)
	{
	Country country=service.getparticulerrecord(id);
		return ResponseEntity.ok(country);
	}
	
	
//	GET ALL RECORD FROM COUNTRY DATABASE
	@GetMapping("getallrecord")
	public ResponseEntity<List<Country>> getallrecord()
	{
		List<Country> list=service.getallrecord();
		return ResponseEntity.ok(list);
    }
	
	
//	ADD EMPLOYEE RECORD
	@PostMapping("addrecord")
	public ResponseEntity<String> addrecord(@RequestBody Employee e)
	{
		String msg=service.addrecord(e);
		return ResponseEntity.ok(msg);
	}
	
	
//	UPDATE EMPLOYEE RECORD
	@PutMapping("updateemprecord/{id}")
	public ResponseEntity<String> updateemprecord(@RequestBody Employee e, @PathVariable int id)
	{
		String msg=service.updateemprecord(e, id);
		return ResponseEntity.ok(msg);
	}
	
//	DELETE EMPLOYEE RECORD
	@DeleteMapping("deleteemprecord/{id}")
	public ResponseEntity<String> deleteemprecord(@PathVariable int id)
	{
		String msg=service.deleteemprecord(id);
		return ResponseEntity.ok(msg);
	}
	
//  GET ALL EMPLOYEE RECORD
	@GetMapping("getallemprecord")
	public ResponseEntity<List<Employee>> getallemprecord()
	{
		List<Employee> list=service.getallemprecord();
		return ResponseEntity.ok(list);
	}
	
//  GET PARTICULER EMPLOYEE RECORD
	@GetMapping("getparticuleremprecord/{id}")
	public ResponseEntity<Employee> getparticuleremprecord(@PathVariable int id)
	{
		Employee emp=service.getparticuleremprecord(id);
		return ResponseEntity.ok(emp);
	}
	
//	EMPLOYEE LOGIN
	@PostMapping("login")
	public ResponseEntity<Map> login(@RequestBody Employee e)
	{
		Map map=service.login(e);
		return ResponseEntity.ok(map);
	}
	
	
	
	
//	GET EMPLOYEE WHOSE SALARY RANGE IS 50000 TO 100000
		@GetMapping("getsalary")
		public ResponseEntity<List<Employee>> getsalary(@RequestParam double startsal,@RequestParam double endsal)
		{
			List<Employee> list=service.getsalary(startsal,endsal);
//			String msg="getsalary api called";
			return ResponseEntity.ok(list);
		}
		
		
		
		
//		GET EMPLOYEE WHOSE SALARY RANGE IS 50000 TO 100000 by using @pathvariable	
		@GetMapping("rangesalary/{startsal}/{endsal}")
		public ResponseEntity<List<Employee>> rangesalary(@PathVariable double startsal,@PathVariable double endsal)
		{
			List<Employee> list=service.rangesalary(startsal,endsal);
//			String msg="getsalary api called";
			return ResponseEntity.ok(list);
		}
		
		
		
//		GET EMPLOYEE WHOSE STATUS IS EITHER ACTIVR/INACTIVE/SUSPEND
		@GetMapping("getstatus/{id}")
		public ResponseEntity<List> getstatus(@PathVariable String status)
		{
//			String msg="getstatus api called";
            List<Employee> list=service.getstatus(status);
			return ResponseEntity.ok(list);
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
//		**************************************************************************
//		UPDATE PARTICULER EMPLOYEE STATUS 
		@GetMapping("getmap/{id}")
		public String getmap(@PathVariable int id)
		{
			String msg=service.getmap(id);
			return msg;
		}
}
