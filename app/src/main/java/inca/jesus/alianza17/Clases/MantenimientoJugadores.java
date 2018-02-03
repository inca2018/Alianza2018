package inca.jesus.alianza17.Clases;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jesus on 08/07/2017.
 */

public class MantenimientoJugadores {
    public int Id;
    public String Nombres;
    public int DNI;
    public String Fecha_nacimiento;
    public boolean isSelected;


    public static final List<MantenimientoJugadores> PLANTEL=new ArrayList<>();
    public MantenimientoJugadores(int id, String nombres, int DNI, String fecha_nacimiento, boolean isSelected) {
        Id = id;
        Nombres = nombres;
        this.DNI = DNI;
        Fecha_nacimiento = fecha_nacimiento;
        this.isSelected = isSelected;
    }
    public MantenimientoJugadores(){
    }


    static{

        PLANTEL.add(new MantenimientoJugadores(1,"ASIN MOSQUERA ANDRES ESTEFANO",73257263,"07/02/2000",false ));
        PLANTEL.add(new MantenimientoJugadores(2,"CARBAJAL RIOS ALBERTO HARRY",70451195,"07/02/1999",false ));
        PLANTEL.add(new MantenimientoJugadores(3,"CARTY QUISPE MIGUEL",70601147,"22/02/1999",false ));
        PLANTEL.add(new MantenimientoJugadores(4,"CIRILO SILVA JACK HARRINSON",61915483,"27/01/1999",false ));
        PLANTEL.add(new MantenimientoJugadores(5,"DIAZ GUZMAN JONATHAN LUCIO",71075186,"15/03/1999",false ));
        PLANTEL.add(new MantenimientoJugadores(6,"FERREYRA CHONLON KEVIN",70827539,"07/06/1999",false ));
        PLANTEL.add(new MantenimientoJugadores(7,"JURADO GUZMAN GEREMI YORDAN",72916594,"28/04/1999",false ));
        PLANTEL.add(new MantenimientoJugadores(8,"PANTA COTITO RAULIHNO JEANPIERRE",71616773,"21/11/1999",false ));
        PLANTEL.add(new MantenimientoJugadores(9,"PANTOJA ORMEÑO CRISTHOFER",72608324,"09/02/2000",false ));
        PLANTEL.add(new MantenimientoJugadores(10,"PRADO MAYTA CESAR",70799345,"26/02/1999",false ));
        PLANTEL.add(new MantenimientoJugadores(11,"ROSAS CRUZ SEBASTIAN PEDRO",71586799,"31/03/2000",false ));
        PLANTEL.add(new MantenimientoJugadores(12,"RUIZ CRIOLLO ROGER ALEXANDER",70400146,"28/01/2000",false ));
        PLANTEL.add(new MantenimientoJugadores(13,"SALAZAR QUELOPANA FABRIZIO",78804670,"29/06/2000",false ));
        PLANTEL.add(new MantenimientoJugadores(14,"SARAVIA ROJAS FRANCO",70930631,"02/06/1999",false ));
        PLANTEL.add(new MantenimientoJugadores(15,"TARAZONA CUEVA DANIEL ALONSO",71198801,"27/09/1999",false ));
        PLANTEL.add(new MantenimientoJugadores(16,"VIDAL CASIMIRO AAROM STHEPEN",73708128,"23/08/1999",false ));
        PLANTEL.add(new MantenimientoJugadores(17,"VILLAVICENCIO HUAMANI CELSO",70513964,"10/08/1999",false ));
        PLANTEL.add(new MantenimientoJugadores(18,"ALBINO PÉREZ JOAQUIN",74356523,"21/01/2000",false ));
        PLANTEL.add(new MantenimientoJugadores(19,"ALEMAN BACA JOSE WILFREDO",74654348,"23/05/2000",false ));
        PLANTEL.add(new MantenimientoJugadores(20,"ARAUJO CASTAÑEDA BRAULIO ALEXIS",71407115,"16/02/2000",false ));

    }


    public int getId() {
        return Id;
    }
    public void setId(int id) {
        Id = id;
    }
    public String getNombres() {
        return Nombres;
    }

    public void setNombres(String nombres) {
        Nombres = nombres;
    }

    public int getDNI() {
        return DNI;
    }

    public void setDNI(int DNI) {
        this.DNI = DNI;
    }

    public String getFecha_nacimiento() {
        return Fecha_nacimiento;
    }

    public void setFecha_nacimiento(String fecha_nacimiento) {
        Fecha_nacimiento = fecha_nacimiento;
    }

    public boolean isSelected() {
        return isSelected;
    }

    public void setSelected(boolean selected) {
        isSelected = selected;
    }
}
