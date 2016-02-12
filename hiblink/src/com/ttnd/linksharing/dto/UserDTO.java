package com.ttnd.linksharing.dto;

import com.ttnd.linksharing.enums.UserGender;
import com.ttnd.linksharing.enums.UserStatus;
import com.ttnd.linksharing.enums.UserType;

import java.util.Date;

public class UserDTO {
    public String firstName;
    public String lastName;
    public String eMail;
    public String password;
    public Date dateOfBirth;
    public UserGender gender;
    public UserType type ;
    public UserStatus active;
    public Date dateCreated;
    public Date lastUpdated;
}
