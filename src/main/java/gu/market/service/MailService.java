package gu.market.service;

import com.sendgrid.*;
import com.sendgrid.helpers.mail.objects.Email;

import gu.market.repository.model.AccountCoupon;
import gu.market.repository.model.Member;

import com.sendgrid.helpers.mail.Mail;
import com.sendgrid.helpers.mail.objects.Content;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MailService {
	
	@Autowired
	@Resource(name = "sqlSessionTemplate2")
	private SqlSessionTemplate sqlSession2;	
	
	//쿠폰조건설정(가입10일 쿠폰)
	//가입한지 10일 -> 가입일자+쿠폰발급여부(쿠폰테이블에 쿠폰종류가 없을때만)
	public void CouponSender() {
		int couponCode = 1; // 쿠폰이 달라지면 query문이 달라져야하는데?
		List<Member> memberList = new ArrayList<Member>();
		memberList = sqlSession2.selectList("selectCouponList", couponCode); // 가입한지 10일 이상된 memberList
		for(int i = 0; i<memberList.size(); i++) {
			if(memberList.get(i).getMemberEmail() != null) {
				String mailaddress = memberList.get(i).getMemberEmail();
				MailService mailsend = new MailService();
				try {
					mailsend.mailSender(mailaddress);
				} catch (IOException e) {
					e.printStackTrace();
				}
				AccountCoupon ac = new AccountCoupon();
				ac.setCouponCode(couponCode);
				ac.setMemberId(memberList.get(i).getMemberId());;
				sqlSession2.insert("insertCoupon", ac);
			}
		}
	}
	
	public void mailSender(String toMail) throws IOException {
	    Email from = new Email("yun9102@naver.com");
	    String subject = "SendGrid test";
	    Email to = new Email(toMail);
	    Content content = new Content("text/plain", "쿠폰이 발급되었습니다");
	    Mail mail = new Mail(from, subject, to, content);
	
	    SendGrid sg = new SendGrid("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");
	    Request request = new Request();
	    try {
	      request.setMethod(Method.POST);
	      request.setEndpoint("mail/send");
	      request.setBody(mail.build());
	      Response response = sg.api(request);
	      System.out.println(response.getStatusCode());
	      System.out.println(response.getBody());
	      System.out.println(response.getHeaders());
	    } catch (IOException ex) {
	      throw ex;
	    }
  }
}