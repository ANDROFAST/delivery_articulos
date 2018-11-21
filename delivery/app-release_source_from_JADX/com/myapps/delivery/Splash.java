package com.myapps.delivery;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class Splash extends Activity {

    class C04901 implements AnimationListener {
        C04901() {
        }

        public void onAnimationStart(Animation animation) {
        }

        public void onAnimationEnd(Animation animation) {
            Splash.this.finish();
            Splash.this.startActivity(new Intent(Splash.this.getBaseContext(), Logueo.class));
        }

        public void onAnimationRepeat(Animation animation) {
        }
    }

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(C0477R.layout.splash);
        ImageView iv = (ImageView) findViewById(C0477R.id.imagenSplash);
        Animation an = AnimationUtils.loadAnimation(getBaseContext(), C0477R.anim.aparecer);
        iv.startAnimation(an);
        getWindow().setFlags(1024, 1024);
        an.setAnimationListener(new C04901());
    }
}
