package dz.com.cerist.artisanat.servlets.images;

import javax.servlet.ServletException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;


/**
 * Created by Marwen on 4/22/17.
 */

/*@WebServlet(name = "imageRender",urlPatterns = {"/sample-pictures/*"})*/

public class ImageRender extends HttpServlet {
    /**
	 * 
	 */
	private static final long serialVersionUID = -5359806399451074970L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
/*
        StringBuffer requestURL = request.getRequestURL();
        if (request.getQueryString() != null) {
            requestURL.append("?").append(request.getQueryString());
        }
        String completeURL = requestURL.toString();
        String[] tmp = completeURL.split("/");


        try {
            String path = "E:/workspace-sts-3.3.0.RELEASE/E-Artisane/WebContent/sample-pictures/" + tmp[tmp.length-1];
            String contentType = getServletContext().getMimeType(path);
            response.setContentType(contentType);

            FileInputStream in=new FileInputStream(new File(path));
            OutputStream out=response.getOutputStream();

            byte[] buffer=new byte[1024];
            int length;

            while((length=in.read(buffer))>0){
                out.write(buffer, 0, length);
            }

            in.close();

        } catch (Exception e) {
            e.printStackTrace(System.out);
        }*/
    }
}
