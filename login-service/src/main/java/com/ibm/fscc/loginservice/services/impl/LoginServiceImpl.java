package com.ibm.fscc.loginservice.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ibm.fscc.loginservice.repository.LoginRepository;
import com.ibm.fscc.loginservice.services.LoginService;
import com.ibm.fscc.loginservice.shared.LoginDto;

@Component
public class LoginServiceImpl implements LoginService {

    @Autowired
    LoginRepository loginRepository;

    @Override
    public LoginDto getLogin(String email) {
        if(loginRepository.existsById(email)){
            String password = loginRepository.findById(email).get().getPassword();
            return new LoginDto(email, password);
        }

        return null;
    }
    
}
