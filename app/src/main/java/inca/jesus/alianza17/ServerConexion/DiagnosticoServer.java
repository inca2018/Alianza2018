package inca.jesus.alianza17.ServerConexion;

import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

import inca.jesus.alianza17.Clases.DataServer;

public class DiagnosticoServer extends StringRequest {
    private static final String CAL_REQUEST_URL = DataServer.REGISTRO_DATA2;
    private Map<String, String> params;
    public DiagnosticoServer(String id1, String id2, String r1, String r2, String r3,
                             String r4, String r5, String r6, String r7,
                             String c1, String c2, String c3, String c4,
                             String s1, String s2, String s3, String s4,
                             String t1, String t2, String t3, String t4, String t5, String t6,
                             String p1, String p2, String p3, String p4,
                             Response.Listener<String> listener) {
        super(Method.POST, CAL_REQUEST_URL, listener, null);
        params = new HashMap<>();
        params.put("id1",id1);
        params.put("id2",id2);
        params.put("r1",r1);
        params.put("r2",r2);
        params.put("r3",r3);
        params.put("r4",r4);
        params.put("r5",r5);
        params.put("r6",r6);
        params.put("r7",r7);
        params.put("c1",c1);
        params.put("c2",c2);
        params.put("c3",c3);
        params.put("c4",c4);
        params.put("s1",s1);
        params.put("s2",s2);
        params.put("s3",s3);
        params.put("s4",s4);
        params.put("t1",t1);
        params.put("t2",t2);
        params.put("t3",t3);
        params.put("t4",t4);
        params.put("t5",t5);
        params.put("t6",t6);
        params.put("p1",p1);
        params.put("p2",p2);
        params.put("p3",p3);
        params.put("p4",p4);
    }
    @Override
    public Map<String, String> getParams() {
        return params;
    }
}