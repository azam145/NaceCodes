package com.example.hclexercise;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;

import com.example.hclexercise.entity.NaceCodes;
import com.example.hclexercise.repository.NaceRepository;
import com.example.hclexercise.service.NaceCodeService;
import java.util.Optional;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class ServiceTest {
  @InjectMocks
  private NaceCodeService service;

  @Mock
  private NaceRepository repos;


  @Test
  public void getById_ValidId() {
    given(repos.findById(any())).willReturn(Optional.ofNullable(buildNaceObject()));

    Optional<NaceCodes> nacCodes = service.getNaceCode(1234L);
    assertEquals(nacCodes.get().getOrder(), 1234L);
  }

  NaceCodes buildNaceObject() {
    return NaceCodes.builder().Order(1234L).build();
  }

}
