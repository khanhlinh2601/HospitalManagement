/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import static java.lang.Integer.parseInt;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author tklin
 */
public class MyValidation {

    private static Scanner sc = new Scanner(System.in);

    public static int getAnInteger(String inputMsg, String errorMsg, boolean allowBlank) {
        int number = 0;
        do {
            try {
                System.out.print(inputMsg);
                String input = sc.nextLine();
                if (input.isEmpty()) {
                    if (allowBlank) {
                        return 0;
                    }
                }
                number = parseInt(input);
                return number;
            } catch (Exception e) {
                System.out.println(errorMsg);
            }
        } while (true);
    }

    //input integer in range min...max
    public static int getAnInteger(String inputMsg, String errorMsg, int lowerBound, int upperBound) {
        int n, tmp;
        if (lowerBound > upperBound) {
            tmp = lowerBound;
            lowerBound = upperBound;
            upperBound = tmp;
        }
        while (true) {
            try {
                System.out.print(inputMsg);
                n = Integer.parseInt(sc.nextLine());
                if (n < lowerBound || n > upperBound) {
                    throw new Exception();
                }
                return n;
            } catch (Exception e) {
                System.out.println(errorMsg);
            }
        }
    }

    public static double getADouble(String inputMsg, String errorMsg, double lowerBound, double upperBound) {
        double n, tmp;
        if (lowerBound > upperBound) {
            tmp = lowerBound;
            lowerBound = upperBound;
            upperBound = tmp;
        }
        while (true) {
            try {
                System.out.print(inputMsg);
                n = Double.parseDouble(sc.nextLine());
                if (n < lowerBound || n > upperBound) {
                    throw new Exception();
                }
                return n;
            } catch (Exception e) {
                System.out.println(errorMsg);
            }
        }
    }

    //Regular Expression
    public static String getID(String inputMsg, String errorMsg, String format) {
        String id;
        boolean match;
        while (true) {
            System.out.print(inputMsg);
            id = sc.nextLine().trim().toUpperCase();
            match = id.matches(format);
            if (id.length() == 0 || id.isEmpty() || match == false) {
                System.out.println(errorMsg);
            } else {
                return id;
            }
        }
    }

    public static String getString(String inputMsg, String errorMsg, boolean allowBlank) {
        String str;
        while (true) {
            System.out.print(inputMsg);
            str = sc.nextLine().trim();
            if (str.length() == 0 || str.isEmpty()) {
                if (allowBlank) {
                    return "";
                } else {
                    System.out.println(errorMsg);
                }

            } else {
                return str;
            }
        }
    }

    public static Boolean getBoolean(String inputMsg, String errorMsg, boolean allowBlank) {
        Boolean result; //xem lại hàm boolean, nhập khác N vẫn chạy đượcq
        do {
            try {
                String input = getString(inputMsg, errorMsg, allowBlank);
                if (input.isEmpty() && allowBlank) {
                    return null;
                }
                result = input.toLowerCase().equals("y");
                return result;
            } catch (Exception e) {
                System.out.println(errorMsg);
            }
        } while (true);
    }

    public static String convertDateFormat(Date d) {
        SimpleDateFormat DateFor = new SimpleDateFormat("dd-MM-yyyy");
        if(d!=null) {
            return DateFor.format(d);
        } 
        return null;
    }
}
