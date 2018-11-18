package com.tiendanube;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.view.Window;
import android.view.WindowManager;
import com.tiendanube.api.ApiServices;
import com.tiendanube.net.RetrofitConnection;

/*
 * Instancia unica padrao de aplicativos android.
 */
public class TiendaNubeApplication extends Application {

    public static final String TYPE_DOG = "typeDog";
    public static final String TYPE_CAT = "typeCat";

    @Override
    public void onCreate() {
        super.onCreate();
    }

    /*
     * metodo responsavel por exibir tela no modo full screen (tela splash_screen).
     */
    public void deviceFullScreen(Context context){

        Activity activity = (Activity) context;
        activity.requestWindowFeature(Window.FEATURE_NO_TITLE);
        activity.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
    }

    /*
     * metodo utilizado pelas classes (CatServiceAyncTask e DogAsyncTask), retorna instancia Retrofit
     * com configuracoes de hearder.
     */
    public ApiServices getServicesAnimals(String type){

        if(type.equals(TYPE_DOG)) {
            return new RetrofitConnection().connection(BuildConfig.API_URL_DOG).create(ApiServices.class);
        }else{
            return new RetrofitConnection().connection(BuildConfig.API_URL_CAT).create(ApiServices.class);
        }
    }

}
