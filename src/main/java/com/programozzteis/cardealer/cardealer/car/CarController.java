package com.programozzteis.cardealer.cardealer.car;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Map;

@Controller
public class CarController {

    private ICarRepository carRepo;


    public CarController(ICarRepository carRepo) {
        super();
        this.carRepo = carRepo;
    }


    @GetMapping("/advertisementList.html")
    public String showAdvertisements(Map<String, Object> model)
    {
        model.put("cars", this.carRepo.findAll() );

        return "advertisements/advertisementList.html";
    }

}
