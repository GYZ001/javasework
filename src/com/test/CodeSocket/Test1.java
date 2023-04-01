package com.test.CodeSocket;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class Test1 {
    public static void main(String[] args) {

        try {
            InetAddress inetAddress1 = InetAddress.getLocalHost();
            System.out.println(inetAddress1.getHostAddress());
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }

    }
}
