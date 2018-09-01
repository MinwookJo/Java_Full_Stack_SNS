package dgsw.hs.kr.snsapplication.network.RetroModel.ResponseModel;

import java.util.List;

import dgsw.hs.kr.snsapplication.network.RetroModel.UserDomain;
//사용자 로그인, 회원가입 관련 응답모델
public class UserResponse implements Response {
    private int code=0;
    private String description;
    private List<UserDomain> resultList;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<UserDomain> getResultList() {
        return resultList;
    }

    public void setResultList(List<UserDomain> resultList) {
        this.resultList = resultList;
    }
}
