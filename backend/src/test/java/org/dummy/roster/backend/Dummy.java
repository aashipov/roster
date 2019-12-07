package org.dummy.roster.backend;


import org.junit.Test;

import java.util.Currency;

public class Dummy {

    @Test
    public void dummy(){
        Currency currency = Currency.getInstance("RUR");
        System.out.println(currency);
    }
}
