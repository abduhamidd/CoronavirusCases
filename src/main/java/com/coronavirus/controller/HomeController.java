package com.coronavirus.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.coronavirus.models.LocationStats;
import com.coronavirus.services.DataService;

@Controller
public class HomeController {
	@Autowired
	private DataService service;
	@GetMapping("/home")
	public String homePage(Model model) {
		List<LocationStats> allStats =service.getAllStats();
      int totalReportedCases = allStats.stream().mapToInt(stat->stat.getLatestTotalCases()).sum();
		model.addAttribute("locationStats",allStats);
		model.addAttribute("totalReportedCases",totalReportedCases);
		
		
		return"home";
	}

}
