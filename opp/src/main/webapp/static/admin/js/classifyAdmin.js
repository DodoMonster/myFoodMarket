/**
 * @author DodoMonster
 * 2016-03-22
 */

/*===================global variable start===========*/

preBigTagName = []; //全局数组存储取消编辑时未进行修改的大分类
preSmallTagName = []; //全局数组存储编辑前未进行修改的小分类
tagTotalNum = 0; //一个大分类div下所存在的小标签分类个数

/*--------------------global variable end------------*/

$(function() {
    var $itemsI = $(".classify-items i"); //分类小标签右上角小图标
    var $editBtn = $('.edit'); //编辑图标按钮
    var $cancelBtn = $('.cancel-btn'); //取消编辑按钮
    var $confirmBtn = $('.save-btn'); //保存编辑按钮
    var $delBigTag = $('.delete-big-tag'); //删除按钮
    var $addBtn = $('.plus'); //添加大分类按钮
    var $itemTags = $('.little-tag-name'); //小分类标签
    var $newLittleTagName =
        '<input class="input-little-tag" />'; //代替原小分类span标签的input代码

    $('.classify-items').perfectScrollbar(); //小标签容器滚动条

    /*--- 点击编辑按钮事件 ---*/
    $editBtn.on('click', function() {

        var $tagUl = $(this).parents('.content-header').next('.classify-items');//获取未修改的小分类标签块

        $tagUl.sortable({revert: true,opacity: 0.7});
        //提示层
        layer.msg('可拖动小标签进行排序', {time: 2000,area: ['200px', '100px']});

        /* 显示小标签右上角的删除图 */
        $(this).parent('span.opt').hide(50).next('div.opt-btn').show(300).end().parents(".content-header").next().find('i.fa-close').show(400);

        /* 把此分类下未修改前所有的小分类存进全局数组 */
        var $bigTag = $(this).parent('.opt').prev('.classify-name').text(); //修改前总分类标签
        var $smallTag = $(this).parents('.content-header').next('ul.classify-items').html(); //修改前小分类的标签html代码
        var $index = $(this).parents('.items-wrapper').index(); //获取一整个大分类div的index

        preBigTagName[$index] = $bigTag; //把该index大分类下把该大分类名存进对应index的数组内
        preSmallTagName[$index] = $smallTag; //把该index大分类下所有的小分类html代码作为一个元素存进对应index数组中

        /* 把classification-name的span变为input */
        var $prevName = $(this).parents().siblings(".classify-name"); //获取未修改的大分类标签块
        var $name = $prevName.text(); //获取未修改的大分类名
        var $newNameHtml = '<input class="input-name" />'; //代替原大分类span标签的input代码
        $prevName.html($newNameHtml).children('input').val($name); //input代替span并把原本的span标签内的分类名赋值给input

        /* 把classify-items每个小标签都变为input */
        var $classifyItems = $tagUl.find('.little-tag-name');
        // var $newLittleTagName =
        //     '<input class="input-little-tag" />'; //代替原小分类span标签的input代码
        $classifyItems.each(function() {
            var $littleTagName = $(this).text(); //获取未修改的小分类标签块的html代码
            $(this).html($newLittleTagName).children('.input-little-tag').val($littleTagName); //input代替span并把原本的span标签内的分类名赋值给input
        });
    });

    /*--- 点击取消编辑按钮事件 ---*/
    $cancelBtn.on('click', function() {

        var $nowIndex = $(this).parents('.items-wrapper').index(); //获取当前点击的大分类div的index

        var $tagUl = $(this).parents('.content-header').next('.classify-items');//获取未修改的小分类标签块

        $tagUl.sortable('destroy'); //销毁元素可移动拖拉排序

        /* 把大分类的input变为span并把数据恢复到未修改前 */
        var $prevBigName = $(this).parents('.opt-btn').siblings(".classify-name")
        var $bigName = preBigTagName[$nowIndex];

        $prevBigName.html($bigName);

        /* 把小分类的input变为span隐藏删除小图标按钮并把数据恢复到未修改前 */
        var $prevSmallName = $(this).parents('.content-header').next();
        var $smallName = preSmallTagName[$nowIndex];

        $prevSmallName.html($smallName);
        $(this).parents(".opt-btn").hide(50).siblings('.opt').show(300).parent('.content-header')
        .next('ul.classify-items').find('i.fa-close').hide(10);
    });

    /*--- 点击保存按钮 ---*/
    $confirmBtn.click(function() {

        var $mainTag = $(this).parent().siblings('.classify-name'); //获取修改的主分类span
        var $mainTagName = $mainTag.children('.input-name').val(); //获取修改的主分类名
        var $mainTagId = $mainTag.attr('id'); //获取修改的主分类id

        var $tagUl = $(this).parents('.content-header').next('.classify-items'); //获取未修改的小分类标签块所在的ul
        var $optDiv = $(this).parent(".opt-btn"); //获取保存取消所在的父元素

        var flag = true;

        if ($mainTagName == '') { //判断主分类是否为空
            layer.msg('主分类不能为空！');
        } else {
            var $subNavLi = $(this).parents('.content-header').next('ul.classify-items').find('li');
            var IdArray = []; //定义保存子分类id的数组
            var nameArray = []; //定义保存子分类名字的数组
            $subNavLi.each(function(i) {
                $subId = $(this).find('.little-tag-name').attr('id'); //获取子分类的id
                $subName = $(this).find('.input-little-tag').val(); //获取子分类的名字
                if ($subName == '') {
                    layer.msg('子分类不能为空！');
                    flag = false;
                    return false;
                } else {
                    IdArray[i] = $subId;
                    nameArray[i] = $subName;
                }
            });

            idArrayJSON = JSON.stringify(IdArray);
            nameArrayJSON = JSON.stringify(nameArray);
            if (flag) {
                $.ajax({
                    url: '/admin/NavAction/modifyMainNav',
                    type: 'GET',
                    data: {
                        "id": $mainTagId,
                        "name": $mainTagName,
                        "subId": idArrayJSON,
                        "subName": nameArrayJSON
                    },
                    dataType: 'JSON',
                    beforeSend: showLoadTips(),
                    success: function(data) {
                        layer.close(loadIndex);
                        $tagUl.sortable('destroy'); //销毁元素可移动拖拉排序
                        $mainTag.html($mainTagName); //把修改后的主分类名写入html
                        $subNavLi.each(function(i) { //把小标签分类input框变为span并把修改后的分类名插进去
                            $subTag = $(this).find('.little-tag-name');
                            var aTag ='<a href="javascript:;"></a>';
                            $subTag.html(aTag).find('a').attr('title',nameArray[i]).text(nameArray[i]).end().siblings('i.fa-close').hide(5);

                        });
                        $optDiv.hide(5).siblings(
                            '.opt').show(50); //隐藏保存编辑按钮显示编辑添加删除按钮
                        layer.msg('编辑保存分类成功！',
                                {area: ['200px','100px'],
                                time: 2000
                            });
                    },
                    error: function() {
                        alert("异常！");
                    },
                });
            } else {
                alert("输入的内容不符合格式，请重新检查！");
            }
        }
    });

    /*--- 删除小分类 ---*/
    $(".classify-items").on("click", '.fa-close', function() {
        $delLi = $(this).parent('li'); //获取点击的小标签所在的li
        $thisId = $delLi.find('.little-tag-name').attr('id'); //获取要删除的子分类的id
        layer.confirm("确认删除分类？", {
            skin: 'layui-layer-molv',
            area: ['300px', '200px'],
            title: '删除提示',
            shade: 0.6, //遮罩透明度
            moveType: 1, //拖拽风格，0是默认，1是传统拖动
            shift: 1, //0-6是动画形式，-1不开启
        }, function(index) {
            $.ajax({
                url: '/admin/NavAction/deleteSubNav',
                type: 'GET',
                data: {
                    "id": $thisId
                },
                beforeSend: showLoadTips(),
                success: function(data) {
                    layer.close(loadIndex);
                    layer.close(index);
                    if (data == "1") {
                        $delLi.remove();
                        layer.msg('删除子分类成功！', {
                                area: ['200px','100px'],
                                time: 2000
                            });
                    } else {
                        view(data.msg);
                    }
                },
                error: function() {
                    alert("网络异常！删除失败");
                }
            });
        });
    });

    /*--- 添加小分类 ---*/
    $addBtn.on("click", function() {
        var $addLi = $(this).parents('.content-header').next('ul');
        var $mainNavId = $addLi.prev().find('.classify-name').attr('id'); //获取要增加到的主类

        layer.open({
            title: '新增子分类',
            skin: 'layui-layer-molv',
            content: '<input class="add-new-tag"/>',
            btn: ['确定', '取消'],
            yes: function(index) {
                var $newTag = $('.add-new-tag').val();
                var $newTagBorder = $('<li><span class="little-tag-name"><a href="javascript:;" class="new">' +
                    $newTag +'</a></span><i class="fa fa-close"></i></li>');
                $.ajax({
                    url: '/admin/NavAction/addSubNav',
                    type: 'GET',
                    data: {
                        "name": $newTag,
                        "mainNavId": $mainNavId
                    },
                    dataType: 'JSON',
                    beforeSend: showLoadTips(),
                    success: function(data) {
                        layer.close(loadIndex);
                        $addLi.append($newTagBorder).find(".new").attr('title',$newTag).removeClass('new');
                        var $mainNavId =$addLi.prev().find('.classify-name').attr('id',data);
                        layer.msg('子分类添加成功！', {
                                area: ['200px','100px'],
                                time: 2000
                            });
                    },
                    error: function() {
                        alert("异常！");
                    },
                });
                layer.close(index);
            },
            cancel: function(index) {
                layer.close(index);
            }
        });
    });

    /*--- 删除大分类div ---*/
    $delBigTag.on("click", function() {
        var $thisId = $(this).parents('.opt').prev().attr('id');
        var $tagDiv = $(this).parents(".items-wrapper");
        layer.confirm("确认删除分类？", {
            skin: 'layui-layer-molv',
            area: ['300px', '200px'],
            title: '删除提示',
            shade: 0.6, //遮罩透明度
            moveType: 1, //拖拽风格，0是默认，1是传统拖动
            shift: 1, //0-6是动画形式，-1不开启
        }, function(index) {
            layer.close(index);
            $.ajax({
                url: '/admin/NavAction/deleteMainNav',
                type: 'GET',
                data: {
                    "id": $thisId
                },
                dataType: 'JSON',
                beforeSend: showLoadTips(),
                success: function(data) {
                    layer.close(loadIndex);
                    if (data == "1") {
                        $tagDiv.remove();
                        layer.msg(
                            '删除主分类成功！', {
                                area: ['200px','100px'],
                                time: 2000
                            });
                    } else {
                        view(data.msg);
                    }
                },
                error: function() {
                    alert("网络异常！删除失败");
                }
            });
        });
    });

    /*--- 点击拖拉按钮启动拖拉主分类 ---*/
    $('#dragSort').on("click", '#dragBtn', function() {
        $(this).hide().siblings('#sortOpt').show();
        layer.msg('可以拖动各主分类框进行排序！', {
            area: ['300px', '100px'],
            time: 2000
        });

        //拖动主分类进行排序
        $('#itemsContainer').sortable({
            revert: true,
            opacity: 0.7,
            // cancel: "div.items-wrapper"
        });

        // $preSequence = $(this).parents('#dragSort').siblings(
        //     '#itemsContainer').html(); //获取排序前的顺序html代码
    });

    /*--- 点击取消拖拉排序事件恢复原顺序 ---*/
    $('#cancelDrag').on("click", function() {
        $('#sortOpt').hide().siblings('#dragBtn').show(); //显示拖拉按钮，隐藏保存取消按钮
        $('#itemsContainer').sortable('destroy'); //销毁拖拉
        window.location.reload();
    });

    /*--- 点击保存拖拉排序事件发起ajax请求 ---*/
    $('#confirmDrag').on("click", function() {
        var sortIDs = $('#itemsContainer').sortable("toArray");

        $('#itemsContainer').sortable('destroy'); //禁止拖拉

        var idJSON = JSON.stringify(sortIDs);

        $.ajax({
            url: '/admin/NavAction/modifyMainSequence',
            type: 'GET',
            data: {"mainNavId": idJSON},
            dataType: 'JSON',
            beforeSend: showLoadTips(),
            success: function(data) {
                layer.close(loadIndex);

                if (data == "1") {
                    $('#sortOpt').hide().siblings('#dragBtn').show();
                    $('#itemsContainer').sortable("refresh");
                    layer.msg('重新排序成功！', {
                            area: ['300px','100px'],
                            time: 2000
                        });
                } else {
                    view(data.msg);
                }
            },
            error: function() {
                alert("网络异常！排序失败");
            }
        });

    });

    $('.classify-items').perfectScrollbar(); //小标签容器滚动条

    /*发起ajax请求提示加载信息*/
    function showLoadTips() {
        loadIndex =layer.load(0, {shade: false}); //0代表加载的风格，支持0-2
    }

    /*---小标签字数过长（>4）中间用省略号表示---*/
    // function showEllipsis() {
    //     var $maxLen = 4;
    //     $itemTags.each(function() {
    //         var $thisText = $(this).text();
    //         var $wordLen = $thisText.length;
    //         if ($wordLen > $maxLen) {
    //             $showWord = $thisText.substring(0, 1) + '...' +
    //                 $thisText.substring($wordLen - 1, $wordLen);
    //             $(this).html($showWord);
    //         }
    //     });
    // }
    // showEllipsis();
});
// function showTips(el) {
//     layer.confirm("确认删除分类？", {
//         skin: 'layui-layer-molv',
//         area: ['300px', '200px'],
//         title: '删除提示',
//         shade: 0.6, //遮罩透明度
//         moveType: 1, //拖拽风格，0是默认，1是传统拖动
//         shift: 1, //0-6是动画形式，-1不开启
//     }, function(index) {
//         ele.remove();
//         layer.close(index);
//     });
// }
