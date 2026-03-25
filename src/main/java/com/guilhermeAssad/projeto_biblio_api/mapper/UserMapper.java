package com.guilhermeAssad.projeto_biblio_api.mapper;

import com.guilhermeAssad.projeto_biblio_api.domain.model.User;
import com.guilhermeAssad.projeto_biblio_api.dto.request.UserRequest;
import com.guilhermeAssad.projeto_biblio_api.dto.response.UserResponse;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class UserMapper {

    public User toEntity(UserRequest request){
        User user = new User();
        user.setName(request.getName());
        user.setEmail(request.getEmail());
        user.setPassword(request.getPassword());
        return user;
    }

    public UserResponse toResponse(User user){
        return new UserResponse(user.getId(), user.getName(), user.getEmail(), user.getUserType());
    }

    public List<UserResponse> toUserResponseList(List<User> users){
        return users.stream()
                .map(this::toResponse)
                .collect(Collectors.toList());
    }
}
