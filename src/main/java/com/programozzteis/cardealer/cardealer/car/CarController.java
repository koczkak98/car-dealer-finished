package com.programozzteis.cardealer.cardealer.car;

import com.programozzteis.cardealer.cardealer.salesmans.ISalesmansRepo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Map;

@Controller
public class CarController {

    private ICarRepository carRepo;

    public CarController(ICarRepository carRepo, ISalesmansRepo salesmansRepo) {
        this.carRepo = carRepo;
    }


    @GetMapping ("/advertisementList.html")
    public String showAdvertisements(Map<String, Object> model)
    {
        model.put("cars", this.carRepo.findAll());

        return "advertisements/advertisementList.html";
    }

}
