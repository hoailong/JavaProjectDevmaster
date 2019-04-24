package test;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

@WebServlet("/uploadfile")
public class BasicUploadMultipleFileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public BasicUploadMultipleFileServlet() {
		super();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		 final String UPLOAD_DIRECTORY = "D:/JAVAWEBDEVMASTER/RestaurantManagement/WebContent/resources/images/food/";
		try {
			ServletFileUpload sf = new ServletFileUpload(new DiskFileItemFactory());
			List<FileItem> multifiles = sf.parseRequest(request);
			
			for (FileItem fileItem : multifiles) {
					fileItem.write(new File(UPLOAD_DIRECTORY + fileItem.getName()));
			}
			
			System.out.println("Uploaded");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
