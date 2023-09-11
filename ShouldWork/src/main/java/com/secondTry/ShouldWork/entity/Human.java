package com.secondTry.ShouldWork.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "human")
public class Human {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    public Integer id;

    @Column(name = "name", columnDefinition = "VARCHAR(50)")
    @JsonProperty("name")
    public String name;

    @Column(name = "company", columnDefinition = "VARCHAR(100)")
    @JsonProperty("company")
    public String company;

    @Column(name = "password", columnDefinition = "VARCHAR(20)")
    @JsonProperty("password")
    public String password;
}
