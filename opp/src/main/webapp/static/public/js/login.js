/**
 * Created by lrnovo on 2015/11/14.
 */

//function showTag(tagName){  //���ܵ�ǰָ��ָ��ı�ǩ��¼����ע��
//
//        document.getElementById("div_login").style.display="none";
//        document.getElementById("tag_login").style.background="#CCCCCC";
//        document.getElementById("tag_login").style.opacity="0.3";
//        document.getElementById("div_register").style.display="none";
//        document.getElementById("tag_register").style.background="#CCCCCC";
//        document.getElementById("tag_register").style.opacity="0.3";
//
//    var tag=document.getElementById("tag_"+tagName);  //��ʾ�ñ�ǩ��Ӧ������
//    tag.style.background="#000000";
//    var tagContent=document.getElementById("div_"+tagName);
//    tagContent.style.display="block";
//}

function getnumberchange(number){
    var xmlhttp;
    if(number.length==0){
        document.getElementById("showStudentMistake").innerHTML="";
        return;
    }
    if(window.XMLHttpRequest){
        xmlhttp=new XMLHttpRequest();
    }
    else{
        xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
    }
    xmlhttp.onreadystatechange=function(){
        if(xmlhttp.readyState==4&&xmlhttp.status==200){
            document.getElementById("showStudentMistake").innerHTML=xmlhttp.responseText;
        }
    }
    xmlhttp.open("GET","changenumber.do?number="+number,true);
    xmlhttp.send();
}
function getusernamechange(username){
    var xmlhttp;
    if(username.length==0){
        document.getElementById("showMistake").innerHTML="";
        return;
    }
    if(window.XMLHttpRequest){
        xmlhttp=new XMLHttpRequest();
    }
    else{
        xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
    }
    xmlhttp.onreadystatechange=function(){
        if(xmlhttp.readyState==4&&xmlhttp.status==200){
            document.getElementById("showMistake").innerHTML=xmlhttp.responseText;
        }
    }
    xmlhttp.open("GET","changeusername.do?username="+username,true);
    xmlhttp.send();
}