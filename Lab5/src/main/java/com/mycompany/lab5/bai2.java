/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.lab5;

/**
 *
 * @author ICT
 */
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class bai2 {
    private static final Scanner sc = new Scanner(System.in);
    private static final List<String> list = new ArrayList<>();

    public static void main(String[] args) {
        int choice;
        do {
            menu();
            choice = chon();
            switch (choice) {
                case 1 -> nhap();
                case 2 -> xuat();
                case 3 -> ngaunhien();
                case 4 -> sapXepGiam();
                case 5 -> xoaTheoTen();
                case 6 -> System.out.println("Ket thuc chuong trinh!");
                default -> System.out.println("Lua chon khong hop le!");
            }
            System.out.println();
        } while (choice != 6);
    }

    private static void menu() {
        System.out.println("=== BAI 2: DANH SACH HO TEN ===");
        System.out.println("1. Nhap danh sach ho ten");
        System.out.println("2. Xuat danh sach");
        System.out.println("3. Xuat danh sach ngau nhien");
        System.out.println("4. Sap xep giam dan va xuat danh sach");
        System.out.println("5. Tim va xoa ho ten");
        System.out.println("6. Ket thuc");
        System.out.print("Chon chuc nang: ");
    }

    private static int chon() {
        try {
            return Integer.parseInt(sc.nextLine().trim());
        } catch (NumberFormatException e) {
            return -1;
        }
    }

    private static void nhap() {
        System.out.println("Nhap ho ten (de trong va Enter de dung):");
        while (true) {
            System.out.print("Ho ten: ");
            String name = sc.nextLine().trim();
            if (name.isEmpty()) break;
            list.add(name);
        }
    }

    private static void xuat() {
        if (list.isEmpty()) {
            System.out.println("Danh sach rong.");
            return;
        }
        System.out.println("Danh sach ho ten:");
        for (String s : list) {
            System.out.println(" - " + s);
        }
    }

    private static void ngaunhien() {
        if (list.isEmpty()) {
            System.out.println("Danh sach rong.");
            return;
        }
        Collections.shuffle(list);
        System.out.println("Da xao tron danh sach:");
        xuat();
    }

    private static void sapXepGiam() {
        if (list.isEmpty()) {
            System.out.println("Danh sach rong.");
            return;
        }
        Collections.sort(list);      // tang dan
        Collections.reverse(list);   // dao thanh giam dan
        System.out.println("Da sap xep giam dan:");
        xuat();
    }

    private static void xoaTheoTen() {
        if (list.isEmpty()) {
            System.out.println("Danh sach rong.");
            return;
        }
        System.out.print("Nhap ho ten can xoa: ");
        String target = sc.nextLine().trim();
        boolean removed = false;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).equalsIgnoreCase(target)) {
                list.remove(i);
                removed = true;
                break;
            }
        }
        System.out.println(removed ? "Da xoa: " + target : "Khong tim thay: " + target);
    }
}
