package repositories;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import com.generation.library.List;

import entities.Dress;

public class DressRepository 
{
     private Connection con;

    public DressRepository(Connection con)
    {
        this.con = con;
    }

    //5 metodi di CRUD
    //2 di lettura (uno per lettura singola (tramite id) uno per leggerli tutti)

    public List<Dress> readAll() throws Exception
    {
        Statement s = con.createStatement();
        String q  = "SELECT * FROM dress";
        ResultSet rs = s.executeQuery(q);

        List<Dress> res = new List<Dress>();
        while(rs.next())
            res.add(_rsToDress(rs));

        s.close();
        return res;
    }

    public List<Dress> readDressWithFK(int fk) throws Exception
    {
        Statement s = con.createStatement();
        String q  = "SELECT * FROM dress WHERE brand_id="+fk;
        ResultSet rs = s.executeQuery(q);

        List<Dress> res = new List<Dress>();
        while(rs.next())
            res.add(_rsToDress(rs));

        s.close();
        return res;
    }

    public Dress readOne(int id) throws Exception
    {
        Statement s = con.createStatement();
        String q  = "SELECT * FROM dress WHERE id="+id;
        ResultSet rs = s.executeQuery(q);

        Dress res = null;
        if(rs.next())
            res=_rsToDress(rs);

        s.close();
        return res;
    }

    public void insert(Dress b) throws Exception
    {
        Statement s = con.createStatement(); 
        String q  = b.toInsertQuery();
        s.execute(q);
        s.close();
    }

    public void update(Dress b) throws Exception
    {
        Statement s = con.createStatement(); 
        String q  = b.toUpdateQuery();
        s.execute(q);
    }

    public void delete(Dress b) throws Exception
    {
        Statement s = con.createStatement(); 
        String q  = b.toDeleteQuery();
        s.execute(q);
        s.close();
    }

    private Dress _rsToDress(ResultSet rs) throws Exception
    {
        Dress res = new Dress();
        res.setId(rs.getInt("id"));
        res.setBrand_id(rs.getInt("brand_id"));
        res.setName(rs.getString("name"));
        res.setType(rs.getString("type"));
        res.setPrice(rs.getInt("price"));
        return res;
    }
}
