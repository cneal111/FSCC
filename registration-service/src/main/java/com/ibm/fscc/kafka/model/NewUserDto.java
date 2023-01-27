package com.ibm.fscc.kafka.model;

public class NewUserDto {

    private String firstname;

    private String lastname;

    private String email;

    public NewUserDto(String firstname, String lastname, String email){

        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;

    }

    public String getFirstName(){
        return this.firstname;
    }

    public void setFirstName(String firstname){
        this.firstname = firstname;
    }

    public String getLastName(){
        return this.lastname;
    }

    public void setLastName(String lastname){
        this.lastname = lastname;
    }
    
    public String getEmail(){
        return this.email;
    }

    public void setEamil(String email){
        this.email = email;
    }


    
}
