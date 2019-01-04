package com.boraji.tutorial.hibernate;

import java.util.HashMap;
import java.util.Map;

import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Environment;

import com.boraji.tutorial.hibernate.entity.Employee;

public class HibernateUtil {
   private static StandardServiceRegistry registry;
   private static SessionFactory sessionFactory;

   public static SessionFactory getSessionFactory() {
      if (sessionFactory == null) {
         try {
            StandardServiceRegistryBuilder registryBuilder = new StandardServiceRegistryBuilder();

            //Configuration properties
            Map<String, Object> settings = new HashMap<>();
            settings.put(Environment.DRIVER, "com.mysql.jdbc.Driver");
            settings.put(Environment.URL, "jdbc:mysql://localhost:3306/batchhp");
            settings.put(Environment.USER, "root");
            settings.put(Environment.PASS,"");
           
            settings.put(Environment.HBM2DDL_AUTO, "update");
            //Set JDBC batch size
            settings.put(Environment.STATEMENT_BATCH_SIZE, 50);

            registryBuilder.applySettings(settings);
            registry = registryBuilder.build();
            System.out.println("Test ddb");
            MetadataSources sources = new MetadataSources(registry);
            sources.addAnnotatedClass(Employee.class);
            Metadata metadata = sources.getMetadataBuilder().build();
            
            sessionFactory = metadata.getSessionFactoryBuilder().build();
         } catch (Exception e) {
            if (registry != null) {
               StandardServiceRegistryBuilder.destroy(registry);
            }
            e.printStackTrace();
         }
      }
      return sessionFactory;
   }

   public static void shutdown() {
      if (registry != null) {
         StandardServiceRegistryBuilder.destroy(registry);
      }
   }
}
