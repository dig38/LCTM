package modelcontroller;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import model.Order;
import mytools.DBUtil;

public class OrderMC {
	public static void insert(Order ord){
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		EntityTransaction trans = em.getTransaction();	
		try{
			trans.begin();
			em.persist(ord);
			trans.commit();
		}catch(Exception e){
			System.out.println(e);
			trans.rollback();
		}finally{
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
}
