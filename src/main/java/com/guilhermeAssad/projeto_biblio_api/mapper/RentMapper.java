package com.guilhermeAssad.projeto_biblio_api.mapper;

import com.guilhermeAssad.projeto_biblio_api.domain.model.Rent;
import com.guilhermeAssad.projeto_biblio_api.dto.request.RentRequest;
import com.guilhermeAssad.projeto_biblio_api.dto.response.RentResponse;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class RentMapper {

    public RentResponse toResponse(Rent rent){
        return new RentResponse(rent.getId(),
                rent.getUser().getName(),
                rent.getBook().getName(),
                rent.getStatus(),
                rent.getDateRent(),
                rent.getDateReturn());
    }

    public List<RentResponse> toRentResponseList(List<Rent> rents){
        return rents.stream()
                .map(this::toResponse)
                .collect(Collectors.toList());
    }

}
