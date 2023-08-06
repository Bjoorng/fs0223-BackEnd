package com.epicode.GodfathersPizza.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.epicode.GodfathersPizza.classes.Ordine;

@Repository
public interface OrdineRepository extends CrudRepository<Ordine, Integer> {

}
