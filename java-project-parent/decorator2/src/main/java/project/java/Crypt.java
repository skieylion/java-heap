package project.java;

public class Crypt extends DecoratorDataSource {
    Crypt(DataSource dataSource) {
        super(dataSource);
    }

    @Override
    public void writeData(String data) {
        System.out.println("encrypt");
        super.writeData("crypt:" + data);
    }

    @Override
    public String readData() {
        System.out.println("decrypt");
        return super.readData().replaceAll("crypt:", "");
    }

}
