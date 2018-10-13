package org.java.util;
import java.util.Date;
import java.util.HashMap;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.Message.RecipientType;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;


public class Email {
    public static final String SMTPSERVER = "smtp.qq.com";
    public static final String SMTPPORT = "465";
    public static final String ACCOUT = "1046934769@qq.com";
    public static final String PWD = "wzumocdgfrdubajb";




    public static void ljmtestSendEmail(HashMap<String,Object>h) throws Exception {

        // 创建邮件配置
        Properties props = new Properties();
        props.setProperty("mail.transport.protocol", "smtp"); // 使用的协议（JavaMail规范要求）
        props.setProperty("mail.smtp.host", SMTPSERVER); // 发件人的邮箱的 SMTP 服务器地址
        props.setProperty("mail.smtp.port", SMTPPORT);
        props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        props.setProperty("mail.smtp.auth", "true"); // 需要请求认证
        props.setProperty("mail.smtp.ssl.enable", "true");// 开启ssl


        // 根据邮件配置创建会话，注意session别导错包
        Session session = Session.getDefaultInstance(props);
        // 开启debug模式，可以看到更多详细的输入日志
        session.setDebug(true);
        //创建邮件
        MimeMessage message = ljmcreateEmail(session,h);
        //获取传输通道
        Transport transport = session.getTransport();
        transport.connect(SMTPSERVER,ACCOUT, PWD);
        //连接，并发送邮件
        transport.sendMessage(message, message.getAllRecipients());
        transport.close();

    }

    public static MimeMessage ljmcreateEmail(Session session,HashMap<String,Object>h) throws Exception {
        // 根据会话创建邮件
        MimeMessage msg = new MimeMessage(session);
        // address邮件地址, personal邮件昵称, charset编码方式
        InternetAddress fromAddress = new InternetAddress(ACCOUT,
                "kimi", "utf-8");
        // 设置发送邮件方
        msg.setFrom(fromAddress);
        InternetAddress receiveAddress = new InternetAddress(
                h.get("email")+"", "test", "utf-8");

        // 设置邮件接收方
        msg.setRecipient(RecipientType.TO, receiveAddress);


        // 设置邮件标题
        String st="<h1>"+h.get("text")+"</h1></div>";
        msg.setSubject("图南科技", "utf-8");
        MimeBodyPart text = new MimeBodyPart();
        text.setContent(st,
                "text/html;charset=UTF-8" );
        // 设置显示的发件时间
        msg.setSentDate(new Date());
        // 保存设置
        MimeMultipart mm = new MimeMultipart();
        mm.addBodyPart(text);
        MimeBodyPart all = new MimeBodyPart();
        all.setContent(mm);
        msg.setContent(mm);
        msg.saveChanges();
        return msg;
    }



    public static void crtestSendEmail(HashMap<String,Object>h) throws Exception {

        // 创建邮件配置
        Properties props = new Properties();
        props.setProperty("mail.transport.protocol", "smtp"); // 使用的协议（JavaMail规范要求）
        props.setProperty("mail.smtp.host", SMTPSERVER); // 发件人的邮箱的 SMTP 服务器地址
        props.setProperty("mail.smtp.port", SMTPPORT);
        props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        props.setProperty("mail.smtp.auth", "true"); // 需要请求认证
        props.setProperty("mail.smtp.ssl.enable", "true");// 开启ssl


        // 根据邮件配置创建会话，注意session别导错包
        Session session = Session.getDefaultInstance(props);
        // 开启debug模式，可以看到更多详细的输入日志
        session.setDebug(true);
        //创建邮件
        MimeMessage message = crcreateEmail(session,h);
        //获取传输通道
        Transport transport = session.getTransport();
        transport.connect(SMTPSERVER,ACCOUT, PWD);
        //连接，并发送邮件
        transport.sendMessage(message, message.getAllRecipients());
        transport.close();

    }


    public static   MimeMessage crcreateEmail(Session session,HashMap<String,Object>h) throws Exception {
        MimeMessage msg = new MimeMessage(session);
        // address邮件地址, personal邮件昵称, charset编码方式
        InternetAddress fromAddress = new InternetAddress(ACCOUT,
                "图南科技", "utf-8");
        // 设置发送邮件方
        msg.setFrom(fromAddress);
        InternetAddress receiveAddress = new InternetAddress(
                h.get("email")+"", "test", "utf-8");

        // 设置邮件接收方
        msg.setRecipient(RecipientType.TO, receiveAddress);
        MimeBodyPart image = new MimeBodyPart();
        // 读取本地文件
        DataHandler dh = new DataHandler(new FileDataSource(h.get("img")+""));
        // 将图片数据添加到"节点"
        image.setDataHandler(dh);
        // 为"节点"设置一个唯一编号（在文本"节点"将引用该ID）
        image.setContentID("mailTestPic");
        // 设置邮件标题
        String st=""+h.get("text")+"<div>请付款<img src='cid:mailTestPic' /></div>";
        msg.setSubject("付款单", "utf-8");
        MimeBodyPart text = new MimeBodyPart();
        text.setContent(st,
                "text/html;charset=UTF-8" );
        // 设置显示的发件时间
        msg.setSentDate(new Date());
        // 保存设置
        MimeMultipart mm = new MimeMultipart();
        mm.addBodyPart(text);
        mm.addBodyPart(image);
        mm.setSubType("related");
        MimeBodyPart all = new MimeBodyPart();
        all.setContent(mm);
        msg.setContent(mm);
        msg.saveChanges();
        return msg;
    }

}