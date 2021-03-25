package com.sate.web.responses;

import com.sate.entities.Restaurant;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Getter
@ToString
@NoArgsConstructor
public class RetrievalResponse {

    private final List<Restaurant> restaurants = new ArrayList<>();
}
