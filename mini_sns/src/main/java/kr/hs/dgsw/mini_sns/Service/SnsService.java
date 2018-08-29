package kr.hs.dgsw.mini_sns.Service;

import kr.hs.dgsw.mini_sns.Controller.ResponseFormat;
import kr.hs.dgsw.mini_sns.Model.BoardDomain;
import kr.hs.dgsw.mini_sns.Model.UserDomain;

public interface SnsService {
    public ResponseFormat viewUser(int idx);
    public ResponseFormat insertUser(UserDomain user);
    public ResponseFormat updateUser(UserDomain user);
    public ResponseFormat deleteUser(int idx);

    public ResponseFormat viewList();
    public ResponseFormat viewBoard(int idx);
    public ResponseFormat writeBoard(BoardDomain boardDomain);
    public ResponseFormat updateBoard(BoardDomain boardDomain);
    public ResponseFormat deleteBoard(int idx);

    public ResponseFormat like(UserDomain userDomain,BoardDomain boardDomain);

}
