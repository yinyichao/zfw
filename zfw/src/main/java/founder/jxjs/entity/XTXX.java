/**
 * @ClassName XTXX
 * @Description TODO
 * @Author yins
 * @Date 2021-06-02
 * @Version 1.0
 **/
package founder.jxjs.entity;

import lombok.Data;


@Data
public class XTXX {
    //平台统一案号
    private String PTTYAH;
    //数据标识
    private String SJBS;
    //案件编号
    private String AJBH;
    //案号
    private String AH = "（2020）黑哈狱有减字5-4号";
    //案件名称
    private String AJMC = "故意伤人";
    //业务类别
    private String YWLB = "0111";
    //业务类别名称
    private String YWLBMC = "减刑假释";
    //流程节点编号
    private String LCJDBH = "0111A";
    //接收单位编号
    private String JSDWBH = "851";
    //接收单位名称
    private String JSDWMC = "哈尔滨市中级人民法院";
    //接收单位单位所在地
    private String JSDWDWSZD = "黑龙江省哈尔滨市";
    //接收单位所在地行政区划代码  int
    private String JSDWSZDXZQHDM = "230100";
    //接收单位所在地行政区划
    private String JSDWSZDXZQH = "黑龙江省哈尔滨市";
    //接收单位类型
    private String JSDWLX = "法院";
    //发送单位类型
    private String FSDWLX = "监狱";
    //发送单位编号
    private String FSDWBH = "2301002301";
    //发送单位名称
    private String FSDWMC = "黑龙江省哈尔滨监狱";
    //发送单位所在地
    private String FSDWSZD = "黑龙江省哈尔滨市";
    //发送单位所在地行政区划代码 int
    //50241083
    private String FSDWSZDXZQHDM = "230100";
    //发送单位所在地行政区划
    private String FSDWSZDXZQH = "黑龙江省哈尔滨市";
    //发送时间  date
    private String FSSJ = "2020-07-10 16:08:38";
    //移送日期  date
    private String YSRQ = "2020-07-10";
    /**
     *  数据类型 int
     * ----		数据类型
     * 50241001	  1	新增
     * 50241001	  2	补充
     **/
    private String SJLX = "1";

    public XTXX(String PTTYAH, String SJBS, String AJBH) {
        this.PTTYAH = PTTYAH;
        this.SJBS = SJBS;
        this.AJBH = AJBH;
    }
}
