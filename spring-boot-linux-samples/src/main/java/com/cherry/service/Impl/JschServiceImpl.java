package com.cherry.service.Impl;

import com.cherry.service.JschService;
import com.jcraft.jsch.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

/**
 * @author : zhang pan
 * @date : 10:35 下午 2021/9/22
 * 描述：
 */
@Service
public class JschServiceImpl implements JschService {

    private static final String USERNAME = "root";
    private static final int PORT = 22;

    //要远程执行的命令
    private static final String LS = "ls";

    @Override
    public void exec(String HOST, String PASSWORD){
        InputStream in = null;
        Channel channel = null;
        Session session = null;
        try {
            JSch jSch = new JSch();
            session = jSch.getSession(USERNAME, HOST, PORT);
            session.setPassword(PASSWORD);
            session.setConfig("StrictHostKeyChecking", "no");
            session.connect();
            channel = session.openChannel("exec");
            ((ChannelExec)channel).setCommand(LS);
            in = channel.getInputStream();
            channel.connect();
            byte[] tmp=new byte[1024];
            while(true){
                while(in.available()>0){
                    int i=in.read(tmp, 0, 1024);
                    if(i<0) {
                        break;
                    }
                    System.out.print(new String(tmp, 0, i));
                }
                if(channel.isClosed()){
                    if(in.available()>0) {
                        continue;
                    }
                    System.out.println("exit-status: "+channel.getExitStatus());
                    break;
                }
            }
        } catch (JSchException | IOException e) {
            e.printStackTrace();
        }finally {
            if(in != null){
                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(channel != null){
                channel.disconnect();
            }
            if(session != null){
                session.disconnect();
            }
        }
    }

}
