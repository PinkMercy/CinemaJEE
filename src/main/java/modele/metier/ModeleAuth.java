package modele.metier;


import Dao.DaoAuth;
import modele.entities.User;
import modele.entities.User;

public class ModeleAuth {
    DaoAuth daoauth=new DaoAuth();
    public boolean auth(String email,String password){
        return daoauth.auth(email,password)!=null;
    }
}