package LikeLion7.weeks1.aspect;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.METHOD) // METHOD단위에서만 사용 가능함
@Retention(RetentionPolicy.RUNTIME)
public @interface LogExecutionTime {
}
