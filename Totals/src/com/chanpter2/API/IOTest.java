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
 *   IO����һ����˳��� �������յ���ֽڼ��� �����ݴ���ĳ����ܳ�
 *   �ֽ��������� inputStream outputStream
 *   ��������ֽ�������ԭ��  ÿ�λ����һ���ֽڣ������ļ��ж�ȡ��д�룩
 *   �ֽڲ�������Ĭ��ÿ��ֱ�Ӱ�����д���ļ� ��������
 *   ʹ���ֽ�����ȡ�ı��ļ������������ ԭ��������ռ�����ֽ� ��ȡһ��ͽ��б����� ���Զ��ı��ļ������ַ���
 *   
 *   �ַ���������Writer reader �����ֽڣ��ڲ�ʵ�ֻ����ֽ�����
 *   ԭ��һ�β���һ���ַ�
 *   �ļ��ַ����������Դ����棬Ĭ��1024�ַ����飬�ڻ���������ֶ�ˢ�»��߹ر���ʱ�������д���ļ�
 *   
 *   �������ı��ļ���ʱ����ѡ�ַ��� �������ݶ�����ѡ���ֽ�������
 *   
 *   �ļ�����ԭ��һ����һ��д  ��дĿ�겻ͬ����
 *   
 *   ת����������ָ������ ���ܵ���ʹ�� ������
 *   	outputStreamWriter ���Խ�������ֽ���ת��Ϊ�ַ����������ʽ
 *   	inputStreamReader ���Խ�������ֽ���ת�����ַ��������뷽ʽ
 *   ת������ʵ���ǰ��ֽ���ת�����ַ����ó�����ʹ�� ʹ�ò����ı��ļ���Ч ���ǽ�㻹���ֽ����ڲ���
 *   
 *   �����������Ч�� ���ܵ���ʹ�� ������
 *   	�ڻ���������ֶ�ˢ�»��߹ر���ʱ�������д���ļ�
 *    Ŀ�ģ������д���ļ�����ʱƵ���Ĳ����ļ������������ܽ��͵�����
 *    ֱ��д�뻺��� ֻ�е�д�����ֶ�ˢ�»��߹ر�����ʱ��Ż�������д���ļ� Ĭ�ϻ����СΪ8KB���ֽ�����
 *    ��ȡҲһ�� Ĭ�ϻ����СΪ8KB   �����Ժ���������ϻ��� ��Ҫ�㱼
 *    
 *   �ַ�����
 *   	1�����ַ�����������ǿ��ȡ���ܣ�readLine��
 *   	2����Ч�Ķ�ȡ����
 *   	fileReader:�ڲ�ʹ��inputStreamReader(ʹ��streamDecoder������̣�byte->char��Ĭ�ϻ����С8KB)
 *   	bufferedReader:Ĭ�ϴ�С8KB ���ǿ���ָ����С ������ֱ�Ӷ�ȡ�������У�����ÿ��ת�����̣�Ч�ʸ���
 *    
 *   ��ӡ������Ҫ������� ������ ԭ�����
 *   	printStream
 *   		���ֽ����ʱ������ǿ�������
 *   	printWriter
 *   		���ֽ����ʱ������ǿ�������
 *   �ֽ�������  �����ڴ�Ĳ����� ��ʵ����ͨ�����ķ�ʽ�����ֽ�����Ĭ�ϴ�С32�ֽ� ����Ҫ���ļ� ����ر���  ���ļ��޹� 
 *   ByteArrayInputStream  ByteArrayOutputStream
 *   
 *   ������������˳���д һ�����紫���ʱ��ʹ�� ��ȫ����java�������Ͷ�д����
 *   DataInputStream
 *   	���������������޹صķ�ʽ�ӵײ��ȡ���е�java�������� ���̷߳��ʲ���ȫ 
 *   DataOutputStream
 *   
 *   �ϲ�������ʾ���������߼�����
 *   	SequenceInputStream(Enumeration<E> en)
 *   
 *   �ַ�������һ���ַ������ַ���  ԴͷΪ�ַ��� �������ֽ������� �����ķ�ʽ�����ַ���
 *   		StringReader StringWriter
 *   	���ã���web������ �����ӷ������ϻ�ȡ����  ���ݵķ��ظ�ʽͨ����һ���ַ�����xml,json��
 *   			������Ҫ������ַ��������һ���ַ�����Ȼ�������������ݽ���������
 *   
 *   �ܵ�����
 *   
 *   RandomAccessFile��IO���е��ֱ࣬�Ӽ̳���Object�ֻ࣬�ܶ��ļ����в��������Զ��ļ�����д��
 *       ����ȿ��Զ�Ҳ����д
 *   	 �ڲ���һ�����͵�byte���� ��ʱ�� �˽�
 *   
 *   ѹ���ͽ�ѹ��:���㷨�� ���ö������ ʹ�õݹ�
 *   	ZipOutputStreamʵ���ļ�ѹ��
 *   	ZipInputStreamʵ���ļ���ѹ��
 *   
 *@version:
 *@Description: 
 *@author :�⾧
 *@date:2019��9��24�� ����8:57:18
 */
