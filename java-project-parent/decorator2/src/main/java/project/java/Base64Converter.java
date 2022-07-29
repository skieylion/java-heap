package project.java;

public class Base64Converter extends DecoratorDataSource {
    Base64Converter(DataSource dataSource) {
        super(dataSource);
    }

    @Override
    public void writeData(String data) {
        System.out.println("decode");
        super.writeData("decode64:" + data);
    }

    @Override
    public String readData() {
        System.out.println("encode");
        return super.readData().replaceAll("decode64:", "");
    }

}
