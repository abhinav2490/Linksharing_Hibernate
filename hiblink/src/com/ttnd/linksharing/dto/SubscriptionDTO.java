package com.ttnd.linksharing.dto;

import com.ttnd.linksharing.domains.Topic;
import com.ttnd.linksharing.domains.User;
import com.ttnd.linksharing.enums.Seriousness;

import java.util.Date;

public class SubscriptionDTO {
    public Seriousness seriousLevel;
    public Date dateCreated;
    public Date lastUpdated;
    public User user;
    public Topic topic;
}
