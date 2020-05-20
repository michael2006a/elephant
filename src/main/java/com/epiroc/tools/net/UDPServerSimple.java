package com.epiroc.tools.net;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

/**
 * @author : Herbert Yin
 * @version : V1.0
 * @project : tools
 * @file : UDPServerSimple.java
 * @description : TODO
 * @date : 2020/5/20 12:00
 * @Copyright : 2020 Epiroc Trading Co., Ltd. All rights reserved.
 */
public class UDPServerSimple {

  public static void main(String[] args) throws IOException {
    byte[] buf = new byte[1024];
    //声明一个用来接收数据的“包裹”
    DatagramPacket dp = new DatagramPacket(buf, buf.length);
    //指定的是UDP中的端口号5678，在TCP中，还有另外一个端口号为5678的端口
    DatagramSocket ds = new DatagramSocket(5678);
    while (true) {
      //阻塞式的
      ds.receive(dp);
      //dp中获取的数据的长度
      System.out.println(new String(buf, 0, dp.getLength()));
    }

  }

}
