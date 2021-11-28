package com.rk.automobile;

public class Validation {
    public static Boolean isEmpty(String str) {
        if (str == null || str.isEmpty() || str == "") {
            return true;
        } else {
            return false;
        }
    }

    public static Boolean isNotYear(String annee) {
        if (isEmpty(annee)) {
            return true;
        } else {
            if(annee.length() != 4) {
                return true;
            } else {
                for (char c: annee.toCharArray()) {
                    try {
                        Integer.parseInt(String.valueOf(c));
                    } catch (Exception e) {
                        return true;
                    }
                }
                return false;
            }
        }
    }

    public static Boolean isNotPrice(String price) {
        for (char c: price.toCharArray()) {
            try {
                Integer.parseInt(String.valueOf(c));
            } catch (Exception e) {
                return true;
            }
        }
        return false;
    }
}
