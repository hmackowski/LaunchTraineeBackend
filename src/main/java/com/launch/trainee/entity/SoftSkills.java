package com.launch.trainee.entity;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class SoftSkills {

  private int SsId;
  private int traineeId;
  private Trainee trainee;
  private int pctScore;
  private int tmwScore;
  private int pslScore;
  private int comScore;
}
