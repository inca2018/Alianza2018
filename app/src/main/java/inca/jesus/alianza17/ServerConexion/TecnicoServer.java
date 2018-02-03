package inca.jesus.alianza17.ServerConexion;

import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

import inca.jesus.alianza17.Clases.DataServer;

public class TecnicoServer extends StringRequest {
    private static final String CAL_REQUEST_URL = DataServer.REGISTRO_TECNICO;
    private Map<String, String> params;
    public TecnicoServer(String id1, String id2, String d1, String d2, String d3, String d4, String d5,
                         String d6,
                         Response.Listener<String> listener) {
        super(Method.POST, CAL_REQUEST_URL, listener, null);
        params = new HashMap<>();
        params.put("id1",id1);
        params.put("id2",id2);
        params.put("d1",d1);
        params.put("d2",d2);
        params.put("d3",d3);
        params.put("d4",d4);
        params.put("d5",d5);
        params.put("d6",d6);

    }
    @Override
    public Map<String, String> getParams() {
        return params;
    }
}