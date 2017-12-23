package com.mall.pojo.product;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.mall.pojo.product_classify.ProductClassify;
import com.mall.pojo.product_spec.ProductSpec;

public class Product implements Serializable {
    /**
     * 商品id
     */
    private String productId;

    /**
     * 商品分类
     */
    private Long classifyId;

    /**
     * 商品状态
     */
    private Integer productStatus;

    /**
     * 商品名称
     */
    private String productName;

    /**
     * 商品描述
     */
    private String productRemark;

    /**
     * 图片路径
     */
    private String pictureUrl;

    /**
     * 商品单位
     */
    private String productUnit;

    /**
     * 最小购买数量
     */
    private Long minBuyNum;

    /**
     * 商品规格list
     */
    private List<ProductSpec> productSpecList;
    
    /**
     * 商品分类
     */
    private ProductClassify productClassify;
    
    /**
     * 商品规格
     */
    private ProductSpec productSpec;
    
    private static final long serialVersionUID = 1L;

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId == null ? null : productId.trim();
    }

    public Long getClassifyId() {
        return classifyId;
    }

    public void setClassifyId(Long classifyId) {
        this.classifyId = classifyId;
    }

    public Integer getProductStatus() {
        return productStatus;
    }

    public void setProductStatus(Integer productStatus) {
        this.productStatus = productStatus;
        this.productStatusView = productStatusMap.get(productStatus);
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName == null ? null : productName.trim();
    }

    public String getProductRemark() {
        return productRemark;
    }

    public void setProductRemark(String productRemark) {
        this.productRemark = productRemark == null ? null : productRemark.trim();
    }

    public String getPictureUrl() {
        return pictureUrl;
    }

    public void setPictureUrl(String pictureUrl) {
        this.pictureUrl = pictureUrl == null ? null : pictureUrl.trim();
    }

    public String getProductUnit() {
        return productUnit;
    }

    public void setProductUnit(String productUnit) {
        this.productUnit = productUnit == null ? null : productUnit.trim();
    }

    public Long getMinBuyNum() {
        return minBuyNum;
    }

    public void setMinBuyNum(Long minBuyNum) {
        this.minBuyNum = minBuyNum;
    }
    
    public ProductClassify getProductClassify() {
		return productClassify;
	}

	public void setProductClassify(ProductClassify productClassify) {
		this.productClassify = productClassify;
	}

	public ProductSpec getProductSpec() {
		return productSpec;
	}

	public void setProductSpec(ProductSpec productSpec) {
		this.productSpec = productSpec;
	}

	@Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", productId=").append(productId);
        sb.append(", classifyId=").append(classifyId);
        sb.append(", productStatus=").append(productStatus);
        sb.append(", productName=").append(productName);
        sb.append(", productRemark=").append(productRemark);
        sb.append(", pictureUrl=").append(pictureUrl);
        sb.append(", productUnit=").append(productUnit);
        sb.append(", minBuyNum=").append(minBuyNum);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }

	public List<ProductSpec> getProductSpecList() {
		return productSpecList;
	}

	public void setProductSpecList(List<ProductSpec> productSpecList) {
		this.productSpecList = productSpecList;
	}
    
    private int num;

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}
    
	  //=============常量区==================
  	public static final Integer PRODUCT__STATUS_SHANG_JIA = 1; 
  	public static final Integer PRODUCT_STATUS_XIA_JIA = 2; 
  	
  	public static final String PRODUCT__STATUS_SHANG_JIA_VIEW = "已上架";
  	public static final String PRODUCT_STATUS_XIA_JIA_VIEW = "已下架"; 
  	
  	public static final Map<Integer, String> productStatusMap = new HashMap<Integer, String>();
  	static{
  		productStatusMap.put(PRODUCT__STATUS_SHANG_JIA, PRODUCT__STATUS_SHANG_JIA_VIEW);
  		productStatusMap.put(PRODUCT_STATUS_XIA_JIA, PRODUCT_STATUS_XIA_JIA_VIEW);
  	}
  	/**
	 * 状态显示值
	 */
	private String productStatusView;

	public String getProductStatusView() {
		return productStatusView;
	}

	
	
}