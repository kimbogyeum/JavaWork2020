package com.jar.validator;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLDecoder;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.jar.JarFile;
import java.util.stream.Collectors;


/*
 * Maven 빌드시: 손상된 jar 파일 확인(corrupted jar check)
 * 
 * 손상된 jar 파일의 경우 다운로드 시도
 * 
 * 다운로드 받은 후 해당 Maven 프로젝트들은 update 해주세요
 * */
public class JarValidator {

	private static final String URL_MAVEN2="https://repo1.maven.org/maven2";
	private static Path repositoryPath=null;
	
	public static void main(String[] args) throws IOException{
		//사용자 폴더 밑의 repository 경로
		repositoryPath=Paths.get(System.getProperty("user.home"),".m2","repository");
		
		System.out.println(repositoryPath);//사용자 경로
		
		//repository 경로 존재 여부 확인
		if(Files.exists(repositoryPath)) {
			
			JarValidator jv=new  JarValidator();
			
			List<Path> jarFiles=jv.getFiles(repositoryPath, ".jar");
			System.out.println("발견된 전체 jar 파일들: "+ jarFiles.size()+"개");
			
			//하나하나 경로 다봐보고싶으면 
//			for(Path p: jarFiles) {
//				System.out.println(p);
//			}
			
			jv.openJars(jarFiles);
			
			
		}else {
			System.out.println("Repository path "+ repositoryPath+"경로가 없습니다. ");
		}
	}//end main()
	
	
	
	
	/**
	 * 주어진 경로에서부터 시작하여 모든 이하 디렉토리들을 검색하여 주어진 확장자에 일치하는 파일들의 목록 만들기.
	 * @param filePath : File의 절대경로
	 * @param fileExtension : 검색할 파일의 확장자(jar)
	 * @return 디렉토리 내에 있는 모든 파일들의 List 
	 * 
	 */
	private List<Path> getFiles(Path filePath, String fileExtension) throws IOException{//특정 확장자를 가진 파일만 걸러낼꺼야
		return Files.walk(filePath)//filePath 부터 시작하여 이하 모든 파일들 검색
		.filter(p -> p.toString().endsWith(fileExtension))//endsWith : 문자열이 ()안의 문자열로 끝나는지 봐서 그것만 골라냄
		.collect(Collectors.toList());//List 모음
	}//end getFiles()
	
	
	//jar 파일이 온전한지 안한지 알아보자
	private List<String> openJars(List<Path> jarFiles){
		
		int [] badJars= {0}; //손상된 jar 파일 개수. 굳이 배열인 이유는 local inner 에서 사용하기 위해 
		
		//각각의 jar 파일에 대해 아래 수행
		jarFiles.forEach(path -> {
			String absPath=path.toAbsolutePath().toString(); //jar 파일 절대경로
			
			try(
					JarFile file=new JarFile(path.toFile());//jar 파일 open 시도
				){
			
			}catch(IOException e) { // ★ jar 파일 open 실패하면 IOException 발생
			
				String errMsg="손상 jar 발견: "+ absPath + "--exception: "+e.toString();
				System.out.println(errMsg);
				//손상된 jar 파일 개수 증가 
				badJars[0]++;//에러나는 이유: local inner에서 같은 scope에 있는 지역변수 못씀..? -> 배열로 만들어주면 됨. 
				String downloadUrl=URL_MAVEN2+absPath.substring(repositoryPath.toString().length()).replaceAll("\\\\", "/");//왜 네개일까? 
				//										△  https://repo1.maven.org/다 잘라버리기...?
				
				
				try {
					download(downloadUrl,absPath);
				}catch(IOException ex){
					System.out.println("다운로드 실패");
				}
				
				
				System.out.println("손상된 jar 파일 개수=" +badJars[0]);
			}
		});
		System.out.println("손상된 jar 파일 개수 = "+badJars[0]);
		return null;
	}//end openJars()
	
	
	
	/**
	 * 특정 url의 파일 다운로드
	 * @param srcUrl : 다운로드 받을 파일의 url
	 * @param dstFile : 다운받아 저장할 파일 경로 
	 * @throws IOException
	 */
	public void download(String srcUrl, String dstFile) throws IOException{
		URL url=null;
		HttpURLConnection conn=null;
		InputStream in=null;
		BufferedInputStream bin=null;
		FileOutputStream out=null;
		BufferedOutputStream bout=null;
		
		
		try {
			
			System.out.println("다운로드 시도.."+srcUrl+"\n\t → "+ dstFile);
			
			url=new URL(srcUrl);
			conn=(HttpURLConnection) url.openConnection();
			int contentLength=conn.getContentLength();//파일크기
			String contentType=conn.getContentType();//파일 종료 MIME-TYPE
			
			// 다운로드 받는 파일 이름 확인 가능
			String raw=conn.getHeaderField("Content-Disposition"); //attachment; filename=abc.jpg
			if(raw!=null && raw.indexOf("=") !=-1) {
				String fileName = raw.split("=")[1].trim();
				//dstFile=URLDecoder.decode(fileName,"UTF-8");
			}
			
			in=conn.getInputStream();
			bin=new BufferedInputStream(in);
			out=new FileOutputStream(dstFile);
			bout=new BufferedOutputStream(out);
			
			int bytes; //읽어들인 바이트 수 
			byte[] buf=new byte[contentLength];//버퍼
			
		
			while((bytes=bin.read(buf)) !=-1) {	//파일의 크기만큼의 buffer을 정해두었기 때문에 한바퀴만 돌껄
				bout.write(buf,0,bytes);
			}
			
			
			// 다운로드 성공!
			System.out.println("다운로드 성공\t"+contentLength+"bytes"+contentType);
			
		}finally {
			if(bout!=null) bout.close();
			if(bin !=null) bin.close();
		}
		
	}//end download()
	
	

}
