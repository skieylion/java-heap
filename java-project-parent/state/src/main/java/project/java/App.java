package project.java;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        Player player = new Player();
        player.setActive(false);
        player.setActive(true);
        player.setActive(true);
        player.setActive(false);
        player.setActive(false);
    }
}

abstract class State {
    Player player;

    abstract void stop();

    abstract void play();

    State(Player player) {
        this.player = player;
    }
}

class StoppedState extends State {

    StoppedState(Player player) {
        super(player);
    }

    @Override
    void stop() {
        System.out.println("...");
    }

    @Override
    void play() {
        player.setState(new PlayingState(player));
        System.out.println("player is active");
    }
}

class PlayingState extends State {

    PlayingState(Player player) {
        super(player);
    }

    @Override
    void stop() {
        player.setState(new StoppedState(player));
        System.out.println("player is not active");
    }

    @Override
    void play() {
        System.out.println("...");
    }
}

class Player {
    State state;

    Player() {
        this.state = new StoppedState(this);
    }

    void setActive(boolean active) {
        if (active) {
            state.play();
        } else {
            state.stop();
        }
    }

    void setState(State state) {
        this.state = state;
    }
}