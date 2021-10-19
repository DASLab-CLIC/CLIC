package fdu.daslab.gatewaycenter.utils.api;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @author 李姜辛
 * @description
 * @since 2021/10/15 20:21
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Response<T> {
    /**
     * 1 true, 0 false
     */
    Integer status;

    String msg;
    T data;
}
