package com.launch.trainee.entity;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class OverallRating {

  private int OrId;
  private int traineeId;
  private Trainee trainee;
  private int ckRating;
  private int psRating;
  private int ssRating;
  private int totalRating;
  
}
