package inca.jesus.alianza17.ServerConexion;

import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

import inca.jesus.alianza17.Clases.DataServer;

public class Evento_Camp_Eliminar extends StringRequest {
    private static final String LOGIN_REQUEST_URL = DataServer.EVENTO_C_ELIMINAR;
    private Map<String, String> params;

    public Evento_Camp_Eliminar(String id,String id2, Response.Listener<String> listener) {
        super(Method.POST, LOGIN_REQUEST_URL,listener, null);
        params = new HashMap<>();
        params.put("id",id);
        params.put("id2",id2);
    }

    @Override
    public Map<String, String> getParams() {
        return params;
    }
}