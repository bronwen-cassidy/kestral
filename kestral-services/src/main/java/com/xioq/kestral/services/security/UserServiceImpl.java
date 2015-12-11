package com.xioq.kestral.services.security;

import com.xioq.kestral.services.DataAccessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;

/**
 * Created by bronwen.cassidy on 14/05/2015
 */

@Configuration
@Service ("userService")
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private DataAccessor dataAccessor;

    @Transactional(readOnly = false)
    public User save(User user) {
        Serializable id = dataAccessor.save(user);
        user.setId((Long)id);
        return user;
    }
}
