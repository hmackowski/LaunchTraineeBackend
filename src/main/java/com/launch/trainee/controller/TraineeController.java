package com.launch.trainee.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import com.launch.trainee.entity.Trainee;
import com.launch.trainee.service.ITraineeService;
import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
/* @CrossOrigin(origins = "http://127.0.0.1:5500") */
public class TraineeController implements ITraineeController {

  @Autowired
  private ITraineeService traineeService;
  
  @Override
  public List<Trainee> fetchAllTrainees() {
    log.debug("fetchAllTrainees() was called, returns a list of all Trainees.");
    return traineeService.fetchAllTrainees();
  }




}
