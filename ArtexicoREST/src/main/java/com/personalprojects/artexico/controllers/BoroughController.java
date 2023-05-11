package com.personalprojects.artexico.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.personalprojects.artexico.entities.Borough;
import com.personalprojects.artexico.services.BoroughService;

@RestController
@RequestMapping("api")
@CrossOrigin({ "*", "http://localhost" })
public class BoroughController {
	@Autowired
	private BoroughService boroService;

	@GetMapping("boroughs")
	public List<Borough> index(HttpServletResponse res, HttpServletRequest req) {
		return boroService.index();
	}

}
