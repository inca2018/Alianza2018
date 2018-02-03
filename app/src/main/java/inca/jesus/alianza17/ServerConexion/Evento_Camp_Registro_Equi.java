package inca.jesus.alianza17.ServerConexion;

import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

import inca.jesus.alianza17.Clases.DataServer;

public class Evento_Camp_Registro_Equi extends StringRequest {
    private static final String LOGIN_REQUEST_URL = DataServer.REGISTRAR_EV_EQUIPO;
    private Map<String, String> params;

    public Evento_Camp_Registro_Equi(String r1, String r2, Response.Listener<String> listener) {
        super(Method.POST, LOGIN_REQUEST_URL,listener, null);
        params = new HashMap<>();

        params.put("r1",r1);
        params.put("r2",r2);

    }
    @Override
    public Map<String, String> getParams() {
        return params;
    }
}