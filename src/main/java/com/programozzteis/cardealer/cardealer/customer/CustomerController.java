package com.programozzteis.cardealer.cardealer.customer;

import com.programozzteis.cardealer.cardealer.car.Car;
import com.programozzteis.cardealer.cardealer.car.ICarRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
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
            @PathVariable("customerId") int custId,
            Map<String, Object> model)
    {

        /** Customer */
        Customer customer = this.customerRepo.findById(custId);
        model.put("customer", customer);

        /** Cars */
        model.put("cars", this.carRepo.findAll());


        return "customers/customerDetails";
    }

    @GetMapping ("/customer/{custId}/buycar/{carId}")
    public String buyCar (
            @PathVariable("custId") int custId,
            @PathVariable("carId") int carId,
            Map<String, Object> model)
    {

        /** Search Cust. & Car */
        Customer cust = this.customerRepo.findById(custId);
        Car car = this.carRepo.findById(carId);

        /** Money >= price of car */

        if (cust.getCurrentMoney() >= car.getPrice())
        {
            /** Update */
            cust.setCurrentMoney(cust.getCurrentMoney() - car.getPrice() );

            /** Delete this car from basicdata */
            carRepo.delete(car);

            /** SAVE money of cust. */
            customerRepo.save(cust);

            /** Message */
            model.put("goodNews", "Congratulation for your new CAR!"); // from customer.html
        }
        else
        {
            /** #4 Error Message */
            model.put("badNews", "Not enough money for this Car!");
        }
        List<Car> cars = carRepo.findAll();
        model.put( "cars" , cars );
        model.put( "customer" , cust);


        return "customers/customerDetails";
    }

    @GetMapping("/customer/{custId}/edit")
    public String startEditCust (
            @PathVariable ("custId") int custId,
            Map<String, Object> model
            )
    {
        Customer customer = customerRepo.findById(custId);

        model.put("customer", customer);

        return "customers/updateCustomerForm";
    }

    @PostMapping ("/customer/{custId}/edit")
    public String finishEditCust (
            @PathVariable ("custId") int custId,
            Customer customer,
            Map<String, Object> model
            )
    {
        customer.setId(custId);
        this.customerRepo.save(customer);


        return "redirect:/customer/" + custId;
    }


}
