package dgsw.hs.kr.snsapplication.network.RetroModel.ResponseModel;

import java.util.List;

import dgsw.hs.kr.snsapplication.network.RetroModel.BoardDomain;
//게시물 리스트 응답모델
public class ListResponse implements Response {
    int code;
    String description;
    List<BoardDomain> resultList;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String descreption) {
        this.description = descreption;
    }

    public List<BoardDomain> getResultList() {
        return resultList;
    }

    public void setResultList(List<BoardDomain> resultList) {
        this.resultList = resultList;
    }
}
