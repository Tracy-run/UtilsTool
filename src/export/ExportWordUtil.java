package export;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.io.Writer;
import java.net.URLEncoder;
import java.util.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;

import freemarker.template.Configuration;
import freemarker.template.Template;

//import com.shara.common.initialize.*;

public class ExportWordUtil {
	
	/**
	 * 存入本地后返回下载路径
	 * @param dataMap 数据
	 * @param templateName 模板名称
	 * @param filePath 保存文件路劲
	 * @param fileName 保存文件名
	 */
	public static String createWord(HttpServletRequest request1 ,Map<?, ?> dataMap) {
		try {
			String filePath = null;
			String templateName = "exportWordTemp.ftl";
			
			String fileName = "test"+System.currentTimeMillis()+".doc";
			Configuration configuration = new Configuration();
			configuration.setDefaultEncoding("UTF-8");
			// ftl模板文件统一放至 test.ftl包下面
			configuration.setClassForTemplateLoading(ExportWordUtil.class, "/com/web/common/util/export/");

			// 获取模板
			Template template = configuration.getTemplate(templateName);
			
			String str =null;
//					com.shara.common.initialize.Configuration.getReourcesV("upload");
			filePath = str + "/export/";
			
			File outFile = new File(filePath + File.separator + fileName);
			if (!outFile.getParentFile().exists()) {
				outFile.getParentFile().mkdirs();
			}

			// 将模板和数据模型合并生成文件
			Writer out = new BufferedWriter(new OutputStreamWriter(
					new FileOutputStream(outFile), "UTF-8"));
			// 生成文件
			template.process(dataMap, out);

			out.flush();
			out.close();
			return filePath + fileName;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * 下载word
	 * @param request
	 * @param response
	 * @param newWordName
	 * @param dataMap
	 */
	public static void  exportWord(HttpServletRequest request,HttpServletResponse response,String url) throws Exception {
			String path = url;
			String filename = url.substring(url.lastIndexOf("\\")+1);
	        try{
	        	response.reset();// 清空输出流
	            
	            response.setCharacterEncoding("UTF-8");  
	            response.setHeader("Content-disposition", "attachment; filename=" + filename);// 设定输出文件头
	            response.setContentType("application/msexcel");// 定义输出类型
	            //输入流：本地文件路径
	            DataInputStream in = new DataInputStream(new FileInputStream(new File(path)));  
	            //输出流
	            OutputStream out = response.getOutputStream();
	            //输出文件
	            int bytes = 0;
	            byte[] bufferOut = new byte[1024];  
	            while ((bytes = in.read(bufferOut)) != -1) {  
	                out.write(bufferOut, 0, bytes);  
	            }
	            out.close();
	            in.close();
	            
	        } catch(Exception e){ 
	            e.printStackTrace();
	       }
	} 
	
	public static String download(HttpServletResponse response,String fileName) throws FileNotFoundException{
	        try {
	            fileName = new String(fileName.getBytes("GBK"), "ISO-8859-1");
	        } catch (UnsupportedEncodingException e) {
	            e.printStackTrace();
	        }
	        ///home/tomcat/apache-tomcat-9.0.1/files
	        String url  = null;
//	        		com.shara.common.initialize.Configuration.getReourcesV("upload") + "/export";
	        String path = url + fileName;
	        File file = new File(path);
	        response.reset();
	        response.setContentType("application/octet-stream");
	        response.setCharacterEncoding("utf-8");
	        response.setContentLength((int) file.length());
	        response.setHeader("Content-Disposition", "attachment;filename=" + fileName);
	        byte[] buff = new byte[1024];
	        BufferedInputStream bis = null;
	        OutputStream os = null;
	        try {
	            os = response.getOutputStream();
	            bis = new BufferedInputStream(new FileInputStream(file));
	            int i = 0;
	            while ((i = bis.read(buff)) != -1) {
	                os.write(buff, 0, i);
	                os.flush();
	            }
	        } catch (IOException e) {
	            e.printStackTrace();
	        } finally {
	            try {
	                bis.close();
	                return path;
	            } catch (IOException e) {
	                e.printStackTrace();
	            }
	        }
	        return null;
	}
	
	
	/**
	 * 测试数据
	 * @return
	 * @throws Exception
	 */
	public static Map<String, Object> getData() throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
		List<Map<String,Object>> tablt1 = new ArrayList<Map<String,Object>>();
		Map<String,Object> target = new HashMap<>();
		
//		个人指标循环1
		target.put("projectName", "projectName111");
		target.put("lastWeekAdd", "lastWeekAdd222");
		target.put("lastWeekDone", "lastWeekDone333");
		target.put("proceed", "proceed4444");
		target.put("done", "done555");
		target.put("total", "total666");
		target.put("exceedTime", "exceedTime777");
		target.put("userName", "userName888");
		
		Map<String,Object> sonmap = new HashMap<>();
		sonmap.put("content", "content11");
		sonmap.put("deadline", "deadline222");
		sonmap.put("status", "status333");
		
		Map<String,Object> sonmap1 = new HashMap<>();
		sonmap1.put("content", "content11");
		sonmap1.put("deadline", "deadline222");
		sonmap1.put("status", "status333");
		
		List<Object> sonlist = new ArrayList<>();
		sonlist.add(sonmap);
		sonlist.add(sonmap1);
		target.put("sonlist", sonlist);
		tablt1.add(target);
////		循环2
		Map<String,Object> target1 = new HashMap<>();
		target1.put("projectName", "projectName111");
		target1.put("lastWeekAdd", "lastWeekAdd222");
		target1.put("lastWeekDone", "lastWeekDone333");
		target1.put("proceed", "proceed4444");
		target1.put("done", "done555");
		target1.put("total", "total666");
		target1.put("exceedTime", "exceedTime777");
		target1.put("userName", "userName888");
		
		Map<String,Object> sonmap12 = new HashMap<>();
		sonmap12.put("content", "content11");
		sonmap12.put("deadline", "deadline222");
		sonmap12.put("status", "status333");
		List<Object> sonlist1 = new ArrayList<>();
		sonlist1.add(sonmap12);
		
		target1.put("sonlist", sonlist1);
		tablt1.add(target1);
		map.put("targetMonitor", tablt1);//<#list table1 as object></#list>
		
//		基础base
		List<Map<String,Object>> tablt2 = new ArrayList<Map<String,Object>>();
		Map<String,Object> target2 = new HashMap<>();
		target2.put("userName", "lastWeekBase");
		target2.put("taskType", "lastWeekBase");
		target2.put("taskStatus", "lastWeekBase");
		target2.put("taskDes", "lastWeekBase");
		target2.put("content", "lastWeekBase");
		target2.put("isTrace", "lastWeekBase");
		Map<String,Object> target22 = new HashMap<>();
		target22.put("userName", "lastWeekBase");
		target22.put("taskType", "lastWeekBase");
		target22.put("taskStatus", "lastWeekBase");
		target22.put("taskDes", "lastWeekBase");
		target22.put("content", "lastWeekBase");
		target22.put("isTrace", "lastWeekBase");
		tablt2.add(target2);
		tablt2.add(target22);
		map.put("lastWeekBase", tablt2);
		
		
//		本周新增任务	
		List<Map<String,Object>> tablt3 = new ArrayList<Map<String,Object>>();
		Map<String,Object> target3 = new HashMap<>();
		target3.put("userName", "weekTask");
		target3.put("taskDec", "weekTask");
		target3.put("targetResource", "weekTask");
		target3.put("principal", "weekTask");
		target3.put("doneDate", "weekTask");
		target3.put("taskValue", "weekTask");
		target3.put("taskType", "weekTask");
		target3.put("status", "weekTask");
		Map<String,Object> target31 = new HashMap<>();
		target31.put("userName", "weekTask");
		target31.put("taskDec", "weekTask");
		target31.put("targetResource", "weekTask");
		target31.put("principal", "weekTask");
		target31.put("doneDate", "weekTask");
		target31.put("taskValue", "weekTask");
		target31.put("taskType", "weekTask");
		target31.put("status", "weekTask");
		tablt3.add(target3);
		tablt3.add(target31);
		map.put("weekTask", tablt3);
		
		
//		缺陷		
		List<Map<String,Object>> tablt4 = new ArrayList<Map<String,Object>>();
		Map<String,Object> target4 = new HashMap<>();
		target4.put("userName", "weekTask");
		target4.put("discoverDate", "weekTask");
		target4.put("parameter", "weekTask");
		target4.put("discoverType", "weekTask");
		target4.put("abnormalEvaluate", "weekTask");
		target4.put("abnormalExpression", "weekTask");
		target4.put("isTrace", "weekTask");
		target4.put("engineer", "weekTask");
		target4.put("status", "weekTask");
		
		Map<String,Object> target41 = new HashMap<>();
		target41.put("userName", "weekTask");
		target41.put("discoverDate", "weekTask");
		target41.put("parameter", "weekTask");
		target41.put("discoverType", "weekTask");
		target41.put("abnormalEvaluate", "weekTask");
		target41.put("abnormalExpression", "weekTask");
		target41.put("isTrace", "weekTask");
		target41.put("engineer", "weekTask");
		target41.put("status", "weekTask");
		tablt4.add(target4);
		tablt4.add(target41);
		map.put("flawStatus", tablt4);
		
// 个人负责问题		
		List<Map<String,Object>> tablt5 = new ArrayList<Map<String,Object>>();
		Map<String,Object> target5 = new HashMap<>();
		target5.put("technologyType", "technologyLlist");
		target5.put("parameter", "technologyLlist");
		target5.put("problemDes", "technologyLlist");
		List<Object> list5 = new ArrayList<>();
		Map<String,Object> map51 = new HashMap<>();
		map51.put("plan1", "plan1");
		map51.put("plan2", "plan2");
		map51.put("plan3", "plan3");
		list5.add(map51);
		target5.put("plans", list5);
		target5.put("dutyPerson", "technologyLlist");
		target5.put("deadline", "technologyLlist");
		target5.put("status", "technologyLlist");
		tablt5.add(target5);
		
		Map<String,Object> target51 = new HashMap<>();
		target51.put("technologyType", "technologyLlist");
		target51.put("parameter", "technologyLlist");
		target51.put("problemDes", "technologyLlist");
		List<Object> list51 = new ArrayList<>();
		Map<String,Object> map52 = new HashMap<>();
		map52.put("plan1", "plan1");
		map52.put("plan2", "plan2");
		map52.put("plan3", "plan3");
		list51.add(map52);
		target51.put("plans", list51);
		target51.put("dutyPerson", "technologyLlist");
		target51.put("deadline", "technologyLlist");
		target51.put("status", "technologyLlist");
		tablt5.add(target51);
		map.put("technologyLlist", tablt5);
		

// 基础问题		
		List<Map<String,Object>> tablt6 = new ArrayList<Map<String,Object>>();
		Map<String,Object> target6 = new HashMap<>();
		target6.put("recentlyType", "recentlyProblem");
		target6.put("problemDes", "recentlyProblem");
		target6.put("dutyPerson", "recentlyProblem");
		target6.put("deadline", "recentlyProblem");
		target6.put("status", "recentlyProblem");
		List<Object> list6 = new ArrayList<>();
		Map<String,Object> map61 = new HashMap<>();
		map61.put("plan1", "plan1");
		map61.put("plan2", "plan2");
		map61.put("plan3", "plan3");
		list6.add(map61);
		target6.put("plans", list6);
		tablt6.add(target6);
		
		Map<String,Object> target61 = new HashMap<>();
		target61.put("recentlyType", "recentlyProblem");
		target61.put("problemDes", "recentlyProblem");
		target61.put("dutyPerson", "recentlyProblem");
		target61.put("deadline", "recentlyProblem");
		target61.put("status", "recentlyProblem");
		List<Object> list61 = new ArrayList<>();
		Map<String,Object> map62 = new HashMap<>();
		map62.put("plan1", "plan1");
		map62.put("plan2", "plan2");
		map62.put("plan3", "plan3");
		list61.add(map62);
		target61.put("plans", list61);
		tablt6.add(target61);
		
		map.put("recentlyProblem", tablt6);
		
//	 下周考情情况	
		List<Map<String,Object>> tablt7 = new ArrayList<Map<String,Object>>();
		Map<String,Object> target7 = new HashMap<>();
		Map<String,Object> target71 = new HashMap<>();
		target7.put("userName", "nextWeekCheck");
		target7.put("person", "nextWeekCheck");
		target7.put("checkType", "nextWeekCheck");
		target7.put("timeQuantum", "nextWeekCheck");
		target7.put("checkTime", "nextWeekCheck");

		target71.put("userName", "nextWeekCheck");
		target71.put("person", "nextWeekCheck");
		target71.put("checkType", "nextWeekCheck");
		target71.put("timeQuantum", "nextWeekCheck");
		target71.put("checkTime", "nextWeekCheck");
		
		tablt7.add(target7);
		tablt7.add(target71);
		map.put("nextWeekCheck", tablt7);
		
//	个人获奖统计	
		List<Map<String,Object>> tablt8 = new ArrayList<Map<String,Object>>();
		Map<String,Object> target8 = new HashMap<>();
		Map<String,Object> target81 = new HashMap<>();
		target8.put("userName", "plamPerson");
		target8.put("plamTime", "plamPerson");
		target8.put("plamLevel", "plamPerson");
		target8.put("plamAwards", "plamPerson");
		target8.put("plamName", "plamPerson");
		target8.put("orderPerson", "plamPerson");
		target8.put("dept", "plamPerson");
		
		target81.put("userName", "plamPerson");
		target81.put("plamTime", "plamPerson");
		target81.put("plamLevel", "plamPerson");
		target81.put("plamAwards", "plamPerson");
		target81.put("plamName", "plamPerson");
		target81.put("orderPerson", "plamPerson");
		target81.put("dept", "plamPerson");
		
		tablt8.add(target8);
		tablt8.add(target81);
		map.put("plamPerson", tablt8);
		
		//其他数据
		return map;
	}
	
	
	public static void main(String[] args) throws Exception {
		System.out.println(getData());
		createWordtest(getData());
		
//		download(null, null, "test"+System.currentTimeMillis()+".doc", getData());
		
	}
	
	
	public static void createWordtest(Map<?, ?> dataMap) {
		try {
			String filePath =  "E:/test/";
			
			String templateName = "exportWordlist.ftl";
			
			String fileName = "test"+System.currentTimeMillis()+".doc";
			Configuration configuration = new Configuration();
			configuration.setDefaultEncoding("UTF-8");
			// ftl模板文件统一放至 test.ftl包下面
			configuration.setClassForTemplateLoading(ExportWordUtil.class, "/com/web/common/util/export/");

			// 获取模板
			Template template = configuration.getTemplate(templateName);

			File outFile = new File(filePath + File.separator + fileName);
			if (!outFile.getParentFile().exists()) {
				outFile.getParentFile().mkdirs();
			}

			// 将模板和数据模型合并生成文件
			Writer out = new BufferedWriter(new OutputStreamWriter(
					new FileOutputStream(outFile), "UTF-8"));
			// 生成文件
			template.process(dataMap, out);

			out.flush();
			out.close();
			//打开导出的文件
			//Desktop desktop = Desktop.getDesktop();
	        //desktop.open(new File(filePath + File.separator + fileName));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

