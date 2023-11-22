package com.example.hclexercise;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.doNothing;

import com.example.hclexercise.controller.NaceController;
import com.example.hclexercise.entity.NaceCodes;
import com.example.hclexercise.service.NaceCodeService;
import java.util.Optional;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@SpringBootTest
class HclExerciseApplicationTests {

	@InjectMocks
	NaceController naceContrlr;

	@Mock
	NaceCodeService service;


	@Test
	void getTest() {

		given(service.getNaceCode(any())).willReturn(Optional.ofNullable(buildNaceObject()));

		ResponseEntity<NaceCodes> resp = naceContrlr.getNaceCodes(1234L);
		assertEquals(resp.getStatusCode(), HttpStatus.OK);
		assertEquals(resp.getBody().getOrder(), 1234L);
	}

	@Test
	void postTest() {

		given(service.addNaceCode(any())).willReturn(Optional.ofNullable(buildNaceObject()));

		ResponseEntity<NaceCodes> resp = naceContrlr.addNaceCodes(buildNaceObject());
		assertEquals(resp.getStatusCode(), HttpStatus.OK);
		assertEquals(resp.getBody().getOrder(), 1234L);
	}


	@Test
	void updateTestNotFound() {

		ResponseEntity<NaceCodes> resp = naceContrlr.updateNaceCodes(buildNullNaceObject());
		assertEquals(resp.getStatusCode(), HttpStatus.NOT_FOUND);
		assertEquals(resp.getBody(), "");
	}

	@Test
	void updateTestFound() {

		given(service.updateNaceCode(any())).willReturn(Optional.ofNullable(buildNaceObject()));


		ResponseEntity<NaceCodes> resp = naceContrlr.updateNaceCodes(buildNaceObject());
		assertEquals(resp.getStatusCode(), HttpStatus.OK);
		assertEquals(resp.getBody().getOrder(), 1234L);
	}

	@Test
	void deleteTest() {
		doNothing().when(service).deleteNaceCode(any());
		ResponseEntity<String> resp = naceContrlr.deleteNaceCodes(1234L);
		assertEquals(resp.getStatusCode(), HttpStatus.OK);
		assertEquals(resp.getBody(), "");
	}

	NaceCodes buildNaceObject() {
		return NaceCodes.builder().Order(1234L).build();
	}

	NaceCodes buildNullNaceObject() {
		return NaceCodes.builder().Order(1234L).build();
	}

}
