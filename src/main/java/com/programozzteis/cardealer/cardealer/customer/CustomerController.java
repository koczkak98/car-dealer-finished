package com.programozzteis.cardealer.cardealer.customer;

import com.programozzteis.cardealer.cardealer.car.ICarRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Map;

@Controller
public class CustomerController {

    private ICustomerRepository customerRepo;
    private ICarRepository carRepo;

    public CustomerController(ICustomerRepository customerRepo, ICarRepository carRepo) {
        this.customerRepo = customerRepo;
        this.carRepo = carRepo;
    }

    @GetMapping("/customer/{customerId}")
    public String showCustomer (
            @PathVariable(name = "customerId") int custId,
            Map<String, Object> model)
    {

        /** Customer */
        Customer customer = this.customerRepo.findById(custId);
        model.put("customer", customer);

        /** Cars */
        model.put("cars", this.carRepo.findAll());


        return "customers/customerDetails";
    }


}
