package dgsw.hs.kr.snsapplication.activity;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import dgsw.hs.kr.snsapplication.R;
import dgsw.hs.kr.snsapplication.constant.ApiMessage;
import dgsw.hs.kr.snsapplication.constant.USER_IDX;
import dgsw.hs.kr.snsapplication.databinding.ActivityWriteAndUpdateBinding;
import dgsw.hs.kr.snsapplication.network.RetroBaseApi;
import dgsw.hs.kr.snsapplication.network.RetroModel.BoardDomain;
import dgsw.hs.kr.snsapplication.network.RetroModel.ResponseModel.NormarResponse;
import dgsw.hs.kr.snsapplication.network.RetrofitClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

//글쓰기, 수정 액티비티
public class WriteAndUpdateActivity extends AppCompatActivity {
    ActivityWriteAndUpdateBinding binding;
    String purpose = "";
    private RetroBaseApi apiService;
    int boardIdx = 0;
    BoardDomain boardDomain = new BoardDomain();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_write_and_update);
        apiService = RetrofitClient.getApiService();
        selcetTitle();
    }

    public void clickDoneBtn(View view){
        if(purpose.equals("write")){
            boardDomain.setTitle(binding.DUTitleEdit.getText().toString());
            boardDomain.setContent(binding.DUContentEdit.getText().toString());
            boardDomain.setUserIdx(USER_IDX.USER_IDX);
            sendWrite(boardDomain);
        }else if(purpose.equals("update")){
            boardDomain.setTitle(binding.DUTitleEdit.getText().toString());
            boardDomain.setContent(binding.DUContentEdit.getText().toString());
            System.out.print(boardIdx+"결곽");
            boardDomain.setIdx(boardIdx);
            sendUpdate(boardDomain);
        }
    }

    //제목결정 Update, Write
    private void selcetTitle() {
        Intent intent = getIntent();
        purpose = intent.getExtras().getString("purpose");
        boardIdx = intent.getExtras().getInt("boardIdx");
        if (purpose.equals("write")) {
            binding.DUTitle.setText("Write");
        } else if (purpose.equals("update")) {
            binding.DUTitle.setText("Update");
        }
    }

    private void sendWrite(BoardDomain board){
        apiService.write(board).enqueue(new Callback<NormarResponse>() {
            @Override
            public void onResponse(Call<NormarResponse> call, Response<NormarResponse> response) {
                if(response.isSuccessful()){
                    if (response.body().getDescription().equals(ApiMessage.SUCCESS_MESSAGE)) {
                        //성공시
                        Toast.makeText(WriteAndUpdateActivity.this, "게시물 작성을 성공했습니다", Toast.LENGTH_SHORT).show();
                        finish();
                    }
                    else {
                        Toast.makeText(WriteAndUpdateActivity.this, ""+response.body().getDescription(), Toast.LENGTH_SHORT).show(); }
                } else{
                    Toast.makeText(WriteAndUpdateActivity.this, "Fail to get like", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<NormarResponse> call, Throwable t) {
                Toast.makeText(WriteAndUpdateActivity.this, ""+t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void sendUpdate(BoardDomain board){
        apiService.update(board).enqueue(new Callback<NormarResponse>() {
            @Override
            public void onResponse(Call<NormarResponse> call, Response<NormarResponse> response) {
                if(response.isSuccessful()){
                    if (response.body().getDescription().equals(ApiMessage.SUCCESS_MESSAGE)) {
                        //성공시
                        Toast.makeText(WriteAndUpdateActivity.this, "게시물 수정을 성공했습니다", Toast.LENGTH_SHORT).show();
                        finish();
                    }
                    else {
                        Toast.makeText(WriteAndUpdateActivity.this, ""+response.body().getDescription(), Toast.LENGTH_SHORT).show(); }
                } else{
                    Toast.makeText(WriteAndUpdateActivity.this, "Fail to update", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<NormarResponse> call, Throwable t) {
                Toast.makeText(WriteAndUpdateActivity.this, ""+t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

}
