package com.jiaoda.edu.log;

import java.lang.annotation.*;

@Target({ ElementType.PARAMETER, ElementType.METHOD })
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface SysControllerLog {

	String description() default "";
	String modelName() default "";

}
