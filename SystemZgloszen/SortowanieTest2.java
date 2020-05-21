package com.company;
import org.junit.Assert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class SortowanieTest2 {

    @BeforeEach
    void before(){
        LocalDate data = LocalDate.of(2020, 03, 19);
        Sortowanie.zgłoszenia.add(new Zgloszenie(data, "opis1", "osoba1", "funkcjonalność1"));
        Sortowanie.zgłoszenia.add(new Zgloszenie(data, "opis2", "osoba2", "funkcjonalność2"));
        Dyspozytor dyspozytor = new Dyspozytor("Ksawery");
        dyspozytor.nadajPriorytet(0, 2);
        dyspozytor.nadajPriorytet(1, 1);
    }


    @Test
    void sortowaniePriorytet1() {
        Sortowanie.sortowaniePriorytet(Sortowanie.zgłoszenia);
        Assert.assertEquals(1, Sortowanie.zgłoszenia.get(0).priorytet);
    }

    @Test
    void sortowaniePriorytet2() {
        Sortowanie.sortowaniePriorytet(Sortowanie.zgłoszenia);
        Assert.assertEquals(2, Sortowanie.zgłoszenia.get(1).priorytet);
    }

    @AfterEach
    void after() {

        Sortowanie.zgłoszenia.remove(0);
        Sortowanie.zgłoszenia.remove(0);
    }

}