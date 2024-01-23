package com.springprojectresponse.utils;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.File;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.List;

public class XmlParserUtils {
    public static <T> List<T> parse(String file, Class<T> targetClass) {
        ArrayList<T> list = new ArrayList<>();

        try {
            //            获取解析器对象
            SAXReader saxReader = new SAXReader();
            //            解析文件,加载内存,返回文档对象
            Document document = saxReader.read(new File(file));
            //            获取根元素
            Element rootElement = document.getRootElement();
            //            获取 user 标签
            List<Element> elements = rootElement.elements("emp");

            for (Element element : elements) {
                //                获取属性
                String name = element.element("name").getText();
                String age = element.element("age").getText();
                String image = element.element("image").getText();
                String gender = element.element("gender").getText();
                String job = element.element("job").getText();

                //                组装数据
                Constructor<T> constructor = targetClass.getDeclaredConstructor(String.class, Integer.class, String.class, String.class, String.class);
                constructor.setAccessible(true);

                T object = constructor.newInstance(name, Integer.valueOf(age), image, gender, job);
                list.add(object);

            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return list;
    }
}
