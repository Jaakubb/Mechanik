package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Mechanik {
    @Autowired
    private CarList listaAut;


    @RequestMapping("/ile")
    public int ileMamyAut() {
        return listaAut.iloscAut();
    }

    @RequestMapping(
            value="/dodajAuto",
            method= RequestMethod.GET
    )
    public boolean dodajAuto(@RequestParam("n") String nazwa, @RequestParam("p") int predkosc) {
        try{
            listaAut.dodawanieZepsutychAut(new Car(nazwa,predkosc));
            return true;
        }catch (Exception e){
            return false;
        }
    }
    @RequestMapping("/lista")
    public String lista (){
        return listaAut.listaB();
    }

}
