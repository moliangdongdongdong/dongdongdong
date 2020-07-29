<!-- 点击验证码图片随机再次生成图片 -->
function change(img) {
    img.src = "getcode?" + new Date().getTime();
}

//设置一个标记位
var flag = true;

<!-- 鼠标焦点事件 鼠标获得焦点方法 清除后面的class：error中的提示文字 -->
function FocusItem(object) {
    if ($(object).attr('name') == 'veryCode') {
        $(object).next().next().html('').removeClass('error');
    } else {
        $(object).next('span').html('').removeClass('error');
    }
}

<!-- 鼠标焦点事件 鼠标失去焦点方法 -->
function CheckItem(object) {
    let msgBox = $(object).next('span');

    switch ($(object).attr('name')) {
        case  "userName":
            if (object.value == "") {
                msgBox.html('用户名不能为空');
                msgBox.addClass('error');
                flag = false;
            } else {
                //用ajax异步请求，验证id是不是唯一
                var url = "usernamecheck?name=" + encodeURI($(object).val()) + "&" + new Date().getTime();//设置url地址
                //"false"这个id不能使用，“true”这个id可以使用
                $.get(url, function (data) {
                    //判断id是不是可以使用
                    if(data == "false"){
                        //不能使用
                        msgBox.html('用户名已存在');
                        msgBox.addClass('error');
                        flag = false;
                    }else{
                        //可以使用的话，就把提示语删除
                        msgBox.html('').removeClass('error');
                        flag = true;
                    }
                });
            }
            break;
        case  "passWord":
            if (object.value == "") {
                msgBox.html('密码不能为空');
                msgBox.addClass('error');
                flag = false;
            }else{
                flag = true;
            }
            break;
        case  "rePassWord":
            if (object.value == "") {
                msgBox.html('确认密码不能为空');
                msgBox.addClass('error');
                flag = false;
            } else if ($(object).val() != $('input[name = "passWord"]').val()) {
                msgBox.html('输入的密码不一致');
                msgBox.addClass('error');
                flag = false;
            }else{
                flag = true;
            }
            break;
        case  "mobile":
            if (object.value == "") {
                msgBox.html('手机号码不能为空');
                msgBox.addClass('error');
                flag = false;
            }else{
                flag = true;
            }
            break;
        case  "address":
            if (object.value == "") {
                msgBox.html('送货地址不能为空');
                msgBox.addClass('error');
                flag = false;
            }else{
                flag = true;
            }
            break;
        case  "veryCode":
            var numshow = $(object).next().next();
            if (object.value == "") {
                numshow.html('验证码不能为空');
                numshow.addClass('error');
                flag = false;
            }else{
                var url = "checkusernum?num=" + encodeURI($(object).val()) + "&" + new Date().getTime();
                $.get(url,function (data) {
                    if(data == 'false'){
                        numshow.html('验证码输入有误');
                        numshow.addClass('error');
                        flag = false;
                    }else{
                        numshow.html('').removeClass('error');
                        flag = true;
                    }
                });
            }
            break;

    }
}

<!-- 检查表单，为true可以注册跳转，为false不能注册 -->
function checkForm(frm) {
    var els = frm.getElementsByTagName('input');

    //获取input表单中有onblur属性的

    for(var i = 0; i < els.length; i++){
        if(els[i] != null){
            if(els[i].getAttribute("onblur")){
                CheckItem(els[i]);
            }
        }
    }

    return flag;
}