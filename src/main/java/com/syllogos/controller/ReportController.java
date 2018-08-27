package com.syllogos.controller;

import com.syllogos.model.RodoClass;
import com.syllogos.service.RodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
public class ReportController {

	@Autowired
	private RodoService rodoService;

	@RequestMapping(value = "availableClasses", method = RequestMethod.GET)
	public ArrayList<RodoClass> getAllRodoClasses() {
		return rodoService.getAllRodoClasses();
	}
}
