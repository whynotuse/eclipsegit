package com.chanpter2.API;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.FileChannel.MapMode;

/**
 * NIO可以实现高速IO  原因是将最耗时的IO操作（填充和提取缓冲区）转移给操作系统
 * 流与快的比较：
 * 		区别：数据打包和传输方式
 * 		IO以流的方式处理数据，NIO是以块的方式处理数据
 * 面向流的IO 系统一次处理一个字节的数据，一个输入流产生一个字节 一个输出流消耗一个字节的数据，相当慢
 * 面向块的IO 以块的形式处理数据，每次操作都是产生和消耗一个数据块 比以流的方式处理快的多
 * 
 * 缓冲区：在NIO库中，任何时候访问NIO中数据，都是在操作（读写）缓冲区 
 * 			本质就是一个字节数组 但也可以是其他数组
 * 缓冲区类型：基本数据类型除布尔的数组  bytebuffer 最常用       通过get/set进行获取和设值
 * 
 * 通道：channel对象可以通过它读取和写入数据  类似于流    channel对接的是操作系统底层和缓存
 * 		所有数据都是通过buffer对象处理的 操作的就是缓冲区
 *   写数据： 数据----->缓冲区----->通道
 *   读数据：数据----->通道------>缓冲区
 *   
 * 性能比较：1内存映射  2NIO读写文件  3使用了缓存的IO流 4无缓存的IO流
 * 
 *@version:
 *@Description: 
 *@author :衡晶
 *@date:2019年9月30日 下午12:05:07
 */
public class NIOTest {
	public static void main(String[] args) {
//		NIOtest1();

//		NIOcopy();
		
//		randomAccessFile();

	
	
	}

	private static void randomAccessFile() {
		try {
		RandomAccessFile r = new RandomAccessFile("d:/hj.txt", "r");
		RandomAccessFile rw = new RandomAccessFile("d:/hj副本1.txt", "rw");
		
		FileChannel fIn = r.getChannel();
		FileChannel fOut = rw.getChannel();
		long size = fIn.size();
		//获得内存映射的缓冲
		MappedByteBuffer fInBuf = fIn.map(MapMode.READ_ONLY, 0, size);
		MappedByteBuffer fOutBuf = fOut.map(MapMode.READ_WRITE, 0, size);
		
		for(int i=0;i<size;i++){
			//操作的是缓冲区 内存
			fOutBuf.put(fInBuf.get(i));
		}
		//在关闭的时候 会以数据块的方式将缓冲区数据写入文件
		fOut.close();
		fIn.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("RandomAccess success!");
	}

	private static void NIOcopy() {
		try {
			FileChannel fIn = new FileInputStream("d:/hj.txt").getChannel();
			FileChannel fOut = new FileOutputStream("d:/hj副本.txt").getChannel();
			
			ByteBuffer buf=ByteBuffer.allocate(1024);
			while(fIn.read(buf)!=-1){
				buf.flip();//缓冲区反转 确定有效数据区域
				fOut.write(buf);
				buf.clear();
			}
			fOut.close();
			fIn.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("copy success!!");
	}

	private static void NIOtest1() {
		//自己制定缓冲区大小
		ByteBuffer buf=ByteBuffer.allocate(8);//创建一个字节缓冲区 申请的内存空间为8个字节
		//缓冲区状态变量 可以用三个值指定缓冲区在任意时刻的状态 
		//position  
		//limit
		//capacity
		System.out.println(buf.position());//0
		System.out.println(buf.limit());//8
		System.out.println(buf.capacity());//8
		//向缓冲区添加数据
		buf.put((byte)10);
		buf.put((byte)20);
		buf.put((byte)30);
		buf.put((byte)40);
		System.out.println("---------------------------------");
		System.out.println(buf.position());//4
		System.out.println(buf.limit());//8
		System.out.println(buf.capacity());//8
		
		//缓冲区反转  截取一下 截取已有数据
		buf.flip();
		System.out.println("-----------------------------------");
		System.out.println(buf.position());//0
		System.out.println(buf.limit());//4 限定数据区域
		System.out.println(buf.capacity());//8
		
		if(buf.hasRemaining()){//position < limit bollean 当前位置和限制位置是否有元素
			for (int i = 0; i < buf.remaining(); i++) {//limit - position 返回当前位置和限制位置之间的元素个数
				byte b =buf.get(i);
				System.out.println(b);
			}
		}
		System.out.println("----------------------");
		System.out.println(buf.position());//0
		System.out.println(buf.limit());//4 
		System.out.println(buf.capacity());//8
	}
}
