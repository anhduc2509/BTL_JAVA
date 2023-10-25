/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Paths;
import java.util.Scanner;

/**
 *
 * @author VAN
 */
public class FileController {

    public FileWriter fileWriter;
    public BufferedWriter bufferedWriter;
    public PrintWriter printWriter;
    public Scanner scanner;

    public Scanner getScanner() {
        return this.scanner;
    }

    public void OpenFileToWrite(String namefile,boolean insert) {
        try {
            fileWriter = new FileWriter(namefile, insert);
            bufferedWriter = new BufferedWriter(fileWriter);
            printWriter = new PrintWriter(bufferedWriter);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void CloseFileAfterWrite() {
        try {
            printWriter.close();
            bufferedWriter.close();
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void OpenFileToRead(String namefile) {
        try {
            scanner = new Scanner(Paths.get(namefile));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void CloseFileAfterRead() {
        scanner.close();
    }

    public PrintWriter getPrintWriter() {
        return printWriter;
    }
}
