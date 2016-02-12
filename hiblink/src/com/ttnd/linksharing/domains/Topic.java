package com.ttnd.linksharing.domains;

import com.ttnd.linksharing.dto.TopicDTO;
import com.ttnd.linksharing.enums.TopicVisibility;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;

@Entity
@Table(name = "topic")
public class Topic {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String name;
    private String description;
    private TopicVisibility visibility;
    @ManyToOne
    @JoinColumn(name = "creator_id")
    private User creator;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public TopicVisibility getVisibility() {
        return visibility;
    }

    public void setVisibility(TopicVisibility visibility) {
        this.visibility = visibility;
    }

    public User getCreator() {
        return creator;
    }

    public void setCreator(User creator) {
        this.creator = creator;
    }

    public Topic() {
    }

    public Topic(TopicDTO dataDto) {
        this.name = dataDto.name;
        this.description = dataDto.description;
        this.visibility = dataDto.visibility;
        this.creator = dataDto.creator;
    }

//    static hasMany = [resources: Resource, subscriptions: Subscription]
//
//
//    static constraints = {
//        description(nullable: true)
//
//    }
}
