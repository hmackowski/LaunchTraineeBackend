package com.launch.trainee.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.launch.trainee.DAO.ITraineeDAO;
import com.launch.trainee.entity.Trainee;
import com.launch.trainee.entity.TraineeNotes;
import com.launch.trainee.entity.TraineeProfile;

@Service
public class TraineeService implements ITraineeService {

  @Autowired
  private ITraineeDAO traineeDAO;

  @Override
  public List<Trainee> fetchAllTrainees() {
    List<Trainee> trainees = traineeDAO.fetchAllTrainees();
    return trainees;
  }

  @Override
  public TraineeProfile getTraineeProfile(Integer traineeId) {
    TraineeProfile traineeProfile = traineeDAO.getTraineeProfile(traineeId);
    return traineeProfile;
  }

  @Override
  public List<TraineeNotes> fetchAllTraineeNotesById(Integer traineeId) {
    List<TraineeNotes> traineeNotes = traineeDAO.fetchAllTraineeNotesById(traineeId);
    return traineeNotes;
  }

}
