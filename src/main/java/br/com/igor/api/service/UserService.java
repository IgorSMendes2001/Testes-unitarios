package br.com.igor.api.service;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.igor.api.domain.User;

@Service
public interface UserService {
    User findById(Integer id);
    List<User>findAll();
}
