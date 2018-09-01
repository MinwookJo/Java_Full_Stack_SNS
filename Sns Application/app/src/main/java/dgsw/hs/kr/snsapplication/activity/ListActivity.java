package dgsw.hs.kr.snsapplication.activity;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

import java.util.ArrayList;

import dgsw.hs.kr.snsapplication.R;
import dgsw.hs.kr.snsapplication.adapter.RecyclerAdapter;
import dgsw.hs.kr.snsapplication.databinding.ActivityListBinding;
import dgsw.hs.kr.snsapplication.network.RetroBaseApi;
import dgsw.hs.kr.snsapplication.constant.ApiMessage;
import dgsw.hs.kr.snsapplication.network.RetroModel.BoardDomain;
import dgsw.hs.kr.snsapplication.network.RetroModel.ResponseModel.ListResponse;
import dgsw.hs.kr.snsapplication.network.RetrofitClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
//게시물 리스트 액티비티
public class ListActivity extends AppCompatActivity {

    ActivityListBinding binding;
    private RetroBaseApi apiService;
    private RecyclerView.Adapter adapter;

    private ArrayList<BoardDomain> Items = new ArrayList<>();
    private int idx;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this,R.layout.activity_list);
        apiService = RetrofitClient.getApiService();
        setRecyclerView();
    }

    //리사이클러뷰 세팅
    private void setRecyclerView(){
        binding.recyclerVIew.setHasFixedSize(true);
        adapter = new RecyclerAdapter(Items,getApplicationContext());
        binding.recyclerVIew.setAdapter(adapter);
        binding.recyclerVIew.setLayoutManager(new LinearLayoutManager(this));

        sendViewList();
    }
    //게시물 리스트 가져오기 메소드
    private void sendViewList(){
        apiService.viewList().enqueue(new Callback<ListResponse>() {
            @Override
            public void onResponse(Call<ListResponse> call, Response<ListResponse> response) {
                if(response.isSuccessful()){
                    if (response.body().getDescription().equals(ApiMessage.SUCCESS_MESSAGE)){
                        for(int i=0; i<response.body().getResultList().size();i++){
                            Log.d("LISTTAG",""+response.body().getResultList().get(i));
                            Items.add(response.body().getResultList().get(i));
                        }
                        adapter.notifyDataSetChanged();
                    }else{
                        Toast.makeText(ListActivity.this, ""+response.body().getDescription(), Toast.LENGTH_SHORT).show();
                    }
                }else {
                    Toast.makeText(ListActivity.this, "Fail to get list", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<ListResponse> call, Throwable t) {
                Toast.makeText(ListActivity.this, ""+t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}
