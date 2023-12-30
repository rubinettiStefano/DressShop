package avvio;

import com.generation.library.List;

import entities.Brand;
import repositories.Database;
import util.DbUtil;

public class MainShop 
{
    public static void main(String[] args) throws Exception
    {
        //Ciao sono un cambiamento
        //Cambiamento per maria rosaria
        Database db = new Database(DbUtil.connectToDB("dress_shop"));  
        
        List<Brand> allBrands = db.readAllBrands();
    }
}
