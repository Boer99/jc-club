package com.jingdianjichi.core.utils;

import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;

import java.io.FileWriter;
import java.io.IOException;
import java.io.StringWriter;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 使用velocity生成文件
 *
 * @author loser
 * @date 2023/9/4
 */
public class CodeGeneratorUtils {

    private final VelocityEngine velocityEngine;

    public CodeGeneratorUtils() {
        this.velocityEngine = new VelocityEngine();
        velocityEngine.init();

    }

    public void generateCode(VelocityContext context, String templatePath, String outputPath, AtomicInteger count) {

        Template template = velocityEngine.getTemplate(templatePath, "UTF-8");
        StringWriter writer = new StringWriter();
        template.merge(context, writer);

        try (FileWriter fileWriter = new FileWriter(outputPath)) {
            fileWriter.write(writer.toString());
            System.out.println();
            System.out.println("==========> " + count.getAndIncrement() + " genFile succeed : " + outputPath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
