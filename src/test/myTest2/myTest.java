package myTest2;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * 配置spring和junit整合，junit启动时加载springIOC容器
 */


@RunWith(SpringJUnit4ClassRunner.class)
//告诉junit spring配置文件
@ContextConfiguration("classpath:applicationContext.xml")
public class myTest  {




    @Test
    public void test() throws Exception {
        //StudentMapper mapper = applicationContext.getBean(StudentMapper.class);
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~");



    }

}

