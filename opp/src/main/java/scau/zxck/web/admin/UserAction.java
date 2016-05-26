package scau.zxck.web.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import scau.zxck.base.dao.mybatis.Conditions;
import scau.zxck.base.exception.BaseException;
import scau.zxck.entity.admin.*;
import scau.zxck.service.admin.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by YWY on 2016/4/13.
 */
@Controller
@RequestMapping("/admin/UserAction")
public class UserAction {
    @Autowired
    IShoppingCartService shoppingCartService;
    @Autowired
    ICommodityService commodityService;
    @Autowired
    IShopService shopService;
    @Autowired
    ICommodityOrderService commodityOrderService;
    @Autowired
    IOrderService orderService;
    @Autowired
    INewsUserService newsUserService;
    @Autowired
    INewsService newsService;
    @Autowired
    ICollectionShopService collectionShopService;
    @Autowired
    ICommodityCommentService commodityCommentService;
    @Autowired
    ICommodityCommentReplyService commodityCommentReplyService;
    @Autowired
    IUserMessageService userMessageService;

    @RequestMapping(value = "/shoppingCart", method = RequestMethod.GET)
    public String main(Model model) throws BaseException {
        return "admin/shoppingCart";
    }

    //显示消费者的购物车
    @RequestMapping(value = "/showShoppingCart", method = RequestMethod.POST)
    public String show(Model model,String userId) throws BaseException {
        Conditions conditions = new Conditions();
        conditions.eq("user_id",userId);
        List<ShoppingCart> shoppingCarts = shoppingCartService.list(conditions);
        List<String> id = new ArrayList<String>();
        List<String> shopName = new ArrayList<String>();
        List<String> pic = new ArrayList<String>();
        List<String> name = new ArrayList<String>();
        List<String> price = new ArrayList<String>();
        List<String> number = new ArrayList<String>();
        Double Sum = 0.0;
        for(ShoppingCart shoppingCart:shoppingCarts){
            Commodity commodity = commodityService.findById(shoppingCart.getCommodityId());
            id.add(shoppingCart.getId());
            shopName.add(shopService.findById(shoppingCart.getShopId()).getName());
            pic.add(commodity.getPic());
            name.add(commodity.getName());
            price.add(commodity.getNewPirce()+"");
            number.add(shoppingCart.getCommodityCount()+"");
            Sum+=commodity.getNewPirce()*shoppingCart.getCommodityCount();
        }
        model.addAttribute("id",id);
        model.addAttribute("shopName",shopName);
        model.addAttribute("pic",pic);
        model.addAttribute("name",name);
        model.addAttribute("price",price);
        model.addAttribute("number",number);
        model.addAttribute("sum",Sum);
        return "admin/showShoppingCart";
    }

    //删除某个id的购物车
    @RequestMapping(value = "/deleteShoppingCart", method = RequestMethod.POST)
    public String delete(Model model,String id) throws BaseException {
        Conditions conditions = new Conditions();
        conditions.eq("id", id);
        if(shoppingCartService.find(conditions)!=null){
        shoppingCartService.delete(conditions);
        model.addAttribute("index","1");
        }
        else model.addAttribute("index","0");
        return "admin/shoppingCart";
    }

    //显示历史订单
    @RequestMapping(value = "/showOrder", method = RequestMethod.POST)
         public String showOrder(Model model,String userId) throws BaseException {
        Conditions conditions = new Conditions();
        conditions.eq("user_id", userId);
        List<Order> orders = orderService.list(conditions);
        List<String> pic = new ArrayList<String>();
        List<String> shopName = new ArrayList<String>();
        List<String> commodityName = new ArrayList<String>();
        List<String> count = new ArrayList<String>();
        List<String> price = new ArrayList<String>();
        List<String> shippingAddress = new ArrayList<String>();
        List<Date> creatTime = new ArrayList<Date>();
        List<String> identifier = new  ArrayList<String>();
        List<String> buyerMessage = new ArrayList<String>();
        for(Order order : orders){
            if(order.getStatus()==1) {
                Conditions conditions1 = new Conditions();
                conditions1.eq("order_id", order.getId());
                CommodityOrder commodityOrder = commodityOrderService.find(conditions1);
                pic.add(commodityService.findById(order.getCommodityId()).getPic());
                shopName.add(shopService.findById(commodityService.findById(commodityOrder.getCommodityId()).getShopId()).getName());
                commodityName.add(commodityService.findById(commodityOrder.getCommodityId()).getName());
                count.add(commodityOrder.getCount() + "");
                price.add(commodityOrder.getPrice() + "");
                shippingAddress.add(order.getShippingAddress());
                creatTime.add(order.getCreateTime());
                identifier.add(order.getIdentifier());
                buyerMessage.add(order.getBuyerMessage());
            }
        }

        model.addAttribute("pic",pic);
        model.addAttribute("shopName",shopName);
        model.addAttribute("commodityName",commodityName);
        model.addAttribute("count",count);
        model.addAttribute("price",price);
        model.addAttribute("shippingAddress",shippingAddress);
        model.addAttribute("creatTime",creatTime);
        model.addAttribute("identifier",identifier);
        model.addAttribute("buyerMessage",buyerMessage);
        return "admin/shoppingCart";
    }

