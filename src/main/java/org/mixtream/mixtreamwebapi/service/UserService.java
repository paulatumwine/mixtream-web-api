package org.mixtream.mixtreamwebapi.service;

import org.mixtream.mixtreamwebapi.adapter.UserAdapter;
import org.mixtream.mixtreamwebapi.dto.UserDTO;
import org.mixtream.mixtreamwebapi.model.User;
import org.mixtream.mixtreamwebapi.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {

    @Autowired
    UserRepository repository;

    public List<UserDTO> findAll() {
        List<User> list = repository.findAll();
        return list.stream().map(UserAdapter::getUserDTO).collect(Collectors.toList());
    }

    public UserDTO findById(String id) {
        User obj = repository.findById(id).orElse(null);
        return UserAdapter.getUserDTO(obj);
    }

    public UserDTO save(UserDTO request) {
        User response = repository.save(UserAdapter.getUser(request));
        return UserAdapter.getUserDTO(response);
    }

    public UserDTO update(UserDTO request) {
        User response = repository.save(UserAdapter.getUser(request));
        return UserAdapter.getUserDTO(response);
    }

    public void delete(String id) {
        repository.deleteById(id);
    }
}
