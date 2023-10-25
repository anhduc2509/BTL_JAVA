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
public class BaoCaoTienDo {

    private int tienDo;
    private String maGTTD;
    private List<DangKyBienSoanGiaoTrinh> dkbss = new ArrayList<>();
    private List<DangKyBienSoanGiaoTrinh> dkbs = new ArrayList<>();
    private FileController fileController = new FileController();
    private String fileName = "DsDangKy.DAT";
    private String fileName1 = "TienDo.DAT";
//    private List<DangKyBienSoanGiaoTrinh> dkbs = new ArrayList<>() ;
    private Scanner scanner = new Scanner(System.in);

    public BaoCaoTienDo(int tienDo, String maGTTD) {
        this.tienDo = tienDo;
        this.maGTTD = maGTTD;
    }

    public BaoCaoTienDo() {
    }

    public int getTienDo() {
        return tienDo;
    }

    public void setTienDo(int tienDo) {
        this.tienDo = tienDo;
    }

    public String getMaGTTD() {
        return maGTTD;
    }

    public void setMaGTTD(String maGTTD) {
        this.maGTTD = maGTTD;
    }
    
    public void XacNhanTienDo(String maGT, int tienDo,List<DangKyBienSoanGiaoTrinh> dkbss) {
        for( int i =0 ; i < dkbss.size(); i++){
            if( dkbss.get(i).getMaGT().compareTo(maGT)==0){
                dkbss.get(i).setTienDo(tienDo);
            } 
        }
    }

    public List<DangKyBienSoanGiaoTrinh> ReadFileDK(String fileName1) {
        fileController.OpenFileToRead(fileName1);
        while (fileController.getScanner().hasNext()) {
            String infor = fileController.getScanner().nextLine();
            String[] data = infor.split("\\|");
            String[] data2 = data[data.length - 2].split("\\*");
            List<TacGia> tgs = new ArrayList<>();
            for (int i = 0; i <= data2.length / 2; i += 2) {
                String ten = data2[i+1];
                String vaiTro = data2[i + 2];
                tgs.add(new TacGia(ten, vaiTro));
            }
            DangKyBienSoanGiaoTrinh a = new DangKyBienSoanGiaoTrinh(data[1], tgs, data[2], data[3]);
            a.setTienDo(Integer.parseInt(data[data.length-1]));
            dkbss.add(a);
        }
        fileController.CloseFileAfterRead();
        return dkbss;
    }
    
    public void WriteFileTĐ(List<DangKyBienSoanGiaoTrinh> dkbss,String fileName) {
        fileController.OpenFileToWrite(fileName,false);
        for (DangKyBienSoanGiaoTrinh dkb : dkbss) {
                String str = "";
                str += dkb.getMaGT() + "|" + dkb.getTenGT() + "|" + dkb.getNoiDung() + "|" + dkb.getThoiGianHT() + "|" + dkb.getThoiGianDK() + "|";
                for (TacGia tacGia : dkb.getTacGias()) {
                    String tmp = "*" + tacGia.getTenTacGia() + "*" + tacGia.getVaiTro();
                    str += tmp; 
                }
                str+=  "|" + dkb.getTienDo();
            fileController.getPrintWriter().println(str);
        }
        fileController.CloseFileAfterWrite();
    }
    
    public void WriteFileBegin() {
        fileController.OpenFileToWrite("TienDo.DAT",false);
        List<DangKyBienSoanGiaoTrinh> dkbss = ReadFileDKBegin("DsDangKy.DAT");
        for (DangKyBienSoanGiaoTrinh dkb : dkbss) {
                String str = "";
                str += dkb.getMaGT() + "|" + dkb.getTenGT() + "|" + dkb.getNoiDung() + "|" + dkb.getThoiGianHT() + "|" + dkb.getThoiGianDK() + "|";
                for (TacGia tacGia : dkb.getTacGias()) {
                    String tmp = "*" + tacGia.getTenTacGia() + "*" + tacGia.getVaiTro();
                    str += tmp; 
                }
                str+=  "|" + dkb.getTienDo();
            fileController.getPrintWriter().println(str);
        }
        fileController.CloseFileAfterWrite();
    }
    
    public List<DangKyBienSoanGiaoTrinh> ReadFileDKBegin(String fileName1) {
        fileController.OpenFileToRead(fileName1);
        while (fileController.getScanner().hasNext()) {
            String infor = fileController.getScanner().nextLine();
            String[] data = infor.split("\\|");
            String[] data2 = data[data.length - 1].split("\\*");
            List<TacGia> tgs = new ArrayList<>();
            for (int i = 0; i <= data2.length / 2; i += 2) {
                String ten = data2[i+1];
                String vaiTro = data2[i + 2];
                tgs.add(new TacGia(ten, vaiTro));
            }
            DangKyBienSoanGiaoTrinh a = new DangKyBienSoanGiaoTrinh(data[1], tgs, data[2], data[3]);
            dkbs.add(a);
        }
        fileController.CloseFileAfterRead();
        return dkbs;
    }
    
    public void XoaTienDo(String maGT, List<DangKyBienSoanGiaoTrinh> dkbss) {
        
        for( int i =0 ; i < dkbss.size(); i++){
            if( dkbss.get(i).getMaGT().compareTo(maGT)==0){
                dkbss.remove(i);
            }
        }
    }
    
    public void XinGH(String maGT, String giaHan, List<DangKyBienSoanGiaoTrinh> dkbss){
        
      
        
        for( int i =0 ; i < dkbss.size(); i++){
            if( dkbss.get(i).getMaGT().compareTo(maGT)==0){
                dkbss.get(i).setThoiGianHT(giaHan);
            }
        }
    }
}
