package com.boraji.tutorial.hibernate;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.boraji.tutorial.hibernate.entity.Employee;

public class InsertBatchExample {
   public static void main(String[] args) {
      Session session = null;
      Transaction transaction = null;
      int batchSize = 100;
      try {
         session = HibernateUtil.getSessionFactory().openSession();
         transaction = session.beginTransaction();

         for (long i = 1; i <= 100; i++) {
            Employee employee = new Employee();
            employee.setName("Employee " + i);
            employee.setEmial("sunil@example.com");
            session.save(employee);
            if (i > 0 && i % batchSize == 0) {
               session.flush();
               session.clear();
            }
         }
         transaction.commit();
      } catch (Exception e) {
         e.printStackTrace();
      } finally {
         if (session != null) {
            session.close();
         }
      }
      
      HibernateUtil.shutdown();
   }
}
