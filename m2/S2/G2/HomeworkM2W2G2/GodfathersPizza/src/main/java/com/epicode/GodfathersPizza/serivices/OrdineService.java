package com.epicode.GodfathersPizza.serivices;

import java.util.List;

import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.epicode.GodfathersPizza.classes.FoodItem;
import com.epicode.GodfathersPizza.classes.Menu;
import com.epicode.GodfathersPizza.classes.Ordine;
import com.epicode.GodfathersPizza.classes.Tavolo;
import com.epicode.GodfathersPizza.repository.MenuRepository;
import com.epicode.GodfathersPizza.repository.OrdineRepository;
import com.epicode.GodfathersPizza.repository.TavoloRepository;

@Service
public class OrdineService {
	
	@Autowired TavoloRepository tavoloRepo;
	@Autowired MenuRepository menuRepo;
	@Autowired OrdineRepository ordineRepo;
	
	@Autowired @Qualifier("generaOrdine") ObjectProvider<Ordine> ordineProvider;
	@Autowired @Qualifier("menupizzeria") private ObjectProvider<Menu> menuProvider;
	
	public Ordine creaOrdine(Integer numeroCoperti, Tavolo tavolo) {
		tavolo.setOccupato(true);
		Ordine o = ordineProvider.getObject();
		o.setNumeroCoperti(numeroCoperti);
		o.setTavolo(tavolo);
		tavoloRepo.save(tavolo);
		ordineRepo.save(o);
		return o;
	}

	public void addOrdine(FoodItem item, Ordine o) {
		o.addMeunuItem(item);
		System.out.println(item.getName() + " aggiunto al tuo ordine n." + o.getNumeroOrdine());
	}
	
	public List<FoodItem> getMenu() {
		return (List<FoodItem>) menuRepo.findAll();
	}
	
	public FoodItem getFoodItemByID(long id) {
		return menuRepo.findById(id).get();
	}
	
	public Ordine findOrdineByID(int id) {
		return ordineRepo.findById(id).get();
	}
	
	public void saveOrdine(Ordine o) {
		ordineRepo.save(o);
	}
}
