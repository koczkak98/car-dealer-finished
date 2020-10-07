package com.programozzteis.cardealer.cardealer.admin;

import com.programozzteis.cardealer.cardealer.car.Car;
import com.programozzteis.cardealer.cardealer.car.ICarRepository;
import com.programozzteis.cardealer.cardealer.customer.Customer;
import com.programozzteis.cardealer.cardealer.customer.ICustomerRepository;
import com.programozzteis.cardealer.cardealer.salesmans.ISalesmansRepo;
import com.programozzteis.cardealer.cardealer.salesmans.Salesman;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
import java.util.Map;

@Controller
public class AdminController {

    private IAdminRepository adminrepo;
    private ISalesmansRepo smanRepo;
    private ICustomerRepository custRepo;
    private ICarRepository carRepo;

    public AdminController(IAdminRepository adminrepo, ISalesmansRepo smanRepo,
                           ICustomerRepository custRepo, ICarRepository carRepo)
    {
        this.adminrepo = adminrepo;
        this.smanRepo = smanRepo;
        this.custRepo = custRepo;
        this.carRepo = carRepo;
    }

    /** SHOW */
    @GetMapping ("/admin/{adminId}")
    public String showAd (
            @PathVariable("adminId") int adminId,
            Map<String, Object> model)
    {

        /** Admin */
        Admin admin = this.adminrepo.findById(adminId);
        model.put("admins", admin);

        /** Salesman */
        model.put("salesmans", this.smanRepo.findAll() );

        /** Customer */
        model.put("customers", this.custRepo.findAll() );

        /** Car */
        model.put("cars", this.carRepo.findAll() );

        return "admins/adminDetails";
    }

    /** DELETE */

    /** Customer */
    @GetMapping("/admin/{adminId}/deletecust/{custId}")
    public String custDelete (
            @PathVariable("adminId") int adminId,
            @PathVariable ("custId") int custId,
            Map<String, Object> model
            )
    {
        /** search */
        Admin admin = this.adminrepo.findById(adminId);
        Customer cust = this.custRepo.findById(custId);

        /** Delete */
        custRepo.delete(cust);

        /** Model */

        /** Admin */
        model.put("admins", this.adminrepo.findById(adminId));

        /** Salesman */
        model.put("salesmans", this.smanRepo.findAll() );

        /** Customer */
        model.put("customers", this.custRepo.findAll() );

        /** Car */
        model.put("cars", this.carRepo.findAll() );


        return "admins/adminDetails";
    }

    /** Car */
    @GetMapping("/admin/{adminId}/deletecar/{carId}")
    public String carDelete (
            @PathVariable("adminId") int adminId,
            @PathVariable ("carId") int carId,
            Map<String, Object> model
    )
    {
        /** search */
        Admin admin = this.adminrepo.findById(adminId);
        Car car = this.carRepo.findById(carId);

        /** Delete */
        carRepo.delete(car);

        /** Model */

        /** Admin */
        model.put("admins", this.adminrepo.findById(adminId));

        /** Salesman */
        model.put("salesmans", this.smanRepo.findAll() );

        /** Customer */
        model.put("customers", this.custRepo.findAll() );

        /** Car */
        model.put("cars", this.carRepo.findAll() );


        return "admins/adminDetails";
    }

    /** Salesman */
    @GetMapping("/admin/{adminId}/deletesman/{smanId}")
    public String smanDelete (
            @PathVariable("adminId") int adminId,
            @PathVariable ("smanId") int smanId,
            Map<String, Object> model
    ) {
        /** search */
        Admin admin = this.adminrepo.findById(adminId);
        Salesman sman = this.smanRepo.findById(smanId);

        List<Car> cars = sman.getCars();

        /** Delete */


        for (int i = 0; i < cars.size(); i++)
        {
            this.carRepo.delete(cars.get(i));
        }
        smanRepo.delete(sman);

        /** Model */

        /** Admin */
        model.put("admins", this.adminrepo.findById(adminId));

        /** Salesman */
        model.put("salesmans", this.smanRepo.findAll() );

        /** Customer */
        model.put("customers", this.custRepo.findAll() );

        /** Car */
        model.put("cars", this.carRepo.findAll() );


        return "admins/adminDetails";
    }

}
