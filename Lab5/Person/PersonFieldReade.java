package Person;

import Classes.*;
import Mess.Message;

import java.util.Scanner;

public class PersonFieldReade {
    private Scanner in = new Scanner(System.in);

    public String readName() {
        String str;
        while (true) {
            Message.info("Введите имя:");
            str = in.nextLine();
            if (str.trim().equals("")) {
                Message.error("Имя не может быть пустой строкой");
                continue;
            }
            if (str.trim().equals("null")) {
                Message.error("Имя не может быть null");
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
                Message.info("Введите координату Х: ");
                String str = in.nextLine();
                x = Float.parseFloat(str.trim());
                return x;
            } catch (NumberFormatException e) {
                Message.error("Координата Х должна быть числом");
            }
        }
    }

    public int readCoordinateY() {
        int y;
        while (true) {
            try {
                Message.info("Введите координату Y: ");
                String str = in.nextLine();
                y = Integer.parseInt(str.trim());
                return y;
            } catch (NumberFormatException e) {
                Message.error("Координата Y должна быть числом");
            }
        }
    }

    public Color readColor() {
        Color eyeColor;
        while (true) {
            try {
                Message.info("Выберите цвет глаз: ");
                for (Color val : Color.values()) {
                    Message.info(val.name());
                }
                String val = in.nextLine();
                if (val.trim().equals("")) {
                    Message.error("Цвет глаз не может быть пустой строкой");
                    continue;
                }
                if (val.trim().equals("null")) {
                    Message.error("Цвет глаз не может быть null");
                    continue;
                }
                eyeColor = Color.valueOf(val.trim().toUpperCase());
                return eyeColor;
            } catch (IllegalArgumentException e) {
                Message.error("Выберите значение из списка");
            }
        }
    }

    public ColorHair readColorHair() {
        ColorHair hairColor;
        while (true) {
            try {
                Message.info("Выберите цвет волос:");
                for (ColorHair val : ColorHair.values()) {
                    Message.info(val.name());
                }
                String val = in.nextLine();
                if (val.trim().equals("")) {
                    Message.error("Цвет волос не может быть пустой строкой");
                    continue;
                }
                if (val.trim().equals("null")) {
                    Message.error("Цвет волос не может быть null");
                    continue;
                }
                hairColor = ColorHair.valueOf(val.trim().toUpperCase());
                return hairColor;
            } catch (IllegalArgumentException e) {
                Message.error("Выберите значение из списка");
            }
        }
    }

    public Country readCountry() {
        Country nationality;
        while (true) {
            try {
                Message.info("Выберите национальность: ");
                for (Country val : Country.values()) {
                    Message.info(val.name());
                }
                String val = in.nextLine();
                if (val.trim().equals("")) {
                    Message.error("национальность не может быть пустой строкой");
                    continue;
                }
                if (val.trim().equals("null")) {
                    Message.error("национальность не может быть null");
                    continue;
                }
                nationality = Country.valueOf(val.trim().toUpperCase());
                return nationality;
            } catch (IllegalArgumentException e) {
                Message.error("Выберите значение из списка");
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
                Message.info("Введите координату Х: ");
                String str = in.nextLine();
                x = Long.parseLong(str.trim());
                return x;
            } catch (NumberFormatException e) {
                Message.error("Координата Х должна быть числом");
            }
        }
    }

    public long readLocationY() {
        long y;
        while (true) {
            try {
                Message.info("Введите координату Y: ");
                String str = in.nextLine();
                y = Long.parseLong(str.trim());
                return y;
            } catch (NumberFormatException e) {
                Message.error("Координата Y должна быть числом");
            }
        }
    }

    public int readLocationZ() {
        int z;
        while (true) {
            try {
                Message.info("Введите координату Z: ");
                String str = in.nextLine();
                z = Integer.parseInt(str.trim());
                return z;
            } catch (NumberFormatException e) {
                Message.error("Координата Z должна быть числом");
            }
        }
    }
}
