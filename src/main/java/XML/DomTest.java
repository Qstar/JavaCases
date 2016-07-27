package XML;

import org.w3c.dom.*;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;

public class DomTest {
    public static void main(String[] args) throws Exception {
        DomTest test = new DomTest();
//        test.xmlParser();
        test.createXml();
    }

    public DocumentBuilder getDocumentBuilder() throws Exception {
        //创建DocumentBuilderFactory对象
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        //创建DocumentBuilder对象
        DocumentBuilder db = dbf.newDocumentBuilder();
        return db;
    }

    public void createXml() throws Exception {
        DocumentBuilder db = getDocumentBuilder();
        Document document = db.newDocument();
        document.setXmlStandalone(true);
        Element bookstore = document.createElement("bookStore");
        //添加字节点book
        Element book = document.createElement("book");
        Element name = document.createElement("name");
        name.setTextContent("小王子");
        book.appendChild(name);
        Element author = document.createElement("author");
        author.setTextContent("安东尼·德·圣埃克苏佩里");
        book.appendChild(author);
        Element year = document.createElement("year");
        year.setTextContent("1942");
        book.appendChild(year);
        Element price = document.createElement("price");
        price.setTextContent("47.50");
        book.appendChild(price);
        book.setAttribute("id", "1");
        bookstore.appendChild(book);
        document.appendChild(bookstore);

        TransformerFactory tff = TransformerFactory.newInstance();
        Transformer tf = tff.newTransformer();
        tf.setOutputProperty(OutputKeys.INDENT, "yes");
        tf.transform(new DOMSource(document),
                new StreamResult(new File("src/XML/demo/books1.xml")));
    }

    public void xmlParser() throws Exception {
        //通过parse方法加载xml文件给document对象
        Document document = getDocumentBuilder().parse("src/XML/demo/books.xml");
        //获取book节点集合
        NodeList bookList = document.getElementsByTagName("book");
        System.out.println("一共有" + bookList.getLength() + "本书");
        for (int i = 0; i < bookList.getLength(); i++) {
            System.out.println("===================开始遍历第" + (i + 1) + "本书的属性");

            Node book = bookList.item(i);
            //遍历book的属性
            NamedNodeMap attrs = book.getAttributes();
            System.out.println("第" + (i + 1) + "本书共有" + attrs.getLength() + "个属性");
            for (int j = 0; j < attrs.getLength(); j++) {
                Node attr = attrs.item(j);
                System.out.print("属性名: " + attr.getNodeName());
                System.out.println("属性值:" + attr.getNodeValue());
            }

            //前提是已知有且只有一个属性
//            Element book = (Element) bookList.item(i);
//            String attrValue = book.getAttribute("id");
//            System.out.println("id属性的属性值为: " + attrValue);

            NodeList childNodes = book.getChildNodes();
            System.out.println("第" + (i + 1) + "本书公有" + childNodes.getLength() + "个字节点");
            for (int k = 0; k < childNodes.getLength(); k++) {
                if (childNodes.item(k).getNodeType() == Node.ELEMENT_NODE) {
                    System.out.print("第" + (k + 1) + "个节点的节点名: " + childNodes.item(k).getNodeName());
                    System.out.println("--节点值是: " + childNodes.item(k).getFirstChild().getNodeValue());
//                    System.out.println("--节点值是: " + childNodes.item(k).getTextContent());
                }
            }

            System.out.println("===================结束遍历第" + (i + 1) + "本书的属性");
        }
    }
}
