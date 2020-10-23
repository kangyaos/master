package com.jiaoda.edu.log;

import java.lang.annotation.*;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface LogDesc {
	String desc() default "";
}
