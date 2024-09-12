package com.simple_form.Simple_form.service;


import com.simple_form.Simple_form.model.UsersModel;
import com.simple_form.Simple_form.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsersService {

    //Autowire UsersRepository through constructor
   private final UsersRepository usersRepository;

   public UsersService(UsersRepository usersRepository) {
       this.usersRepository = usersRepository;
   }

    public UsersModel registerUser(String login, String password, String email) {
        if(login == null || password == null) { //This makes login and password compulsory parameters
            return null;

        } else {
            UsersModel usersModel = new UsersModel();
            usersModel.setLogin(login);
            usersModel.setPassword(password);
            usersModel.setEmail(email);
            return usersRepository.save(usersModel);
        }

    }
    public UsersModel authenticate(String login, String password) {
       return usersRepository.findByLoginAndPassword(login, password).orElse(null);

    }
}
