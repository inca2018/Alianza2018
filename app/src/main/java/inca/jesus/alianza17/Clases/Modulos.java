package inca.jesus.alianza17.Clases;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jesus on 07/07/2017.
 */

public class Modulos {
    public int id;
    public int id_perfil;
    public boolean m1;
    public boolean m2;
    public boolean m3;
    public boolean m4;
    public boolean m5;

    public Modulos(int id, int id_perfil, boolean m1, boolean m2, boolean m3, boolean m4, boolean m5) {
        this.id = id;
        this.id_perfil = id_perfil;
        this.m1 = m1;
        this.m2 = m2;
        this.m3 = m3;
        this.m4 = m4;
        this.m5 = m5;
    }
    public Modulos(){

    }


    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public int getId_perfil() {
        return id_perfil;
    }
    public void setId_perfil(int id_perfil) {
        this.id_perfil = id_perfil;
    }
    public boolean isM1() {
        return m1;
    }
    public void setM1(boolean m1) {
        this.m1 = m1;
    }
    public boolean isM2() {
        return m2;
    }
    public void setM2(boolean m2) {
        this.m2 = m2;
    }
    public boolean isM3() {
        return m3;
    }
    public void setM3(boolean m3) {
        this.m3 = m3;
    }
    public boolean isM4() {
        return m4;
    }
    public void setM4(boolean m4) {
        this.m4 = m4;
    }
    public boolean isM5() {
        return m5;
    }
    public void setM5(boolean m5) {
        this.m5 = m5;
    }

}
