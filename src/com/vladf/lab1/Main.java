package com.vladf.lab1;

import java.io.IOException;
import java.security.spec.RSAOtherPrimeInfo;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    private static void Menu() {
        System.out.println("1.Add new product\n2.Show All\n3.Remove\n4.Exit");
    }

    private static void remove(ArrayList<Product> arr) throws IOException {
        do {
            Scanner ssc = new Scanner(System.in);
            if(ssc.hasNextInt()) {
                int _tmp = ssc.nextInt();
                if(_tmp>0) {
                    if (_tmp <= arr.size()) {
                        arr.remove(_tmp-1);
                        ClearScreen();
                        System.out.println("Succes!");
                        break;
                    }
                    else {
                        ClearScreen();
                        System.out.println("We dont have product with that numver. Abording...");
                        break;
                    }
                }
                else if(_tmp==0) {
                    ClearScreen();
                    System.out.println("Abording...");
                    break;
                }
            }
            else {
                ClearScreen();
                System.out.println("Unknown number");
            }

        }while (true);
    }

    private static void ClearScreen() throws IOException { //Dont work on IDA
       System.out.println("\033[H\033[2J");
       System.out.flush();
       System.out.println("/-----------------------------------------/");
    }

    private static void InputError(Product p, char type) {
        boolean done = false;
        do {
            Scanner ssc = new Scanner(System.in);
            if (ssc.hasNextInt()) {
                int _tmp = ssc.nextInt();
                switch (type) {
                    case ('p'):
                        p.setPrice(_tmp);
                        done = true;
                        break;
                    case ('a'):
                        p.setAmount(_tmp);
                        done = true;
                        break;
                    case ('m'):
                        p.setMin_consig(_tmp);
                        done = true;
                        break;
                    case ('s'):
                        if (_tmp > 0 && _tmp < 4) {
                            p.setShouse((byte) _tmp);
                            done = true;
                        } else
                            System.out.println("We currently don't have storehouse with that number (only 1,2,3)");

                        break;

                }
            } else
                System.out.println("ERROR");

        } while (!done);
    }

    private static void Input(Product p) {
        Scanner keyboard = new Scanner(System.in);

        System.out.println("Name: ");
        p.setName(keyboard.nextLine());
        System.out.println("Manufacturer: ");
        p.setManuf(keyboard.nextLine());
        System.out.println("Price per 1: (from 1 to 999 else set 0)");
        InputError(p, 'p');
        System.out.println("Amount: (from 1 to 9999 else set 0)");
        InputError(p, 'a');
        System.out.println("Storehouse number: ");
        InputError(p, 's');
        System.out.println("Min consignment: (bigger then 0 else set 0) ");
        InputError(p, 'm');
    }

    public static void main(String[] args) throws IOException {

        ArrayList<Product> arr = new ArrayList<>();

        Menu();
        do {
            Scanner sc = new Scanner(System.in);
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
                            System.out.println(i+1 +". " + arr.get(i).toString());
                        }
                        System.out.println("");
                        Menu();
                        break;
                    case (3):
                        System.out.println("Please input number of element (0 - abord)");
                        remove(arr);
                        Menu();
                        break;
                    case (4):
                        System.out.println("BYE");
                        System.exit(0);
                    default:
                        System.out.println("IDK this command");
                }
            }
            else
                System.out.println("Unknown command");
        }while (true);

    }


    }