package Day7;

import lombok.Data;

/**
 * @author by woyuan  2022/3/7
 */
@Data
public abstract class Packet {
    /**
     * 协议版本
     */
    private Byte version = 1;

    /**
     * 指令
     */
    public abstract Byte getCommand();
}
