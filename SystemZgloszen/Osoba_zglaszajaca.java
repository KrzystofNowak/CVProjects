package com.company;

import java.time.LocalDate;

public class Osoba_zglaszajaca
{

  public String osoba_zgłaszająca;

  public Osoba_zglaszajaca(String osoba_zgłaszająca)
  {
      this.osoba_zgłaszająca = osoba_zgłaszająca;
  }


  public void zgłośBłąd(int rok, int miesiąc, int dzień, String opis_błędu,String funkcjonalność)
  {
        LocalDate data_zgłoszenia = LocalDate.of(rok, miesiąc, dzień);
        Zgloszenie zgloszenie = new Zgloszenie(data_zgłoszenia, opis_błędu, osoba_zgłaszająca, funkcjonalność);
        Sortowanie.zgłoszenia.add(zgloszenie);
  }


  public String toString()

  {
      return this.osoba_zgłaszająca;
  }


}



