$(function() {
    var $addBtn = $('#addBtn'); //添加小标签分类按钮
    var $addDiv = $('#newTagDiv'); //安放添加的小标签分类的div
    var $edit = $('.fa-pencil'); //标签分类编辑图标按钮
    var $cancel = $('.newTag .fa-close'); //编辑状态下的取消按钮图标
    var $tagRow = $('.newTag'); //小标签分类
    var $replaceDiv =
        '<i class="fa fa-check"></i><i class="fa fa-close"></i>'; //点击编辑图标出现的保存/取消图标按钮
    var $replacedDiv =
        '<i class="fa fa-trash"></i><i class="fa fa-pencil"></i>'; //非编辑状态下小标签分类旁边的删除/编辑图标按钮

    var $inputDiv = '<input class="editTag" type="text"/>'; //小分类编辑input框
    var $tagDiv = '<span></span>'; //标签小分类

    //添加小分类按钮事件
    $addBtn.on('click', function() {
        var $inputLittleTag = $('#sequenceClassify').val();
        var addHtml = '<p class="newTag"><span class="newAdd">' +
            $inputLittleTag +
            '</span><span class="opt"><i class="fa fa-trash"></i><i class="fa fa-pencil"></i></span></p>';
        if ($inputLittleTag != '') {
            $addDiv.append(addHtml);
        } else {
            return false;
        }
    });

    //点击垃圾箱删除小分类
    $addDiv.on('click', '.fa-trash', function() {
        var $removeDiv = $(this).parents('.newTag');

        layer.confirm("确认删除分类？", {
            skin: 'layui-layer-molv',
            area: ['300px', '200px'],
            title: '删除提示',
            shade: 0.6,
            moveType: 1,
            shift: 1,
        }, function(index) {
            $removeDiv.remove();
            layer.close(index);
        });
    });

    //点击编辑图标进行小标签分类编辑
    preTagName = []; //全局数组储存input框原本的值，供取消编辑后还原原来的值用
    $addDiv.on('click', '.fa-pencil', function() {
        var $replaced = $(this).parent('.opt');
        var $editTag = $replaced.prev();
        var $tagName = $editTag.text();
        var index = $(this).parents('.newTag').index();
        preTagName[index] = $tagName;
        $editTag.html($inputDiv);
        $replaced.html($replaceDiv);
        $replaced.siblings().find(".editTag").val($tagName);
    });

    //点击取消编辑按钮还原数据以及原编辑/删除图标
    $addDiv.on('click', '.fa-close', function() {
        var $replaced = $(this).parent(
            '.opt');
        var $editTag = $replaced.prev();
        var index = $(this).parents('.newTag').index();

        $editTag.html(preTagName[index]);
        $replaced.html($replacedDiv);
    });

    //点击保存编辑按钮保存数据
    $addDiv.on('click', '.fa-check', function() {
        var $replace = $(this).parent('.opt');
        var $editTag = $replace.prev();
        var $newTag = $editTag.find('input').val(); //新输入的值

        if (!$editTag.hasClass('newAdd')) {
            $editTag.addClass('newAdd');
        }

        $editTag.html($newTag);
        $replace.html($replacedDiv);
    })

    //点击清除按钮清除所有编辑项
    $("#reset").click(function() {
        $(".newAdd").parent('.newTag').remove();
    });

    $('#newTagDiv').perfectScrollbar(); //小标签容器滚动条

});
