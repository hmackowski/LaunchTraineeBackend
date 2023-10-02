package com.launch.trainee.DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collections;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;
import com.launch.trainee.entity.ClassroomKnowledge;
import com.launch.trainee.entity.OverallRating;
import com.launch.trainee.entity.PracticalSkills;
import com.launch.trainee.entity.SoftSkills;
import com.launch.trainee.entity.Trainee;
import com.launch.trainee.entity.TraineeProfile;
import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class TraineeDAO implements ITraineeDAO {

  @Autowired
  private NamedParameterJdbcTemplate jdbcTemplate;
  @Override
  public List<Trainee> fetchAllTrainees() {
    // @formatter:off
    String sql = ""
        + "SELECT * "
        + "FROM trainees";
    // formatter:on
    log.info("Retreiving all Trainees");
    
    return jdbcTemplate.query(sql, new RowMapper<Trainee>() {
      public Trainee mapRow(ResultSet rs, int rowNum) throws SQLException {
        // @formatter:off
        return Trainee.builder()
            .traineeId(rs.getInt("trainee_id"))
            .firstName(rs.getString("first_name"))
            .lastName(rs.getString("last_name"))
            .hireDate(rs.getString("hire_date"))
            .traineeTitle(rs.getString("trainee_title"))
            .expectedGraduationDate(rs.getString("expected_graduation_date"))
            .overallRating(rs.getInt("overall_rating"))
            .build();
        // @formatter:on
      }
    });
  }
  @Override
  public TraineeProfile getTraineeProfile(Integer traineeId) {
      String sql = "SELECT * FROM trainees t "
                 + "LEFT JOIN classroom_knowledge ck ON t.trainee_id = ck.trainee_id "
                 + "LEFT JOIN practical_skills ps ON t.trainee_id = ps.trainee_id "
                 + "LEFT JOIN soft_skills ss ON t.trainee_id = ss.trainee_id "
                 + "LEFT JOIN overall_ratings orr ON t.trainee_id = orr.trainee_id "
                 + "WHERE t.trainee_id = :traineeId";

      return jdbcTemplate.queryForObject(sql, Collections.singletonMap("traineeId", traineeId), new RowMapper<TraineeProfile>() {
          @Override
          public TraineeProfile mapRow(ResultSet rs, int rowNum) throws SQLException {
              Trainee trainee = Trainee.builder()
                  .traineeId(rs.getInt("trainee_id"))
                  .firstName(rs.getString("first_name"))
                  .lastName(rs.getString("last_name"))
                  .hireDate(rs.getString("hire_date"))
                  .expectedGraduationDate(rs.getString("expected_graduation_date"))
                  .overallRating(rs.getInt("overall_rating"))
                  .build();

              ClassroomKnowledge classroomKnowledge = ClassroomKnowledge.builder()
                  .CkId(rs.getInt("ck_id"))
                  .test1Score(rs.getInt("test1_score"))
                  .test2Score(rs.getInt("test2_score"))
                  .test3Score(rs.getInt("test3_score"))
                  .averageTestScore(rs.getInt("average_score"))
                  .build();

              PracticalSkills practicalSkills = PracticalSkills.builder()
                  .PsId(rs.getInt("ps_id"))
                  .wpsScore(rs.getInt("wps_score"))
                  .disScore(rs.getInt("dis_score"))
                  .build();

              SoftSkills softSkills = SoftSkills.builder()
                  .SsId(rs.getInt("ss_id"))
                  .pctScore(rs.getInt("pct_score"))
                  .tmwScore(rs.getInt("tmw_score"))
                  .pslScore(rs.getInt("psl_score"))
                  .comScore(rs.getInt("com_score"))
                  .build();

              OverallRating overallRating = OverallRating.builder()
                  .OrId(rs.getInt("or_id"))
                  .ckRating(rs.getInt("ck_rating"))
                  .psRating(rs.getInt("ps_rating"))
                  .ssRating(rs.getInt("ss_rating"))
                  .totalRating(rs.getInt("total_rating"))
                  .build();

              // Note: For attendance, since it can have multiple records, it's better to fetch it in a separate query.
              // However, if you still want it in the same query, you'll need to handle it differently.
              log.info("Retreiving Trainees profile");
              return TraineeProfile.builder()
                  .trainee(trainee)
                  .classroomKnowledge(classroomKnowledge)
                  .practicalSkills(practicalSkills)
                  .softSkills(softSkills)
                  .overallRating(overallRating)
                  // .attendanceList(attendanceList)  // Handle this separately
                  .build();
          }
      });
  }


}

