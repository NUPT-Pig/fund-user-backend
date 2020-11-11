package org.nuptpig.funduserbackend.service.Impl;

import org.apache.catalina.User;
import org.nuptpig.funduserbackend.dao.UserRepository;
import org.nuptpig.funduserbackend.entity.Users;
import org.nuptpig.funduserbackend.service.UserService;
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
}
