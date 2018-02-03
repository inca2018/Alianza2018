package inca.jesus.alianza17.ServerConexion;

import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

import inca.jesus.alianza17.Clases.DataServer;

public class Fecha_Insertar extends StringRequest {
    private static final String LOGIN_REQUEST_URL = DataServer.REGISTRO_FECHA;
    private Map<String, String> params;

    public Fecha_Insertar(String cod,String d1, String d2, String d3, Response.Listener<String> listener) {
        super(Method.POST, LOGIN_REQUEST_URL,listener, null);
        params = new HashMap<>();
        params.put("cod",cod);
        params.put("d1",d1);
        params.put("d2",d2);
        params.put("d3",d3);


    }
    @Override
    public Map<String, String> getParams() {
        return params;
    }
}