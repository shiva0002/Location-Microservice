package com.movieticketsystem.location.Entities;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Theatre {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private String theatreId;
	private String theatreName;
	private String theatreAddress;
    @OneToMany
    private List<Screen> screens;
}
