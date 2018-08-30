package kr.hs.dgsw.mini_sns.Controller;

import kr.hs.dgsw.mini_sns.Model.BoardDomain;
import kr.hs.dgsw.mini_sns.Model.LikeDomain;
import kr.hs.dgsw.mini_sns.Service.SnsService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/board")
public class BoardController {
    @Autowired
    SnsService boardService;

    @GetMapping
    public ResponseFormat viewList(){
        return boardService.viewList();
    }

    @GetMapping("/{idx}")
    public ResponseFormat viewBoard(@PathVariable("idx")int idx){
        return boardService.viewBoard(idx);
    }

    @PostMapping
    public ResponseFormat writeBoard(@RequestBody BoardDomain boardDomain){
        return boardService.writeBoard(boardDomain);
    }

    @PutMapping("/{userIdx}")
    public ResponseFormat update(@RequestBody BoardDomain boardDomain, @PathVariable("userIdx")int userIdx){
        return boardService.updateBoard(boardDomain,userIdx);
    }

    @DeleteMapping("/{idx}")
    public ResponseFormat update(@PathVariable int idx){
        return boardService.deleteBoard(idx);
    }

    @GetMapping("/like/{idx}")
    public ResponseFormat viewLikeCount(@PathVariable("idx")int idx){
        return boardService.viewLikeCount(idx);
    }

    @PostMapping("/like")
    public ResponseFormat like(@RequestBody LikeDomain likeDomain){
        return boardService.like(likeDomain);
    }

}
