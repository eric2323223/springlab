package com.john.springinaction.mvc;

import com.john.springinaction.service.SpitterService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.util.Map;

@Controller
public class HomeController {
	
	protected static final int DEFAULT_SPITTLES_PER_PAGE = 25;
	
	@Resource(name = "spitterService")
	private SpitterService spitterService;

    public HomeController(){}

    public HomeController(SpitterService spitterService) {
        this.spitterService = spitterService;
    }
	
	@RequestMapping({"/","/home"})
	public String showHomePage(Map<String, Object> model) {
		
		model.put("spittles", spitterService.getRecentSpittles(DEFAULT_SPITTLES_PER_PAGE));
		return "home";
	}

}
