package com.project.knowyourcity.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.project.knowyourcity.dto.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.knowyourcity.entity.User;
import com.project.knowyourcity.repository.UserRepository;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepo;
    
    public List<UserDto> getAllUsers(){
        List<User> userList = userRepo.findAll();
        List<UserDto> userDtoList = new ArrayList<>();
        for(User temp : userList) {
            UserDto user1 = UserDto.builder()
                    .userId(temp.getUserId())
                    .name(temp.getName())
                    .email(temp.getEmail())
                    .password(temp.getPassword())
                    .role(temp.getRole())
                    .build();
            userDtoList.add(user1);
        }
        return userDtoList;
    }

    public UserDto insertNewUser(UserDto newUser){
        User tempUser = User.builder()
                .Name(newUser.getName())
                .Email(newUser.getEmail())
                .Password(newUser.getPassword())
                .Role(newUser.getRole())
                .build();

        User user1 = userRepo.save(tempUser);
        return UserDto.builder()
                .userId(user1.getUserId())
                .name(newUser.getName())
                .email(newUser.getEmail())
                .role(newUser.getRole())
                .build();
    }

    public UserDto loginUser(UserDto user){
        Optional<User> temp = userRepo.matchUser(user.getEmail(), user.getPassword());
        if (temp.isPresent()){
            return UserDto.builder()
                    .userId(temp.get().getUserId())
                    .name(temp.get().getName())
                    .email(temp.get().getEmail())
                    .role(temp.get().getRole())
                    .build();
        }
        return null;
    }
}
