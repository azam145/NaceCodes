package com.example.hclexercise.configuration;

import com.example.hclexercise.repository.NaceRepository;
import com.example.hclexercise.service.NaceCodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class InfraConfig {

  @Bean
  public NaceCodeService NaceCodeService() {
    return new NaceCodeService();
  }

}
