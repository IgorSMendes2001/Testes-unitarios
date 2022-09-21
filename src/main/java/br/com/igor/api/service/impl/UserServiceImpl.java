package br.com.igor.api.service.impl;


import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.igor.api.domain.User;
import br.com.igor.api.domain.dto.UserDTO;
import br.com.igor.api.repository.UserRepository;
import br.com.igor.api.resources.exceptions.DataIntegrityViolationException;
import br.com.igor.api.resources.exceptions.ObjectNotFoundException;
import br.com.igor.api.service.UserService;
@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository repository;
    @Autowired
    private ModelMapper mapper;

    @Override
    public User findById(Integer id) {
    Optional<User> obj =repository.findById(id);
        return obj.orElseThrow(()-> new ObjectNotFoundException("Objeto não encontrado!"));
    }
    @Override
    public List<User>findAll(){
        return repository.findAll();
    }
    @Override
    public User save(UserDTO objDto){
        findByEmail(objDto);
        return repository.save(mapper.map(objDto, User.class));
    }
    private void findByEmail(UserDTO objDto){
        Optional<User> user=repository.findByEmail(objDto.getEmail());
        if(user.isPresent() && !user.get().getId().equals(objDto.getId())){
            throw new DataIntegrityViolationException("Email já cadastrado no sistema!");
        }
    }
    @Override
    public User update(UserDTO objDto) {
        findByEmail(objDto);
        return repository.save(mapper.map(objDto, User.class));
    }

}
