package inca.jesus.alianza17.ServerConexion;

import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

import inca.jesus.alianza17.Clases.DataServer;

public class MiEquipo_Insertar extends StringRequest {
    private static final String LOGIN_REQUEST_URL = DataServer.MIEQUIPO_INSERT;
    private Map<String, String> params;

    public MiEquipo_Insertar(String d1, String d2, String d3, String d4, Response.Listener<String> listener) {
        super(Method.POST, LOGIN_REQUEST_URL,listener, null);
        params = new HashMap<>();
        params.put("d1",d1);
        params.put("d2",d2);
        params.put("d3",d3);
        params.put("d4",d4);

    }
    @Override
    public Map<String, String> getParams() {
        return params;
    }
}