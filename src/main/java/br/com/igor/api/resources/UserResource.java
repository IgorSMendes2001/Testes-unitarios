package br.com.igor.api.resources;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.igor.api.domain.dto.UserDTO;
import br.com.igor.api.service.UserService;

@RestController
@RequestMapping(value = "/user")
public class UserResource {
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private UserService service;
    @GetMapping(value = "/{id}")
    public ResponseEntity<UserDTO> findById(@PathVariable Integer id){
        return ResponseEntity.ok().body(modelMapper.map(service.findById(id), UserDTO.class));
    }
}
