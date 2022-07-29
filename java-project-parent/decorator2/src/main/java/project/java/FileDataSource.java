package project.java;

public class FileDataSource implements DataSource {

    private String data;

    @Override
    public void writeData(String data) {
        this.data = data;
        System.out.println("write data: " + data);
    }

    @Override
    public String readData() {
        return data;
    }
}
