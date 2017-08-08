package com.starry.servlet;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ImgServlet
 */
@WebServlet("/ImgServlet")
public class ImgServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ImgServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
				//response.getWriter().append("Served at: ").append(request.getContextPath());
				 response.setContentType("image/jpeg");
				 int width = 100;
				 int height = 40;
				 BufferedImage img = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
			        //获得画笔
			        Graphics graphics = img.getGraphics();
			        //给画笔设置为蓝色
			        graphics.setColor(Color.BLUE);
			        //绘制矩形
			        graphics.fillRect(0, 0, width, height);
			        //给画笔设置为白色
			        graphics.setColor(new Color(34, 95, 15));
			        graphics.fillRect(1, 1, width-2, height-2);
			        //定义字符数据
			        String code = "1234567890abcdefg";
			        Random rd = new Random();
			        StringBuffer codesave = new StringBuffer();
			        //设置画笔的字体样式为楷体、加粗，行高
			        graphics.setFont(new Font("楷体", Font.BOLD, height-4));
			        for (int i = 0; i < 4; i++) {
			            //设置颜色
			            graphics.setColor(new Color(rd.nextInt(256), rd.nextInt(256), rd.nextInt(256)));
			            //取出随机索引
			            int index = rd.nextInt(code.length());
			            codesave.append(code.substring(index, index+1));
			            //画字符串
			            graphics.drawString(code.substring(index, index+1), width/6*(i+1), height-4);
			        }
			        //写到浏览器  
			
			        request.getSession().setAttribute("codesave", codesave);
			        ImageIO.write(img, "jpg", response.getOutputStream());

		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
