package com.fractalautomatawaveband.marga.rush.colln;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class SetProcessor {
    static HashMap<String, Set> settab = new HashMap<>();

    public static void addtohset(String snm, String typ, String v) {
        if (!settab.containsKey(snm)) {
            switch (typ) {
                case "int":
                    settab.put(snm, new HashSet<Integer>());
                    break;
                case "str":
                    settab.put(snm, new HashSet<String>());
                    break;
            }
        }
        settab.get(snm).add(v);
    }

    public static void addtotset(String snm, String typ, String v) {
        if (!settab.containsKey(snm)) {
            switch (typ) {
                case "int":
                    settab.put(snm, new TreeSet<Integer>());
                    break;
                case "str":
                    settab.put(snm, new TreeSet<String>());
                    break;
            }
        }
        settab.get(snm).add(v);
    }

    public static void showsets() {
        System.out.println("[sets]");
        for (String k : settab.keySet()) {
            System.out.printf("%s -> %s\n", k, settab.get(k));
        }
    }
}
