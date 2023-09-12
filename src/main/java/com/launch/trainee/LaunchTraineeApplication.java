package com.launch.trainee;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackageClasses = {ComponentScanMarker.class})
public class LaunchTraineeApplication {

	public static void main(String[] args) {
		SpringApplication.run(LaunchTraineeApplication.class, args);
	}

}
