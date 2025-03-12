package com.hoiii.dynamicFilter.restControllerClass;

import com.hoiii.dynamicFilter.entity.Persion;
import com.hoiii.dynamicFilter.service.PersionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/persions")
public class RestControllerApp {

    private PersionService persionService;

    public RestControllerApp(PersionService persionService) {
        this.persionService = persionService;
    }


    @GetMapping("/filter")
    //GET /filter  by calling thiswe will get the default filter with: age=0, page=0, size=5, sortBy=id, order=asc
    Page<Persion> returnAll(

            //while applying filter there is lot of chances the filter will
            // //automaticaly filter our data becuase of wrong implimntation of Specification classs
           // GET /filter?firstName=John
            //GET /filter?firstName=John&lastName=Doe
            //GET /filter?age=30
            //GET /filter?email=johndoe@example.com
            //GET /filter?companyName=TechCorp
            //GET /filter?firstName=John&lastName=Doe&age=25&email=johndoe@example.com&companyName=TechCorp
            //GET /filter?page=1&size=10
            //GET /filter?sortBy=firstName&order=desc
            //GET /filter?sortBy=age&order=asc&page=2&size=5
            //GET /filter?lastName=Smith&sortBy=lastName&order=desc
            //GET /filter?email=jane.doe@example.com&sortBy=age&order=asc
            //GET /filter?companyName=InnoTech&sortBy=id&order=desc
            //GET /filter?age=30
            //GET /filter?firstName=Emma&lastName=Brown&page=3&size=10
            //GET /filter?age=25&page=1&size=20&sortBy=age&order=desc
            //GET /filter?sortBy=id&order=desc&page=0&size=10
            //GET /filter?companyName=DataSolutions&page=0&size=15
            //GET /filter?age=50
            //GET /filter?firstName=Michael&lastName=Johnson&age=40&companyName=TechNova&email=mj@technova.com&sortBy=companyName&order=asc&page=2&size=10
            //GET /filter?sortBy=email&order=asc
            //GET /filter?sortBy=lastName&order=asc&page=0&size=50
            //


                    //
                    @RequestParam(required = false) String firstName,


                           @RequestParam(required = false) String lastName,
                           @RequestParam(defaultValue = "0") int age,

                           @RequestParam(required = false) String email,
                            @RequestParam(required = false) String companyName,
                            @RequestParam(defaultValue = "0") int page,
                            @RequestParam(defaultValue = "5") int size,
                            @RequestParam(defaultValue = "id") String sortBy,
                            @RequestParam(defaultValue = "asc") String order){
    return persionService.getAll(firstName,lastName,age,email,companyName,sortBy,order,
                                         page,size);

    }


}
