package org.springboot.mail.test;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springboot.mail.service.MailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
@RunWith(SpringRunner.class)
@SpringBootTest
public class testSimpleMail {

	@Autowired private MailService mailService;
	//@Test //简易邮箱
	public void testSimpleMailSend() {
		mailService.sendSimpleMail("1593983911@qq.com", "邮箱服务测试", "你是李梦吗？");
	}
	//@Test //HTML邮件
	public void testHtmlMail() {
		 String content="<html>\n" +
		            "<body>\n" +
		            "    <h3>hello world ! 这是一封Html邮件!</h3>\n" +
		            "</body>\n" +
		            "</html>";
		mailService.sendHtmlMail("1593983911@qq.com", "邮箱服务测试", content);
	}
	//@Test //带附件
	public void sendAttachmentsMail() {
	    String filePath="e:\\mj\\mine\\esmeng\\mj.mp4";
	    mailService.sendAttachmentsMail("1593983911@qq.com", "主题：带附件的邮件", "有附件，请查收！", filePath);
	}
	
	@Test(timeout=1000) //静态资源
	public void sendInlineResourceMail() {
	    String rscId = "neo006";
	    String content="<html><body>这是有图片的邮件：<img src=\'cid:" + rscId + "\' ></body></html>";
	    String imgPath = "e:\\mj\\mine\\esmeng\\aa.jpg";
	    mailService.sendInlineResourceMail("1593983911@qq.com", "主题：这是有图片的邮件", content, imgPath, rscId);
	    //添加多个图片可以使用多条 <img src='cid:" + rscId + "' > 和 helper.addInline(rscId, res) 来实现到此所有的邮件发送服务已经完成了。


	}
}
