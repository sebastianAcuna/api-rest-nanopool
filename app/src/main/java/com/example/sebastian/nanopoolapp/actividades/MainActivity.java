package com.example.sebastian.nanopoolapp.actividades;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.TextView;

import com.example.sebastian.nanopoolapp.R;
import com.example.sebastian.nanopoolapp.adapters.MyAdapter_lista_wrk;
import com.example.sebastian.nanopoolapp.clases.AvgHashrate;
import com.example.sebastian.nanopoolapp.clases.Data;
import com.example.sebastian.nanopoolapp.clases.EstadoPool;
import com.example.sebastian.nanopoolapp.clases.HsPool;
import com.example.sebastian.nanopoolapp.clases.Worker;
import com.example.sebastian.nanopoolapp.retrofit.RetrofitInterface;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    TextView ethCant,hsCant ,h1,h3,h6,h12,h24;
    ArrayList<Worker> listaCarga;
    //VARIABLES PARA RECYCLER VIEW
    private RecyclerView recyclerMarca;
    private MyAdapter_lista_wrk adapterMarca;
    private RecyclerView.LayoutManager lManagerMarca;
    //VARIABLES PARA RECYCLER VIEW
    private ProgressDialog dialog;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ethCant = findViewById(R.id.cant_eth);
        hsCant = findViewById(R.id.hs_cant);



        //SE OBTIENE RECYCLER Y SE CONFIGURAN SUS PARAMETROS
        recyclerMarca = findViewById(R.id.lista_wrk);
        recyclerMarca.setHasFixedSize(true);
        lManagerMarca = new LinearLayoutManager(this);
        recyclerMarca.setLayoutManager(lManagerMarca);
        //SE OBTIENE RECYCLER Y SE CONFIGURAN SUS PARAMETROS

        loadBalance();
        //loadCurrentHS();
    }


    private void loadBalance() {
        dialog = new ProgressDialog(this);
        dialog.setMessage("Obteniendo datos del servidor");
        dialog.setCancelable(false);
        dialog.show();

        Gson gson = new GsonBuilder()
                .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
                .create();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.nanopool.org/v1/eth/user/")
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        RetrofitInterface restClient = retrofit.create(RetrofitInterface.class);
        Call<EstadoPool> call = restClient.getData();

        call.enqueue(new Callback<EstadoPool>() {
            @Override
            public void onResponse(Call<EstadoPool> call, Response<EstadoPool> response) {
                switch (response.code()) {
                    case 200:
                        EstadoPool data = response.body();

                        ethCant.setText(data.getData().getBalance().toString());
                        hsCant.setText(data.getData().getHashrate().toString());

                        //h1.setText(data.getData().getAvgHashrate().getClass().toString());
                        /*h3.setText(data.getData().getAvgHashrate().getH3());
                        h6.setText(data.getData().getAvgHashrate().getH6());
                        h12.setText(data.getData().getAvgHashrate().getH12());
                        h24.setText(data.getData().getAvgHashrate().getH24());*/
                        listaCarga = new ArrayList<Worker>();

                        for (int i = 0; i < data.getData().getWorkers().size(); i++) {
                            Worker trab = new Worker();
                            trab.setHashrate(data.getData().getWorkers().get(i).getHashrate());

                            trab.setH1(data.getData().getWorkers().get(i).getH1());
                            trab.setH3(data.getData().getWorkers().get(i).getH3());
                            trab.setH6(data.getData().getWorkers().get(i).getH6());
                            trab.setH12(data.getData().getWorkers().get(i).getH12());
                            trab.setH24(data.getData().getWorkers().get(i).getH24());
                            trab.setId(data.getData().getWorkers().get(i).getId());
                            listaCarga.add(trab);
                            //System.out.println(data.getData().getWorkers().get(i).getH1());
                        }

                        adapterMarca = new MyAdapter_lista_wrk(getApplicationContext(), listaCarga );
                        recyclerMarca.setAdapter(adapterMarca);
                        break;
                    case 401:

                        break;
                    default:

                        break;
                }
                dialog.dismiss();
            }

            @Override
            public void onFailure(Call<EstadoPool> call, Throwable t) {
                Log.e("error", t.toString());
            }

        });
    }
/*
        private void loadCurrentHS () {
            Gson gson = new GsonBuilder()
                    .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
                    .create();

            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl("https://api.nanopool.org/v1/eth/hashrate/")
                    .addConverterFactory(GsonConverterFactory.create(gson))
                    .build();

            RetrofitInterface restClient = retrofit.create(RetrofitInterface.class);
            Call<HsPool> call = restClient.getHS();

            call.enqueue(new Callback<HsPool>() {
                @Override
                public void onResponse(Call<HsPool> call, Response<HsPool> response) {
                    switch (response.code()) {
                        case 200:
                            HsPool hs = response.body();
                            hsCant.setText(hs.getData().toString());
                            //view.notifyDataSetChanged(data.getResults());
                            break;
                        case 401:

                            break;
                        default:

                            break;
                    }
                }

                @Override
                public void onFailure(Call<HsPool> call, Throwable t) {
                    Log.e("error", t.toString());
                }

            });

        }*/

























    //FUNCION PARA CARGAR EL MENÚ DEL ACTIONBAR
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu_main_activity items for use in the action bar
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_principal, menu);
        return super.onCreateOptionsMenu(menu);
    }

    //OPTION SELECT SE DEFINE LAS ACCIONES A REALIZAR LUEGO DE PRESIONAR LOS BOTONES DEL MENU
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_down_data: //SI SE SELECCIONA SE ENVIA A ACTIVIDAD CREAR_MARCACION PASANDOLE RUT EMPLEADO Y NOMBRE
                loadBalance();
                //loadCurrentHS();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
