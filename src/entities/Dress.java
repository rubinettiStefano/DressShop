package entities;

import static util.DbUtil.quota;

public class Dress 
{
    private int id;
    private int brand_id;
    private String name,type;
    private double price;

    private Brand brand;

    public Brand getBrand() {
        return brand;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
        this.brand_id = brand.getId();
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public int getBrand_id() {
        return brand_id;
    }
    public void setBrand_id(int brand_id) {
        this.brand_id = brand_id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }
    public double getPrice() {
        return price;
    }
    public void setPrice(double price) {
        this.price = price;
    }

    public String toInsertQuery()
    {
        return  "INSERT INTO dress (brand_id, name, type, price) VALUES(" 
                +brand_id+","
                +quota(name)+","
                +quota(type)+","
                +price
            	+")";
    }

    public String toUpdateQuery()
    {
        return  "Update dress set " 
                +"brand_id="+brand_id+","
                +"name="+quota(name)+","
                +"type="+quota(type)+","
                +"price="+price
            	+" WHERE id="+id;
    }
    
    public String toDeleteQuery()
    {
        return "DELETE FROM dress WHERE id="+id;
    }

    public String toString() {
        return "Dress [id=" + id + ", brand_id=" + brand_id + ", name=" + name + ", type=" + type + ", price=" + price
                + "]";
    }
    

    
}
