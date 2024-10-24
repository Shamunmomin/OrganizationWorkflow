package com.tka.OrganizationWorkflow.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tka.OrganizationWorkflow.dao.MainDao;
import com.tka.OrganizationWorkflow.entity.Country;
import com.tka.OrganizationWorkflow.entity.Employee;

@Service
public class MainService {

	@Autowired
	MainDao dao;

	public String addcountry(Country c) {

		String msg	=dao.addcountry(c);

		if(Objects.isNull(msg)) {
			msg="country is not added";
		}
		return msg;

	}

	//	UPDATE COUNTRY RECORD
	public String updaterecord(Country c, int id) {

		String msg=dao.updaterecord(c,id);

		if(Objects.isNull(msg)) {
			msg="Country record is not updated";
		}
		return msg;

	}

	//	DELETE COUNTRY RECORD
	public String deleterecord(int id) {

		String msg=dao.deleterecord(id);

		if(Objects.isNull(msg)) {
			msg="Country record is not deleted";
		}
		return msg;
	}


	//	GET PARTICLUER RECORD FROM COUNTRY DATABASE
	public Country getparticulerrecord(int id) {

		Country country= dao.getparticulerrecord(id);

		return country;
	}


	//	GET ALL RECORDS FROM COUNTRY 
	public List<Country> getallrecord() {
		List<Country> list = dao.getallrecord();
		return list;
	}

	public String addrecord(Employee e) {
		String msg=dao.addrecord(e);

		if(Objects.isNull(msg)) {
			msg="Employee record is not added successfully";
		}
		return msg;
	}


	//	UPDATE RECORD EMPLLOYEE
	public String updateemprecord(Employee e, int id) {
		String msg=dao.updateemprecord(e,id);

		if(Objects.isNull(msg)) {
			msg="Employee record is not updated";
		}
		return msg;
	}


	//	DELETE EMPLOYEE RECORD
	public String deleteemprecord(int id) {
		String msg=dao.deleteemprecord(id);

		if(Objects.isNull(msg)) {
			msg="Employee record is not deleted";
		}
		return msg;
	}


	//	GET ALL EMPLOYEE RECORD
	public List<Employee> getallemprecord() {
		List<Employee> list=dao.getallemprecord();

		return list;
	}


	//	GET PARTICULER EMPLOYEE RECORD
	public Employee getparticuleremprecord(int id) {
		Employee emp=dao.getparticuleremprecord(id);
		return emp;
	}


	//	EMPLOYEE LOGIN
	public Map login(Employee e) {
		Employee obj=dao.login(e);
		Map map= new HashMap() ;

		if(Objects.isNull(obj)) {
			map.put("msg", "Invaluid user");
			map.put("user", obj);  
		}else {
			map.put("msg", "Valid user");
			map.put("user", obj);
		}

		return map;

	}


	//	GET EMPLOYEE SALARY 50000-100000
	public List<Employee> getsalary(double startsal, double endsal) {
		List<Employee> list= dao.getsalary(startsal,endsal);
		return list;
	}




	//	GET EMPLOYEE WHOSE SALARY RANGE IS 50000 TO 100000 by using @pathvariable	

	public List<Employee> rangesalary(double startsal, double endsal) {
		List<Employee> list= dao.rangesalary(startsal,endsal);
		return list;
	}



	//	GET EMPLOYEE WHOSE STATUS IS EITHER ACTIVR/INACTIVE/SUSPEND
	public List<Employee> getstatus(String status) {

		List<Employee> list=dao.getstatus(status);

		return list;
	}



	
	
	
	
	
	
	
	
	
//	*********************************************************************************
	//	UPDATE PARTICULER EMPLOYEE STATUS
	public String getmap(int id) {
		String msg= dao.getmap(id);

		return msg;
	}







}
