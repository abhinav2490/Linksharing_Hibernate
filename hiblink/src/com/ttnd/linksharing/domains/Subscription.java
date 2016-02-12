package com.ttnd.linksharing.domains;

import com.ttnd.linksharing.dto.SubscriptionDTO;
import com.ttnd.linksharing.enums.Seriousness;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "subscription")
public class Subscription {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Integer id;
    Seriousness seriousLevel;
    Date dateCreated;
    Date lastUpdated;
    @ManyToOne(cascade = CascadeType.REMOVE)
    User user;
    @OneToOne
    Topic topic;

    public Seriousness getSeriousLevel() {
        return seriousLevel;
    }

    public void setSeriousLevel(Seriousness seriousLevel) {
        this.seriousLevel = seriousLevel;
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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Topic getTopic() {
        return topic;
    }

    public void setTopic(Topic topic) {
        this.topic = topic;
    }

    public Subscription() {
    }

    public Subscription(SubscriptionDTO dataDto) {
        this.seriousLevel = dataDto.seriousLevel;
        this.dateCreated = dataDto.dateCreated;
        this.lastUpdated = dataDto.lastUpdated;
        this.user = dataDto.user;
        this.topic = dataDto.topic;
    }

    //    static belongsTo = [subscriber: User, topic: Topic]
//    static constraints = {
//        topic(unique: ['subscriber'])
//    }
}
