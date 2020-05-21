package com.company;
import org.junit.Assert;

import static org.junit.jupiter.api.Assertions.*;

class Osoba_zglaszajacaTest {

    @org.junit.jupiter.api.BeforeEach
    void before(){
        Osoba_zglaszajaca osoba = new Osoba_zglaszajaca("Krzysztof");
        osoba.zgłośBłąd(2020, 03, 19, "opis błędu", "funkcjonalność");
    }




    @org.junit.jupiter.api.Test
    void zgłośBłąd1() {
        Assert.assertNotNull(Sortowanie.zgłoszenia.get(0));
    }
    @org.junit.jupiter.api.Test
    void zgłośBłąd2() {
        Assert.assertEquals("Krzysztof", Sortowanie.zgłoszenia.get(0).osoba_zgłaszająca);
    }
    @org.junit.jupiter.api.Test
    void zgłośBłąd3() {
        Assert.assertEquals(1, Sortowanie.zgłoszenia.size());
    }





    @org.junit.jupiter.api.AfterEach
    void after(){
        Sortowanie.zgłoszenia.remove(0);
    }

}