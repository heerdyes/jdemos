package toysh;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(
                new InputStreamReader(System.in));
        Stack<Object> stk = new Stack<>();
        for (;;) {
            System.out.printf("toysh-> ");
            String cli = br.readLine();
            String[] parts = cli.split(" ");
            String cmd = parts[0];
            if (cmd.equals("q")) {
                break;
            }
            if (cmd.equals("push")) {
                String dtyp = parts[1];
                switch (dtyp) {
                    case "i":
                        int pi = Integer.parseInt(parts[2]);
                        stk.push(pi);
                        break;
                    case "s":
                        String ps = parts[2];
                        stk.push(ps);
                        break;
                }
            } else if (cmd.equals("show")) {
                System.out.println(stk);
            } else if (cmd.equals("pop")) {
                System.out.println(stk.pop());
            }
        }
    }
}
