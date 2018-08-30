package kr.hs.dgsw.mini_sns.Model;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface SnsMapper {
    public UserDomain viewUser(@Param("idx")int idx);
    public int insertUser(UserDomain user);
    public UserDomain login(UserDomain user);

    public List<BoardDomain> viewList();
    public BoardDomain viewBoard(@Param("idx")int idx);
    public int writeBoard(BoardDomain boardDomain);
    public int updateBoard(BoardDomain boardDomain);
    public int deleteBoard(@Param("idx")int idx);

    public int like(LikeDomain likeDomain);
    public int viewLikeCount(@Param("idx")int idx);
}

