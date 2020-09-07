package com.fumei.bg;


import com.fumei.bg.util.UUIDUtil;

public class Test {
    public static void main(String[] args) {
        System.err.println(UUIDUtil.randomUUID(false));
        System.err.println(UUIDUtil.randomUUID(true));
    }
}
