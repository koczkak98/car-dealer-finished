package com.programozzteis.cardealer.cardealer.system;

import java.util.Map;

import com.programozzteis.cardealer.cardealer.customer.ICustomerRepository;
import com.programozzteis.cardealer.cardealer.salesmans.ISalesmansRepo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class WelcomeHandler {

	private ISalesmansRepo smanRepo;
	private ICustomerRepository customerRepo;


	public WelcomeHandler(ISalesmansRepo smanRepo, ICustomerRepository customerRepo) {
		super();
		this.smanRepo = smanRepo;
		this.customerRepo = customerRepo;
	}

	@GetMapping("/")
	public String welcome(Map<String, Object> model)
	{
		/** show all default users */


		/** ADMIN */

		/** SALESMANS */
		model.put("salesmans", this.smanRepo.findAll() );

		/** CUSTOMERS */
		model.put("customers", this.customerRepo.findAll() );


		return "welcome";
	}


}
