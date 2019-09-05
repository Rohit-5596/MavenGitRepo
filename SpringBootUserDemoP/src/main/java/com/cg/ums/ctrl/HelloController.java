package com.cg.ums.ctrl;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("rest/ums/sayhello")
public class HelloController {

	@GetMapping
	public String greetMe()
	{
		return "Rest Controller said welcome rohit";
		
	}
	
}
