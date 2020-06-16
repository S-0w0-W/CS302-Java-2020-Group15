//package com.example.myapplication;
//
//import java.io.Serializable;
//
//public class Manga implements Serializable {
//    int digit;
//    String mangaName, iconName, price;
//
//    public int getDigit(){
//        return digit;
//    }
//
//    public String getPrice(){
//        return price;
//    }
//
//
//    public String getMangaName(){
//        return mangaName;
//    }
//
//    public String getIconName(){
//        return iconName;
//    }
//
//    public Manga(int digit, String price, String mangaName, String iconName){
//        this.digit = digit;
//        this.price = price;
//        this.mangaName = mangaName;
//        this.iconName = iconName;
//    }
//}

package com.example.myapplication;

import java.io.Serializable;

public class Manga implements Serializable {
    int digit;
    int covers[] ;
    String mangaName, iconName, price, description,descriptionL, catagory;

    public int getDigit(){
        return digit;
    }
    public int[] getCovers(){
        return covers;
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
    public String getCatagory(){
        return catagory;
    }

    public String getDescription() { return description;}
    public String getDescriptionL() { return descriptionL;}

    public Manga(int digit, String catagory, String price, String mangaName, String iconName, String description,String descriptionL){
        this.digit = digit;
        this.price = price;
        this.mangaName = mangaName;
        this.iconName = iconName;
        this.description=description;
        this.descriptionL=descriptionL;
        this.covers=covers;
        this.catagory=catagory;
    }
}

