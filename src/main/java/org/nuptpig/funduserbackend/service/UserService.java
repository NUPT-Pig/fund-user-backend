package org.nuptpig.funduserbackend.service;

import org.nuptpig.funduserbackend.entity.Users;
import org.nuptpig.funduserbackend.vo.UserCreateRequest;
import org.nuptpig.funduserbackend.vo.UserListResponse;

import java.util.List;

public interface UserService {
    List<UserListResponse> getUsers();
    Users getUserByUserName(String userName);
    Users addUser(UserCreateRequest userCreateRequest);
    Boolean userExists(String userName);
}
