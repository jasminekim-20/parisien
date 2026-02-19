package com.example.parisien.play;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/play")
public class PlayController {
    private final PlayService playService;
    public PlayController(PlayService playService) {
        this.playService = playService;
    }

    @PostMapping
    public PlayAnswer submit(@Valid @RequestBody PlayAnswer answer) {
      System.out.println("==== PLAY SUBMIT ====");
      System.out.println("morning=" + answer.getMorningChoice());
      System.out.println("lunch=" + answer.getLunchChoice());
      System.out.println("dinner=" + answer.getDinnerChoice());
      System.out.println("======================");

      return playService.save(answer);
    }

    @GetMapping
    public List<PlayAnswer> list() {
        return playService.findAll();
    }
}
