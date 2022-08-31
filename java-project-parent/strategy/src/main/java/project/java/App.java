package project.java;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        Cipher cipher = new Cipher();
        cipher.setAlgorithm(new Sha1());
        cipher.encrypt();
        cipher.setAlgorithm(new Sha256());
        cipher.encrypt();
    }
}

interface Algorithm {
    void execute();
}

class Sha1 implements Algorithm {

    @Override
    public void execute() {
        System.out.println("sha 1 ...");
    }
}

class Sha256 implements Algorithm {

    @Override
    public void execute() {
        System.out.println("sha 256 ...");
    }
}

class Cipher {
    Algorithm algorithm;

    void setAlgorithm(Algorithm algorithm) {
        this.algorithm = algorithm;
    }

    void encrypt() {
        algorithm.execute();
    }
}