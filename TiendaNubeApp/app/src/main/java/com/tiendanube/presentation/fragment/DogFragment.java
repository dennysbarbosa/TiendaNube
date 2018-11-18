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
import com.github.pwittchen.infinitescroll.library.InfiniteScrollListener;
import com.tiendanube.R;
import com.tiendanube.interfaces.AsyncTaskDelegate;
import com.tiendanube.model.DogModel;
import com.tiendanube.presentation.activity.GenericActivity;
import com.tiendanube.presentation.activity.HomeActivity;
import com.tiendanube.presentation.adapter.DogAdapter;
import com.tiendanube.service.DogServiceAsyncTask;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class DogFragment extends Fragment implements AsyncTaskDelegate, View.OnClickListener {

    private static final int MAX_ITEMS_PER_REQUEST = 25;
    private static final int MAX_ITENS = 50;
    private int page;
    public List<DogModel> listDogs;
    private boolean showMessageNumItens;
    private GridLayoutManager gridLayoutManager;
    private RecyclerView recyclerView;
    public ProgressBar progressBar;
    private Button btnTryAgain;
    private View view;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        super.onCreateView(inflater, container, savedInstanceState);
        view = inflater.inflate(R.layout.dog_fragment, container, false);
        listDogs = new ArrayList<>();
        initViews();
        getDogs();

        return view;
    }

    /*
     * metodo responsavel por realizar a requisicao asincrona quando o numero de itens for menor que 50,
     * caso maior exibe menssagem para o usuario, somente uma vez.
     */
    private void getDogs(){

        if(listDogs.size() != MAX_ITENS) {

            new DogServiceAsyncTask(this, page).execute();
        }else{

            if(showMessageNumItens == false) {

                ((GenericActivity) getActivity()).showToast(getString(R.string.fragment_dog_maximum_itens));
                showMessageNumItens = true;
            }
        }
    }

    private void initViews(){

        btnTryAgain = view.findViewById(R.id.btn_try_again_dog);
        btnTryAgain.setOnClickListener(this);
        recyclerView = view.findViewById(R.id.recycler_view_dog);
        progressBar = view.findViewById(R.id.progress_dog);

    }

    private void loadRecyclerView(){

        gridLayoutManager = new GridLayoutManager(getActivity(), 4);
        gridLayoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
            @Override
            public int getSpanSize(int position) {

                return 2;
            }
        });
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(gridLayoutManager);
        recyclerView.setAdapter(new DogAdapter(listDogs));
        recyclerView.addOnScrollListener(createInfiniteScrollListener());
    }

    /*
     * metodo responsavel por gerenciar o evento de scroll, realizando novas requisicoes.
     */
    @NonNull
    private InfiniteScrollListener createInfiniteScrollListener() {
        return new InfiniteScrollListener(MAX_ITEMS_PER_REQUEST, gridLayoutManager) {
            @Override public void onScrolledToEnd(final int firstVisibleItemPosition) {

                if (progressBar.getVisibility() != View.VISIBLE) {
                    if (loadMoreItens()) {
                        refreshView(recyclerView, new DogAdapter(listDogs), firstVisibleItemPosition);
                    }
                }
            }
        };
    }

    public boolean loadMoreItens() {

        final int start = ++page * MAX_ITEMS_PER_REQUEST;
        int end = start + MAX_ITEMS_PER_REQUEST;
        final List<DogModel> itemsLocal = getItemsToBeLoaded(start, end);
        getDogs();

        if (itemsLocal != null) {

            listDogs.addAll(itemsLocal);
            return true;
        }
        return false;
    }

    public List<DogModel> getItemsToBeLoaded(int start, int end) {

        try {
            List<DogModel> newItems = listDogs.subList(start, end);
            final List<DogModel> oldItems = listDogs;
            final List<DogModel> itemsLocal = new LinkedList<>();
            itemsLocal.addAll(oldItems);
            itemsLocal.addAll(newItems);
            return itemsLocal;
        } catch (IndexOutOfBoundsException e) {
            return null;
        }
    }

    /*
     * metodo responsavel por exibir botao de nova tentativa somente na primeira requisicao.
     */
    public void showBtnTryAgain(){

        if(page == 0) {

            progressBar.setVisibility(View.GONE);
            recyclerView.setVisibility(View.GONE);
            btnTryAgain.setVisibility(View.VISIBLE);
        }
    }

    public void hideBtntryAgain(){

        recyclerView.setVisibility(View.VISIBLE);
        btnTryAgain.setVisibility(View.GONE);
    }

    @Override
    public void processFinish(Object obj) {

        if(obj != null) {

            hideBtntryAgain();
            listDogs.addAll((List<DogModel>) obj);
            if(page == 0) {
                loadRecyclerView();
            }
        }else{

            /*
             * exibe botão de nova tentativa caso a carga inicial nao aconteca
             */
            showBtnTryAgain();
        }
    }

    @Override
    public void onClick(View v) {

        ((HomeActivity) getActivity()).animationView(v);
        switch (v.getId()){

            case R.id.btn_try_again_dog:

                hideBtntryAgain();
                getDogs();
                break;
        }
    }
}
