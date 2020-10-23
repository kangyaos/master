package com.jiaoda.edu.util;
/**
 * 做一个导入结果返回,word直接返回文本内容即可
 */
public class ImportWordResult {
	 private String title;
	    private String content;
	    private String msg;//发生错误的时候返回内容

	    public String getTitle() {
	        return title;
	    }

	    public void setTitle(String title) {
	        this.title = title;
	    }

	    public String getContent() {
	        return content;
	    }

	    public void setContent(String content) {
	        this.content = content;
	    }

	    public String getMsg() {
	        return msg;
	    }

	    public void setMsg(String msg) {
	        this.msg = msg;
	    }
}
