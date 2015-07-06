package modelcontroller;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import model.Order;
import model.Product;
import mytools.DBUtil;

public class OrderMC {
	public static void insert(Order ord){
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		EntityTransaction trans = em.getTransaction();	
		try{
			trans.begin();
			em.persist(ord);
			em.flush();
			System.out.println(ord.getOrderId());
			trans.commit();
		}catch(Exception e){
			System.out.println(e);
			trans.rollback();
		}finally{
			em.close();
		}		
	}//END insert
	public static void insert(Order ord, HttpServletRequest request){
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		EntityTransaction trans = em.getTransaction();
		//HttpSession session = request.getSession();
		try{
			trans.begin();
			em.persist(ord);
			em.flush();
			System.out.println(ord.getOrderId());
			trans.commit();
		}catch(Exception e){
			System.out.println(e);
			trans.rollback();
		}finally{
			//session.setAttribute("ord", ord);
			em.close();
		}		
	}//END insert
	public static void update(Order ord){
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		EntityTransaction trans = em.getTransaction();
		try{
			trans.begin();
			em.merge(ord);
			trans.commit();
		}catch(Exception e){
			System.out.println(e);
			trans.rollback();
		}finally{
			em.close();
		}		
	}//END update
	public static void delete(Order ord){
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		EntityTransaction trans = em.getTransaction();
		try{
			trans.begin();
			em.remove(em.merge(ord));
			trans.commit();
		}catch(Exception e){
			System.out.println(e);
			trans.rollback();
		}finally{
			em.close();
		}		
	}//END delete
	
	public static List<Product> getCustomerProducts(BigDecimal customerId){
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		List<Product> ProductList = null;
		String queryString = "SELECT P, O FROM Product P INNER JOIN P.Order O WHERE P.customerId = :cusId";
		TypedQuery<Product> typeQue = em.createQuery(queryString, Product.class);
		typeQue.setParameter("cusId", customerId);
		try{
			ProductList = typeQue.getResultList();
			if(ProductList == null || ProductList.isEmpty())
				ProductList = null;
			return ProductList;
		}finally{
			em.close();
		}
	}//END getCustomerProducts
}
