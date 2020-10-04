package com.programozzteis.cardealer.cardealer.salesmans;

import com.programozzteis.cardealer.cardealer.car.Car;
import com.programozzteis.cardealer.cardealer.car.CarType;
import com.programozzteis.cardealer.cardealer.car.ICarRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
import java.util.Map;

@Controller
public class SalesmanController {

    private ISalesmansRepo smanRepo;
    private ICarRepository carRepo;


    public SalesmanController(ISalesmansRepo smanRepo, ICarRepository carRepo) {
        super();
        this.smanRepo = smanRepo;
        this.carRepo = carRepo;
    }


    @GetMapping("/salesman/{salesmanId}")
    public String showSalesman(
            @PathVariable(name = "salesmanId") int smanId,
            Map<String, Object> model
    )
    {

        /** SALESMAN */
        Salesman sman = this.smanRepo.findById(smanId);
        model.put( "salesman", sman );

        /** CARS OF SALESMAN */
        List<Car> cars = sman.getCars();
        model.put( "cars" , cars );


        return "salesman/salesmanDetails.html";
    }


    @GetMapping("/salesman/find")
    public String startFindSalesman(Map<String, Object> model)
    {
        Salesman newSalesman = new Salesman();
        model.put( "salesman" , newSalesman );

        return "salesman/findSalesman";
    }


    @GetMapping("/salesman")
    public String finishFindSalesman(Salesman sman, Map<String, Object> model)
    {
        String destination = "";
        String searchResult = "";


        /** Read every Salesman from DB, which contains name */
        List<Salesman> smanResults = this.smanRepo.findByName( sman.getName() );


        if(smanResults.size() == 1)
        {
            destination = "redirect:/salesman/" + smanResults.get(0).getId();
        }
        else
        {
            destination = "salesman/findSalesman";

            searchResult = "Zero or Multiple results are found for Salesman Name: " + sman.getName();
            model.put( "searchResult" , searchResult);
        }


        return destination;
    }


    @GetMapping("/salesman/*/new") // * Van ott egy adat amit nem használunk.
    public String startCreateNewAd(Map<String, Object> model)
    {
        /** CAR */
        Car car = new Car();
        model.put( "car" , car );

        /** CAR TYPES */
        CarType[] car_types = CarType.values();
        model.put( "car_types" , car_types);


        return "salesman/createNewAd";
    }


    @PostMapping("/salesman/{salesmanId}/new") //Nem jelenik meg az URL-ben a továbbított adat.
    public String finishCreateNewAd(
            Car car,
            @PathVariable("salesmanId") int smanId,
            Map<String, Object> model
    )
    {
        /** Update Salesman & Car references */
        Salesman sman = this.smanRepo.findById(smanId);
        sman.addCar(car);


        /** SAVE */
        this.carRepo.save(car);


        return "redirect:/salesman/" + smanId;
    }



}
