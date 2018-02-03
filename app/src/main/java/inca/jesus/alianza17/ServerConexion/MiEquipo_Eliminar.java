package inca.jesus.alianza17.ServerConexion;

import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

import inca.jesus.alianza17.Clases.DataServer;

public class MiEquipo_Eliminar extends StringRequest {
    private static final String LOGIN_REQUEST_URL = DataServer.MIEQUIPO_DELETE;
    private Map<String, String> params;

    public MiEquipo_Eliminar(String id, Response.Listener<String> listener) {
        super(Method.POST, LOGIN_REQUEST_URL,listener, null);
        params = new HashMap<>();
        params.put("id",id);
    }

    @Override
    public Map<String, String> getParams() {
        return params;
    }
}