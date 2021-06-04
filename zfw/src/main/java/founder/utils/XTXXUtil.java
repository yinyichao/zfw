/**
 * @ClassName XTXXUtil
 * @Description TODO
 * @Author yins
 * @Date 2021-06-04
 * @Version 1.0
 **/
package founder.utils;

import founder.jxjs.entity.XTXX;

public class XTXXUtil {
    private static XTXX xtxx;

    static {
        String PTTYAH = StringUtils.uuid();
        String SJBS = StringUtils.uuid();
        String AJBH = StringUtils.uuid();
        xtxx = new XTXX(PTTYAH,SJBS,AJBH);
    }
/**
 *
  *
   *
    *
    *  //案号
     *     private String AH = "（2020）黑哈狱有减字5-4号";
     *     //案件名称
     *     private String AJMC = "故意伤人";
     *     //业务类别
     *     private String YWLB = "0111";
     *     //业务类别名称
     *     private String YWLBMC = "减刑假释";
     *     //流程节点编号
     *     private String LCJDBH = "0111A";
     *     //接收单位编号
     *     private String JSDWBH = "851";
     *     //接收单位名称
     *     private String JSDWMC = "哈尔滨市中级人民法院";
 *      //接收单位类型
 *     private String JSDWLX = "法院";
    * @Description  //TODO
    * @Date 2021-06-04   10:57
    * @return
    **/
//230100	哈尔滨市人民检察院

    public static XTXX builder(String type) {
        if(type.equals("0111A")){
            xtxx.setAH("（2020）黑哈狱有减字5-4号");
            xtxx.setAJMC("故意伤人");
            xtxx.setYWLB("0111");
            xtxx.setYWLBMC("减刑假释");
            xtxx.setLCJDBH(type);
            xtxx.setJSDWBH("851");
            xtxx.setJSDWMC("哈尔滨市中级人民法院");
            xtxx.setJSDWLX("法院");
        }else if(type.equals("0111F")){
            xtxx.setAH("（2020）黑哈狱有减字5-4号");
            xtxx.setAJMC("故意伤人");
            xtxx.setYWLB("0111");
            xtxx.setYWLBMC("减刑假释");
            xtxx.setLCJDBH(type);
            xtxx.setJSDWBH("230100");
            xtxx.setJSDWMC("哈尔滨市人民检察院");
            xtxx.setJSDWLX("检察院");
        }
        return xtxx;
    }
}
