package fengge.feign.client;

import feign.Param;
import fengge.feign.param.EmailSendParam;
import fengge.feign.response.MessageResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @Description: spring cloud集成openfeign兼容性较好
 * @Author Jinfeng.hu  @Date 2022/7/21
 **/
@FeignClient(name = "sendMessageClient", url = "${message.url}")
public interface SendMessageClient {
    /**
     * Post test
     */
    @RequestMapping(value = "/post", method = RequestMethod.POST, consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    MessageResponse post(@Param("param") EmailSendParam param);

    @RequestMapping(value = "/sendMail", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    Boolean sendMail(@RequestBody EmailSendParam param);

    @RequestMapping(value = "/sendMailWithAttachment", method = RequestMethod.POST, consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    MessageResponse sendMailWithAttachment(@Param("param") EmailSendParam param);
}
