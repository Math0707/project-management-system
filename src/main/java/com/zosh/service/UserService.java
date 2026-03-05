package com.zosh.service;

import com.zosh.modal.User;

public interface UserService {
    User findUserProfileByJwt(String jwt)throws  Exception;

    User findUSerByEmail(String email )throws Exception;

    User findUserById(Long userId)throws Exception;

    User updateUsersProjectsSize(User user,int number);
}
