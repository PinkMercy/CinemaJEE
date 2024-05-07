package Dao;

import modele.entities.User;
import modele.entities.User;

public interface IDaoAuth {
    public User auth(String email,String password);
}
