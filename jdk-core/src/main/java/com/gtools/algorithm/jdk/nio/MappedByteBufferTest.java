package com.gtools.algorithm.jdk.nio;

import java.io.*;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.util.Scanner;

/**
 * @Description MappedByteBuffer, 零拷贝实现基础
 * @Author ghy
 * @Date 2020/4/14 14:58
 */
public class MappedByteBufferTest {
    public static void main(String[] args) throws IOException {
        File file = new File("D://data//wchat开发流程.txt");
        long len = file.length();
        byte[] ds = new byte[(int) len];
        MappedByteBuffer mappedByteBuffer = new FileInputStream(file).getChannel().map(FileChannel.MapMode.READ_ONLY, 0, len);
        for (int offset = 0; offset < len; offset++) {
            ds[offset] = mappedByteBuffer.get();
        }
        Scanner scan = new Scanner(new ByteArrayInputStream(ds)).useDelimiter(" ");
        while (scan.hasNext()) {
            System.out.println(scan.next() + " ");
        }
    }
}
