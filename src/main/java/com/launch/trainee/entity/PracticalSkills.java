package com.launch.trainee.entity;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PracticalSkills {

  private int PsId;
  private int traineeId;
  private Trainee trainee;
  private int wpsScore;
  private int disScore;
}
