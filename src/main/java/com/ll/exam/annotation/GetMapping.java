package com.ll.exam.annotation;

import java.lang.annotation.*;

@Target(ElementType.METHOD) // 이 어노테이션은 메서드에 붙는거다.
@Retention(RetentionPolicy.RUNTIME) // ??
public @interface GetMapping {
    String value(); // 어노테이션 달때, value(String) 입력가능하게 함
}
