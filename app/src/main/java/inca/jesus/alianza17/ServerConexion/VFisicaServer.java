package inca.jesus.alianza17.ServerConexion;

import android.provider.ContactsContract;

import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

import inca.jesus.alianza17.Clases.DataServer;

public class VFisicaServer extends StringRequest {
    private static final String CAL_REQUEST_URL = DataServer.VALIDAR_FISICO;
    private Map<String, String> params;
    public VFisicaServer(String id1, String id2,
                         Response.Listener<String> listener) {
        super(Method.POST, CAL_REQUEST_URL, listener, null);
        params = new HashMap<>();
        params.put("id1",id1);
        params.put("id2",id2);

    }
    @Override
    public Map<String, String> getParams() {
        return params;
    }
}