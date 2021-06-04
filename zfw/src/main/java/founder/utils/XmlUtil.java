/**
 * @ClassName XmlUtil
 * @Description TODO
 * @Author yins
 * @Date 2021-06-02
 * @Version 1.0
 **/
package founder.utils;

import founder.jxjs.entity.XTXX;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

import java.io.*;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class XmlUtil {
    private static Map<String,String> maps = new HashMap<String,String>();
    public static void a(String path,XTXX xtxx){
        String fileUrl = path.substring(0,path.lastIndexOf("/"));
        String fileUrl1 = "E:\\test\\";
        //1.创建Reader对象
        SAXReader reader = new SAXReader();
        //2.加载xml
        Document document = null;
        maps = StringUtils.setConditionMap(xtxx);
        try {
            document = reader.read(new File(path));
            //3.获取根节点
            Element rootElement = document.getRootElement();

            b(rootElement,"/"+rootElement.getName());

            XMLWriter writer = new XMLWriter(new FileOutputStream(new File(path)));
            writer.write(document);
            writer.close();
            ZipUtil.zip(fileUrl1+"1.zip",fileUrl);
            String hash = MD5Util.md5HashCode32(fileUrl1+"1.zip");
            File file1 = new File(fileUrl1+"1.zip");
            //2301002301_230100_0111A_0111_6BC3F42A1B842A9C6A894125FF007601_2C6D1C74B87B12F6AC42D07674256121.zip
            File fileR = new File(fileUrl1+"/"+xtxx.getFSDWBH()+"_"+xtxx.getJSDWBH()+"_"+xtxx.getLCJDBH()+"_"+xtxx.getYWLB()+"_"+hash+"_"+xtxx.getSJBS()+".zip");
            file1.renameTo(fileR);
        } catch (DocumentException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void b(Element rootElement,String name){
        if(rootElement.selectNodes(name+"/*").size()>0){
            Iterator iterator = rootElement.elementIterator();
            while (iterator.hasNext()) {
                Element stu = (Element) iterator.next();
                b(stu,name+"/"+stu.getName());
            }
        }else{
            if(maps.get(rootElement.getName())!=null&&!"".equals(maps.get(rootElement.getName()))){
                rootElement.setText(maps.get(rootElement.getName()));
            }
            System.out.println("节点名："+rootElement.getName()+"---节点值："+rootElement.getStringValue());
        }
    }
}
