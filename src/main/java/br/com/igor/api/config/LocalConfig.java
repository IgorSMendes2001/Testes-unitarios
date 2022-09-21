package br.com.igor.api.config;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import br.com.igor.api.domain.User;
import br.com.igor.api.repository.UserRepository;

@Configuration
@Profile("local")
public class LocalConfig {
    @Autowired
    private UserRepository repository;
    @Bean
    public void startDB(){
        User u1 = new User(null, "Igor","igor@gmail.com","1234");
        User u2 = new User(null, "Layo","layo@gmail.com","1234");
        repository.saveAll(List.of(u1,u2));

    }   
}
