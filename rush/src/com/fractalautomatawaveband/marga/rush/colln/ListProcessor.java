package com.fractalautomatawaveband.marga.rush.colln;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ListProcessor {

    static HashMap<String, List<String>> listab = new HashMap<>();

    public static void addtolist(String lnm, String v) {
        if (!listab.containsKey(lnm)) {
            listab.put(lnm, new ArrayList<>());
        }
        listab.get(lnm).add(v);
    }

    public static void showlists() {
        System.out.println("[lists]");
        for (String k : listab.keySet()) {
            System.out.printf("%s -> %s", k, listab.get(k));
        }
    }
}
