package edu.cnm.deepdive.codebreaker;

import edu.cnm.deepdive.codebreaker.model.Game;
import edu.cnm.deepdive.codebreaker.service.GameRepository;
import edu.cnm.deepdive.codebreaker.service.WebServiceProxy;
import java.io.IOException;
import retrofit2.Call;
import retrofit2.Response;

public class Application {

  private static final String DEFUALT_POOL = "ABCDEF";
  private static final int DEFUALT_LENGTH = 3;

  private final GameRepository repository;
  private final String pool;
  private final int length;
  private final Game game;

  private Application(String[] args) {
    if (args.length > 0) {
      pool = args[0];
      if (args.length > 1) {
        length = Integer.parseInt(args[1]);
      } else {
        length = DEFUALT_LENGTH;
      }
    } else {
      pool = DEFUALT_POOL;
      length = DEFUALT_LENGTH;
      }

    repository = new GameRepository();
    game = repository.startGame(pool, length);

  }

  public static void main(String[] args) throws IOException {
    // TODO read command-line arguments for pool & length.
    String pool = "ABCDEF"; // FIXME
    int length=3; //FIXME Read from args
    Game game = startGame(pool, length);
    System.out.printf("Game id = %s%n", game.getId());
    // TODO while code is not guessed:
    // 1. Read guess from user input
    // 2. Submit guess to codebreaker service
    // 3. Display correct results.
  }

}
