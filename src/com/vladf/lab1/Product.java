package com.vladf.lab1;

import lombok.*;

public @NoArgsConstructor /*@AllArgsConstructor*/ @ToString class Product {
    private @Setter @Getter String name;
    private @Setter @Getter String manuf;
    private @Getter int price;
    private @Getter int ammount;
    private @Getter Product.shouse shouse;
    private @Getter int min_consig;

    //I don't have another idea :D
    private static shouse sh;


    enum shouse{main,secondary,reserve}

    public boolean setPrice(int price) {
        if(price > 0 && price < 999) {
            this.price = price;
            return true;
        }
        else
            return false;
    }

    public boolean setAmmount(int ammount) {
        if(ammount > 0 && ammount < 9999) {
            this.ammount = ammount;
            return true;
        }
        else
            return false;
    }

    public boolean setShouse(byte shouseNumb) {
        //shouse sh = Product.shouse.main;
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
        return this.shouse != null;

    }

    public boolean setMin_consig(int min_consig) {
        if(min_consig > 0 /*&& min_consig < 9999*/) {
            this.min_consig = min_consig;
            return true;
        }
        else
            return false;
    }
}
