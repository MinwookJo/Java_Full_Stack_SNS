package dgsw.hs.kr.snsapplication.network.RetroModel.ResponseModel;

import java.util.List;
//종아요 숫자 응답모델
public class viewLikeResponse implements Response {
    int code;
    String description;
    List<Integer> resultList;

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

    public List<Integer> getResultList() {
        return resultList;
    }

    public void setResultList(List<Integer> resultList) {
        this.resultList = resultList;
    }
}
