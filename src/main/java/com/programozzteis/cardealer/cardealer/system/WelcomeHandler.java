package com.programozzteis.cardealer.cardealer.system;

import java.util.Map;

import com.programozzteis.cardealer.cardealer.salesmans.ISalesmansRepo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class WelcomeHandler {

	private ISalesmansRepo smanrepo;


	public WelcomeHandler(ISalesmansRepo smanrepo) {
		this.smanrepo = smanrepo;
	}


	@GetMapping("/")
	public String welcome(Map<String, Object> model) {
		/** show all default users */

		/** ADMIN */

		/** SALESMANS */
		model.put("salesmans", this.smanrepo.findAll());

		/** CUSTOMERS */


		return "welcome";
	}

}
