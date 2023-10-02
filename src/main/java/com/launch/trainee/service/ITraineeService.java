package com.launch.trainee.service;

import java.util.List;
import com.launch.trainee.entity.Trainee;
import com.launch.trainee.entity.TraineeProfile;

public interface ITraineeService {
  
  public List<Trainee> fetchAllTrainees();

  public TraineeProfile getTraineeProfile(Integer traineeId);
}
