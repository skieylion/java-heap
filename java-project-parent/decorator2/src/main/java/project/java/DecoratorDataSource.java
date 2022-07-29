package project.java;

public abstract class DecoratorDataSource implements DataSource {

    private final DataSource dataSource;

    DecoratorDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public void writeData(String data) {
        dataSource.writeData(data);
    }

    @Override
    public String readData() {
        return dataSource.readData();
    }
}
