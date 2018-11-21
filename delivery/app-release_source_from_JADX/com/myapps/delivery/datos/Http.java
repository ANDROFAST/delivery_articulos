package com.myapps.delivery.datos;

import com.myapps.delivery.util.HttpPostValues;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Vector;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;

public class Http {
    public static final String URL_IMAGENES = "http://negocioe.netau.net/imagenes/";
    public static final String URL_WEB_SERVICE = "http://negocioe.netau.net/web-service/";

    public String enviarGet(String url) throws Exception {
        BufferedReader rd = new BufferedReader(new InputStreamReader(new DefaultHttpClient().execute(new HttpGet(url)).getEntity().getContent()));
        StringBuffer result = new StringBuffer();
        String str = "";
        while (true) {
            str = rd.readLine();
            if (str == null) {
                return result.toString();
            }
            result.append(str + "\n");
        }
    }

    public String enviarPost(String url, Vector<HttpPostValues> valores) throws Exception {
        HttpClient client = new DefaultHttpClient();
        HttpPost post = new HttpPost(url);
        Vector<NameValuePair> urlParameters = new Vector();
        for (int i = 0; i < valores.size(); i++) {
            urlParameters.add(new BasicNameValuePair(((HttpPostValues) valores.elementAt(i)).getParametro(), ((HttpPostValues) valores.elementAt(i)).getValor()));
        }
        post.setEntity(new UrlEncodedFormEntity(urlParameters));
        BufferedReader rd = new BufferedReader(new InputStreamReader(client.execute(post).getEntity().getContent()));
        StringBuffer result = new StringBuffer();
        String str = "";
        while (true) {
            str = rd.readLine();
            if (str == null) {
                return result.toString();
            }
            result.append(str + "\n");
        }
    }
}
