package project.java;

public class RandomClickerProxy implements Clickable {

    private RandomClicker randomClicker = null;

    private RandomClicker getInstance() {
        if (randomClicker == null) randomClicker = new RandomClicker();
        return randomClicker;
    }

    @Override
    public void click() {
        System.out.println("proxy click");
        getInstance().click();
    }
}
