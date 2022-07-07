package ru.home.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws RasimKukaiBashException {
        Scanner sc = new Scanner(System.in);
        try {
            while (true) {
                String valueAInString = sc.next();
                String action = sc.next();
                String valueBInString = sc.next();
                boolean isLatin = true;
                int valueA = 0;
                int valueB = 0;
                try {
                    valueA = Integer.parseInt(valueAInString);
                    valueB = Integer.parseInt(valueBInString);
                } catch (NumberFormatException e) {
                    valueA = parseInLatin(valueAInString);
                    valueB = parseInLatin(valueBInString);
                    isLatin = false;
                }
                if (valueA > 10 || valueA < 1 || valueB > 10 || valueB < 1) {
                    throw new RasimKukaiBashException();
                }
                switch (action) {
                    case "*": {
                        if (!isLatin) {
                            System.out.println(parseInRome(valueA * valueB));
                            break;
                        }
                        System.out.println(valueA * valueB);
                        break;
                    }
                    case "/": {
                        if (!isLatin) {
                            System.out.println(parseInRome(valueA / valueB));
                            break;
                        }
                        System.out.println(valueA / valueB);
                        break;
                    }
                    case "+": {
                        if (!isLatin) {
                            System.out.println(parseInRome(valueA + valueB));
                            break;
                        }
                        System.out.println(valueA + valueB);
                        break;
                    }
                    case "-": {
                        if (!isLatin) {
                            System.out.println(parseInRome(valueA - valueB));
                            break;
                        }
                        System.out.println(valueA - valueB);
                        break;
                    }
                    default: {
                        throw new RasimKukaiBashException();
                    }
                }
            }
        } catch (ArithmeticException | NumberFormatException e) {
            throw new RasimKukaiBashException();
        }
    }

    private static int parseInLatin(String value) throws RasimKukaiBashException {
        switch (value) {
            case "I": {
                return 1;
            }
            case "II": {
                return 2;
            }
            case "III": {
                return 3;
            }
            case "IV": {
                return 4;
            }
            case "V": {
                return 5;
            }
            case "VI": {
                return 6;
            }
            case "VII": {
                return 7;
            }
            case "VIII": {
                return 8;
            }
            case "IX": {
                return 9;
            }
            case "X": {
                return 10;
            }
            default: {
                throw new RasimKukaiBashException();
            }
        }
    }

    private static String parseInRome(int value) throws RasimKukaiBashException {
        if (value < 1) {
            throw new RasimKukaiBashException();
        }
        int remainder = value % 10;
        String result = null;
        if (remainder == value) {
            return parseRomeRemainder(remainder);
        }
        value = value - remainder;
        switch (value) {
            case 10: {
                result = "X";
                break;
            }
            case 20: {
                result = "XX";
                break;
            }
            case 30: {
                result = "XXX";
                break;
            }
            case 40: {
                result = "XL";
                break;
            }
            case 50: {
                result = "L";
                break;
            }
            case 60: {
                result = "LX";
                break;
            }
            case 70: {
                result = "LXX";
                break;
            }
            case 80: {
                result = "LXXX";
                break;
            }
            case 90: {
                result = "XC";
                break;
            }
            case 100: {
                return "C";
            }
        }
        if (remainder != 0) {
            return result + parseRomeRemainder(remainder);
        }
        return result;
    }

    private static String parseRomeRemainder(int value) {
        String result = null;
        switch (value) {
            case 1: {
                result = "I";
                break;
            }
            case 2: {
                result = "II";
                break;
            }
            case 3: {
                result = "III";
                break;
            }
            case 4: {
                result = "IV";
                break;
            }
            case 5: {
                result = "V";
                break;
            }
            case 6: {
                result = "VI";
                break;
            }
            case 7: {
                result = "VII";
                break;
            }
            case 8: {
                result = "VIII";
                break;
            }
            case 9: {
                result = "IX";
                break;
            }
            case 10: {
                result = "X";
            }
        }
        return result;
    }
}
