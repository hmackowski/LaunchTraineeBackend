package com.launch.trainee.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;
import com.launch.trainee.entity.Trainee;
import com.launch.trainee.entity.TraineeNotes;
import com.launch.trainee.entity.TraineeProfile;
import com.launch.trainee.service.ITraineeService;
import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
@CrossOrigin(origins = "http://localhost:3000/") // Adjust the origin as needed
public class TraineeController implements ITraineeController {

  @Autowired
  private ITraineeService traineeService;

  @Override
  public List<Trainee> fetchAllTrainees() {
    log.debug("fetchAllTrainees() was called, returns a list of all Trainees.");
    return traineeService.fetchAllTrainees();
  }


  @Override
  public TraineeProfile getTraineeProfile(Integer traineeId) {
    log.debug("getTraineeProfile() was called for traineeId: {}", traineeId);
    return traineeService.getTraineeProfile(traineeId);
  }

  @Override
  public List<TraineeNotes> fetchAllTraineeNotesById(Integer traineeId) {
    log.debug("fetchAllTraineeNotesById in controller id: " + traineeId);
    return traineeService.fetchAllTraineeNotesById(traineeId);
  }
}
