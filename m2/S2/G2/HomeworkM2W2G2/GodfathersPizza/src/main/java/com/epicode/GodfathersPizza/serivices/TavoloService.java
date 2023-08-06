package com.epicode.GodfathersPizza.serivices;

import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.epicode.GodfathersPizza.classes.Tavolo;
import com.epicode.GodfathersPizza.repository.TavoloRepository;

@Service
public class TavoloService {
	
	@Autowired TavoloRepository tavoloRepo;
	@Autowired @Qualifier("generaTavolo") ObjectProvider<Tavolo> tavoloProvider;
	
	
	public Tavolo creaTavolo(Integer numeroMassimoCoperti) {
		Tavolo t = tavoloProvider.getObject();
		t.setNumeroMassimoCoperti(numeroMassimoCoperti);
		tavoloRepo.save(t);
		return t;
	}

}
