/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.lab5;

/**
 *
 * @author ICT
 */
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class bai1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Double> list = new ArrayList<>();

        System.out.println("=== BAI 1: DANH SACH SO THUC & TONG ===");
        System.out.println("Nhap so thuc, de trong va Enter de ket thuc.");

        while (true) {
            System.out.print("Nhap so: ");
            String line = sc.nextLine().trim();
            if (line.isEmpty()) break;
            try {
                double x = Double.parseDouble(line);
                list.add(x);
            } catch (NumberFormatException e) {
                System.out.println("Gia tri khong hop le. Vui long nhap so.");
            }
        }

        // Xuat danh sach
        System.out.println("\nDanh sach da nhap:");
        double sum = 0;
        for (double x : list) {
            System.out.print(x + "  ");
            sum += x;
        }
        System.out.println("\nTong = " + sum);
    }
}


