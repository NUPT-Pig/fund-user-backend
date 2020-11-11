package org.nuptpig.funduserbackend.dao;

import org.nuptpig.funduserbackend.entity.Users;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface UserRepository extends PagingAndSortingRepository<Users, Long> {
    List<Users> findAll();
    Users getUsersByUserName(String userName);
}
