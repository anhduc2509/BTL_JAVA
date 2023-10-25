/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Anh Duc
 */
public class DangKyBienSoanGiaoTrinh {

    private static int id = 1;
    private String maGT;
    private String TenGT;
    private List<TacGia> tacGias = new ArrayList<>();
    private String noiDung;
    private String thoiGianHT;
    private int tienDo;
    private int SLB;
    private int SLSX;
    private Date thoiGianDK = java.util.Calendar.getInstance().getTime();
    private Date thoiGianXB = java.util.Calendar.getInstance().getTime();
    private FileController fileController = new FileController();
    private String fileName = "DsDangKy.DAT";

    public DangKyBienSoanGiaoTrinh() {
        this.maGT = "GT" + id++;
        setTienDo(0);
    }

    public DangKyBienSoanGiaoTrinh(String TenGT, List<TacGia> tacGias, String noiDung, String thoiGianHT) {
        this.maGT = "GT" + id++;
        this.TenGT = TenGT;
        this.tacGias = tacGias;
        this.noiDung = noiDung;
        this.thoiGianHT = thoiGianHT;
        setThoiGianDK(thoiGianDK);
        setTienDo(0);
    }

    public DangKyBienSoanGiaoTrinh(String TenGT) {
        this.TenGT = TenGT;
    }

    public DangKyBienSoanGiaoTrinh(String maGT, String TenGT, int SLB, int SLSX) {
        this.maGT = maGT;
        this.TenGT = TenGT;
        this.SLB = SLB;
        this.SLSX = SLSX;
    }

    public DangKyBienSoanGiaoTrinh(String TenGT, int SLB, int SLSX, String TGXB) {
        this.TenGT = TenGT;
        this.SLB = SLB;
        this.SLSX = SLSX;
        setThoiGianXB(thoiGianXB);
    }

    public DangKyBienSoanGiaoTrinh(String maGT, String TenGT) {
        this.maGT = maGT;
        this.TenGT = TenGT;
    }

    public Date getThoiGianXB() {
        return thoiGianXB;
    }

    public void setThoiGianXB(Date thoiGianXB) {
        this.thoiGianXB = thoiGianXB;
    }
    
    

    public int getTienDo() {
        return tienDo;
    }

    public int getSLB() {
        return SLB;
    }

    public void setSLB(int SLB) {
        this.SLB = SLB;
    }

    public int getSLSX() {
        return SLSX;
    }

    public void setSLSX(int SLSX) {
        this.SLSX = SLSX;
    }

    public void setTienDo(int tienDo) {
        this.tienDo = tienDo;
    }

    public void setMaGT(String maGT) {
        this.maGT = maGT;
    }

    public String getMaGT() {
        return maGT;
    }

    public String getTenGT() {
        return TenGT;
    }

    public List<TacGia> getTacGias() {
        return tacGias;
    }

    public String getNoiDung() {
        return noiDung;
    }

    public String getThoiGianHT() {
        return thoiGianHT;
    }

    public Date getThoiGianDK() {
        return thoiGianDK;
    }

    public void setTenGT(String TenGT) {
        try {
            if (TenGT.trim().equals("")) {
                throw new Exception("Vai tro khong duoc de trong");
            } else {
                this.TenGT = TenGT;
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void setTacGias(List<TacGia> tacGias) {
        this.tacGias = tacGias;

    }

    public void setNoiDung(String noiDung) {
        try {
            if (noiDung.trim().equals("")) {
                throw new Exception("Vai tro khong duoc de trong");
            } else {
                this.noiDung = noiDung;
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    public void setThoiGianHT(String thoiGianHT) {
        this.thoiGianHT = thoiGianHT;
    }

    public void setThoiGianDK(Date thoiGianDK) {
        this.thoiGianDK = thoiGianDK;
    }

    public void Nhap(int n, String tenGT, String thoiGian, String noiDung) {
        Scanner scanner = new Scanner(System.in);
        setTenGT(tenGT);
        setThoiGianHT(thoiGian);
        setNoiDung(noiDung);
        for (int i = 0; i < n; i++) {
            System.out.println("Tác giả " + (i + 1));
            TacGia tg = new TacGia();
            tg.Nhap();
            tacGias.add(tg);
        }
        WritetoFile(fileName);
    }

    public void WritetoFile(String fileName) {
        fileController.OpenFileToWrite(fileName, true);
        String str = "";
        str += getMaGT() + "|" + getTenGT() + "|" + getNoiDung() + "|" + getThoiGianHT() + "|" + getThoiGianDK() + "|";
        for (TacGia tacGia : tacGias) {
            String tmp = "*" + tacGia.getTenTacGia() + "*" + tacGia.getVaiTro();
            str += tmp;
        }
        fileController.getPrintWriter().println(str);
        fileController.CloseFileAfterWrite();
    }

    public List<DangKyBienSoanGiaoTrinh> ReadFileDK(String fileName1) {
        fileController.OpenFileToRead(fileName1);
        List<DangKyBienSoanGiaoTrinh> dkbss = new ArrayList<>();
        while (fileController.getScanner().hasNext()) {
            String infor = fileController.getScanner().nextLine();
            String[] data = infor.split("\\|");
            String[] data2 = data[data.length - 2].split("\\*");
            List<TacGia> tgs = new ArrayList<>();
            for (int i = 0; i <= data2.length / 2; i += 2) {
                String ten = data2[i + 1];
                String vaiTro = data2[i + 2];
                tgs.add(new TacGia(ten, vaiTro));
            }
            DangKyBienSoanGiaoTrinh a = new DangKyBienSoanGiaoTrinh(data[1], tgs, data[2], data[3]);
            a.setTienDo(Integer.parseInt(data[data.length - 1]));
            dkbss.add(a);
        }
        fileController.CloseFileAfterRead();
        return dkbss;
    }
}
