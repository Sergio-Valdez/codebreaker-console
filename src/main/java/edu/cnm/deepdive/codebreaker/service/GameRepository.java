package edu.cnm.deepdive.codebreaker.service;

import edu.cnm.deepdive.codebreaker.model.Game;
import java.io.IOException;
import retrofit2.Call;
import retrofit2.Response;

public class GameRepository {

  private final WebServiceProxy proxy;

  public  GameRepository() {
  proxy = WebServiceProxy.getInstance();
  }

  public Game startGame(String pool, int length) throws IOException {
    Game game = new Game();
    game.setPool(pool);
    game.setLength(length);
    Call<Game> call = proxy.startGame(game);
    Response<Game> response = call.execute();
    if (!response.isSuccessful()) {
      throw new RuntimeException(response.message());
    }
    return response.body();

  }


}
