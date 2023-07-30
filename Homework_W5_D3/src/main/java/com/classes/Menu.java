package com.classes;

import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Menu {
    private List<Pizza> menuPizza = new ArrayList<Pizza>();
    private List<Drink> menuDrink = new ArrayList<Drink>();
    private List<Topping> menuToppings = new ArrayList<Topping>();
    private List<Item> menuFranchise = new ArrayList<Item>();
}

