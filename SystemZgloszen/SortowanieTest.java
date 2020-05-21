package com.company;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class SortowanieTest {

    @Test
    void sortowanieStatus() {
        int miesiac = 3;
        int dzien = 1;
        int rok = 2020;
        Sortowanie.zgłoszenia.add(new Zgloszenie(LocalDate.of(rok,miesiac,dzien),"cos","ja ","mleko"));
        Sortowanie.zgłoszenia.add(new Zgloszenie(LocalDate.of(rok,miesiac,dzien),"los","krzys ","kacczka"));
        Sortowanie.zgłoszenia.add(new Zgloszenie(LocalDate.of(rok,miesiac,dzien),"numeros","ksawy ","mordeczka "));
        Sortowanie.zgłoszenia.get(0).status = "Zrealizowano";
        Sortowanie.zgłoszenia.get(1).status = "Oczekiwanie na rozpatrzenie";
        Sortowanie.zgłoszenia.get(2).status = "Do zrealizowania";
        Sortowanie.sortowanieStatus(Sortowanie.zgłoszenia);
        Assert.assertEquals("Oczekiwanie na rozpatrzenie", Sortowanie.zgłoszenia.get(2).status);

    }
}