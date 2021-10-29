package gu.market.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/admin")
public class AdminController {
	//admin관련 mapping
	@RequestMapping(value = "/adminMain")
	public String adminMain() throws Exception {
		return "admin/admin_main";
	}
}
