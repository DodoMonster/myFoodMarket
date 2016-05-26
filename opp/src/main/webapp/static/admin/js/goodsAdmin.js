/*
 *
 *@author DodoMonster(dodomonster@qq.com)
 *2016-03-29
 *
 */
/*===================global variable start===========*/

$thisSubNav = ' '; //发起分页请求时需要传递的商品子分类
$thisShopSubNav = ''; //发起分页请求时需要传递的店铺子分类
$thisShopNav='';////发起分页请求时需要传递的店铺主分类

/*--------------------global variable end------------*/
$(function() {
    var $dropNavLi = $('.select-classiy-nav'); //商品分类的下拉框选择
    var $subNavLi = $('#mainNav li a'); //获取子分类侧边导航栏的li
    var $subNavDiv = $('.subNavDiv'); //获取右侧的子分类
    var $subNav = $('.subnav li'); //获取右侧子分类li
    var $closeSubNav = $('#subNav .glyphicon-remove'); //获取#subNav页面右上角的x按钮
    var subnavFlag = 0; //标识子分类模块是否显示0为隐藏，1为显示
    var $searchBox=$('#inputSearch');//搜索框
    var $searchBtn = $('#searchBtn'); //搜索按钮

    var $sortDiv = $('.subnav'); //获取标题分类div
    var $subNavDiv = $('.subNavDiv'); //获取装标题分类div的容器
    var $titleNode =
        '<div class="subnav"><p></p><ul></ul></div>'; //标题类型节点
    var $subTitleNode = '<li></li>'; //子类型列表节点
    var $classiyTitle = $('.classify-title'); //获取商品分类button
    var $mainNav=$('.mainNav');//全部主分类所在处
    var $allBtn=$('.all-btn');//全部主分类按钮

    var $tableTbody = $('#tableContainer tbody'); //获取装载数据的tabled body
    var $newTr =
        '<tr><td></td><td><img alt="商品图1"></td><td></td><td></td><td></td><td></td><td></td><td></td><td><span class="glyphicon glyphicon-remove delete-btn"></span>' +
        '<p><a href="#"><span class="glyphicon glyphicon-pencil edit-btn"></span></a><span class="checkbox"><span class="open-box"></span></span></p></td></tr>'; //新增td节点元素

    var $totalSpan = $('#totalNum'); //获取总条数容器
    var $pageSpan = $('#totalPage'); //获取总分页容器
    var $nowSpan = $('#nowPage'); //获取当前页数容器


    var $prevBtn = $('#prevBtn'); //前一页按钮
    var $nextBtn = $("#nextBtn"); //后一页按钮
    var $gotoBtn = $("#gotoBtn"); //到达输入页面的按钮

    /*
     * 点击下拉菜单显示子分类
     *
     * stpe1 : 对下拉菜单的li进行each()函数循环获取点击的index(i)以便在子分类div侧边导航栏对相应的主类添加active类
     *
     * step2 : 子分类div侧边导航栏对相应的主类添加active类以及去除之前因点击而对其他a添加的active
     *
     * step3 : 点击的主类对应的子分类显示而其余隐藏
     *
     * step4 : 子分类所在的一整块div显示（使用slideDown动画显示）
     */
    $dropNavLi.click(function() {
        if (subnavFlag === 0) { //当子分类没有在显示的时候
            $("#mainNav li:first-child").children('a').addClass('active').parent('li').siblings('li').find('a').removeClass('active');
            $subNavDiv.eq(0).show().siblings('.subNavDiv').hide();
            $('#subNav').slideDown(500);
            subnavFlag = 1;
        } else {
            $('#subNav').slideUp(500);
            subnavFlag = 0;
        }
    });

    /*
     * 点击主+子分类所在div的主分类显示对应的子分类
     *
     * step1 : 获取点击的主分类发送异步请求，接收包含该主分类的主性质以及属于该主性质的商品
     *
     * stpe2 : 异步请求成功后对主分类li进行each()函数循环获取点击的index(i)以便在子分类div侧边导航栏对相应的主类添加active类
     *
     * step3 : 点击的主类对应的子分类显示而其余隐藏
     *
     * step4 : 子分类div侧边导航栏对相应的主类添加active类以及去除之前因点击而对其他a添加的active
     *
     * step5 ：处理后台返回的数组把对应的类型插入到html文档
     */
    $subNavLi.each(function(i) {
        $(this).click(function() {
            var $thisNav = $(this).text(); //获取点击的主分类名
            $classiyTitle.text($thisNav); //把点击的主分类写入商品分类button中
            $.ajax({
                url: 'showClassify',
                type: 'GET',
                data: {navType: $thisNav},
                datatype: 'JSON',
                beforeSend: showLoadTips(), //显示加载图标
                success: function(data) {
                    layer.close(loadIndex); //关闭加载图标
                    $classiyTitle.text($thisNav); //把点击的主分类写入商品分类button中
                    $mainNav.text($thisNav);//把点击的主分类写入全部主分类button中
                    $(this).addClass('active').parent('li').siblings('li').find('a').removeClass('active'); //主分类导航active的变化

                    var dataLength = data.length; //获取数组的总长度

                    $subNavDiv.empty(); //清空子分类容器

                    for (var a = 0; a <dataLength; a++) {
                        $subNavDiv.append($titleNode); //添加标题分类div
                    }

                    $.each(data, function(index, item) { //循环遍历后台传回来的数组并进行数据插入
                        var $sort =$('.subnav').eq(index); //获取对应index下标的subnav
                        var $sortUl =$sort.find('ul'); //获取对应index下标的subnav下的列表
                        var $listLength = item.subNavList.length; //获取一个标题分类下的子分类长度

                        $sort.find('p').text(item.name); //把对应index下标的name插入进去

                        for (var i = 0; i < $listLength; i++) {
                            $sortUl.append($subTitleNode); //增加li节点
                            var $sortLi =$sortUl.find('li').eq(i);
                            $sortLi.attr("id",item.subNavList[i].id); //设置li的id属性
                            $sortLi.text(item.subNavList[i].name); //设置li的text属性
                        }
                    });
                },
                error: function(){
                    errorFun();
                }
            });

        });
    });

    /*
     * 点击全部主分类
     *
     * step1 : 获取点击的主分类名发送异步请求，接收包含该主分类的主性质以及属于该主性质的商品
     *
     * stpe2 : 异步请求成功后关闭下拉菜单，调用showData(data)函数把从后台获取到的数据插入到html文档中
     *
     */
    $allBtn.click(function(){
        var $thisNav=$mainNav.text();//获取全部主分类名
        $thisSubNav="";//清空子分类
        $searchBox.val("");//清空搜索框
        $thisSubNav="";//清空子分类id
        $classiyTitle.text($thisNav);
        $.ajax({
            url: 'find',
            type: 'GET',
            data: {navType: $thisNav},
            datatype: 'JSON',
            beforeSend: showLoadTips(), //显示加载图标
            success: function(data) {
                layer.close(loadIndex); //关闭加载图标
                $('#subNav').slideUp(500);
                showData(data);
            },
            error: function(){
                errorFun();
            }
        });
    });
    /*
     * 点击下拉分类菜单里的子分类处理函数
     *
     * step1 ：获取获取点击的子分类
     *
     * step2 ：发起ajax请求，发送点击的子分类给后台
     *
     * step3 ：清空table内的已有数据，然后处理后台返回的数组
     *
     */
     $subNavDiv.on('click','li',function(){
        $searchBox.val("");//清空搜索框
        $thisSubNav=$(this).attr("id");//获取点击的子分类
        $.ajax({
            url:'find',
            type:'GET',
            data:{subNavId:$thisSubNav},
            datatype:'JSON',
            beforeSend:showLoadTips(),
            success:function(data){
                layer.close(loadIndex);
                $nowSpan.text('1'); //使现在页数显示为1
                 $('#subNav').slideUp(500);
                showData(data);
            },
            error: function(){
                errorFun();
             }
        });
     });


    /*
     * 点击#subNav页面右上角的x关闭#subNav页面
     *
     */
    $closeSubNav.click(function() {
        $("#subNav").slideUp();
    });

    /*
     * 点击table行内的删除按钮删除对应商品
     *
     * stpe1 : 获取要删除的商品的ID
     *
     * step2 : 弹框给用户是否确定要删除该商品
     *
     * step3 : 点击确定则发起ajax请求删除该商品，取消则关闭该提示框
     */
    $tableTbody.on('click', '.delete-btn', function() {
        var $deletedTr = $(this).parents('tr'); //获取被删除的tr
        var $goodsId = $deletedTr.attr('id');
        layer.confirm('确认删除此商品吗？', {
            skin: 'layui-layer-molv',
            area: ['300px', '200px'],
            title: '删除商品提示',
            shade: 0.6,
            moveType: 1,
            shift: 2,
        }, function(index) {
            $.ajax({
                url: 'deleteCommodity',
                type: 'GET',
                data: {
                    commodityId: $goodsId
                },
                dataType: 'JSON',
                beforeSend: showLoadTips(),
                success: function(data) {
                    layer.close(loadIndex);
                    if (data == '1') {
                        $deletedTr.remove();
                        layer.close(index);

                        //重新发起ajax请求刷新数据//
                        var $nowPage = $nowSpan.text(); //获取当前页数
                        var $thisNav=$classiyTitle.text();//获取全部主分类名
                        var $shopId=" ";
                        var $searchText=$searchBox.val();//获取搜索框内的关键字
                        pageControl($nowPage,$shopId,$searchText,$thisSubNav,$thisNav);
                    }
                },
                error: function() {
                    errorFun();
                }
            });
        });
    });

    /*
     * 点击开关按钮函数
     *
     * stpe1 : 获取要删除的商品的ID
     *
     * step2 : 发起ajax请求开关该商品
     *
     */
    $tableTbody.on('click', '.checkbox', function() {
        var $switchBox = $(this).children('span');
        var flag = 1; //1为open，0为close
        var $goodsId = $(this).parents('tr').attr("id"); //商品id

        $.ajax({
            url: 'displayCommodity',
            type: 'GET',
            data: {
                commodityId: $goodsId,
                flag: flag
            },
            dataType: 'JSON',
            success: function(data) {
                if (data == '1') {
                    if ($switchBox.hasClass("open-box")) { //图片是open状态
                        flag = 0;
                        $switchBox.removeClass('open-box').addClass(
                            'close-box');
                    } else { //图片是close状态
                        flag = 1
                        $switchBox.removeClass('close-box').addClass(
                            'open-box');
                    }
                    layer.msg('商品显示状态修改成功！');
                }
            },
            error: function(){
                errorFun();
            }
        });
    });

    /*
     * 点击搜索按钮进行搜索
     *
     * step1 ：获取输入的要进行搜索文字
     *
     * step2 ：判断输入的内容是否为空，不为空时发起ajax请求，为空时则弹框提示
     *
     * step3 ：清空table内的已有数据，然后处理后台返回的数组
     *
     * step4 : 判断搜索到的条数是否需要分页，不需要分页则直接把搜索到的相关数据重新插入table内，需要分页则显示一页最多显示的条数
     */
    $searchBtn.click(function() {
        var $searchText = $searchBox.val(); //获取输入的商品/类
        $thisSubNav="";//清空子分类id
        if ($searchText) { //当搜索内容不为空时
            $.ajax({
                url: 'find',
                type: 'GET',
                data: {
                    name: $searchText
                },
                datatype: 'JSON',
                beforeSend: showLoadTips(),
                success: function(data) {
                    layer.close(loadIndex); //关闭加载图标
                    if (data == 1) {
                        layer.msg('不存在此商品！', {
                            area: ["300px","100px"]
                        });
                    } else {
                        $nowSpan.text('1'); //使现在页数显示为1
                        showData(data);
                    }
                },
                 error: function() {
                    errorFun();
                 }

            });
        } else { //当搜索内容为空时
            layer.msg('搜索关键词不能为空！', {
                area: ['300px', '100px']
            });
        }
    });

    /*
     * 点击往前翻页按钮处理函数
     *
     * step1 ：获取当前页数，判断是否为第一页，第一页则不进行任何动作提示现在已是第一页
     *
     * step2 ：不是第一页则发起ajax请求，发送当前页数给后台
     *
     * step3 ：清空table内的已有数据，然后处理后台返回的数组
     *
     * step4 : 判断搜索到的条数是否需要分页，不需要分页则直接把搜索到的相关数据重新插入table内，需要分页则显示一页最多显示的条数
     */
    $prevBtn.click(function() {
        var $nowPage = $nowSpan.text(); //获取当前页数
        var $sendPage=parseInt($nowPage)-1;//求要到达的页数
        var $thisNav=$classiyTitle.text();//获取全部主分类名
        var $shopId=" ";
        var $searchText=$searchBox.val();//获取搜索框内的关键字

        console.log($sendPage,$searchText,$thisSubNav);
        if ($nowPage == 1) { //判断是否已处于第一页
            layer.msg('现已处于第一页！', {
                area: ['200px', '100px']
            });
        } else {
            pageControl($gotoPage,$shopId,$searchText,$thisSubNav,$thisNav);
            // $.ajax({
            //     url: 'pageControl',
            //     type: 'GET',
            //     data: {
            //         index: $sendPage,//要到达的页数
            //         shopId:shopId,//店铺id
            //         search:$searchText,//搜索框内的关键字
            //         subNavId:$thisSubNav//商品子分类
            //         mainNav:$thisNav;//商品主分类
            //     },
            //     datatype: 'JSON',
            //     beforeSend: showLoadTips(),
            //     success: function(data) {
            //         layer.close(loadIndex);
            //         $nowSpan.text($sendPage);//设置当前页数
            //         showData(data);
            //     },
            //     error: function(){
            //         errorFun();
            //     }
            // });
        }
    });

    /*
     * 点击往后翻页按钮处理函数
     *
     * step1 ：获取当前页数，判断是否为最后一页，最后一页则不进行任何动作提示现在已是最后一页
     *
     * step2 ：不是第一页则发起ajax请求，发送当前页数给后台
     *
     * step3 ：清空table内的已有数据，然后处理后台返回的数组
     *
     * step4 : 判断搜索到的条数是否需要分页，不需要分页则直接把搜索到的相关数据重新插入table内，需要分页则显示一页最多显示的条数
     */
    $nextBtn.click(function() {
        var $nowPage = $nowSpan.text(); //获取当前页数
        var $totalPage = $pageSpan.text(); //获取总分页
        var $sendPage=parseInt($nowPage)+1;//要到达的页数
        var $thisNav=$classiyTitle.text();//获取全部主分类名
        var $searchText=$searchBox.val();//获取搜索框内的关键字

        var $shopId="";//店铺ID

        console.log($sendPage,$searchText,$thisSubNav);
        if ($nowPage == $totalPage) { //如果已经是最后一页则不进行ajax请求，弹出提示框
            layer.msg('现在已是最后一页了！', {
                area: ["300px", "100px"]
            });
        } else { //发起ajax请求
            pageControl($gotoPage,$shopId,$searchText,$thisSubNav,$thisNav);
            // $.ajax({
            //     url: 'pageControl',
            //     type: 'GET',
            //     data: {
            //         index: $sendPage,//要到达的页数
            //         shopId:shopId,//店铺id
            //         search:$searchText,//搜索框内的关键字
            //         subNavId:$thisSubNav//商品子分类
            //         thisNav:$thisNav
            //     },
            //     datatype: 'JSON',
            //     beforeSend: showLoadTips(),
            //     success: function(data) {
            //         layer.close(loadIndex); //关闭正在加载图标
            //         $nowSpan.text($sendPage);
            //         showData(data); //处理后台返回的数组，把数据插到table中
            //     },
            //     error: function(){
            //         errorFun();
            //     }
            // });

        }
    });

    /*
     * 点击前往指定页数按钮处理函数
     *
     * step1 ：获取输入的要前往的页数
     *
     * step2 ：判断输入的页数是否是第一页、最后一页、当前页数，否则发起ajax请求
     *
     * step3 ：清空table内的已有数据，然后处理后台返回的数组
     *
     */
    $gotoBtn.click(function() {
        var $gotoPage = $("#gotoPage").val(); //获取输入的要前往的页数
        var $nowPage = $nowSpan.text(); //获取当前页数
        var $totalPage = $pageSpan.text(); //获取总分页

        var $thisNav=$classiyTitle.text();//获取全部主分类名
        var $searchText=$searchBox.val();//获取搜索框内的关键字
        var $shopId="";//店铺ID

        if ($gotoPage == '') { //输入页数为空时，弹出提示框
            layer.msg('输入页数不能为空！', {
                area: ["200px", "100px"]
            });
        } else if ($gotoPage > totalPage) {
            layer.msg('输入页数超于总页数，请重新输入！', {
                area: ["200px", "100px"]
            });
        } else if ($gotoPage < 1) {
            layer.msg('输入页数不能小于1，请重新输入！', {
                area: ["200px", "100px"]
            });
        } else if ($gotoPage == $nowPage) {
            layer.msg('已在此页数！', {
                area: ["200px", "100px"]
            });
        } else {
            pageControl($gotoPage,$shopId,$searchText,$thisSubNav,$thisNav);
            // $.ajax({
            //     url: 'pageControl',
            //     type: 'GET',
            //     datatype: 'JSON',
            //     data: {
            //         nowPage: $nowPage
            //     },
            //     beforeSend: showLoadTips(),
            //     success: function(data) {
            //         showData(data);
            //     },
            //     error: function(){
            //         errorFun();
            //     }
            // });
        }
    })

    /*发起ajax请求提示加载信息*/
    function showLoadTips() {
        loadIndex = layer.load(0, {
            shade: false
        });
    }


    /*异步请求成功后显示商品详细信息数据*/
    function showData(data) {
        var arrLength = data.total; //获取一页的数据长度
        $tableTbody.empty(); //清空table内的数据
        $totalSpan.text(data.total); //把搜索到的相关的数据总数插入到总条数span中
        $pageSpan.text(data.pageCount); //求总共页数

        for (var i = 0; i < data.returnSize; i++) {
            $tableTbody.append($newTr); //新增tr节点元素
        }

        //显示第一个商品的信息
        var $tableFirst = $tableTbody.find('tr').eq(0); //获取第一条商品信息的tr标签元素
        var $tableFirstTd = $tableFirst.find('td'); //获取第一条商品信息的tr标签元素
        var $firstHref="http://localhost:8888/admin/CommodityAction/commodityModify?commodityId="+data.first.id;//编辑按钮超链接地址
        var $imagePath="http://localhost:8888/static/admin/images/"+data.first.pic;
        $tableFirstTd.eq(0).text(1); //第一个td是商品序号
        $tableFirst.attr('id', data.first.id); //把id放入对应index下标的tr标签中
        $tableFirstTd.eq(1).find('img').attr('src', $imagePath); //第二个td是图片需要特殊处理为设置src属性
        $tableFirstTd.eq(2).text(data.first.name); //第三个td设置商品名
        $tableFirstTd.eq(3).text(data.first.number); //第四个td设置商品编号
        $tableFirstTd.eq(4).text(data.first.newPirce); //第五个td设置价格
        $tableFirstTd.eq(5).text(data.first.stock); //第六个td设置商品库存
        $tableFirstTd.eq(6).text(data.first.descrip); //第七个td设置商品属性
        $tableFirstTd.eq(7).text(data.first.label); //第八个td设置商品标签
        $tableFirstTd.find('a').attr('href',$firstHref);//设置编辑按钮的超链接
        if (data.flag === 1) {//如果商品是需要显示在页面中
            $tableFirstTd.eq(8).find('.checkbox span').removeClass(
                'close-box').addClass('open-box'); //把开关按钮设置为open-box
        } else {//如果商品是不需要显示在页面中
            $tableFirstTd.eq(8).find('.checkbox span').removeClass(
                'open-box').addClass('close-box'); //把开关按钮设置为close-box
        }

        //显示第2+个商品的信息
        for(var j=1;j<=data.results.length;j++){
            var $tableTr = $tableTbody.find('tr').eq(j); //获取对应index下标下的tr标签元素
            var $tableTd = $tableTr.find('td'); //获取对应index下标下的td标签元素
            var $editHref="http://localhost:8888/admin/CommodityAction/commodityModify?commodityId="+data.results[j].id;//编辑按钮超链接地址
            var $imagePath="http://localhost:8888/static/admin/images/"+data.results[j].pic;
            $tableTr.attr('id', data.results[j].id); //把id放入对应index下标的tr标签中
            $tableTd.eq(0).text(j+1); //第一个td是商品序号
            $tableTd.eq(1).find('img').attr('src', $imagePath); //第二个td是图片需要特殊处理为设置src属性
            $tableTd.eq(2).text(data.results[j].name); //第三个td设置商品名
            $tableTd.eq(3).text(data.results[j].number); //第四个td设置商品编号
            $tableTd.eq(4).text(data.results[j].newPirce); //第五个td设置价格
            $tableTd.eq(5).text(data.results[j].stock); //第六个td设置商品库存
            $tableTd.eq(6).text(data.results[j].descrip); //第七个td设置商品属性
            $tableTd.eq(7).text(data.results[j].label); //第八个td设置商品标签
            $tableTd.find('a').attr('href',$firstHref);//设置编辑按钮的超链接
            if (data.flag === 1) {//如果商品是需要显示在页面中
                $tableTd.eq(8).find('.checkbox span').removeClass('close-box').addClass('open-box'); //把开关按钮设置为open-box
            } else {//如果商品是不需要显示在页面中
               $tableTd.eq(8).find('.checkbox span').removeClass('open-box').addClass('close-box'); //把开关按钮设置为close-box
           }

        }
    }

    /*翻页ajax请求函数*/
    function pageControl(sendPage,shopId,searchText,thisSubNav,thisNav){
        $.ajax({
            url: 'pageControl',
            type: 'GET',
            data: {
                index: sendPage,//要到达的页数
                shopId:shopId,//店铺id
                search:searchText,//搜索框内的关键字
                subNavId:thisSubNav,//商品子分类
                subNav:thisNav//商品主分类
            },
            datatype: 'JSON',
            beforeSend: showLoadTips(),
            success: function(data) {
                layer.close(loadIndex); //关闭正在加载图标
                $nowSpan.text(sendPage);
                showData(data); //处理后台返回的数组，把数据插到table中
            },
            error: function(){
                errorFun();
            }
        });
    }
});
    /*异步请求失败后显示提示失败提示框*/
    function errorFun() {
        layer.msg('数据连接失败！请反省！', {
            area: ['300px', '100px']
        });
    }
