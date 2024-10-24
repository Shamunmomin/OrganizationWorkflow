package com.tka.OrganizationWorkflow.dao;

import java.util.List;
import java.util.Map;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.tka.OrganizationWorkflow.entity.Country;
import com.tka.OrganizationWorkflow.entity.Employee;

@Repository
public class MainDao {

	@Autowired
	SessionFactory factory;

	
//	Add COUNTRY RECORD
	public String addcountry(Country c) {

		Session session=null;
		Transaction tx=null;
		String msg=null;

		try {
			session=factory.openSession();
			tx=session.beginTransaction();
			session.persist(c);

			tx.commit();
			msg="Country record added successfully..";

		}
		catch(Exception e)
		{
			if(tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		}
		finally {
			if(session != null) {
				session.close();
			}
		}
		return msg;
	}

	//	UPDATE COUNTRY RECORD
	public String updaterecord(Country c, int id) {

		Session session=null;
		Transaction tx=null;
		String msg=null;

		try {
			session=factory.openSession();
			tx=session.beginTransaction();

			Country country=session.get(Country.class, id);
			country.setCname(c.getCname());
			session.merge(country);

			tx.commit();
			msg="Country record update successfully..";

		} catch (Exception e) {

			if(tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		}
		finally {
			if(session != null) {
				session.close();
			}
		}

		return msg;

	}

//	DELETE COUNTRY RECORD
	public String deleterecord(int id) {
		
		Session session=null;
		Transaction tx=null;
		String msg=null;
		
		try {
			session= factory.openSession();
			tx =session.beginTransaction();
			
			Country country =session.get(Country.class, id);
			session.remove(country);
			
			tx.commit();
			msg="Country record delete successfully..";
			
		} catch (Exception e) {
			if(tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		}
		finally {
			if(session != null) {
				session.close();
			}
		}
		
		return msg;
	}

	
//	GET PARTICULER RECORD FROM COUNTRY 
	public Country getparticulerrecord(int id) {
	
		Session session=null;
		Transaction tx=null;
		List<Country> list=null;
		Country country=null;
		try {
			session=factory.openSession();
			tx=session.beginTransaction();

			String q="from Country where id=:myid";
			Query<Country> query=session.createQuery(q,Country.class);
			query.setParameter("myid", id);
			country=query.uniqueResult();
			tx.commit();
			
		} catch (Exception e) {
			if(tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		}
		finally {
			if(session != null) {
				session.close();
			}
		}
		
		return country;
	}

	
//	GET ALL RECORDS FROM COUNTRY
	public List<Country> getallrecord() {
		Session session=null;
		Transaction tx=null;
		List<Country> list=null;
		String q="from Country";
		
		try {
			session= factory.openSession();
			tx=session.beginTransaction();
			
			Query<Country> query= session.createQuery(q, Country.class);
			list=query.list();
			
			tx.commit();
			
		} catch (Exception e) {
			if(tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		}
		finally {
			if(session != null) {
				session.close();
			}
		}
		return list;
	}

	
//	ADD EMPLOYEE RECORD
	public String addrecord(Employee e) {
		
		Session session=null;
		Transaction tx=null;
		String msg=null;
		
		try {
			session=factory.openSession();
			tx=session.beginTransaction();
			session.persist(e);
			
			tx.commit();
			msg="employee record added successfully..";
			
		} catch (Exception e2) {
			// TODO: handle exception
			if(tx != null) {
				tx.rollback();
			}
			e2.printStackTrace();
		}
		finally {
			if(session != null) {
				session.close();
			}
		}
		
		return msg;
	}

	
//	UPDATE EMPLOYEE RECORD
	public String updateemprecord(Employee e, int id) {
		
		Session session= null;
		Transaction tx=null;
		String msg=null;
		
		try {
			session=factory.openSession();
			tx=session.beginTransaction();
			
		Employee ee=session.get(Employee.class, id);
		ee.setName(e.getName());
		ee.setMobileno(e.getMobileno());
		ee.setEmailid(e.getEmailid());
		ee.setCreatedBy(e.getCreatedBy());
		ee.setCreatedDate(e.getCreatedDate());
		ee.setUpdatedBy(e.getUpdatedBy());
		ee.setUpdatedDate(e.getUpdatedDate());
		ee.setStatus(e.getStatus());
		ee.setDepartment(e.getDepartment());
		ee.setSalary(e.getSalary());
	    ee.setCountry(e.getCountry());
	    
	    session.merge(ee);
	    tx.commit();
			
		msg="employee record updated successfully..";
	    
		} catch (Exception e2) {
			if(tx !=null) {
				tx.rollback();
			}
			e2.printStackTrace();
		}finally {
			if(session != null) {
				session.close();
			}
		}
		
		return msg;
	}

	
//	DELETE EMPLOYEE RECORD
	public String deleteemprecord(int id) {

		Session session=null;
		Transaction tx=null;
		String msg=null;
		
		try {
			session=factory.openSession();
			tx=session.beginTransaction();
			
			Employee ee=session.get(Employee.class, id);
			session.remove(ee);
			
			tx.commit();
			msg="employee record is delete successfully...";
			
		} catch (Exception e) {
           if(tx !=null) {
        	   tx.rollback();
           }
           e.printStackTrace();
		}
		finally {
			if(session !=null) {
				session.close();
			}
		}
		
		return msg;
	}

	
//	GET ALL EMPLOYEE RECORD
	public List<Employee> getallemprecord() {
		
		Session session=null;
		Transaction tx=null;
		List<Employee> list=null;
		
		try {
			session=factory.openSession();
			tx=session.beginTransaction();
			
			String q="from Employee";
			Query<Employee> query=session.createQuery(q,Employee.class);
			list=query.list();
			
			tx.commit();
			
		} catch (Exception e) {
			if(tx !=null) {
				tx.rollback();
			}
			e.printStackTrace();
		}finally {
			if(session !=null) {
				session.close();
			}
		}
		
		return list;
	}

	
//	GET PARTICULER EMPLOYEE RECORD
	public Employee getparticuleremprecord(int id) {
		Session session=null;
		Transaction tx=null;
		Employee emp=null;
		
		try {
			session=factory.openSession();
			tx=session.beginTransaction();
			
			emp=session.get(Employee.class, id);
			tx.commit();
			
		} catch (Exception e) {
			if(tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		}finally {
			if(session !=null) {
				session.close();
			}
		}
		
		return emp;
	}

//	EMPLOYEE LOGIN
	public Employee login(Employee e) {
		Session session=null;
		Transaction tx=null;
		Employee employee=null;
		
		try {
			session=factory.openSession();
			tx=session.beginTransaction();
			
			String q="from Employee where emailid=:myemail and mobileno=:myno";
			 Query<Employee> query=session.createQuery(q,Employee.class);
			 query.setParameter("myemail",e.getEmailid());
			 query.setParameter("myno", e.getMobileno());
			employee= query.uniqueResult();
			tx.commit();
			
		} catch (Exception e2) {
			if(tx!=null) {
				tx.rollback();
			}
			e2.printStackTrace();
		} finally {
			if(session !=null) {
				session.close();
			}
		}
		return employee;
	}

	
	
//	GET EMPLOYEE SALARY 50000-100000
	public List<Employee> getsalary(double startsal,double endsal) {
		Session session=null;
		Transaction tx=null;
		List<Employee> list=null;
		String q="from Employee where salary between :startsal and :endsal";
		
		try {
			session=factory.openSession();
			tx=session.beginTransaction();
			
			Query<Employee> query=session.createQuery(q,Employee.class);
			query.setParameter("startsal", startsal);
			query.setParameter("endsal", endsal);
			list=query.list();
			
			tx.commit();
			
		} catch (Exception e) {
			if(tx !=null) {
				tx.rollback();
			}
			e.printStackTrace();
		}finally {
			if(session !=null) {
				session.close();
			}
		}
		
		return list;
	}

	

	
	
//	GET EMPLOYEE WHOSE SALARY RANGE IS 50000 TO 100000 by using @pathvariable	

	public List<Employee> rangesalary(double startsal,double endsal) {
		Session session=null;
		Transaction tx=null;
		List<Employee> list=null;
		String q="from Employee where salary between :startsal and :endsal";
		
		try {
			session=factory.openSession();
			tx=session.beginTransaction();
			
			Query<Employee> query=session.createQuery(q,Employee.class);
			query.setParameter("startsal", startsal);
			query.setParameter("endsal", endsal);
			list=query.list();
			
			tx.commit();
			
		} catch (Exception e) {
			if(tx !=null) {
				tx.rollback();
			}
			e.printStackTrace();
		}finally {
			if(session !=null) {
				session.close();
			}
		}
		
		return list;
	}

	
	
	
//	GET EMPLOYEE WHOSE STATUS IS EITHER ACTIVR/INACTIVE/SUSPEND
	public List<Employee> getstatus(String status) {
		Session session=null;
		Transaction tx=null;
		List<Employee> list=null;
		String q="from Employee where status=:status";
		
		try {
			session=factory.openSession();
			tx=session.beginTransaction();
			
			Query<Employee> query =session.createQuery(q,Employee.class);
			query.setParameter("status", status);
			list=query.getResultList();
			
			tx.commit();
			
		} catch (Exception e) {
			if(tx !=null) {
				tx.rollback();
			}
			e.printStackTrace();
		}finally {
			if(session !=null) {
				session.close();
			}
		}
		
		return list;
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
//	*********************************************************************************
//	not work
//	UPDATE PARTICULER EMPLOYEE STATUS
	public String getmap(int id) {
		Session session=null;
		Transaction tx=null;
		String msg=null;
		
		try {
			session=factory.openSession();
			tx=session.beginTransaction();
			
			Employee emp=session.get(Employee.class, id);
			System.out.println(emp);
			System.out.println(emp.getStatus());
			if(emp.getStatus()=="active") {
				emp.setStatus("inactive");
			    session.merge(emp);
			}
			tx.commit();
			
		} catch (Exception e) {
			if(tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		}finally {
			if(session !=null) {
				session.close();
			}
		}
		return msg;
		
	}

	
	
	

		
	

}
