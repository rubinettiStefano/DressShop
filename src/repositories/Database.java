package repositories;

import java.sql.Connection;

import com.generation.library.List;

import entities.Brand;
import entities.Dress;

public class Database 
{
    //sommerà tutti i metodi delle singole repository
    //private Connection con;
    private BrandRepository bRepo;
    private DressRepository dRepo;

    public Database(Connection con)
    {
        this.bRepo = new BrandRepository(con);
        this.dRepo = new DressRepository(con);
    }

    public Brand readBrand(int id) throws Exception
    {
        Brand res = bRepo.readOne(id);
        List<Dress> children = dRepo.readDressWithFK(id);

        //collego padre a figli
        res.setDresses(children);

        //collego ogni figlio al padre
        for(Dress d : children)
            d.setBrand(res);

        return res;
    }

    public Dress readDress(int id)throws Exception
    {
        Dress res = dRepo.readOne(id);
        Brand father = readBrand(res.getBrand_id());

        //collego padre a figlio
        father.addDress(res);

        //collego figlio a padre
        res.setBrand(father);

        return res;
    }

    public List<Brand> readAllBrands() throws Exception
    {
        List<Brand> res = bRepo.readAll();

        //ma il collegamento lo facciamo per ogni brand dentro la lista che abbiamo letto
        for(Brand b:res)
        {
            List<Dress> children = dRepo.readDressWithFK(b.getId());
            b.setDresses(children);

            //collego ogni figlio al padre
            for(Dress d : children)
                d.setBrand(b);
        }
        return res;
    }

     public  List<Dress> readAllDresses()throws Exception
    {
        List<Dress> res = dRepo.readAll();

        for(Dress d: res)
        {
            Brand father = readBrand(d.getBrand_id());

            //collego padre a figlio
            father.addDress(d);

            //collego figlio a padre
            d.setBrand(father);
        }
        return res;
    }

    //metodo per leggere un dress
    //metodo per leggere un brand
    //metodo per leggere tutti i dress
    //metodo per leggere tutti i brand
    //metodo per inserire un dress
    //metodo per inserire un brand
    //metodo per modificare un dress
    //metodo per modificare un brand
    //metodo per cancellare un dress
    //metodo per cancellare un brand
    public void insertDress(Dress d) throws Exception
    {
        dRepo.insert(d);
    }

    public void insertBrand(Brand b) throws Exception
    {
        bRepo.insert(b);
    }

    public void  updateBrand(Brand b) throws Exception
    {
        bRepo.update(b);
    }

    public void  updateDress(Dress d) throws Exception
    {
        dRepo.update(d);
    }

    public void deleteDress(Dress d) throws Exception
    {
        dRepo.delete(d);
    }

    public void deleteBrand(Brand b) throws Exception
    {
        bRepo.delete(b);
    }
}
