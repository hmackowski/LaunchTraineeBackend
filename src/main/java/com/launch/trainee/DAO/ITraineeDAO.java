package com.launch.trainee.DAO;

import java.util.List;
import com.launch.trainee.entity.Trainee;
import com.launch.trainee.entity.TraineeNotes;
import com.launch.trainee.entity.TraineeProfile;

public interface ITraineeDAO {

  List<Trainee> fetchAllTrainees();

  TraineeProfile getTraineeProfile(Integer traineeId);

  List<TraineeNotes> fetchAllTraineeNotesById(Integer traineeId);

}
