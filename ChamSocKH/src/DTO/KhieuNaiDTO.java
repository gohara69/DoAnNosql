/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

/**
 *
 * @author PC
 */
public class KhieuNaiDTO {
    String maKN, ngayKN, noiDungKN;

    public KhieuNaiDTO(String maKN, String ngayKN, String noiDungKN) {
        this.maKN = maKN;
        this.ngayKN = ngayKN;
        this.noiDungKN = noiDungKN;
    }

    public String getMaKN() {
        return maKN;
    }

    public String getNgayKN() {
        return ngayKN;
    }

    public String getNoiDungKN() {
        return noiDungKN;
    }

    public void setMaKN(String maKN) {
        this.maKN = maKN;
    }

    public void setNgayKN(String ngayKN) {
        this.ngayKN = ngayKN;
    }

    public void setNoiDungKN(String noiDungKN) {
        this.noiDungKN = noiDungKN;
    }
    
}
