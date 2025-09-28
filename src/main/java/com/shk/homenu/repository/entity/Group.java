package com.shk.homenu.repository.entity;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@ToString
@Builder
public class Group {

	private Long id;
	private String name;
	private List<Dish> dishes;

}
