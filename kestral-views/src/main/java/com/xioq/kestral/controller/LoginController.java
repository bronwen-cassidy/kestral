package com.xioq.kestral.controller;

import com.xioq.kestral.services.security.InvalidLoginCredentialsException;
import com.xioq.kestral.services.security.LoginInfo;
import com.xioq.kestral.services.security.User;
import com.xioq.kestral.services.clients.ClientService;
import com.xioq.kestral.services.security.LoginService;
import com.xioq.kestral.services.providers.ProviderService;
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
@RequestMapping("/logins")
public class LoginController {

    @Autowired
    private LoginService loginService;
    @Autowired
    private ProviderService providerService;
    @Autowired
    private ClientService clientService;


    @RequestMapping(value = "/login", method = RequestMethod.POST,headers = "Accept=application/json")
    public ResponseEntity<Map> clientLogin(@RequestBody LoginInfo loginInfo) {
        Map<String, Object> resultMapping = new HashMap<String, Object>();
        try {
            // todo need to return a client and/ or an error
            User user = loginService.loginUser(loginInfo);
            if(user.isProvider()) {
                resultMapping.put("provider", providerService.find(new User(user.getId())));
            } else {
                resultMapping.put("client", clientService.find(new User(user.getId())));
            }
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

    @RequestMapping(value="/add", method = RequestMethod.POST,headers="Accept=application/json")
    public LoginInfo addLoginInfo(@RequestBody LoginInfo loginInfo) {
        return loginService.addUserLogin(loginInfo);
    }
}
