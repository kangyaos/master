package com.jiaoda.edu.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;

import org.apache.poi.hwpf.HWPFDocument;
import org.apache.poi.hwpf.usermodel.Range;
import org.apache.poi.poifs.filesystem.OfficeXmlFileException;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;

public class WordUtils {
	public static ImportWordResult impw(InputStream stram){
        ImportWordResult result = new ImportWordResult();
        
        //这边是03版本的word进行导入解析操作；
        HWPFDocument doc = null;
        try {
            doc = new HWPFDocument(stram);//这边报错
          
            
            result.setContent(doc.getDocumentText().replace("/n","<br/>"));//返回解析内容
        }catch (OfficeXmlFileException ofe){
            ofe.printStackTrace();
            result.setMsg("这可能是个07版本的word");
        }catch(Exception io){
            io.printStackTrace();
            result.setMsg("word文档解析失败,格式不符合");
            return result;
        }finally {
            if(doc != null){
//                try {
//                    //doc.close();
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
            }
        }
//        //07版的word解析操作；
//        XWPFDocument docx = null;
//        try {
//            docx = new XWPFDocument(stram);
//            //07版本传的和03版本不同，它是一个一个获取然后拼接；
//            //这边是一行一行获取的，不是直接全部获取，所以每一行加个回车
//            List<XWPFParagraph> paragraphs = docx.getParagraphs();
//            StringBuffer content = new StringBuffer();
//            for(int i = 0; i < paragraphs.size(); i++){
//                if(i != 0){
//                    content.append("<br/>");
//                }
//                content.append(paragraphs.get(i).getText());//获取文本拼接
//            }
//            result.setContent(content.toString());
//        } catch (IOException e) {
//            e.printStackTrace();
//        }finally {
//            if(docx != null){
//                try {
//                    docx.close();
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//            }
//        }

        return  result;
    }

    /**
     * 进行导出功能的编写,对03版的导出
     */
    public HWPFDocument export03(Map<String,String> replaceContent){
        //这边是03版本的word进行导入解析操作；
        HWPFDocument doc = null;
        try {
            doc = new HWPFDocument(new FileInputStream("K:\\JavawebExportDown\\web\\template\\template_03.doc"));
            Range range = doc.getRange();//随机字符串用来做替换
            //Map<String,String> 用来做替换内容，key和value
            for(Map.Entry<String,String> entry : replaceContent.entrySet()){
                //遍历替换内容
                range.replaceText(entry.getKey(),entry.getValue());
            }
        }catch(Exception io){
            return null;
        }
        return doc;
    }

    public XWPFDocument export07(Map<String,String> replaceContent){
        XWPFDocument docx = null;
        try{
            docx = new XWPFDocument(new FileInputStream("K:\\JavawebExportDown\\web\\template\\template_07.docx"));
            List<XWPFParagraph> paragraphs = docx.getParagraphs();
            for(XWPFParagraph paragraph:paragraphs){
                List<XWPFRun> runs = paragraph.getRuns();//run是一小段格式相同是一小段不同则不是；
                for(XWPFRun run:runs){
                    String str = run.getText(run.getTextPosition());
                    for(Map.Entry<String,String> entry: replaceContent.entrySet()){
                        str = str.replace(entry.getKey(),entry.getValue());
                    }
                    run.setText(str,0);
                }
            }

        }catch (Exception ex){
            return null;
        }
        return docx;
    }
}
