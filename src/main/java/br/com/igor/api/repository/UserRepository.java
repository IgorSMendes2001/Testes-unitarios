package br.com.igor.api.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.igor.api.domain.User;

@Repository
public interface UserRepository extends JpaRepository<User,Integer>{

    Optional<User> findByEmail(String email);
    
}
