package com.launch.trainee.DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;
import com.launch.trainee.entity.Trainee;
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
            .expectedGraduationDate(rs.getString("expected_graduation_date"))
            .overallRating(rs.getInt("overall_rating"))
            .build();
        // @formatter:on
      }
    });
  }

}

