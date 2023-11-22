package com.example.hclexercise.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "NACE_TBL")
@Builder
public class NaceCodes {
  @Id
  @Column(name="Order")
  private Long Order;
  @Column(name="Level")
  private int Level;
  @Column(name="Code")
  private String Code;
  @Column(name="Parent")
  private String parent;
  @Column(columnDefinition = "TEXT", name="Description")
  private String description;
  @Column(columnDefinition = "TEXT", name="This item includes")
  private String includes;
  @Column(columnDefinition = "TEXT", name="This item also includes")
  private String alsoIncl;
  @Column(columnDefinition = "TEXT", name="Rulings")
  private String rulings;
  @Column(columnDefinition = "TEXT", name="This item excludes")
  private String excludes;
  @Column(columnDefinition ="varchar(255)", name="Reference to ISIC Rev 4")
  private String reference;
}
