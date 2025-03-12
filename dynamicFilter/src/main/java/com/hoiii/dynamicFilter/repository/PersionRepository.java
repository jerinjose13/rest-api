package com.hoiii.dynamicFilter.repository;

import com.hoiii.dynamicFilter.entity.Persion;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

//here we no need to mention the @Repository
//here we extended the JpaSpecificationExecutor.its used for helpig the use of Specification interface
public interface PersionRepository extends JpaRepository<Persion, Long> , JpaSpecificationExecutor<Persion> {

    //we need pagination,thatswhy we created a return type Page<Persion> and in the findAll method we passing the
    //Pageable object
    Page<Persion>findAll(Pageable pageable);
}
