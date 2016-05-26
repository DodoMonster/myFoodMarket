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
    var $itemEven = $('.items-wrapper:even'); //分类index为偶数的div
    var $itemOdd = $('.items-wrapper:odd'); //分类index为偶数的div
    var $editBtn = $('.edit'); //编辑图标按钮
    var $cancelBtn = $('.cancel-btn'); //取消编辑按钮
    var $confirmBtn = $('.save-btn'); //保存编辑按钮
    var $delBigTag = $('.delete-big-tag'); //删除按钮
    var $addBtn = $('.plus'); //添加大分类按钮
    var $itemTags = $('.little-tag-name'); //小分类标签
    // var $tagContainer = $('.classify-items li') //小分类标签所在的li容器

    $itemEven.css({
        "margin-left": "40px",
        "margin-right": "40px"
    }); //浮动的div左右居中
    $itemOdd.css({
        "margin-left": "40px",
        "margin-right": "40px"
    }); //使分类index为奇数的div左浮动


    /*--- 点击编辑按钮事件 ---*/
    $editBtn.on('click', function() {

        var $tagUl = $(this).parents('.content-header') //获取未修改的小分类标签块
            .next('.classify-items')
        var tagUl = $tagUl[0];
        new Sortable(tagUl); //可拖动小标签排序
        //提示层
        layer.msg('可拖动小标签进行排序', {
            time: 2000,
            area: ['200px', '100px']
        });

        /* 显示小标签右上角的删除图 */
        $(this).parent('span.opt').hide(50).next('div.opt-btn')
            .show(
                300).end().parents(".content-header").next()
            .find(
                'i.fa-close').show(400);

        /* 把此分类下未修改前所有的小分类存进全局数组 */
        var $bigTag = $(this).parent('.opt').prev(
            '.classify-name').text(); //修改前总分类标签
        var $smallTag = $(this).parents('.content-header').next(
            'ul.classify-items').html(); //修改前小分类的标签html代码
        var $index = $(this).parents('.items-wrapper').index(); //获取一整个大分类div的index

        preBigTagName[$index] = $bigTag; //把该index大分类下把该大分类名存进对应index的数组内
        preSmallTagName[$index] = $smallTag; //把该index大分类下所有的小分类html代码作为一个元素存进对应index数组中

        /* 把classification-name的span变为input */
        var $prevName = $(this).parents().siblings(
            ".classify-name"); //获取未修改的大分类标签块
        var $name = $prevName.text(); //获取未修改的大分类名
        var $newNameHtml = '<input class="input-name" />'; //代替原大分类span标签的input代码
        $prevName.html($newNameHtml).children('input').val(
            $name); //input代替span并把原本的span标签内的分类名赋值给input

        /* 把classify-items每个小标签都变为input */
        var $classifyItems = $tagUl.find('.little-tag-name');
        var $newLittleTagName =
            '<input class="input-little-tag" />'; //代替原小分类span标签的input代码
        $classifyItems.each(function() {
            var $littleTagName = $(this).text(); //获取未修改的小分类标签块的html代码
            $(this).html($newLittleTagName).children(
                '.input-little-tag').val(
                $littleTagName); //input代替span并把原本的span标签内的分类名赋值给input
        });
    });

    /*--- 点击取消编辑按钮事件 ---*/
    $cancelBtn.click(function() {

        var $nowIndex = $(this).parents('.items-wrapper').index(); //获取当前点击的大分类div的index
        /* 把大分类的input变为span并把数据恢复到未修改前 */
        var $prevBigName = $(this).parents('.opt-btn').siblings(
            ".classify-name")
        var $bigName = preBigTagName[$nowIndex];

        $prevBigName.html($bigName);

        /* 把小分类的input变为span隐藏删除小图标按钮并把数据恢复到未修改前 */
        var $prevSmallName = $(this).parents('.content-header')
            .next();
        var $smallName = preSmallTagName[$nowIndex];

        $prevSmallName.html($smallName);
        $(this).parents(".opt-btn").hide(50).siblings('.opt').show(
            300).parent('.content-header').next(
            'ul.classify-items').find(
            'i.fa-close').hide(10);
    });

    /*--- 点击保存按钮 ---*/
    $confirmBtn.click(function() {

    });

    /*--- 删除小分类 ---*/
    $(".classify-items").on("click", '.fa', function() {
        $delLi = $(this).parent('li'); //获取点击的小标签所在的li
        layer.confirm("确认删除分类？", {
            skin: 'layui-layer-molv',
            area: ['300px', '200px'],
            title: '删除提示',
            shade: 0.6, //遮罩透明度
            moveType: 1, //拖拽风格，0是默认，1是传统拖动
            shift: 1, //0-6是动画形式，-1不开启
        }, function(index) {
            $delLi.remove();
            layer.close(index);
        });
    });

    /*--- 添加小分类 ---*/
    $addBtn.on("click", function() {
        var $addLi = $(this).parents('.content-header').next(
            'ul');
        layer.open({
            title: '新增分类',
            skin: 'layui-layer-molv',
            content: '<input class="add-new-tag"/>',
            btn: ['确定', '取消'],
            yes: function(index) {
                var $newTag = $('.add-new-tag').val();
                var $newTagBorder = $(
                    '<li><span class="little-tag-name">' +
                    $newTag +
                    '</span><i class="fa fa-close "></i></li>'
                );
                $addLi.append($newTagBorder);
                layer.close(index);
            },
            cancel: function(index) {
                layer.close(index);
            }
        });
    });

    /*--- 删除大分类div ---*/
    $delBigTag.on("click", function() {
        var $tagDiv = $(this).parents(".items-wrapper");
        layer.confirm("确认删除分类？", {
            skin: 'layui-layer-molv',
            area: ['300px', '200px'],
            title: '删除提示',
            shade: 0.6, //遮罩透明度
            moveType: 1, //拖拽风格，0是默认，1是传统拖动
            shift: 1, //0-6是动画形式，-1不开启
        }, function(index) {
            $tagDiv.remove();
            layer.close(index);
        });
    });



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
