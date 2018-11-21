package com.myapps.delivery;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.TextView;
import org.apache.http.util.EncodingUtils;

public class EstadisticasArticulo extends Activity {
    Button btnDeGraficoAArticulo;
    TextView lblTVNombreArticulo;
    WebView vistaPagina;

    class C04621 implements OnClickListener {
        C04621() {
        }

        public void onClick(View v) {
            EstadisticasArticulo.this.finish();
        }
    }

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(C0477R.layout.grafico_webview_articulo_votos);
        this.btnDeGraficoAArticulo = (Button) findViewById(C0477R.id.btnDeGraficoAArticulo);
        this.btnDeGraficoAArticulo.setOnClickListener(new C04621());
        this.lblTVNombreArticulo = (TextView) findViewById(C0477R.id.lblTVNombreArticulo);
        this.vistaPagina = (WebView) findViewById(C0477R.id.webview);
        this.vistaPagina.getSettings().setJavaScriptEnabled(true);
        this.vistaPagina.setWebViewClient(new WebViewClient());
        Bundle parametros = getIntent().getExtras();
        int codigo_articulo = parametros.getInt("cod_articulo");
        this.lblTVNombreArticulo.setText(parametros.getString("nombre_articulo"));
        this.vistaPagina.postUrl("http://negocioe.netau.net/web-service/grafico-resultado-votacion.php", EncodingUtils.getBytes("cod_articulo=" + codigo_articulo, "BASE64"));
    }
}
