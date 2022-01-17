package gu.market.controller;

import java.io.File;
import java.time.LocalDate;
import java.util.Enumeration;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import gu.market.dto.PutProductRequest;
import gu.market.error.MarketException;
import gu.market.repository.model.*;
import gu.market.service.*;

@Controller
@RequestMapping(value = "/admin")
public class AdminController {
	
	@Autowired
	private MarketService marketSvc;
	@Autowired
	private AccountService actSvc;
	@Autowired
	private AdminService adminSvc;
	
	@RequestMapping(value="/adminMain", method = RequestMethod.GET) 
	public String adminMain() {
		return "admin/admin_home";
	} 
	//전체멤버
	@RequestMapping(value = "/allMember")
	public String allMember(ModelMap modelMap) throws Exception {
		List<?> memberview = adminSvc.allMember();

		modelMap.addAttribute("memberview", memberview);
		return "admin/allMemberPage";
	}
	//멤버선택
	@RequestMapping(value = "/selectedMember")
	public ModelAndView selectedMember(HttpServletRequest request) throws Exception {
		String memberId = request.getParameter("memberId");
		Member memberInfo = adminSvc.selectMemberOne(memberId);

		ModelAndView mv = new ModelAndView("admin/selectedMemberPage");
		mv.addObject("member_info", memberInfo);

		return mv;
	}
	
	//상품등록get
		@RequestMapping(value = "/getAddProduct")
		public String getAddProduct(HttpSession session) throws Exception {
			return "admin/addProductPage";
		}
	//상품등록post
	@RequestMapping(value = "/postAddProduct", method = RequestMethod.POST)
	public String postAddProduct(HttpServletRequest request) {
		
		String path = request.getServletContext().getRealPath("productImage");
		int size = 1024 * 1024 * 100; // 저장가능한 파일 크기 100
		
		File dir = new File(path);
		if (!dir.exists()) {
			dir.mkdirs(); 
		}

	    String file = ""; // 업로드 한 파일의 이름(이름이 변경될수 있다)
	    //String originalFile = ""; // 이름이 변경되기 전 실제 파일 이름
	    
	    // 실제로 파일 업로드하는 과정
	    try{
	        MultipartRequest multi = new MultipartRequest(request, path, size, "UTF-8", new DefaultFileRenamePolicy());
	        
	        // 여러개 파일들
	    	Enumeration<String> files = multi.getFileNames();
        	String str = files.nextElement(); // 파일 이름을 받아와 string으로 저장
        	file = multi.getFilesystemName(str); // 업로드 된 파일 이름 가져옴
	        
	        //originalFile = multi.getOriginalFileName("pImgSrc"); // 원래의 파일이름 가져옴
	        
	    
	    System.out.println("===============");
        System.out.println(file);
        //System.out.println(originalFile);
		
		String pName = multi.getParameter("pName");
		int pCCode = Integer.parseInt(multi.getParameter("pCCode"));
		String pDetail = multi.getParameter("pDetail");
		int pPrice = Integer.parseInt(multi.getParameter("pPrice"));
		int pStock = Integer.parseInt(multi.getParameter("pStock"));
		String pStatus = multi.getParameter("pStatus");
		String pImgSrc = path+"\\"+file;
		System.out.println("path : "+path);
		System.out.println("pImgSrc : "+pImgSrc);
		
		adminSvc.addProduct(pName, pCCode, pDetail, pPrice, pStock, pStatus, pImgSrc);
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    return "redirect:/admin/adminMain";
	}
	//관리자 권한주기
	@RequestMapping(value = "/checkAdmin", method = RequestMethod.POST)
	public String checkAdmin(HttpServletRequest request) throws MarketException {
		String memberId = request.getParameter("memberId");
		String check = request.getParameter("memberCheck");
		if(check!=null) {
			try {
				adminSvc.deleteAdmin(memberId);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else {
			try {
				adminSvc.addAdmin(memberId);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return "redirect:/admin/adminMain";
	}
	//품목별 매출
	@RequestMapping(value = "/productSales", method = RequestMethod.GET)
	public String productSales(ModelMap modelMap) {
		List<?> pSview = adminSvc.productSales();
		modelMap.addAttribute("pSview", pSview);
		return "/admin/productSales";
	}
	//회원별 매출
		@RequestMapping(value = "/memberSales", method = RequestMethod.GET)
		public String memberSales(ModelMap modelMap) {
			List<?> pSview = adminSvc.memberSales();
			modelMap.addAttribute("pSview", pSview);
			return "/admin/memberSales";
		}
	//상품전체보기
	@RequestMapping(value = "/adminProduct")
	public String allProductList(ModelMap modelMap) throws Exception {
		List<?> productview = adminSvc.adminProduct();

		modelMap.addAttribute("productview", productview);
		return "admin/allProductViewPage";
	}
	// 한품목 선택했을때 읽기
	@RequestMapping(value = "/selectedProduct")
	public ModelAndView selectedProduct(HttpServletRequest request) throws Exception {
		String productNo = request.getParameter("productNo");
		Product productInfo = adminSvc.selectProductOne(productNo);

		ModelAndView mv = new ModelAndView("admin/updateProductPage");
		mv.addObject("product_info", productInfo);

		return mv;
	}
	@PostMapping(value = "/modifiedProductInfo", consumes = {"application/x-www-form-urlencoded"})
	public String modifiedProductInfo(HttpServletRequest request, HttpSession session, PutProductRequest product) throws MarketException {
		System.out.println(product.getProductStock());
		try {
			adminSvc.modifiedProductInfo(product);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "admin/admin_home";
	}
	
	//상품정보수정
//	@RequestMapping(value = "/modifiedProductInfo")
//	public String modifiedProductInfo(HttpServletRequest request, HttpSession session, Product product) throws MarketException {
//		int productNo = Integer.parseInt(request.getParameter("productNo"));
//		int productCatCode = Integer.parseInt(request.getParameter("productCatCode"));
//		String productName = request.getParameter("productName");
//		String productDetail = request.getParameter("productDetail");
//		int productPrice = Integer.parseInt(request.getParameter("productPrice"));
//		int productStock = Integer.parseInt(request.getParameter("productStock"));
//		String productStatus = request.getParameter("productStatus");
//		//String productImgSrc = request.getParameter("address2"); 이미지 수정 나중에
//		try {
//			adminSvc.modifiedProductInfo(productNo, productCatCode, productName, productDetail, productPrice, productStock, productStatus);
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//		return "admin/admin_home";
//	}
	//상품삭제
	@RequestMapping(value= "/deleteProduct")
	public String deleteProduct(HttpServletRequest request) {
		int productNo = Integer.parseInt(request.getParameter("productNo"));
		String productStatus = request.getParameter("productStatus");
		
		adminSvc.deleteProduct(productNo, productStatus);
		
		return "admin/admin_home";
	}
	//클레임관리
	@Autowired
	private ReviewService reviewSvc;
	
	@RequestMapping(value = "/claimList")
	public String reviewList(ModelMap modelMap) throws Exception {
		List<?> listview = reviewSvc.selectClaimList();
		  
		modelMap.addAttribute("listview", listview);
		return "review/reviewList";
	}
}
