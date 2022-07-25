package fengge.feign.service;

import fengge.feign.client.SendMessageClient;
import fengge.feign.param.EmailSendParam;
import fengge.feign.response.MessageResponse;
import fengge.utils.JsonUtils;
import fengge.utils.MultipartFileUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * @Description:
 * @Author Jinfeng.hu  @Date 2022/7/20
 **/
@Service
public class FileService {
    @Autowired
    private SendMessageClient sendMessageClient;

    public MessageResponse sendWithAttachment(String file) {
        EmailSendParam param = new EmailSendParam();
        param.setEmail("pbfoxhu@gmail.com");
        param.setUserName("fengge");
        param.setRequestId(UUID.randomUUID().toString());
        param.setOrgId(0L);
        param.setBusinessType("GET_MY_FREE_REPORT");
        if (!StringUtils.isEmpty(file)) {
            MultipartFile attachment = MultipartFileUtil.toMultipartFile(new File(file));
            param.setAttachment(attachment);
        }

        Map<String, Object> data = new HashMap<>();
        data.put("name", "锋哥");
        data.put("age", 26);
        // 表单提交方式和json提交方式没法直接混用，因为提交的数据格式机制是不一样的
        // 当使用表单方式提交，可以把Java对象转成json格式
//        param.setData(data);

        param.setJson(JsonUtils.toJson(data));

        return sendMessageClient.post(param);
    }

}
