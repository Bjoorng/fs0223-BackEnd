package com.epicode.GodfathersPizza.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.epicode.GodfathersPizza.classes.Tavolo;

@Repository
public interface TavoloRepository extends CrudRepository<Tavolo, Integer> {

}
