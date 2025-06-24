package com.example.assignment_2.Aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;

@Aspect
@Component
public class loggingAspect {
    private static final String LOG_FILE = "app.log";


    @Pointcut("execution(* com.example.assignment_2.API..*(..)) || " +
            "execution(* com.example.assignment_2.Service..*(..)) || " +
            "execution(* com.example.assignment_2.Repository..*(..))")
    public void applicationPackagePointcut() {}

    @Before("applicationPackagePointcut()")
    public void logBefore(JoinPoint joinPoint) {
        String username = getUsername();
        String methodName = joinPoint.getSignature().toShortString();
        String args = Arrays.toString(joinPoint.getArgs());
        String timestamp = getTimestamp();

        String logEntry = String.format("[%s] USER: %s - ENTERING METHOD: %s - ARGS: %s%n",
                timestamp, username, methodName, args);

        writeToLog(logEntry);
    }

    @AfterReturning(pointcut = "applicationPackagePointcut()", returning = "result")
    public void logAfterReturning(JoinPoint joinPoint, Object result) {
        String username = getUsername();
        String methodName = joinPoint.getSignature().toShortString();
        String timestamp = getTimestamp();

        String logEntry = String.format("[%s] USER: %s - EXITING METHOD: %s - RETURN: %s%n",
                timestamp, username, methodName, result != null ? result.toString() : "null");

        writeToLog(logEntry);
    }

    @AfterThrowing(pointcut = "applicationPackagePointcut()", throwing = "ex")
    public void logAfterThrowing(JoinPoint joinPoint, Throwable ex) {
        String username = getUsername();
        String methodName = joinPoint.getSignature().toShortString();
        String timestamp = getTimestamp();

        String logEntry = String.format("[%s] USER: %s - EXCEPTION in METHOD: %s - ERROR: %s%n",
                timestamp, username, methodName, ex.getMessage());

        writeToLog(logEntry);
    }

    private String getUsername() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null && auth.isAuthenticated() && !"anonymousUser".equals(auth.getName())) {
            return auth.getName();
        }
        return "Anonymous";
    }

    private String getTimestamp() {
        return LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
    }

    private void writeToLog(String logEntry) {
        try (FileWriter writer = new FileWriter(LOG_FILE, true)) {
            writer.write(logEntry);
        } catch (IOException e) {
            System.err.println("Error writing to log file: " + e.getMessage());
        }
    }
}

