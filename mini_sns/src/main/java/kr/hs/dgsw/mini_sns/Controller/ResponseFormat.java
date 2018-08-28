package kr.hs.dgsw.mini_sns.Controller;

import kr.hs.dgsw.mini_sns.Model.BoardDomain;
import kr.hs.dgsw.mini_sns.Model.UserDomain;

import java.util.ArrayList;
import java.util.List;

public class ResponseFormat {
    private int code=0;
    private String description;
    private List<BoardDomain> boardDoaminList;
    private List<UserDomain> userDomainList;

    public ResponseFormat(){
        this.code=0;
        this.description="success";
        this.boardDoaminList = new ArrayList<>();
        this.userDomainList = new ArrayList<>();
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

    public List<BoardDomain> getBoardDoaminList() {
        return boardDoaminList;
    }

    public void setBoardDoaminList(List<BoardDomain> boardDoaminList) {
        this.boardDoaminList = boardDoaminList;
    }

    public List<UserDomain> getUserDomainList() {
        return userDomainList;
    }

    public void setUserDomainList(List<UserDomain> userDomainList) {
        this.userDomainList = userDomainList;
    }
}
