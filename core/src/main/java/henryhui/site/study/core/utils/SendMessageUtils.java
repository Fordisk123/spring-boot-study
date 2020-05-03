package henryhui.site.study.core.utils;

import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

public class SendMessageUtils {

    public static void sendTextMessage(HttpServletResponse response, String text, int statusCode) throws Exception {
        response.setContentType("text/html; charset=utf-8");
        response.setStatus(statusCode);
        PrintWriter writer = response.getWriter();
        writer.print(text);
        writer.close();
        response.flushBuffer();
    }


    public static void sendJsonMessage(HttpServletResponse response, Object obj, int statusCode) throws Exception {
        response.setContentType("application/json; charset=utf-8");
        response.setStatus(statusCode);
        PrintWriter writer = response.getWriter();
        ObjectMapper objectMapper = new ObjectMapper();
        writer.print(objectMapper.writeValueAsString(obj));
        writer.close();
        response.flushBuffer();
    }

}
