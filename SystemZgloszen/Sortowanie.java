package com.company;


import java.util.ArrayList;
import java.util.Comparator;

public class Sortowanie {

    public static ArrayList<Zgloszenie> zgłoszenia = new ArrayList<>();
    public static ArrayList<Osoba_zglaszajaca> osoby_zgłaszające = new ArrayList<>();
    public static ArrayList<Dyspozytor> dyspozytorzy = new ArrayList<>();
    public static ArrayList<Wykonawca> wykonawcy = new ArrayList<>();


    public static void sortowaniePriorytet(ArrayList<Zgloszenie> zgłoszeniaDoSortu)
    {
        zgłoszeniaDoSortu.sort(Comparator.comparingInt(s -> s.priorytet));

        for (int i = 0; i < zgłoszeniaDoSortu.size(); i++) {
            System.out.println();
            System.out.print(i + ". ");
            System.out.println(zgłoszeniaDoSortu.get(i));
        }
    }

    public static void sortowanieStatus(ArrayList<Zgloszenie> zgłoszeniaDoSortu)
    {
       zgłoszeniaDoSortu.sort ((s1, s2) -> s1.compare(s1,s2));

        for (int i = 0; i < zgłoszeniaDoSortu.size(); i++) {
            System.out.println();
            System.out.print(i + ". ");
          System.out.println(zgłoszeniaDoSortu.get(i));
       }

    }

    public static void zgłoszeniaUżytkownika(ArrayList<Zgloszenie> zgłoszeniaDanegoUżytkownika, Osoba_zglaszajaca osoba_zglaszajaca)
    {
        for (int i = 0; i < zgłoszeniaDanegoUżytkownika.size(); i++) {
            if (zgłoszeniaDanegoUżytkownika.get(i).osoba_zgłaszająca.equals(osoba_zglaszajaca.osoba_zgłaszająca)) {
                System.out.println();
                System.out.print(i + ". ");
                System.out.println(zgłoszeniaDanegoUżytkownika.get(i));
            }
        }
    }


}
