$(function () {
    //ajax实现一二级菜单跳转页面
    $(".header_list_hidden").children().click(function () {
        //获取二级菜单内容
        var $span_two =  $(this).children().children().html();
        alert($span_two);
        //获取一级菜单内容
        var $div_one = $(this).parent().prev().children("div:eq(1)").html();
        alert($div_one);
        $.ajax({
            url:"",
            data:{"typeone":$div_one,"typetwo":$span_two},
            type:"post",
            dataType:"json",
            success:function (list) {
                window.location.href="videoshow.html";
            //
                for (var i =0;i<list.length;i++){
                    var $node = $('');
                }
            }

        });
    });
    
    $(".header_list_name").click(function () {
        var div_one = $(this).html();
        alert(div_one);

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