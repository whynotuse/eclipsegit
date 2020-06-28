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
 * NIO����ʵ�ָ���IO  ԭ���ǽ����ʱ��IO������������ȡ��������ת�Ƹ�����ϵͳ
 * �����ıȽϣ�
 * 		�������ݴ���ʹ��䷽ʽ
 * 		IO�����ķ�ʽ�������ݣ�NIO���Կ�ķ�ʽ��������
 * ��������IO ϵͳһ�δ���һ���ֽڵ����ݣ�һ������������һ���ֽ� һ�����������һ���ֽڵ����ݣ��൱��
 * ������IO �Կ����ʽ�������ݣ�ÿ�β������ǲ���������һ�����ݿ� �������ķ�ʽ�����Ķ�
 * 
 * ����������NIO���У��κ�ʱ�����NIO�����ݣ������ڲ�������д�������� 
 * 			���ʾ���һ���ֽ����� ��Ҳ��������������
 * ���������ͣ������������ͳ�����������  bytebuffer ���       ͨ��get/set���л�ȡ����ֵ
 * 
 * ͨ����channel�������ͨ������ȡ��д������  ��������    channel�Խӵ��ǲ���ϵͳ�ײ�ͻ���
 * 		�������ݶ���ͨ��buffer������� �����ľ��ǻ�����
 *   д���ݣ� ����----->������----->ͨ��
 *   �����ݣ�����----->ͨ��------>������
 *   
 * ���ܱȽϣ�1�ڴ�ӳ��  2NIO��д�ļ�  3ʹ���˻����IO�� 4�޻����IO��
 * 
 *@version:
 *@Description: 
 *@author :�⾧
 *@date:2019��9��30�� ����12:05:07
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
		RandomAccessFile rw = new RandomAccessFile("d:/hj����1.txt", "rw");
		
		FileChannel fIn = r.getChannel();
		FileChannel fOut = rw.getChannel();
		long size = fIn.size();
		//����ڴ�ӳ��Ļ���
		MappedByteBuffer fInBuf = fIn.map(MapMode.READ_ONLY, 0, size);
		MappedByteBuffer fOutBuf = fOut.map(MapMode.READ_WRITE, 0, size);
		
		for(int i=0;i<size;i++){
			//�������ǻ����� �ڴ�
			fOutBuf.put(fInBuf.get(i));
		}
		//�ڹرյ�ʱ�� �������ݿ�ķ�ʽ������������д���ļ�
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
			FileChannel fOut = new FileOutputStream("d:/hj����.txt").getChannel();
			
			ByteBuffer buf=ByteBuffer.allocate(1024);
			while(fIn.read(buf)!=-1){
				buf.flip();//��������ת ȷ����Ч��������
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
		//�Լ��ƶ���������С
		ByteBuffer buf=ByteBuffer.allocate(8);//����һ���ֽڻ����� ������ڴ�ռ�Ϊ8���ֽ�
		//������״̬���� ����������ֵָ��������������ʱ�̵�״̬ 
		//position  
		//limit
		//capacity
		System.out.println(buf.position());//0
		System.out.println(buf.limit());//8
		System.out.println(buf.capacity());//8
		//�򻺳����������
		buf.put((byte)10);
		buf.put((byte)20);
		buf.put((byte)30);
		buf.put((byte)40);
		System.out.println("---------------------------------");
		System.out.println(buf.position());//4
		System.out.println(buf.limit());//8
		System.out.println(buf.capacity());//8
		
		//��������ת  ��ȡһ�� ��ȡ��������
		buf.flip();
		System.out.println("-----------------------------------");
		System.out.println(buf.position());//0
		System.out.println(buf.limit());//4 �޶���������
		System.out.println(buf.capacity());//8
		
		if(buf.hasRemaining()){//position < limit bollean ��ǰλ�ú�����λ���Ƿ���Ԫ��
			for (int i = 0; i < buf.remaining(); i++) {//limit - position ���ص�ǰλ�ú�����λ��֮���Ԫ�ظ���
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
