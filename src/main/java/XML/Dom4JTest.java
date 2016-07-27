package XML;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

import java.io.File;
import java.io.FileOutputStream;
import java.util.Iterator;
import java.util.List;

public class Dom4JTest {
    public static void main(String[] args) throws Exception {
        Dom4JTest test = new Dom4JTest();
//        test.parseXML();
        test.createXML();
    }

    private void parseXML() throws Exception {
        SAXReader reader = new SAXReader();
        Document document = reader.read(new File("src/XML/XMLRead/demo/books.xml"));
        Element bookStore = document.getRootElement();
        Iterator it = bookStore.elementIterator();
        while (it.hasNext()) {
            System.out.println("==========开始遍历某一本书======");
            Element book = (Element) it.next();
            List<Attribute> bookAttr = book.attributes();
            for (Attribute attr : bookAttr) {
                System.out.println("节点名:  " + attr.getName() +
                        "---节点值: " + attr.getValue());
            }
            Iterator itt = book.elementIterator();
            while (itt.hasNext()) {
                Element bookChild = (Element) itt.next();
                System.out.println("节点名:  " + bookChild.getName() +
                        "---节点值: " + bookChild.getStringValue());
            }
            System.out.println("==========结束遍历某一本书======");
        }
    }

    private void createXML() throws Exception {
        Document document = DocumentHelper.createDocument();
        Element rss = document.addElement("rss");
        rss.addAttribute("version", "2.0");
        Element channel = rss.addElement("channel");
        Element title = channel.addElement("title");
        title.addText("国内最新新闻");
        OutputFormat format = OutputFormat.createPrettyPrint();
        format.setEncoding("gbk");
        File file = new File("src/XML/demo/rssnews.xml");
        XMLWriter writer = new XMLWriter(new FileOutputStream(file), format);
        //设置是否转义,默认值是true,代表转义
//        writer.setEscapeText(false);
        writer.write(document);
        writer.close();
    }
}
