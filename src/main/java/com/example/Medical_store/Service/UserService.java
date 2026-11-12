package com.example.Medical_store.Service;
import com.example.Medical_store.Dto.UserDto;
import com.example.Medical_store.Exception.UserNotFoundException;
import com.example.Medical_store.Repository.UserRepository;
import org.springframework.stereotype.Service;
import com.example.Medical_store.Entity.User;

import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User addUser(UserDto dto) {

        User user = User.builder()
                .username(dto.getUsername())
                .password(dto.getPassword())
                .build();

        return userRepository.save(user);
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User getUserById(Long id) {

        return userRepository.findById(id)
                .orElseThrow(() ->
                        new UserNotFoundException(
                                "User not found with id : " + id));
    }

    public void deleteUser(Long id) {

        User user = getUserById(id);

        userRepository.delete(user);
    }
}