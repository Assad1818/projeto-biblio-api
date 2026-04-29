package com.guilhermeAssad.projeto_biblio_api.domain.service;


import com.guilhermeAssad.projeto_biblio_api.domain.model.User;
import com.guilhermeAssad.projeto_biblio_api.domain.repository.UserRepository;
import com.guilhermeAssad.projeto_biblio_api.dto.request.UserRequest;
import com.guilhermeAssad.projeto_biblio_api.dto.response.UserResponse;
import com.guilhermeAssad.projeto_biblio_api.exception.user.DuplicateUserException;
import com.guilhermeAssad.projeto_biblio_api.exception.user.UserNotFoundException;
import com.guilhermeAssad.projeto_biblio_api.mapper.UserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;

    private User findUserOrThrow(Long id){
        return userRepository.findById(id)
                .orElseThrow(()-> new UserNotFoundException(id));
    }
    private void validateDuplicateUser(UserRequest request){
        boolean exists = userRepository.existsByEmailIgnoreCase(request.getEmail());
        if (exists){
            throw new DuplicateUserException(request.getEmail());
        }

    }

    public UserResponse create(UserRequest request){
        validateDuplicateUser(request);
        User user = userMapper.toEntity(request);
        return userMapper.toResponse(userRepository.save(user));
    }
    public UserResponse getById(Long id) {
        User user  = findUserOrThrow(id);
        return userMapper.toResponse(user);
    }

    public List<UserResponse> findAll(){
        return userMapper.toUserResponseList(userRepository.findAll());
    }

    public void delete(Long id){
        User user = findUserOrThrow(id);
        userRepository.delete(user);
    }

    public UserResponse update(Long id, UserRequest request){
        User user = findUserOrThrow(id);
        user.updateFrom(userMapper.toEntity(request));
        return userMapper.toResponse(userRepository.save(user));
    }
}