public class IOTest {
	public static void main(String[] args)  {
		//fileTest();
		
		//byteStreamDemo();
		//CharStreamDemo();
//		try {
//			OutputStream os=new FileOutputStream("d:/hj.txt",true);
//			write(os,"��������doSomething...");
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
		System.out.println("����ѹ����......");
		try {
			//Ҫ���ɵ�ѹ���ļ�
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
		System.out.println("ѹ�����");
		
	}

	private static void zip(ZipOutputStream zOut, File targetFile, String name, BufferedOutputStream bos) {
		if(targetFile.isDirectory()){
			File[] listFiles = targetFile.listFiles();
			if(listFiles.length==0){
				try {
					zOut.putNextEntry(new ZipEntry(name+"/"));//�����Ŀ¼
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			for(File f: listFiles){
				//�ݹ鴦��
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
				//��ȡ�ļ�
				RandomAccessFile read =new RandomAccessFile(new File("d:/hj.txt"), "r");//r�������ģʽ
				//д���ļ�
				RandomAccessFile write =new RandomAccessFile(new File("d:/hj/hj.txt"), "rw");//rw�����д��ģʽ
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
			System.out.println("�������");
	}


	private static void stringReader() {
		String info = "good good study day day up";
		StringReader sr= new StringReader(info);
		//���ı���� �������ǵ���
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
			dos.writeInt(10);//д��4���ֽ� ����java������������
			dos.writeByte(10);//д��1���ֽ�
			dos.writeUTF("��");//��utfת����ֽ���
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
		int curr=-1;//ÿ�ζ�ȡ���ֽ�
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
				//��ǿ��ӡ����
				PrintWriter pw=new PrintWriter(bw);
				pw.print("զ���� ������");
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
				//�ӻ���
				BufferedOutputStream bos = new BufferedOutputStream(os);
				//��ǿ��ӡ����
				PrintStream ps=new PrintStream(bos);
				ps.print("���컩����");
				ps.close();
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("ִ�н���");
	}


	private static void charReader() {
			try {
				Reader reader=new FileReader("d:/hj.txt");
				//Ϊ�ַ����ṩ���壬�Դﵽ��Ч��д
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
			//�Ҹ�����
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
			//����һ���ֽڻ�����
			BufferedOutputStream bos=new BufferedOutputStream(os);
			
			String data="С����ˮ������";
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
		//�ַ��������ļ�ʹ��������filereader/writer
//		try {
//			Writer writer=new FileWriter("d:/hj.txt",true);
//			
//			writer.write("\n\r�廨���Ҽ�");
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
		//�ֽ��������ļ�ʹ���ֽ���������filein/outputStream
//		try {
//			OutputStream os=new FileOutputStream("d:/hj.txt");
//			os.write("С����ˮ������".getBytes());
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
			int len=-1;//�������ֽڳ���
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
				file.createNewFile();//�����ļ�
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		System.out.println(file.isDirectory());//�Ƿ�Ϊ�ļ���
		
		
		File file2 = new File("d:/my");
		boolean delete = file2.delete();
		System.out.println(delete);//false
		
		String[] list = file2.list();//�г���ǰ�ļ���������ļ����ַ�������
		System.out.println(Arrays.toString(list));
		
		File[] listFiles = file2.listFiles();//�г��ļ����µ������ļ���������
		for (File f : listFiles) {
			System.out.println("length="+f.length());//�ļ���С
			System.out.println("hidden="+f.isHidden());//�Ƿ��������ļ�
			System.out.println("name="+f.getName());//�ļ���
			System.out.println("path="+f.getPath());//���·��
			System.out.println("AbsPath="+f.getAbsolutePath());//����·��
			System.out.println("isRead="+f.canRead());//�Ƿ�ɶ�
			System.out.println("LastModify="+f.lastModified());//����޸ĵ�ʱ��
			Date date=new Date(f.lastModified());
			String dateString = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss sss").format(date);
			System.out.println(dateString);
			System.out.println("----------------------------------------");
		}
		File file3=new File("d:/my/�Ǻ�");
		file3.delete();
//		if(!file3.exists()){
//			file3.mkdir();//�����ļ���
//		}
		file3.renameTo(new File("d:/my/�ٺ�/�Ǻ�"));//���������ƶ��ļ�
		new File("d:/my/����").renameTo(new File("d:/my/�ٺ�/�Ǻ�/����"));
		
		/*File[] listFiles2 = file2.listFiles(new FileFilter() {
			@Override
			public boolean accept(File pathname) {
				return pathname.getName().endsWith(".txt");
			}
		});*/
		//lambda��ʽ
		File[] listFiles2 = file2.listFiles((pathname)->pathname.getName().endsWith(".txt"));
		for (File f : listFiles2) {
			System.out.println(f.getName());
		}
	}
}
