package com.jiaoda.edu.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.jiaoda.edu.domain.QuestionChapter;
import com.jiaoda.edu.domain.QuestionInfo;
import com.jiaoda.edu.domain.UserInfo;
import com.jiaoda.edu.log.LogDesc;
import com.jiaoda.edu.mapper.QuestionChapterMapper;
import com.jiaoda.edu.mapper.QuestionInfoMapper;
import com.jiaoda.edu.service.IQuestionInfoService;
import com.jiaoda.edu.util.ExcelUtils;
import com.jiaoda.edu.util.PasswordEncoder;



@Service
public class QuestionInfoServiceImpl implements IQuestionInfoService {

	@Autowired
	private QuestionInfoMapper selfDAO;
	@Autowired
	private QuestionChapterMapper chapterfDAO;

	@Override
	public Integer insertSelective(QuestionInfo record) {
		return selfDAO.insertSelective(record);
	}

	@Override
	public Integer updateByPrimaryKeySelective(QuestionInfo record) {
		return selfDAO.updateByPrimaryKeySelective(record);
	}

	@Override
	public Integer deleteByPrimaryKey(Object key) {
		return selfDAO.deleteByPrimaryKey(Integer.parseInt(key.toString()) );
	}

	@Override
	public QuestionInfo selectByPrimaryKey(Object key) {
		return selfDAO.selectByPrimaryKey(Integer.parseInt(key.toString()) );
	}

	@Override
	public List<QuestionInfo> findWhereList(String where, String order) {
		return selfDAO.findWhereList(where, order);
	}

	@Override
	public Integer getCount(String where) {
		return selfDAO.getCount(where);
	}

	@Override
	public List<QuestionInfo> findPagerList(Integer start, Integer length, String where,
			String order) {
		return selfDAO.findPagerList(start, length, where, order);
	}

	
	@Override
	public QuestionInfo findWhere(String where, String order) {
		List<QuestionInfo> list = selfDAO.findWhereList(where, order);
		return list.size() > 0 ? list.get(0) : null;
	}

	@Override
	@LogDesc(desc="Excel导入用户信息")
    public  Integer importExcel(MultipartFile myFile) throws Exception {
        //
        //        2、用HSSFWorkbook对象返回或者创建Sheet对象
        //
        //        3、用Sheet对象返回行对象，用行对象得到Cell对象
        //
        //        4、对Cell对象读写。
        //获得文件名  
    	
        Workbook workbook = null ;
        String fileName = myFile.getOriginalFilename(); 
        if(fileName.endsWith(ExcelUtils.XLS)){  
            //2003  
            workbook = new HSSFWorkbook(myFile.getInputStream());  
        }else if(fileName.endsWith(ExcelUtils.XLSX)){  
            //2007  
            workbook = new XSSFWorkbook(myFile.getInputStream());  
        }else{
            throw new Exception("文件不是Excel文件");
        }
 
        Sheet sheet = workbook.getSheet("Sheet1");
        int rows = sheet.getLastRowNum();// 指的行数，一共有多少行+
        if(rows==0){
            throw new Exception("请填写数据");
        }
        List<QuestionChapter> chapters =  chapterfDAO.findPagerList(0, 999, " delete_flag=0 ", "");
        Date now=new Date();
        List<QuestionInfo> quests=new ArrayList();
        for (int i = 1; i <= rows+1; i++) {
            // 读取左上端单元格
            Row row = sheet.getRow(i);
            // 行不为空
            if (row != null) {
                // **读取cell**
            	QuestionInfo quest = new QuestionInfo();
                String  chapterName= ExcelUtils.getCellValue(row.getCell(0));
                String question = ExcelUtils.getCellValue(row.getCell(1));
                String optionA = ExcelUtils.getCellValue(row.getCell(2));
                String optionB = ExcelUtils.getCellValue(row.getCell(3));
                String optionC= ExcelUtils.getCellValue(row.getCell(4));
                String optionD = ExcelUtils.getCellValue(row.getCell(5));
                String optionE = ExcelUtils.getCellValue(row.getCell(6));
                String answer = ExcelUtils.getCellValue(row.getCell(7));
               
                //循环给章节赋值
                if(chapterName!=null&&!chapterName.equals("")) {
            	  for (int j = 0; j <= chapters.size(); j++) {
            		if(chapters.get(j).getChapterName().equals(chapterName.trim())) {
            			quest.setChapterId(chapters.get(j).getChapterId());
            		    break;
            		}
            	  }
                }
                 //如果章节不存在就添加
                if(quest.getChapterId()==null) {
                	QuestionChapter qc=new QuestionChapter();
                	qc.setChapterName(chapterName);
                	qc.setUpdateTime(now);
                	chapterfDAO.insertSelective(qc);
                	chapters.add(qc);
                	quest.setChapterId(qc.getChapterId());
                }
                quest.setQuestion(question);
                quest.setOptionA(optionA);
                quest.setOptionB(optionB);
                quest.setOptionC(optionC);
                quest.setOptionD(optionD);
                quest.setOptionE(optionE);
                //选项数
                if(optionE!=null&&!optionE.equals("")) {
                	quest.setOptionNum(5);
                }else  if(optionD!=null&&!optionD.equals("")) {
                	quest.setOptionNum(4);
                }else  if(optionC!=null&&!optionC.equals("")) {
                	quest.setOptionNum(3);
                }else {
                	quest.setOptionNum(2);
                }
                quest.setAnswer(getanswer(answer));
                quest.setQuestionType(0);
                quests.add(quest);
             
            }
        }
        selfDAO.batchinsert(quests);
        return rows-1;
    }
	
	public String  getanswer(String  answer) {
		String resultstr="1";
		switch(answer){
		    case "E" :
		       resultstr="5";
		       break; //可选
		    case "D" :
		       resultstr="4";
		       break; //可选
		    case "C" :
		       resultstr="3";
		       break; //可选
		    case "B" :
	    	  resultstr="2";
	          break; //可选
		    
		    default : //可选
		       //语句
		}
		return resultstr;
	}
	


}
