package com.dp.observer;


import java.io.Closeable;
import java.util.ArrayList;
import java.util.List;

class Game {
    private List<Rat> rats = new ArrayList<>();

    public void addRat(Rat rat) {
        rats.add(rat);
        for (Rat r : rats) {
            r.attack = rats.size();
        }
    }

    public void removeRat(Rat rat) {
        rats.remove(rat);
        for (Rat r : rats) {
            r.attack = rats.size();
        }
    }
}

class Rat implements Closeable {
    private Game game;
    public int attack = 1;

    public Rat(Game game) {
        this.game = game;
        game.addRat(this);
    }

    @Override
    public void close() {
        game.removeRat(this);
    }
}

public class RatExample {

    public static void main(String[] args) {
        Game game = new Game();

        Rat rat1 = new Rat(game);
        Rat rat2 = new Rat(game);
        Rat rat3 = new Rat(game);

        System.out.println(rat3.attack);

        rat3.close();
    }
}
