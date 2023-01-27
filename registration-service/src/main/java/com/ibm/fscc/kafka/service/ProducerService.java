package com.ibm.fscc.kafka.service;

import com.ibm.fscc.kafka.model.NewUserDto;

public interface ProducerService {
    public void produce(NewUserDto newUser) throws Exception;

}
