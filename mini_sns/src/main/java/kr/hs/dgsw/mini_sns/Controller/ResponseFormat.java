package kr.hs.dgsw.mini_sns.Controller;

import kr.hs.dgsw.mini_sns.Model.BoardDomain;
import kr.hs.dgsw.mini_sns.Model.UserDomain;

import java.util.ArrayList;
import java.util.List;

public class ResponseFormat<T> {
    private int code=0;
    private String description;
    private List<T> resultList;

    public ResponseFormat(){
        this.code=0;
        this.description="success";
        this.resultList = new ArrayList<>();
    }

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

    public List<T> getResultList() {
        return resultList;
    }

    public void setResultList(List<T> resultList) {
        this.resultList = resultList;
    }

    public void setResultList(T t){
        this.resultList.add(t);
    }
}
