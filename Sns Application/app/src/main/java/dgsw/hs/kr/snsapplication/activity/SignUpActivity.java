package dgsw.hs.kr.snsapplication.activity;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import dgsw.hs.kr.snsapplication.R;
import dgsw.hs.kr.snsapplication.databinding.ActivitySignUpBinding;
import dgsw.hs.kr.snsapplication.network.RetroBaseApi;
import dgsw.hs.kr.snsapplication.constant.ApiMessage;
import dgsw.hs.kr.snsapplication.network.RetroModel.UserDomain;
import dgsw.hs.kr.snsapplication.network.RetroModel.ResponseModel.UserResponse;
import dgsw.hs.kr.snsapplication.network.RetrofitClient;
import dgsw.hs.kr.snsapplication.other_class.PatternChecker;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
//회원가입 액티비티
public class SignUpActivity extends AppCompatActivity {
    //데이터바인딩
    ActivitySignUpBinding binding;
    //레트로핏
    private RetroBaseApi apiService;
    //유저모델
    UserDomain userDomain = new UserDomain();
    //정규식
    PatternChecker checker = new PatternChecker();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        binding = DataBindingUtil.setContentView(this,R.layout.activity_sign_up);
        apiService = RetrofitClient.getApiService();
    }

    //클릭시함수들
    public void clickOkBtn(View view){
        if(checker.SignPasswordCheck(binding.signupPwdEdit.getText().toString())) {
            userDomain.setUserName(binding.signupNameEdit.getText().toString());
            userDomain.setId(binding.signupIdEdit.getText().toString());
            userDomain.setPwd(binding.signupPwdEdit.getText().toString());
            sendSignUp(userDomain);
        }else{
            Toast.makeText(this, "양식을 맞춰주세요.", Toast.LENGTH_SHORT).show();
        }
    }
    public void clickNoBtn(View view){
        finish();
    }

    private void sendSignUp(UserDomain userDomain){
        apiService.signUp(userDomain).enqueue(new Callback<UserResponse>() {
            @Override
            public void onResponse(Call<UserResponse> call, Response<UserResponse> response) {
                if(response.isSuccessful()){
                    if (response.body().getDescription().equals(ApiMessage.SUCCESS_MESSAGE)){
                        //성공시
                        Toast.makeText(SignUpActivity.this, "회원가입성공", Toast.LENGTH_SHORT).show();
                        Intent intent=new Intent(SignUpActivity.this,LoginActivity.class);
                        startActivity(intent);
                    }else{
                        Toast.makeText(SignUpActivity.this, ""+response.body().getDescription(), Toast.LENGTH_SHORT).show();
                    }
                }else {
                    Toast.makeText(SignUpActivity.this, "Signup Fail", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<UserResponse> call, Throwable t) {
                Toast.makeText(SignUpActivity.this, ""+t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}
