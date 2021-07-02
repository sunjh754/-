import com.myBlog.utils.CrowdUtil;
import org.junit.jupiter.api.Test;

import static com.myBlog.utils.CrowdUtil.md5;

/**
 * @Description
 * @Author Sunjh
 * @Date 2021/6/7 19:31
 */
public class StringTest {
    @Test
    public void testMD5(){
        String source="123456";
        String encoded=CrowdUtil.md5(source);
        System.out.println(encoded);
    }
}
