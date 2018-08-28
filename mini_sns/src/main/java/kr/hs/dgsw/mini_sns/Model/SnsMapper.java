package kr.hs.dgsw.mini_sns.Model;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface SnsMapper {
    public UserDomain viewUser(UserDomain userDomain);
    public int insertUser(UserDomain user);
    public int updateUser(UserDomain user);
    public int deleteUser(@Param("idx")int idx);

    public BoardDomain viewBoard(BoardDomain boardDomain);
    public int writeBoard(BoardDomain boardDomain);
    public int updateBoard(BoardDomain boardDomain);
    public int delteBoard(@Param("idx")int idx);

    public int like(UserDomain userDomain,BoardDomain boardDomain);
}
