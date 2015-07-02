package modelcontroller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import mytools.DBUtil;
import model.Customer;

public class CustomerMC {
    public CustomerMC() {
        super();
        // TODO Auto-generated constructor stub
    }
	
	public static void insert(Customer cust){
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		EntityTransaction trans = em.getTransaction();	
		try{
			trans.begin();
			em.persist(cust);
			trans.commit();
		}catch(Exception e){
			System.out.println(e);
			trans.rollback();
		}finally{
			em.close();
		}		
	}//END insert
	public static void update(Customer cust){
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		EntityTransaction trans = em.getTransaction();
		try{
			trans.begin();
			em.merge(cust);
			trans.commit();
		}catch(Exception e){
			System.out.println(e);
			trans.rollback();
		}finally{
			em.close();
		}		
	}//END update
	public static void delete(Customer cust){
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		EntityTransaction trans = em.getTransaction();
		try{
			trans.begin();
			em.remove(em.merge(cust));
			trans.commit();
		}catch(Exception e){
			System.out.println(e);
			trans.rollback();
		}finally{
			em.close();
		}		
	}//END delete
	public static List<Customer> getAllCustomers(){
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		List<Customer> customerList = null;
		String queryString = "SELECT C FROM Customer C";
		TypedQuery<Customer> typeQue = em.createQuery(queryString, Customer.class);
		try{
			customerList = typeQue.getResultList();
			if(customerList == null || customerList.isEmpty())
				customerList = null;
			return customerList;
		}finally{
			em.close();
		}
	}//END getAllCustomers
	public static Customer getOneCustomer(String cusId){
		EntityManager em = DBUtil.getEmFactory().createEntityManager();

		Customer cust = null;
		String queryString = "SELECT C FROM Customer C "
				+ "WHERE C.customerId = :custId ";
		TypedQuery<Customer> typeQue = em.createQuery(queryString, Customer.class);
		typeQue.setParameter("custId", cusId);
		try{
			cust = typeQue.getSingleResult();
			return cust;
		} catch (Exception e)
		{
			System.out.println(e);
			return null;
		}finally{
			em.close();
		}
	}//END getOneCustomer
	
	public static Customer getOneCustomer(String email, String password){
		EntityManager em = DBUtil.getEmFactory().createEntityManager();

		Customer cust = null;
		String queryString = "SELECT C FROM Customer C "
				+ "WHERE C.customerEmail = :cEmail AND C.customerPassword = :cPassword";
		TypedQuery<Customer> typeQue = em.createQuery(queryString, Customer.class);
		typeQue.setParameter("cEmail", email);
		typeQue.setParameter("cPassword", password);
		try{
			cust = typeQue.getSingleResult();
			return cust;
		} catch (Exception e)
		{
			System.out.println(e);
			return null;
		}finally{
			em.close();
		}
	}//END getOneCustomer
	
}//END class CustomerMC