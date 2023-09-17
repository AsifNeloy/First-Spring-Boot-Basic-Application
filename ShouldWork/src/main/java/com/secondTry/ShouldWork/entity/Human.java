package com.secondTry.ShouldWork.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Optional;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "human") //table name in the database
public class Human {
    @Id //primary key indicator
    @GeneratedValue(strategy = GenerationType.IDENTITY) //for auto increment
    @Column(name = "id") //name of the column in db

    public Integer id;

    @Column(name = "name", columnDefinition = "VARCHAR(50)") //name and type of the column in db
    @JsonProperty("name")
    public String name;

    @Column(name = "company", columnDefinition = "VARCHAR(100)")
    @JsonProperty("company")
    public String company;

    @Column(name = "password", columnDefinition = "VARCHAR(20)")
    @JsonProperty("password")
    public String password;
}
