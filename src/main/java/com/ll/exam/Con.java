package com.ll.exam;

import com.ll.exam.annotation.Controller;
import com.ll.exam.annotation.Service;
import com.ll.exam.article.controller.ArticleController;
import com.ll.exam.home.controller.HomeController;
import org.reflections.Reflections;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Con {
    private static Map<Class, Object> objects;

    static {
        objects = new HashMap<>();

        scanComponents();
    }

    private static void scanComponents() {
        scanService();
        scanController();
    }

    private static void scanService() {
        Reflections ref = new Reflections("com.ll.exam");
        for (Class<?> cls : ref.getTypesAnnotatedWith(Service.class)) {
            objects.put(cls, Ut.cls.newObj(cls, null));
        }
    }

    private static void scanController() {
        Reflections ref = new Reflections("com.ll.exam");
        for (Class<?> cls : ref.getTypesAnnotatedWith(Controller.class)) {
            objects.put(cls, Ut.cls.newObj(cls, null));
        }
    }

    public static <T> T getObj(Class<T> cls) {
        return (T)objects.get(cls);
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
