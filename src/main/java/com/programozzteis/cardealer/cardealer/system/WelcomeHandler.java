package com.programozzteis.cardealer.cardealer.system;

import java.util.Map;

import com.programozzteis.cardealer.cardealer.admin.IAdminRepository;
import com.programozzteis.cardealer.cardealer.customer.ICustomerRepository;
import com.programozzteis.cardealer.cardealer.salesmans.ISalesmansRepo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class WelcomeHandler {

	private ISalesmansRepo smanRepo;
	private ICustomerRepository customerRepo;
	private IAdminRepository adminRepo;


	public WelcomeHandler(ISalesmansRepo smanRepo, ICustomerRepository customerRepo, IAdminRepository adminRepo) {
		this.smanRepo = smanRepo;
		this.customerRepo = customerRepo;
		this.adminRepo = adminRepo;
	}

	@GetMapping("/")
	public String welcome(Map<String, Object> model)
	{
		/** show all default users */


		/** ADMIN */
		model.put("admins", this.adminRepo.findAll() );

		/** SALESMANS */
		model.put("salesmans", this.smanRepo.findAll() );

		/** CUSTOMERS */
		model.put("customers", this.customerRepo.findAll() );


		return "welcome";
	}


}
