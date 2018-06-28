import com.clw.phaapp.common.entity.ResultEntity;
import com.clw.phaapp.dao.UserDao;
import com.clw.phaapp.entity.UserEntity;
import com.clw.phaapp.entity.UserFeedbackEntity;
import com.clw.phaapp.service.IUserFeedbackService;
import com.clw.phaapp.service.IUserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

/**
 * 测试用户反馈
 *
 * @author chenliwu
 * @create 2018-03-06 23:29
 **/
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath*:springMVC-config.xml"})
@WebAppConfiguration
public class TestUserFeedback {

    @Autowired
    private IUserFeedbackService mIUserFeedbackService;

    @Autowired
    private UserDao mUserDao;

    @Test
    public void insert(){
        UserFeedbackEntity userFeedbackEntity=new UserFeedbackEntity();
        userFeedbackEntity.setType((byte)0);
        userFeedbackEntity.setContact("30075213");
        userFeedbackEntity.setContent("测试用户反馈");
        ResultEntity resultEntity=mIUserFeedbackService.insertRecord(userFeedbackEntity);
        System.out.println("插入结果："+resultEntity.toString());
    }

    @Test
    public void insertuser(){
        for(int i=0;i<10;i++){
            UserEntity userEntity=new UserEntity();
            userEntity.setUsercode("usercode"+i);
            userEntity.setPwd("pwd"+i);
            userEntity.setNickname("nickname"+i);
            userEntity.setName("name"+i);
            userEntity.setSecurity("Security"+i);
            userEntity.setAnswer("answer"+i);
            mUserDao.insertSelective(userEntity);
        }
    }

}
