/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.util.Scanner;

/**
 *
 * @author Anh Duc
 */
public class TacGia {

    private String vaiTro;
    private String tenTacGia;

    public TacGia(String tenTacGia, String vaiTro) {
        this.tenTacGia = tenTacGia;
        this.vaiTro = vaiTro;
    }

    public TacGia() {
    }

    public String getVaiTro() {
        return vaiTro;
    }

    public String getTenTacGia() {
        return tenTacGia;
    }

    public void setVaiTro(String vaiTro) {
        try {
            if (vaiTro.trim().equals("")) {
                throw new Exception("Vai tro khong duoc de trong");
            }
        } catch (Exception e) {
            System.out.println(e.toString());
        }
        this.vaiTro = vaiTro;
    }

    public void setTenTacGia(String tenTacGia) {
        try {
            if (tenTacGia.trim().equals("")) {
                throw new Exception("Ho ten khong duoc de trong");
            }
        } catch (Exception e) {
            System.out.println(e.toString());
        }
        this.tenTacGia = tenTacGia;
    }

    public void Nhap() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("nhap ten tac gia");
        boolean done = false;
        while (!done) {
            tenTacGia = scanner.nextLine();
            setTenTacGia(tenTacGia);
            if (!tenTacGia.trim().equals("")) {
                done = true;
            }
        }
        System.out.println("Nhap vai tro");
        boolean done2 = false;
        while (!done2) {
            vaiTro = scanner.nextLine();
            setVaiTro(vaiTro);
            if (!vaiTro.trim().equals("")) {
                done2 = true;
            }
        }
    }

}
