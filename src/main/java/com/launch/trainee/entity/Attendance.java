package com.launch.trainee.entity;
import java.sql.Date;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Attendance {
  private int attendeanceId;
  private int traineeId;
  private Trainee trainee;
  private Date attendanceDate;
  @SuppressWarnings("unused")
  private enum status {
    Present,
    Late,
    Absent,
    PTO,
    Sick
  } 
  
}
