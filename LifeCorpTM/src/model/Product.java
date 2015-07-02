package model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the PRODUCTS database table.
 * 
 */
@Entity
@Table(name="PRODUCTS", schema="LIFECORP")
@NamedQuery(name="Product.findAll", query="SELECT p FROM Product p")
public class Product implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="PRODUCT_ID")
	private String productId;

	@Column(name="PRODUCT_NAME")
	private String productName;

	@Column(name="PRODUCT_UNITPRICE")
	private BigDecimal productUnitprice;

	public Product() {
	}

	public String getProductId() {
		return this.productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return this.productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public BigDecimal getProductUnitprice() {
		return this.productUnitprice;
	}

	public void setProductUnitprice(BigDecimal productUnitprice) {
		this.productUnitprice = productUnitprice;
	}

}