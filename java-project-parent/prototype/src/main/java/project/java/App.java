package project.java;

public class App {
    public static void main(String[] args) throws CloneNotSupportedException {
        Actionable dragon1 = CharacterFactoryFactory.createDragonFactory().create("dragon");
        Actionable skeleton1 = CharacterFactoryFactory.createSkeletonFactory().create("iron skeleton");
        System.out.println(((Skeleton)skeleton1).health);//для логов
        dragon1.attack(skeleton1);
        System.out.println(((Skeleton)skeleton1).health);//для логов
    }
}


interface Actionable extends Cloneable {
    void attack(Actionable enemy);

    void move();
}

abstract class Character implements Actionable {
    int speed;
    int damage;
    int defense;
    int health;

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}

class Dragon extends Character {
    int mana;

    @Override
    public void attack(Actionable e) {
        Character enemy = (Character) e;
        enemy.health -= (damage - enemy.defense);
        System.out.println("Dragon attacks [" + (damage - enemy.defense) + "]");
    }

    @Override
    public void move() {
        System.out.println("Dragon moves [" + speed + "]");
    }

    @Override
    public Dragon clone() throws CloneNotSupportedException {
        Dragon dragon = (Dragon) super.clone();
        dragon.mana = this.mana;
        return dragon;
    }
}

class Skeleton extends Character {
    double resurrection;

    @Override
    public void attack(Actionable e) {
        Character enemy = (Character) e;
        enemy.health -= (damage - enemy.defense);
        System.out.println("Skeleton attacks [" + (damage - enemy.defense) + "]");
    }

    @Override
    public void move() {
        System.out.println("Skeleton moves [" + speed + "]");
    }

    @Override
    public Skeleton clone() throws CloneNotSupportedException {
        Skeleton skeleton = (Skeleton) super.clone();
        skeleton.resurrection = this.resurrection;
        return skeleton;
    }
}

abstract class CharacterFactory {
    public abstract Character create(String type) throws CloneNotSupportedException;
}

class DragonFactory extends CharacterFactory {

    private static final Dragon dragon = new Dragon();
    private static final Dragon dragonFire = new Dragon();

    static {
        dragon.mana = 10;
        dragon.defense = 5;
        dragon.damage = 15;
        dragon.health = 400;
        dragon.speed = 10;

        dragonFire.mana = 30;
        dragonFire.defense = 15;
        dragonFire.damage = 25;
        dragonFire.health = 600;
        dragonFire.speed = 12;
    }

    @Override
    public Dragon create(String type) throws CloneNotSupportedException {
        if ("fire dragon".equals(type)) {
            return dragonFire.clone();
        }
        return dragon.clone();
    }
}

class SkeletonFactory extends CharacterFactory {

    private static final Skeleton skeleton = new Skeleton();
    private static final Skeleton skeletonIron = new Skeleton();

    static {
        skeleton.defense = 1;
        skeleton.damage = 8;
        skeleton.health = 50;
        skeleton.speed = 3;
        skeleton.resurrection = 0.1;

        skeletonIron.defense = 2;
        skeletonIron.damage = 10;
        skeletonIron.health = 60;
        skeletonIron.speed = 5;
        skeletonIron.resurrection = 0.2;
    }

    @Override
    public Skeleton create(String type) throws CloneNotSupportedException {
        if ("iron skeleton".equals(type)) {
            return skeletonIron.clone();
        }
        return skeleton.clone();
    }
}

class CharacterFactoryFactory {

    public static DragonFactory createDragonFactory() {
        return new DragonFactory();
    }

    public static SkeletonFactory createSkeletonFactory() {
        return new SkeletonFactory();
    }
}
