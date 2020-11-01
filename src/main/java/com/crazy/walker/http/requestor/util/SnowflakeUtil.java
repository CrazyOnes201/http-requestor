package com.crazy.walker.http.requestor.util;

import cn.hutool.core.lang.Snowflake;
import cn.hutool.core.util.IdUtil;

/**
 * *****************************************
 * **       @author : CrazyWalker         **
 * *****************************************
 * *****************************************
 * **@date: 周日,11/01 2020 12:22 上午GMT+8**
 * *****************************************
 * *****************************************
 * **         用途: 雪花算法工具类          **
 * *****************************************
 */
public class SnowflakeUtil {

    private static final Long DEFAULT_WORKER_ID = 1L;
    private static final Long DEFAULT_DATA_CENTER_ID = 1L;
    private static final Snowflake DEFAULT_SNOWFLAKE = IdUtil.getSnowflake(DEFAULT_WORKER_ID, DEFAULT_DATA_CENTER_ID);

    public static long create() {
        return DEFAULT_SNOWFLAKE.nextId();
    }

    public static void main(String[] args) {
        System.out.println(SnowflakeUtil.create());
    }
}
