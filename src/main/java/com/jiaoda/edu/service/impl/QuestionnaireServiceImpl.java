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
import com.jiaoda.edu.domain.Questionnaire;
import com.jiaoda.edu.domain.QuestionnaireQuestion;
import com.jiaoda.edu.log.LogDesc;
import com.jiaoda.edu.mapper.QuestionChapterMapper;
import com.jiaoda.edu.mapper.QuestionInfoMapper;
import com.jiaoda.edu.mapper.QuestionnaireMapper;
import com.jiaoda.edu.mapper.QuestionnaireQuestionMapper;
import com.jiaoda.edu.service.IQuestionnaireService;
import com.jiaoda.edu.util.ExcelUtils;



@Service
public class QuestionnaireServiceImpl implements IQuestionnaireService {

	@Autowired
	private QuestionnaireMapper selfDAO;
	@Autowired
	private QuestionInfoMapper infoDAO;
	@Autowired
	private QuestionChapterMapper chapterfDAO;
	@Autowired
	private QuestionnaireQuestionMapper qselfDAO;

	@Override
	public Integer insertSelective(Questionnaire record) {
		return selfDAO.insertSelective(record);
	}

	@Override
	public Integer updateByPrimaryKeySelective(Questionnaire record) {
		return selfDAO.updateByPrimaryKeySelective(record);
	}

	@Override
	public Integer deleteByPrimaryKey(Object key) {
		return selfDAO.deleteByPrimaryKey(Integer.parseInt(key.toString()) );
	}

	@Override
	public Questionnaire selectByPrimaryKey(Object key) {
		return selfDAO.selectByPrimaryKey(Integer.parseInt(key.toString()) );
	}

	@Override
	public List<Questionnaire> findWhereList(String where, String order) {
		return selfDAO.findWhereList(where, order);
	}

	@Override
	public Integer getCount(String where) {
		return selfDAO.getCount(where);
	}

	@Override
	public List<Questionnaire> findPagerList(Integer start, Integer length, String where,
			String order) {
		return selfDAO.findPagerList(start, length, where, order);
	}

	
	@Override
	public Questionnaire findWhere(String where, String order) {
		List<Questionnaire> list = selfDAO.findWhereList(where, order);
		return list.size() > 0 ? list.get(0) : null;
	}

	@Override
	public Questionnaire selectDetailByWhere(String where) {
		return selfDAO.selectDetailByWhere(where );
	}
	@Override
	@LogDesc(desc="Excel导入用户信息")
    public  Integer importExcel(MultipartFile myFile,Integer id) throws Exception {
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
        List<QuestionChapter> chapters =  chapterfDAO.findPagerList(0, 999, " delete_flag=0 ", "");
        Integer sheetnum=workbook.getNumberOfSheets();
        for(Integer jj=0;jj<sheetnum;jj++) {
    	   
   
        Sheet sheet = workbook.getSheetAt(jj);
        String chapterName=workbook.getSheetName(jj);
        if(sheet==null) {
        	return id;
        }
        int rows = sheet.getLastRowNum();// 指的行数，一共有多少行+
        if(rows==0){
            throw new Exception("请填写数据");
        }
       
        Date now=new Date();
        List<QuestionInfo> quests=new ArrayList();
        List<QuestionnaireQuestion> qquests=new ArrayList();
        String  title=fileName.substring(0,fileName.indexOf("."));
        for (int i = 0; i <= rows; i++) {
            // 读取左上端单元格
            Row row = sheet.getRow(i);
        
            // 行不为空
            if (row != null) {
                // **读取cell**
              
            	QuestionInfo quest = new QuestionInfo();
              
                String question = ExcelUtils.getCellValue(row.getCell(0));
                String optionA = ExcelUtils.getCellValue(row.getCell(1));
                String optionB = ExcelUtils.getCellValue(row.getCell(2));
                String optionC= ExcelUtils.getCellValue(row.getCell(3));
                String optionD = ExcelUtils.getCellValue(row.getCell(4));
                String answer = ExcelUtils.getCellValue(row.getCell(5));
                String score = ExcelUtils.getCellValue(row.getCell(6));
               
                //循环给章节赋值
                if(chapterName!=null&&!chapterName.equals("")) {
            	  for (int j = 0; j < chapters.size(); j++) {
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
                if(score!=null&&!score.equals("")) {
                	 quest.setScore(Integer.parseInt(score));
                }
               
                //选项数
               if(optionD!=null&&!optionD.equals("")) {
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
        
        if(id==null) {
        	Questionnaire naire =new Questionnaire();
        	naire.setName(title);
        	naire.setCreateTime(now);
        	naire.setUpdateTime(now);
        	naire.setDeleteFlag(0);
        	selfDAO.insertSelective(naire);
        	id=naire.getId();
        }
          infoDAO.batchinsert(quests);
	      for (int i = 0; i < quests.size(); i++) {
	      	QuestionnaireQuestion qq=new QuestionnaireQuestion();
	      	qq.setQuestionId(quests.get(i).getQuestionId());
	        qq.setNaireId(id);
			qq.setScore(quests.get(i).getScore());
			qquests.add(qq);
	      }
	      qselfDAO.batchinsert(qquests);
       }
        return id;
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
