package com.ibm.fscc.kafka.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ibm.fscc.kafka.model.NewUserDto;
import com.ibm.fscc.kafka.model.User;
import com.ibm.fscc.kafka.repository.KafkaRepository;
import com.ibm.fscc.kafka.service.impl.ConsumerServiceImpl;
import com.ibm.fscc.kafka.service.impl.ProducerServiceImpl;

@RestController
@RequestMapping(path = "api")
public class KafkaController {

    @Autowired
    private Environment env;

    @Autowired
    KafkaRepository kafkaRepository;

    @Autowired
    ConsumerServiceImpl consumerService;

    @Autowired
    ProducerServiceImpl producerService;

    @GetMapping(path = "/status/check")
    public String status() {
        return "Working on port " + env.getProperty("server.port") + "!";
    }

    @PostMapping(path = "/register-user")
    public String newUser(@RequestBody NewUserDto newUser) throws Exception{
        try{
            producerService.produce(newUser);
        }catch(Exception e){
            throw new Exception("User registration failed.");
        }
        return null;
    }

    @GetMapping(path = "/authenticate/user")
    public String existingUser(@RequestBody User user) throws Exception{

        try{
            producerService.authenticateUser(user);
        }catch(Exception e){
            throw new Exception("User does not exist.");
        }
        return null;
    }


}
