
package com.company;

import org.junit.Assert;

import java.time.LocalDate;


public class WykonawcaTest {


    @org.junit.jupiter.api.Test
    public void testCreateOsobyZglaszajace()
    {
        Sortowanie.osoby_zgłaszające.add(new Osoba_zglaszajaca("krzys"));
        int a = Sortowanie.osoby_zgłaszające.size();
        Assert.assertEquals(1,a);
    }


    @org.junit.jupiter.api.Test
    public void testCreateWykonawcy()
    {
        Sortowanie.wykonawcy.add(new Wykonawca("las"));
        int a = Sortowanie.wykonawcy.size();
        Assert.assertEquals(1,a);
    }


    @org.junit.jupiter.api.Test
    public void testCreateDyspozytorzy()
    {
        Sortowanie.dyspozytorzy.add(new Dyspozytor("las"));
        Sortowanie.dyspozytorzy.add(new Dyspozytor("nos"));
        int a = Sortowanie.dyspozytorzy.size();
        Assert.assertEquals(2,a);
    }

    @org.junit.jupiter.api.Test
    public void testCreateZgloszenia()
    {
        int miesiac = 3;
        int dzien = 1;
        int rok = 2020;
        Sortowanie.zgłoszenia.add(new Zgloszenie(LocalDate.of(rok,miesiac,dzien),"cos","ja ","mleko"));
        Sortowanie.zgłoszenia.add(new Zgloszenie(LocalDate.of(rok,miesiac,dzien),"los","krzys ","kacczka"));
        Sortowanie.zgłoszenia.add(new Zgloszenie(LocalDate.of(rok,miesiac,dzien),"numeros","ksawy ","mordeczka "));
        int a = Sortowanie.zgłoszenia.size();
        Assert.assertEquals(3,a);
    }


}

