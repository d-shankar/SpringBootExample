package com.example.mobilecharge.charge.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.mobilecharge.charge.MobileModel.Mobile;
import com.example.mobilecharge.charge.service.MobileService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController()
public class MoblleController {
	ObjectMapper mapper= new ObjectMapper();
	@Autowired
	MobileService mobileService;
	
	@GetMapping("/mobilecharge")
	public List<Mobile> getallChargeMob() throws JsonProcessingException{
		Mobile mobile= new Mobile();
		mobile.setBrand("abc");
		mobile.setChargeId(1);
		System.out.println("["+mapper.writeValueAsString(mobile)+"]");
		return mobileService.getAllCharge();
	}
	@GetMapping("/mobilecharge/{id}")
	public Optional<Mobile> getChargeById(@PathVariable int id)
	{
		return mobileService.getMobileById(id);
	}
	
	@DeleteMapping("/mobilecharge/{id}")
	public void deletebycharge(@PathVariable int id) {
		mobileService.deleteMobileRepo(id);
	}
	@PostMapping("/mobilecharge")
	public void saveCharge(@RequestBody  Mobile mobile) {
		mobileService.saveMobile(mobile);
	}
	
}
