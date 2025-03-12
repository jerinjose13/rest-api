package com.hoiii.dynamicFilter.specificationAndFilter;

import com.hoiii.dynamicFilter.entity.Persion;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Repository;

@Repository
public class SpecificationPersion {

    //Here the method searchByFirstName return  a Specification<Persion> type based the string we giving
    public static Specification<Persion> searchByFirstName(String firstName) {

        //Here we calling the lambda function and passing 3 parameters
        //First parameter is root(our Entity class,in here Persion), second parameter query used for helping the creation of query
        //and third parameter criteria builder will also help to giving the like or and criterias
        return ((root, query, criteriaBuilder) ->

                //if first name equal to null it return null means do not apply any filters
                //if its not null it will apply the condition that we spplied  don the criteria builder
                firstName == null ? null : criteriaBuilder.like(root.get("firstName"), "%"+firstName+"%")
        );
    }

    public static Specification<Persion> searchByLastName(String lastName) {
        return ((root, query, criteriaBuilder) ->
                lastName == null ? null : criteriaBuilder.like(root.get("lastName"), "%"+lastName+"%"));
    }

    public static Specification<Persion> searchByAge(Integer age) {
        return ((root, query, criteriaBuilder) ->
                criteriaBuilder.greaterThanOrEqualTo(root.get("age"), age));
    }
    public static Specification<Persion> searchByEmail(String email) {
        return ((root, query, criteriaBuilder) ->
                email == null ? null : criteriaBuilder.like(root.get("email"), "%"+email+"%"));
    }

    public static Specification<Persion> searchByCompanyName(String companyName) {
        return ((root, query, criteriaBuilder) ->
                companyName == null ? null :  criteriaBuilder.like(root.get("company"), "%"+companyName+"%"));
    }
}
