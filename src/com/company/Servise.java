package com.company;


import java.util.Random;
import java.util.Scanner;

import static com.company.Main.*;

public class Servise {

    public static void carSearch() throws Exception {
        System.out.println("Choose on of the Truck");
        Scanner scanner = new Scanner(System.in);
        int idTruck;
        int cheng;

        Truck[] trucks = GSON.fromJson(readTtuck(), Truck[].class);
        Driver[] driver1 = GSON.fromJson(readDriver(),Driver[].class);


        while (true) {
            idTruck = scanner.nextInt();

            for (Truck truck : trucks) {
                if (truck.getId() == idTruck) {
                    System.out.println("-----------Truck INF------------");
                    System.out.println("N      : " + truck.getId() + "\nTrusk  : " + truck.gettruckName() + "\nDriver : "
                            + truck.getDriver() + "\nState  : " + truck.getState() + "\n" +
                            "Press 1 to change Driver\n" +
                            "Press 2 to send to the Route\n" +
                            "Press 3 to send to the Repairing\n");
                    cheng = scanner.nextInt();
                    if (cheng == 1) {
                        for (Driver d : driver1) {
                            if (idTruck == d.getIdDiver())
                                truck.setDriver(d.getName());
                        }
                        for (Driver t : driver1) {
                            if (idTruck == t.getIdDiver()) {
                                t.setTruckName(truck.gettruckName());

                            }
                        }
                    } else if (cheng == 2 && truck.getState() == State.BASE) {
                        truck.setState(State.ROUTE);
                        if (truck.getDriver().equals("")) {
                            throw new RuntimeException("Driver no");

                        }
                    } else if (cheng == 3 && truck.getState() == State.BASE) {
                        truck.setState(State.REPAIR);
                    } else if (cheng == 3 && truck.getState() == State.ROUTE) {
                        throw new RuntimeException("if the truck on the road cannot be repaired");
                    } else if (cheng == 2 && truck.getState() == State.REPAIR) {
                        Random random = new Random();
                        int send = random.nextInt(2);
                        switch (send) {
                            case 0:
                                truck.setState(State.BASE);
                                break;
                            case 1:
                                truck.setState(State.ROUTE);
                        }
                    } else if (cheng == 2 && truck.getState() == State.ROUTE) {
                        throw new RuntimeException("The driver is already on the road");
                    } else if (cheng == 3 && truck.getState() == State.REPAIR) {
                        throw new RuntimeException("The driver is under repair.");
                    }

                }
            }
            System.out.println("--------------------\n" +
                    "Driver changed successfully\n" +
                    "--------------------\n" +
                    "-------------Drivers-------------\n" +
                    " #  | Driver           |Truck    \n" +
                    "----*------------------*---------");

            for (Driver dr : driver1) {
                System.out.println(" " + dr);

            }
            System.out.println("-------------------------------------\n" +
                    "--------------Trucks--------------\n" +
                    " #  | Buss        | Stetes    |Driver\n" +
                    "----*-------------*-----------*---------");
            for (Truck t : trucks) {
                System.out.println(" " + t.getId() + "  | " + t.gettruckName() + "    |" + t.getState() + "       |" + t.getDriver());
            }

        }

    }


}












