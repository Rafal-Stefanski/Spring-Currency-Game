package com.rafalstefanski.currencygame.currency_game.service;

import com.rafalstefanski.currencygame.currency_game.model.CurrencyGame;
import com.rafalstefanski.currencygame.currency_game.model.LatestUsdInPlnValue;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class GameService {

    private double USD;
    private int serviceCounter;
    private CurrencyGame currencyGame = new CurrencyGame();

    public CurrencyGame getCurrencyGame() {
        return currencyGame;
    }

    public GameService() {

        RestTemplate restTemplate = new RestTemplate();
        String url = "https://cdn.jsdelivr.net/gh/fawazahmed0/currency-api@1/latest/currencies/usd/pln.json";

        LatestUsdInPlnValue ratesForObject = restTemplate.getForObject(url, LatestUsdInPlnValue.class);

//        USD = Math.round(ratesForObject.getPln() * 100.0) / 100.0;
        currencyGame.setUsdValueInPln(ratesForObject.getPln());

    }

//    double pln = Math.round(ServiceCurrency().getPln() * 100) / 100.0;

    public void check(double usdInput) {
//        serviceCounter++;
        currencyGame.getCounter();
        currencyGame.setUsdInput(usdInput);
//        currencyGame.setCounter(serviceCounter);
        if (currencyGame.getUsdValueInPln() < usdInput) {
            currencyGame.setStatus("Too much. Try again. ");
        } else if (currencyGame.getUsdValueInPln() > usdInput) {
            currencyGame.setStatus("Too low. Try again. ");
        } else {
            currencyGame.setStatus("Bingo! You guessed it!");
            currencyGame.setGameOver(true);
        }
    }

    public void reset() {
        currencyGame.setCounter(0);
        currencyGame.setUsdInput(0);
        currencyGame.setStatus("");

    }


}
