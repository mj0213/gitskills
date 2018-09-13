package org.springboot.mail.service;

public interface MailService {

	public void sendSimpleMail(String to,String subject,String content); //简易邮箱
	public void sendHtmlMail(String to,String subject,String content); //发送html格式邮件
	public void sendAttachmentsMail(String to, String subject, String content, String filePath);//带附件的邮件
	public void sendInlineResourceMail(String to, String subject, String content, String rscPath, String rscId);//静态资源的邮件
}
