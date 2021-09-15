package com.xing.learnjava;

import com.xing.learnjava.service.User;
import com.xing.learnjava.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author xing
 * @create 2021-05-27 16:40
 */

//标注了@Configuration，表示它是一个配置类
@Configuration
//@ComponentScan，它告诉容器，自动搜索当前类所在的包以及子包，把所有标注为@Component的Bean自动创建出来，并根据@Autowired进行装配。
@ComponentScan
public class Appconfig {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Appconfig.class);
        UserService service = context.getBean(UserService.class);
        service.setUsers();
        User user = service.login("bob@example.com", "password");
        System.out.println(user.getName());
    }
}
