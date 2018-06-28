import com.clw.phaapp.common.entity.ResultEntity;
import com.clw.phaapp.entity.AskEntity;
import com.clw.phaapp.service.IAskService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.List;

/**
 * 测试健康问答
 *
 * @author chenliwu
 * @create 2018-03-11 9:26
 **/
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath*:springMVC-config.xml"})
@WebAppConfiguration
public class TestAsk {

    @Autowired
    private IAskService mIAskService;

    @Test
    public void testSelect(){
        //测试获取健康问答列表，分页
        AskEntity askEntity=new AskEntity();
        ResultEntity resultEntity=mIAskService.selectAskRecordListByPage(askEntity);
        System.out.println(resultEntity.toString());
        AskEntity data=(AskEntity)resultEntity.getData();
        List<AskEntity> list=data.getRows();
        if(list!=null){
            for(AskEntity entity:list){
                System.out.println(entity.toString());
            }
        }
    }

}
