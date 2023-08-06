package com.epicode.GodfathersPizza.runner;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.epicode.GodfathersPizza.classes.DrinkLemonade;
import com.epicode.GodfathersPizza.classes.FoodItem;
import com.epicode.GodfathersPizza.classes.Ordine;
import com.epicode.GodfathersPizza.classes.PizzaMargherita;
import com.epicode.GodfathersPizza.classes.PizzaSalami;
import com.epicode.GodfathersPizza.classes.Tavolo;
import com.epicode.GodfathersPizza.classes.Water;
import com.epicode.GodfathersPizza.serivices.OrdineService;
import com.epicode.GodfathersPizza.serivices.TavoloService;

@Component
public class OrdineRunner implements CommandLineRunner {
	
	@Autowired TavoloService ts;
	@Autowired OrdineService os;

	@Override
	public void run(String... args) throws Exception {

		System.out.println("Run.. OrdineRunner");
		
		Tavolo t1 = ts.creaTavolo(4);
		Tavolo t2 = ts.creaTavolo(6);
		Tavolo t3 = ts.creaTavolo(2);
		
		System.out.println(t1);
		System.out.println(t2);
		System.out.println(t3);
		
		Ordine o1 = os.creaOrdine(3, t1);
		
		List<FoodItem> menu = os.getMenu();
		
		PizzaMargherita pm = (PizzaMargherita) os.getFoodItemByID(1);
		PizzaSalami ps = (PizzaSalami) os.getFoodItemByID(3);
		DrinkLemonade dlem = (DrinkLemonade) os.getFoodItemByID(4);
		Water wa = (Water) os.getFoodItemByID(5);

		os.addOrdine(pm, o1);
		os.addOrdine(pm, o1);
		os.addOrdine(dlem, o1);
		os.addOrdine(ps, o1);
		os.addOrdine(wa, o1);
		os.addOrdine(wa, o1);
		
		os.saveOrdine(o1);
		
		Ordine ordine = os.findOrdineByID(1);
		
		System.out.println("Ordine n." + ordine.getNumeroOrdine());
		System.out.println("NumeroCoperti " + ordine.getNumeroCoperti());
		System.out.println("CostoCoperto " + ordine.getCostoCoperto());
		System.out.println("OraAcquisizioneOrdine " + ordine.getOraAcquisizioneOrdine());
		System.out.println("StatoOrdine " + ordine.getStatoOrdine());
		System.out.println("Tavolo n. " + ordine.getTavolo().getNumero());

		for(FoodItem f : ordine.getOrdinato().keySet()) {
			System.out.println(f + " - " + ordine.getOrdinato().get(f));
		}
		System.out.println("Totale " + ordine.getTotale());

		
	}

}
