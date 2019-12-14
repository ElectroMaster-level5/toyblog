package com.moonrabbit.web.toyblog.constants;

public class Constants {
    public static final Integer YES = 1;
    public static final Integer NO = 0;
    public static final int defaultPageSize = 3;
    // 最多一次显示5个页码，比如说我们有10页要显示，但是页面栏就只有1,2,3,4,5或2,3,4,5,6
    public static final int maxShowPageItem = 5;
    // 若摘要长度>blogIntroLen，多余的部分则会显示为 '...'
    public static final int blogIntroLen=100;

}
