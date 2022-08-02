package com.ll.exam;

import com.ll.exam.article.controller.ArticleController;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.assertj.core.api.Assertions.assertThat;

public class AppTest {
    @Test
    public void junit_assertThat() {
        int rs = 10 + 20;
        assertThat(rs).isEqualTo(30);
    }
    @Test
    public void ioc__articleController() {
        ArticleController articleController = Con.getArticleController();
        assertThat(new ArrayList<>()).isNotNull();
    }
    @Test
    public void ioc__articleController__싱글톤() {
        ArticleController articleController1 = Con.getArticleController();
        ArticleController articleController2 = Con.getArticleController();
        assertThat(articleController2).isEqualTo(articleController1);
    }
}
