CREATE TABLE trainees (
    trainee_id INT PRIMARY KEY AUTO_INCREMENT,
    first_name VARCHAR(255) NOT NULL,
    last_name VARCHAR(255) NOT NULL,
    hire_date DATE NOT NULL,
    expected_graduation_date DATE,
    overall_rating INT
);

CREATE TABLE classroom_knowledge (
    ck_id INT PRIMARY KEY AUTO_INCREMENT,
    trainee_id INT,
    test1_score INT,
    test2_score INT,
    test3_score INT,
    average_score INT,
    FOREIGN KEY (trainee_id) REFERENCES trainees(trainee_id)
);

CREATE TABLE practical_skills (
    ps_id INT PRIMARY KEY AUTO_INCREMENT,
    trainee_id INT,
    wps_score INT,
    dis_score INT,
    FOREIGN KEY (trainee_id) REFERENCES trainees(trainee_id)
);

CREATE TABLE soft_skills (
    ss_id INT PRIMARY KEY AUTO_INCREMENT,
    trainee_id INT,
    pct_score INT,
    tmw_score INT,
    psl_score INT,
    com_score INT,
    FOREIGN KEY (trainee_id) REFERENCES trainees(trainee_id)
);

CREATE TABLE overall_ratings (
    or_id INT PRIMARY KEY AUTO_INCREMENT,
    trainee_id INT,
    ck_rating INT,
    ps_rating INT,
    ss_rating INT,
    total_rating INT,
    FOREIGN KEY (trainee_id) REFERENCES trainees(trainee_id)
);

CREATE TABLE attendance (
    attendance_id INT PRIMARY KEY AUTO_INCREMENT,
    trainee_id INT,
    date DATE NOT NULL,
    status ENUM('Present', 'Late', 'Absent') NOT NULL,
    FOREIGN KEY (trainee_id) REFERENCES trainees(trainee_id)
);
