package com.example.hclexercise.controller;

import com.example.hclexercise.entity.NaceCodes;
import com.example.hclexercise.service.NaceCodeService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Tag(name = "NACE description API")
public class NaceController {

  @Autowired
  private NaceCodeService naceSvc;

  /**
   * @param order
   * @return
   */
  @Operation(summary = "Get a NACE description by Order number", description = "Returns detailed description")
  @ApiResponses(value = {
    @ApiResponse(responseCode = "200", description = "Successfully retrieved"),
    @ApiResponse(responseCode = "404", description = "Not found - The product was not found")
  })
  @GetMapping("/details")
  public ResponseEntity<NaceCodes> getNaceCodes(@Param("Order") Long order) {
    Optional<NaceCodes> response = naceSvc.getNaceCode(order);
    if (response.isPresent()) {
      return new ResponseEntity(response.get(), HttpStatus.OK);
    }
    return new ResponseEntity("", HttpStatus.NOT_FOUND);
  }

  /**
   * @param order
   * @return
   */
  @Operation(summary = "Add a NACE description by Order number", description = "Returns detailed description")
  @ApiResponses(value = {
    @ApiResponse(responseCode = "200", description = "Successfully added"),
    @ApiResponse(responseCode = "400", description = "Bad request")
  })
  @PostMapping("/add")
  public ResponseEntity<NaceCodes> addNaceCodes(@RequestBody NaceCodes order) {
    Optional<NaceCodes> response = naceSvc.addNaceCode(order);
    if (response.isPresent()) {
      return new ResponseEntity(response.get(), HttpStatus.OK);
    }
    return new ResponseEntity("", HttpStatus.BAD_REQUEST);
  }

  /**
   * @param order
   * @return
   */
  @Operation(summary = "Delete a NACE description by Order number", description = "returns status codes")
  @ApiResponses(value = {
    @ApiResponse(responseCode = "200", description = "Successfully deleted")
  })

  @DeleteMapping("/delete")
  public ResponseEntity<String> deleteNaceCodes(@Param("Order") Long order) {
    naceSvc.deleteNaceCode(order);
    return new ResponseEntity("", HttpStatus.OK);
  }

  /**
   *
   * @param order
   * @return
   */
  @Operation(summary = "update a NACE description by Order number", description = "returns status codes and the updated Nace description")
  @ApiResponses(value = {
    @ApiResponse(responseCode = "200", description = "Successfully updated"),
    @ApiResponse(responseCode = "404", description = "Not found - The product was not found")
  })
  public ResponseEntity<NaceCodes> updateNaceCodes(@RequestBody NaceCodes order) {
    Optional<NaceCodes> response = naceSvc.updateNaceCode(order);
    if (response.isPresent()) {
      return new ResponseEntity(response.get(), HttpStatus.OK);
    }
    return new ResponseEntity("", HttpStatus.NOT_FOUND);
  }
}