package inca.jesus.alianza17.ServerConexion;

import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

import inca.jesus.alianza17.Clases.DataServer;

public class ResultadosServer extends StringRequest {
    private static final String LOGIN_REQUEST_URL = DataServer.DETALLE_1;
    private Map<String, String> params;

    public ResultadosServer(String cod1, String cod2, Response.Listener<String> listener) {
        super(Method.POST, LOGIN_REQUEST_URL,listener, null);
        params = new HashMap<>();
        params.put("cod1", cod1);
        params.put("cod2", cod2);
    }

    @Override
    public Map<String, String> getParams() {
        return params;
    }
}