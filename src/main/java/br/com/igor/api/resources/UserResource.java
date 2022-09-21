package br.com.igor.api.resources;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.igor.api.domain.dto.UserDTO;
import br.com.igor.api.service.UserService;

@RestController
@RequestMapping(value = "/user")
public class UserResource {
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private UserService service;

    @GetMapping
    public ResponseEntity<List<UserDTO>>findAll(){
        return ResponseEntity.ok()
                .body(service.findAll()
                    .stream().map(x->modelMapper.map(x, UserDTO.class)).collect(Collectors.toList()));
    }


    @GetMapping(value = "/{id}")
    public ResponseEntity<UserDTO> findById(@PathVariable Integer id){
        return ResponseEntity.ok().body(modelMapper.map(service.findById(id), UserDTO.class));
    }
    @PostMapping
    public ResponseEntity<UserDTO>findById(@RequestBody UserDTO objDto){
        URI uri= ServletUriComponentsBuilder
        .fromCurrentRequest().path("/{id}").buildAndExpand( service.save(objDto).getId()).toUri();
        return ResponseEntity.created(uri).build();
    }
}
