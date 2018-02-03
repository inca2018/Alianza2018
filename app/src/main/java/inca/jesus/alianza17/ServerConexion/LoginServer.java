package inca.jesus.alianza17.ServerConexion;

import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

import inca.jesus.alianza17.Clases.DataServer;

public class LoginServer extends StringRequest {
    private static final String LOGIN_REQUEST_URL = DataServer.VALIDAR_SESION;
    private Map<String, String> params;

    public LoginServer(String usuario, String password, Response.Listener<String> listener) {
        super(Method.POST, LOGIN_REQUEST_URL,listener, null);
        params = new HashMap<>();
        params.put("usuario", usuario);
        params.put("password", password);
    }

    @Override
    public Map<String, String> getParams() {
        return params;
    }
}