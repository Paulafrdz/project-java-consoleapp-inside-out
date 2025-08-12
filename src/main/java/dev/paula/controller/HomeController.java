package dev.paula.controller;

import dev.paula.view.*;

public class HomeController {

    public HomeController() {
        index();
    }
    
    public void index() {
        HomeView.printMenu();
    }

}


