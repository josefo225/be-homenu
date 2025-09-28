package com.shk.homenu.repository.entity;

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
public class Dish {

	private Long id;
	private String group;
	private String name;
	private int quantity;

}
