package com.launch.trainee.entity;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ClassroomKnowledge {

  private int CkId;
  private int traineeId;
  private Trainee trainee;
  private int test1Score;
  private int test2Score;
  private int test3Score;
  private int test4Score;
  private int averageTestScore;
}
