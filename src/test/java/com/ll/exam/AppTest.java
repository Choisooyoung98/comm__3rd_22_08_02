package com.ll.exam;

import com.ll.exam.article.controller.ArticleController;
import com.ll.exam.article.service.ArticleService;
import com.ll.exam.home.controller.HomeController;
import org.junit.jupiter.api.Test;
import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;

public class AppTest {
    @Test
    public void junit_assertThat() {
        int rs = 10 + 20;
        assertThat(rs).isEqualTo(30);
    }

    @Test
    public void ioc__articleController() {
        ArticleController articleController = Con.getObj(ArticleController.class);

        assertThat(articleController).isNotNull();
    }

    @Test
    public void ioc__articleController__싱글톤() {
        ArticleController articleController1 = Con.getObj(ArticleController.class);
        ArticleController articleController2 = Con.getObj(ArticleController.class);

        assertThat(articleController2).isEqualTo(articleController1);
    }

    @Test
    public void ioc__homeController() {
        HomeController homeController = Con.getObj(HomeController.class);

        assertThat(homeController).isNotNull();
    }

    @Test
    public void ioc__homeController__싱글톤() {
        HomeController homeController1 = Con.getObj(HomeController.class);
        HomeController homeController2 = Con.getObj(HomeController.class);

        assertThat(homeController2).isEqualTo(homeController1);
    }
    @Test
    public void ioc__Controller들을_스캔하여_수집() {
        List<String> names = Con.getControllerNames();
        assertThat(names).contains("home");
        assertThat(names).contains("article");
    }
    @Test
    public void ioc__articleService() {
        ArticleService articleService = Con.getObj(ArticleService.class);

        assertThat(articleService).isNotNull();
    }
    @Test
    public void ioc__articleService__싱글톤() {
        ArticleService articleService1 = Con.getObj(ArticleService.class);
        ArticleService articleService2 = Con.getObj(ArticleService.class);

        assertThat(articleService2).isEqualTo(articleService1);
    }
}