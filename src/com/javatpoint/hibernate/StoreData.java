    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.javatpoint.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.boot.Metadata;

/**
 *
 * @author narottamkrjha
 */
public class StoreData {
    
    public static void main(String[] args) {
//        SessionFactory sessionFactory= null;
//        try{
//            sessionFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
//        }catch(Throwable ex){
//            System.err.println("Unable to  create session factory");
//            throw new ExceptionInInitializerError(ex);
//        }

           StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
           Metadata meta = new MetadataSources(ssr).getMetadataBuilder().build();
           
           SessionFactory factory = meta.getSessionFactoryBuilder().build();
           Session session = factory.openSession();
           Transaction t = session.beginTransaction();
           
           Employee e1 = new Employee();
           e1.setId(101);
           e1.setFirstName("Narottam");
           e1.setLastName("Kr Jha");
           
           session.save(e1);
           t.commit();
           System.out.println("Sucessfully Saved");
           factory.close();
           session.close();
          
        
    }
}
