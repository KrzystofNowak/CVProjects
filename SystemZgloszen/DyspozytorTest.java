package com.company;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DyspozytorTest {

    @org.junit.jupiter.api.BeforeEach
    void before() {
        Osoba_zglaszajaca osoba = new Osoba_zglaszajaca("Krzysztof");
        osoba.zgłośBłąd(2020, 03, 19, "opis błędu", "funkcjonalność");
        Dyspozytor dyspozytor = new Dyspozytor("Antoni");
        dyspozytor.zmieńStatus(0);
    }
    @org.junit.jupiter.api.Test
    void zmieńStatus(){
        Assert.assertEquals("Do zrealizowania", Sortowanie.zgłoszenia.get(0).status);
    }

    @org.junit.jupiter.api.AfterEach
    void after(){
        Sortowanie.zgłoszenia.remove(0);
    }


}