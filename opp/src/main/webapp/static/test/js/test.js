/**
* @author srj
* 2016-03-22
*/

/*===================global variable start===========*/

/*--------------------global variable end------------*/

$(function(){
    var options = {
        beforeSubmit : validate,
        success : sucFunction,
        dataType : 'json'
    }
    $('#myForm').ajaxForm(options);
});


/*
 * validate: 表单提交前的验证函数
 *
 * return : true
 *
 * params : formData,jqForm,options
 */
function validate(formData,jqForm,options){
    for(var i = 0; i< formData.length ; i++){
        if(!formData[i].value){
            alert('用户名、地址和自我介绍不能为空！');
            return false;
        }
    }
    var queryString = $.param(formData);
    return true;
}

/*
 * sucFunction: 表单提交成功后的回调函数
 *
 * return : void
 *
 * params : void
 */
function sucFunction() {

}