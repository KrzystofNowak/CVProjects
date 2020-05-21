package com.company;

import java.time.LocalDate;
import java.util.Comparator;

public class Zgloszenie implements Comparator
{

    public int priorytet;
    public LocalDate data_zgłoszenia;
    public String funkcjonalność;
    public String opis_błędu;
    public String status;
    public String osoba_zgłaszająca;
    public String dyspozytor;
    public String wykonawca=" ";



    public Zgloszenie(LocalDate data_zgłoszenia, String opis_błędu, String osoba_zgłaszająca, String funkcjonalność)
    {
        this.data_zgłoszenia = data_zgłoszenia;
        this.opis_błędu = opis_błędu;
        this.osoba_zgłaszająca = osoba_zgłaszająca;
        this.funkcjonalność = funkcjonalność;
        this.status = "Oczekiwanie na rozpatrzenie";
    }


    public String toString()
    {
        return (this.status + "   " + this.data_zgłoszenia.toString() + "   priorytet:  " + this.priorytet  + "   " +  this. osoba_zgłaszająca + "   " +this.funkcjonalność + "    "  + this.opis_błędu);
    }




    @Override
    public int compare(Object o1, Object o2)
    {
        Zgloszenie zgłoszenie1 = (Zgloszenie) o1;
        Zgloszenie zgłoszenie2 = (Zgloszenie) o2;

        return Integer.compare(zgłoszenie1.status.length(),zgłoszenie2.status.length());
    }
}
