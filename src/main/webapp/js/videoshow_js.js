$(function () {
    // alert(1);
    $.ajax({
        url: "/ShowTypeTwoVideo",
        // data:""
        type: "post",
        dataType: "json",
        success: function (list) {
            // alert(list.length+1);
            // alert(4);
            for (var i = 0; i < list.length; i++) {
                // alert(list[1].videoId + "8888888888888888888");
                var $node = $('<div class="video_show_list" value="' + list[i].videoId + '">\n' +
                    '                <div class="video_show_list_images">\n' +
                    '                    <img src="'+list[i].videoImage+'" class="video_show_list_image"></div>\n' +
                    '                <p class="video_show_list_title">' + list[i].videoName + '</p>\n' +
                    '                <div class="video_show_list_data">\n' +
                    '                    <span class="video_show_list_click"><i class="video_show_list_data_icon"></i>'+list[i].videoClick+'</span>\n' +
                    '                    <span class="video_show_list_review"><i class="video_show_list_data_icon"></i>'+list[i].videoBoom+'</span>\n' +
                    '                </div>\n' +
                    '        </div>');
                $("#video_show_lists").append($node);
            }
        }

    })

    //    实现选定视频跳转播放页
    $("body").on("click", ".video_show_list", function () {
        // alert($(this).attr("value"));
        var bfl = $(this).attr("value");
        $.ajax({
            url: "/TakeVideoUrl",
            data:{"videoId" : bfl},
            type: "post",
            dataType: "json",
            success: function (ret) {
                // alert(ret);
                // window.location.href = "review.html";
                //实现播放量id的传递
                $.ajax({
                    url:"/ClickAdd",
                    data:{"videoId" : bfl},
                    type:"post",
                    dataType:"json",
                    success:function () {
                        // alert(bfl);
                        // alert(ret);
                        window.location.href = "review.html";
                    }
                })
            }
        })

    })




})

