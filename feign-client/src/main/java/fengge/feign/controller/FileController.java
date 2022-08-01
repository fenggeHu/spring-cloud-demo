package fengge.feign.controller;

import fengge.feign.response.MessageResponse;
import fengge.feign.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description:
 * @Author Jinfeng.hu  @Date 2022/7/20
 **/
@RestController
@RequestMapping("/file")
public class FileController {
    @Autowired
    private FileService fileService;

    @PostMapping("/send")
    public MessageResponse sendEmail(String filename) {
        return fileService.sendWithAttachment(filename);
    }
    @PostMapping("/sendSms")
    public MessageResponse sendSms() {
        return fileService.sendSms();
    }
}
