package com.boraji.tutorial.hibernate.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.TableGenerator;

@Entity
public class Employee {
   
   @Id
   @TableGenerator(name = "EMP_SEQ")
   @GeneratedValue(strategy = GenerationType.TABLE, generator = "EMP_SEQ")
   private Long id;

   private String name;
   private String emial;

   public Long getId() {
      return id;
   }

   public void setId(Long id) {
      this.id = id;
   }

   public String getName() {
      return name;
   }

   public void setName(String name) {
      this.name = name;
   }

   public String getEmial() {
      return emial;
   }

   public void setEmial(String emial) {
      this.emial = emial;
   }

}
