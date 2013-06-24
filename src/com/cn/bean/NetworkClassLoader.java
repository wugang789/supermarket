package com.cn.bean;

import java.io.*;

public class NetworkClassLoader extends ClassLoader {
    
    private String host;
    private int port;
    
    public static void main(String[] args)throws Exception{
		
		 ClassLoader loader = new NetworkClassLoader("127.0.0.1", 4444);
		 System.out.println("�Զ����������");
         Object pin = loader.loadClass("F:/"+"pin.class").newInstance();
	}
    
    public NetworkClassLoader(){
    	
    }
    
    public NetworkClassLoader(String host,int port){
    	this.host = host;
    	this.port = port;
    }
    
    //�������
    public Class loadClass( String name, boolean resolve ) throws ClassNotFoundException{
    	// Ŀ��Class
        Class clas = null;
    System.out.println("ִ���������");
        // ���Ƿ��Ѿ����ظ���
        clas = findLoadedClass( name );
        
        
        if(clas == null){
        	clas = findClass(name);
        }
        
        //���class���󲻴�������ϵͳ�в���
        if (clas==null) {
          clas = findSystemClass( name );
        }
        
        if(clas == null){
        	
        	throw new ClassNotFoundException("���಻����1");
        }
        
        //�Ƿ���Ҫ��������
        if (resolve && clas != null)
            resolveClass( clas );
        return clas;
     }
    
    //��������Class����
    public Class findClass(String name){
    	try{
            byte[] b = loadClassData(name);
            if(b == null){
            	return null;
            }
            System.out.println("my findClass method");
            return defineClass("pin", b, 0, b.length);
            
        }catch(IOException e){
        	System.out.print(e.getMessage());
        }
    	System.out.println(">>>>>����ִ��");
        return null;
    }
    
    //��������ؼ�����Ķ����ƴ��룬�˴�����ʹ�ñ����ļ�
    private byte[] loadClassData(String name)throws IOException{
        System.out.println("��������ؼ�����Ķ����ƴ���"+name);
        //��ȡ���ļ�
        File file = new File(name);
        if(!file.exists()){
        	return null;
        }
        FileInputStream input = new FileInputStream(file);
       long length = file.length();
        byte[] bt = new byte[(int)length];
        
        int rl = input.read(bt);
        if(rl != length){
        	throw new IOException("���ܶ�ȡ��������");
        }
        input.close();
        
        return bt;
    }
}
