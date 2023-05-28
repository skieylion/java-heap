package project.java;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.PdfWriter;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public final class PdfUtils {
    private PdfUtils() {
        throw new UnsupportedOperationException();
    }

    private static List<PdfReader> getPdfReadersFromFiles(List<byte[]> files) {
        List<PdfReader> readers = new ArrayList<>();
        for (byte[] binaryFile : files) {
            try (InputStream streamPdf = new ByteArrayInputStream(binaryFile)) {
                readers.add(new PdfReader(streamPdf));
            } catch (IOException e) {
                throw new RuntimeException("Couldn't open stream from the binary file", e);
            }
        }
        return readers;
    }

    private static byte[] createPdfFileFromPdfReaderList(List<PdfReader> readers) {
        try (ByteArrayOutputStream stream = new ByteArrayOutputStream()) {
            Document document = new Document();
            PdfWriter writer = PdfWriter.getInstance(document, stream);
            document.open();
            PdfContentByte pageContentByte = writer.getDirectContent();
            for (int i = 0; i < readers.size(); i++) {
                PdfReader reader = readers.get(i);
                for (int j = 1; j <= reader.getNumberOfPages(); j++) {
                    if (i == readers.size() - 1 && j == reader.getNumberOfPages())
                        document.setPageSize(PageSize.A4.rotate());
                    else
                        document.setPageSize(PageSize.A4);
                    document.newPage();
                    pageContentByte.addTemplate(writer.getImportedPage(reader, j), 0, 0);
                }
            }
            stream.flush();
            document.close();
            return stream.toByteArray();
        } catch (DocumentException e) {
            throw new RuntimeException("Couldn't get an instance from ");
        } catch (IOException e) {
            throw new RuntimeException("The pdf stream is not flushed", e);
        }
    }

    public static byte[] mergeFiles(List<byte[]> files) {
        List<PdfReader> readers = getPdfReadersFromFiles(files);
        return createPdfFileFromPdfReaderList(readers);
    }
}

