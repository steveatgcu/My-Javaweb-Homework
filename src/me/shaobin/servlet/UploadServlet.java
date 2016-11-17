package me.shaobin.servlet;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import me.shaobin.dao.UploadDao;
import me.shaobin.entity.UploadEntity;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

public class UploadServlet implements Servlet {

	String uploadTemp = "D:/TentcooTools/";
	private UploadDao uploadDao;

	@Override
	public void destroy() {
	}

	@Override
	public ServletConfig getServletConfig() {
		return null;
	}

	@Override
	public String getServletInfo() {
		return null;
	}

	@Override
	public void init(ServletConfig arg0) throws ServletException {
		uploadDao = new UploadDao();
	}

	@Override
	public void service(ServletRequest srequest, ServletResponse arg1)
			throws ServletException, IOException {
		HttpServletRequest request = (HttpServletRequest) srequest;
		request.setCharacterEncoding("UTF-8");
		boolean isMultipart = ServletFileUpload.isMultipartContent(request);
		if (isMultipart) {
			try {
				FileItemFactory factory = new DiskFileItemFactory();
				ServletFileUpload upload = new ServletFileUpload(factory);
				List<FileItem> items = upload.parseRequest(request);
				Iterator<FileItem> iter = items.iterator();
				while (iter.hasNext()) {
					FileItem item = (FileItem) iter.next();
					UploadEntity uploadEntity = new UploadEntity();
					uploadEntity.setFileName(item.getName());
					String prefix = item.getName().substring(
							item.getName().lastIndexOf(".") + 1);
					File savedFile = new File(uploadTemp,
							System.currentTimeMillis() + "." + prefix);
					item.write(savedFile);
					uploadEntity.setFilePath(savedFile.getAbsolutePath());
					uploadDao.create(uploadEntity);
				}
				request.setAttribute("status", "上传已经完成");
			} catch (Exception e) {
				e.printStackTrace();
				request.setAttribute("status", "上传发生错误，失败");
			}
			request.getRequestDispatcher("/upload.jsp").forward(request, arg1);
		}

	}

}
