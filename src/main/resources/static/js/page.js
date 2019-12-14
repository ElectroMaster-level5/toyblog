function getRootPath_dc(){
    return window.location.protocol+'//'+window.location.host+"/";
}

$.fn.extend({
    "initPage":function(totalCount, currentPage, fun){
        var maxshowpageitem=$(this).attr("maxshowpageitem");
        if(maxshowpageitem!=null && maxshowpageitem>0 &&maxshowpageitem!=""){
            page.maxshowpageitem = maxshowpageitem;
        }
        var pagelistcount = $(this).attr("pagelistcount");
        if(pagelistcount!=null && pagelistcount>0 && pagelistcount!=""){
            page.pagelistcount = pagelistcount;
        }
        var pageId = $(this).attr("id");
        page.pageId = pageId;

        if(totalCount<0){
            totalCount = 0;
        }
        if(currentPage<=0){
            currentPage = 1;
        }
        page.setPageNav(pageId, totalCount, currentPage, fun);

    }
});

var page = {
    // page.pagelistcount: 每页展示数据条数
    /**
     * 初始化页码栏的html
     * @param pageId <ul class="page" id="">里的id
     * @param totalCount 一共有多少条数据
     * @param currentPage 当前页码
     */
    "initWithUI": function (pageId, totalCount, currentPage) {
        if (totalCount > 0) {
            // pageCount: 总页码个数
            var pageCount = totalCount % page.pagelistcount > 0 ? parseInt(totalCount / page.pagelistcount) + 1 :
                parseInt(totalCount / page.pagelistcount);

            var appendStr = page.getPageListModel(pageCount, currentPage);
            $("#"+pageId).html(appendStr);
        }

    },

    /**
     *
     * @param pageId <ul class="page" id="">里的id
     * @param totalCount 一共有多少条数据
     * @param currentPage 当前页码
     * @param fun
     */
    "setPageNav":function(pageId, totalCount, currentPage, fun){
        totalCount = parseInt(totalCount);
        currentPage = parseInt(currentPage);
        page.initWithUI(pageId, totalCount, currentPage);
        page.initPageEvent(pageId, totalCount, fun);
    },
    "initPageEvent": function(pageId, totalCount, fun){
        $("#"+pageId+">li[class='pageItem']").on("click", function(){
            if(typeof fun=="function"){
                fun($(this).attr("page-data"));
            }
            page.setPageNav(pageId, totalCount, $(this).attr("page-data"), fun);
        });
    },
    /**
     * 初始化页码栏的html的具体实现
     * @param pageCount 总页码个数
     * @param currentPage 当前页码
     */
    "getPageListModel": function (pageCount, currentPage) {
        var prePage = currentPage - 1;
        var nextPage = currentPage + 1;
        var prePageClass="pageItem";
        var nextPageClass="pageItem";

        if(prePage<=0){
            prePageClass = "pageItemDisable";
        }
        if(nextPage>pageCount){
            nextPageClass = "pageItemDisable";
        }

        var appendStr="";
        appendStr += "<li class='"+prePageClass+"' page-data='1' page-rel='firstpage'>首页</li>";
        appendStr += "<li class='"+prePageClass+"' page-data='"+prePage+"' page=rel='prepage'>&lt;上一页</li>";

        var minPageNumber = 1;
        // 假设页码为1-10，我们设置最多展示页码数量为5， 那么在当前页码为1,2,3时，页面栏中最小页码值为1。
        // 在当前页码为9或10时，页面栏中最小页码值为6
        if(currentPage - parseInt(page.maxshowpageitem/2)>0 && currentPage+parseInt(page.maxshowpageitem/2)<=pageCount){
            minPageNumber = currentPage-parseInt(page.maxshowpageitem/2);
        } else if(currentPage-parseInt(page.maxshowpageitem/2)>0 && currentPage+parseInt(page.maxshowpageitem/2)>pageCount){
            minPageNumber = pageCount-page.maxshowpageitem+1;
            if(minPageNumber<=0){
                minPageNumber=1;
            }
        }
        var showPageNum = parseInt((page.maxshowpageitem));
        if(pageCount<showPageNum){
            showPageNum = pageCount;
        }
        for(var i=0; i<showPageNum; i++){
            var pageNumber = minPageNumber++;
            var itemPageClass = "pageItem";
            if(pageNumber == currentPage){
                itemPageClass = "pageItemActive";
            }
            appendStr += "<li class='"+itemPageClass+"' page-data='"+pageNumber+"' page-rel='itempage'>"+pageNumber+"</li>"
        }
        appendStr += "<li class='"+nextPageClass+"' page-data='"+nextPage+"' page-rel='nextpage'>下一页&gt;</li>";
        appendStr += "<li class='"+nextPageClass+"' page-data='"+pageCount+"' page-rel='lastpage'>尾页</li>";

        return appendStr;

    }

}