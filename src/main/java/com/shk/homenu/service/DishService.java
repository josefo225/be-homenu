package com.shk.homenu.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.shk.homenu.repository.DishRepository;
import com.shk.homenu.repository.entity.Dish;
import com.shk.homenu.repository.entity.Group;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class DishService {

	private final DishRepository dishRepository;

	public List<Group> getAllDishesByGroup() {

		List<Dish> dishes = dishRepository.findAll();
		List<Group> groups = new ArrayList<>();
		dishes.stream().collect(Collectors.groupingBy(Dish::getGroup)).forEach((group, dishList) -> {
			Group g = Group.builder().name(group).dishes(dishList).build();
			groups.add(g);
		});

		return groups;
	}


}
