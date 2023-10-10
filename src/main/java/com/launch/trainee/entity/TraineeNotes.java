package com.launch.trainee.entity;

import org.springframework.data.relational.core.mapping.Table;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@Table(name = "trainee_notes")
public class TraineeNotes {
  private int traineeNotesId;
  private int traineeId;
  private String note;
  private String date;
}
