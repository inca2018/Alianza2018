package inca.jesus.alianza17.ServerConexion;

import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

import inca.jesus.alianza17.Clases.DataServer;

public class Modulo_Mostrar extends StringRequest {
    private static final String LOGIN_REQUEST_URL = DataServer.PERFIL_GET_MODULO;
    private Map<String, String> params;

    public Modulo_Mostrar(String cod, Response.Listener<String> listener) {
        super(Method.POST, LOGIN_REQUEST_URL,listener, null);
        params = new HashMap<>();
        params.put("cod",cod);
    }

    @Override
    public Map<String, String> getParams() {
        return params;
    }
}