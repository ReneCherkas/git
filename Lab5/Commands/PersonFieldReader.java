package Commands;

import Classes.*;
import Mess.Message;

import java.util.Scanner;

public class PersonFieldReader {
    private Scanner in = new Scanner(System.in);

    public String readName() {
        String str;
        while (true) {
            Message.info("Введите имя: \n");
            str = in.nextLine();
            if (str.trim().equals("")) {
                Message.error("Имя не может быть пустой строкой\n");
                continue;
            }
            if (str.trim().equals("null")) {
                Message.error("Имя не может быть null\n");
                continue;
            }
            return str;
        }
    }


    public Coordinates readCoordinates() {
        return new Coordinates(readCoordinateX(), readCoordinateY());
    }

    public float readCoordinateX() {
        float x;
        while (true) {
            try {
                Message.info("Введите координату Х: \n");
                String str = in.nextLine();
                x = Float.parseFloat(str.trim());
                return x;
            } catch (NumberFormatException e) {
                Message.error("Координата Х должна быть числом\n");
            }
        }
    }

    public int readCoordinateY() {
        int y;
        while (true) {
            try {
                Message.info("Введите координату Y: \n");
                String str = in.nextLine();
                y = Integer.parseInt(str.trim());
                return y;
            } catch (NumberFormatException e) {
                Message.error("Координата Y должна быть числом\n");
            }
        }
    }

    public Color readColor() {
        Color eyeColor;
        while (true) {
            try {
                Message.info("Выберите цвет глаз: \n");
                for (Color val : Color.values()) {
                    Message.info(val.name());
                }
                String val = in.nextLine();
                if (val.trim().equals("")) {
                    Message.error("Цвет глаз не может быть пустой строкой\n");
                    continue;
                }
                if (val.trim().equals("null")) {
                    Message.error("Цвет глаз не может быть null\n");
                    continue;
                }
                eyeColor = Color.valueOf(val.trim().toUpperCase());
                return eyeColor;
            } catch (IllegalArgumentException e) {
                Message.error("Выберите значение из списка\n");
            }
        }
    }

    public ColorHair readColorHair() {
        ColorHair hairColor;
        while (true) {
            try {
                Message.info("Выберите цвет волос: \n");
                for (ColorHair val : ColorHair.values()) {
                    Message.info(val.name());
                }
                String val = in.nextLine();
                if (val.trim().equals("")) {
                    Message.error("Цвет волос не может быть пустой строкой\n");
                    continue;
                }
                if (val.trim().equals("null")) {
                    Message.error("Цвет волос не может быть null\n");
                    continue;
                }
                hairColor = ColorHair.valueOf(val.trim().toUpperCase());
                return hairColor;
            } catch (IllegalArgumentException e) {
                Message.error("Выберите значение из списка\n");
            }
        }
    }

    public Country readCountry() {
        Country nationality;
        while (true) {
            try {
                Message.info("Выберите национальность: \n");
                for (Country val : Country.values()) {
                    Message.info(val.name());
                }
                String val = in.nextLine();
                if (val.trim().equals("")) {
                    Message.error("национальность не может быть пустой строкой\n");
                    continue;
                }
                if (val.trim().equals("null")) {
                    Message.error("национальность не может быть null\n");
                    continue;
                }
                nationality = Country.valueOf(val.trim().toUpperCase());
                return nationality;
            } catch (IllegalArgumentException e) {
                Message.error("Выберите значение из списка\n");
            }
        }
    }

    public Location readLocation() {
        return new Location(readLocationX(), readLocationY(),readLocationZ());
    }

    public long readLocationX() {
        long x;
        while (true) {
            try {
                Message.info("Введите координату Х: \n");
                String str = in.nextLine();
                x = Long.parseLong(str.trim());
                return x;
            } catch (NumberFormatException e) {
                Message.error("Координата Х должна быть числом\n");
            }
        }
    }

    public long readLocationY() {
        long y;
        while (true) {
            try {
                Message.info("Введите координату Y: \n");
                String str = in.nextLine();
                y = Long.parseLong(str.trim());
                return y;
            } catch (NumberFormatException e) {
                Message.error("Координата Y должна быть числом\n");
            }
        }
    }

    public int readLocationZ() {
        int z;
        while (true) {
            try {
                Message.info("Введите координату Z: \n");
                String str = in.nextLine();
                z = Integer.parseInt(str.trim());
                return z;
            } catch (NumberFormatException e) {
                Message.error("Координата Z должна быть числом\n");
            }
        }
    }
}
