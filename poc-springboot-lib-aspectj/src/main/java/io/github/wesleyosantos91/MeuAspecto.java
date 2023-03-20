package io.github.wesleyosantos91;

import io.github.wesleyosantos91.annotations.EventoCapturado;
import io.github.wesleyosantos91.annotations.HelloWorld;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.lang.reflect.Parameter;

@Aspect
@Component
public class MeuAspecto {
    @Around("@annotation(io.github.wesleyosantos91.annotations.HelloWorld)")
    public Object executarAnotacao(ProceedingJoinPoint pontoDeExecucao) throws Throwable {
        MethodSignature signature = (MethodSignature) pontoDeExecucao.getSignature();
        Object[] argumentos = pontoDeExecucao.getArgs(); // acessa os argumentos do método

        int argumentoCapturado = 0;

        Parameter[] parameters = signature.getMethod().getParameters();
        for (int i = 0; i < parameters.length; i++) {
            if (parameters[i].isAnnotationPresent(EventoCapturado.class)) {
                argumentoCapturado = parameters[i].getAnnotation(EventoCapturado.class).value();
                break;
            }
        }

        Object objetoCapturado = argumentos[argumentoCapturado];

        System.out.println(objetoCapturado);

        System.out.println("Anotação executada com sucesso!");
        return pontoDeExecucao.proceed();
    }
}
