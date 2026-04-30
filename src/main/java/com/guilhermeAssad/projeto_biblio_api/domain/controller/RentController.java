package com.guilhermeAssad.projeto_biblio_api.domain.controller;

import com.guilhermeAssad.projeto_biblio_api.domain.service.RentService;
import com.guilhermeAssad.projeto_biblio_api.dto.request.RentRequest;
import com.guilhermeAssad.projeto_biblio_api.dto.response.RentResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/rents")
public class RentController {

    private final RentService rentService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public RentResponse create(@RequestBody RentRequest request){
        return rentService.create(request);
    }

    @PutMapping("/{id}/return")
    public RentResponse returnBook(@PathVariable Long id){
        return rentService.returnBook(id);
    }

    @GetMapping("/{id}")
    public RentResponse getById(@PathVariable Long id){
        return rentService.getById(id);
    }

    @GetMapping
    public List<RentResponse> findAll(){
        return rentService.findAll();
    }


    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id){
        rentService.delete(id);
    }

    @GetMapping("/search/active")
    public List<RentResponse> findActiveRents(){
        return rentService.findActiveRents();
    }

    @GetMapping("/search/returned")
    public List<RentResponse> findReturnedRents(){
        return rentService.findReturnedRents();
    }

    @GetMapping("/search/user")
    public List<RentResponse> findByUser(@RequestParam Long userId){
        return rentService.findByUser(userId);
    }

    @GetMapping("/search/book")
    public List<RentResponse> findByBook(@RequestParam Long bookId){
        return rentService.findByBook(bookId);
    }
}