package fengge.feign.param;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Map;

/**
 * @Description:
 * @Author Jinfeng.hu  @Date 2022/7/25
 **/
@Data
public class EmailSendParam {
    @NotBlank
    @ApiModelProperty("请求ID（去重）")
    protected String requestId;

    @NotNull
    @ApiModelProperty("机构ID")
    protected Long orgId;
    @NotBlank
    @ApiModelProperty("业务类型 - 消息模板代码")
    protected String businessType;

    @ApiModelProperty("语言")
    protected String language;
    /**
     * 其它相关数据 - 可用于渲染模板 - 使用json简化feign处理Map等数据类型问题
     */
    @ApiModelProperty("自定义数据 - 可用于渲染模板")
    private Map<String, Object> data;

    private String json;

    @Email
    @ApiModelProperty("email地址")
    private String email;
    @ApiModelProperty("用戶名")
    private String userName;
    @ApiModelProperty("附件")
    private MultipartFile attachment;
}
