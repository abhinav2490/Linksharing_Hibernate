package com.ttnd.linksharing.dataManagers;

import com.ttnd.linksharing.domains.User;
import com.ttnd.linksharing.dto.UserDTO;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class UserManager {

    public int addUser(UserDTO userData){
        Session session = FactoryProvider.factory.openSession();
        Transaction tx = null;
        Integer savedUserId = null;
        try{
            tx = session.beginTransaction();
            userData.dateCreated = new Date();
            User user = new User(userData);
            savedUserId = (Integer) session.save(user);
            tx.commit();
        }catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        }finally {
            session.close();
        }
        return savedUserId;
    }

    public void deleteUser(Integer userId){
        Session session = FactoryProvider.factory.openSession();
        Transaction tx = null;
        try{
            tx = session.beginTransaction();
            User user = (User) session.get(User.class,userId);
            session.delete(user);
            tx.commit();
        }catch (HibernateException e){
            if(tx!=null) tx.rollback();
            e.printStackTrace();
        }finally {
            session.close();
        }
    }

    public void updateUser(UserDTO dto,Integer id){
        Session session = FactoryProvider.factory.openSession();
        Transaction tx = null;
        try{
            tx = session.beginTransaction();
            User user =(User) session.get(User.class,id);
            user.setLastUpdated(new Date());
            user.setFirstName(dto.firstName);
            user.setLastUpdated(dto.lastUpdated);
            user.setPassword(dto.password);
            user.setDateOfBirth(dto.dateOfBirth);
            user.setGender(dto.gender);
            user.setActive(dto.active);
            user.setType(dto.type);
            session.update(user);
            tx.commit();
        }catch (HibernateException e){
            if(tx!=null) tx.rollback();
            e.printStackTrace();
        }finally {
            session.close();
        }
    }

    public List<User> listUser(){
        Session session = FactoryProvider.factory.openSession();
        Transaction tx = null;
        List<User> userList = new ArrayList<User>();
        try{
            tx = session.beginTransaction();
            userList = session.createQuery("FROM User ").list();
            tx.commit();
        }catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        }finally {
            session.close();
        }
        return userList;
    }

}
