package br.com.igor.api.service.impl;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.igor.api.domain.User;
import br.com.igor.api.repository.UserRepository;
import br.com.igor.api.resources.exceptions.ObjectNotFoundException;
import br.com.igor.api.service.UserService;
@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository repository;

    @Override
    public User findById(Integer id) {
    Optional<User> obj =repository.findById(id);
        return obj.orElseThrow(()-> new ObjectNotFoundException("Objeto não encontrado!"));
    }
    
}
