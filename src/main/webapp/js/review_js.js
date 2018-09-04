$(function () {
    //
    $.ajax({
        url: "/ShowReview",
        type: "post",
        data:{"pagenum":pagenum},
        dataType: "json",
        success: function (list) {
            num = list.length;
            var arrayRid = new Array();
            var arrayi = new Array();
            var arrayhf = new Array();
            for (var i = 0; i < list.length; i++) {
                var $node = $('<div class="div_view"><hr width="90%"><div><a href="" class="sa_img"><img src="'+list[i].userImage+'" alt="" style="width:100%;min-height:100%;"></a>\n' +
                    '<a href="" style="position: relative;left: 50px;text-decoration: none">'+list[i].nickname+'</a></div><div class="sdiv_sa_view"><div>' +
                    '<p>'+list[i].reviewContent+'</p><br><span class="span_view_id">#'+list[i].reviewFloor+'</span><span class="span_view_time">'+list[i].reviewTime+'</span>\n' +
                    '<span><a class="sa_view_dzup"><div hidden>'+list[i].reviewId+'</div><div class="span_div_up"></div><span>'+list[i].reviewPraise+'</span></a></span>\n' +
                    ' <span><a class="sa_view_dzdown"><div hidden>'+list[i].reviewId+'</div><div class="span_div_down"></div><span>'+list[i].reviewUnpraise+'</span></a></span>\n' +
                    '<span class="span_view_hf">回复</span>\n' +
                    '<div class="hfdiv"></div><div hidden>'+list[i].reviewId+'</div><!--回复-->\n' +
                    '</div></div>');
                arrayhf.push(list[i].reviewId);
                ix = i+1;
                $('#review_pl'+ix).append($node);
                $('#review_pl'+ix).children('input').attr("value",''+list[i].reviewId);
                $('#review_hf'+ix).children('input').attr("value",''+list[i].reviewId);
                rid = $('#review_pl'+ix).children('input').val();
                arrayRid.push(rid);
                back(i+1,arrayRid[i]);
                // alert(111)
            }
        }
    })
    //更新用户头像及名字
    // $(".sa_img").children().children().attr("img","");

    //鼠标变成点击小手的操作
    $("body").on("mouseover",".span_view_hf",function () {
        $(this).css("cursor","pointer");
    })
    $("body").on("mouseover",".sa_view_dzup",function () {
        $(this).css("cursor","pointer");
    })
    $("body").on("mouseover",".sa_view_dzdown",function () {
        $(this).css("cursor","pointer");
    })
    //评论点赞功能
    $("body").on("click",".sa_view_dzup",function () {
        var span =  $(this).children("div:eq(0)").html();
        // alert(span);
        $.ajax({
            url:"/AddPraise",
            type:"post",
            data:{"reviewId":span},
            dataType:"json",
            success:function (ret) {
                // alert("charu")
                if (ret =="1"){
                    $.ajax({
                        url: "/ShowReview",
                        type: "post",
                        // data:{"num":num},
                        dataType: "json",
                        success: function (list) {

                            num = list.length;
                            //移除input中存储的value属性值
                            $(".div_view").remove();
                            $(".div_hf").remove();
                            for(var inputi = 1;inputi<5;inputi++){
                                $('#review_pl'+inputi).children('input').removeAttr("value");
                                $('#review_hf'+inputi).children('input').removeAttr("value");
                            }
                            var arrayRid = new Array();
                            var arrayi = new Array();
                            for (var i = 0; i < list.length; i++) {
                                // if (i<list.length){
                                var $node = $('<div class="div_view"><hr width="90%"><div><a href="" class="sa_img"><img src="'+list[i].userImage+'" alt="" style="width:100%;min-height:100%;"></a>\n' +
                                    '<a href="" style="position: relative;left: 50px;text-decoration: none">'+list[i].nickname+'</a></div><div class="sdiv_sa_view"><div>' +
                                    '<p>'+list[i].reviewContent+'</p><br><span class="span_view_id">#'+list[i].reviewFloor+'</span><span class="span_view_time">'+list[i].reviewTime+'</span>\n' +
                                    '<span><a class="sa_view_dzup"><div hidden>'+list[i].reviewId+'</div><div class="span_div_up"></div><span>'+list[i].reviewPraise+'</span></a></span>\n' +
                                    ' <span><a class="sa_view_dzdown"><div hidden>'+list[i].reviewId+'</div><div class="span_div_down"></div><span>'+list[i].reviewUnpraise+'</span></a></span>\n' +
                                    '<span class="span_view_hf">回复</span>\n' +
                                    '<div class="hfdiv"></div><div hidden>'+list[i].reviewId+'</div><!--回复-->\n' +
                                    '</div></div>');
                                ix = i+1;
                                $('#review_pl'+ix).append($node);
                                $('#review_pl'+ix).children('input').attr("value",''+list[i].reviewId);
                                $('#review_hf'+ix).children('input').attr("value",''+list[i].reviewId);
                                rid = $('#review_pl'+ix).children('input').val();
                                arrayRid.push(rid);
                                back(i+1,arrayRid[i]);
                            }
                        }
                    })
                }
            }
        })
    });
    //评论踩一下功能
    $("body").on("click",".sa_view_dzdown",function () {
        var span =  $(this).children("div:eq(0)").html();
        // alert(span);
        $.ajax({
            url:"/AddUnpraise",
            type:"post",
            data:{"reviewId":span},
            dataType:"json",
            success:function (ret) {
                // alert("charu")
                if (ret =="1"){
                    $.ajax({
                        url: "/ShowReview",
                        type: "post",
                        // data:{"num":num},
                        dataType: "json",
                        success: function (list) {

                            num = list.length;
                            //移除input中存储的value属性值
                            $(".div_view").remove();
                            $(".div_hf").remove();
                            for(var inputi = 1;inputi<5;inputi++){
                                $('#review_pl'+inputi).children('input').removeAttr("value");
                                $('#review_hf'+inputi).children('input').removeAttr("value");
                            }
                            var arrayRid = new Array();
                            var arrayi = new Array();
                            for (var i = 0; i < list.length; i++) {
                                var $node = $('<div class="div_view"><hr width="90%"><div><a href="" class="sa_img"><img src="'+list[i].userImage+'" alt="" style="width:100%;min-height:100%;"></a>\n' +
                                    '<a href="" style="position: relative;left: 50px;text-decoration: none">'+list[i].nickname+'</a></div><div class="sdiv_sa_view"><div>' +
                                    '<p>'+list[i].reviewContent+'</p><br><span class="span_view_id">#'+list[i].reviewFloor+'</span><span class="span_view_time">'+list[i].reviewTime+'</span>\n' +
                                    '<span><a class="sa_view_dzup"><div hidden>'+list[i].reviewId+'</div><div class="span_div_up"></div><span>'+list[i].reviewPraise+'</span></a></span>\n' +
                                    ' <span><a class="sa_view_dzdown"><div hidden>'+list[i].reviewId+'</div><div class="span_div_down"></div><span>'+list[i].reviewUnpraise+'</span></a></span>\n' +
                                    '<span class="span_view_hf">回复</span>\n' +
                                    '<div class="hfdiv"></div><div hidden>'+list[i].reviewId+'</div><!--回复-->\n' +
                                    '</div></div>');
                                ix = i+1;
                                $('#review_pl'+ix).append($node);
                                $('#review_pl'+ix).children('input').attr("value",''+list[i].reviewId);
                                $('#review_hf'+ix).children('input').attr("value",''+list[i].reviewId);
                                rid = $('#review_pl'+ix).children('input').val();
                                arrayRid.push(rid);
                                back(i+1,arrayRid[i]);
                            }
                        }
                    })
                }
            }
        })
    });



    //reiviewid绑定框隐藏事件
    // $(".input_reviewid").hide();
    //模板隐藏
    $(".div_view").hide();

    $("body").on("click",".span_view_hf",function () {
        var $huifu = $('<div class="div_common_com2" tabindex="1" style="border: double 2px bisque ;width: 620px;height: 140px;outline: none">\n' +
            '<div class="sa_img" ><a href="">\n' +
            '<img src="image/common01.png" alt="" style="width:100%;min-height:100%;"></a></div>\n' +
            '<textarea placeholder="请自觉遵守互联网相关的政策法规，严禁发布色情、暴力、反动的言论。"\n' +
            'style="background:transparent;border:1px solid #aaa;font: 15px 微软雅黑" class="area_coms" name="area_com" required></textarea>\n' +
            '                        <!--<button type="button" class="btn btn-primary" id="button_com">发表<br>评论</button>-->\n' +
            ' <div class="boxs uploadBox1"><span>发布<br>评论</span>\n' +
            '<input class="input"  class="uploadInput" type="button" multiple/></div></div>');
        $(this).next().children().remove();
        $(this).next().append($huifu);
    });

    //回复框按钮绑定插入回复事件
    //回复框按钮绑定事件
    $("body").on("click",".uploadBox1",function () {
        var top = $(this).parents("div[class^=hf]").next("div").html();
        // alert(top);
        //回复功能
        $.ajax({
            url:"/AddBack",
            type:"post",
            data:{"ReviewContent": $("textarea[class='area_coms']").val(),"TopReviewID":top},
            dataType:"json",
            success:function (ret) {
                if (ret =="1"){
                    layer.msg('回复成功！',{time:800},function () {
                        location.reload();
                    });
                }
                // ,"TopReviewID":top
            }
        })
    });

    //回复按钮绑定变色效果
    $("body").on("mousedown",".uploadBox1",function () {
        $(".uploadBox1").css("background-color","#1b6d85");

    })
    $("body").on("mouseup",".uploadBox1",function () {
        $(".uploadBox1").css("background-color","#b8c0cc");
    })

    //显示评论总数及总页数
    $.ajax({
        url: "/ShowCount",
        type: "post",
        dataType: "json",
        success: function (count) {
            $countz = count;
            var $pagey = Math.ceil(count/PageSize);
            var $node = $('<span>'+count+'</span>');
            $("#span_common_head_left").append($node);
            $("#span_common_ys").append('<span style="font: 15px 微软雅黑;">共'+$pagey+'页</span>');
        }
    });

    //获取最大楼层
    var foot=0;
    $.ajax({
        url:"/ShowMaxFloor",
        type:"post",
        dataType:"json",
        success:function (ret) {
            foot=ret;
        }
    });

    //插入评论功能
    var userid = 1;
    // var vedio = 39;
    // var foot = 8;
    $("#uploadBox").click(function () {
        $.ajax({
            url:"/AddReview",
            type:"post",
            data:{"ReviewContent": $("textarea[class='area_com']").val(),"TopReviewID":0,"FooterID":(foot+1)},
            dataType:"json",
            success:function (ret) {
                // alert("charu")
                if (ret =="1"){
                    layer.msg('评论成功！',{time:800},function () {
                        location.reload();
                    });
                }
            }
        })
    });

    //实现单击变化页数事件
    $(".span_line:odd").click(function () {
        pageClick = $(this).html();
        num = pageClick;
        // alert(num);
        //将页数传到session对象中
        $.ajax({
            url:"/ShowPage",
            data:{"page":pageClick},
            type:"post",
            dataType:"json",
            success:function () {}
        });
        // alert(num);
        //分页显示评论
        $.ajax({
            url: "/ShowReview",
            type: "post",
            // data:{"num":num},
            dataType: "json",
            success: function (list) {
                num = list.length;
                //移除input中存储的value属性值
                $(".div_view").remove();
                $(".div_hf").remove();
                for(var inputi = 1;inputi<5;inputi++){
                    $('#review_pl'+inputi).children('input').removeAttr("value");
                    $('#review_hf'+inputi).children('input').removeAttr("value");
                }
                var arrayRid = new Array();
                var arrayi = new Array();
                for (var i = 0; i < list.length; i++) {
                    // if (i<list.length){
                    var $node = $('<div class="div_view"><hr width="90%"><div><a href="" class="sa_img"><img src="'+list[i].userImage+'" alt="" style="width:100%;min-height:100%;"></a>\n' +
                        '<a href="" style="position: relative;left: 50px;text-decoration: none">'+list[i].nickname+'</a></div><div class="sdiv_sa_view"><div>' +
                        '<p>'+list[i].reviewContent+'</p><br><span class="span_view_id">#'+list[i].reviewFloor+'</span><span class="span_view_time">'+list[i].reviewTime+'</span>\n' +
                        '<span><a class="sa_view_dzup"><div hidden>'+list[i].reviewId+'</div><div class="span_div_up"></div><span>'+list[i].reviewPraise+'</span></a></span>\n' +
                        ' <span><a class="sa_view_dzdown"><div hidden>'+list[i].reviewId+'</div><div class="span_div_down"></div><span>'+list[i].reviewUnpraise+'</span></a></span>\n' +
                        '<span class="span_view_hf">回复</span>\n' +
                        '<div class="hfdiv"></div><div hidden>'+list[i].reviewId+'</div><!--回复-->\n' +
                        '</div></div>');
                    ix = i+1;
                    $('#review_pl'+ix).append($node);
                    $('#review_pl'+ix).children('input').attr("value",''+list[i].reviewId);
                    $('#review_hf'+ix).children('input').attr("value",''+list[i].reviewId);
                    rid = $('#review_pl'+ix).children('input').val();
                    arrayRid.push(rid);
                    back(i+1,arrayRid[i]);
                }
            }
        })
    });

//    按钮按下变色效果
//    评论按钮
    $("#uploadBox").mousedown(function () {
        $("#uploadBox").css("background-color","#1b6d85");
    });
    $("#uploadBox").mouseup(function () {
        $("#uploadBox").css("background-color","#b8c0cc");
    });




});


