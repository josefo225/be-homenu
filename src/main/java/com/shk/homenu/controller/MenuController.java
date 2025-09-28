package com.shk.homenu.controller;


import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shk.homenu.repository.entity.Group;
import com.shk.homenu.service.DishService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/api/menu")
@RequiredArgsConstructor
@Slf4j
public class MenuController {
	
	private final DishService dishService;

    @GetMapping("/bygroup")
    public List<Group> getMenuByGroup() {
    	log.info("Fetching menu grouped by category");
    	return dishService.getAllDishesByGroup();
    }

}
