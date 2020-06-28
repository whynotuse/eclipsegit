package com.chanpter2.API;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.io.RandomAccessFile;
import java.io.Reader;
import java.io.StreamTokenizer;
import java.io.StringReader;
import java.io.Writer;
import java.nio.charset.Charset;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import javax.swing.text.StyledEditorKit.ForegroundAction;

/**
 * 
 *   IO流是一组有顺序的 有起点和终点的字节集合 是数据传输的抽象总称
 *   字节流抽象类 inputStream outputStream
 *   输入输出字节流操作原理  每次会操作一个字节，（从文件中读取或写入）
 *   字节操作流程默认每次直接把数据写入文件 不带缓冲
 *   使用字节流读取文本文件可能造成乱码 原因是中文占两个字节 读取一半就进行编码了 所以读文本文件建议字符流
 *   
 *   字符流抽象类Writer reader 基于字节（内部实现还是字节流）
 *   原理：一次操作一个字符
 *   文件字符操作流会自带缓存，默认1024字符数组，在缓存满后或手动刷新或者关闭流时会把数据写入文件
 *   
 *   操作纯文本文件的时候首选字符流 所有数据都可以选择字节流操作
 *   
 *   文件复制原理：一个读一个写  读写目标不同而已
 *   
 *   转换流：可以指定编码 不能单独使用 处理流
 *   	outputStreamWriter 可以将输出的字节流转换为字符流的输出方式
 *   	inputStreamReader 可以将输出的字节流转换成字符流的输入方式
 *   转换流其实都是把字节流转换成字符流让程序来使用 使得操作文本文件高效 但是结点还是字节流在操作
 *   
 *   缓冲流：提高效率 不能单独使用 处理流
 *   	在缓存满后或手动刷新或者关闭流时会把数据写入文件
 *    目的：解决在写入文件操作时频繁的操作文件所带来的性能降低的问题
 *    直接写入缓存的 只有当写满或手动刷新或者关闭流的时候才会真正的写入文件 默认缓存大小为8KB的字节数组
 *    读取也一样 默认缓存大小为8KB   建议以后操作都带上缓存 不要裸奔
 *    
 *   字符流：
 *   	1加入字符缓冲流，增强读取功能（readLine）
 *   	2更高效的读取数据
 *   	fileReader:内部使用inputStreamReader(使用streamDecoder解码过程，byte->char，默认缓存大小8KB)
 *   	bufferedReader:默认大小8KB 但是可以指定大小 把数据直接读取到缓存中，减少每次转换过程，效率更高
 *    
 *   打印流：主要用于输出 分两类 原样输出
 *   	printStream
 *   		在字节输出时可以增强输出功能
 *   	printWriter
 *   		在字节输出时可以增强输出功能
 *   字节数组流  基于内存的操作流 其实就是通过流的方式操作字节数组默认大小32字节 不需要绑定文件 无需关闭流  与文件无关 
 *   ByteArrayInputStream  ByteArrayOutputStream
 *   
 *   数据流：按照顺序读写 一般网络传输的时候使用 完全利用java数据类型读写数据
 *   DataInputStream
 *   	允许程序以与机器无关的方式从底层读取流中的java数据类型 多线程访问不安全 
 *   DataOutputStream
 *   
 *   合并流：表示其他流的逻辑串联
 *   	SequenceInputStream(Enumeration<E> en)
 *   
 *   字符串流：一个字符串的字符流  源头为字符串 类似于字节数组流 以流的方式操作字符串
 *   		StringReader StringWriter
 *   	作用：在web开发中 经常从服务器上获取数据  数据的返回格式通常是一个字符串（xml,json）
 *   			我们需要把这个字符串构造成一个字符流，然后在用三方数据解析器解析
 *   
 *   管道流：
 *   
 *   RandomAccessFile是IO包中的类，直接继承自Object类，只能对文件进行操作，可以对文件读和写操
 *       本类既可以读也可以写
 *   	 内部是一个大型的byte数组 过时了 了解
 *   
 *   压缩和解压缩:有算法的 会用对象就行 使用递归
 *   	ZipOutputStream实现文件压缩
 *   	ZipInputStream实现文件解压缩
 *   
 *@version:
 *@Description: 
 *@author :衡晶
 *@date:2019年9月24日 下午8:57:18
 */
public class IOTest {
	public static void main(String[] args)  {
		//fileTest();
		
		//byteStreamDemo();
		//CharStreamDemo();
//		try {
//			OutputStream os=new FileOutputStream("d:/hj.txt",true);
//			write(os,"开开心心doSomething...");
//		} catch (FileNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		try {
//			InputStream is=new FileInputStream("d:/hj.txt");
//			reader(is);
//		} catch (FileNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		//byteWriter();
		//byteReader();
//		charReader();
		//bytePrint();
//		charPrint();
		
//		byteArrayReaderAndWriter();
		
//		DataWrter();
//		DataReader();
		
//		stringReader();
//		randomAccessFlileTest();
		compression("d:/zip_test.zip",new File("d:/my"));
		
		
	}


