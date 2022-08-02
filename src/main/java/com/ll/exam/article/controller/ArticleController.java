package com.ll.exam.article.controller;

import com.ll.exam.annotation.Controller;
import com.ll.exam.annotation.GetMapping;

@Controller // ArticleController 가 컨트롤러 이다.
public class ArticleController {
    @GetMapping("/usr/article/list") /// usr/article/list/free 와 같이 관련된 컨트롤러이다.
    public void showList() {

    }
}
