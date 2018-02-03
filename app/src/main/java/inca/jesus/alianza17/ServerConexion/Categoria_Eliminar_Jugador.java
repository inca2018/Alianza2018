package inca.jesus.alianza17.ServerConexion;

import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

import inca.jesus.alianza17.Clases.DataServer;

public class Categoria_Eliminar_Jugador extends StringRequest {
    private static final String LOGIN_REQUEST_URL = DataServer.CATEGORIA_ELIMINAR_JUGADOR;
    private Map<String, String> params;

    public Categoria_Eliminar_Jugador(String id,String id2, Response.Listener<String> listener) {
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