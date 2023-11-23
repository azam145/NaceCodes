package com.example.hclexercise.service;

import com.example.hclexercise.entity.NaceCodes;
import com.example.hclexercise.repository.NaceRepository;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NaceCodeService {

  @Autowired
  private NaceRepository repository;

  /**
   *
   * @param order
   * @return
   */
  public Optional<NaceCodes> getNaceCode(Long order) {
    return repository.findById(order);
  }

  /**
   *
   * @param order
   * @return
   */
  public Optional<NaceCodes> addNaceCode(NaceCodes order) {
    return Optional.of(repository.save(order));
  }


  /**
   *
   * @param order
   * @return
   */
  public Optional<NaceCodes> updateNaceCode(NaceCodes order) {
    if(repository.existsById(order.getOrder())) {
      repository.deleteById(order.getOrder());
      repository.save(order);
      return Optional.of(order);
    }
    return Optional.empty();
  }


  /**
   * To  make idempotent not adding any further checks.
   * @param order
   * @return
   */
  public void deleteNaceCode(Long order) {
    repository.deleteById(order);
  }


}