var ix;
var num = 1;
var preList;
var pagenum;
var PageSize = 4;
var rid;
var rids;
var pageClick;
var arrayback = new Array();
function back(x,array) {
    // alert(111)
    $.ajax({
        url: "/ShowBack",
        type: "post",
        data: {"reviewid": array},
        dataType: "json",
        success: function (listback) {
            // alert(listback)
            for (var j = 0; j < listback.length; j++) {
                var $back = $('<div class="div_hf"><div><a href="" class="sa_img_min"><img src="'+listback[j].userImage+'" alt="" style="width:100%;min-height:100%;"></a>\n' +
                    '<a href="" style="position: relative;left: 50px;text-decoration: none">'+listback[j].nickname+'</a>\n' +
                    ' <span style="position: relative;left: 55px">' + listback[j].reviewContent + '</span></div><span class="span_view_times">' + listback[j].reviewTime + '</span>\n' +
                    ' <span><a class="sa_view_dzup"><div hidden>'+listback[j].reviewId+'</div><div class="span_div_up"></div><span>' + listback[j].reviewPraise + '</span></a></span>\n' +
                    ' <span class="span_view_hf">回复</span><div></div><div hidden>'+listback[j].reviewId+'</div><div></div></div>');

                arrayback.push(listback[j].reviewId);
                // alert(arrayback);
                $('#review_hf' + x).append($back);
            }
        }
    });
}