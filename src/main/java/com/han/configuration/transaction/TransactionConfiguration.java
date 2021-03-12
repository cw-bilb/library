package com.han.configuration.transaction;

import org.aspectj.lang.annotation.Aspect;
import org.springframework.aop.Advisor;
import org.springframework.aop.aspectj.AspectJExpressionPointcut;
import org.springframework.aop.support.DefaultPointcutAdvisor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.interceptor.NameMatchTransactionAttributeSource;
import org.springframework.transaction.interceptor.RuleBasedTransactionAttribute;
import org.springframework.transaction.interceptor.TransactionAttribute;
import org.springframework.transaction.interceptor.TransactionInterceptor;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

/**
 * @author kurt
 * @version 1.0.0
 * @ClassName TransactionConfiguration.java
 * @Description TODO
 * @createTime 2021年03月11日 10:51:00
 */
@Aspect
@Configuration
public class TransactionConfiguration {

    private final static int METHOD_TIME_OUT = 5;
    private static final String AOP_POINTCUT_EXPRESSION = "execution(* com.han.service.impl.*.*(..))";
    @Resource
    private PlatformTransactionManager transactionManager;//spring事务管理器

    /**
     * 事务拦截器，配置事务的增强器
     * @param
     * @return org.springframework.transaction.interceptor.TransactionInterceptor
     */
    @Bean(value = "txAdivce")
    public TransactionInterceptor transactionConfig() {
        RuleBasedTransactionAttribute readOnly = new RuleBasedTransactionAttribute();
        //设置只读事务
        readOnly.setReadOnly(true);
        readOnly.setPropagationBehavior(TransactionDefinition.PROPAGATION_NOT_SUPPORTED);
        //定义默认的传播事务
        RuleBasedTransactionAttribute required = new RuleBasedTransactionAttribute();
        //事务传播方式及其超时
        required.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRED);
        required.setTimeout(METHOD_TIME_OUT);

        //使用名称匹配
        NameMatchTransactionAttributeSource source = new NameMatchTransactionAttributeSource();
        // 哪些方法是只读，哪些是默认的事务行为
        Map<String, TransactionAttribute> transactionmap = new HashMap<>();
        transactionmap.put("add*", required);
        transactionmap.put("insert*", required);
        transactionmap.put("delete*", required);
        transactionmap.put("get*", readOnly);
        transactionmap.put("list*", readOnly);
        transactionmap.put("find*", readOnly);

        source.setNameMap(transactionmap);

        TransactionInterceptor transactionInterceptor = new TransactionInterceptor();
        transactionInterceptor.setTransactionManager(transactionManager);
        transactionInterceptor.setTransactionAttributeSource(source);

        return transactionInterceptor;
    }
    /**
     * 将切入点和事务增强结合在一起
     * @param
     * @return org.springframework.aop.Advisor
     */
    @Bean
    public Advisor transactionAdviceAdvisor(){
        //定义切入点
        AspectJExpressionPointcut pointcut = new AspectJExpressionPointcut();
        pointcut.setExpression(AOP_POINTCUT_EXPRESSION);
        //
        return new DefaultPointcutAdvisor(pointcut,transactionConfig());
    }

}
