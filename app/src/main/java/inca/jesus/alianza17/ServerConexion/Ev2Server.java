package inca.jesus.alianza17.ServerConexion;

import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

import inca.jesus.alianza17.Clases.DataServer;

public class Ev2Server extends StringRequest {
    private static final String LOGIN_REQUEST_URL = DataServer.REGISTRAR_EVA2;
    private Map<String, String> params;


    public Ev2Server(String torneo, String rival, String  goles, String tiempo, String total, String iddepo, Response.Listener<String> listener) {
        super(Method.POST, LOGIN_REQUEST_URL, listener, null);
        params = new HashMap<>();
        params.put("id1", torneo);
        params.put("id2", rival);
        params.put("id3", goles);
        params.put("id4", tiempo);
        params.put("id5", total);
        params.put("id6", iddepo);
    }
    @Override
    public Map<String, String> getParams() {
        return params;
    }
}