$(function () {
    //ajax实现一二级菜单跳转页面
    $(".header_list_hidden").children().click(function () {
        //获取二级菜单内容
        var $span_two =  $(this).children().children().html();
        alert($span_two);
        //获取一级菜单内容
        var $div_one = $(this).parent().prev().children("div:eq(1)").html();
        $.ajax({
            url:"/TakeTypeVideo",
            data:{"typeName" : $span_two},
            type:"post",
            dataType:"json",
            success:function (ret) {
                alert(ret)
                window.location.href="videoshow.html";
            }

        });
    });

    //只单击一级菜单实现跳转页面
    $(".header_list_name").click(function () {
        var $div_one = $(this).html();
        alert($div_one);
        $.ajax({
            url:"",
            data:{"typeone":$div_one},
            type:"post",
            dataType:"json",
            success:function () {
                window.location.href="videoshow.html";
            }
        });
    });



});