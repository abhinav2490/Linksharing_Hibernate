package com.ttnd.linksharing;


import com.ttnd.linksharing.domains.Subscription;
import com.ttnd.linksharing.domains.Topic;
import com.ttnd.linksharing.domains.User;
import com.ttnd.linksharing.dto.SubscriptionDTO;
import com.ttnd.linksharing.dto.TopicDTO;
import com.ttnd.linksharing.dto.UserDTO;
import com.ttnd.linksharing.dataManagers.*;
import com.ttnd.linksharing.enums.Seriousness;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class Main {
    public static void main(String args[]){
        UserManager manager = new UserManager();
        TopicManager topicManager = new TopicManager();
        SubscriptionManager subscriptionManager = new SubscriptionManager();
        UserDTO dataDto = new UserDTO();
        dataDto.firstName = "test";
        dataDto.lastName = "name";
        Integer userId = manager.addUser(dataDto);

        Session session = FactoryProvider.factory.openSession();
        Transaction tx = session.beginTransaction();
        User user = (User) session.get(User.class,userId);
        tx.commit();
        session.close();

        TopicDTO topicDTO = new TopicDTO();
        topicDTO.name = "Groovy";
        topicDTO.creator = user;
        Integer topicId = topicManager.addTopic(topicDTO);

        session = FactoryProvider.factory.openSession();
         tx = session.beginTransaction();
        Topic topic = (Topic) session.get(Topic.class,topicId);
        tx.commit();
        session.close();

        SubscriptionDTO subscriptionDTO = new SubscriptionDTO();
        subscriptionDTO.seriousLevel = Seriousness.SERIOUS;
        subscriptionDTO.user = user;
        subscriptionDTO.topic = topic;
        Integer subsId = subscriptionManager.addSubscription(subscriptionDTO);
        subscriptionManager.updateSeriousLevel(Seriousness.CASUAL,subsId);

//        manager.deleteUser(userId);
        topicManager.deleteTopic(topicId);
    }
}

