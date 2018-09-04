$(function () {
    $.ajax({
        url:"",
        // data:""
        type:"post",
        dataType:"json",
        success:function (list) {
            for (var i =0;i<list.length;i++){
                var $node = $('<div class="video_show_list">\n' +
                    '            <a href="" target="_blank" class="video_show_list_a">\n' +
                    '                <div class="video_show_list_images">\n' +
                    '                    <img src="image/video_show_list_image1.webp" class="video_show_list_image">\n' +
                    '                </div>\n' +
                    '                <p class="video_show_list_title">【综漫/核爆/高燃/多素材AMV】神之战歌，响彻天地; 十年之战，即将重现！</p>\n' +
                    '                <div class="video_show_list_data">\n' +
                    '                    <span class="video_show_list_click"><i class="video_show_list_data_icon"></i>2.5万</span>\n' +
                    '                    <span class="video_show_list_review"><i class="video_show_list_data_icon"></i>185</span>\n' +
                    '                </div>\n' +
                    '            </a>\n' +
                    '        </div>');
                $("#video_show").append($node);
            }

        }
    });

//    实现选定视频跳转播放页
    $("body").on("click",".video_show_list",function () {

        $.ajax({
            url:"",
            // data:""
            type:"post",
            dataType:"json",
            success:function () {
                window.location.href="review.html";
            }
        });
    });
});