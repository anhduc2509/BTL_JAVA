/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Anh Duc
 */
public class XuatBan {

    private Date TGXB = java.util.Calendar.getInstance().getTime();
    private int soLuongXB;
    private int soLuongBan;
    private List<DangKyBienSoanGiaoTrinh> dsxb = new ArrayList<>();
    private FileController fileController = new FileController();

    public Date getTGXB() {
        return TGXB;
    }

    public void setTGXB(Date TGXB) {
        this.TGXB = TGXB;
    }

    public int getSoLuongXB() {
        return soLuongXB;
    }

    public void setSoLuongXB(int soLuongXB) {
        this.soLuongXB = soLuongXB;
    }

    public int getSoLuongBan() {
        return soLuongBan;
    }

    public void setSoLuongBan(int soLuongBan) {
        this.soLuongBan = soLuongBan;
    }

    public XuatBan(int soLuongXB, int soLuongBan) {
        this.soLuongXB = soLuongXB;
        this.soLuongBan = soLuongBan;
    }

    public XuatBan() {
    }

    public void ReadFileBegin() {
        fileController.OpenFileToRead("NghiemThu.DAT");
        while (fileController.getScanner().hasNext()) {
            String infor = fileController.getScanner().nextLine();
            String[] data = infor.split("\\|");
            String[] data2 = data[data.length - 1].split("\\*");
            List<TacGia> tgs = new ArrayList<>();
            for (int i = 0; i <= data2.length / 2; i += 2) {
                String ten = data2[i + 1];
                String vaiTro = data2[i + 2];
                tgs.add(new TacGia(ten, vaiTro));
            }
            DangKyBienSoanGiaoTrinh a = new DangKyBienSoanGiaoTrinh(data[1], tgs, data[2], data[3]);
            a.setMaGT(data[0]);
            dsxb.add(a);
        }
        fileController.CloseFileAfterRead();
    }

    public void WriteFileBegin() {
        ReadFileBegin();
        fileController.OpenFileToWrite("XuatBan.DAT", true);
        for (DangKyBienSoanGiaoTrinh dkb : dsxb) {
            String str = "";
            str += dkb.getMaGT() + "|" + dkb.getTenGT() + "|" + dkb.getNoiDung() + "|" + dkb.getThoiGianHT() + "|" + dkb.getThoiGianDK() + "|";
            for (TacGia tacGia : dkb.getTacGias()) {
                String tmp = "*" + tacGia.getTenTacGia() + "*" + tacGia.getVaiTro();
                str += tmp;
            }
            fileController.getPrintWriter().println(str);
        }
        fileController.CloseFileAfterWrite();
    }
}
