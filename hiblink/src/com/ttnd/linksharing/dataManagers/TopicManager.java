package com.ttnd.linksharing.dataManagers;


import com.ttnd.linksharing.domains.Topic;
import com.ttnd.linksharing.domains.User;
import com.ttnd.linksharing.dto.TopicDTO;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

public class TopicManager {

    public int addTopic(TopicDTO dataDto){
        Session session = FactoryProvider.factory.openSession();
        Transaction tx = null;
        Integer savedTopicId = null;
        try{
            tx=session.beginTransaction();
            Topic topic = new Topic(dataDto);
            savedTopicId = (Integer)session.save(topic);
            tx.commit();
        }catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        }finally {
            session.close();
        }
        return savedTopicId;
    }

    public void deleteTopic(Integer topicId){
        Session session = FactoryProvider.factory.openSession();
        Transaction tx = null;
        try{
            tx = session.beginTransaction();
            Topic topic = (Topic) session.get(Topic.class,topicId);
            session.delete(topic);
            tx.commit();
        }catch (HibernateException e){
            if(tx!=null) tx.rollback();
            e.printStackTrace();
        }finally {
            session.close();
        }
    }

    public void updateTopic(TopicDTO dto , Integer id){
        Session session = FactoryProvider.factory.openSession();
        Transaction tx =null;
        try{
            tx = session.beginTransaction();
            Topic topic = (Topic) session.get(Topic.class,id);
            topic.setDescription(dto.description);
            topic.setVisibility(dto.visibility);
            topic.setName(dto.name);
            session.update(topic);
            tx.commit();
        }catch (HibernateException e){
            if(tx!=null) tx.rollback();
            e.printStackTrace();
        }finally {
            session.close();
        }
    }

    public List<Topic> listUser(){
        Session session = FactoryProvider.factory.openSession();
        Transaction tx = null;
        List<Topic> topicList = new ArrayList<Topic>();
        try{
            tx = session.beginTransaction();
            topicList = session.createQuery("FROM User ").list();
            tx.commit();
        }catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        }finally {
            session.close();
        }
        return topicList;
    }

}
