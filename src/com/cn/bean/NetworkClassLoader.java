package com.cn.bean;

import java.io.*;

public class NetworkClassLoader extends ClassLoader {
    
    private String host;
    private int port;
    
    public static void main(String[] args)throws Exception{
		
		 ClassLoader loader = new NetworkClassLoader("127.0.0.1", 4444);
		 System.out.println("自定义类加载器");
         Object pin = loader.loadClass("F:/"+"pin.class").newInstance();
	}
    
    public NetworkClassLoader(){
    	
    }
    
    public NetworkClassLoader(String host,int port){
    	this.host = host;
    	this.port = port;
    }
    
    //类加载器
    public Class loadClass( String name, boolean resolve ) throws ClassNotFoundException{
    	// 目标Class
        Class clas = null;
    System.out.println("执行类加载器");
        // 看是否已经加载该类
        clas = findLoadedClass( name );
        
        
        if(clas == null){
        	clas = findClass(name);
        }
        
        //如果class对象不存在则在系统中查找
        if (clas==null) {
          clas = findSystemClass( name );
        }
        
        if(clas == null){
        	
        	throw new ClassNotFoundException("该类不存在1");
        }
        
        //是否需要分析该类
        if (resolve && clas != null)
            resolveClass( clas );
        return clas;
     }
    
    //构造该类的Class对象
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
    	System.out.println(">>>>>不会执行");
        return null;
    }
    
    //从网络加载加载类的二进制代码，此处我们使用本地文件
    private byte[] loadClassData(String name)throws IOException{
        System.out.println("从网络加载加载类的二进制代码"+name);
        //读取类文件
        File file = new File(name);
        if(!file.exists()){
        	return null;
        }
        FileInputStream input = new FileInputStream(file);
       long length = file.length();
        byte[] bt = new byte[(int)length];
        
        int rl = input.read(bt);
        if(rl != length){
        	throw new IOException("不能读取所有内容");
        }
        input.close();
        
        return bt;
    }
}
