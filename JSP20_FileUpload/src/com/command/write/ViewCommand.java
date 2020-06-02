package com.command.write;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;

import javax.imageio.ImageIO;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lec.beans.FileDAO;
import com.lec.beans.FileDTO;
import com.lec.beans.WriteDAO;
import com.lec.beans.WriteDTO;

public class ViewCommand implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		
		WriteDAO dao=new WriteDAO();
		WriteDTO [] arr=null;
		
		//첨부파일
		FileDAO fileDao=new FileDAO();
		FileDTO [] fileArr=null;
		
		
		int uid=Integer.parseInt(request.getParameter("uid"));
		try {
			arr=dao.readByUid(uid);
			request.setAttribute("list", arr);
		} catch(SQLException e) {
			e.printStackTrace();
		}
		
		
		//첨부파일 읽어들이기 
		try {
			if(arr!=null && arr.length==1) {
				fileArr=fileDao.selectFilesByWrUid(uid); //첨부파일 읽어오기
				//이미지 파일 여부 세팅
				String realPath="";
				String saveFolder="upload";
				ServletContext context=request.getServletContext();
				realPath=context.getRealPath(saveFolder);
				
				for(FileDTO fileDto :fileArr) {
					String downloadedFilePath=realPath+File.separator+fileDto.getFile();
					BufferedImage imgData = ImageIO.read(new File(downloadedFilePath));
					if(imgData !=null) {
						fileDto.setImage(true);
					}
				}
				request.setAttribute("file", fileArr);
			}
		}catch (SQLException | IOException e) {
			e.printStackTrace();
		}
		
	}//end execute()

}
