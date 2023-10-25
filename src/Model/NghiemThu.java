/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Anh Duc
 */
public class NghiemThu {

    private List<DangKyBienSoanGiaoTrinh> dsnt = new ArrayList<>();
    private List<CanBo> dscb = new ArrayList<>();
    private FileController fileController = new FileController();
    private Scanner scanner = new Scanner(System.in);

    public NghiemThu() {
    }

    public List<CanBo> getDscb() {
        return dscb;
    }

    public void setDscb(List<CanBo> dscb) {
        this.dscb = dscb;
    }

    public List<DangKyBienSoanGiaoTrinh> getDsnt() {
        return dsnt;
    }

    public void setDsnt(List<DangKyBienSoanGiaoTrinh> dsnt) {
        this.dsnt = dsnt;
    }

    public void Nhap(int n) {
        for (int i = 0; i < n; i++) {
            CanBo cb = new CanBo();
            cb.Nhap();
            dscb.add(cb);
        }
    }

    public void WriteFileBegin() {
        fileController.OpenFileToWrite("NghiemThu.DAT", true);
        for (DangKyBienSoanGiaoTrinh dkb : dsnt) {

            String str = "";
            str += dkb.getMaGT() + "|" + dkb.getTenGT() + "|" + dkb.getNoiDung() + "|" + dkb.getThoiGianHT() + "|" + dkb.getThoiGianDK() + "|";
            for (TacGia tacGia : dkb.getTacGias()) {
                String tmp = "*" + tacGia.getTenTacGia() + "*" + tacGia.getVaiTro();
                str += tmp;
            }
            for (CanBo canBo : dscb) {
                String tmp = "+" + canBo.getTenCB() + "+" + canBo.getVaiTro();
                str += tmp;
            }
            fileController.getPrintWriter().println(str);
        }

        fileController.CloseFileAfterWrite();
    }
}
