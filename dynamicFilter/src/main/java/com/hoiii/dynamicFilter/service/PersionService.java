package com.hoiii.dynamicFilter.service;

import com.hoiii.dynamicFilter.entity.Persion;
import com.hoiii.dynamicFilter.repository.PersionRepository;
import com.hoiii.dynamicFilter.specificationAndFilter.SpecificationPersion;
import jakarta.persistence.criteria.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

@Service
public class PersionService {

    private PersionRepository persionRepository;
    private SpecificationPersion specificationPersion;

    public PersionService(PersionRepository persionRepository, SpecificationPersion specification) {
        this.persionRepository = persionRepository;
        this.specificationPersion =  specification;
    }


    //in here we mentioning the all parameters that passes from the URL, here we mentioned page and size also
    public Page<Persion> getAll(String firstName,String lastName,int age,String email,String companyName,
                                 String sortBy,String order,int page,int size) {


        //here first we create the object of Specification interface and calling the each method thatw e declaed in the
        //Specifucation class
        //and one thing we need to consider the method inside the specification class is static so we need to call the mehods with class name
        Specification<Persion> specification_obj = Specification.where(SpecificationPersion.searchByFirstName(firstName)
                .and(SpecificationPersion.searchByLastName(lastName))
                .and(SpecificationPersion.searchByAge(age))
                .and(SpecificationPersion.searchByEmail(email))
                .and(SpecificationPersion.searchByCompanyName(companyName)));

        //Here we declaring the sort object
        Sort sort = order.equals("asc") ? Sort.by(sortBy).ascending() : Sort.by(sortBy).descending();
        Pageable pageable = PageRequest.of(page, size, sort);
        return persionRepository.findAll(specification_obj, pageable);


    }


}
