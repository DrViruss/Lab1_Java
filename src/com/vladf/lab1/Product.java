package com.vladf.lab1;

import lombok.*;

public @NoArgsConstructor /*@AllArgsConstructor*/ @ToString class Product {
    private @Setter  String name;
    private @Setter  String manuf;
    private int price;
    private int amount;
    private Product.shouse shouse;
    private int min_consig;

    //I don't have another idea :D
    private static shouse sh;


    enum shouse{main,secondary,reserve}

    public void setPrice(int price) {
        if(price > 0 && price < 999) {
            this.price = price;}
    }

    public void setAmount(int amount) {
        if(amount > 0 && amount < 9999)
            this.amount = amount;
    }

    public void setShouse(byte shouseNumb) {
        switch (shouseNumb)
        {
            case ((byte)1):
                this.shouse = sh.main;
                break;
            case ((byte)2):
                this.shouse = sh.secondary;
                break;
            case ((byte)3):
                this.shouse = sh.reserve;
                break;

        }

    }

    public void setMin_consig(int min_consig) {
        if(min_consig > 0) {
            this.min_consig = min_consig;
        }
    }
}
