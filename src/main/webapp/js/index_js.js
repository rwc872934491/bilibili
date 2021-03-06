$(function () {
    //ajax实现一二级菜单跳转页面
    $(".header_list_hidden").children().click(function () {
        //获取二级菜单内容
        var $span_two =  $(this).children().children().html();
        // alert($span_two);
        //获取一级菜单内容
        var $div_one = $(this).parent().prev().children("div:eq(1)").html();
        $.ajax({
            url:"/TakeTypeVideo",
            data:{"typeName" : $span_two},
            type:"post",
            dataType:"json",
            success:function (ret) {
                // alert(ret)
                window.location.href="videoshow.html";
            }

        });
    });

    //实现用户退出及销毁session及跳转登录页
    $("#index_user_exit_button").click(function () {
        $.ajax({
            url:"/DestroySession",
            type:"post",
            dataType:"json",
            success:function (ret) {
                if (ret=="1"){
                    window.location.href="login.html";
                }
            }
        });
    });

    //只单击一级菜单实现跳转页面
    $(".header_list_name").click(function () {
        var $div_one = $(this).html();
        // alert($div_one);
        $.ajax({
            url:"/TakeTypeOneVideo",
            data:{"typeName":$div_one},
            type:"post",
            dataType:"json",
            success:function () {
                window.location.href="videoshow.html";
            }
        });
    });

//   模糊搜索
    $(".header_search_submit").click(function () {
        var $content = $(".header_search_keyword").val();
        // alert($content);
        $.ajax({
            url:"/TakeMoHuList",
            data:{"videoName":$content},
            type:"post",
            dataType:"json",
            success:function (ret) {
                window.location.href="videoshow.html";
            }
        });
    });




});