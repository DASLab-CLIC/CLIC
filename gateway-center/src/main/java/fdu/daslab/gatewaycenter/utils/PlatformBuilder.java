package fdu.daslab.gatewaycenter.utils;

import com.google.gson.Gson;
import fdu.daslab.thrift.base.Platform;

/**
 * @author 李姜辛
 * @description
 * @since 2021/9/25 16:40
 */
public class PlatformBuilder {
    public Platform parseJson(String jsonStr){
        Gson gson = new Gson();
        Platform platform = gson.fromJson(jsonStr, Platform.class);
        return platform;
    }
}
