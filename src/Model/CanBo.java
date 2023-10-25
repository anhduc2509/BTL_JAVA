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
public class CanBo {

    private String vaiTro;
    private String tenCB;

    public CanBo(String tenCB, String vaiTro) {
        this.tenCB = tenCB;
        this.vaiTro = vaiTro;
    }

    public CanBo() {
    }

    public String getVaiTro() {
        return vaiTro;
    }

    public String getTenCB() {
        return tenCB;
    }

    public void setVaiTro(String vaiTro) {
        try {
            if (vaiTro.trim().equals("")) {
                throw new Exception("Vai tro khong duoc de trong");
            } else {
                this.vaiTro = vaiTro;
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    public void setTenCB(String tenCB) {
        try {
            if (tenCB.trim().equals("")) {
                throw new Exception("Ho ten khong duoc de trong");
            } else {
                this.tenCB = tenCB;
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void Nhap() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhap ten can bo:");
        boolean done = false;
        while (!done) {
            tenCB = scanner.nextLine();
            setTenCB(tenCB);
            if (!tenCB.trim().equals("")) {
                done = true;
            }
        }
        System.out.println("Nhap vai tro:");
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
