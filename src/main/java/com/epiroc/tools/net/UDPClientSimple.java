package com.epiroc.tools.net;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;

/**
 * @author : Herbert Yin
 * @version : V1.0
 * @project : tools
 * @file : UDPClientSimple.java
 * @description : TODO
 * @date : 2020/5/20 12:00
 * @Copyright : 2020 Epiroc Trading Co., Ltd. All rights reserved.
 */
public class UDPClientSimple {

  public static void main(String[] args) throws IOException {
    byte[] buf = new String("Hello").getBytes();
    //UDP是无连接的，所以要在发送的数据包裹中指定要发送到的ip：port
    DatagramPacket dp = new DatagramPacket(buf, buf.length,
        new InetSocketAddress("10.86.93.246", 5289));
    //指明发送端的端口号
    DatagramSocket ds = new DatagramSocket(5291);
    ds.send(dp);
    ds.close();
  }

}
