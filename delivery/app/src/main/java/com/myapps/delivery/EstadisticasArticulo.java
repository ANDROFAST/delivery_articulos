package com.myapps.delivery;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.TextView;

import com.myapps.delivery.datos.Http;
import org.apache.http.util.EncodingUtils;

public class EstadisticasArticulo extends Activity{
	WebView vistaPagina;
	Button btnDeGraficoAArticulo;
    TextView lblTVNombreArticulo;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.grafico_webview_articulo_votos);

        btnDeGraficoAArticulo=(Button)findViewById(R.id.btnDeGraficoAArticulo);
        btnDeGraficoAArticulo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        lblTVNombreArticulo=(TextView)findViewById(R.id.lblTVNombreArticulo);

		vistaPagina= (WebView) findViewById(R.id.webview);
        //vistaPagina.loadUrl(Http.URL_WEB_SERVICE + "grafico-resultado-votacion_1.php");
        WebSettings webSettings = vistaPagina.getSettings();
        webSettings.setJavaScriptEnabled(true);
        vistaPagina.setWebViewClient(new WebViewClient());

		Bundle parametros = this.getIntent().getExtras();

		int codigo_articulo = parametros.getInt("cod_articulo");
        String nom_articulo= parametros.getString("nombre_articulo");
        lblTVNombreArticulo.setText(nom_articulo);

        byte[] post = EncodingUtils.getBytes("cod_articulo="+codigo_articulo, "BASE64");
        vistaPagina.postUrl(Http.URL_WEB_SERVICE+"grafico-resultado-votacion.php",post);

        /*
        WebView browser = (WebView)findViewById(R.id.webkit);
        byte[] post = EncodingUtils.getBytes("argumento1=valor1&argumento2=valor2", "BASE64");
        browser.postUrl("https://sis-t.redsys.es:25443/sis/realizarPago", post);
        */
	}

	/*
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		getMenuInflater().inflate(R.menu.registrar_usuario, menu);
		return true;
	}


	@Override
	public boolean onOptionsItemSelected(MenuItem item) {

		int id = item.getItemId();
		switch (id){
			case R.id.action_settings1:
				return true;
		}
		return super.onOptionsItemSelected(item);
	}
	*/
		
	
}
