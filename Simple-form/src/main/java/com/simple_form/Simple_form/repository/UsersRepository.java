package com.simple_form.Simple_form.repository;

import com.simple_form.Simple_form.model.UsersModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UsersRepository extends JpaRepository<UsersModel, Integer> {

      Optional<UsersModel> findByLoginAndPassword(String login, String password);


}
