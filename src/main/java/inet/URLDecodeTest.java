package inet;

import java.net.URLDecoder;
import java.net.URLEncoder;

/**
 * 编码类与解码类静态方法的调用。在URL中，非西欧的字符串都会有一个转换。
 */
public class URLDecodeTest {
    public static void main(String[] args)
            throws Exception
    {
        //将application/x-www-form-urlencoded字符串
        //转换成普通字符串
        //其中的字符串直接从图17.3所示窗口复制过来
        String keyWord = URLDecoder.decode(
                "%E6%9D%8E%E5%88%9A+j2ee", "UTF-8");
        System.out.println(keyWord);
        //将普通字符串转换成
        //application/x-www-form-urlencoded字符串
        String urlStr = URLEncoder.encode(
                "ROR敏捷开发最佳指南" , "GBK");
        System.out.println(urlStr);
    }
}
