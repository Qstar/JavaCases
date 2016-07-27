package PDF;

import com.itextpdf.text.Document;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import java.io.FileOutputStream;

public class DrawPdf {

    public static void main(String[] args) throws Exception {
        Document document = new Document();
        PdfWriter.getInstance(document, new FileOutputStream("/Users/Qstar/spring/helloJava/src/PDF/Employee.pdf"));
        document.open();

        Paragraph para = new Paragraph("Employee Table");
        para.setSpacingAfter(20);
        document.add(para);

        PdfPTable table = new PdfPTable(3);
        PdfPCell cell = new PdfPCell(new Paragraph("First Name"));

        table.addCell(cell);
        table.addCell("Last Name");
        table.addCell("Gender");
        table.addCell("Ram");
        table.addCell("Kumar");
        table.addCell("Male");
        table.addCell("Lakshmi");
        table.addCell("Devi");
        table.addCell("Female");

        document.add(table);

        document.close();
    }
}