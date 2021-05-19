package cn.antigenmhc.test.mail;

import cn.antigenmhc.test.base.ReadProperties;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Properties;

public class AutoMail {

	public static void main(String[] args) throws IOException {
		MailInfo mailInfo = new MailInfo();
		String[] sendTo = readMail("sendto");
		String[] ccList = readMail("cc");
		
		mailInfo.setMailServerHost(ReadProperties.getProp("mail", "MailServerHost"));
		mailInfo.setMailServerPort(ReadProperties.getProp("mail", "MailServerPort"));
		mailInfo.setValidate(true);
		mailInfo.setUsername(ReadProperties.getProp("mail", "Username"));
		// 邮箱密码
		mailInfo.setPassword(ReadProperties.getProp("mail", "Password"));
		mailInfo.setFromAddress(ReadProperties.getProp("mail", "FromAddress"));
		mailInfo.setToAddress(sendTo);
		mailInfo.setSubject(ReadProperties.getProp("mail", "Subject"));
		mailInfo.setCcAddress(ccList);
		String[] files = {"./target/test-output/index.html"};
		mailInfo.setAttachFileNames(files);

		String mailContent = ReadHtml.readString("./target/test-output/index.html");
		String cssValueExtent = ReadHtml.readString("./target/classes/css/extent.css");
		String changeExtentStr ="<style type=\"text/css\">h1 {display : inline}"+cssValueExtent+"</style>";
		String cssValueIcon = ReadHtml.readString("./target/classes/css/icon.css");
		String changeIconStr ="<style type=\"text/css\">h1 {display : inline}"+cssValueIcon+"</style>";
		String cssValueSource = ReadHtml.readString("./target/classes/css/source.css");
		String changeSourceStr ="<style type=\"text/css\">h1 {display : inline}"+cssValueSource+"</style>";
		String jsValueExtent = ReadHtml.readString("./target/classes/js/extent.js");
		String changeExtentJsStr ="<script type='text/javascript'>" + jsValueExtent + "</script>";
		mailContent = mailContent.replace("<link href='http://extentreports.com/resx/dist/css/extent.css' type='text/css' rel='stylesheet' />", changeExtentStr);
		mailContent = mailContent.replace("<link href=\"https://fonts.googleapis.com/icon?family=Material+Icons\" rel=\"stylesheet\">", changeIconStr);
		mailContent = mailContent.replace("<link href='https://fonts.googleapis.com/css?family=Source+Sans+Pro:400,600' rel='stylesheet' type='text/css'>", changeSourceStr);
		mailContent = mailContent.replace("<script src='http://extentreports.com/resx/dist/js/extent.js' type='text/javascript'>", changeExtentJsStr);

		mailInfo.setContent(mailContent);
		// 发送html格式邮件
		SendMail.sendHtmlMail(mailInfo);
	}

	public static String[] readMail(String mailType) throws IOException {
		Properties props = new Properties();
		props.load(new FileInputStream("./target/classes/properties/" + mailType + ".properties"));
		String[] mailto = new String[props.size()];

		int i = 0;
		for (Enumeration enu = props.elements(); enu.hasMoreElements(); i++) {
		    String key = (String)enu.nextElement();
		    mailto[i]=key;
		}
		return mailto;
	}
	
}
