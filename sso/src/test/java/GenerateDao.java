import cn.sinobest.sso.SsoApplication;
import cn.sinobest.sso.dao.generator.entity.SysUser;
import cn.sinobest.sso.dao.generator.repository.SysUserMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.internal.DefaultShellCallback;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName GenerateDao
 * @Desc
 * @Author 柯雷
 * @Date 2020/10/29 10:41
 * @Version 1.0
 */
@ContextConfiguration(classes = SsoApplication.class)
@RunWith(SpringRunner.class)
@SpringBootTest
public class GenerateDao {

    @Autowired
    SysUserMapper sysUserMapper;

    @Test
    public void generateDao() throws Exception {
        List<String> warnings = new ArrayList<String>();
        boolean overwrite = true;
        File configFile = new File("src/main/resources/GenerateMybatis.xml");
        ConfigurationParser cp = new ConfigurationParser(warnings);
        Configuration config = cp.parseConfiguration(configFile);
        DefaultShellCallback callback = new DefaultShellCallback(overwrite);
        MyBatisGenerator myBatisGenerator = new MyBatisGenerator(config, callback, warnings);
        myBatisGenerator.generate(null);
    }

    @Test
    public void get() {
        SysUser sysUser = sysUserMapper.selectByPrimaryKey(1);
        System.err.println(sysUser.getUsername());
    }
}
