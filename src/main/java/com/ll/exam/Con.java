package com.ll.exam;

import com.ll.exam.annotation.Controller;
import com.ll.exam.article.controller.ArticleController;
import org.reflections.Reflections;

import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.List;

import static com.ll.exam.Ut.str.decapitalize;

public class Con {
    private static final ArticleController articleController;
    static {
        articleController = new ArticleController();
    }
    public static ArticleController getArticleController() {
        return articleController;
    }

    public static List<String> getControllerNames() {
        List<String> names = new ArrayList<>();

        Reflections reflections = new Reflections("com.ll.exam");
        for (Class<?> cls : reflections.getTypesAnnotatedWith(Controller.class)) {
            String name = cls.getSimpleName();
            name = name.replace("Controller","");

            name = decapitalize(name);

            names.add(name);
        }

        return names;
    }
}
