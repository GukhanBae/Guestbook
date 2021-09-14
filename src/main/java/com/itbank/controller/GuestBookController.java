package com.itbank.controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.itbank.model.GuestBookDTO;
import com.itbank.service.GuestBookService;

@RestController	// 하위의 메서드가 @ResponseBody를 포함하도록 처리하는 어노테이션
public class GuestBookController {

	// 자바스크립트에서 전송한 요청을 자바 객체 형식으로 받으려면 RequestBody
	private ObjectMapper mapper = new ObjectMapper();
	
	@Autowired
	private GuestBookService gbs;
	
	@PostMapping(value="/")
//	@ResponseBody
	public int write(@RequestBody HashMap<String, String> map) {
		System.out.println("write !!");
		System.out.println(map);
		
		return gbs.write(map);
	}
	
	@GetMapping(value="/list", produces="application/json;charset=utf-8")
	public String list() throws JsonProcessingException {
		List<GuestBookDTO> list = gbs.selectList();
		String result = mapper.writeValueAsString(list);
		return result;
	}

}
