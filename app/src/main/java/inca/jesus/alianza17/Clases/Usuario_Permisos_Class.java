package inca.jesus.alianza17.Clases;
import java.util.ArrayList;
import java.util.List;
public class Usuario_Permisos_Class {
    public int id;
    public int id_usuario;
    public int p1;
    public int p2;
    public int p3;
    public int p4;
    public int p5;
    public int p6;
    public int p7;
    public int p8;

    public Usuario_Permisos_Class(int id, int id_usuario, int p1, int p2, int p3, int p4, int p5, int p6, int p7, int p8) {
        this.id = id;
        this.id_usuario=id_usuario;
        this.p1 = p1;
        this.p2 = p2;
        this.p3 = p3;
        this.p4 = p4;
        this.p5 = p5;
        this.p6 = p6;
        this.p7 = p7;
        this.p8 = p8;
    }
    public Usuario_Permisos_Class(){
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public int getP1() {
        return p1;
    }
    public void setP1(int p1) {
        this.p1 = p1;
    }
    public int getP2() {
        return p2;
    }
    public void setP2(int p2) {
        this.p2 = p2;
    }
    public int getP3() {
        return p3;
    }
    public void setP3(int p3) {
        this.p3 = p3;
    }
    public int getP4() {
        return p4;
    }
    public void setP4(int p4) {
        this.p4 = p4;
    }
    public int getP5() {
        return p5;
    }
    public void setP5(int p5) {
        this.p5 = p5;
    }
    public int getP6() {
        return p6;
    }
    public void setP6(int p6) {
        this.p6 = p6;
    }
    public int getP7() {
        return p7;
    }
    public void setP7(int p7) {
        this.p7 = p7;
    }
    public int getP8() {
        return p8;
    }
    public void setP8(int p8) {
        this.p8 = p8;
    }
    public int getId_usuario() {
        return id_usuario;
    }
    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

}
