package repositories;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import com.generation.library.List;

import entities.Brand;

public class BrandRepository 
{
    private Connection con;

    public BrandRepository(Connection con)
    {
        this.con = con;
    }

    //5 metodi di CRUD
    //2 di lettura (uno per lettura singola (tramite id) uno per leggerli tutti)

    public List<Brand> readAll() throws Exception
    {
        Statement s = con.createStatement();
        String q  = "SELECT * FROM brand";
        ResultSet rs = s.executeQuery(q);

        List<Brand> res = new List<Brand>();
        while(rs.next())
            res.add(_rsToBrand(rs));

        s.close();
        return res;
    }

    public Brand readOne(int id) throws Exception
    {
        Statement s = con.createStatement();
        String q  = "SELECT * FROM brand WHERE id="+id;
        ResultSet rs = s.executeQuery(q);

        Brand res = null;
        if(rs.next())
            res=_rsToBrand(rs);

        s.close();
        return res;
    }

    public void insert(Brand b) throws Exception
    {
        Statement s = con.createStatement(); 
        String q  = b.toInsertQuery();
        s.execute(q);
        s.close();
    }

    public void update(Brand b) throws Exception
    {
        Statement s = con.createStatement(); 
        String q  = b.toUpdateQuery();
        s.execute(q);
        s.close();
    }

    public void delete(Brand b) throws Exception
    {
        Statement s = con.createStatement(); 
        String q  = b.toDeleteQuery();
        s.execute(q);
        s.close();
    }

    private Brand _rsToBrand(ResultSet rs) throws Exception
    {
        Brand res = new Brand();
        res.setId(rs.getInt("id"));
        res.setName(rs.getString("name"));
        res.setAnnual_revenue(rs.getInt("annual_revenue"));
        res.setAddress(rs.getString("address"));
        res.setFounded_in(rs.getInt("founded_id"));
        return res;
    }

}
