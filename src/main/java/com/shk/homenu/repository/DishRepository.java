package com.shk.homenu.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.shk.homenu.repository.entity.Dish;

@Repository
public class DishRepository {

	public List<Dish> findAll() {

		List<Dish> dishes = new ArrayList<>();
		
		Dish dish1 = Dish.builder()
				.id(1L)
				.group("meat")
				.name("pork")
				.quantity(2)
				.build();
		dishes.add(dish1);
		
		dish1 = Dish.builder()
				.id(1L)
				.group("meat")
				.name("pollo")
				.quantity(2)
				.build();
		dishes.add(dish1);
		
		dish1 = Dish.builder()
				.id(1L)
				.group("salad")
				.name("lettuce")
				.quantity(2)
				.build();
		dishes.add(dish1);
		
		dish1 = Dish.builder()
				.id(1L)
				.group("salad")
				.name("tomato")
				.quantity(2)
				.build();
		dishes.add(dish1);

		return dishes;

	}

}
