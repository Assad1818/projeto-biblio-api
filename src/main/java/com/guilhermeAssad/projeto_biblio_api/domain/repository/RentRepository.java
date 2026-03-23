package com.guilhermeAssad.projeto_biblio_api.domain.repository;

import com.guilhermeAssad.projeto_biblio_api.domain.model.Rent;
import com.guilhermeAssad.projeto_biblio_api.utils.ERentStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface RentRepository extends JpaRepository<Rent, Long> {
    List<Rent> findByStatusAndDateReturnIsNull(ERentStatus status, LocalDateTime dateReturn);

}
