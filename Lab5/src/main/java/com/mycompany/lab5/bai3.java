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
import java.util.Comparator;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

class SanPham {
    String ten;
    Double donGia;

    public SanPham(String ten, Double donGia) {
        this.ten = ten;
        this.donGia = donGia;
    }

    @Override
    public String toString() {
        return String.format(Locale.US, "%-30s | %,10.2f", ten, donGia);
    }
}

public class bai3 {
    private static final Scanner sc = new Scanner(System.in);
    private static final List<SanPham> list = new ArrayList<>();

    public static void main(String[] args) {
        int choice;
        do {
            menu();
            choice = chon();
            switch (choice) {
                case 1 -> nhap();
                case 2 -> sapXepGiamTheoGiaVaXuat();
                case 3 -> xoaTheoTen();
                case 4 -> xuatGiaTrungBinh();
                case 5 -> System.out.println("Ket thuc chuong trinh!");
                default -> System.out.println("Lua chon khong hop le!");
            }
            System.out.println();
        } while (choice != 5);
    }

    private static void menu() {
        System.out.println("=== BAI 3: QUAN LY SAN PHAM ===");
        System.out.println("1. Nhap danh sach san pham");
        System.out.println("2. Sap xep giam dan theo gia va xuat");
        System.out.println("3. Tim va xoa san pham theo ten");
        System.out.println("4. Xuat gia trung binh cac san pham");
        System.out.println("5. Ket thuc");
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
        System.out.println("Nhap san pham (de trong ten va Enter de dung):");
        while (true) {
            System.out.print("Ten SP: ");
            String ten = sc.nextLine().trim();
            if (ten.isEmpty()) break;

            Double gia = null;
            while (gia == null) {
                System.out.print("Don gia: ");
                String line = sc.nextLine().trim();
                try {
                    gia = Double.parseDouble(line);
                    if (gia < 0) {
                        System.out.println("Gia phai >= 0");
                        gia = null;
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Gia khong hop le, vui long nhap so.");
                }
            }
            list.add(new SanPham(ten, gia));
        }
    }

    private static void sapXepGiamTheoGiaVaXuat() {
        if (list.isEmpty()) {
            System.out.println("Danh sach rong.");
            return;
        }
        Comparator<SanPham> comp = new Comparator<SanPham>() {
            @Override
            public int compare(SanPham o1, SanPham o2) {
                return o1.donGia.compareTo(o2.donGia); // tăng dần
            }
        };
        Collections.sort(list, comp);
        Collections.reverse(list); // thành giảm dần
        System.out.println("Danh sach SP (gia giam dan):");
        for (SanPham sp : list) {
            System.out.println(sp);
        }
    }

    private static void xoaTheoTen() {
        if (list.isEmpty()) {
            System.out.println("Danh sach rong.");
            return;
        }
        System.out.print("Nhap ten san pham can xoa: ");
        String target = sc.nextLine().trim();
        boolean removed = false;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).ten.equalsIgnoreCase(target)) {
                list.remove(i);
                removed = true;
                break;
            }
        }
        System.out.println(removed ? "Da xoa: " + target : "Khong tim thay: " + target);
    }

    private static void xuatGiaTrungBinh() {
        if (list.isEmpty()) {
            System.out.println("Danh sach rong.");
            return;
        }
        double sum = 0;
        for (SanPham sp : list) sum += sp.donGia;
        double avg = sum / list.size();
        System.out.printf(Locale.US, "Gia trung binh: %, .2f\n", avg);
    }
}
