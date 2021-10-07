package com.rafalstefanski.currencygame.currency_game.controller;

import com.rafalstefanski.currencygame.currency_game.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/currency_game-gui")
public class GameController {

    private GameService gameService;

    @Autowired
    public GameController(GameService gameService) {
        this.gameService = gameService;
    }

    @GetMapping
    public String getGame(Model model) {
        model.addAttribute("currency", gameService.getCurrencyGame());
        return "currency_game-gui/game_view";
    }

    @GetMapping("/check")
    public String getCheck(@RequestParam("usdInput") double usdInput) {
        gameService.check(usdInput);
        return "redirect:/currency_game-gui";
    }

//    @GetMapping("/resetgame")
//    public String resetGame() {
//        gameService.reset();
//        return "/";
//    }
}
