package br.com.igor.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.igor.api.domain.User;

@Repository
public interface UserRepository extends JpaRepository<User,Integer>{
    
}
