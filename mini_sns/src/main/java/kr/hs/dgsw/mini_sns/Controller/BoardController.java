package kr.hs.dgsw.mini_sns.Controller;

import kr.hs.dgsw.mini_sns.Model.BoardDomain;
import kr.hs.dgsw.mini_sns.Service.SnsService;
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

    @PostMapping
    public ResponseFormat writeBoard(@RequestBody BoardDomain boardDomain){
        return boardService.writeBoard(boardDomain);
    }

}
