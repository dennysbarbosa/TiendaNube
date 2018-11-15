package com.tiendanube;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Toast;
import com.tiendanube.api.ApiServices;
import com.tiendanube.net.RetrofitConnection;

public class TiendaNubeApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
    }


    public void deviceFullScreen(Context context){

        Activity activity = (Activity) context;
        activity.requestWindowFeature(Window.FEATURE_NO_TITLE);
        activity.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
    }

    public ApiServices getServicesAnimals(){
        return new RetrofitConnection().connection(BuildConfig.API_URL).create(ApiServices.class);
    }

}
