package com.moonrabbit.web.toyblog.util;

import org.pegdown.PegDownProcessor;

public class MarkdownToHtml {
    /**
     * 将markdown String 转换成 html String
     * @param markdownStr
     * @return
     */
    public static String markDownToHtml(String markdownStr){
        PegDownProcessor pdp = new PegDownProcessor(Integer.MAX_VALUE);
        return pdp.markdownToHtml(markdownStr);
    }
}