	private static void compression(String zipFileName,File targetFile) {
		System.out.println("正在压缩中......");
		try {
			//要生成的压缩文件
			ZipOutputStream out = new ZipOutputStream(new FileOutputStream(zipFileName));
			BufferedOutputStream bos = new BufferedOutputStream(out);
			zip(out,targetFile,targetFile.getName(),bos);
			bos.close();
			out.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("压缩完成");
		
	}

	private static void zip(ZipOutputStream zOut, File targetFile, String name, BufferedOutputStream bos) {
		if(targetFile.isDirectory()){
			File[] listFiles = targetFile.listFiles();
			if(listFiles.length==0){
				try {
					zOut.putNextEntry(new ZipEntry(name+"/"));//处理空目录
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			for(File f: listFiles){
				//递归处理
				zip(zOut,f,name+"/"+f.getName(),bos);
			}
		}else{
			try {
				zOut.putNextEntry(new ZipEntry(name));
				InputStream in = new FileInputStream(targetFile);
				BufferedInputStream bis = new BufferedInputStream(in);
				byte[] bytes=new byte[1024];
				int len = -1;
				while((len=bis.read(bytes))!=-1){
					bos.write(bytes, 0, len);
				}
				bis.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}


	private static void randomAccessFlileTest() {
			try {
				//读取文件
				RandomAccessFile read =new RandomAccessFile(new File("d:/hj.txt"), "r");//r代表读的模式
				//写入文件
				RandomAccessFile write =new RandomAccessFile(new File("d:/hj/hj.txt"), "rw");//rw代表读写的模式
				byte[] bs=new byte[1024];
				int len = -1;
				while((len = read.read(bs))!=-1){
					write.write(bs, 0, len);
				}
				write.close();
				read.close();
				
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("复制完毕");
	}


	private static void stringReader() {
		String info = "good good study day day up";
		StringReader sr= new StringReader(info);
		//流的标记器 处理带标记的流
		StreamTokenizer st=new StreamTokenizer(sr);
		
		int count = 0;
		while(st.ttype != StreamTokenizer.TT_EOF){
			try {
				if(st.nextToken()==StreamTokenizer.TT_WORD){
					count++;
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		sr.close();
		System.out.println("count:"+count);
		
	}


	private static void DataReader() {
		try {
			InputStream is=new FileInputStream("d:/hj1.txt");
			BufferedInputStream bis=new BufferedInputStream(is);
			DataInputStream dis=new DataInputStream(bis);
			int num = dis.readInt();
			byte b =dis.readByte();
			String name=dis.readUTF();
			System.out.println(num +":"+b+":"+name);
			dis.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


	private static void DataWrter() {
		try {
			OutputStream os=new FileOutputStream("d:/hj1.txt",true);
			BufferedOutputStream bos=new BufferedOutputStream(os);
			DataOutputStream dos =new DataOutputStream(bos);
			dos.writeInt(10);//写入4个字节 按照java基本数据类型
			dos.writeByte(10);//写入1个字节
			dos.writeUTF("中");//看utf转后的字节数
			dos.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}


	private static void byteArrayReaderAndWriter() {
		String str="dsa5456dsads21a354#@4c54xz";
		ByteArrayInputStream bais = new ByteArrayInputStream(str.getBytes());
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		int curr=-1;//每次读取的字节
		while((curr=bais.read())!=-1){
			if((curr>=65 && curr<=90) || (curr>=97 && curr<=122)){
				baos.write(curr);
			}
		}
		System.out.println(baos.toString());
	}


	private static void charPrint() {
			try {
				Writer w=new FileWriter("d:/hj.txt",true);
				BufferedWriter bw=new BufferedWriter(w);
				//增强打印功能
				PrintWriter pw=new PrintWriter(bw);
				pw.print("咋的啦 不符啊");
				pw.print(123456);
				char[] chs=new char[12];
				chs[0]=95;
				chs[1]=96;
				pw.print(chs);
				pw.print(true);
				pw.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}


	private static void bytePrint() {
			try {
				OutputStream os=new FileOutputStream("d:/hj.txt",true);
				//加缓存
				BufferedOutputStream bos = new BufferedOutputStream(os);
				//增强打印功能
				PrintStream ps=new PrintStream(bos);
				ps.print("天天哗啦啦");
				ps.close();
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("执行结束");
	}


	private static void charReader() {
			try {
				Reader reader=new FileReader("d:/hj.txt");
				//为字符流提供缓冲，以达到高效读写
				BufferedReader br=new BufferedReader(reader);
				char[] chs=new char[1024];
				int len=-1;
				while((len = br.read(chs))!=-1){
					System.out.println(new String(chs, 0, len));
				}
				br.close();
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}

	private static void byteReader() {
		try(
				BufferedInputStream bis=new BufferedInputStream(new FileInputStream("d:hj.txt"));
			) {
			//挂个缓冲
			byte[] bs=new byte[1024];
			int len=-1;
			while((len = bis.read(bs))!=-1){
				System.out.println(new String(bs, 0, len));
			}			
			//bis.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private static void byteWriter() {
		try {
			OutputStream os=new FileOutputStream("d:/hj.txt",true);
			//构造一个字节缓冲流
			BufferedOutputStream bos=new BufferedOutputStream(os);
			
			String data="小河流水哗啦啦";
			bos.write(data.getBytes());
//			bos.flush();
			bos.close();
			//os.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private static void reader(InputStream is) {
		Reader reader = new InputStreamReader(is,Charset.defaultCharset());
		char[] chs=new char[1024];
		int len =-1;
		try {
			while((len = reader.read(chs))!=-1){
				System.out.println(new String(chs, 0, len));
			}
			reader.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private static void write(OutputStream os,String data) {
			OutputStreamWriter osw=new OutputStreamWriter(os,Charset.forName("GBK"));
			try {
				osw.write(data);
				osw.flush();
				osw.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}

	private static void CharStreamDemo() {
		//字符流操作文件使用其子类filereader/writer
//		try {
//			Writer writer=new FileWriter("d:/hj.txt",true);
//			
//			writer.write("\n\r村花到我家");
//			writer.close();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		try {
			Reader reader=new FileReader("d:/hj.txt");
			char[] chs=new char[1024];
			int len=-1;
			while((len=reader.read(chs))!=-1){
				System.out.println(new String(chs,0,len));
			}
			reader.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	private static void byteStreamDemo() {
		//字节流操作文件使用字节流的子类filein/outputStream
//		try {
//			OutputStream os=new FileOutputStream("d:/hj.txt");
//			os.write("小河流水哗啦啦".getBytes());
//			os.close();
//		} catch (FileNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		InputStream is = null;
		try {
			is = new FileInputStream("d:/hj.txt");
			byte[] bs=new byte[1024];
			int len=-1;//读到的字节长度
			StringBuilder sb=new StringBuilder();
			String line=System.getProperty("line.separator");
			
			while((len=is.read(bs))!=-1){
				sb.append(line).append(new String(bs, 0, len));
			}
			System.out.println(sb.toString());
			is.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private static void fileTest() {
		File file =new File("d:/wangbagaozi/qingshu.txt");
		if(!file.exists()){
			try {
				file.createNewFile();//创建文件
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		System.out.println(file.isDirectory());//是否为文件夹
		
		
		File file2 = new File("d:/my");
		boolean delete = file2.delete();
		System.out.println(delete);//false
		
		String[] list = file2.list();//列出当前文件夹下面的文件名字符串数组
		System.out.println(Arrays.toString(list));
		
		File[] listFiles = file2.listFiles();//列出文件夹下的所有文件对象数组
		for (File f : listFiles) {
			System.out.println("length="+f.length());//文件大小
			System.out.println("hidden="+f.isHidden());//是否是隐藏文件
			System.out.println("name="+f.getName());//文件名
			System.out.println("path="+f.getPath());//相对路径
			System.out.println("AbsPath="+f.getAbsolutePath());//绝对路径
			System.out.println("isRead="+f.canRead());//是否可读
			System.out.println("LastModify="+f.lastModified());//最后被修改的时间
			Date date=new Date(f.lastModified());
			String dateString = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss sss").format(date);
			System.out.println(dateString);
			System.out.println("----------------------------------------");
		}
		File file3=new File("d:/my/呵呵");
		file3.delete();
//		if(!file3.exists()){
//			file3.mkdir();//创建文件夹
//		}
		file3.renameTo(new File("d:/my/嘿嘿/呵呵"));//重命名与移动文件
		new File("d:/my/哈哈").renameTo(new File("d:/my/嘿嘿/呵呵/哈哈"));
		
		/*File[] listFiles2 = file2.listFiles(new FileFilter() {
			@Override
			public boolean accept(File pathname) {
				return pathname.getName().endsWith(".txt");
			}
		});*/
		//lambda方式
		File[] listFiles2 = file2.listFiles((pathname)->pathname.getName().endsWith(".txt"));
		for (File f : listFiles2) {
			System.out.println(f.getName());
		}
	}
}
