package com.jiaoda.edu.log;

import java.io.IOException;
import java.lang.reflect.Method;
import java.sql.Timestamp;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import javassist.ClassClassPath;
import javassist.ClassPool;
import javassist.CtClass;
import javassist.CtMethod;
import javassist.Modifier;
import javassist.bytecode.CodeAttribute;
import javassist.bytecode.LocalVariableAttribute;

import javax.servlet.http.HttpServletRequest;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.json.simple.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.jiaoda.edu.domain.LogException;
import com.jiaoda.edu.domain.LogOperation;
import com.jiaoda.edu.domain.UserInfo;
import com.jiaoda.edu.service.ILogExceptionService;
import com.jiaoda.edu.service.ILogOperationService;
import com.jiaoda.edu.service.IUserInfoService;
import com.jiaoda.edu.util.SystemUtil;


@Aspect
public class LogAspect {
	
	@Autowired
	private ILogOperationService logService;
	@Autowired
	private ILogExceptionService logeService;
	@Autowired
	private IUserInfoService userInfoService;
	
	private static final Logger logger = LoggerFactory.getLogger(LogAspect.class);
	
	@Pointcut("@annotation(com.sxhalo.lamadm.log.LogDesc)")
	public void serviceAspect() {
		
	}
	
	
	private static String device_version;
	static {
		Properties p = new Properties();
		try {
			p.load(LogAspect.class.getResourceAsStream("/comm.properties"));
			device_version = p.getProperty("device_version");			
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
	
	@AfterReturning(pointcut="serviceAspect()")    
    public void doAfter(JoinPoint joinPoint) {
		HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder
				.getRequestAttributes()).getRequest();
		// 获取登录用户
//		UserInfo user = userInfoService.find("userName",
//		request.getRemoteUser());
UserInfo user =new UserInfo();
		// 获取请求ip
		String ip = request.getRemoteAddr();
		try {
			/* ==========数据库日志========= */
            Timestamp nowTime = new Timestamp(System.currentTimeMillis());
            LogOperation log = new LogOperation();
            log.setAppId(1);
            log.setCreateTime(nowTime);
            log.setUserName(user.getUserName());
            log.setUserId(user.getUserId());
            log.setModuleName(getLogDesc(joinPoint));
            log.setOperationName(getOperationName(joinPoint));
			log.setMachineIp(ip);
			String params = "";
			ObjectMapper mapper = new ObjectMapper(); 
			if (joinPoint.getArgs() != null && joinPoint.getArgs().length > 0) {
				for (int i = 0; i < joinPoint.getArgs().length; i++) {
					params += mapper.writeValueAsString(joinPoint.getArgs()[i]) + ";";
				}
			}
			if(params.length()>9980){
				params=params.substring(0,9980);
			}
			log.setMessage("模块:"+log.getModuleName()+";操作:"+log.getOperationName()+";参数:"+params);
			// 保存数据库
			logService.insertSelective(log);
		} catch (Exception ex) {
			// 记录本地异常日志
			logger.error("异常信息:{}", ex.getMessage());
		}    
    }
	
	@Transactional(propagation = Propagation.REQUIRES_NEW)
	@AfterThrowing(pointcut = "serviceAspect()", throwing = "e")
	public void doAfterThrowing(JoinPoint joinPoint, Throwable e) {
		HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder
				.getRequestAttributes()).getRequest();
		// 获取登录用户		
//		UserInfo user = userInfoService.find("userName",
//		request.getRemoteUser());
UserInfo user =new UserInfo();
		// 获取请求ip
		String ip = request.getRemoteAddr();
		try {
			// 获取用户请求方法的参数并序列化为JSON格式字符串
			String params = "";
			ObjectMapper mapper = new ObjectMapper(); 
			if (joinPoint.getArgs() != null && joinPoint.getArgs().length > 0) {
				for (int i = 0; i < joinPoint.getArgs().length; i++) {
					params += mapper.writeValueAsString(joinPoint.getArgs()[i]) + ";";
				}
			}
			/* ========异常日志========= */
			Timestamp nowTime = new Timestamp(System.currentTimeMillis());
			LogException loge=new LogException();
			loge.setCreateTime(nowTime);
			loge.setUserId(user.getUserId());
			loge.setUserName(user.getUserName());
			loge.setModuleName(getLogDesc(joinPoint));
			loge.setOperationName(getOperationName(joinPoint));
			loge.setMachineIp(ip);
			loge.setMessage("异常信息:"+ e.getMessage());
			loge.setDeviceType("pc");
			loge.setDeviceBrand(SystemUtil.Config());
			loge.setDeviceVersion(device_version);
			loge.setAppName("pc_web_"+device_version);
			logeService.insertSelective(loge);
		} catch (Exception ex) {
			// 记录本地异常日志
			logger.error("异常信息:{}", ex.getMessage());
		}
	}
	
