package com.ttnd.linksharing.domains;

import com.ttnd.linksharing.dto.UserDTO;
import com.ttnd.linksharing.enums.UserGender;
import com.ttnd.linksharing.enums.UserStatus;
import com.ttnd.linksharing.enums.UserType;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

@Entity
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private Date dateOfBirth;
    private UserGender gender;
    private UserType type ;
    private UserStatus active;
    private Date dateCreated;
    private Date lastUpdated;
    @OneToMany(cascade = CascadeType.REMOVE,mappedBy = "creator")
    private Collection<Topic> topicsCreated = new ArrayList<Topic>();
    @OneToMany(cascade = CascadeType.REMOVE,mappedBy = "user")
    private Collection<Subscription> subscriptions = new ArrayList<Subscription>();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public UserGender getGender() {
        return gender;
    }

    public void setGender(UserGender gender) {
        this.gender = gender;
    }

    public UserType getType() {
        return type;
    }

    public void setType(UserType type) {
        this.type = type;
    }

    public UserStatus getActive() {
        return active;
    }

    public void setActive(UserStatus active) {
        this.active = active;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    public Date getLastUpdated() {
        return lastUpdated;
    }

    public void setLastUpdated(Date lastUpdated) {
        this.lastUpdated = lastUpdated;
    }

    public Collection<Topic> getTopicsCreated() {
        return topicsCreated;
    }

    public void setTopicsCreated(Collection<Topic> topicsCreated) {
        this.topicsCreated = topicsCreated;
    }

    public User() {
    }

    public User(UserDTO userData) {
        this.firstName = userData.firstName;
        this.lastName = userData.lastName;
        this.email = userData.eMail;
        this.password = userData.password;
        this.dateOfBirth = userData.dateOfBirth;
        this.gender = userData.gender;
        this.type = userData.type;
        this.active = userData.active;
        this.dateCreated = userData.dateCreated;
        this.lastUpdated = userData.lastUpdated;
    }

    public Collection<Subscription> getSubscriptions() {
        return subscriptions;
    }

    public void setSubscriptions(Collection<Subscription> subscriptions) {
        this.subscriptions = subscriptions;
    }
//    static hasMany = [readStatus: ReadStatus, resources: Resource]
//    static constraints = {
//        email(email: true, unique: true)
//        lastName(nullable: true)
//    }
}
