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
       
	//��֤������ 
    private Font[] codeFont = 
    { 
        new Font("Algerian", Font.BOLD,25), 
  new Font("Vivaldi", Font.BOLD, 25), 
        new Font("Broadway", Font.BOLD,25), 
  new Font("Forte", Font.BOLD, 25) 
    }; 
        //��֤��������ɫ 
    private Color[] color = 
    { 
       Color.BLACK, Color.RED, Color.DARK_GRAY, Color.BLUE 
    }; 

    String codeNumbers = ""; 

    int width = 90, height = 25; 

    // ���� HTTP get ���� 
    public void doGet(HttpServletRequest request, HttpServletResponse response) 
                      throws ServletException, IOException 
    { 
        // ��ջ����� 
        response.reset(); 

        // ע�������MIME���� 
        response.setContentType("image/png"); 

        // ����ҳ�治���� 
        response.setHeader("Pragma", "No-cache"); 
        response.setHeader("Cache-Control", "no-cache"); 
        response.setDateHeader("Expires", 0); 

        // ����һ�� 110X40 ��ͼ��,��֤����ʾ��ͼƬ��С 
        BufferedImage image = new BufferedImage(width, height, 
                                                BufferedImage.TYPE_INT_RGB); 

        // �õ�ͼ�λ������� g 
        Graphics g = image.getGraphics(); 

        // ��䱳�� 
        g.setColor(new Color(64,219,255)); 
        g.fillRect(0, 0, width, height); 

        for (int i = 0; i < 4; i++) 
        { 
            drawCode(g, i); 
        } 

        drawNoise(g, 17); 

        // ���Ʊ߿� 
        g.setColor(Color.gray); 
        g.drawRect(0, 0, width - 1, height - 1); 

        // ����֤�����ݱ����session�У�������֤�û������Ƿ���ȷʱʹ�� 
        HttpSession session = request.getSession(true); 
        session.removeAttribute("codeNumbers"); 
        System.out.println(codeNumbers);
        session.setAttribute("codeNumbers", codeNumbers); 
        
  // �����ַ��� 
        codeNumbers = ""; 

        // ����ImageIO���write������ͼ����б��� 
        ServletOutputStream sos = response.getOutputStream(); 
        ImageIO.write(image, "PNG", sos); 
        sos.close(); 
    } 

    // ������֤�� 
    public void drawCode(Graphics graphics, int i) 
    { 
        int number = (int)(Math.random() * 10); 
        graphics.setFont(codeFont[i]); 
        graphics.setColor(color[i]); 
        graphics.drawString("" + number, 10 + i * 17,22); 

        codeNumbers += number; 
    } 

    // ���Ƹ����� 
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
    // ���� HTTP post ����, ��doGetһ�� 
    public void doPost(HttpServletRequest request, HttpServletResponse response) 
        throws ServletException, IOException 
    { 
        doGet(request, response); 
    } 

}
