package com.example.myapplication;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;


public class TestDataProvider {
    public static Map<Integer, String> generateMangos() {
        Map<Integer, String> title = new LinkedHashMap<Integer, String>();

        title.put(1, "Cory in the house");
        title.put(2, "Pengu in the city");
        title.put(3, "Boku no pico");
        title.put(4, "Naruto");
        title.put(5, "One Piece");
        title.put(6, "Bleach");
        return title;
    }
    public static Map<Integer, String> generateMangoCost() {
        Map<Integer, String> cost = new LinkedHashMap<Integer, String>();

        cost.put(1, "420");
        cost.put(2, "21");
        cost.put(3, "69");
        cost.put(4, "10");
        cost.put(5, "12");
        cost.put(6, "14");
        return cost;
    }

    public static List<Manga> getManga(){
        List<Manga> mangaList = new ArrayList<Manga>();
        Map<Integer, String> cost = generateMangoCost();
        Map<Integer, String> title = generateMangos();
        for (Integer key : title.keySet()){
            int digit = key;
            String price = cost.get(key);
            String mangaName = title.get(key);
            String icon = "icon" + String.valueOf(key);

            Manga n = new Manga(digit, price, mangaName, icon);
            mangaList.add(n);
        }
        return mangaList;
    }
}
