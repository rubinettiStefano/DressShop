package entities;
import static util.DbUtil.quota;

import com.generation.library.List;

public class Brand 
{
    private int id;
    private String name;
    private int annual_revenue;
    private String address;
    private int founded_in;

    private List<Dress> dresses;
    public List<Dress> getDresses() {
        return dresses;
    }
    public void setDresses(List<Dress> dresses) {
        this.dresses = dresses;
    }
    public void addDress(Dress d)
    {
        this.dresses.add(d);
    }


    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getAnnual_revenue() {
        return annual_revenue;
    }
    public void setAnnual_revenue(int annual_revenue) {
        this.annual_revenue = annual_revenue;
    }
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public int getFounded_in() {
        return founded_in;
    }
    public void setFounded_in(int founded_in) {
        this.founded_in = founded_in;
    }

    
    

     //INSERT INTO brand (name, annual_revenue, address, founded_in) VALUES
    //('Nike', 400000000, '123 Shoe Street, Beaverton, OR', 1964),
    public String toInsertQuery()
    {
        return  "INSERT INTO brand (name, annual_revenue, address, founded_in) VALUES ("
                +quota(name)+","
                +annual_revenue+","
                +quota(address)+","
                +founded_in
                +")";
    }

    //UPDATE brand set
    //name='Nike',
    //annual_revenue=400000000,
    //address='123 Shoe Street, Beaverton, OR'
    //founded_in=1964
    //WHERE id=1
    public String toUpdateQuery()
    {
        return  "UPDATE brand set "
                +"name="+quota(name)+","
                +"annual_revenue="+annual_revenue+","
                +"address="+quota(address)+","
                +"founded_in="+founded_in
                +" WHERE id="+id;
    }
   
    public String toDeleteQuery()
    {
        return "DELETE FROM brand WHERE id="+id;
    }

    public String toString() {
        return "Brand [id=" + id + ", name=" + name + ", annual_revenue=" + annual_revenue + ", address=" + address
                + ", founded_in=" + founded_in + "]";
    }
   
    
}
