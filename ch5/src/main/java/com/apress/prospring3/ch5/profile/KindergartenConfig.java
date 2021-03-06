package com.apress.prospring3.ch5.profile;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.apress.prospring3.ch5.profile.kindergarten.FoodProviderServiceImpl;;

@Configuration
@Profile(value="kindergarten")
public class KindergartenConfig {
	
	@Bean
	public FoodProviderService foodProviderService() {
		return new FoodProviderServiceImpl();
	}

}
