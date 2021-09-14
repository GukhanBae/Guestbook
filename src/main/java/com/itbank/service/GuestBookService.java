package com.itbank.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itbank.model.GuestBookDAO;
import com.itbank.model.GuestBookDTO;

@Service
public class GuestBookService {

	@Autowired
	private GuestBookDAO dao;
	
	public int write(HashMap<String, String> map) {
		return dao.write(map);
	}

	public List<GuestBookDTO> selectList() {
		return dao.selectList();
	}

}
