package com.epicode.GodfathersPizza.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.epicode.GodfathersPizza.classes.FoodItem;

@Repository
public interface MenuRepository extends CrudRepository<FoodItem, Long> {

}
