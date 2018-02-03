package inca.jesus.alianza17.ServerConexion;

import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

import inca.jesus.alianza17.Clases.DataServer;

public class Permiso_Guardar extends StringRequest {
    private static final String LOGIN_REQUEST_URL = DataServer.PERMISO_UPDATE_USER;
    private Map<String, String> params;

    public Permiso_Guardar(String cod,String d1,String d2,String d3,String d4,String d5,String d6,String d7,String d8, Response.Listener<String> listener) {
        super(Method.POST, LOGIN_REQUEST_URL,listener, null);
        params = new HashMap<>();
        params.put("cod",cod);
        params.put("d1",d1);
        params.put("d2",d2);
        params.put("d3",d3);
        params.put("d4",d4);
        params.put("d5",d5);
        params.put("d6",d6);
        params.put("d7",d7);
        params.put("d8",d8);
    }

    @Override
    public Map<String, String> getParams() {
        return params;
    }
}