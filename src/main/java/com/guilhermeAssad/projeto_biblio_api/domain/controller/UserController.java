package com.guilhermeAssad.projeto_biblio_api.domain.controller;

import com.guilhermeAssad.projeto_biblio_api.domain.service.UserService;
import com.guilhermeAssad.projeto_biblio_api.dto.request.UserRequest;
import com.guilhermeAssad.projeto_biblio_api.dto.response.UserResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public UserResponse create(@RequestBody UserRequest request){
        return userService.create(request);
    }


    @GetMapping("/{id}")
    public UserResponse getById(@PathVariable Long id){
        return userService.getById(id);
    }

    @GetMapping
    public List<UserResponse> findAll(){
        return userService.findAll();
    }

    @PutMapping("/{id}")
    public UserResponse update(@PathVariable Long id, @RequestBody UserRequest request){
        return userService.update(id, request);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id){
        userService.delete(id);
    }

    @GetMapping("/search/name")
    public List<UserResponse> findByName(@RequestParam String name){
        return userService.findByName(name);
    }

    @GetMapping("/search/email")
    public List<UserResponse> findByEmail(@RequestParam String email){
        return userService.findByEmail(email);
    }
}