package com.launch.trainee.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.launch.trainee.DAO.ITraineeDAO;
import com.launch.trainee.entity.Trainee;

@Service
public class TraineeService implements ITraineeService {

  @Autowired
  private ITraineeDAO traineeDAO;
  
  @Override
  public List<Trainee> fetchAllTrainees() {
    List<Trainee> trainees = traineeDAO.fetchAllTrainees();
    return trainees;
  }

}
