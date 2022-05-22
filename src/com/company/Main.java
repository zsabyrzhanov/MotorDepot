package com.company;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class Main {

    public static final GsonBuilder BUILDER = new GsonBuilder();
    public static final Gson GSON = BUILDER.setPrettyPrinting().create();
    public static final Path WRITE_PATH = Paths.get("./truck.json");
    public static final Path WRITE_PATH1 = Paths.get("./driver.json");

    public static void main(String[] args) {

        Truck[] trucks = {new Truck(1, "Renault ", " ",State.BASE),
                new Truck(2, "Volvo   ", " ", State.BASE),
                new Truck(3, "DAF XT  ", " ", State.BASE),};
        Driver[] drivers = {new Driver(1, "Tilek", ""),
                new Driver(2, "Marat", ""),
                new Driver(3, "Almaz", "")};


        String allTruck = GSON.toJson(trucks);
        writeTruck(allTruck);
        System.out.println("#  | Truck      | State    | Driiver\n" +
                            "---*------------*----------*--------");
        Truck[] trucks1 = GSON.fromJson(readTtuck(), Truck[].class);
        for (Truck t : trucks1
        ) {
            System.out.println(t.toString());
        }  String allDriver = GSON.toJson(drivers);
        writeDriver(allDriver);

        try {
            Servise.carSearch();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        }

    private static void writeTruck(String obj) {
        Path write = Paths.get(String.valueOf(WRITE_PATH));
        try {
            Files.writeString(write, obj, StandardOpenOption.CREATE,
                    StandardOpenOption.WRITE);
        } catch (IOException e) {
            e.getMessage();
        }
    }

    private static void writeDriver(String obj) {
        Path write = Paths.get(String.valueOf(WRITE_PATH1));
        try {
            Files.writeString(write, obj, StandardOpenOption.CREATE,
                    StandardOpenOption.WRITE);
        } catch (IOException e) {
            e.getMessage();
        }
    }

   public static String readTtuck() {
        String json = "";
        try {
            FileReader fr = new FileReader(String.valueOf(WRITE_PATH));
            int a;
            while ((a = fr.read()) != -1) {
                json += (char) a;
            }
            return json;
        } catch (IOException e) {
            e.getMessage();
        }
        return json;
    }

   public static String readDriver() {
        String json = "";
        try {
            FileReader fr = new FileReader(String.valueOf(WRITE_PATH1));
            int a;
            while ((a = fr.read()) != -1) {
                json += (char) a;
            }
            return json;
        } catch (IOException e) {
            e.getMessage();
        }
        return json;
    }
}