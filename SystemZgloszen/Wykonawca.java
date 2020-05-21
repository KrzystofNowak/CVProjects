package com.company;

public class Wykonawca
{

    public String wykonawca;

    public Wykonawca(String wykonawca)
    {
        this.wykonawca = wykonawca;
    }

    public void zmieńStatus(int numer_zgłoszenia)
    {
        Sortowanie.zgłoszenia.get(numer_zgłoszenia).status = "Zrealizowano";
    }


    public String toString()
    {
        return this.wykonawca;
    }
}
