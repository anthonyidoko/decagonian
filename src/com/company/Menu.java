package com.company;

import java.util.ArrayList;
import java.util.HashMap;

public class Menu {


    public static void displayMenu(HashMap<Integer,String>cinemaMenu){
            for (int menuItem = 0; menuItem < cinemaMenu.size(); menuItem++){
                if(menuItem != 0){
                    System.out.println(menuItem + ". " + cinemaMenu.get(menuItem));
                }
            }
            System.out.println(0 + ". " + cinemaMenu.get(0));
            System.out.println("Select a menu");
            System.out.print("> ");
        }
}

