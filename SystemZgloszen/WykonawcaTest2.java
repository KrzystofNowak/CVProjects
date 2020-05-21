package com.company;
        import org.junit.Assert;
        import org.junit.jupiter.api.Test;

        import static org.junit.jupiter.api.Assertions.*;

class WykonawcaTest2 {

    @org.junit.jupiter.api.BeforeEach
    void before() {
        Osoba_zglaszajaca osoba = new Osoba_zglaszajaca("Krzysztof");
        osoba.zgłośBłąd(2020, 03, 19, "opis błędu", "funkcjonalność");
        Wykonawca wykonawca = new Wykonawca("Antoni");
        wykonawca.zmieńStatus(0);
    }
    @org.junit.jupiter.api.Test
    void zmieńStatus(){
        Assert.assertEquals("Zrealizowano", Sortowanie.zgłoszenia.get(0).status);
    }

    @org.junit.jupiter.api.AfterEach
    void after(){
        Sortowanie.zgłoszenia.remove(0);
    }


}