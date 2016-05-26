/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50538
Source Host           : localhost:3306
Source Database       : apt

Target Server Type    : MYSQL
Target Server Version : 50538
File Encoding         : 65001

Date: 2016-04-23 21:37:57
*/

CREATE DATABASE  IF NOT EXISTS apt ;        #创建名称为“apt”的数据库
USE apt;                      #使用名称为“apt”的数据库


SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for apt_advertisement
-- ----------------------------
DROP TABLE IF EXISTS `apt_advertisement`;
CREATE TABLE `apt_advertisement` (
  `id` varchar(50) NOT NULL,
  `pic` varchar(255) NOT NULL,
  `commodity_id` varchar(50) DEFAULT NULL,
  `shop_id` varchar(50) DEFAULT NULL,
  `position` int(11) NOT NULL COMMENT '广告的位置',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='广告表';

-- ----------------------------
-- Records of apt_advertisement
-- ----------------------------

-- ----------------------------
-- Table structure for apt_carousel_pic
-- ----------------------------
DROP TABLE IF EXISTS `apt_carousel_pic`;
CREATE TABLE `apt_carousel_pic` (
  `id` varchar(50) NOT NULL,
  `pic` varchar(255) NOT NULL COMMENT '滚动图片路径',
  `commodity_id` varchar(50) DEFAULT NULL COMMENT '商品id',
  `time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `shop_id` varchar(50) DEFAULT NULL COMMENT '店铺id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='滚动图片表，首页与店铺页面的滚动图片共用这张表';

-- ----------------------------
-- Records of apt_carousel_pic
-- ----------------------------

-- ----------------------------
-- Table structure for apt_collecting_shop
-- ----------------------------
DROP TABLE IF EXISTS `apt_collecting_shop`;
CREATE TABLE `apt_collecting_shop` (
  `id` varchar(50) NOT NULL,
  `user_id` varchar(50) NOT NULL,
  `shop_id` varchar(50) NOT NULL,
  `classification` varchar(10) NOT NULL DEFAULT '默认' COMMENT '分类',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='收藏店铺表';

-- ----------------------------
-- Records of apt_collecting_shop
-- ----------------------------

-- ----------------------------
-- Table structure for apt_commodity
-- ----------------------------
DROP TABLE IF EXISTS `apt_commodity`;
CREATE TABLE `apt_commodity` (
  `id` varchar(50) NOT NULL,
  `name` varchar(255) NOT NULL COMMENT '商品名',
  `pic` varchar(255) NOT NULL COMMENT '商品图片',
  `number` varchar(15) NOT NULL COMMENT '商品编号',
  `old_price` decimal(11,2) NOT NULL DEFAULT '0.00' COMMENT '旧价格',
  `new_pirce` decimal(11,2) NOT NULL DEFAULT '0.00' COMMENT '新价格',
  `discount` varchar(255) DEFAULT NULL COMMENT '本店优惠',
  `stock` int(11) NOT NULL DEFAULT '0' COMMENT '库存',
  `descrip` text COMMENT '商品信息描述',
  `shop_id` varchar(50) NOT NULL COMMENT '商品所属的店铺id',
  `sale` int(11) NOT NULL DEFAULT '0' COMMENT '销量',
  `comment` int(11) NOT NULL DEFAULT '0' COMMENT '评论数',
  `sub_nav_id` varchar(50) NOT NULL DEFAULT '0',
  `label` varchar(110) DEFAULT NULL COMMENT '商品标签，最多十个，每个长度不超过10，用“/”组合在一起，如“牛肉/羊肉”',
  `min_amount` int(11) NOT NULL DEFAULT '0' COMMENT '最低限度购买数量',
  `browsing_times` int(11) NOT NULL DEFAULT '0' COMMENT '浏览次数',
  `flag` int(255) NOT NULL DEFAULT '1' COMMENT '标记，1：显示商品，0：隐藏商品',
  `time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='商品信息表';

-- ----------------------------
-- Records of apt_commodity
-- ----------------------------

-- ----------------------------
-- Table structure for apt_commodity_attribute
-- ----------------------------
DROP TABLE IF EXISTS `apt_commodity_attribute`;
CREATE TABLE `apt_commodity_attribute` (
  `id` varchar(50) NOT NULL,
  `commodity_id` varchar(50) NOT NULL,
  `attribute` varchar(15) NOT NULL COMMENT '属性，如春、夏、秋、冬，酸性等',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='商品属性表';

-- ----------------------------
-- Records of apt_commodity_attribute
-- ----------------------------

-- ----------------------------
-- Table structure for apt_commodity_carousel_pic
-- ----------------------------
DROP TABLE IF EXISTS `apt_commodity_carousel_pic`;
CREATE TABLE `apt_commodity_carousel_pic` (
  `id` varchar(50) NOT NULL,
  `pic` varchar(255) NOT NULL COMMENT '滚动图片路径',
  `shop_id` varchar(50) NOT NULL COMMENT '商品id',
  `commodity_id` varchar(50) DEFAULT NULL,
  `time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='店铺的滚动图片表';

-- ----------------------------
-- Records of apt_commodity_carousel_pic
-- ----------------------------

-- ----------------------------
-- Table structure for apt_commodity_comment
-- ----------------------------
DROP TABLE IF EXISTS `apt_commodity_comment`;
CREATE TABLE `apt_commodity_comment` (
  `id` varchar(50) NOT NULL,
  `user_id` varchar(50) NOT NULL COMMENT '评论用户id',
  `commodity_id` varchar(50) NOT NULL COMMENT '被评论商品id',
  `comment` varchar(255) NOT NULL DEFAULT '系统自动好评',
  `score` int(11) NOT NULL DEFAULT '5' COMMENT '评分，等级1-5',
  `seller_reply` varchar(50) NOT NULL DEFAULT '0' COMMENT '商家回复',
  `time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='商品评论表';

-- ----------------------------
-- Records of apt_commodity_comment
-- ----------------------------

-- ----------------------------
-- Table structure for apt_commodity_comment_reply
-- ----------------------------
DROP TABLE IF EXISTS `apt_commodity_comment_reply`;
CREATE TABLE `apt_commodity_comment_reply` (
  `id` varchar(50) NOT NULL,
  `user_id` varchar(50) NOT NULL COMMENT '商家id',
  `commodity_comment_id` varchar(50) NOT NULL COMMENT '商品评论id',
  `comment` varchar(255) NOT NULL DEFAULT '系统自动好评',
  `time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='商品评论回复表';

-- ----------------------------
-- Records of apt_commodity_comment_reply
-- ----------------------------

-- ----------------------------
-- Table structure for apt_commodity_group
-- ----------------------------
DROP TABLE IF EXISTS `apt_commodity_group`;
CREATE TABLE `apt_commodity_group` (
  `id` varchar(50) NOT NULL,
  `name` varchar(15) NOT NULL DEFAULT '默认' COMMENT '分组名',
  `sequence` int(11) NOT NULL DEFAULT '0' COMMENT '分组顺序',
  `commodity_id` varchar(50) NOT NULL,
  `flag` int(11) NOT NULL DEFAULT '1' COMMENT '标志',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='商家的商品分类管理表';

-- ----------------------------
-- Records of apt_commodity_group
-- ----------------------------

-- ----------------------------
-- Table structure for apt_commodity_order
-- ----------------------------
DROP TABLE IF EXISTS `apt_commodity_order`;
CREATE TABLE `apt_commodity_order` (
  `id` varchar(50) NOT NULL,
  `commodity_id` varchar(50) NOT NULL,
  `order_id` varchar(50) NOT NULL,
  `count` int(11) NOT NULL DEFAULT '1' COMMENT '购买的商品数量',
  `price` decimal(11,2) NOT NULL DEFAULT '0.00' COMMENT '购买时的商品价格',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='商品-订单 关联表';

-- ----------------------------
-- Records of apt_commodity_order
-- ----------------------------

-- ----------------------------
-- Table structure for apt_commodity_pic
-- ----------------------------
DROP TABLE IF EXISTS `apt_commodity_pic`;
CREATE TABLE `apt_commodity_pic` (
  `id` varchar(50) NOT NULL,
  `pic` varchar(255) NOT NULL COMMENT '图片地址',
  `commodity_id` varchar(45) NOT NULL COMMENT '对应的商品id',
  `sequence` int(11) NOT NULL DEFAULT '0' COMMENT '顺序',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='商品图片表';

-- ----------------------------
-- Records of apt_commodity_pic
-- ----------------------------

-- ----------------------------
-- Table structure for apt_keyword
-- ----------------------------
DROP TABLE IF EXISTS `apt_keyword`;
CREATE TABLE `apt_keyword` (
  `id` varchar(50) NOT NULL,
  `name` varchar(10) NOT NULL COMMENT '关键字名称',
  `sequence` int(11) NOT NULL DEFAULT '0' COMMENT '排序',
  `hightlight` int(11) NOT NULL DEFAULT '1' COMMENT '是否高亮，0--否，1--是',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='搜素框下面的关键字表';

-- ----------------------------
-- Records of apt_keyword
-- ----------------------------

-- ----------------------------
-- Table structure for apt_main_nav
-- ----------------------------
DROP TABLE IF EXISTS `apt_main_nav`;
CREATE TABLE `apt_main_nav` (
  `id` varchar(50) NOT NULL,
  `name` varchar(15) NOT NULL COMMENT '栏目名',
  `sequence` int(11) NOT NULL DEFAULT '0' COMMENT '顺序',
  `belong_to` varchar(5) NOT NULL COMMENT '表示栏目属于哪个主栏目',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='主导航栏表';

-- ----------------------------
-- Records of apt_main_nav
-- ----------------------------
INSERT INTO `apt_main_nav` VALUES ('0e488df5754d4ca7af4f1f029f1357ea', '酸性', '1', '水果');
INSERT INTO `apt_main_nav` VALUES ('7a8a1dc6aa824921897fc69d46d56a40', '亚酸性', '0', '水果');
INSERT INTO `apt_main_nav` VALUES ('c98b4d524e6743d49d45450872ad8180', '甜性', '2', '水果');

-- ----------------------------
-- Table structure for apt_merchant_group
-- ----------------------------
DROP TABLE IF EXISTS `apt_merchant_group`;
CREATE TABLE `apt_merchant_group` (
  `id` varchar(50) NOT NULL,
  `name` varchar(15) NOT NULL COMMENT '分组名',
  `sequence` int(11) NOT NULL DEFAULT '0' COMMENT '分组顺序',
  `merchant_id` varchar(50) NOT NULL,
  `flag` int(11) NOT NULL DEFAULT '1' COMMENT '标志',
  PRIMARY KEY (`name`,`merchant_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='商家分组管理表';

-- ----------------------------
-- Records of apt_merchant_group
-- ----------------------------

-- ----------------------------
-- Table structure for apt_merchant_message
-- ----------------------------
DROP TABLE IF EXISTS `apt_merchant_message`;
CREATE TABLE `apt_merchant_message` (
  `id` varchar(50) NOT NULL,
  `company_name` varchar(30) NOT NULL COMMENT '公司名',
  `province` varchar(15) DEFAULT NULL COMMENT '省份',
  `city` varchar(15) DEFAULT NULL COMMENT '城市',
  `county` varchar(15) DEFAULT '1' COMMENT '县区',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='商家信息表';

-- ----------------------------
-- Records of apt_merchant_message
-- ----------------------------

-- ----------------------------
-- Table structure for apt_news
-- ----------------------------
DROP TABLE IF EXISTS `apt_news`;
CREATE TABLE `apt_news` (
  `id` varchar(50) NOT NULL,
  `title` varchar(140) NOT NULL COMMENT '消息标题',
  `content` varchar(255) NOT NULL COMMENT '消息内容',
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `sending_time` timestamp NULL DEFAULT NULL COMMENT '发送时间',
  `count` int(11) DEFAULT NULL COMMENT '浏览次数',
  `flag` int(11) DEFAULT '0' COMMENT '0--未发送，1--已发送',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='消息表';

-- ----------------------------
-- Records of apt_news
-- ----------------------------

-- ----------------------------
-- Table structure for apt_news_user
-- ----------------------------
DROP TABLE IF EXISTS `apt_news_user`;
CREATE TABLE `apt_news_user` (
  `id` varchar(50) NOT NULL,
  `user_id` varchar(50) NOT NULL,
  `news_id` varchar(50) NOT NULL,
  `flag` int(11) NOT NULL DEFAULT '0' COMMENT '0--默认，1--表示这条信息是发送给系统中除管理员外的所有账号，此时user_id记录为111111，2--表示这条信息是发送给系统中除管理员外的所有消费者账号，此时user_id记录为222222,3--表示这条信息是发送给系统中除管理员外的所有商家账号，此时user_id记录为333333',
  PRIMARY KEY (`user_id`,`news_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='消息-用户关联表';

-- ----------------------------
-- Records of apt_news_user
-- ----------------------------

-- ----------------------------
-- Table structure for apt_order
-- ----------------------------
DROP TABLE IF EXISTS `apt_order`;
CREATE TABLE `apt_order` (
  `id` varchar(50) NOT NULL,
  `user_id` varchar(50) NOT NULL COMMENT '买家id',
  `commodity_id` varchar(50) NOT NULL COMMENT '商品id',
  `shipping_address` varchar(500) NOT NULL COMMENT '收货地址',
  `buyer_message` varchar(255) NOT NULL COMMENT '买家留言',
  `identifier` varchar(20) NOT NULL COMMENT '订单编号',
  `sum` decimal(11,2) NOT NULL DEFAULT '0.00' COMMENT '总额',
  `status` int(11) NOT NULL DEFAULT '0' COMMENT '订单状态，0--未完成，1--交易成功',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '订单创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='订单表';

-- ----------------------------
-- Records of apt_order
-- ----------------------------

-- ----------------------------
-- Table structure for apt_permission
-- ----------------------------
DROP TABLE IF EXISTS `apt_permission`;
CREATE TABLE `apt_permission` (
  `id` varchar(50) NOT NULL,
  `permission` varchar(45) NOT NULL COMMENT '权限名',
  `description` varchar(45) NOT NULL COMMENT '权限描述',
  `available` int(11) NOT NULL DEFAULT '1' COMMENT '权限是否可用，0-否，1-是',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='权限表';

-- ----------------------------
-- Records of apt_permission
-- ----------------------------
INSERT INTO `apt_permission` VALUES ('0cc40764e28d417c93d78736f132a6b9', 'webGunPic:operate', '操作滚动大图模块', '1', '');
INSERT INTO `apt_permission` VALUES ('1276a17e10fd4de6974aa4b4902c8773', 'admin:left', '后台菜单栏', '1', null);
INSERT INTO `apt_permission` VALUES ('1473412c018c453894ef7a798f15fc4f', 'permission:operation', '权限操作权限', '1', '');
INSERT INTO `apt_permission` VALUES ('1c3ab539ffcd467aaa42d5531eaa9040', 'member:countFreeTime', '统计空闲时间', '1', null);
INSERT INTO `apt_permission` VALUES ('270e83b0b6854e3090edd3d7c2bee3b6', 'menu:2:website', '首页管理菜单', '1', '');
INSERT INTO `apt_permission` VALUES ('274c023e0f214d92a7055b19851d4f6c', 'ordinaryMember:is', '项目普通成员', '1', '');
INSERT INTO `apt_permission` VALUES ('2fdb71cbe90443d78cf7ec011f119d11', 'menu:1:personalSpace', '后台个人空间', '1', null);
INSERT INTO `apt_permission` VALUES ('3f64e72b2905443db088e0a73a39a3ac', 'product:operate', '操作产品管理系统模块', '1', null);
INSERT INTO `apt_permission` VALUES ('403c75e4180e4ec688dac04fb56acda6', 'menu:5:permission', '后台权限管理', '1', null);
INSERT INTO `apt_permission` VALUES ('4a90d59d2bd94faab34da74099cdfb08', 'admin:index', '后台主体', '1', null);
INSERT INTO `apt_permission` VALUES ('9be7ed5dcd30472b86bc4b08213bf612', 'Login', '后台登录', '1', '');
INSERT INTO `apt_permission` VALUES ('b03b04c33b6a4e0194c5bb8576924b60', 'member:addScheduleTime', '插入课表空闲时间', '1', null);
INSERT INTO `apt_permission` VALUES ('b1a5d3afb00d4e93a01b2183e7b7bfcf', 'menu:4:libary', '首页图书管理', '1', null);
INSERT INTO `apt_permission` VALUES ('ba43333b6db84a9ca69a57b5f1a780eb', 'member:operate', '操作人员管理系统模块', '1', null);
INSERT INTO `apt_permission` VALUES ('c336c136df1c4b629cea0a90c57640fd', 'visitorMessage:operate', '操作游客留言模块', '1', null);
INSERT INTO `apt_permission` VALUES ('c72ccd4a4ed74eac85bf184c50b7dcc6', 'admin:top', '后台顶部', '1', null);
INSERT INTO `apt_permission` VALUES ('f0f801f623544e70b1d99839965dd678', 'manager:is', '项目管理员', '1', '');
INSERT INTO `apt_permission` VALUES ('fdc3da26621142a18e038ad3970895c8', 'menu:3:member', '后台成员管理', '1', null);

-- ----------------------------
-- Table structure for apt_resource
-- ----------------------------
DROP TABLE IF EXISTS `apt_resource`;
CREATE TABLE `apt_resource` (
  `id` varchar(50) NOT NULL,
  `name` varchar(100) NOT NULL DEFAULT 'requestUrl' COMMENT '资源名称',
  `type` varchar(50) NOT NULL DEFAULT 'url' COMMENT '资源类型',
  `url` varchar(45) NOT NULL,
  `available` int(11) NOT NULL DEFAULT '1' COMMENT '资源是否可用，0--否，1--是',
  `priority` int(11) NOT NULL DEFAULT '0',
  `parent_id` int(11) NOT NULL DEFAULT '0' COMMENT '父编号，0-顶层菜单名',
  `permission_id` varchar(50) NOT NULL DEFAULT '0',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of apt_resource
-- ----------------------------
INSERT INTO `apt_resource` VALUES ('041285d539764642a09e65c99a409b66', 'Permission关联Resource', 'url', 'UrpAction/PermissionBindResource', '1', '0', '0', '1473412c018c453894ef7a798f15fc4f', '');
INSERT INTO `apt_resource` VALUES ('04d480b62f1c4338995c7d742dd71325', '编辑滚动大图预处理', 'url', 'GetBGDataAction/preEditWebGunPic', '1', '0', '0', '0cc40764e28d417c93d78736f132a6b9', null);
INSERT INTO `apt_resource` VALUES ('0561a6680d4d4a809be98b01e63bdde9', '下载文件', 'url', 'PersonalAction/download', '1', '0', '0', '274c023e0f214d92a7055b19851d4f6c', '');
INSERT INTO `apt_resource` VALUES ('109ff4b4687e4be8903361b95e097cd2', '搜索Permission', 'url', 'UrpAction/searchPermission', '1', '0', '0', '1473412c018c453894ef7a798f15fc4f', '');
INSERT INTO `apt_resource` VALUES ('140c07d1ebfe428ebd508229d94339f4', '查询产品', 'url', 'GetBGDataAction/advancedSearchProduct', '1', '0', '0', '3f64e72b2905443db088e0a73a39a3ac', '');
INSERT INTO `apt_resource` VALUES ('2796c4dbb53c48b8863df3cdef1e452d', '获取项目成员信息', 'url', 'PersonalAction/getGroup', '1', '0', '0', 'f0f801f623544e70b1d99839965dd678', '');
INSERT INTO `apt_resource` VALUES ('27b492afd09f4007a5d1f108a8af613f', '发送任务', 'url', 'PersonalAction/sendTask', '1', '0', '0', 'f0f801f623544e70b1d99839965dd678', '');
INSERT INTO `apt_resource` VALUES ('2848fcc3b381474ebf92eb4846f2f114', '编辑团队成员', 'url', 'GetBGDataAction/editMember', '1', '0', '0', 'ba43333b6db84a9ca69a57b5f1a780eb', null);
INSERT INTO `apt_resource` VALUES ('2d6462338c934d50a39ec6c2530a2459', '所有图书', 'menu', 'none', '1', '2', '4', 'b1a5d3afb00d4e93a01b2183e7b7bfcf', null);
INSERT INTO `apt_resource` VALUES ('3505205a16c049ecb46b6fa6aa9eb2f0', '修改Role', 'url', 'UrpAction/modifyRole', '1', '0', '0', '1473412c018c453894ef7a798f15fc4f', '');
INSERT INTO `apt_resource` VALUES ('3715c2929d5d421bbe682960724132d7', '登录后台', 'url', 'admin/adminSys', '1', '0', '0', '9be7ed5dcd30472b86bc4b08213bf612', '');
INSERT INTO `apt_resource` VALUES ('3948cbb551da4012903b1bad5ebb5b90', 'MainAction/index', 'url', 'MainAction/index', '1', '0', '0', '4a90d59d2bd94faab34da74099cdfb08', null);
INSERT INTO `apt_resource` VALUES ('3acffddd7c6a4541bdeba42cc1c6be66', '编辑产品', 'url', 'GetBGDataAction/editProduct', '1', '0', '0', '3f64e72b2905443db088e0a73a39a3ac', null);
INSERT INTO `apt_resource` VALUES ('3b60abd258d243f58cd02b2308fc9342', '显示User编辑页面', 'url', 'UrpAction/showUserMsg', '1', '0', '0', '1473412c018c453894ef7a798f15fc4f', '');
INSERT INTO `apt_resource` VALUES ('3caa79ce5a9f47a485a4bd551d37bd61', '查询团队成员', 'url', 'GetBGDataAction/advancedSearchMember', '1', '0', '0', 'ba43333b6db84a9ca69a57b5f1a780eb', null);
INSERT INTO `apt_resource` VALUES ('3f83f77642c2498bb5e120f95cb1240d', '推荐图书', 'menu', 'none', '1', '1', '4', 'b1a5d3afb00d4e93a01b2183e7b7bfcf', null);
INSERT INTO `apt_resource` VALUES ('404531dd3cbd43f8a27e71d6f8b6299f', '任务分配预处理', 'url', 'PersonalAction/preSendTask', '1', '0', '0', 'f0f801f623544e70b1d99839965dd678', '');
INSERT INTO `apt_resource` VALUES ('40c1b600aec247b4a7f588c1a8e2946f', '添加产品', 'url', 'GetBGDataAction/addProduct', '1', '0', '0', '3f64e72b2905443db088e0a73a39a3ac', null);
INSERT INTO `apt_resource` VALUES ('41628b73637e4d1da3e82a4be2c3a779', '新增User', 'url', 'UrpAction/addUser', '1', '0', '0', '1473412c018c453894ef7a798f15fc4f', '');
INSERT INTO `apt_resource` VALUES ('44fea6825e8b422eb2c1125a505de0f5', 'MainAction/left', 'url', 'MainAction/left', '1', '0', '0', '1276a17e10fd4de6974aa4b4902c8773', null);
INSERT INTO `apt_resource` VALUES ('49800146c94c49d9b57b612681df9a60', '用户管理', 'menu', 'MembersAction/manager-user', '1', '1', '5', '403c75e4180e4ec688dac04fb56acda6', null);
INSERT INTO `apt_resource` VALUES ('4a9c5a9c052b4a898428951b7fced582', '权限管理', 'menu', 'MembersAction/manager-permission', '1', '3', '5', '403c75e4180e4ec688dac04fb56acda6', null);
INSERT INTO `apt_resource` VALUES ('4f3d3d659cbf4f77b2a8b023125f0716', 'User取消关联Role', 'url', 'UrpAction/UserUnBindRole', '1', '0', '0', '1473412c018c453894ef7a798f15fc4f', '');
INSERT INTO `apt_resource` VALUES ('511073a01eb54b84abf6bb9d2ecd2620', '删除Role', 'url', 'UrpAction/deleteRole', '1', '0', '0', '1473412c018c453894ef7a798f15fc4f', '');
INSERT INTO `apt_resource` VALUES ('5748d14949034c398ca7f2df19f38685', '显示RolePermission编辑页面', 'url', 'UrpAction/showRolePermission', '1', '0', '0', '1473412c018c453894ef7a798f15fc4f', '');
INSERT INTO `apt_resource` VALUES ('60b8838937184e98b7bc45694d92cbd4', 'showPermissionResource', 'url', 'UrpAction/showPermissionResource', '1', '0', '0', '1473412c018c453894ef7a798f15fc4f', '');
INSERT INTO `apt_resource` VALUES ('62416d097bcc42fbb412c7388ee4b233', '显示Resource编辑页面', 'url', 'UrpAction/showResourceMsg', '1', '0', '0', '1473412c018c453894ef7a798f15fc4f', '');
INSERT INTO `apt_resource` VALUES ('63115c5078094049b97dbd2c2d7b1061', '所有成员', 'menu', 'MembersAction/member-allmembers', '1', '1', '3', 'fdc3da26621142a18e038ad3970895c8', null);
INSERT INTO `apt_resource` VALUES ('656c6fc74d7242ec806e27af4f98445f', '删除User', 'url', 'UrpAction/deleteUser', '1', '0', '0', '1473412c018c453894ef7a798f15fc4f', '');
INSERT INTO `apt_resource` VALUES ('66404887d7274d6e87969be08fd0897b', '编辑团队成员预处理', 'url', 'GetBGDataAction/preEditMember', '1', '0', '0', 'ba43333b6db84a9ca69a57b5f1a780eb', null);
INSERT INTO `apt_resource` VALUES ('686c056f77f74707af1b90809f6aecbb', '修改Permission', 'url', 'UrpAction/modifyPermission', '1', '0', '0', '1473412c018c453894ef7a798f15fc4f', '');
INSERT INTO `apt_resource` VALUES ('68b83504da0a4186916c4cf996849435', '删除团队成员', 'url', 'GetBGDataAction/deleteMember', '1', '0', '0', 'ba43333b6db84a9ca69a57b5f1a780eb', null);
INSERT INTO `apt_resource` VALUES ('68fab0eae72549878d108cb74e73b9c0', '修改Resource', 'url', 'UrpAction/modifyResource', '1', '0', '0', '1473412c018c453894ef7a798f15fc4f', '');
INSERT INTO `apt_resource` VALUES ('6bea51387dcd47bfa139e6215785aca2', '数据统计', 'menu', 'none', '1', '3', '4', 'b1a5d3afb00d4e93a01b2183e7b7bfcf', null);
INSERT INTO `apt_resource` VALUES ('6d19394b403f418f872420cd4a40265f', '添加滚动大图', 'url', 'GetBGDataAction/addWebGunPic', '1', '0', '0', '0cc40764e28d417c93d78736f132a6b9', null);
INSERT INTO `apt_resource` VALUES ('7340ae0cd8384c89bdacccb4d4ab0a2d', '删除产品', 'url', 'GetBGDataAction/deleteProduct', '1', '0', '0', '3f64e72b2905443db088e0a73a39a3ac', null);
INSERT INTO `apt_resource` VALUES ('7698db3bc6c34dbb91456fba369b8074', '添加团队成员', 'url', 'GetBGDataAction/addMember', '1', '0', '0', 'ba43333b6db84a9ca69a57b5f1a780eb', null);
INSERT INTO `apt_resource` VALUES ('782404dfb6c248c2ae1c7a8f48afa8cf', '删除Permission', 'url', 'UrpAction/deletePermission', '1', '0', '0', '1473412c018c453894ef7a798f15fc4f', '');
INSERT INTO `apt_resource` VALUES ('7cce1027eab740bbb096b4185802bc08', '删除滚动大图', 'url', 'GetBGDataAction/deleteWebGunPic', '1', '0', '0', '0cc40764e28d417c93d78736f132a6b9', null);
INSERT INTO `apt_resource` VALUES ('7f7f4b890664447dbe76a90089ca6eef', '查询游客留言', 'url', 'GetBGDataAction/advancedSearchVisitorMessage', '1', '0', '0', 'c336c136df1c4b629cea0a90c57640fd', null);
INSERT INTO `apt_resource` VALUES ('81a9b6a526034eeda9ea288423ba585d', '获取任务详情', 'url', 'PersonalAction/seeDetails', '1', '0', '0', 'f0f801f623544e70b1d99839965dd678', '');
INSERT INTO `apt_resource` VALUES ('83557059e421490697ace25db8c0f90e', '删除任务', 'url', 'PersonalAction/deleteTask', '1', '0', '0', 'f0f801f623544e70b1d99839965dd678', '');
INSERT INTO `apt_resource` VALUES ('89a3d92f87ab4ab3aa4e3656252f35f9', '新增Resource', 'url', 'UrpAction/addResource', '1', '0', '0', '1473412c018c453894ef7a798f15fc4f', '');
INSERT INTO `apt_resource` VALUES ('8b8b15a14a734653bf3f41965513ae58', '人员介绍', 'menu', 'GetBGDataAction/findMemberPage', '1', '3', '2', '270e83b0b6854e3090edd3d7c2bee3b6', null);
INSERT INTO `apt_resource` VALUES ('8c01e063102c45398a718af7752fa135', '联系我们', 'menu', 'GetBGDataAction/findVisitorMessagePage', '1', '4', '2', '270e83b0b6854e3090edd3d7c2bee3b6', null);
INSERT INTO `apt_resource` VALUES ('8fbd4fc299974af58cdb09cc00f96836', '个人信息', 'menu', 'PersonalAction/message', '1', '1', '1', '2fdb71cbe90443d78cf7ec011f119d11', null);
INSERT INTO `apt_resource` VALUES ('9127cc956824424fa684251a94be6bc1', '新增Role', 'url', 'UrpAction/addRole', '1', '0', '0', '1473412c018c453894ef7a798f15fc4f', '');
INSERT INTO `apt_resource` VALUES ('91b68089cb7a4fff9de09ecf3e621cbe', '修改User', 'url', 'UrpAction/modifyUser', '1', '0', '0', '1473412c018c453894ef7a798f15fc4f', '');
INSERT INTO `apt_resource` VALUES ('947a82a74b184a819df79b941779f496', '搜索User', 'url', 'UrpAction/searchUser', '1', '0', '0', '1473412c018c453894ef7a798f15fc4f', '');
INSERT INTO `apt_resource` VALUES ('96a375c4d48941f1a9c3adb792e8fa03', '密码重置', 'menu', 'PersonalAction/resetPassword', '1', '3', '1', '2fdb71cbe90443d78cf7ec011f119d11', null);
INSERT INTO `apt_resource` VALUES ('9a571d97ebb34d2fb51bd73b4892f25b', '显示UserRole编辑页面', 'url', 'UrpAction/showUserRole', '1', '0', '0', '1473412c018c453894ef7a798f15fc4f', '');
INSERT INTO `apt_resource` VALUES ('9bb99738ae464273abea5ebd2932aaf7', '搜索Role', 'url', 'UrpAction/searchRole', '1', '0', '0', '1473412c018c453894ef7a798f15fc4f', '');
INSERT INTO `apt_resource` VALUES ('9f1827083ff943f7b6002ecfd65311eb', '删除游客留言', 'url', 'GetBGDataAction/deleteVisitorMessage', '1', '0', '0', 'c336c136df1c4b629cea0a90c57640fd', null);
INSERT INTO `apt_resource` VALUES ('ac0ac6b92430475bb14d3f87131a09d0', '闲时统计', 'menu', 'MembersAction/member-countFreeTime', '1', '2', '3', 'fdc3da26621142a18e038ad3970895c8', null);
INSERT INTO `apt_resource` VALUES ('ad53ce6f508b4d1ea12fcf8fcfe6de86', '项目成员提交任务预处理', 'url', 'PersonalAction/preSubmitTask', '1', '0', '0', '274c023e0f214d92a7055b19851d4f6c', '');
INSERT INTO `apt_resource` VALUES ('af0a0a071f2c458097d75746703113a3', '成员管理', 'menu', 'none', '1', '3', '0', 'fdc3da26621142a18e038ad3970895c8', null);
INSERT INTO `apt_resource` VALUES ('af631ad00308446ab437a6197d7f2919', '任务', 'menu', 'PersonalAction/task', '1', '4', '1', '2fdb71cbe90443d78cf7ec011f119d11', null);
INSERT INTO `apt_resource` VALUES ('b5edf8821fde48f2b591a4edc80320eb', 'SchedulesAction/insert', 'url', 'SchedulesAction/insert', '1', '0', '0', 'b03b04c33b6a4e0194c5bb8576924b60', null);
INSERT INTO `apt_resource` VALUES ('b7447299f6dd44258c04f07f5afed7a1', 'User关联Role', 'url', 'UrpAction/UserBindRole', '1', '0', '0', '1473412c018c453894ef7a798f15fc4f', '');
INSERT INTO `apt_resource` VALUES ('b92b0d26e89a4d1ab7b34b64677396fa', '编辑产品预处理', 'url', 'GetBGDataAction/preEditProduct', '1', '0', '0', '3f64e72b2905443db088e0a73a39a3ac', null);
INSERT INTO `apt_resource` VALUES ('c0737159eded42e8bd6b01dcd297f7b8', '显示Role编辑页面', 'url', 'UrpAction/showRoleMsg', '1', '0', '0', '1473412c018c453894ef7a798f15fc4f', '');
INSERT INTO `apt_resource` VALUES ('c0e8af82bc244f5e9da859007168259e', 'Permission取消关联Resource', 'url', 'UrpAction/PermissionUnBindResource', '1', '0', '0', '1473412c018c453894ef7a798f15fc4f', '');
INSERT INTO `apt_resource` VALUES ('c3ddc5ddc2274f6fa74300bdca9ac391', '删除Resource', 'url', 'UrpAction/deleteResource', '1', '0', '0', '1473412c018c453894ef7a798f15fc4f', '');
INSERT INTO `apt_resource` VALUES ('c7bdb6002453492292f659592af60961', 'SchedulesAction/count', 'url', 'SchedulesAction/count', '1', '0', '0', '1c3ab539ffcd467aaa42d5531eaa9040', null);
INSERT INTO `apt_resource` VALUES ('c8c89ba469314a7194ccd091b18ca4d0', '项目经理获取历史任务', 'url', 'PersonalAction/taskSendingList', '1', '0', '0', 'f0f801f623544e70b1d99839965dd678', '');
INSERT INTO `apt_resource` VALUES ('cfb9767f78ed4f3dab4a723c08cdadc2', '搜索Resource', 'url', 'UrpAction/searchResource', '1', '0', '0', '1473412c018c453894ef7a798f15fc4f', '');
INSERT INTO `apt_resource` VALUES ('d22c950d1479442ea4646715fc048b0c', '资源管理', 'menu', 'MembersAction/manager-resource', '1', '4', '5', '403c75e4180e4ec688dac04fb56acda6', null);
INSERT INTO `apt_resource` VALUES ('d48dcb822163439facc5cdfd1404cf12', '项目普通成员获取任务', 'url', 'PersonalAction/taskReceivingList', '1', '0', '0', '274c023e0f214d92a7055b19851d4f6c', '');
INSERT INTO `apt_resource` VALUES ('d4f3349cd8dc40d9a0a5699a56b74c99', '项目普通成员提交任务', 'url', 'PersonalAction/submitTask', '1', '0', '0', '274c023e0f214d92a7055b19851d4f6c', '');
INSERT INTO `apt_resource` VALUES ('d58df2a244dc47d29af3bac64839f00e', '空闲时间', 'menu', 'PersonalAction/schedule', '1', '2', '1', '2fdb71cbe90443d78cf7ec011f119d11', null);
INSERT INTO `apt_resource` VALUES ('d68fb611c72342819795b5737947716e', 'Role取消关联Permission', 'url', 'UrpAction/RoleUnBindPermission', '1', '0', '0', '1473412c018c453894ef7a798f15fc4f', '');
INSERT INTO `apt_resource` VALUES ('dbfb2c56c1c143cbba69913791d121b1', '新增Permission', 'url', 'UrpAction/addPermission', '1', '0', '0', '1473412c018c453894ef7a798f15fc4f', '');
INSERT INTO `apt_resource` VALUES ('e52a6884cbc54bc5873d048eafa51c90', '权限设置', 'menu', 'none', '1', '5', '0', '403c75e4180e4ec688dac04fb56acda6', null);
INSERT INTO `apt_resource` VALUES ('eb11696406e64c8dad8faabd937604d0', '首页管理', 'menu', 'none', '1', '2', '0', '270e83b0b6854e3090edd3d7c2bee3b6', null);
INSERT INTO `apt_resource` VALUES ('ecdb68cb89394ecca30c875e9ca71fe0', '编辑滚动大图', 'url', 'GetBGDataAction/editWebGunPic', '1', '0', '0', '0cc40764e28d417c93d78736f132a6b9', null);
INSERT INTO `apt_resource` VALUES ('ed986c60906f496081314d457be42a4e', '产品介绍', 'menu', 'GetBGDataAction/findProductPage', '1', '2', '2', '270e83b0b6854e3090edd3d7c2bee3b6', null);
INSERT INTO `apt_resource` VALUES ('f75532c5ba014cc0bbafaafbb1e6c2c1', '滚动大图', 'menu', 'GetBGDataAction/findWebGunPicPage', '1', '1', '2', '270e83b0b6854e3090edd3d7c2bee3b6', null);
INSERT INTO `apt_resource` VALUES ('f87109e59a3147939954d10263c1e4f2', '角色管理', 'menu', 'MembersAction/manager-role', '1', '2', '5', '403c75e4180e4ec688dac04fb56acda6', null);
INSERT INTO `apt_resource` VALUES ('fbc285f6dda94b0c9718c0e4d39d6ec9', '显示Permission编辑页面', 'url', 'UrpAction/showPermissionMsg', '1', '0', '0', '1473412c018c453894ef7a798f15fc4f', '');
INSERT INTO `apt_resource` VALUES ('fc4bb9be126e42dbb67e8ce8c72eeabf', 'MainAction/top', 'url', 'MainAction/top', '1', '0', '0', 'c72ccd4a4ed74eac85bf184c50b7dcc6', null);
INSERT INTO `apt_resource` VALUES ('fde01154448145f38eaafb39fb81c7e1', '图书管理', 'menu', 'none', '1', '4', '0', 'b1a5d3afb00d4e93a01b2183e7b7bfcf', null);
INSERT INTO `apt_resource` VALUES ('ff6dea514df044058509e45241e754b0', 'Role关联Permission', 'url', 'UrpAction/RoleBindPermission', '1', '0', '0', '1473412c018c453894ef7a798f15fc4f', '');

-- ----------------------------
-- Table structure for apt_role
-- ----------------------------
DROP TABLE IF EXISTS `apt_role`;
CREATE TABLE `apt_role` (
  `id` varchar(50) NOT NULL,
  `name` varchar(45) NOT NULL COMMENT '角色名',
  `description` varchar(45) NOT NULL COMMENT '角色描述，用于前台显示',
  `available` int(11) NOT NULL DEFAULT '1' COMMENT '角色是否可用，0-否，1-是',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='权限表';

-- ----------------------------
-- Records of apt_role
-- ----------------------------
INSERT INTO `apt_role` VALUES ('1255454fb1c5400a80b77e17cbd59607', 'superManager', '超级管理员', '1', null);
INSERT INTO `apt_role` VALUES ('16da2b1b91a2426c8700d0754751cc8e', 'studentManager', '人员系统管理员', '1', '');
INSERT INTO `apt_role` VALUES ('25e4957dab534b1ab97ca1c6af1dd38a', 'websiteManager', '工作室网站管理员', '1', null);
INSERT INTO `apt_role` VALUES ('3c6fd9e0c4cc41f7be8c907ad60d742e', 'nomalUser', '普通用户', '1', '');

-- ----------------------------
-- Table structure for apt_role_permission
-- ----------------------------
DROP TABLE IF EXISTS `apt_role_permission`;
CREATE TABLE `apt_role_permission` (
  `id` varchar(50) NOT NULL,
  `role_id` varchar(50) NOT NULL,
  `permission_id` varchar(50) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of apt_role_permission
-- ----------------------------
INSERT INTO `apt_role_permission` VALUES ('03240ef94bcf43e3a3accf541d4758ef', '1255454fb1c5400a80b77e17cbd59607', 'b1a5d3afb00d4e93a01b2183e7b7bfcf');
INSERT INTO `apt_role_permission` VALUES ('0993d541a7f7473d86156fadad7a0235', '1255454fb1c5400a80b77e17cbd59607', '1473412c018c453894ef7a798f15fc4f');
INSERT INTO `apt_role_permission` VALUES ('1a30c5de660449fa901f3c8ca3d6fdea', '3c6fd9e0c4cc41f7be8c907ad60d742e', '2fdb71cbe90443d78cf7ec011f119d11');
INSERT INTO `apt_role_permission` VALUES ('22247a39de7a43e3b2e7eaefd47f285f', '1255454fb1c5400a80b77e17cbd59607', '0cc40764e28d417c93d78736f132a6b9');
INSERT INTO `apt_role_permission` VALUES ('316cdbd5eb7846549ffc80bc5a53d6cb', '16da2b1b91a2426c8700d0754751cc8e', '1c3ab539ffcd467aaa42d5531eaa9040');
INSERT INTO `apt_role_permission` VALUES ('482ad3adfea44477b1a01e43d0860fcb', '25e4957dab534b1ab97ca1c6af1dd38a', 'c72ccd4a4ed74eac85bf184c50b7dcc6');
INSERT INTO `apt_role_permission` VALUES ('4b189c3086cc4937968e40f4501b8966', '16da2b1b91a2426c8700d0754751cc8e', '4a90d59d2bd94faab34da74099cdfb08');
INSERT INTO `apt_role_permission` VALUES ('50c0b3258b194351a70d01e5d66b8883', '1255454fb1c5400a80b77e17cbd59607', '1276a17e10fd4de6974aa4b4902c8773');
INSERT INTO `apt_role_permission` VALUES ('5c9a0a1d544e446dafa7305aecc8cca9', '1255454fb1c5400a80b77e17cbd59607', 'b03b04c33b6a4e0194c5bb8576924b60');
INSERT INTO `apt_role_permission` VALUES ('64f3fdda640e4fa7a27dea53eae89585', '16da2b1b91a2426c8700d0754751cc8e', 'fdc3da26621142a18e038ad3970895c8');
INSERT INTO `apt_role_permission` VALUES ('65bfedb13d324c6193a293e0b3d37a29', '16da2b1b91a2426c8700d0754751cc8e', 'b03b04c33b6a4e0194c5bb8576924b60');
INSERT INTO `apt_role_permission` VALUES ('691db75fbcfc4923a267b24eda1cb763', '1255454fb1c5400a80b77e17cbd59607', '2fdb71cbe90443d78cf7ec011f119d11');
INSERT INTO `apt_role_permission` VALUES ('76f82cae627d45919a33c21cb63b4db9', '16da2b1b91a2426c8700d0754751cc8e', 'c72ccd4a4ed74eac85bf184c50b7dcc6');
INSERT INTO `apt_role_permission` VALUES ('782c09c908ce404f9f868c312b216b2a', '25e4957dab534b1ab97ca1c6af1dd38a', '270e83b0b6854e3090edd3d7c2bee3b6');
INSERT INTO `apt_role_permission` VALUES ('8675391143724d9d87e8ca210f86e7e5', '25e4957dab534b1ab97ca1c6af1dd38a', '4a90d59d2bd94faab34da74099cdfb08');
INSERT INTO `apt_role_permission` VALUES ('8a37d63a9afa4b8eb58cb36a8b40b005', '25e4957dab534b1ab97ca1c6af1dd38a', '1276a17e10fd4de6974aa4b4902c8773');
INSERT INTO `apt_role_permission` VALUES ('8efabbb1f3e440b0a91a9820de0f5b95', '1255454fb1c5400a80b77e17cbd59607', 'c72ccd4a4ed74eac85bf184c50b7dcc6');
INSERT INTO `apt_role_permission` VALUES ('900041404c454266a8c72ebb1120a94a', '1255454fb1c5400a80b77e17cbd59607', '1c3ab539ffcd467aaa42d5531eaa9040');
INSERT INTO `apt_role_permission` VALUES ('a56aaa6e4b5940c6a07eb6db6b3dd414', '1255454fb1c5400a80b77e17cbd59607', 'ba43333b6db84a9ca69a57b5f1a780eb');
INSERT INTO `apt_role_permission` VALUES ('ae5c9680f9f746a993f5019abe421edb', '1255454fb1c5400a80b77e17cbd59607', 'fdc3da26621142a18e038ad3970895c8');
INSERT INTO `apt_role_permission` VALUES ('b256314ba741491eba21c8b5679f1118', '1255454fb1c5400a80b77e17cbd59607', '274c023e0f214d92a7055b19851d4f6c');
INSERT INTO `apt_role_permission` VALUES ('b3365c8a1c5743e1831694812416c296', '1255454fb1c5400a80b77e17cbd59607', '4a90d59d2bd94faab34da74099cdfb08');
INSERT INTO `apt_role_permission` VALUES ('c17f53e7452a4d53b3f42fd5e355acdb', '1255454fb1c5400a80b77e17cbd59607', 'f0f801f623544e70b1d99839965dd678');
INSERT INTO `apt_role_permission` VALUES ('c81ddbd33b2f46828a3c4c68a098de17', '1255454fb1c5400a80b77e17cbd59607', '9be7ed5dcd30472b86bc4b08213bf612');
INSERT INTO `apt_role_permission` VALUES ('c87bcb77a1ea4b1fbf9875494fe5402a', '1255454fb1c5400a80b77e17cbd59607', '403c75e4180e4ec688dac04fb56acda6');
INSERT INTO `apt_role_permission` VALUES ('ce9cd3d8b10c4d79b1e14f52dc6c2bb1', '1255454fb1c5400a80b77e17cbd59607', '270e83b0b6854e3090edd3d7c2bee3b6');
INSERT INTO `apt_role_permission` VALUES ('db15a1cdb5a14f0ea2565aeaccaec8c1', '1255454fb1c5400a80b77e17cbd59607', 'c336c136df1c4b629cea0a90c57640fd');
INSERT INTO `apt_role_permission` VALUES ('de0b92b1d16b45eeb6aa224bf26144c2', '16da2b1b91a2426c8700d0754751cc8e', '1276a17e10fd4de6974aa4b4902c8773');
INSERT INTO `apt_role_permission` VALUES ('e17ddf9ad36147c1b7f25fb7644d29e8', '3c6fd9e0c4cc41f7be8c907ad60d742e', '9be7ed5dcd30472b86bc4b08213bf612');
INSERT INTO `apt_role_permission` VALUES ('fac7fdbe805a494f97e0adb77edb3498', '1255454fb1c5400a80b77e17cbd59607', '3f64e72b2905443db088e0a73a39a3ac');

-- ----------------------------
-- Table structure for apt_shipping_address
-- ----------------------------
DROP TABLE IF EXISTS `apt_shipping_address`;
CREATE TABLE `apt_shipping_address` (
  `id` varchar(50) NOT NULL DEFAULT '',
  `user_id` varchar(50) NOT NULL COMMENT '用户id',
  `country` varchar(10) NOT NULL DEFAULT '中国大陆',
  `province` varchar(15) DEFAULT NULL COMMENT '省份',
  `city` varchar(15) DEFAULT NULL COMMENT '城市',
  `county` varchar(15) DEFAULT NULL COMMENT '县区',
  `street` varchar(15) DEFAULT NULL,
  `detail_address` varchar(255) NOT NULL DEFAULT '不知' COMMENT '详细地址',
  `postcode` varchar(6) NOT NULL DEFAULT '000000' COMMENT '邮编',
  `consignee_name` varchar(25) NOT NULL COMMENT '收货人姓名',
  `cellphone` varchar(25) DEFAULT NULL COMMENT '手机号码',
  `telephone` varchar(25) DEFAULT NULL,
  `flag` int(11) NOT NULL DEFAULT '0' COMMENT '标记为默认收货地址，0--非默认，1--默认',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='收货地址表';

-- ----------------------------
-- Records of apt_shipping_address
-- ----------------------------

-- ----------------------------
-- Table structure for apt_shop
-- ----------------------------
DROP TABLE IF EXISTS `apt_shop`;
CREATE TABLE `apt_shop` (
  `id` varchar(50) NOT NULL,
  `name` varchar(50) NOT NULL,
  `brief` varchar(140) DEFAULT NULL COMMENT '简介',
  `introduction` varchar(500) DEFAULT NULL COMMENT '详细信息',
  `contact` varchar(45) DEFAULT NULL COMMENT '联系我们',
  `user_id` varchar(50) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='店铺表';

-- ----------------------------
-- Records of apt_shop
-- ----------------------------

-- ----------------------------
-- Table structure for apt_shopping_cart
-- ----------------------------
DROP TABLE IF EXISTS `apt_shopping_cart`;
CREATE TABLE `apt_shopping_cart` (
  `id` varchar(50) NOT NULL,
  `user_id` varchar(50) NOT NULL COMMENT '用户id',
  `commodity_id` varchar(50) NOT NULL COMMENT '商品id',
  `commodity_count` int(11) NOT NULL DEFAULT '1' COMMENT '商品数量',
  `shop_id` varchar(50) NOT NULL COMMENT '店铺id',
  `status` int(11) NOT NULL DEFAULT '0' COMMENT '订单状态，0--未完成，1--完成',
  `time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of apt_shopping_cart
-- ----------------------------

-- ----------------------------
-- Table structure for apt_special_offer
-- ----------------------------
DROP TABLE IF EXISTS `apt_special_offer`;
CREATE TABLE `apt_special_offer` (
  `id` varchar(50) NOT NULL,
  `commodity_id` varchar(45) NOT NULL COMMENT '商品id',
  `sequence` int(11) NOT NULL DEFAULT '0' COMMENT '顺序',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='今日特价专区表';

-- ----------------------------
-- Records of apt_special_offer
-- ----------------------------

-- ----------------------------
-- Table structure for apt_sub_nav
-- ----------------------------
DROP TABLE IF EXISTS `apt_sub_nav`;
CREATE TABLE `apt_sub_nav` (
  `id` varchar(50) NOT NULL,
  `name` varchar(15) NOT NULL COMMENT '栏目名',
  `sequence` int(11) NOT NULL DEFAULT '0' COMMENT '顺序',
  `main_nav_id` varchar(50) NOT NULL COMMENT '表示栏目属于哪个主栏目',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='主导航栏表';

-- ----------------------------
-- Records of apt_sub_nav
-- ----------------------------
INSERT INTO `apt_sub_nav` VALUES ('01297f2b71b44f5f83f2e022a6033fb3', '车厘子', '0', 'c98b4d524e6743d49d45450872ad8180');
INSERT INTO `apt_sub_nav` VALUES ('07925a9ba61c44fcb8e7d28e86ade12d', '杨梅', '11', '0e488df5754d4ca7af4f1f029f1357ea');
INSERT INTO `apt_sub_nav` VALUES ('07b7afb9faaf483a82574161f9ffb102', '李杏', '3', '7a8a1dc6aa824921897fc69d46d56a40');
INSERT INTO `apt_sub_nav` VALUES ('0bd9a8de986b4548a62e7554a29ac739', '山竹', '9', '0e488df5754d4ca7af4f1f029f1357ea');
INSERT INTO `apt_sub_nav` VALUES ('14edfed331a04297b3e19de299c5fe52', '无花果', '8', '7a8a1dc6aa824921897fc69d46d56a40');
INSERT INTO `apt_sub_nav` VALUES ('162a8325defe4267926271bbebed2950', '柑橙', '7', '0e488df5754d4ca7af4f1f029f1357ea');
INSERT INTO `apt_sub_nav` VALUES ('193ebabfffe441a6b22f77334416577d', '木瓜', '12', '0e488df5754d4ca7af4f1f029f1357ea');
INSERT INTO `apt_sub_nav` VALUES ('19a5872f493046f4839844a039013b20', '荔枝', '3', 'c98b4d524e6743d49d45450872ad8180');
INSERT INTO `apt_sub_nav` VALUES ('2257e2ea268c4ff8926f5871e116df9e', '柠檬', '2', '7a8a1dc6aa824921897fc69d46d56a40');
INSERT INTO `apt_sub_nav` VALUES ('251bc50f615e47888c0a696dec772cfa', '人参果', '10', 'c98b4d524e6743d49d45450872ad8180');
INSERT INTO `apt_sub_nav` VALUES ('25ffee740a204946bd133ec0c1d6a87b', '樱桃', '6', 'c98b4d524e6743d49d45450872ad8180');
INSERT INTO `apt_sub_nav` VALUES ('3b0e791bacff44c8bc1a1772fde483eb', '罗汉果', '16', '7a8a1dc6aa824921897fc69d46d56a40');
INSERT INTO `apt_sub_nav` VALUES ('3f2ab47f28a8477fac8644d30adf30f9', '西瓜', '3', '0e488df5754d4ca7af4f1f029f1357ea');
INSERT INTO `apt_sub_nav` VALUES ('419141795f654c9d875b96d5b8174a39', '提子', '7', '7a8a1dc6aa824921897fc69d46d56a40');
INSERT INTO `apt_sub_nav` VALUES ('490e443a9c2b4300b8c47e25d42de357', '杨桃', '10', '0e488df5754d4ca7af4f1f029f1357ea');
INSERT INTO `apt_sub_nav` VALUES ('5330900ce5304cdcaedf2cbc40481069', '椰子', '13', 'c98b4d524e6743d49d45450872ad8180');
INSERT INTO `apt_sub_nav` VALUES ('5a22670ba9e04fe9b6ff6b42d70fc38b', '芒果', '2', 'c98b4d524e6743d49d45450872ad8180');
INSERT INTO `apt_sub_nav` VALUES ('60b22c23b9874dfc833945ea500e2ee0', '草莓', '8', '0e488df5754d4ca7af4f1f029f1357ea');
INSERT INTO `apt_sub_nav` VALUES ('663ca558710c403a958be8705e38a379', '香蕉', '4', '7a8a1dc6aa824921897fc69d46d56a40');
INSERT INTO `apt_sub_nav` VALUES ('68b22b96701f429090f5966573cc5bfb', '枇杷', '15', '0e488df5754d4ca7af4f1f029f1357ea');
INSERT INTO `apt_sub_nav` VALUES ('70bad72188344c45809f7e9275d9c715', '蛇果', '14', '7a8a1dc6aa824921897fc69d46d56a40');
INSERT INTO `apt_sub_nav` VALUES ('7ce90218e7dc46d98b70f355455ed935', '香瓜', '12', 'c98b4d524e6743d49d45450872ad8180');
INSERT INTO `apt_sub_nav` VALUES ('85277288737546e98973623824c3b694', '鸡蛋果', '15', '7a8a1dc6aa824921897fc69d46d56a40');
INSERT INTO `apt_sub_nav` VALUES ('859d79ecb825445eb5c08afe8585e152', '柿子', '9', 'c98b4d524e6743d49d45450872ad8180');
INSERT INTO `apt_sub_nav` VALUES ('8b97081b98b74b379622bb8df2cd99af', '莲雾', '14', 'c98b4d524e6743d49d45450872ad8180');
INSERT INTO `apt_sub_nav` VALUES ('8c698bcfb0734fbabd0b2d827bb2ba90', '火龙果', '1', 'c98b4d524e6743d49d45450872ad8180');
INSERT INTO `apt_sub_nav` VALUES ('8d1f924b1a9b49b59a2379a773a623d8', '哈密瓜', '4', '0e488df5754d4ca7af4f1f029f1357ea');
INSERT INTO `apt_sub_nav` VALUES ('8f2532b99a124c068f99fe5f45aeeb6a', '柚', '1', '7a8a1dc6aa824921897fc69d46d56a40');
INSERT INTO `apt_sub_nav` VALUES ('96de956195ef40ada2dddd97fcfae796', '葡萄', '6', '7a8a1dc6aa824921897fc69d46d56a40');
INSERT INTO `apt_sub_nav` VALUES ('979baa8359f14bad9f19e372dda7640d', '梨', '2', '0e488df5754d4ca7af4f1f029f1357ea');
INSERT INTO `apt_sub_nav` VALUES ('9f991e5357bb408c96e4b830e7a656b6', '榴莲', '8', 'c98b4d524e6743d49d45450872ad8180');
INSERT INTO `apt_sub_nav` VALUES ('a239f1eb1a4648a0840bd549c2d16683', '橄榄', '11', 'c98b4d524e6743d49d45450872ad8180');
INSERT INTO `apt_sub_nav` VALUES ('a39b17b2a1d1408dbbf80d02b4e2b813', '板栗', '10', '7a8a1dc6aa824921897fc69d46d56a40');
INSERT INTO `apt_sub_nav` VALUES ('a3b90930737241feb48137628c0b19b7', '番石榴', '13', '7a8a1dc6aa824921897fc69d46d56a40');
INSERT INTO `apt_sub_nav` VALUES ('a93bc721f423481e8dec851a2298c6c3', '猕猴桃', '5', '0e488df5754d4ca7af4f1f029f1357ea');
INSERT INTO `apt_sub_nav` VALUES ('c3bf8616b1824ec383eb201d4009878e', '冬枣', '14', '0e488df5754d4ca7af4f1f029f1357ea');
INSERT INTO `apt_sub_nav` VALUES ('c44a2e3539f04f8da8bfb3b64f6909da', '龙眼', '4', 'c98b4d524e6743d49d45450872ad8180');
INSERT INTO `apt_sub_nav` VALUES ('cefae89398564479a1d9102428b46cee', '菠萝', '7', 'c98b4d524e6743d49d45450872ad8180');
INSERT INTO `apt_sub_nav` VALUES ('d1308a6a9efe4f37be5cb051467c4ad1', '桃桔', '6', '0e488df5754d4ca7af4f1f029f1357ea');
INSERT INTO `apt_sub_nav` VALUES ('d26d2e2d34c5457c839a7611b8b9350a', '甘蔗', '5', 'c98b4d524e6743d49d45450872ad8180');
INSERT INTO `apt_sub_nav` VALUES ('d531c9ddf1b24d3b9eb872f6c6e3be81', '黄金瓜', '9', '7a8a1dc6aa824921897fc69d46d56a40');
INSERT INTO `apt_sub_nav` VALUES ('df4d9f12e12a450a9eaade6ad1741c57', '圣女果', '5', '7a8a1dc6aa824921897fc69d46d56a40');
INSERT INTO `apt_sub_nav` VALUES ('f2b328cc7c574f0b8dc4baa4f98d7fa2', '石榴', '13', '0e488df5754d4ca7af4f1f029f1357ea');
INSERT INTO `apt_sub_nav` VALUES ('f62255195bd84a7e9006f4ef63832fc6', '菱角', '11', '7a8a1dc6aa824921897fc69d46d56a40');
INSERT INTO `apt_sub_nav` VALUES ('f6b9c527ad574a1d97d33210f08d6080', '山楂', '12', '7a8a1dc6aa824921897fc69d46d56a40');
INSERT INTO `apt_sub_nav` VALUES ('f8ad07c509a145b5b645943a459db681', '苹果', '1', '0e488df5754d4ca7af4f1f029f1357ea');

-- ----------------------------
-- Table structure for apt_user
-- ----------------------------
DROP TABLE IF EXISTS `apt_user`;
CREATE TABLE `apt_user` (
  `id` varchar(50) NOT NULL,
  `username` varchar(20) NOT NULL,
  `password` varchar(40) NOT NULL,
  `salt` varchar(50) NOT NULL,
  `role` varchar(15) NOT NULL DEFAULT '消费者' COMMENT '账号角色，与role表中的角色不一样。',
  `create_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `available` int(11) NOT NULL DEFAULT '1' COMMENT '账户是否可用，1--可用，0--不可用',
  `remark` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='账户表，存储管理员、用户、商家的账户';

-- ----------------------------
-- Records of apt_user
-- ----------------------------
INSERT INTO `apt_user` VALUES ('f6e17df4e82b4e35b31130b543ae97af', 'admin', '6ba705e0b59fd230f58a21985d721578', 'b5d84235338b4620d9715434f0e0fb94', '消费者', '2015-12-05 08:33:53', '1', null);

-- ----------------------------
-- Table structure for apt_user_group
-- ----------------------------
DROP TABLE IF EXISTS `apt_user_group`;
CREATE TABLE `apt_user_group` (
  `id` varchar(50) NOT NULL DEFAULT '',
  `name` varchar(15) NOT NULL COMMENT '分组名',
  `sequence` int(11) NOT NULL DEFAULT '0' COMMENT '分组顺序',
  `user_id` varchar(50) NOT NULL,
  `flag` int(11) NOT NULL DEFAULT '1' COMMENT '标志',
  PRIMARY KEY (`name`,`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户分组管理表';

-- ----------------------------
-- Records of apt_user_group
-- ----------------------------

-- ----------------------------
-- Table structure for apt_user_message
-- ----------------------------
DROP TABLE IF EXISTS `apt_user_message`;
CREATE TABLE `apt_user_message` (
  `id` varchar(50) NOT NULL,
  `pic` varchar(255) NOT NULL DEFAULT '/static/images/userPic/UserdefaultPic.png' COMMENT '头像',
  `nickname` varchar(25) DEFAULT NULL COMMENT '昵称',
  `realname` varchar(45) DEFAULT NULL COMMENT '真实姓名',
  `sex` int(11) NOT NULL DEFAULT '0' COMMENT '性别，0--男，1--女',
  `birthday` timestamp NULL DEFAULT NULL,
  `residence` varchar(45) DEFAULT NULL COMMENT '居住地',
  `hometown` varchar(45) DEFAULT NULL COMMENT '家乡',
  `user_id` varchar(50) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户个人信息表';

-- ----------------------------
-- Records of apt_user_message
-- ----------------------------

-- ----------------------------
-- Table structure for apt_user_role
-- ----------------------------
DROP TABLE IF EXISTS `apt_user_role`;
CREATE TABLE `apt_user_role` (
  `id` varchar(50) NOT NULL,
  `user_id` varchar(50) NOT NULL,
  `role_id` varchar(50) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of apt_user_role
-- ----------------------------
INSERT INTO `apt_user_role` VALUES ('8c0eb612daa84bb2941c7f4da5e5805a', 'f6e17df4e82b4e35b31130b543ae97af', '1255454fb1c5400a80b77e17cbd59607');
