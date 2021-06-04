/**
 * @ClassName test
 * @Description TODO
 * @Author yins
 * @Date 2021-06-02
 * @Version 1.0
 **/
package founder.jxjs.controller.jxjs;

import founder.utils.XTXXUtil;
import founder.utils.XmlUtil;

import java.util.HashMap;
import java.util.Map;

public class test {
    private static Map<String,String> maps = new HashMap<String,String>();
    public static void main(String[] args) {
        test._F();
    }

    public static void _A(){
        String path = test.class.getClassLoader().getResource("jxjs/0111A/ywxx.xml").getPath();
        XmlUtil.a(path,XTXXUtil.builder("0111A"));
    }

    public static void _D(){
        String path = test.class.getClassLoader().getResource("jxjs/0111D/ywxx.xml").getPath();
        XmlUtil.a(path,XTXXUtil.builder("0111D"));
    }

    public static void _F(){
        String path = test.class.getClassLoader().getResource("jxjs/0111F/ywxx.xml").getPath();
        XmlUtil.a(path,XTXXUtil.builder("0111F"));
    }
}
