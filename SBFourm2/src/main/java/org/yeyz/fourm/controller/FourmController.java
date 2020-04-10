package org.yeyz.fourm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping(value="fourm")
public class FourmController {

	@RequestMapping(value="/")
	public String toIndex() {
		return "index";
	}
	
	
	
	
}
