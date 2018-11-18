package com.tiendanube.presentation.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ProgressBar;
import com.tiendanube.R;
import com.tiendanube.interfaces.AsyncTaskDelegate;
import com.tiendanube.model.CatModel;
import com.tiendanube.presentation.activity.HomeActivity;
import com.tiendanube.presentation.adapter.CatAdapter;
import com.tiendanube.service.CatServiceAsyncTask;

import java.util.List;

public class CatFragment extends Fragment implements AsyncTaskDelegate, View.OnClickListener {

    private RecyclerView recyclerViewCat;
    public ProgressBar progressBarCat;
    private Button btnTryAgainCat;
    private View viewCat;
    private List<CatModel> listCats;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        super.onCreateView(inflater, container, savedInstanceState);
        viewCat = inflater.inflate(R.layout.cat_fragment, container, false);
        initViews();
        getCats();

        return viewCat;
    }

    /*
     * metodo responsavel por realizar a chamada assincrona
     */
    private void getCats(){

        new CatServiceAsyncTask(this).execute();
    }

    private void initViews(){

        recyclerViewCat = viewCat.findViewById(R.id.recycler_view_cat);
        recyclerViewCat.setHasFixedSize(true);
        btnTryAgainCat = viewCat.findViewById(R.id.btn_try_again_cat);
        btnTryAgainCat.setOnClickListener(this);
        progressBarCat = viewCat.findViewById(R.id.progress_cat);
    }

    /*
     * metodo carregado apos sucesso do request, monta grid e configura
     * recycler view com uma instancia da classe CatAdapter.
     */
    private void loadRecyclerView(){

        GridLayoutManager gridLayoutManager = new GridLayoutManager(getActivity(), 4);

        gridLayoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
            @Override
            public int getSpanSize(int position) {

                return 1;
            }
        });

        recyclerViewCat.setLayoutManager(gridLayoutManager);
        recyclerViewCat.setAdapter(new CatAdapter(listCats));

    }

    /*
     * metodo de exibicao do botao de nova tentativa, caso exista falha no request.
     */
    public void showBtnTryAgainCat(){

            progressBarCat.setVisibility(View.GONE);
            recyclerViewCat.setVisibility(View.GONE);
            btnTryAgainCat.setVisibility(View.VISIBLE);

    }

    public void hideBtntryAgainCat(){

        recyclerViewCat.setVisibility(View.VISIBLE);
        btnTryAgainCat.setVisibility(View.GONE);
    }

    /*
     *  implementacao da interface AsyncTaskDelegate (retorno da AsyncTask).
     *  Carrega a list de objetos (dados do request) e Adapter.
     */
    @Override
    public void processFinish(Object obj) {

        if(obj != null){

            listCats = ((List<CatModel>) obj);
            loadRecyclerView();
        }
    }

    /*
     * metodo(contrato) para realizar animacao e gerenciar o evento de views especificas.
     */
    @Override
    public void onClick(View v) {

        ((HomeActivity) getActivity()).animationView(v);
        switch (v.getId()){

            case R.id.btn_try_again_cat:

                hideBtntryAgainCat();
                getCats();
                break;
        }
    }
}
