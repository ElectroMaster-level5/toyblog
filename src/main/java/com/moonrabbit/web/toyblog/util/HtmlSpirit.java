package com.moonrabbit.web.toyblog.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class HtmlSpirit {
    /**
     * 用于提取摘要时，删除html tag
     * @param htmlStr
     * @return
     */
    public static String delHtmlTag(String htmlStr){
        //定义script的正则表达式
        String regexScript = "<script[^>]*?>[\\s\\S]*?<\\/script>";
        //定义style的正则表达式
        String regexStyle = "<style[^>]*?>[\\s\\S]*?<\\/style>";
        //定义HTML标签的正则表达式
        String regexHtml = "<[^>]+>";

        Pattern pScript = Pattern.compile(regexScript, Pattern.CASE_INSENSITIVE);
        Matcher mScript = pScript.matcher(htmlStr);
        //过滤script标签
        htmlStr = mScript.replaceAll("");

        Pattern pStyle = Pattern.compile(regexStyle, Pattern.CASE_INSENSITIVE);
        Matcher mStyle = pStyle.matcher(htmlStr);
        //过滤style标签
        htmlStr = mStyle.replaceAll("");

        Pattern pHtml = Pattern.compile(regexHtml, Pattern.CASE_INSENSITIVE);
        Matcher mHtml = pHtml.matcher(htmlStr);
        //过滤html标签
        htmlStr = mHtml.replaceAll("");

        //返回文本字符串
        return htmlStr.trim();
    }
}
