package fengge.feign.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Description: 消息返回值
 * @Author Jinfeng.hu  @Date 2022/7/25
 **/
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MessageResponse {
    /**
     * 是否成功
     */
    private boolean success;
    /**
     * 请求Id
     */
    private String requestId;
    /**
     * 消息推送后三方接口返回的Id
     * 如果发送的是异步消息，那么此id是我们生成的id，取三方返回的id需要用此id去消息投递表（tb_msg_delivery_record）查询
     */
    private String messageId;

    /**
     * 错误/信息
     */
    private String msg;

    public static MessageResponse of() {
        return MessageResponse.builder().build();
    }

    public static MessageResponse ofErrMsg(String msg) {
        return MessageResponse.builder().success(false).msg(msg).build();
    }
}