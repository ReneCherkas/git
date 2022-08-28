package Parser;

import Classes.Color;
import Classes.ColorHair;
import Classes.Country;
import Mess.Message;

import java.util.Arrays;
import java.util.Locale;

public class Validation {
    public boolean validation(String[] lin, int lineNumber) {
        try {
            if (lin[0].trim().equals("") || Long.parseLong(lin[0]) <= 0) {
                Message.error("Неверный формат id у " + lineNumber + " строки");
                return false;
            }
        } catch (NumberFormatException e) {
            Message.error("Неверный формат id у " +  lineNumber + " строки");
            return false;
        }

        if (lin[1].trim().equals("") || lin[1].trim().toLowerCase(Locale.ROOT).equals("none")) {
            Message.error("Неверный формат name у " +  lineNumber + " строки");
            return false;
        }

        try {
            Float.parseFloat(lin[2]);
        } catch (NumberFormatException e) {
            Message.error("Неверный формат X у " +  lineNumber + " строки");
            return false;
        }

        try {
            Integer.parseInt(lin[3]);
        } catch (NumberFormatException e) {
            Message.error("Неверный формат Y у " +  lineNumber + " строки");
            return false;
        }

        try {
            Color.valueOf(lin[5]);
        } catch (IllegalArgumentException e) {
            Message.error("Неверный формат weaponType у " +  lineNumber + " строки");
            return false;
        }

        try {
            ColorHair.valueOf(lin[6]);
        } catch (IllegalArgumentException e) {
            Message.error("Неверный формат mood у " +  lineNumber + " строки");
            return false;
        }

        try {
            Country.valueOf(lin[7]);
        } catch (IllegalArgumentException e) {
            Message.error("Неверный формат mood у " +  lineNumber + " строки");
            return false;
        }
        try {
            Float.parseFloat(lin[8]);
        } catch (NumberFormatException e) {
            Message.error("Неверный формат X у " +  lineNumber + " строки");
            return false;
        }

        try {
            Integer.parseInt(lin[9]);
        } catch (NumberFormatException e) {
            Message.error("Неверный формат Y у " +  lineNumber + " строки");
            return false;
        }

        try {
            Float.parseFloat(lin[10]);
        } catch (NumberFormatException e) {
            Message.error("Неверный формат X у " +  lineNumber + " строки");
            return false;
        }


        return true;
    }
}