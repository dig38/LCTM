package modelcontroller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import model.Product;
import mytools.DBUtil;

public class ProductMC {
	public static List<Product> getAllProducts(){
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		List<Product> ProductList = null;
		String queryString = "SELECT P FROM Product P";
		TypedQuery<Product> typeQue = em.createQuery(queryString, Product.class);
		try{
			ProductList = typeQue.getResultList();
			if(ProductList == null || ProductList.isEmpty())
				ProductList = null;
			return ProductList;
		}finally{
			em.close();
		}
	}//END getAll
	
	public static Product getOneProduct(String proId){
		EntityManager em = DBUtil.getEmFactory().createEntityManager();

		Product Product = null;
		String queryString = "SELECT P FROM Product P WHERE P.productId = :proId ";
		TypedQuery<Product> typeQue = em.createQuery(queryString, Product.class);
				
		typeQue.setParameter("proId", proId);
		
		try{
			Product = typeQue.getSingleResult();
			return Product;
		} catch (Exception e)
		{
			System.out.println(e);
			return null;
		}finally{
			em.close();
		}
	}//END getOne
	
}//END clas productMC



