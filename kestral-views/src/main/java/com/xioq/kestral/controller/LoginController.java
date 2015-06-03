package com.xioq.kestral.controller;

import com.xioq.kestral.model.InvalidLoginCredentialsException;
import com.xioq.kestral.model.LoginInfo;
import com.xioq.kestral.model.User;
import com.xioq.kestral.services.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.security.auth.login.FailedLoginException;
import java.util.HashMap;
import java.util.Map;

/**
 * handle appointments
 */
@RestController
@RequestMapping("/")
public class LoginController {

    @Autowired
    private LoginService loginService;

    @RequestMapping(value = "/login", method = RequestMethod.POST,headers = "Accept=application/json")
    public ResponseEntity<Map> clientLogin(@RequestBody LoginInfo loginInfo) {
        Map<String, Object> resultMapping = new HashMap<String, Object>();
        try {
            // todo need to return a client and/ or an error
            User user = loginService.loginUser(loginInfo);
            resultMapping.put("user", user);
            resultMapping.put("successMsg", "Login Successful");
            return new ResponseEntity<Map>(resultMapping, HttpStatus.OK);
        } catch (InvalidLoginCredentialsException e) {
            resultMapping.put("errorMsg", "Invalid username or password");

        } catch (FailedLoginException e) {
            resultMapping.put("errorMsg", "Failed Login");
        }
        return new ResponseEntity<Map>(resultMapping, HttpStatus.UNAUTHORIZED);
    }
}