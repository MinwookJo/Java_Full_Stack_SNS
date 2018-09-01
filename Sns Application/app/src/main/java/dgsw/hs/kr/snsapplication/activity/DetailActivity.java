package dgsw.hs.kr.snsapplication.activity;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import dgsw.hs.kr.snsapplication.R;
import dgsw.hs.kr.snsapplication.constant.ApiMessage;
import dgsw.hs.kr.snsapplication.constant.USER_IDX;
import dgsw.hs.kr.snsapplication.databinding.ActivityDetailBinding;
import dgsw.hs.kr.snsapplication.network.RetroBaseApi;
import dgsw.hs.kr.snsapplication.network.RetroModel.ResponseModel.DetailResponse;
import dgsw.hs.kr.snsapplication.network.RetroModel.ResponseModel.viewLikeResponse;
import dgsw.hs.kr.snsapplication.network.RetrofitClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
//게시물상세 액티비티
public class DetailActivity extends AppCompatActivity {
    ActivityDetailBinding binding;
    private RetroBaseApi apiService;

    private int idx;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this,R.layout.activity_detail);
        apiService = RetrofitClient.getApiService();
        Intent intent = getIntent();
        idx  = intent.getExtras().getInt("idx");

        sendviewBoard(idx);
        sendViewLike(idx);
    }

    //좋아요숫자보기 메소드
    private void sendViewLike(int idx){
        apiService.viewLike(idx).enqueue(new Callback<viewLikeResponse>() {
            @Override
            public void onResponse(Call<viewLikeResponse> call, Response<viewLikeResponse> response) {
                if(response.isSuccessful()){
                    if (response.body().getDescription().equals(ApiMessage.SUCCESS_MESSAGE)) {
                        binding.likeTxt.setText(response.body().getResultList().get(0)+"");
                    }
                    else {
                        Toast.makeText(DetailActivity.this, ""+response.body().getDescription(), Toast.LENGTH_SHORT).show(); }
                } else{
                    Toast.makeText(DetailActivity.this, "Fail to get like", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<viewLikeResponse> call, Throwable t) {
                Toast.makeText(DetailActivity.this, ""+t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    //게시물 가져오기 메소드
    private void sendviewBoard(int idx){
        apiService.viewBoard(idx).enqueue(new Callback<DetailResponse>() {
            @Override
            public void onResponse(Call<DetailResponse> call, Response<DetailResponse> response) {
                if(response.isSuccessful()){
                    if (response.body().getDescription().equals(ApiMessage.SUCCESS_MESSAGE)) {
                        binding.dTitleTxt.setText(response.body().getResultList().get(0).getTitle());
                        binding.dContentTxt.setText(response.body().getResultList().get(0).getContent());
                        if (USER_IDX.USER_IDX == response.body().getResultList().get(0).getUserIdx()) {
                            binding.writeOwner.setText("내글");
                            binding.writeOwner.setTextColor(Color.parseColor("#33b5e5"));
                        }
                    }
                    else {
                        Toast.makeText(DetailActivity.this, ""+response.body().getDescription(), Toast.LENGTH_SHORT).show();
                    }
                } else{
                    Toast.makeText(DetailActivity.this, "Fail to get list item", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<DetailResponse> call, Throwable t) {
                Toast.makeText(DetailActivity.this, ""+t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}
