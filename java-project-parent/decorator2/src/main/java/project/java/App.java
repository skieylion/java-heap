package project.java;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {

        FileDataSource fileDataSource = new FileDataSource();
        DataSource dataSourceWriter = new Base64Converter(new Crypt(fileDataSource));
        DataSource dataSourceReader = new Crypt(new Base64Converter(fileDataSource));
        dataSourceWriter.writeData("abc");
        System.out.println("read data: " + dataSourceReader.readData());
    }
}

//base64 -> binary
//encrypt
//write
//decrypt
//encode


