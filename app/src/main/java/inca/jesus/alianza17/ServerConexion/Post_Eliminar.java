package inca.jesus.alianza17.ServerConexion;

import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

import inca.jesus.alianza17.Clases.DataServer;

public class Post_Eliminar extends StringRequest {
    private static final String LOGIN_REQUEST_URL = DataServer.POST_ELIMINAR;
    private Map<String, String> params;

    public Post_Eliminar(String d1,String d2, Response.Listener<String> listener) {
        super(Method.POST, LOGIN_REQUEST_URL,listener, null);
        params = new HashMap<>();
        params.put("d1",d1);
        params.put("d2",d2);
    }

    @Override
    public Map<String, String> getParams() {
        return params;
    }
}