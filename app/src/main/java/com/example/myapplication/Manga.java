package com.example.myapplication;

public class Manga {
    int digit;
    String mangaName, iconName, price;

    public int getDigit(){
        return digit;
    }

    public String getPrice(){
        return price;
    }

    public String getMangaName(){
        return mangaName;
    }

    public String getIconName(){
        return iconName;
    }

    public Manga(int digit, String price, String mangaName, String iconName){
        this.digit = digit;
        this.price = price;
        this.mangaName = mangaName;
        this.iconName = iconName;
    }
}
