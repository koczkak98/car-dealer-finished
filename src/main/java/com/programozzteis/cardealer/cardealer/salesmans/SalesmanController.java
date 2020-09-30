package com.programozzteis.cardealer.cardealer.salesmans;

import com.programozzteis.cardealer.cardealer.car.Car;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Map;

@Controller
public class SalesmanController {

    private ISalesmansRepo smanRepo;

    public SalesmanController(ISalesmansRepo smanRepo) {
        this.smanRepo = smanRepo;
    }


    @GetMapping("/salesman/find")
    public String startFindSalesman (Map<String, Object> model)
    {

        Salesman sman = new Salesman();
        model.put("salesman", sman);

        return "salesman/findSalesman";
    }

    @GetMapping("/salesman")
    public String finishFindSalesman(Salesman sman, Map<String, Object> model)
    {
        List <Salesman> smanResult = this.smanRepo.findByName(sman.getName());
        String destination = "";
        String searchResult = "";

        if(smanResult.size() == 1)
        {
            destination = "redirect:/salesman/" + smanResult.get(0).getId();
        }
        else
        {
            destination = "salesman/findSalesman";
            searchResult = "Zero or Multiple results are found. Please search again!";

            model.put("searchResult", searchResult);
        }


        return destination;
    }


    @GetMapping ("/salesman/{salesmanId}")
    public String showAds(
                    @PathVariable (name = "salesmanId") int smanId,
                    Map<String, Object> model)
    {

        /** SALESMAN */
        Salesman sman = this.smanRepo.findById(smanId);
        model.put("salesman", sman);

        /** SALESMAN CARS */
        List<Car> cars = sman.getCars();
        model.put("cars", cars);

        return "salesman/salesmanDetails.html";
    }


}
