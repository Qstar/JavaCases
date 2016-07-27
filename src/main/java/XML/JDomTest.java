package XML;

import org.jdom2.Attribute;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.input.SAXBuilder;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class JDomTest {
    private static ArrayList<Book> booksList = new ArrayList<>();

    public static void main(String[] args) throws Exception {
        JDomTest test = new JDomTest();
//        test.parseXML();
        test.createXML();
    }

    private void parseXML() throws Exception {
        SAXBuilder saxBuilder = new SAXBuilder();
        InputStream in = new FileInputStream("src/XML/demo/books.xml");
        Document document = saxBuilder.build(in);
        Element rootElement = document.getRootElement();
        List<Element> bookList = rootElement.getChildren();
        for (Element book : bookList) {
            Book bookEntity = new Book();

            System.out.println("============开始解析第" +
                    (bookList.indexOf(book) + 1) + "本书");
            List<Attribute> attrList = book.getAttributes();
            for (Attribute attr : attrList) {
                String attrName = attr.getName();
                String attrValue = attr.getValue();
                System.out.println("属性名: " + attrName + "----属性值: " + attrValue);

                if ("id".equals(attrName)) {
                    bookEntity.setId(attrValue);
                }
            }

            List<Element> bookChilds = book.getChildren();
            for (Element child : bookChilds) {
                System.out.println("节点名: " + child.getName() +
                        "----节点值: " + child.getValue());
                if ("name".equals(child.getName())) {
                    bookEntity.setName(child.getValue());
                } else if ("author".equals(child.getName())) {
                    bookEntity.setAuthor(child.getValue());
                } else if ("year".equals(child.getName())) {
                    bookEntity.setYear(child.getValue());
                } else if ("price".equals(child.getName())) {
                    bookEntity.setPrice(child.getValue());
                } else if ("language".equals(child.getName())) {
                    bookEntity.setLanguage(child.getValue());
                }
            }

            System.out.println("============结束解析第" +
                    (bookList.indexOf(book) + 1) + "本书");

            booksList.add(bookEntity);
            bookEntity = null;

            System.out.println(booksList.size());
            System.out.println(booksList.get(0).getId());
            System.out.println(booksList.get(0).getName());
        }
    }

    private void createXML() throws Exception {
        Element rss = new Element("rss");
        rss.setAttribute("version", "2.0");
        Document document = new Document(rss);
        Element channel = new Element("channel");
        rss.addContent(channel);
        Element title = new Element("title");
        title.setText("国内最新新闻");
        channel.addContent(title);
        Format format = Format.getCompactFormat();
        format.setIndent("");
        format.setEncoding("utf-8");
        XMLOutputter outputter = new XMLOutputter(format);
        outputter.output(document, new FileOutputStream(new File("src/XML/demo/rssnews1.xml")));

    }
}
