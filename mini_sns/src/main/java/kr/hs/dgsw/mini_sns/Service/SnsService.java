package kr.hs.dgsw.mini_sns.Service;

import kr.hs.dgsw.mini_sns.Model.BoardDomain;
import kr.hs.dgsw.mini_sns.Model.UserDomain;

public interface SnsService {
    public UserDomain viewUser(UserDomain userDomain);
    public int insertUser(UserDomain user);
    public int updateUser(UserDomain user);
    public int deleteUser(int idx);

    public BoardDomain viewBoard(BoardDomain boardDomain);
    public int writeBoard(BoardDomain boardDomain);
    public int updateBoard(BoardDomain boardDomain);
    public int delteBoard(int idx);

    public int like(UserDomain userDomain,BoardDomain boardDomain);

}
