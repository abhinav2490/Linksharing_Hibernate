package com.ttnd.linksharing.dto;


import com.ttnd.linksharing.domains.User;
import com.ttnd.linksharing.enums.TopicVisibility;

public class TopicDTO {
    public User creator;
    public Integer id;
    public String name;
    public String description;
    public TopicVisibility visibility;

}
