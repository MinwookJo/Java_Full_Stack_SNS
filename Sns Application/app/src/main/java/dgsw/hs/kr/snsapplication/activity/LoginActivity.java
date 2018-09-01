package dgsw.hs.kr.snsapplication.activity;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import dgsw.hs.kr.snsapplication.R;
import dgsw.hs.kr.snsapplication.constant.USER_IDX;
import dgsw.hs.kr.snsapplication.databinding.ActivityLoginBinding;
import dgsw.hs.kr.snsapplication.network.RetroBaseApi;
import dgsw.hs.kr.snsapplication.constant.ApiMessage;
import dgsw.hs.kr.snsapplication.network.RetroModel.UserDomain;
import dgsw.hs.kr.snsapplication.network.RetroModel.ResponseModel.UserResponse;
import dgsw.hs.kr.snsapplication.network.RetrofitClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
//로그인 액티비티
public class LoginActivity extends AppCompatActivity {
    //데이터바인딩
    ActivityLoginBinding binding;
    //레트로핏
    private RetroBaseApi apiService;
    //유저모델
    UserDomain userDomain = new UserDomain();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this,R.layout.activity_login);
        apiService = RetrofitClient.getApiService();
    }


    //클릭시 함수들
    public void clickLoginBtn(View view){
        userDomain.setId(binding.idEdit.getText().toString());
        userDomain.setPwd(binding.pwdEdit.getText().toString());
        sendLogin(userDomain);
    }

    public void clickSignupBtn(View view){
        Intent intent=new Intent(LoginActivity.this,SignUpActivity.class);
        startActivity(intent);
    }

    //로그인 API호출
    private void sendLogin(UserDomain userDomain){
        apiService.login(userDomain).enqueue(new Callback<UserResponse>() {
            @Override
            public void onResponse(Call<UserResponse> call, Response<UserResponse> response) {
                if(response.isSuccessful()){
                    if (response.body().getDescription().equals(ApiMessage.SUCCESS_MESSAGE)){
                        Toast.makeText(LoginActivity.this, response.body().getResultList().get(0).userName+"님 반갑습니다", Toast.LENGTH_SHORT).show();
                        USER_IDX.USER_IDX = response.body().getResultList().get(0).getIdx();
                        Intent intent=new Intent(LoginActivity.this,ListActivity.class);
                        startActivity(intent);
                    }else{
                        Toast.makeText(LoginActivity.this, ""+response.body().getDescription(), Toast.LENGTH_SHORT).show();
                    }
                }else {
                    Toast.makeText(LoginActivity.this, "Login Fail", Toast.LENGTH_SHORT).show();
                }
            }
            @Override
            public void onFailure(Call<UserResponse> call, Throwable t) {
                Toast.makeText(LoginActivity.this, ""+t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

}
