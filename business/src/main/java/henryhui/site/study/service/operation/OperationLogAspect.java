package henryhui.site.study.service.operation;

import henryhui.site.study.core.JwtComponent;
import henryhui.site.study.model.OperationLogModel;
import lombok.extern.slf4j.Slf4j;
import org.apache.tomcat.jni.Local;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
import java.time.LocalDateTime;
import java.util.Arrays;

@Aspect
@Component
@Slf4j
public class OperationLogAspect {

    @Autowired
    JwtComponent jwtComponent;


    @Autowired
    IOperationService operationService;


    //表示匹配带有自定义注解的方法
    @Pointcut("@annotation(henryhui.site.study.service.operation.OperationLog)")
    public void pointcut() {}

    @Around("pointcut()")
    public Object around(ProceedingJoinPoint point){
        //TODO 记录操作是否成功
        LocalDateTime startTime = LocalDateTime.now();
        Object res = null;
        try{
            res = point.proceed();
            LocalDateTime endTime = LocalDateTime.now();
            insertLog(point ,startTime, endTime);
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        return res;
    }

    private long insertLog(ProceedingJoinPoint point , LocalDateTime starTime , LocalDateTime endTime) {
        //获取注解的描述
        MethodSignature signature = (MethodSignature)point.getSignature();
        Method method = signature.getMethod();
        String operate = "";
        OperationLog log = method.getAnnotation(OperationLog.class);
        if (log != null) {
            // 注解上的描述
            operate = log.operate();
        }

        // 请求的类名
        String className = point.getTarget().getClass().getName();
        // 请求的方法名
        String methodName = signature.getName();

        String loginName = "";
        // RequestContextHolder 一个持有上下文的request的容器
        HttpServletRequest request = ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();
        //获取token，提取userId
        String token = request.getHeader("token");
        if(token != null && !token.isEmpty()){
            loginName = jwtComponent.getLoginName(token);
        }
        //TODO login接口从body中获取

        OperationLogModel logModel = new OperationLogModel();
        logModel.setOperate(operate);
        logModel.setOperateUsername(loginName);
        logModel.setStartTime(starTime);
        logModel.setEndTime(endTime);
        logModel.setCostTime(endTime.getNano() - starTime.getNano());
        logModel.setClassName(className);
        logModel.setMethodName(methodName);

        return operationService.insertLog(logModel).getId();
    }


}
