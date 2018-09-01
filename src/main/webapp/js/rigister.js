
$.validator.addMethod("mobile", function(value, element) {
    var length = value.length;
    var mobile =  /^(((13[0-9]{1})|(15[0-9]{1}))+\d{8})$/
    return this.optional(element) || (length == 11 && mobile.test(value));
}, "请输入正确的手机号码");

$(function () {
        $("form").validate({
            onsubmit: true,//是否在提交时验证
            onfocusout: true,//是否在获取焦点时验证
            onkeyup: true,//是否在敲击键盘时验证

            rules: {
                username: {
                    required: true
                },
                phone: {
                    required: true,
                    mobile:true
                },
                password:{
                    required:true,
                    minlength:6,
                    maxlength:20
                },
                repassword:{
                    required:true,
                    equalTo:"#password"
                },
            },
            messages: {
                username: {
                    required: "用户名不能为空"
                },
                phone: {
                    required: "手机号不能为空"
                },
                password:{
                    required:"密码不能为空",
                    minlength:"密码长度不能小于6位",
                    maxlength:"密码长度不能大于20位"
                },
                repassword:{
                    required: "请确认密码",
                    equalTo: "两次密码输入不一致"
                }
            },
            submitHandler:function (form) {
                $.ajax({
                    url: "/insertUserInfo",
                    type: "post",
                    dataType: "json",
                    data:{
                        "username":$("input[name='username']").val(),
                        "phone":$("input[name='phone']").val(),
                        "password":$("input[name='password']").val()
                    },
                    success:function (ret) {
                        if(ret=="1"){
                            layer.msg('注册成功',{time:1000},function () {
                                window.location.href = "login.html";
                            });
                        }
                    }
                });
            },
            invalidHandler:function (form,validator) {
                return false;
            }
        });
})

