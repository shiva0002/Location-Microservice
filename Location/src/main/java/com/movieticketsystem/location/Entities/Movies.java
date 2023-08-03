package com.movieticketsystem.location.Entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Movies {
    private String movieId;
    private String movieName;
    private String duration;
    private String about;
}
