package com.ttnd.linksharing.dataManagers;

import com.ttnd.linksharing.domains.Subscription;
import com.ttnd.linksharing.dto.SubscriptionDTO;
import com.ttnd.linksharing.enums.Seriousness;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.Date;

public class SubscriptionManager {

    public Integer addSubscription(SubscriptionDTO dataDto){
        Session session = FactoryProvider.factory.openSession();
        Transaction tx = null;
        Integer subscriptionId = null;
        try{
            tx = session.beginTransaction();
            dataDto.dateCreated = new Date();
            Subscription subscription = new Subscription(dataDto);
            subscriptionId = (Integer) session.save(subscription);
            tx.commit();
        }catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        }finally {
            session.close();
        }
        return subscriptionId;
    }

    public Integer removeSubscription(Integer subscriptionId){
        Session session = FactoryProvider.factory.openSession();
        Transaction tx = null;
        try{
            tx = session.beginTransaction();
            Subscription subscription = (Subscription) session.get(Subscription.class,subscriptionId);
            session.delete(subscription);
            tx.commit();
        }catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        }finally {
            session.close();
        }
        return subscriptionId;
    }

    public void updateSeriousLevel(Seriousness seriousness, Integer id){
        Session session = FactoryProvider.factory.openSession();
        Transaction tx =null;
        try{
            tx=session.beginTransaction();
            Subscription subscription = (Subscription) session.get(Subscription.class,id);
            subscription.setSeriousLevel(seriousness);
            subscription.setLastUpdated(new Date());
            session.update(subscription);
            tx.commit();
        }catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        }finally {
            session.close();
        }
    }
}
