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
import com.tiendanube.R;
import com.tiendanube.interfaces.AsyncTaskDelegate;
import com.tiendanube.model.DogModel;
import com.tiendanube.presentation.activity.HomeActivity;
import com.tiendanube.presentation.adapter.CommonAdapter;
import com.tiendanube.service.DogServiceAsyncTask;

import java.util.List;

public class DogFragment extends Fragment implements AsyncTaskDelegate, View.OnClickListener {

    private RecyclerView recyclerView;
    private Button btnTryAgain;
    private View view;
    public List<DogModel> listDogs;
    private static int page = 0;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

         super.onCreateView(inflater, container, savedInstanceState);
         view = inflater.inflate(R.layout.cat_fragment, container, false);
         initViews();
         getDogs();

         return view;
    }

    private void getDogs(){
        new DogServiceAsyncTask(getActivity(), page).execute();
    }

    private void initViews(){

        btnTryAgain = view.findViewById(R.id.btn_try_again);
        btnTryAgain.setOnClickListener(this);
        recyclerView = view.findViewById(R.id.recycler_view);

        GridLayoutManager gridLayoutManager = new GridLayoutManager(getActivity(), 4);
        gridLayoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
            @Override
            public int getSpanSize(int position) {

                return 2;
            }
        });
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(gridLayoutManager);

    }

    public void showBtnTryAgain(){

        getActivity().runOnUiThread(new Runnable() {
            @Override
            public void run() {
                recyclerView.setVisibility(View.GONE);
                btnTryAgain.setVisibility(View.VISIBLE);
            }
        });

    }

    public void hideBtntryAgain(){

        getActivity().runOnUiThread(new Runnable() {
            @Override
            public void run() {
                recyclerView.setVisibility(View.VISIBLE);
                btnTryAgain.setVisibility(View.GONE);
            }
        });
    }

    @Override
    public void processFinish(Object obj) {

        if(obj != null) {

            hideBtntryAgain();
            listDogs = (List<DogModel>) obj;
            recyclerView.setAdapter(new CommonAdapter(listDogs));
        }else{
            showBtnTryAgain();
        }
    }

    @Override
    public void onClick(View v) {

        ((HomeActivity) getActivity()).animationView(v);
        switch (view.getId()){

            case R.id.btn_try_again:

                getDogs();
                break;
        }
    }
}
