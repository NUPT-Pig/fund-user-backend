package org.nuptpig.funduserbackend.service.Impl;

import org.apache.catalina.User;
import org.nuptpig.funduserbackend.dao.UserRepository;
import org.nuptpig.funduserbackend.entity.Users;
import org.nuptpig.funduserbackend.service.UserService;
import org.nuptpig.funduserbackend.util.CommonHelper;
import org.nuptpig.funduserbackend.util.HashHelper;
import org.nuptpig.funduserbackend.util.RandomStringHelper;
import org.nuptpig.funduserbackend.vo.UserCreateRequest;
import org.nuptpig.funduserbackend.vo.UserListResponse;
import org.springframework.stereotype.Service;
import org.nuptpig.funduserbackend.util.MapperHelper;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<UserListResponse> getUsers() {
        List<Users> users = userRepository.findAll();
        return MapperHelper.SourcesToDestinations(users, UserListResponse.class);
    }

    @Override
    public Users getUserByUserName(String userName) {
        return userRepository.getUsersByUserName(userName);
    }

    @Override
    public Users addUser(UserCreateRequest userCreateRequest) {
        Users users = MapperHelper.SourceToDestination(userCreateRequest, Users.class);
        users.setSalt(CommonHelper.generateSalt());
        String password = userCreateRequest.getPassword();
        users.setPassword(HashHelper.sha512Hash(password, users.getSalt()));
        users.setRole(Users.Role.VIEWER.getRoleLevel());
        userRepository.save(users);
        return users;
    }
}
