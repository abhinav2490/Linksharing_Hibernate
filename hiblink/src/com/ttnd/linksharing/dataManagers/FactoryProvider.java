package com.ttnd.linksharing.dataManagers;


import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class FactoryProvider {
    public static SessionFactory factory = new Configuration().configure().buildSessionFactory();

}
