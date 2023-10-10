package com.launch.trainee.entity;
import java.util.List;
import org.springframework.data.relational.core.mapping.Table;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@Table(name = "traineeProfile")
public class TraineeProfile {
  private Trainee trainee;
  private List<Attendance> attendanceList;
}
