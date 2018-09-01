package dgsw.hs.kr.snsapplication.network.RetroModel.ResponseModel;

import java.util.ArrayList;

import dgsw.hs.kr.snsapplication.network.RetroModel.BoardDomain;
//게시물 상세보기 응답모델
public class DetailResponse implements Response {
    int code;
    String description;
    ArrayList<BoardDomain> resultList;

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

    public ArrayList<BoardDomain> getResultList() {
        return resultList;
    }

    public void setResultList(ArrayList<BoardDomain> resultList) {
        this.resultList = resultList;
    }
}
