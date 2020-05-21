package com.company;

public class Dyspozytor
{

    public String dyspozytor;


    public Dyspozytor(String dyspozytor)
    {
        this.dyspozytor = dyspozytor;
    }

    public String toString()
    {
        return this.dyspozytor;
    }


    public void nadajPriorytet(int numer_zgłoszenia, int priorytet)
    {
        Sortowanie.zgłoszenia.get(numer_zgłoszenia).priorytet =priorytet;
    }

    public void zmieńStatus(int numer_zgłoszenia)
    {
        Sortowanie.zgłoszenia.get(numer_zgłoszenia).status = "Do zrealizowania";
    }

    public void przydzielWykonawcę(int numer_zgłoszenia, int numer_wykonawcy)
    {
        Sortowanie.zgłoszenia.get(numer_zgłoszenia).wykonawca = Sortowanie.wykonawcy.get(numer_wykonawcy).wykonawca;
    }

    public void usuńZgłoszenie(int numer_zgłoszenia)
    {
        Sortowanie.zgłoszenia.remove(numer_zgłoszenia);
    }


}
