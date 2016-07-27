package XML;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.AttributesImpl;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Result;
import javax.xml.transform.Transformer;
import javax.xml.transform.sax.SAXTransformerFactory;
import javax.xml.transform.sax.TransformerHandler;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;

public class SAXTest {

    public static void main(String[] args) throws Exception {
        SAXTest test = new SAXTest();
//        test.parseXML();
        test.createXML();
    }

    public ArrayList<Book> parseXML() throws Exception {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser parser = factory.newSAXParser();
        SAXParserHandler handler = new SAXParserHandler();
        parser.parse("src/XML/demo/books.xml", handler);

        System.out.println("~!~!~!共有" +
                handler.getBookList().size() + "本书");
        for (Book book : handler.getBookList()) {
            System.out.println(book.getId());
            System.out.println(book.getName());
            System.out.println(book.getAuthor());
            System.out.println(book.getYear());
            System.out.println(book.getPrice());
            System.out.println(book.getLanguage());
        }
        return handler.getBookList();
    }

    public void createXML() throws Exception {
        ArrayList<Book> bookList = parseXML();
        //生成xml
        SAXTransformerFactory tff =
                (SAXTransformerFactory) SAXTransformerFactory.newInstance();
        TransformerHandler handler = tff.newTransformerHandler();
        Transformer tr = handler.getTransformer();
        tr.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
        tr.setOutputProperty(OutputKeys.INDENT, "yes");
        File f = new File("src/XML/demo/newlbooks.xml");
        if (!f.exists()) {
            f.createNewFile();
        }
        Result result = new StreamResult(new FileOutputStream(f));
        handler.setResult(result);
        handler.startDocument();
        AttributesImpl attr = new AttributesImpl();
        handler.startElement("", "", "bookstore", attr);
        for (Book book : bookList) {
            attr.clear();
            attr.addAttribute("", "", "id", "", book.getId());
            handler.startElement("", "", "book", attr);

            if (book.getName() != null && !book.getName().trim().equals("")) {
                attr.clear();
                handler.startElement("", "", "name", attr);
                handler.characters(book.getName().toCharArray(), 0, book.getName().length());
                handler.endElement("", "", "name");
            }

            if (book.getYear() != null && !book.getYear().trim().equals("")) {
                attr.clear();
                handler.startElement("", "", "year", attr);
                handler.characters(book.getYear().toCharArray(), 0, book.getYear().length());
                handler.endElement("", "", "year");
            }
            if (book.getAuthor() != null && !book.getAuthor().trim().equals("")) {
                attr.clear();
                handler.startElement("", "", "author", attr);
                handler.characters(book.getAuthor().toCharArray(), 0, book.getAuthor().length());
                handler.endElement("", "", "author");
            }
            if (book.getPrice() != null && !book.getPrice().trim().equals("")) {
                attr.clear();
                handler.startElement("", "", "price", attr);
                handler.characters(book.getPrice().toCharArray(), 0, book.getPrice().length());
                handler.endElement("", "", "price");
            }
            if (book.getLanguage() != null && !book.getLanguage().trim().equals("")) {
                attr.clear();
                handler.startElement("", "", "language", attr);
                handler.characters(book.getLanguage().toCharArray(), 0, book.getLanguage().length());
                handler.endElement("", "", "language");
            }

            handler.endElement("", "", "book");
        }
        handler.endElement("", "", "bookstore");

        handler.endDocument();
    }
}


class SAXParserHandler extends DefaultHandler {
    int bookIndex = 0;
    String value = null;
    Book book = null;
    private ArrayList<Book> bookList = new ArrayList<>();

    public ArrayList<Book> getBookList() {
        return bookList;
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        super.startElement(uri, localName, qName, attributes);
        if (qName.equals("book")) {
            //创建一个book对象
            book = new Book();


            bookIndex++;
            System.out.println("===================开始遍历第" + bookIndex + "本书的属性");

            //已知book元素下的属性
//            String value = attributes.getValue("id");
//            System.out.println("book的属性值是: "+value);

            int num = attributes.getLength();
            for (int i = 0; i < num; i++) {
                System.out.println("book元素的第" + (i + 1) + "个属性名是: " +
                        attributes.getQName(i));
                System.out.println("------属性值是: " + attributes.getValue(i));
                if (attributes.getQName(i).equals("id")) {
                    book.setId(attributes.getValue(i));
                }
            }
        } else if (!qName.equals("book") && !qName.equals("bookstore")) {
            System.out.print("节点名是---" + qName);
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        super.endElement(uri, localName, qName);
        if (qName.equals("book")) {
            bookList.add(book);
            book = null;
            System.out.println("===================结束遍历第" + bookIndex + "本书的属性");
        } else if (qName.equals("name")) {
            book.setName(value);
        } else if (qName.equals("author")) {
            book.setAuthor(value);
        } else if (qName.equals("year")) {
            book.setYear(value);
        } else if (qName.equals("price")) {
            book.setPrice(value);
        } else if (qName.equals("language")) {
            book.setLanguage(value);
        }
    }

    @Override
    public void startDocument() throws SAXException {
        super.startDocument();
        System.out.println("SAX解析开始");
    }

    @Override
    public void endDocument() throws SAXException {
        super.endDocument();
        System.out.println("SAX解析结束");
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        super.characters(ch, start, length);
        value = new String(ch, start, length);
        if (!value.trim().equals("")) {
            System.out.println("节点值是: " + value);
        }
    }
}