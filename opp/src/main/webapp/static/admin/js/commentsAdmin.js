/**
 * @author DodoMonster
 * 2016-03-22
 */

/*===================global variable start===========*/
// $thisNav="";//当前评论所属的类型
/*--------------------global variable end------------*/
$(function(){
    var $replyBox='<div class="input-box"><textarea name="replyBox" id="replyBox" cols="107" rows="5"></textarea>'
                  +'<span class="confirm-cancel cancel-reply">取消</span><span class="confirm-cancel confirm-reply">确定</span></div></div>';//回复框
    var $inputBox=$('.comments-list');//回复内容输入box
    var $commentsList=$('.comments-list');//评论装载容器ul
    var $commentsNav=$('.comments-nav li');//评论导航
    var $totalSpan = $('#totalNum'); //获取总条数容器
    var $totalNum = $totalSpan.text(); //获取总条数
    var $pageSpan = $('#totalPage'); //获取总分页容器
    var $nowSpan = $('#nowPage'); //获取当前页数容器

    var $inputPage = $('#gotoPage').val(); //获取用户输入的需要到达的页数
    var $prevBtn = $('#prevBtn'); //前一页按钮
    var $nextBtn = $("#nextBtn"); //后一页按钮
    var $gotoBtn = $("#gotoBtn"); //到达输入页面的按钮

    /*
	* 点击评论分类导航处理函数
	*
	* step1 : 获取点击的要查看的分类
	*
	* step2 ：发起ajax请求，处理后台返回的含有该分类的数组把其插入到html文档中
	*
	*/
    $commentsNav.click(function(){
        var $thisNav=$(this).find('.nowNav').text();//获取当前点击的评论所属分类
        $(this).addClass('on').siblings().removeClass('on');//点击的当前添加onclass其余子兄弟removaClass
        $.ajax({
            url:'',
            type:'GET',
            data:{
                thisNav:$thisNav
            },
            dataType:'JSON',
            beforeSend:showLoadTips(),
            success:function(data){
                layer.close(loadIndex);
                showData(data);
            },
            error:errorFun()
        });
    });
    /*
	* 点击回复按钮处理事件
	*
	* step1 : 获取要append的父元素
	*
	* step2 ：append显示回复框
	*
	*/
    $inputBox.on('click','.reply-btn',function(){
        var $appendPlace=$(this).parents('.comments-detail');//获取要append的父元素
        $appendPlace.append($replyBox);//append回复框
    });

    /*
	* 点击确定回复按钮处理事件
	*
	* step1 : 获取回复的内容，判断是否为空
	*
	* step2 ：如果用户点击了取消则直接关闭提示框
	*
	* step3 ：如果用户点击了确定，先判断用户输入是否为空
	*
	* step4 : 为空则弹框提示不能为空
	*
	* step5 : 不为空则发起ajax请求发送（用户的评论id和回复的内容），成功后并把其插入到html文档中
	*/
    $inputBox.on('click','.confirm-reply',function(){
        var $replyContent=$(this).siblings('textarea').val();//获取回复内容
        var $commentsId=$(this).parent('li').attr('id');//获取此评论的id
        if($replyContent==''){//当回复内容为空时
            layer.msg('回复内容不能为空',{
                area:['200px','100px']
            })
        }else{
            $.ajax({
                url:'',
                type:'GET',
                data:{
                    commentsId:$commentsId,//回复的评论id
                    replyComments:$replyContent//回复的内容
                },
                datatype:'JSON',
                beforeSend:showLoadTip(),
                success:function(data){
                    layer.close(loadIndex);
                    layer.msg('回复成功！',{
                        area:['200px','100px']
                    });
                    var $replyContentBox='<div class="reply-content"><p>店家回复: <span>'+$replyContent+'</span></p></div>';//店家回复内容
                    var $appendPlace=$(this).parent('.input-box').siblings('.time');//获取要append的父元素
                    $(this).parent('.input-box').remove();//移除回复框
                    $appendPlace.before($replyContentBox);//append回复框
                },
                error:errorFun()
            });
        }
    });
    /*
	* 点击取消回复按钮处理事件
	*
	* step1 : 获取取消回复的回复框
	*
	* step2 ：如果用户点击了取消则直接关闭提示框
	*
	* step3 ：如果用户点击了确定，先判断用户输入是否为空
	*
	* step4 : 为空则弹框提示不能为空
	*
	* step5 : 不为空则获取用户输入的新增的商品名，并把其插入到html文档中
	*/
    $inputBox.on('click','.cancel-reply',function(){
        var $delReplyBox=$(this).parent('.input-box');//获取取消回复的回复框
        layer.confirm('确定取消回复？',{
            skin:'layui-layer-molv',
            title:'取消提示',
            shade:0.6,//遮罩透明度
            moveType:1,//拖拽风格,0是默认,1是传递拖动
            shift:1,//0-6是动画形式，-1是不开启
        },function(index){
            $delReplyBox.remove();//移除此回复框
            layer.close(index);//关闭弹框
        });
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
        var $thisNav=$('.on').find('.nowNav').text();//获取当前评论所属的类型
        if ($nowPage == 1) { //判断是否已处于第一页
            layer.msg('现已处于第一页！', {
                area: ['200px', '100px']
            });
        } else {
            $.ajax({
                url: '',
                type: 'GET',
                data: {
                    nowSpan: $nowSpan,
                    up: 0, //前一页信号
                    thisNav: $thisNav //当前显示的数据所属的分类
                },
                datatype: 'JSON',
                beforeSend: showLoadTips(),
                success: function(data) {
                    layer.close(loadIndex);
                    showData(data);
                },
                error: errorFun()
            });
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
        var $thisNav=$('.on').find('.nowNav').text();//获取当前评论所属的类型
        if ($nowSpan == $totalPage) { //如果已经是最后一页则不进行ajax请求，弹出提示框
            layer.msg('现在已是最后一页了！', {
                area: ["300px", "100px"]
            });
        } else { //发起ajax请求
            $.ajax({
                url: '',
                type: 'GET',
                data: {
                    nowSpan: $nowSpan,
                    down: 1, //下一页
                    thisNav: $thisNav //当前显示的数据所属的分类
                },
                datatype: 'JSON',
                beforeSend: showLoadTips(),
                success: function(data) {
                    layer.close(loadIndex); //关闭正在加载图标
                    showData(data); //处理后台返回的数组，把数据插到table中
                },
                error: errorFun()
            });
        }
    });

    /*
     * 点击前往指定页数按钮处理函数
     *
     * step1 ：获取输入的要前往的页数以及当前评论所属分类
     *
     * step2 ：判断输入的页数是否是第一页、最后一页、当前页数，否则发起ajax请求
     *
     * step3 ：清空table内的已有数据，然后处理后台返回的数组
     *
     */
    $gotoBtn.click(function() {
        var $gotoPage = $("#gotoPage").val(); //获取输入的要前往的页数
        var $nowPage = $("#nowPage").text(); //获取当前页数
        var $totalPage = $("#totalPage").text(); //获取总页数
        var $thisNav=$('.on').find('.nowNav').text();//获取当前评论所属的类型

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
            $.ajax({
                url: '',
                type: 'GET',
                datatype: 'JSON',
                data: {
                    nowPage: $nowPage,
                    thisNav:$thisNav
                },
                beforeSend: showLoadTips(),
                success: function(data) {
                    showData(data);
                },
                error: errorFun()
            })
        }
    })

    /*
     * 处理ajax请求时后台返回的含有对应评论的数组
     *
     * step1 ：判断后台返回数组的长度确定评论的条数以及页数
     *
     * step2 ：判断评论中有没有图片，分两种情况进行循环遍历拼接要显示的评论
     *
     * step3 ：清空ul中已有的评论，把拼接好的字符串插入html文档中显示出来
     *
     */
    function showData(data){
        // data=[{
        //     "userPhoto":"../../images/goods-img.jpg",
        //     "user":"大叔控好2",
        //     "rank":"钻石会员",
        //     "star":5,
        //     "commentsWord":"不想改那个页面先了 想现在开始今晚撸完评论管理的样式排版布局不想改那个页面先了 想现在开始今晚撸完评论管理的样式排版布局",
        //     "commentsImg":[
        //         "../../images/goods-img.jpg",
        //         "../../images/goods-img.jpg",
        //         "../../images/goods-img.jpg"
        //     ],
        //     "replyComments":"好看，质量也不错，宽松版穿着舒服，最开心的是活动买的划算啊，物流也快的不行",
        //     "takeTime":2,
        //     "time":'2016 - 04 -05'
        // },
        // {
        //     "userPhoto":"../../images/goods-img.jpg",
        //     "user":"大叔控好9",
        //     "rank":"钻石会员",
        //     "star":5,
        //     "commentsWord":"不想改那个页面先了 想现在开始今晚撸完评论管理的样式排版布局不想改那个页面先了 想现在开始今晚撸完评论管理的样式排版布局",
        //     "commentsImg":["../../images/goods-img.jpg","../../images/goods-img.jpg","../../images/goods-img.jpg"],
        //     "replyComments":"好看，质量也不错，宽松版穿着舒服，最开心的是活动买的划算啊，物流也快的不行",
        //     "takeTime":2,
        //     "time":'2016 - 04 -05'
        // }];

        var $newRank="";//用户等级
        var imgFlag=0;//0表示没有评论图片，1则表示有评论图片
        var $rank='<i class="fa fa-star"></i>';
        var $newCommentsImg0='<div class="images">';
        var $newCommentsImg1='<img src="';
        var $newCommentsImg2='" alt="评论图" />';
        var $newCommentsImg3='</div>';
        var arrLength = data.length; //获取的数据长度
        $commentsList.empty(); //清空评论列表内的数据
        $nowSpan.text('1'); //使现在页数显示为1
        $totalSpan.text(arrLength); //把搜索到的相关的数据总数插入到总条数span中
        if (data.length < 10) {
            $pageSpan.text('1'); //把搜索到的相关的数据分页总数插入到分页总条数span中
        } else {
            $pageSpan.text(Math.ceil(arrLength / 10)); //求总共页数
            arrLength = 10;
        }
        $.each(data,function(index,item){
            var $newRank="";//用户等级
            var $newComment="";//拼接成总字符串
            var $newCommentsImg="";//用户评论图片
            for(var i=0;i<item.star;i++){//好评等级
                $newRank+=$rank;
            }
            if(item.commentsImg.length>0){//评论中含有图片
                for(var j=0;j<item.commentsImg.length;j++){
                    $newCommentsImg+=($newCommentsImg1+item.commentsImg[j]+$newCommentsImg2);
                }
                $newComment='<li class="buyer-comments" id=""><div class="buyer"><img src="'+item.userPhoto
                +'" alt="用户头像"><p class="author">'+item.user+'</p><p class="rank">'+item.rank+'</p></div><div class="comments-detail"><p>'
                +$newRank+'</p><div class="comments"><div class="images">'+$newCommentsImg+'</div><p>'+item.commentsWord+'</div><div class="time"><span>收货后<em>'+item.takeTime+'</em>天后评论</span><span>'
                +' '+item.time+'</span><span class="reply-btn">回复 <i class="fa fa-angle-down"></i></span></div></div><div class="clear"></div></li>';
            }else{//评论不带图
                $newComment='<li class="buyer-comments" id=""><div class="buyer"><img src="'+item.userPhoto
                +'" alt="用户头像"><p class="author">'+item.user+'</p><p class="rank">'+item.rank+'</p></div><div class="comments-detail"><p>'
                +$newRank+'</p><div class="comments"><p>'+item.commentsWord+'</div><div class="time"><span>收货后<em>'+item.takeTime+'</em>天后评论</span><span>'
                +' '+item.time+'</span><span class="reply-btn">回复 <i class="fa fa-angle-down"></i></span></div></div><div class="clear"></div></li>';
            }
            $commentsList.append($newComment);
        })
    }
    /*发起ajax请求提示加载信息*/
    function showLoadTips() {
        loadIndex = layer.load(0, {
            shade: false
        });

    }

    /*异步请求失败后显示提示失败提示框*/
    function errorFun() {
        layer.msg('数据连接失败！请反省！', {
            area: ['300px', '100px']
        });
    }
});