    //显示系统消息
    @RequestMapping(value = "/showNews", method = RequestMethod.POST)
         public String showNews(Model model,String userId) throws BaseException {
        Conditions conditions = new Conditions();
        conditions.eq("user_id", userId);
        List<NewsUser> newsUsers = newsUserService.list(conditions);
        List<String> content = new ArrayList<String>();
        List<Date> time = new ArrayList<Date>();
        for(NewsUser newsUser : newsUsers){
            News news = newsService.findById(newsUser.getNewsId());
            content.add(news.getContent());
            time.add(news.getTime());
        }
        model.addAttribute("content",content);
        model.addAttribute("time",time);
        return "admin/shoppingCart";
    }

    //显示收藏店铺
    @RequestMapping(value = "/showCollectingShop", method = RequestMethod.POST)
    public String showCollectingShop(Model model,String userId) throws BaseException {
        Conditions conditions = new Conditions();
        conditions.eq("user_id", userId);
        List<CollectionShop> collectionShops = collectionShopService.list(conditions);
        List<String> shopName = new ArrayList<String>();
        List<String> id = new ArrayList<String>();
        List<String> classification = new ArrayList<String>();
        for(CollectionShop collectionShop:collectionShops){
            id.add(collectionShop.getId());
            shopName.add(shopService.findById(collectionShop.getShopId()).getName());
            classification.add(collectionShop.getClassification());
        }
        model.addAttribute("id",id);
        model.addAttribute("shopName",shopName);
        model.addAttribute("classification",classification);
        return "admin/shoppingCart";
    }

    //查看自己的历史评论以及商家对自己的回复
    @RequestMapping(value = "/showComment", method = RequestMethod.POST)
    public String showComment(Model model,String userId) throws BaseException {
        CommodityComment commodityComment1 = new CommodityComment();
        commodityComment1.setUserId(userId);
        List<CommodityComment> commodityComments = commodityCommentService.listByEntity(commodityComment1);
        List<String> commodityName = new ArrayList<String>();
        List<String> shopName = new ArrayList<String>();
        List<String> comment = new ArrayList<String>();
        List<Date> commentTime = new ArrayList<Date>();
        List<Date> replyTime = new ArrayList<Date>();
        List<String> reply = new ArrayList<String>();
        for(CommodityComment commodityComment : commodityComments){
            Commodity commodity = commodityService.findById(commodityComment.getCommodityId());
            commodityName.add(commodity.getName());
            shopName.add(shopService.findById(commodity.getShopId()).getName());
            comment.add(commodityComment.getComment());
            commentTime.add(commodityComment.getTime());
            reply.add(commodityCommentReplyService.findById(commodityComment.getSellerReply()).getComment());
            replyTime.add(commodityCommentReplyService.findById(commodityComment.getSellerReply()).getTime());
        }
        model.addAttribute("commodityName",commodityName);
        model.addAttribute("shopName",shopName);
        model.addAttribute("comment",comment);
        model.addAttribute("commentTime",commentTime);
        model.addAttribute("reply",reply);
        model.addAttribute("replyTime",replyTime);
        return "admin/shoppingCart";
    }

    //删除收藏店铺
    @RequestMapping(value = "/deleteCollectingShop", method = RequestMethod.POST)
         public String deleteCollectingShop(Model model,String id) throws BaseException {
        Conditions conditions = new Conditions();
        conditions.eq("id", id);
        if(collectionShopService.findById(id)!=null){
        collectionShopService.delete(conditions);
        model.addAttribute("index",1);
        }
        else model.addAttribute("index",0);
        return "admin/shoppingCart";
    }

    //显示消费者个人资料
    @RequestMapping(value = "/showUserMessage", method = RequestMethod.POST)
         public String showUserMessage(Model model,String userId) throws BaseException {
        Conditions conditions = new Conditions();
        conditions.eq("user_id", userId);
        UserMessage userMessage = userMessageService.find(conditions);
        String id = userMessage.getId();
        String pic = userMessage.getPic();
        String nickname = userMessage.getNickname();
        String realname = userMessage.getRealname();
        String sex;
        if(userMessage.getSex()==0)sex="男";
        else sex="女";
        Date brithday = userMessage.getBirthday();
        String residence = userMessage.getResidence();
        String hometown = userMessage.getHometown();
        model.addAttribute("id",id);
        model.addAttribute("pic",pic);
        model.addAttribute("nickname",nickname);
        model.addAttribute("realname",realname);
        model.addAttribute("sex",sex);
        model.addAttribute("brithday",brithday);
        model.addAttribute("residence",residence);
        model.addAttribute("hometown",hometown);
        model.addAttribute("userId",userId);
        return "admin/shoppingCart";
    }

    //修改个人资料
    @RequestMapping(value = "/alterUserMessage", method = RequestMethod.POST)
    public String alterUserMessage(Model model,String userId,String id,String pic,String nickname,String realname,String sex,Date brithday,String residence,String hometown) throws BaseException {
        UserMessage userMessage = new UserMessage();
        userMessage.setId(id);
        userMessage.setPic(pic);
        userMessage.setNickname(nickname);
        userMessage.setRealname(realname);
        if(sex=="男"){
        userMessage.setSex(0);
        }
        else userMessage.setSex(1);
        userMessage.setBirthday(brithday);
        userMessage.setResidence(residence);
        userMessage.setHometown(hometown);
        userMessage.setUserId(userId);
        if(userMessageService.findById(id)!=null){
            userMessageService.updateById(userMessage);
            model.addAttribute("index","0");
        }
        else model.addAttribute("index","1");
        return "admin/shoppingCart";
    }
}
