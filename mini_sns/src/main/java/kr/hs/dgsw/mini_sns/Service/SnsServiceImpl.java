package kr.hs.dgsw.mini_sns.Service;

import kr.hs.dgsw.mini_sns.Controller.ResponseFormat;
import kr.hs.dgsw.mini_sns.Model.BoardDomain;
import kr.hs.dgsw.mini_sns.Model.LikeDomain;
import kr.hs.dgsw.mini_sns.Model.SnsMapper;
import kr.hs.dgsw.mini_sns.Model.UserDomain;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SnsServiceImpl implements SnsService{
    @Autowired
    SnsMapper snsMapper;

    @Override
    public ResponseFormat viewUser(int idx) {
        ResponseFormat rf = new ResponseFormat();
        UserDomain userDomain = snsMapper.viewUser(idx);
        if(userDomain==null){
            rf.setCode(101);
            rf.setDescription("Fail to get user");
        }else {
            rf.setResultList(userDomain);
        }
        return rf;
    }

    @Override
    public ResponseFormat insertUser(UserDomain user) {
        ResponseFormat rf = new ResponseFormat();
        int num_affected = snsMapper.insertUser(user);
        if(num_affected == 0){
            rf.setCode(102);
            rf.setDescription("Fail to insert user");
        }
        return rf;
    }

    @Override
    public ResponseFormat login(UserDomain user) {
        ResponseFormat rf = new ResponseFormat();
        UserDomain userDomain = snsMapper.login(user);
        if(userDomain==null){
            rf.setCode(101);
            rf.setDescription("Fail to get user");
        }else {
            rf.setResultList(userDomain);
        }
        return rf;
    }

    @Override
    public ResponseFormat viewList() {
        ResponseFormat rf = new ResponseFormat();
        List<BoardDomain> boardDomainList = snsMapper.viewList();
        if(boardDomainList==null){
            rf.setCode(103);
            rf.setDescription("Fail to get Board List");
        }else {
            rf.setResultList(boardDomainList);
        }
        return rf;
    }

    @Override
    public ResponseFormat viewBoard(int idx) {
        ResponseFormat rf = new ResponseFormat();
        BoardDomain boardDomain = snsMapper.viewBoard(idx);

        if(boardDomain==null){
            rf.setCode(104);
            rf.setDescription("Fail to get Board");
        }else {
            rf.setResultList(boardDomain);
        }
        return rf;
    }

    @Override
    public ResponseFormat writeBoard(BoardDomain boardDomain) {
        ResponseFormat rf = new ResponseFormat();
        int num_affected = snsMapper.writeBoard(boardDomain);
        if(num_affected == 0) {
            rf.setCode(105);
            rf.setDescription("Fail to add Board");
        }
        return rf;
    }

    @Override
    public ResponseFormat updateBoard(BoardDomain boardDomain,int userIdx) {
        ResponseFormat rf = new ResponseFormat();
        int num_affected = 0;

        System.out.print("결과"+userIdx+"AND"+boardDomain.userIdx);
        if(boardDomain.userIdx==userIdx){
            num_affected = snsMapper.updateBoard(boardDomain);
        }

        if(num_affected == 0){
            rf.setCode(106);
            rf.setDescription("Fail to update Board");
        }
        return rf;
    }

    @Override
    public ResponseFormat deleteBoard(int idx) {
        ResponseFormat rf = new ResponseFormat();
        int num_affected = snsMapper.deleteBoard(idx);
        if(num_affected == 0){
            rf.setCode(107);
            rf.setDescription("Fail to delete Board");
        }
        return rf;
    }

    @Override
    public ResponseFormat like(LikeDomain likeDomain) {
        ResponseFormat rf = new ResponseFormat();
        int num_affected = snsMapper.like(likeDomain);
        if(num_affected == 0) {
            rf.setCode(108);
            rf.setDescription("Fail to like");
        }
        return rf;
    }

    @Override
    public ResponseFormat viewLikeCount(int idx) {
        ResponseFormat rf = new ResponseFormat();
        int count = -1;
        count = snsMapper.viewLikeCount(idx);
        if(count==-1){
            rf.setCode(110);
            rf.setDescription("Fail to view like count");
        }else {
            rf.setResultList(count);
        }
        return rf;
    }
}
