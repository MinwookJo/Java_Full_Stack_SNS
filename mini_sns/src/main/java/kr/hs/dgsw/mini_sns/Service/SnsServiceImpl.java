package kr.hs.dgsw.mini_sns.Service;

import kr.hs.dgsw.mini_sns.Model.BoardDomain;
import kr.hs.dgsw.mini_sns.Model.SnsMapper;
import kr.hs.dgsw.mini_sns.Model.UserDomain;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SnsServiceImpl implements SnsService{
    @Autowired
    SnsMapper snsMapper;

    @Override
    public UserDomain viewUser(UserDomain userDomain) {
        return null;
    }

    @Override
    public int insertUser(UserDomain user) {
        return 0;
    }

    @Override
    public int updateUser(UserDomain user) {
        return 0;
    }

    @Override
    public int deleteUser(int idx) {
        return 0;
    }

    @Override
    public BoardDomain viewBoard(BoardDomain boardDomain) {
        return null;
    }

    @Override
    public int writeBoard(BoardDomain boardDomain) {
        return 0;
    }

    @Override
    public int updateBoard(BoardDomain boardDomain) {
        return 0;
    }

    @Override
    public int delteBoard(int idx) {
        return 0;
    }

    @Override
    public int like(UserDomain userDomain, BoardDomain boardDomain) {
        return 0;
    }
}
