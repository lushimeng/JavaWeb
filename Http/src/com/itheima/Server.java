/**
 * @Time: 2021/00/00
 * @Author: LSM
 * @Email: 3108763730@qq.com
 * @File: test.java
 * @Software: IDEA
 */
package com.itheima;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

/*
   自定义服务器
 */
public class Server {
    public static void main(String[] args) throws Exception{
        ServerSocket ss = new ServerSocket(8080);  // 鉴定指定端口
        System.out.println("server is running.....");
        while (true){
            Socket socket = ss.accept();
            System.out.println("connected from" + socket.getRemoteSocketAddress());
            Thread thread = new Handler(socket);
            thread.start();
        }

    }
}

class Handler extends Thread{
    Socket socket;

    public Handler(Socket socket){
        this.socket = socket;
    }

    @Override
    public void run() {
        try(InputStream input = this.socket.getInputStream()) {
            try(OutputStream output = this.socket.getOutputStream()){
                handle(input, output);
            }
        } catch (IOException e) {
            try {
                this.socket.close();
            } catch (IOException ex) {
            }
            System.out.println("client disconnected.");
        }
    }
    private void handle(InputStream input, OutputStream output) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(input, StandardCharsets.UTF_8));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(output, StandardCharsets.UTF_8));
        // 读取HTTP请求
        boolean requestOk = false;
        String first = reader.readLine();
        if(first.startsWith("GET / HTTP/1.")){
            requestOk = true;
        }

        for(;;){
            String header = reader.readLine();
            if(header.isEmpty()){ // 读取到空行时， HTTP Header读取完毕
                break;
            }
            System.out.println(header);
        }
        System.out.println(requestOk ? "Response OK" : "Response Error");
        if(!requestOk){
            // 发送错误响应
            writer.write("HTTP/1.0 404 Not Found\r\n");
            writer.write("Content-Length: 0\r\n");
            writer.write("\r\n");
            writer.flush();
        }else {
            // 发送成功响应
            // 读取html内容，转为字符串
            BufferedReader br = new BufferedReader(new FileReader("Http/html/a.html"));
            StringBuilder data = new StringBuilder();
            String line = null;
            while ((line = br.readLine()) != null){
                data.append(line);
            }
            br.close();
            int length = data.toString().getBytes(StandardCharsets.UTF_8).length;


            writer.write("HTTP/1.1 200 OK\r\n");
            writer.write("Connection: keep-alive\r\n");
            writer.write("Content-Type: text/html\r\n");
            writer.write("Content-Length: " + length + "\r\n");
            writer.write("\r\n"); // 空行标识Header和Body的分隔
            writer.write(data.toString());
            writer.flush();
        }
    }
}












