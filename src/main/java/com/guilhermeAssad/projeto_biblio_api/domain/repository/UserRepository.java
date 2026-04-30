package com.guilhermeAssad.projeto_biblio_api.domain.repository;

import com.guilhermeAssad.projeto_biblio_api.domain.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    List<User> findByNameContainingIgnoreCase (String name);

    List<User> findByEmail (String email);

    boolean existsByEmailIgnoreCase(String email);
}
