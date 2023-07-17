package com.movieticketsystem.location.Entities;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
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
public class Screen {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String screenId;
	private String screenName;

	@OneToMany(mappedBy = "screen",cascade = CascadeType.ALL)
    private List<Seat> seats;

    @ManyToOne
    private Theatre theatre;
}
