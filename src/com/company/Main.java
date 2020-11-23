package com.company;
import JavaTeacherLib.MyLang;
import JavaTeacherLib.Node;

import java.util.Arrays;
import java.util.HashSet;

public class Main {

    static void printEpsNonterminals(MyLang lang) {
        HashSet<Integer> S = new HashSet<>();
        int[] nonterminals = lang.getNonTerminals();
        for(Node node :  lang.getLanguarge()) {
            if (node.getRoole().length == 1) {
                for(int id: nonterminals) {
                    if(id == node.getRoole()[0]) {
                        S.add(node.getRoole()[0]);
                    }
                }
            }
        }
        int m = S.size();
        while (true) {
            for(Node node :  lang.getLanguarge()) {
                for(int i = 1; i < node.getRoole().length; i++) {
                    if (S.contains(node.getRoole()[i])) {
                        S.add(node.getRoole()[0]);
                    }
                }
            }
            if(m == S.size()) break;
            m = S.size();
        }
        Object[] res = S.toArray();
        lang.setEpsilonNonterminals(Arrays.stream(res).mapToInt(t -> (int) t).toArray());
        for(int r: S) {
            System.out.println(lang.getLexemaText(r));
        }
    }

    public static void main(String[] args) {
        JavaTeacherLib.MyLang a = new MyLang("GR.txt", 1);
        printEpsNonterminals(a);
        a.printEpsilonNonterminals();
    }
}
