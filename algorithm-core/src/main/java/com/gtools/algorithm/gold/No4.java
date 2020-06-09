package com.gtools.algorithm.gold;

public class No4 {
    public static void main(String[] args) {
        No4 n = new No4();
        System.out.println(n.oneEditAway("islander", "slander"));
        //System.out.println(n.oneEditAway("teacher", "bleacher"));
    }

    public boolean oneEditAway(String first, String second) {
        if (first == null && second == null) return true;
        int flen = first.length();
        int slen = second.length();
        if (Math.abs(flen - slen) > 1) return false;
        else if ("".equals(first) || "".equals(second)) return true;


        if (flen == slen) {
            int one = 0;
            for (int i = 0; i < first.length(); i++) {
                if (first.charAt(i) != second.charAt(i)) {
                    if (one == 0) {
                        one++;
                        continue;
                    } else {
                        return false;
                    }
                }
            }
        } else {
            String sh = null, lo = null;
            if (flen > slen) {
                sh = second;
                lo = first;
            } else {
                sh = first;
                lo = second;
            }

            int one = 0;
            int i = 0, j = 0;
            for (; i < sh.length() && j < lo.length(); ) {
                if (sh.charAt(i) != lo.charAt(j)) {
                    if (one == 0) {
                        one++;
                        j++;
                    } else {
                        return false;
                    }
                } else {
                    i++;
                    j++;
                }
            }
        }
        return true;
    }
}
