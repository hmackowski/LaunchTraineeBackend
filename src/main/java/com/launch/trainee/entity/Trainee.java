package com.launch.trainee.entity;


import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@Table(name = "trainee")
public class Trainee {
  
  @Id
  private int traineeId;
  
  private String firstName;  
  private String lastName;  
  private String hireDate;  
  private String expectedGraduationDate;  
  private int overallRating;
}
