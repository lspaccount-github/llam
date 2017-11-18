package com.mall.pojo.order;

import java.io.Serializable;

import com.mall.pojo.product.Product;

/**
 * 
 * @ClassName: OrderConfirm
 * @Description: 保存订单临时对象
 * @author ShenWei 
 * @date 2017年11月18日 下午2:17:41
 *
 */
public class OrderConfirm implements Serializable {
	/**
	 * 商品id
	 */
   private String productId;
   
   /**
    * 商品数量
    */
   private int num;

   /**
    * 商品价格
    */
   private Double price;
   
   /**
    * 商品对象
    */
   private Product product;
   
public String getProductId() {
	return productId;
}

public void setProductId(String productId) {
	this.productId = productId;
}

public int getNum() {
	return num;
}

public void setNum(int num) {
	this.num = num;
}

public Double getPrice() {
	return price;
}

public void setPrice(Double price) {
	this.price = price;
}

public Product getProduct() {
	return product;
}

public void setProduct(Product product) {
	this.product = product;
}
   
}