	private static String getLogDesc(JoinPoint joinPoint)
			throws Exception {
		String targetName = joinPoint.getTarget().getClass().getName();
		String methodName = joinPoint.getSignature().getName();
		Object[] arguments = joinPoint.getArgs();
		Class targetClass = Class.forName(targetName);
		Method[] methods = targetClass.getMethods();
		String description = "";
		for (Method method : methods) {
			if (method.getName().equals(methodName)) {
				Class[] clazzs = method.getParameterTypes();
				if (clazzs.length == arguments.length) {
					LogDesc logDesc = method.getAnnotation(LogDesc.class);
                    if (logDesc != null) {  
                    	description = logDesc.desc();  
                    } 
				}
			}
		}
		return description;
	}
	
	private static String getOperationName(JoinPoint joinPoint){
		String operationName = "";
		String methodName = joinPoint.getSignature().getName();
		if(methodName.equals("save")){
			operationName = "新增";
		}
		if(methodName.equals("update")){
			operationName = "编辑";
		}
		if(methodName.equals("delete")){
			operationName = "删除";
		}
		return operationName;
	}
	
	/*
	 * Controller 切点
	 */
	@Pointcut("@annotation(com.sxhalo.lamadm.log.SysControllerLog)")
	public void controllerAspect() {
	}
	/**
     * 方法开始执行
     */
	@AfterReturning(pointcut = "controllerAspect()")
	public void doBefore(JoinPoint joinPoint) throws Exception {
		HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder
				.getRequestAttributes()).getRequest();

		// 获取登录用户
//		UserInfo user = userInfoService.find("userName",
//				request.getRemoteUser());
		UserInfo user =new UserInfo();
		// 获取请求ip
		String ip = request.getRemoteAddr();
		Object[] args = joinPoint.getArgs();
		String classType = joinPoint.getTarget().getClass().getName();
		Class<?> clazz = Class.forName(classType);
		String clazzName = clazz.getName();
		String methodName = joinPoint.getSignature().getName(); // 获取方法名称
		// 获取参数名称和值
		Map<String, Object> nameAndArgs = this.getFieldsName(this.getClass(),
				clazzName, methodName, args);
		String result = JSONObject.toJSONString(nameAndArgs);
		/* ==========数据库日志========= */

		try {
			String description = getControllerMethodDescription(joinPoint);
			String[] des = description.split(",");
			Timestamp nowTime = new Timestamp(System.currentTimeMillis());
			LogOperation log = new LogOperation();
			log.setAppId(1);
			log.setCreateTime(nowTime);
			log.setUserName(user.getUserName());
			log.setUserId(user.getUserId());
			log.setOperationName(des[0]);
			log.setModuleName(des[1]);
			log.setMachineIp(ip);
			String params = "";
			ObjectMapper mapper = new ObjectMapper(); 
			if (joinPoint.getArgs() != null && joinPoint.getArgs().length > 0) {
				for (int i = 0; i < joinPoint.getArgs().length; i++) {
					params += mapper.writeValueAsString(joinPoint.getArgs()[i]) + ";";
				}
			}
			if(params.length()>9980){
				params=params.substring(0,9980);
			}
			log.setMessage(request.getRequestURI() + "," + result+";参数:"+params);
			logService.insertSelective(log);
		} catch (Exception ex) {
			// 记录本地异常日志
			logger.error("异常信息:{}", ex.getMessage());
		}

	}
	/**
	 * @Description 获取字段名和字段值
	 * @Author 
	 * @return Map<String,Object>
	 */
	private Map<String, Object> getFieldsName(Class cls, String clazzName,
			String methodName, Object[] args) throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();

		ClassPool pool = ClassPool.getDefault();
		ClassClassPath classPath = new ClassClassPath(cls);
		pool.insertClassPath(classPath);

		CtClass cc = pool.get(clazzName);
		CtMethod cm = cc.getDeclaredMethod(methodName);
		javassist.bytecode.MethodInfo methodInfo = cm.getMethodInfo();
		CodeAttribute codeAttribute = ((javassist.bytecode.MethodInfo) methodInfo)
				.getCodeAttribute();
		LocalVariableAttribute attr = (LocalVariableAttribute) codeAttribute
				.getAttribute(LocalVariableAttribute.tag);
		if (attr == null) {
			// exception
		}
		int pos = Modifier.isStatic(cm.getModifiers()) ? 0 : 1;
		for (int i = 0; i < cm.getParameterTypes().length; i++) {
			map.put(attr.variableName(i + pos), args[i]);// paramNames即参数名
		}
		return map;
	}

	/**
	 * 获取注解中对方法的描述信息 用于Controller层注解
	 * 
	 * @param joinPoint
	 *            切点
	 * @return 方法描述
	 * @throws Exception
	 */
	@SuppressWarnings("rawtypes")
	public static String getControllerMethodDescription(JoinPoint joinPoint)
			throws Exception {
		String targetName = joinPoint.getTarget().getClass().getName();
		String methodName = joinPoint.getSignature().getName();
		Object[] arguments = joinPoint.getArgs();
		Class<?> targetClass = Class.forName(targetName);
		Method[] methods = targetClass.getMethods();
		String description = "";
		for (Method method : methods) {
			if (method.getName().equals(methodName)) {
				Class[] clazzs = method.getParameterTypes();
				if (clazzs.length == arguments.length) {
					description = method.getAnnotation(
							SysControllerLog.class).description();
					description = description
							+ ","
							+ method.getAnnotation(SysControllerLog.class)
									.modelName();
					break;
				}
			}
		}
		return description;
	}
}
