package com.ibm.fscc.kafka.service.impl;

import com.ibm.fscc.kafka.model.NewUserDto;
import com.ibm.fscc.kafka.model.User;
import com.ibm.fscc.kafka.repository.KafkaRepository;
import com.ibm.fscc.kafka.service.ProducerService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class ProducerServiceImpl implements ProducerService {

    @Autowired
    KafkaTemplate<String,String> kafkaTemplate;
    
    @Autowired
    KafkaRepository kafkaRepository;

    @Override
    public void produce(NewUserDto newUserDto) throws Exception {

        try{
            User user = new User();

            user.setFirstName(newUserDto.getFirstName());
            user.setLastName(newUserDto.getLastName());
            user.setEmail(newUserDto.getEmail());
            

            kafkaTemplate.send("registration-topic", "User created");
        }catch(Exception e){
            kafkaTemplate.send("registation-topic", "User was not saved");
            throw new Exception("User information not set.");
        }
        
    }

    public void authenticateUser(User user) throws Exception{

        try{

        }catch(Exception e){
            kafkaTemplate.send("registration-topic","User does not exist.");
            throw new Exception("User was not found.");
        }
    }
}
