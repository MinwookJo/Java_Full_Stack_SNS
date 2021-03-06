package dgsw.hs.kr.snsapplication.network;

import dgsw.hs.kr.snsapplication.network.RetroModel.BoardDomain;
import dgsw.hs.kr.snsapplication.network.RetroModel.LikeDomain;
import dgsw.hs.kr.snsapplication.network.RetroModel.ResponseModel.DetailResponse;
import dgsw.hs.kr.snsapplication.network.RetroModel.ResponseModel.ListResponse;
import dgsw.hs.kr.snsapplication.network.RetroModel.ResponseModel.NormarResponse;
import dgsw.hs.kr.snsapplication.network.RetroModel.ResponseModel.viewLikeResponse;
import dgsw.hs.kr.snsapplication.network.RetroModel.UserDomain;
import dgsw.hs.kr.snsapplication.network.RetroModel.ResponseModel.UserResponse;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface RetroBaseApi {
    @POST("/user/login")
    Call<UserResponse> login(@Body UserDomain userDomain);

    @POST("/user")
    Call<UserResponse> signUp(@Body UserDomain userDomain);

    @GET("/board")
    Call<ListResponse> viewList();

    @GET("/board/{idx}")
    Call<DetailResponse> viewBoard(@Path("idx") int idx);

    @GET("/board/like/{idx}")
    Call<viewLikeResponse> viewLike(@Path("idx") int idx);

    @POST("/board/like")
    Call<NormarResponse> like(@Body LikeDomain likeDomain);

    @DELETE("/board/{idx}")
    Call<NormarResponse> delete(@Path("idx")int idx);

    @PUT("/board")
    Call<NormarResponse> update(@Body BoardDomain boardDomain);

    @POST("/board")
    Call<NormarResponse> write(@Body BoardDomain boardDomain);
}
