package com.javalec.function;

public class Share {
	public static String dbName = "jdbc:mysql://192.168.50.2/ebid?serverTimezone=UTC&charactorEncoding=utf8&useSSL=FALSE";
	public static String dbUser = "root";
	public static String dbPass = "qwer1234";
	
	public static String id;
	public static String pw;
//	public static String id = "joa72";
//	public static String pw = "joaaa2";
	
	public static int filename = 0;
	
	// Home에서 detail 상세페이지로 진입 시 필요한 postid
	public static int postId = 0;
	
	// User profile Image를 가져오기 위함
	public static int sellId = 0;
	
	// post_status 저장
	public static String post_status;
	
	// chat id
	public static int chatid;
	
	// image num
	public static int imageNum;
	
	// check if chat is new?
	public static boolean checkNewChat;
	
	// 블락 할 유저 체크
	public static String checkUser;
	
	// 채팅이 이미지인지 확인
	public static boolean checktextImage;
	
}
