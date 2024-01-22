package com.example.money_exchange;

import android.graphics.drawable.Drawable;

public class DivisaM {

    public String divisaName;
    public String Change;
    public Drawable divisaLogo;


    public DivisaM(String divisaName, String Change,Drawable divisaLogo) {
        this.divisaName = divisaName;
        this.Change = Change;
        this.divisaLogo =divisaLogo;

    }

    public String getDivisaName() {
        return divisaName;
    }

    public String getChange() {
        return Change;
    }

    public Drawable getDivisaLogo() {return divisaLogo;}

}