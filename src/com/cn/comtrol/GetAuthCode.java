package com.cn.comtrol;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class GetAuthCode
 */
public class GetAuthCode extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	//验证码字体 
    private Font[] codeFont = 
    { 
        new Font("Algerian", Font.BOLD,25), 
  new Font("Vivaldi", Font.BOLD, 25), 
        new Font("Broadway", Font.BOLD,25), 
  new Font("Forte", Font.BOLD, 25) 
    }; 
        //验证码数字颜色 
    private Color[] color = 
    { 
       Color.BLACK, Color.RED, Color.DARK_GRAY, Color.BLUE 
    }; 

    String codeNumbers = ""; 

    int width = 90, height = 25; 

    // 处理 HTTP get 请求 
    public void doGet(HttpServletRequest request, HttpServletResponse response) 
                      throws ServletException, IOException 
    { 
        // 清空缓冲区 
        response.reset(); 

        // 注意这里的MIME类型 
        response.setContentType("image/png"); 

        // 设置页面不缓存 
        response.setHeader("Pragma", "No-cache"); 
        response.setHeader("Cache-Control", "no-cache"); 
        response.setDateHeader("Expires", 0); 

        // 创建一个 110X40 的图像,验证码显示的图片大小 
        BufferedImage image = new BufferedImage(width, height, 
                                                BufferedImage.TYPE_INT_RGB); 

        // 得到图形环境对象 g 
        Graphics g = image.getGraphics(); 

        // 填充背景 
        g.setColor(new Color(64,219,255)); 
        g.fillRect(0, 0, width, height); 

        for (int i = 0; i < 4; i++) 
        { 
            drawCode(g, i); 
        } 

        drawNoise(g, 17); 

        // 绘制边框 
        g.setColor(Color.gray); 
        g.drawRect(0, 0, width - 1, height - 1); 

        // 将验证码内容保存进session中，用于验证用户输入是否正确时使用 
        HttpSession session = request.getSession(true); 
        session.removeAttribute("codeNumbers"); 
        System.out.println(codeNumbers);
        session.setAttribute("codeNumbers", codeNumbers); 
        
  // 重设字符串 
        codeNumbers = ""; 

        // 利用ImageIO类的write方法对图像进行编码 
        ServletOutputStream sos = response.getOutputStream(); 
        ImageIO.write(image, "PNG", sos); 
        sos.close(); 
    } 

    // 绘制验证码 
    public void drawCode(Graphics graphics, int i) 
    { 
        int number = (int)(Math.random() * 10); 
        graphics.setFont(codeFont[i]); 
        graphics.setColor(color[i]); 
        graphics.drawString("" + number, 10 + i * 17,22); 

        codeNumbers += number; 
    } 

    // 绘制干扰线 
    public void drawNoise(Graphics graphics, int lineNumber) 
    { 
        graphics.setColor(new Color(9,143,134)); 
        for (int i = 0; i < lineNumber; i++) 
        { 
            int pointX1 = 1 + (int)(Math.random() * width); 
            int pointY1 = 1 + (int)(Math.random() * height); 
            int pointX2 = 1 + (int)(Math.random() * width); 
            int pointY2 = 1 + (int)(Math.random() * height); 
            graphics.drawLine(pointX1, pointY1, pointX2, pointY2); 
        } 
        
    } 
    // 处理 HTTP post 请求, 和doGet一样 
    public void doPost(HttpServletRequest request, HttpServletResponse response) 
        throws ServletException, IOException 
    { 
        doGet(request, response); 
    } 

}
