package com.boraji.tutorial.hibernate;

import org.hibernate.CacheMode;
import org.hibernate.ScrollMode;
import org.hibernate.ScrollableResults;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.boraji.tutorial.hibernate.entity.Employee;

public class UpdateBatchExample {
   public static void main(String[] args) {
      Session session = null;
      Transaction transaction = null;
      ScrollableResults scrollableResults = null;
      int batchSize = 50;
      try {
         session = HibernateUtil.getSessionFactory().openSession();
         transaction = session.beginTransaction();

         scrollableResults=session.createQuery("from Employee")
               .setCacheMode(CacheMode.IGNORE)
               .scroll(ScrollMode.FORWARD_ONLY);
         
         int count=0;
         while (scrollableResults.next()) {
            Employee employee = (Employee) scrollableResults.get(0);
            employee.setEmial("sunil.singh@example.com"); // Change property
            if (++count % batchSize == 0) {
               session.flush();
               session.clear();
            }
         }
         
         transaction.commit();
      } catch (Exception e) {
         e.printStackTrace();
      } finally {
         if (scrollableResults != null) {
            scrollableResults.close();
         }
         if (session != null) {
            session.close();
         }
      }
      
      HibernateUtil.shutdown();
   }
}
