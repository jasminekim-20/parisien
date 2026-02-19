package com.example.parisien.play;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController
@RequestMapping("/result")
public class ResultController {
    private final PlayService playService;

    public ResultController(PlayService playService) {
        this.playService = playService;
    }
    @GetMapping
    public ResultResponse getResult() {
        PlayAnswer last = playService.findLast();
        if (last == null) {
            return new ResultResponse(
                    "아직 선택이 없어요",
                    "먼저 하루 플레이를 한 번 해주세요.",
                    List.of("POST /play로 선택을 저장한 뒤 다시 와주세요.")
            );
        }
        return playService.summarize(last);
    }

}
