package fengge.feign.param;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Map;

/**
 * @Description:
 * @Author Jinfeng.hu  @Date 2022/7/30
 **/
@Data
public class SmsSendParam {
    /**
     * 手机号： 国家/地区码
     */
    @NotBlank
    @ApiModelProperty("国家/地区码")
    private String nationCode;
    /**
     * 手机号： 手机号码
     */
    @NotBlank
    @ApiModelProperty("手机号码")
    private String mobile;

    @NotBlank
    @ApiModelProperty("请求ID（去重）")
    private String requestId;

    @NotNull
    @ApiModelProperty("机构ID")
    private Long orgId;
    @NotBlank
    @ApiModelProperty("业务类型 - 消息模板代码")
    private String businessType;

    @ApiModelProperty("语言")
    private String language;
    /**
     * 其它相关数据 - 可用于渲染模板
     */
    @ApiModelProperty("自定义数据 - 可用于渲染模板")
    private Map<String, Object> data;
}
