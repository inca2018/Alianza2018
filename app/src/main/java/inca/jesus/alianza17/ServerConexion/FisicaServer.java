package inca.jesus.alianza17.ServerConexion;

import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

import inca.jesus.alianza17.Clases.DataServer;

public class FisicaServer extends StringRequest {
    private static final String CAL_REQUEST_URL = DataServer.REGISTRO_FISICO;
    private Map<String, String> params;
    public FisicaServer(String id1, String id2, String d1, String d2, String d3, String d4, String d5,
                        String d6,
                        String d7,
                        String d8,
                        String d9,
                        String d10,
                        String d11,
                        String d12,
                        String d13,
                        String d14,
                        String d15,
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
        params.put("d7",d7);
        params.put("d8",d8);
        params.put("d9",d9);
        params.put("d10",d10);
        params.put("d11",d11);
        params.put("d12",d12);
        params.put("d13",d13);
        params.put("d14",d14);
        params.put("d15",d15);


    }
    @Override
    public Map<String, String> getParams() {
        return params;
    }
}