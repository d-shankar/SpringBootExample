package com.example.mobilecharge.charge.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.mobilecharge.charge.MobileModel.Mobile;
import com.example.mobilecharge.charge.Repository.MobileRepoditory;

@Service
public class MobileService {
	
	@Autowired
	MobileRepoditory mobRepo;
	
	public List<Mobile> getAllCharge() {
		return (List<Mobile>) mobRepo.findAll();
	}

	public Optional<Mobile> getMobileById(int id) {
		return mobRepo.findById(id);
	}
	public void saveMobile(Mobile mobile) {
		mobRepo.save(mobile);
	}
	public void deleteMobileRepo(int id) {
		mobRepo.deleteById(id);
	}
}
