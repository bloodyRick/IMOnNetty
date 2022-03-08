package Day7;

import lombok.Data;

import static Day7.Command.LOGIN_REQUEST;

/**
 * @author by woyuan  2022/3/7
 */
@Data
public class LoginRequestPacket extends Packet {
    private Integer userId;

    private String username;

    private String password;

    @Override
    public Byte getCommand() {
        return LOGIN_REQUEST;
    }
}
