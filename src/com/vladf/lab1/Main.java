package com.vladf.lab1;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    private static void Menu()
    {
        System.out.println("1.Add new product\n2.Show All\n3.Exit");
    }
private static void ClearScreen() throws IOException { //Dont work on IDA
    String os = System.getProperty("os.name");
    if(os.contains("Windows"))
        Runtime.getRuntime().exec("CLS");
    else
        Runtime.getRuntime().exec("clear");
    System.out.println("/-----------------------------------------/");
}


    private static void InputError( Product p, char type)
    {
        boolean done = false;
        do {
            Scanner ssc = new Scanner(System.in);
            if (ssc.hasNextInt()) {
                int _tmp = ssc.nextInt();
                switch (type) {
                    case ('p'):
                        p.setPrice(_tmp);
                        done=true;
                        break;
                    case ('a'):
                        p.setAmmount(_tmp);
                        done=true;
                        break;
                    case ('m'):
                        p.setMin_consig(_tmp);
                        done=true;
                        break;
                    case ('s'):
                        if(_tmp > 0 && _tmp<4) {
                            p.setShouse((byte) _tmp);
                            done = true;
                        }
                        else
                            System.out.println("We currently don't have storehouse with that number (only 1,2,3)");

                        break;

                }
            }
            else
                System.out.println("ERROR");

        }while (!done);
    }

    private static void Input(Product p)
    {
        Scanner keyboard = new Scanner(System.in);

        System.out.println("Name: ");
        p.setName(keyboard.nextLine());
        System.out.println("Manufacturer: ");
        p.setManuf(keyboard.nextLine());
        System.out.println("Price per 1: ");
        InputError(p,'p');
        System.out.println("Ammount: ");
        InputError(p,'a');
        System.out.println("Storehouse number: ");

        InputError(p,'s');
        System.out.println("Min consignment: ");
        InputError(p,'m');
    }

    public static void main(String[] args) throws IOException {
    //Product p = new Product("jh","",0,0,Product.shouse.main,0);
//        ArrayList<Product> arr = new ArrayList<>();
//        Product p1 = new Product();

        ArrayList<Product> arr = new ArrayList<>();
        Scanner sc = new Scanner(System.in);

        Menu();
        do {
            if (sc.hasNextInt()) {
                ClearScreen();
                switch (sc.nextInt()) {
                    case (1):
                        Product p = new Product();
                        Input(p);
                        arr.add(p);
                        ClearScreen();
                        Menu();
                        break;
                    case (2):
                        for (int i = 0; i < arr.size(); i++) {
                            System.out.println(arr.get(i).toString());
                        }
                        Menu();
                        break;
                    case (3):
                        System.exit(0);
                    default:
                        System.out.println("IDK this command");
                }
            }
            else
                sc.close();
        }while (true);

    }
}