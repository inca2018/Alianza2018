package inca.jesus.alianza17.ServerConexion;

import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

import inca.jesus.alianza17.Clases.DataServer;

public class Estadistico_Insertar extends StringRequest {
    private static final String LOGIN_REQUEST_URL = DataServer.REGISTRO_ESTADISTICO;
    private Map<String, String> params;

    public Estadistico_Insertar(String cod1, String cod2, String cod3, String creador,
                                String d1,
                                String d2,
                                String d3,
                                String d4,
                                String d5,
                                String d6,
                                String d7,
                                String d8,
                                String d9,
                                String d10,
                                String d11,
                                String d12,
                                String d13,
                                String d14,
                                Response.Listener<String> listener) {
        super(Method.POST, LOGIN_REQUEST_URL,listener, null);
        params = new HashMap<>();
        params.put("cod1",cod1);
        params.put("cod2",cod2);
        params.put("cod3",cod3);
        params.put("creador",creador);
        params.put("d1",d1);
        params.put("d2",d2);
        params.put("d3",d3);
        params.put("d4",d4);
        params.put("d5",d5);
        params.put("d6",d6);
        params.put("d7",d7);
        params.put("d8",d8);
        params.put("d9",d9);
        params.put("d10",d10);
        params.put("d11",d11);
        params.put("d12",d12);
        params.put("d13",d13);
        params.put("d14",d14);
    }
    @Override
    public Map<String, String> getParams() {
        return params;
    }
}