package com.vilderlee.design.commandchain;

import org.springframework.beans.factory.annotation.AnnotatedBeanDefinition;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.core.type.AnnotationMetadata;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.stream.Stream;

/**
 * 类说明:
 *
 * <pre>
 * Modify Information:
 * Author        Date          Description
 * ============ ============= ============================
 * VilderLee    2019/7/26      Create this file
 * </pre>
 */
public class Tx1100RiskCommandChain extends BaseCommandChain {

    public Tx1100RiskCommandChain() {

        JdbcTemplate jdbcTemplate = Environment.ApplicationContext.getBean(JdbcTemplate.class);
        String sql = "SELECT * FROM RiskCommandDictionary";

        List<RiskCommandDictionary> list = jdbcTemplate
                .query(sql, BeanPropertyRowMapper.newInstance(RiskCommandDictionary.class));

        String[] string = Environment.ApplicationContext.getBeanNamesForAnnotation(RiskCommand.class);

        Map<String, String> commandBeanNameMap = new HashMap<>();
        Stream.of(string).forEach(s -> {
            BeanDefinition beanDefinition = ((BeanDefinitionRegistry) Environment.ApplicationContext)
                    .getBeanDefinition(s);

            if (beanDefinition instanceof AnnotatedBeanDefinition) {
                AnnotationMetadata annotationMetadata = ((AnnotatedBeanDefinition) beanDefinition).getMetadata();
                if (annotationMetadata.hasAnnotation(RiskCommand.class.getName())) {
                    Map map = annotationMetadata.getAnnotationAttributes(RiskCommand.class.getName());
                    commandBeanNameMap.put((String) map.get("RiskName"), s);
                }
            }
        });

        list.forEach(riskCommandDictionary -> {
            Command command = (Command) Environment.ApplicationContext.getBean(commandBeanNameMap.get(riskCommandDictionary.getRiskCommand()));
            addCommand(command);
        });
    }

    @Override
    public boolean execute(Context context) {
        AtomicBoolean saveResult = new AtomicBoolean(false);
        super.commands.forEach(command -> {
            try {
                saveResult.set(command.execute(context));
                if (!saveResult.get()){
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        return saveResult.get();
    }

    @Override
    public boolean rollback(Context context) throws Exception {
        super.commands.forEach(command -> {
            try {
                command.rollback(context);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        return false;
    }
}
