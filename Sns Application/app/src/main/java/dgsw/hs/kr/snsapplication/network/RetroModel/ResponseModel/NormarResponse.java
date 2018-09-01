package dgsw.hs.kr.snsapplication.network.RetroModel.ResponseModel;

import java.util.List;

import dgsw.hs.kr.snsapplication.network.RetroModel.BoardDomain;

public class NormarResponse {
    int code;
    String description;

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
}
