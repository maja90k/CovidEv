package cl.sema.covidev.dao;

import java.util.ArrayList;
import java.util.List;

import cl.sema.covidev.dto.User;

public class UserDAOLista implements UserDAO {

    private List<User> users = new ArrayList<>();

    private static UserDAOLista instancia;

    public static UserDAOLista getInstance(){
        if(instancia == null){
            instancia = new UserDAOLista();
        }
        return instancia;
    }

    private UserDAOLista(){
        User us = new User();
        //atributos
    }

    @Override
    public List<User> getAll(){
        return null;
    }
    @Override
    public User save(User u){
        users.add(u);
        return u;
    }

}
