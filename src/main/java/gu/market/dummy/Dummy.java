package gu.market.dummy;

import java.util.ArrayList;

import gu.market.repository.model.Member;
import gu.market.repository.model.Product;

public class Dummy {
	public ArrayList<Product> getProductList() {
		ArrayList<Product> list = new ArrayList<Product>();
		list.add(new Product(0, 0, "P0001", "건강한펫 동결건조 소프트 통살 연어 스틱 100g", 50000,10));
		list.add(new Product(1, 1, "P0002", "건강한펫 동결건조 착한북어 스틱 100g",  12000,10));
		list.add(new Product(2, 2, "P0003", "건강한펫 동결건조 치킨텐더 대왕 도시락 600g", 30000,10));
		list.add(new Product(3, 3, "P0004", "건강한펫 동결건조 착한치킨 스틱 대왕 도시락 700g", 51000,10));
		list.add(new Product(4, 4, "P0005", "건강한펫 동결건조 착한북어 스틱 대왕 도시락 500g",84000,10));
		list.add(new Product(5, 5, "P0006", "건강한펫 동결건조 뉴 소프트 통살 연어 대왕 도시락 500g",18000,10));
		list.add(new Product(6, 6,  "P0007", "건강한펫 동결건조 연근 방울토마토 30g / 강아지 간식",20000,10));
		list.add(new Product(7, 7,  "P0008", "건강한펫 동결건조 착한북어 스틱 500", 60000,10));
		list.add(new Product(8, 8,  "P0009", "건강한펫 동결건조 치킨텐더 200g / 강아지 고양이간식",45000,10));
		return list;
	}
	
	public ArrayList<Member> getMemberList() {
		ArrayList<Member> list = new ArrayList<Member>();
		list.add(new Member(1, "M10001", "1111", "김행복", "010-1111-2222","서울" , "**구"));
		list.add(new Member(2, "M10002", "2222", "이축복", "010-1111-3333","부산" , "**구"));
		list.add(new Member(3, "M10003", "3333", "장믿음", "010-1111-4444","서울" , "**구"));
		list.add(new Member(4, "M10004", "4444", "최사랑", "010-1111-5555","경기" , "**시"));
		list.add(new Member(5, "M10005", "5555", "진평화", "010-1111-6666","경기" , "**시"));
		list.add(new Member(6, "M10006", "6666", "차공단", "010-1111-7777","충남" , "**시"));
		return list;
	};
	
//안맞음 db에 넣어서 안바꿈	
//	public ArrayList<Category getCategoryList() {
//		Category[] list = new Category[CategoryMaxSize];
//		list[0] = new Category("C01", "츄르/파우더");
//		list[0] = new Category("C02", "기호성테스터");
//		list[0] = new Category("C03", "대용량");
//		list[0] = new Category("C05", "소용량");
//		list[0] = new Category("C05", "과일/야채");
//		return list;
//	};
}
