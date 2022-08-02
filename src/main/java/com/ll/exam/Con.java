package com.ll.exam;

import com.ll.exam.annotation.Controller;
import com.ll.exam.article.controller.ArticleController;
import com.ll.exam.home.controller.HomeController;
import org.reflections.Reflections;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

public class Con {
    private static final ArticleController articleController;
    private static final HomeController homeController;
    static {
        articleController = (ArticleController) Ut.cls.newObj(ArticleController.class, null);
        homeController = (HomeController) Ut.cls.newObj(HomeController.class, null);
    }
    public static ArticleController getArticleController() {
        return articleController;
    }


    public static List<String> getControllerNames() {
        List<String> names = new ArrayList<>();

        Reflections reflections = new Reflections("com.ll.exam");
        for (Class<?> cls : reflections.getTypesAnnotatedWith(Controller.class)) {
            String name = cls.getSimpleName().replace("Controller","");

            names.add(Ut.str.decapitalize(name));
        }

        return names;
    }
}
