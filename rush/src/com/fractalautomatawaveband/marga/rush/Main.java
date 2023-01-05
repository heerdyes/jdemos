package com.fractalautomatawaveband.marga.rush;

import com.fractalautomatawaveband.marga.rush.colln.ListProcessor;
import com.fractalautomatawaveband.marga.rush.colln.SetProcessor;

import java.io.BufferedReader;
import java.io.Console;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Main {

    static Console c;
    static InputStreamReader isr;
    static BufferedReader br;
    static boolean SIGQUIT = false;

    static String rdln(String prompt) {
        System.out.printf(prompt);
        if (c == null) {
            try {
                return br.readLine();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        return c.readLine();
    }

    static void cmdproc(String cmd) {
        Scanner s = new Scanner(cmd);
        String tok0 = s.next();
        if (tok0.equals("q")) {
            SIGQUIT = true;
        } else if (tok0.equals("lst")) {
            String tok1 = s.next();
            while (s.hasNext()) {
                ListProcessor.addtolist(tok1, s.next());
            }
        } else if (tok0.equals("lists")) {
            ListProcessor.showlists();
        } else if (tok0.equals("hset")) {
            String snm = s.next();
            String styp = s.next();
            while (s.hasNext()) {
                SetProcessor.addtohset(snm, styp, s.next());
            }
        } else if (tok0.equals("tset")) {
            String snm = s.next();
            String styp = s.next();
            while (s.hasNext()) {
                SetProcessor.addtotset(snm, styp, s.next());
            }
        } else if (tok0.equals("sets")) {
            SetProcessor.showsets();
        }
        s.close();
    }

    static void cleanup() {
        System.out.println("goodbye!");
    }

    static void repl() {
        for (; !SIGQUIT; ) {
            String cli = rdln("> ");
            cmdproc(cli);
        }

        cleanup();
    }

    static void setup() {
        c = System.console();
        if (c == null) {
            isr = new InputStreamReader(System.in);
            br = new BufferedReader(isr);
        }
    }

    public static void main(String[] args) {
        setup();
        repl();
    }
}