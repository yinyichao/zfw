/**
 * @ClassName XmlUtil
 * @Description TODO
 * @Author yins
 * @Date 2021-06-02
 * @Version 1.0
 **/
package founder.utils;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import java.io.*;

public class XmlUtil {
    @SuppressWarnings({ "restriction", "unchecked" })
    public static <T> T toObject(File file, Class<T> type) throws JAXBException {
        JAXBContext jc = JAXBContext.newInstance(type);
        return (T) jc.createUnmarshaller().unmarshal(file);
    }

    @SuppressWarnings({ "restriction", "unchecked" })
    public static <T> T toObject(String context, Class<T> type) throws JAXBException {
        JAXBContext jc = JAXBContext.newInstance(type);
        return (T) jc.createUnmarshaller().unmarshal(new StringReader(context));
    }

    @SuppressWarnings("restriction")
    public static void toXml(Object object, String FilePath) throws JAXBException, IOException {
        JAXBContext jc = JAXBContext.newInstance(object.getClass());
        OutputStream outputStream = new FileOutputStream(new File(FilePath));
        jc.createMarshaller().marshal(object, outputStream);
        outputStream.close();
    }
}
