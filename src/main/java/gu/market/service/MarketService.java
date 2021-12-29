package gu.market.service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.ws.rs.core.Response;

import org.json.JSONObject;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;

import gu.market.config.MarketConfig;
import gu.market.dto.Page;
import gu.market.error.ErrorCode;
import gu.market.error.MarketException;
import gu.market.repository.model.*;
import gu.market.session.SessionManager;

@Service
public class MarketService {

	@Autowired
	@Resource(name = "sqlSessionTemplate2")
	private SqlSessionTemplate sqlSession2;

	private String createNaverAPIURL(String code, String state) throws Exception {
		String redirectURI = URLEncoder.encode(MarketConfig.authNaverCallbackURL, "UTF-8");

		String apiURL;
		apiURL = "https://nid.naver.com/oauth2.0/token?grant_type=authorization_code&";
		apiURL += "client_id=" + MarketConfig.clientId;
		apiURL += "&client_secret=" + MarketConfig.clientSecret;
		apiURL += "&redirect_uri=" + redirectURI;
		apiURL += "&code=" + code;
		apiURL += "&state=" + state;
		return apiURL;
	}

	private String requestHTTP(String requestURL, Map<String, String> map) throws Exception {
		URL url = new URL(requestURL);
		HttpURLConnection con = (HttpURLConnection) url.openConnection();

		// HTTP Request

		// HTTP Request > Method
		con.setRequestMethod("GET");

		// HTTP Request > Header
		if(map != null) {
			for(String key : map.keySet()) {
				//con.setRequestProperty("Authorization", authorization);
				con.setRequestProperty(key, map.get(key));
			}
		}
			
		// HTTP Response

		// HTTP Response > Status Code
		int responseCode = con.getResponseCode();
		System.out.print("responseCode=" + responseCode);

		// HTTP Response > Body
		BufferedReader br;
		if (responseCode == HttpURLConnection.HTTP_OK) {
			br = new BufferedReader(new InputStreamReader(con.getInputStream()));
		} else {
			br = new BufferedReader(new InputStreamReader(con.getErrorStream()));
		}
		String inputLine;
		StringBuffer res = new StringBuffer();
		while ((inputLine = br.readLine()) != null) {
			res.append(inputLine);
		}
		br.close();

		if (responseCode == HttpURLConnection.HTTP_OK) {
			System.out.println(res.toString());
			return res.toString();
		}
		
		return null;
	}

	public String authWithNaver(String code, String state) {
		try {
			String apiURL = createNaverAPIURL(code, state);
			String res = requestHTTP(apiURL, null);
			
			JSONObject jObject = new JSONObject(res);
			String access_token = jObject.getString("access_token");
			String refresh_token = jObject.getString("refresh_token");
	
			System.out.println("access_token: " + access_token);
			System.out.println("refresh_token: " + refresh_token);
	
			return access_token;
		} catch (Exception e) {
			e.printStackTrace();
			return "";
		}
	}
	
	public Member getPersonalInfo(String accessCode) throws Exception {
		String apiURL = "https://openapi.naver.com/v1/nid/me";
		Map<String, String> hashMap = new HashMap<String, String>();
		hashMap.put("Authorization", "Bearer " + accessCode);
		String res = requestHTTP(apiURL, hashMap);
		
		JSONObject resObj = new JSONObject(res);
		JSONObject response = resObj.getJSONObject("response");
		String id = response.getString("id");
		Member idCheck = sqlSession2.selectOne("idCheck", id);
		return idCheck;
	}
	
	public Member getInfo(String accessCode) throws Exception{
		String apiURL = "https://openapi.naver.com/v1/nid/me";
		Map<String, String> hashMap = new HashMap<String, String>();
		hashMap.put("Authorization", "Bearer " + accessCode);
		String res = requestHTTP(apiURL, hashMap);
		
		JSONObject resObj = new JSONObject(res);
		JSONObject response = resObj.getJSONObject("response");
		
		Member member = new Member();
		member.setMemberId(response.getString("id"));
		member.setMemberName(response.getString("name"));
		member.setMemberGender(response.getString("gender"));
		member.setMemberPhone(response.getString("mobile"));
		String birthdate = response.getString("birthyear")+"-"+response.getString("birthday");
		DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		member.setMemberBirthDate(LocalDate.parse(birthdate, format));
		return member;
	}
	
	// 전체상품
	public List<?> allProduct() throws Exception {
		return sqlSession2.selectList("allProduct");
	}

	// 상품검색
	public List<?> searchProduct(String productName) throws Exception {
		return sqlSession2.selectList("searchProduct", productName);
	}

	// 추천상품(특정카테고리)
	public List<?> recommandProduct() throws Exception {
		return sqlSession2.selectList("recommandProduct");
	}

	// 신상품(3개만)
	public List<?> newProduct() throws Exception {
		return sqlSession2.selectList("newProduct");
	}

	// 한품목선택
	public Product selectProductOne(String productNo) throws Exception {
		return sqlSession2.selectOne("selectProductOne", productNo);
	}

	// 구매 - 재고 빼기
	public void minusCount(int productNo, int salesCount) throws MarketException {
		Sales sales = new Sales();
		sales.setProductNo(productNo);
		sales.setSalesCount(salesCount);
		// 재고부족할때 오류페이지로 나가게되는 과정
		Product productinfo = new Product();
		productinfo = sqlSession2.selectOne("selectProductOne", productNo);

		if (productinfo.getProductStock() < sales.getSalesCount()) {
			throw new MarketException(ErrorCode.ShortStock);
		} else {
			sqlSession2.update("minusCount", sales);
		}
	}

	// 구매 - sales db 등록
	public void purchase(String memberId, int productNo, int salesCount) throws MarketException {
		Sales sales = new Sales();
		sales.setMemberId(memberId);
		sales.setProductNo(productNo);
		sales.setSalesCount(salesCount);

		sqlSession2.insert("purchase", sales);
	}

	public void deleteFcart(int cartNo) {
		sqlSession2.delete("deleteFcart", cartNo);
	}

	// 장바구니보기
	public List<?> allCart(String id) throws Exception {
		return sqlSession2.selectList("allCart", id);
	}

	// 장바구니추가
	public void addCart(String memberId, int productNo, int salesCount) throws MarketException {
		Cart cart = new Cart();
		cart.setMemberId(memberId);
		cart.setProductNo(productNo);
		cart.setSalesCount(salesCount);

		sqlSession2.insert("addCart", cart);
	}
	
	//페이징
	public int countProductList() {
    	return sqlSession2.selectOne("countProduct");
    }
    public List<Product> selectProductList(Page vo) {
    	int start = vo.getStart();
    	int end = vo.getEnd();
    	Map<String, Integer> input = new HashMap<String, Integer>();
    	input.put("start", start);
    	input.put("end", end);
    	return sqlSession2.selectList("allProduct", input);
    }
}