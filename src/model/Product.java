
package model;

import java.util.Date;
import java.util.Objects;

/**
 *
 * @author admin
 */
public class Product implements Comparable<Product>{
  
    private String productID;
    private String productName;
    private double unitPrice;
    private int quantity;
    private double version;
    private String productManufacturingDate;

    // Constructors
    public Product(String productID,String productName,double unitPrice,int quantity,double version,String productManufacturingDate){
        this.productID = productID;
        this.productName = productName;
        this.unitPrice = unitPrice;
        this.quantity = quantity;
        this.version = version;
        this.productManufacturingDate = productManufacturingDate;
    }
    
    public Product(){
        
    }
   
    // Getters and Setters
    public String getProductID() {
        return productID;
    }

    public void setProductID(String productID) {
        this.productID = productID;
    }

    public String getproductName() {
        return productName;
    }

    public void setproductName(String Name) {
        this.productName = productName;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getVersion() {
        return version;
    }

    public void setVersion(double version) {
        this.version = version;
    }

    public String getProductManufacturingDate() {
        return productManufacturingDate;
    }

    public void setProductManufacturingDate(String productManufacturingDate) {
        this.productManufacturingDate = productManufacturingDate;
    }
    
     @Override
    public String toString() {
       return "ID="+productID+", Name="+productName+", UnitPrice="+unitPrice
               +", Quantity="+quantity+", Version="+version+", ProductManufacturingDate="+productManufacturingDate;
    }
    //Id=4, Name=Software, UnitPrice=2.0, Quantity=2, Version=2, ProductManufacturingDate=01/01/2020
    @Override
    public boolean equals(Object obj) {
        if(this == obj) return true;
        if(obj == null) return false;
        if(getClass()!=obj.getClass()) return false;
        Product that = (Product) obj;
        return (this.unitPrice==(that.unitPrice) 
                && Objects.equals(this.productID, that.productID) && this.productName.equals(that.productName) && Objects.equals(this.quantity, that.quantity)
                && Objects.equals(this.version, that.version) && this.productManufacturingDate.equals(that.productManufacturingDate));
    }
    
    @Override
    public int compareTo(Product T){
        return this.productID.compareTo(T.productID);
    }

}

