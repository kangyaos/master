/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50621
Source Host           : localhost:3306
Source Database       : test

Target Server Type    : MYSQL
Target Server Version : 50621
File Encoding         : 65001

Date: 2020-09-26 22:32:33
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for log_exception
-- ----------------------------
DROP TABLE IF EXISTS `log_exception`;
CREATE TABLE `log_exception` (
  `log_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '日志id',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `app_name` varchar(255) DEFAULT NULL COMMENT 'app名称',
  `app_version` varchar(30) DEFAULT NULL COMMENT 'app版本号',
  `user_id` int(11) DEFAULT NULL COMMENT '用户id',
  `user_name` varchar(50) DEFAULT NULL COMMENT '用户名',
  `machine_ip` varchar(50) DEFAULT NULL COMMENT '访问IP',
  `machine_code` varchar(50) DEFAULT NULL COMMENT '机器码',
  `module_name` varchar(50) DEFAULT NULL COMMENT '模块名',
  `operation_name` varchar(500) DEFAULT NULL COMMENT '操作',
  `message` varchar(20000) DEFAULT NULL COMMENT '异常信息',
  `device_type` varchar(50) DEFAULT NULL COMMENT '设备类型',
  `device_brand` varchar(255) DEFAULT NULL COMMENT '设备型号',
  `device_version` varchar(255) DEFAULT NULL COMMENT '系统版本号',
  PRIMARY KEY (`log_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='异常日志';

-- ----------------------------
-- Records of log_exception
-- ----------------------------

-- ----------------------------
-- Table structure for log_operation
-- ----------------------------
DROP TABLE IF EXISTS `log_operation`;
CREATE TABLE `log_operation` (
  `log_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '日志id',
  `app_id` int(11) NOT NULL DEFAULT '1' COMMENT '应用id',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `user_id` int(11) DEFAULT NULL COMMENT '用户id',
  `user_name` varchar(50) DEFAULT NULL COMMENT '用户名',
  `machine_ip` varchar(50) DEFAULT NULL COMMENT '机器ip',
  `module_name` varchar(50) DEFAULT NULL COMMENT '模块名',
  `operation_name` varchar(50) DEFAULT NULL COMMENT '操作',
  `message` text COMMENT '日志信息',
  PRIMARY KEY (`log_id`)
) ENGINE=InnoDB AUTO_INCREMENT=253 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='操作日志';

-- ----------------------------
-- Records of log_operation
-- ----------------------------

-- ----------------------------
-- Table structure for operate_article
-- ----------------------------
DROP TABLE IF EXISTS `operate_article`;
CREATE TABLE `operate_article` (
  `article_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '文章编号',
  `category_id` int(11) NOT NULL COMMENT '栏目编号',
  `title` varchar(100) NOT NULL COMMENT '标题',
  `summary` varchar(500) DEFAULT NULL COMMENT '摘要',
  `source` varchar(255) DEFAULT NULL COMMENT '文章来源',
  `author` varchar(50) DEFAULT NULL COMMENT '作者',
  `editor` varchar(255) DEFAULT NULL COMMENT '编辑人',
  `content` text COMMENT '文章内容',
  `publish_url` varchar(500) DEFAULT NULL COMMENT '发布地址',
  `publish_time` datetime NOT NULL COMMENT '发布时间',
  `publish_state` int(11) DEFAULT '0' COMMENT '发布状态：0、未发布 ；1、已发布 ',
  `tumb_pic_code` varchar(50) DEFAULT NULL COMMENT '内容列表缩略图',
  `tumb_pic_code2` varchar(50) DEFAULT NULL COMMENT '内容列表缩略图',
  `tumb_pic_code3` varchar(50) DEFAULT NULL COMMENT '内容列表缩略图',
  `tumb` varchar(500) DEFAULT NULL COMMENT '缩略图',
  `video_address` varchar(500) DEFAULT NULL COMMENT '视频地址',
  `click_num` int(11) DEFAULT '0' COMMENT '点击量',
  `sort` int(11) DEFAULT NULL COMMENT '排序',
  `is_special` int(11) DEFAULT '0' COMMENT '是否头条：1是0不是',
  `is_send` int(11) DEFAULT '0' COMMENT '是否推送消息',
  `is_picture` int(11) DEFAULT '0' COMMENT '是否图文',
  `enclosure` varchar(2000) DEFAULT NULL COMMENT '附件',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `delete_flag` int(11) NOT NULL DEFAULT '0' COMMENT '删除标记：0，未删除；1、已删除',
  PRIMARY KEY (`article_id`),
  KEY `category_id` (`category_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2771 DEFAULT CHARSET=utf8 COMMENT='新闻文章基本信息表';

-- ----------------------------
-- Records of operate_article
-- ----------------------------
INSERT INTO `operate_article` VALUES ('2763', '7', '明月照我心 天涯共此时——五年级组自主活动报道', '中华传统文化源远流长，为弘扬中华民族的优秀传统文化，增强中华文化自信，培育具有民族精神的未来人才，我们五年级组特举行“明月照我心天涯共此时”优秀手抄报展示活动。', '未知', '五年级班主任', null, '<p style=\"padding:0px;margin:0cm 0cm 0pt;line-height:21px;color:#333333;font-family:宋体;font-size:14px;white-space:normal;text-indent:24pt;\">\r\n	<span style=\"font-family:宋体;\">中华传统文化源远流长，为弘扬中华民族的优秀传统文化，增强中华文化自信，培育具有民族精神的未来人才，我们五年级组特举行“明月照我心天涯共此时”优秀手抄报展示活动。</span>\r\n</p>\r\n<p align=\"center\" style=\"padding:0px;margin:0cm 0cm 0pt;line-height:21px;color:#333333;font-family:宋体;font-size:14px;white-space:normal;text-align:center;\">\r\n	<span lang=\"EN-US\"><img height=\"425\" src=\"http://www.xajdfx.com/UploadFiles/xxxw/2020/9/202009251638344445.jpg\" width=\"567\" style=\"padding:0px;margin:0px;max-width:600px;height:auto;\" /></span>\r\n</p>\r\n<p class=\"MsoNormal\" style=\"padding:0px;margin:0cm 0cm 0pt;line-height:21px;color:#333333;font-family:宋体;font-size:14px;white-space:normal;text-indent:24pt;\">\r\n	<span style=\"line-height:24px;font-size:12pt;\">本次活动本着人人参与的原则，旨在培养学生的传统文化素养及爱国情怀，陶冶学生的艺术情操。激发同学们通过传统节日的习俗等相关知识的了解来表达自己对祖国的传统文化的热爱之情。<span lang=\"EN-US\"></span></span>\r\n</p>\r\n<p class=\"MsoNormal\" style=\"padding:0px;margin:0cm 0cm 0pt;line-height:21px;color:#333333;font-family:宋体;font-size:14px;white-space:normal;text-indent:24pt;\">\r\n	<span lang=\"EN-US\" style=\"line-height:24px;font-size:12pt;\"><img height=\"430\" src=\"http://www.xajdfx.com/UploadFiles/xxxw/2020/9/202009251638348738.jpg\" width=\"567\" style=\"padding:0px;margin:0px;max-width:600px;height:auto;\" /></span>\r\n</p>\r\n<p class=\"MsoNormal\" style=\"padding:0px;margin:0cm 0cm 0pt;line-height:21px;color:#333333;font-family:宋体;font-size:14px;white-space:normal;text-indent:24.1pt;\">\r\n	<b><span lang=\"EN-US\" style=\"line-height:24px;font-size:12pt;\"><img height=\"425\" src=\"http://www.xajdfx.com/UploadFiles/xxxw/2020/9/202009251638348351.jpg\" width=\"567\" style=\"padding:0px;margin:0px;max-width:600px;height:auto;\" /></span></b>\r\n</p>\r\n<p class=\"MsoNormal\" style=\"padding:0px;margin:0cm 0cm 0pt;line-height:21px;color:#333333;font-family:宋体;font-size:14px;white-space:normal;text-indent:24.1pt;\">\r\n	<b><span lang=\"EN-US\" style=\"line-height:24px;font-size:12pt;\"><img height=\"422\" src=\"http://www.xajdfx.com/UploadFiles/xxxw/2020/9/202009251638341239.jpg\" width=\"567\" style=\"padding:0px;margin:0px;max-width:600px;height:auto;\" /></span></b>\r\n</p>\r\n<p class=\"MsoNormal\" style=\"padding:0px;margin:0cm 0cm 0pt;line-height:21px;color:#333333;font-family:宋体;font-size:14px;white-space:normal;text-indent:24.1pt;\">\r\n	<b><span lang=\"EN-US\" style=\"line-height:24px;font-size:12pt;\"><img height=\"424\" src=\"http://www.xajdfx.com/UploadFiles/xxxw/2020/9/202009251638344389.jpg\" width=\"567\" style=\"padding:0px;margin:0px;max-width:600px;height:auto;\" /></span></b><span lang=\"EN-US\" style=\"line-height:24px;font-size:12pt;\"></span>\r\n</p>\r\n<p class=\"MsoNormal\" style=\"padding:0px;margin:0cm 0cm 0pt;line-height:21px;color:#333333;font-family:宋体;font-size:14px;white-space:normal;text-indent:24pt;\">\r\n	<span style=\"line-height:24px;font-size:12pt;\">本次展示活动前期准备充足，同学们能够认真搜集资料，认真制作手抄报。展示过程中，同学们能够一边参观，一边学习。<span lang=\"EN-US\"></span></span>\r\n</p>\r\n<p class=\"MsoNormal\" style=\"padding:0px;margin:0cm 0cm 0pt;line-height:21px;color:#333333;font-family:宋体;font-size:14px;white-space:normal;text-indent:24pt;\">\r\n	<span lang=\"EN-US\" style=\"line-height:24px;font-size:12pt;\"><img height=\"421\" src=\"http://www.xajdfx.com/UploadFiles/xxxw/2020/9/202009251638346919.jpg\" width=\"567\" style=\"padding:0px;margin:0px;max-width:600px;height:auto;\" /></span>\r\n</p>\r\n<p class=\"MsoNormal\" style=\"padding:0px;margin:0cm 0cm 0pt;line-height:21px;color:#333333;font-family:宋体;font-size:14px;white-space:normal;text-indent:24pt;\">\r\n	<span lang=\"EN-US\" style=\"line-height:24px;font-size:12pt;\"><img height=\"417\" src=\"http://www.xajdfx.com/UploadFiles/xxxw/2020/9/202009251638341100.jpg\" width=\"567\" style=\"padding:0px;margin:0px;max-width:600px;height:auto;\" /></span>\r\n</p>\r\n<p class=\"MsoNormal\" style=\"padding:0px;margin:0cm 0cm 0pt;line-height:21px;color:#333333;font-family:宋体;font-size:14px;white-space:normal;text-indent:24pt;\">\r\n	<span style=\"line-height:24px;font-size:12pt;\">通过这样有序的组织，也使孩子们在这次活动中对于传统文化有了进一步的认识，更是增强了民族自豪感和爱国情怀。<span lang=\"EN-US\"></span></span>\r\n</p>\r\n<p class=\"MsoNormal\" style=\"padding:0px;margin:0cm 0cm 0pt;line-height:21px;color:#333333;font-family:宋体;font-size:14px;white-space:normal;text-indent:24pt;\">\r\n	<span lang=\"EN-US\" style=\"line-height:24px;font-size:12pt;\">&nbsp;</span>\r\n</p>\r\n<p class=\"MsoNormal\" style=\"padding:0px;margin:0cm 0cm 0pt;line-height:21px;color:#333333;font-family:宋体;font-size:14px;white-space:normal;text-indent:24pt;\">\r\n	<span lang=\"EN-US\" style=\"line-height:24px;font-size:12pt;\">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span><span style=\"line-height:24px;font-size:12pt;\">文字：高伟<span lang=\"EN-US\">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span>图片：五年级班主任</span>\r\n</p>', null, '2020-09-26 12:10:50', '1', '', null, null, null, null, '1112', null, '0', '0', '0', null, '2020-09-26 11:52:41', '2020-09-26 11:52:41', '0');
INSERT INTO `operate_article` VALUES ('2764', '7', '交大附小第32个全国爱牙日健康知识讲座进课堂', '', '葛睿瑞', '葛睿瑞', null, '<p class=\"MsoNormal\" style=\"padding:0px;margin:0cm 0cm 0pt;line-height:21px;color:#333333;font-family:宋体;font-size:14px;white-space:normal;text-indent:24pt;\">\r\n	<span style=\"line-height:24px;font-size:12pt;\">随着生活质量的提高，人们饮食结构多样化，随之而来的牙齿健康问题也不容忽视，学龄期儿童口腔问题尤为突出，为了更好的培养我校学生爱护牙齿的好习惯，<span lang=\"EN-US\">9</span>月<span lang=\"EN-US\">21</span>日，在第<span lang=\"EN-US\">32</span>个“全国爱牙日”之际我校保健室为三年级部分班级进行爱牙护牙科普知识讲座。</span>\r\n</p>\r\n<p class=\"MsoNormal\" style=\"padding:0px;margin:0cm 0cm 0pt;line-height:21px;color:#333333;font-family:宋体;font-size:14px;white-space:normal;\">\r\n	<span lang=\"EN-US\" style=\"line-height:24px;font-size:12pt;\"><img height=\"417\" src=\"http://www.xajdfx.com/UploadFiles/xxxw/2020/9/202009251636365068.png\" width=\"554\" style=\"padding:0px;margin:0px;max-width:600px;height:auto;\" /></span>\r\n</p>\r\n<p class=\"MsoNormal\" style=\"padding:0px;margin:0cm 0cm 0pt;line-height:21px;color:#333333;font-family:宋体;font-size:14px;white-space:normal;text-indent:24pt;\">\r\n	<span style=\"line-height:24px;font-size:12pt;\">我校保健室王春莉医生用生动形象的<span lang=\"EN-US\">PPT</span>为学生们讲解了基本的口腔知识、常见口腔疾病、尤其是对牙列不齐、牙齿外伤及发生牙齿外伤后该怎么办？什么是六龄牙，并且如何来保护六龄牙做了详细讲解。</span>\r\n</p>\r\n<p class=\"MsoNormal\" style=\"padding:0px;margin:0cm 0cm 0pt;line-height:21px;color:#333333;font-family:宋体;font-size:14px;white-space:normal;\">\r\n	<span lang=\"EN-US\" style=\"line-height:24px;font-size:12pt;\"><img height=\"415\" src=\"http://www.xajdfx.com/UploadFiles/xxxw/2020/9/202009251636363406.jpg\" width=\"554\" style=\"padding:0px;margin:0px;max-width:600px;height:auto;\" /></span>\r\n</p>\r\n<p class=\"MsoNormal\" style=\"padding:0px;margin:0cm 0cm 0pt;line-height:21px;color:#333333;font-family:宋体;font-size:14px;white-space:normal;\">\r\n	<span lang=\"EN-US\" style=\"line-height:24px;font-size:12pt;\"><img height=\"415\" src=\"http://www.xajdfx.com/UploadFiles/xxxw/2020/9/202009251636365703.png\" width=\"554\" style=\"padding:0px;margin:0px;max-width:600px;height:auto;\" /></span>\r\n</p>\r\n<p class=\"MsoNormal\" style=\"padding:0px;margin:0cm 0cm 0pt;line-height:21px;color:#333333;font-family:宋体;font-size:14px;white-space:normal;text-indent:24pt;\">\r\n	<span style=\"line-height:24px;font-size:12pt;\">讲解中用动画的形式为同学们演示了牙齿的结构、龋齿形成的过程、口腔保健的方法以及如何正确刷牙。</span>\r\n</p>\r\n<p class=\"MsoNormal\" style=\"padding:0px;margin:0cm 0cm 0pt;line-height:21px;color:#333333;font-family:宋体;font-size:14px;white-space:normal;\">\r\n	<span lang=\"EN-US\" style=\"line-height:24px;font-size:12pt;\"><img height=\"415\" src=\"http://www.xajdfx.com/UploadFiles/xxxw/2020/9/202009251636362090.png\" width=\"554\" style=\"padding:0px;margin:0px;max-width:600px;height:auto;\" /></span>\r\n</p>\r\n<p class=\"MsoNormal\" style=\"padding:0px;margin:0cm 0cm 0pt;line-height:21px;color:#333333;font-family:宋体;font-size:14px;white-space:normal;\">\r\n	<span lang=\"EN-US\" style=\"line-height:24px;font-size:12pt;\">&nbsp;</span>\r\n</p>\r\n<p class=\"MsoNormal\" style=\"padding:0px;margin:0cm 0cm 0pt;line-height:21px;color:#333333;font-family:宋体;font-size:14px;white-space:normal;\">\r\n	<span lang=\"EN-US\" style=\"line-height:24px;font-size:12pt;\"><img height=\"395\" src=\"http://www.xajdfx.com/UploadFiles/xxxw/2020/9/202009251636363958.png\" width=\"553\" style=\"padding:0px;margin:0px;max-width:600px;height:auto;\" /></span>\r\n</p>\r\n<p class=\"MsoNormal\" style=\"padding:0px;margin:0cm 0cm 0pt;line-height:21px;color:#333333;font-family:宋体;font-size:14px;white-space:normal;text-indent:24pt;\">\r\n	<span style=\"line-height:24px;font-size:12pt;\">最后，王春莉医生给同学们普查了口腔卫生，给存在口腔牙齿问题的同学提出中肯的治疗建议和预防牙齿疾病的方法。</span>\r\n</p>\r\n<p class=\"MsoNormal\" style=\"padding:0px;margin:0cm 0cm 0pt;line-height:21px;color:#333333;font-family:宋体;font-size:14px;white-space:normal;text-indent:24pt;\">\r\n	<span style=\"line-height:24px;font-size:12pt;\">此次爱牙护牙知识讲座，让同学们深刻认识到牙齿健康的重要性，懂得了如何从小保护好牙齿，为孩子们的口腔健康保驾护航。</span>\r\n</p>\r\n<p align=\"right\" class=\"MsoNormal\" style=\"padding:0px;margin:0cm 32pt 0pt 0cm;line-height:21px;color:#333333;font-family:宋体;font-size:14px;white-space:normal;text-align:right;text-indent:24pt;\">\r\n	<span style=\"line-height:24px;font-size:12pt;\">文字：葛睿瑞<span lang=\"EN-US\">&nbsp;&nbsp;&nbsp;</span>图片：葛睿瑞</span>\r\n</p>', null, '2020-09-26 12:10:50', '1', '', null, null, null, null, '10', null, '0', '0', '0', null, '2020-09-26 11:58:59', '2020-09-26 11:58:59', '0');
INSERT INTO `operate_article` VALUES ('2767', '7', '“效率 习惯 专注”——三年级家长会顺利召开', '', '未知', '陈奕竹', null, '', null, '2020-09-26 21:50:47', '0', '', null, null, null, null, '10', null, '0', '0', '0', null, '2020-09-26 21:50:47', '2020-09-26 21:50:47', '0');
INSERT INTO `operate_article` VALUES ('2768', '7', '乘风破浪踏刃起，科技扬帆谱新章——西安交通大学附属小学党支部中国西部科技创新港“科创月”活动报道', '', '未知', '卞益婷', null, '<p class=\"MsoNormal\" style=\"padding:0px;margin:0cm 0cm 0pt;line-height:21px;color:#333333;font-family:宋体;font-size:14px;white-space:normal;text-indent:24pt;\">\r\n	<span style=\"line-height:24px;font-size:12pt;\">为了更好的传承和弘扬<span lang=\"EN-US\">“</span>西迁精神<span lang=\"EN-US\">”</span>，深入了解交大创新港所体现的科技创新魅力，引领基础教育改革方向。<span lang=\"EN-US\">9</span>月<span lang=\"EN-US\">17</span>日下午，西安交大附小党支部组织党员代表赴中国西部科技创新港参观学习，西安交大附小校长雷玲，西安交大附小党支部副书记戴宇飞，及来自西安交大附小的党员们参加了本次活动。<br />\r\n<span lang=\"EN-US\">&nbsp;&nbsp;</span>在宣传部李老师的带领和解说下，党员们沿着西迁大道，先后走进数字展厅、涵英楼楼顶花园、影随轩、阅览中心、米兰学院、材料科研平台等标志性建筑和网红打卡地，宏大的格局、优美的环境、高端的设计无不展现着这座新型科研创新和人才培养基地的气势与风采。<br />\r\n<span lang=\"EN-US\">&nbsp;&nbsp;</span>首先工作人员向党员们详细介绍中国西部科技创新港以“国家使命担当、全球科教高地、服务陕西引擎、创新驱动平台、智慧学镇示范”为目标，在<span lang=\"EN-US\">4</span>个领域上建立了<span lang=\"EN-US\">8</span>大平台、<span lang=\"EN-US\">29</span>个研究院和<span lang=\"EN-US\">300</span>多个科研基地，服务于学校研究生培养。宏伟的战略蓝图激发出大家对大西安美好未来的无限憧憬。</span>\r\n</p>\r\n<p align=\"center\" class=\"MsoNormal\" style=\"padding:0px;margin:0cm 0cm 0pt 0.05pt;line-height:21px;color:#333333;font-family:宋体;font-size:14px;white-space:normal;text-align:center;\">\r\n	<span lang=\"EN-US\" style=\"line-height:24px;font-size:12pt;\"><img height=\"350\" src=\"http://www.xajdfx.com/UploadFiles/xxxw/2020/9/202009251613089507.png\" width=\"567\" style=\"padding:0px;margin:0px;max-width:600px;height:auto;\" /></span>\r\n</p>\r\n<p align=\"center\" class=\"MsoNormal\" style=\"padding:0px;margin:0cm 0cm 0pt;line-height:21px;color:#333333;font-family:宋体;font-size:14px;white-space:normal;text-align:center;\">\r\n	<span lang=\"EN-US\" style=\"line-height:24px;font-size:12pt;\"><img height=\"429\" src=\"http://www.xajdfx.com/UploadFiles/xxxw/2020/9/202009251613085752.png\" width=\"566\" style=\"padding:0px;margin:0px;max-width:600px;height:auto;\" /></span>\r\n</p>\r\n<p align=\"center\" class=\"MsoNormal\" style=\"padding:0px;margin:0cm 0cm 0pt;line-height:21px;color:#333333;font-family:宋体;font-size:14px;white-space:normal;text-align:center;\">\r\n	<span lang=\"EN-US\" style=\"line-height:24px;font-size:12pt;\"><img height=\"425\" src=\"http://www.xajdfx.com/UploadFiles/xxxw/2020/9/202009251613082130.png\" width=\"567\" style=\"padding:0px;margin:0px;max-width:600px;height:auto;\" /></span>\r\n</p>\r\n<p align=\"center\" class=\"MsoNormal\" style=\"padding:0px;margin:0cm 0cm 0pt;line-height:21px;color:#333333;font-family:宋体;font-size:14px;white-space:normal;text-align:center;\">\r\n	<span lang=\"EN-US\" style=\"line-height:24px;font-size:12pt;\"><img height=\"318\" src=\"http://www.xajdfx.com/UploadFiles/xxxw/2020/9/202009251613090554.jpg\" width=\"566\" style=\"padding:0px;margin:0px;max-width:600px;height:auto;\" /></span>\r\n</p>\r\n<p align=\"center\" class=\"MsoNormal\" style=\"padding:0px;margin:0cm 0cm 0pt;line-height:21px;color:#333333;font-family:宋体;font-size:14px;white-space:normal;text-align:center;\">\r\n	<span lang=\"EN-US\" style=\"line-height:24px;font-size:12pt;\"><img height=\"382\" src=\"http://www.xajdfx.com/UploadFiles/xxxw/2020/9/202009251613099743.jpg\" width=\"566\" style=\"padding:0px;margin:0px;max-width:600px;height:auto;\" /></span>\r\n</p>\r\n<p align=\"center\" class=\"MsoNormal\" style=\"padding:0px;margin:0cm 0cm 0pt;line-height:21px;color:#333333;font-family:宋体;font-size:14px;white-space:normal;text-align:center;\">\r\n	<span lang=\"EN-US\" style=\"line-height:24px;font-size:12pt;\"><img height=\"318\" src=\"http://www.xajdfx.com/UploadFiles/xxxw/2020/9/202009251613091130.jpg\" width=\"566\" style=\"padding:0px;margin:0px;max-width:600px;height:auto;\" /></span>\r\n</p>\r\n<p align=\"center\" class=\"MsoNormal\" style=\"padding:0px;margin:0cm 0cm 0pt;line-height:21px;color:#333333;font-family:宋体;font-size:14px;white-space:normal;text-align:center;\">\r\n	<span lang=\"EN-US\" style=\"line-height:24px;font-size:12pt;\"><img height=\"380\" src=\"http://www.xajdfx.com/UploadFiles/xxxw/2020/9/202009251613099471.jpg\" width=\"566\" style=\"padding:0px;margin:0px;max-width:600px;height:auto;\" /><img height=\"319\" src=\"http://www.xajdfx.com/UploadFiles/xxxw/2020/9/202009251613097769.jpg\" width=\"566\" style=\"padding:0px;margin:0px;max-width:600px;height:auto;\" /></span><br />\r\n<span lang=\"EN-US\" style=\"line-height:24px;font-size:12pt;\">&nbsp;&nbsp;</span><span style=\"line-height:24px;font-size:12pt;\">作为中国西部最大的智慧学镇，西安交通大学致力于将创新港打造成世界级科技中心和国家级科技成果研发转换平台。在<span lang=\"EN-US\">“</span>双一流<span lang=\"EN-US\">”</span>建设的伟大新征程中，西安交通大学坚持<span lang=\"EN-US\">“</span>扎根西部、服务国家、世界一流<span lang=\"EN-US\">”</span>办学定位，以<span lang=\"EN-US\">“</span>探索一流大学新形态、塑造立德树人新构架、构筑科教融合新高地、创新国际合作新模式、打造一流学科新格局<span lang=\"EN-US\">”</span>的<span lang=\"EN-US\">“</span>五新战略<span lang=\"EN-US\">”</span>，矢志在祖国西部大地上，率先建成中国特色世界一流大学，用实际行动给出了<span lang=\"EN-US\">“</span>双一流<span lang=\"EN-US\">”</span>建设的<span lang=\"EN-US\">“</span>交大方案<span lang=\"EN-US\">”</span>。</span>\r\n</p>\r\n<p align=\"center\" class=\"MsoNormal\" style=\"padding:0px;margin:0cm 0cm 0pt;line-height:21px;color:#333333;font-family:宋体;font-size:14px;white-space:normal;text-align:center;\">\r\n	<span lang=\"EN-US\" style=\"line-height:24px;font-size:12pt;\">&nbsp;</span>\r\n</p>\r\n<p align=\"center\" class=\"MsoNormal\" style=\"padding:0px;margin:0cm 0cm 0pt;line-height:21px;color:#333333;font-family:宋体;font-size:14px;white-space:normal;text-align:center;\">\r\n	<span lang=\"EN-US\" style=\"line-height:24px;font-size:12pt;\"><img height=\"344\" src=\"http://www.xajdfx.com/UploadFiles/xxxw/2020/9/202009251613098434.jpg\" width=\"567\" style=\"padding:0px;margin:0px;max-width:600px;height:auto;\" /><img height=\"307\" src=\"http://www.xajdfx.com/UploadFiles/xxxw/2020/9/202009251613091487.jpg\" width=\"567\" style=\"padding:0px;margin:0px;max-width:600px;height:auto;\" /><img height=\"316\" src=\"http://www.xajdfx.com/UploadFiles/xxxw/2020/9/202009251613099247.jpg\" width=\"567\" style=\"padding:0px;margin:0px;max-width:600px;height:auto;\" /></span>\r\n</p>\r\n<p align=\"center\" class=\"MsoNormal\" style=\"padding:0px;margin:0cm 0cm 0pt;line-height:21px;color:#333333;font-family:宋体;font-size:14px;white-space:normal;text-align:center;\">\r\n	<span lang=\"EN-US\" style=\"line-height:24px;font-size:12pt;\"><img height=\"318\" src=\"http://www.xajdfx.com/UploadFiles/xxxw/2020/9/202009251613095267.jpg\" width=\"566\" style=\"padding:0px;margin:0px;max-width:600px;height:auto;\" /></span>\r\n</p>\r\n<p align=\"center\" class=\"MsoNormal\" style=\"padding:0px;margin:0cm 0cm 0pt;line-height:21px;color:#333333;font-family:宋体;font-size:14px;white-space:normal;text-align:center;\">\r\n	<span lang=\"EN-US\" style=\"line-height:24px;font-size:12pt;\"><img height=\"318\" src=\"http://www.xajdfx.com/UploadFiles/xxxw/2020/9/202009251613096316.jpg\" width=\"566\" style=\"padding:0px;margin:0px;max-width:600px;height:auto;\" /></span>\r\n</p>\r\n<p align=\"center\" class=\"MsoNormal\" style=\"padding:0px;margin:0cm 0cm 0pt;line-height:21px;color:#333333;font-family:宋体;font-size:14px;white-space:normal;text-align:center;\">\r\n	<span lang=\"EN-US\" style=\"line-height:24px;font-size:12pt;\"><img height=\"297\" src=\"http://www.xajdfx.com/UploadFiles/xxxw/2020/9/202009251613092099.jpg\" width=\"567\" style=\"padding:0px;margin:0px;max-width:600px;height:auto;\" /><img height=\"336\" src=\"http://www.xajdfx.com/UploadFiles/xxxw/2020/9/202009251613094906.jpg\" width=\"566\" style=\"padding:0px;margin:0px;max-width:600px;height:auto;\" /><img height=\"349\" src=\"http://www.xajdfx.com/UploadFiles/xxxw/2020/9/202009251613097691.jpg\" width=\"567\" style=\"padding:0px;margin:0px;max-width:600px;height:auto;\" /></span>\r\n</p>\r\n<p align=\"center\" class=\"MsoNormal\" style=\"padding:0px;margin:0cm 0cm 0pt;line-height:21px;color:#333333;font-family:宋体;font-size:14px;white-space:normal;text-align:center;\">\r\n	<span lang=\"EN-US\" style=\"line-height:24px;font-size:12pt;\"><img height=\"318\" src=\"http://www.xajdfx.com/UploadFiles/xxxw/2020/9/202009251613093500.jpg\" width=\"566\" style=\"padding:0px;margin:0px;max-width:600px;height:auto;\" /></span>\r\n</p>\r\n<p align=\"center\" class=\"MsoNormal\" style=\"padding:0px;margin:0cm 0cm 0pt;line-height:21px;color:#333333;font-family:宋体;font-size:14px;white-space:normal;text-align:center;\">\r\n	<span lang=\"EN-US\" style=\"line-height:24px;font-size:12pt;\"><img height=\"319\" src=\"http://www.xajdfx.com/UploadFiles/xxxw/2020/9/202009251613092846.jpg\" width=\"566\" style=\"padding:0px;margin:0px;max-width:600px;height:auto;\" /><img height=\"319\" src=\"http://www.xajdfx.com/UploadFiles/xxxw/2020/9/202009251613093628.jpg\" width=\"566\" style=\"padding:0px;margin:0px;max-width:600px;height:auto;\" /><img height=\"375\" src=\"http://www.xajdfx.com/UploadFiles/xxxw/2020/9/202009251613099083.jpg\" width=\"567\" style=\"padding:0px;margin:0px;max-width:600px;height:auto;\" /><img height=\"378\" src=\"http://www.xajdfx.com/UploadFiles/xxxw/2020/9/202009251613092967.jpg\" width=\"567\" style=\"padding:0px;margin:0px;max-width:600px;height:auto;\" /><img height=\"425\" src=\"http://www.xajdfx.com/UploadFiles/xxxw/2020/9/202009251613092234.jpg\" width=\"567\" style=\"padding:0px;margin:0px;max-width:600px;height:auto;\" /></span><br />\r\n<span lang=\"EN-US\" style=\"line-height:24px;font-size:12pt;\">&nbsp;&nbsp;</span><span style=\"line-height:24px;font-size:12pt;\">在参观过程中，老师们被创新港呈现出的<span lang=\"EN-US\">“</span>交大力量<span lang=\"EN-US\">”</span>深深震撼与折服。西安交大附小校长雷玲对于瀑布流电子图书借阅系统，材料科研平台的材料研制等产生浓厚的兴趣，表示希望将优质资源引进西安交大附小，依托西安交通大学的创新理念，引领交大附小所有成员</span>\r\n</p>\r\n<p align=\"left\" class=\"MsoNormal\" style=\"padding:0px;margin:0cm 0cm 0pt;line-height:21px;color:#333333;font-family:宋体;font-size:14px;white-space:normal;\">\r\n	<span style=\"line-height:24px;font-size:12pt;\">校的蓬勃发展。</span>\r\n</p>\r\n<p align=\"center\" class=\"MsoNormal\" style=\"padding:0px;margin:0cm 0cm 0pt;line-height:21px;color:#333333;font-family:宋体;font-size:14px;white-space:normal;text-align:center;\">\r\n	<span lang=\"EN-US\" style=\"line-height:24px;font-size:12pt;\">&nbsp;</span>\r\n</p>\r\n<p align=\"center\" class=\"MsoNormal\" style=\"padding:0px;margin:0cm 0cm 0pt;line-height:21px;color:#333333;font-family:宋体;font-size:14px;white-space:normal;text-align:center;\">\r\n	<span lang=\"EN-US\" style=\"line-height:24px;font-size:12pt;\"><img height=\"319\" src=\"http://www.xajdfx.com/UploadFiles/xxxw/2020/9/202009251613092871.jpg\" width=\"566\" style=\"padding:0px;margin:0px;max-width:600px;height:auto;\" /><img height=\"358\" src=\"http://www.xajdfx.com/UploadFiles/xxxw/2020/9/202009251613095216.jpg\" width=\"567\" style=\"padding:0px;margin:0px;max-width:600px;height:auto;\" /></span>\r\n</p>\r\n<p align=\"center\" class=\"MsoNormal\" style=\"padding:0px;margin:0cm 0cm 0pt;line-height:21px;color:#333333;font-family:宋体;font-size:14px;white-space:normal;text-align:center;\">\r\n	<span lang=\"EN-US\" style=\"line-height:24px;font-size:12pt;\"><img height=\"319\" src=\"http://www.xajdfx.com/UploadFiles/xxxw/2020/9/202009251613090648.jpg\" width=\"566\" style=\"padding:0px;margin:0px;max-width:600px;height:auto;\" /><img height=\"319\" src=\"http://www.xajdfx.com/UploadFiles/xxxw/2020/9/202009251613092468.jpg\" width=\"566\" style=\"padding:0px;margin:0px;max-width:600px;height:auto;\" /><img height=\"319\" src=\"http://www.xajdfx.com/UploadFiles/xxxw/2020/9/202009251613096613.jpg\" width=\"566\" style=\"padding:0px;margin:0px;max-width:600px;height:auto;\" /></span><br />\r\n<span lang=\"EN-US\" style=\"line-height:24px;font-size:12pt;\">&nbsp;&nbsp;</span><span style=\"line-height:24px;font-size:12pt;\">创新港建设是学校发展的历史机遇，也是西迁精神的重要实践，通过这次参观学习，党员们反响强烈，大家对创新港的建设赞不绝口，表示进一步加深了自己对基础教育的初心和使命的理解，作为新时代的交大人，西迁精神的内涵和实质一直激励着大家前行，一定立足本职，潜心教学，努力工作，用实际行动践行西迁精神，努力为基础教育建设发展贡献力量。</span>\r\n</p>', null, '2020-09-26 21:52:45', '0', '', null, null, null, null, '1', null, '0', '0', '0', null, '2020-09-26 21:52:45', '2020-09-26 21:52:45', '0');
INSERT INTO `operate_article` VALUES ('2769', '7', '诵读美丽中国 抒发爱国情怀——三年级推普周活动报道', '', '未知', '孟婧暄', null, '<p align=\"center\" class=\"MsoNormal\" style=\"padding:0px;margin:0cm 0cm 0pt;line-height:27px;color:#333333;font-family:宋体;font-size:14px;white-space:normal;text-align:center;\">\r\n	&nbsp;\r\n</p>\r\n<p align=\"left\" class=\"MsoNormal\" style=\"padding:0px;margin:0cm 0cm 0pt;line-height:17.5px;color:#333333;font-family:宋体;font-size:14px;white-space:normal;text-indent:24pt;\">\r\n	<span style=\"line-height:20px;font-size:12pt;\">金秋九月，充满了清新与美丽，蕴含了朦胧与传奇，它是一支画笔，勾勒大江山河；它是半盏墨香，蕴育了五千年文明大国源远流长。普通话是我国法定的最标准的交际用语，我国把每年九月的第三个星期定为<span lang=\"EN-US\">“</span>推广普通话宣传周<span lang=\"EN-US\">”</span>。<span lang=\"EN-US\">2020</span>年<span lang=\"EN-US\">9</span>月<span lang=\"EN-US\">14</span>日至<span lang=\"EN-US\">18</span>日，是第<span lang=\"EN-US\">23</span>届全国推广普通话宣传周，今年的主题是“同讲普通话，携手进小康”。三年级师生开展了以“诵读中国”为主题的诗歌朗诵会。</span>\r\n</p>\r\n<p align=\"center\" class=\"MsoNormal\" style=\"padding:0px;margin:0cm 0cm 0pt 0.05pt;line-height:17.5px;color:#333333;font-family:宋体;font-size:14px;white-space:normal;text-align:center;\">\r\n	<span lang=\"EN-US\" style=\"line-height:20px;font-size:12pt;\"><img height=\"400\" src=\"http://www.xajdfx.com/UploadFiles/xxxw/2020/9/202009251039433180.jpg\" width=\"533\" style=\"padding:0px;margin:0px;max-width:600px;height:auto;\" /></span>\r\n</p>\r\n<p align=\"left\" class=\"MsoNormal\" style=\"padding:0px;margin:0cm 0cm 0pt;line-height:17.5px;color:#333333;font-family:宋体;font-size:14px;white-space:normal;text-indent:24pt;\">\r\n	<span style=\"line-height:20px;font-size:12pt;\">三年级各班学生在周末准备了自己最喜爱的爱国诗词，并利用两天假期练习朗诵，在周一的队会课上进行展示。周一下午，各班班主任老师先在队会课上强调了讲好普通话的重要性，紧接着各班学生齐诵了班主任准备的爱国诗歌《我们爱祖国》。</span>\r\n</p>\r\n<p align=\"center\" class=\"MsoNormal\" style=\"padding:0px;margin:0cm 0cm 0pt;line-height:17.5px;color:#333333;font-family:宋体;font-size:14px;white-space:normal;text-align:center;\">\r\n	<span lang=\"EN-US\" style=\"line-height:20px;font-size:12pt;\"><img height=\"400\" src=\"http://www.xajdfx.com/UploadFiles/xxxw/2020/9/202009251039438036.jpg\" width=\"533\" style=\"padding:0px;margin:0px;max-width:600px;height:auto;\" /></span>\r\n</p>\r\n<p align=\"left\" class=\"MsoNormal\" style=\"padding:0px;margin:0cm 0cm 0pt;line-height:17.5px;color:#333333;font-family:宋体;font-size:14px;white-space:normal;text-indent:24pt;\">\r\n	<span style=\"line-height:20px;font-size:12pt;\">学生们在朗诵时声情并茂、字正腔圆，“她是蓝天里飞翔的白鸽，她是国徽在阳光下闪烁，她是夜晚的万家灯火，她是熊熊燃烧的奥运圣火。”在孩子们深情地诵读下，课件上的文字变成了一幅幅动人的画卷，配上抒情的背景音乐，更激发了孩子们爱国之情。</span>\r\n</p>\r\n<p align=\"center\" class=\"MsoNormal\" style=\"padding:0px;margin:0cm 0cm 0pt;line-height:17.5px;color:#333333;font-family:宋体;font-size:14px;white-space:normal;text-align:center;\">\r\n	<span lang=\"EN-US\" style=\"line-height:20px;font-size:12pt;\"><img height=\"400\" src=\"http://www.xajdfx.com/UploadFiles/xxxw/2020/9/202009251039436510.jpg\" width=\"533\" style=\"padding:0px;margin:0px;max-width:600px;height:auto;\" /></span>\r\n</p>\r\n<p align=\"left\" class=\"MsoNormal\" style=\"padding:0px;margin:0cm 0cm 0pt;line-height:17.5px;color:#333333;font-family:宋体;font-size:14px;white-space:normal;text-indent:24pt;\">\r\n	<span style=\"line-height:20px;font-size:12pt;\">接下来，各班的学生诵读了各自准备的爱国诗词。从岳飞的“三十功名尘与土，八千里路云和月”，到陆游的“王师北定中原日，家祭无忘告乃翁”，再到文天祥的“人生自古谁无死，留取丹心照汗青”。读者心潮澎湃，听者热血沸腾，仿佛能看到诗人、词人那坚毅的脸庞和炽热的忠心。这些诗词世界里的呐喊，激励着后人永葆爱国之心。</span>\r\n</p>\r\n<p align=\"center\" class=\"MsoNormal\" style=\"padding:0px;margin:0cm 0cm 0pt;line-height:17.5px;color:#333333;font-family:宋体;font-size:14px;white-space:normal;text-align:center;\">\r\n	<span lang=\"EN-US\" style=\"line-height:20px;font-size:12pt;\"><img height=\"400\" src=\"http://www.xajdfx.com/UploadFiles/xxxw/2020/9/202009251039432093.jpg\" width=\"533\" style=\"padding:0px;margin:0px;max-width:600px;height:auto;\" /></span>\r\n</p>\r\n<p align=\"left\" class=\"MsoNormal\" style=\"padding:0px;margin:0cm 0cm 0pt;line-height:17.5px;color:#333333;font-family:宋体;font-size:14px;white-space:normal;text-indent:24pt;\">\r\n	<span style=\"line-height:20px;font-size:12pt;\">这次的活动让学生了解了普通话的重要性，更深深地托起了孩子们的爱国情怀，培育了学生们的民族精神。希望我们附小学子都能说好普通话，做好中国人。</span>\r\n</p>\r\n<p align=\"left\" class=\"MsoNormal\" style=\"padding:0px;margin:0cm 0cm 0pt;line-height:17.5px;color:#333333;font-family:宋体;font-size:14px;white-space:normal;text-indent:24pt;\">\r\n	<span lang=\"EN-US\" style=\"line-height:20px;font-size:12pt;\">&nbsp;</span>\r\n</p>\r\n<p align=\"right\" class=\"MsoNormal\" style=\"padding:0px;margin:0cm 0cm 0pt;line-height:27px;color:#333333;font-family:宋体;font-size:14px;white-space:normal;text-align:right;\">\r\n	<span style=\"font-size:12pt;\">文字：孟婧暄&nbsp;&nbsp;&nbsp;摄影：三年级各班班主任</span>\r\n</p>', null, '2020-09-26 21:53:16', '0', '', null, null, null, null, '1', null, '0', '0', '0', null, '2020-09-26 21:53:16', '2020-09-26 21:53:16', '0');
INSERT INTO `operate_article` VALUES ('2770', '7', '五年级语文教研组活动报道', '《计划》中指出，本学期，教研组建设要实现两个转变，一是教研组由事务型组织走向学习型组织，二是由应付性研究走向发展性研究，实现教学与研究的一体化。每个教研组以观课议课为操作平台开展课例研究，以研究促发展。每位老师在教学中要认真研读教材，精心设计作业，在“减负”的同时积极探索“增效”的新途径。随后，老师们对《计划》发表了自己的见解并讨论了实施的方法。', '五年级组', '王荣荣', null, '<p class=\"MsoNormal\" align=\"center\" style=\"padding:0px;margin-top:0px;margin-bottom:15px;line-height:21px;color:#333333;font-family:宋体;font-size:14px;white-space:normal;text-indent:21.75pt;\">\r\n	<span style=\"font-size:12pt;line-height:24px;\"><img src=\"http://www.xajdfx.com/UploadFile/201198133557953.jpg\" border=\"0\" style=\"padding:0px;margin:0px;max-width:600px;height:auto;\" /></span>\r\n</p>\r\n<p class=\"MsoNormal\" style=\"padding:0px;margin-top:0px;margin-bottom:15px;line-height:21px;color:#333333;font-family:宋体;font-size:14px;white-space:normal;text-indent:21.75pt;\">\r\n	绵绵的秋雨驱走了残留的炎热，却驱不走老师们高涨的工作热情。<span lang=\"EN-US\" style=\"font-size:12pt;line-height:24px;\"><o:p></o:p></span>\r\n</p>\r\n<p class=\"MsoNormal\" style=\"padding:0px;margin-top:0px;margin-bottom:15px;line-height:21px;color:#333333;font-family:宋体;font-size:14px;white-space:normal;text-indent:21.75pt;\">\r\n	<span style=\"font-size:12pt;line-height:24px;\">开学伊始，组长<st1:personname productid=\"曹瑞娜\" w:st=\"on\">曹瑞娜</st1:personname>老师趁召开年级组会议之际，组织<st1:personname productid=\"全组\" w:st=\"on\">全组</st1:personname>老师学习并讨论了本学期《学校教学工作计划》。</span><span lang=\"EN-US\" style=\"font-size:12pt;line-height:24px;\"><o:p></o:p></span>\r\n</p>\r\n<p class=\"MsoNormal\" style=\"padding:0px;margin-top:0px;margin-bottom:15px;line-height:21px;color:#333333;font-family:宋体;font-size:14px;white-space:normal;text-indent:21.75pt;\">\r\n	<span style=\"font-size:12pt;line-height:24px;\">《计划》中指出，本学期，教研组建设要实现两个转变，一是教研组由事务型组织走向学习型组织，二是由应付性研究走向发展性研究，实现教学与研究的一体化。每个教研组以观课议课为操作平台开展课例研究，以研究促发展。每位老师在教学中要认真研读教材，精心设计作业，在“减负”的同时积极探索“增效”的新途径。随后，老师们对《计划》发表了自己的见解并讨论了实施的方法。</span><span lang=\"EN-US\" style=\"font-size:12pt;line-height:24px;\"><o:p></o:p></span>\r\n</p>\r\n<p class=\"MsoNormal\" style=\"padding:0px;margin-top:0px;margin-bottom:15px;line-height:21px;color:#333333;font-family:宋体;font-size:14px;white-space:normal;text-indent:28.5pt;\">\r\n	<span style=\"font-size:12pt;line-height:24px;\">老师们将以学校的教学工作计划为引领，积极参加各种教学活动，促进自身专业发展，提高课堂教学质量。</span>\r\n</p>', null, '2020-09-26 22:17:44', '0', '', null, null, null, null, '1', null, '0', '0', '0', null, '2020-09-26 22:17:44', '2020-09-26 22:17:44', '0');

-- ----------------------------
-- Table structure for operate_article_category
-- ----------------------------
DROP TABLE IF EXISTS `operate_article_category`;
CREATE TABLE `operate_article_category` (
  `category_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '栏目编号',
  `category_name` varchar(200) DEFAULT NULL COMMENT '栏目名称',
  `category_pic_code` varchar(50) DEFAULT NULL COMMENT '栏目图片',
  `image` int(11) DEFAULT NULL COMMENT '图片',
  `sort` int(11) DEFAULT '10000' COMMENT '排序',
  `category_level` int(11) DEFAULT '0' COMMENT '栏目级别',
  `parent_category` int(11) DEFAULT NULL COMMENT '父级栏目',
  `show_special` int(11) DEFAULT '0' COMMENT '是否显示头条',
  `use_status` int(11) NOT NULL DEFAULT '1' COMMENT '启用状态',
  `update_time` datetime NOT NULL COMMENT '更新时间',
  `delete_flag` int(11) NOT NULL DEFAULT '0' COMMENT '删除标记',
  PRIMARY KEY (`category_id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8 COMMENT='新闻栏目表';

-- ----------------------------
-- Records of operate_article_category
-- ----------------------------
INSERT INTO `operate_article_category` VALUES ('7', '学校新闻', null, null, '1', '0', null, '0', '0', '2020-09-26 11:00:31', '0');
INSERT INTO `operate_article_category` VALUES ('8', '通知公告', null, null, '3', '0', null, '0', '0', '2020-09-26 11:01:18', '0');
INSERT INTO `operate_article_category` VALUES ('9', '媒体报道', null, null, '3', '0', null, '0', '0', '2020-09-26 11:04:23', '0');

-- ----------------------------
-- Table structure for sys_modules
-- ----------------------------
DROP TABLE IF EXISTS `sys_modules`;
CREATE TABLE `sys_modules` (
  `module_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '模块id',
  `app_id` int(11) NOT NULL COMMENT '应用id',
  `module_name` varchar(100) DEFAULT NULL COMMENT '模块名称',
  `module_code` varchar(100) DEFAULT NULL COMMENT '模块编码',
  `module_class` varchar(100) DEFAULT NULL COMMENT '图标样式',
  `module_path` varchar(200) DEFAULT NULL COMMENT '链接路径',
  `module_description` varchar(200) DEFAULT NULL COMMENT '功能描述',
  `module_parent` int(11) DEFAULT NULL COMMENT '上级模块',
  `module_sort` int(11) DEFAULT NULL COMMENT '排序',
  `module_isdisable` int(11) DEFAULT NULL COMMENT '是否禁用',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `delete_flag` int(11) DEFAULT '0' COMMENT '删除标记：0，未删除；1、已删除',
  PRIMARY KEY (`module_id`)
) ENGINE=InnoDB AUTO_INCREMENT=192 DEFAULT CHARSET=utf8 COMMENT='系统模块表';

-- ----------------------------
-- Records of sys_modules
-- ----------------------------

-- ----------------------------
-- Table structure for sys_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_role`;
CREATE TABLE `sys_role` (
  `role_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '角色ID',
  `role_name` varchar(30) COLLATE utf8_bin NOT NULL COMMENT '角色名称',
  `role_key` varchar(100) COLLATE utf8_bin NOT NULL COMMENT '角色权限字符串',
  `role_sort` int(4) NOT NULL COMMENT '显示顺序',
  `data_scope` char(1) COLLATE utf8_bin DEFAULT '1' COMMENT '数据范围（1：全部数据权限 2：自定数据权限 3：本部门数据权限 4：本部门及以下数据权限）',
  `status` char(1) COLLATE utf8_bin NOT NULL COMMENT '角色状态（0正常 1停用）',
  `del_flag` char(1) COLLATE utf8_bin DEFAULT '0' COMMENT '删除标志（0代表存在 2代表删除）',
  `create_by` varchar(64) COLLATE utf8_bin DEFAULT '' COMMENT '创建者',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(64) COLLATE utf8_bin DEFAULT '' COMMENT '更新者',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(500) COLLATE utf8_bin DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`role_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COLLATE=utf8_bin ROW_FORMAT=COMPACT COMMENT='角色信息表';

-- ----------------------------
-- Records of sys_role
-- ----------------------------

-- ----------------------------
-- Table structure for sys_role_modules
-- ----------------------------
DROP TABLE IF EXISTS `sys_role_modules`;
CREATE TABLE `sys_role_modules` (
  `role_id` int(11) NOT NULL COMMENT '角色id',
  `module_id` int(11) NOT NULL COMMENT '模块id',
  `module_sort` int(11) DEFAULT NULL,
  PRIMARY KEY (`role_id`,`module_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='角色模块分配表';

-- ----------------------------
-- Records of sys_role_modules
-- ----------------------------

-- ----------------------------
-- Table structure for sys_settings
-- ----------------------------
DROP TABLE IF EXISTS `sys_settings`;
CREATE TABLE `sys_settings` (
  `keycode` varchar(50) NOT NULL COMMENT '系统变量编码',
  `value` varchar(500) DEFAULT NULL COMMENT '系统变量数值',
  `remark` varchar(100) DEFAULT NULL COMMENT '备注说明',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `delete_flag` int(11) DEFAULT '0' COMMENT '删除标记：0，未删除；1、已删除',
  PRIMARY KEY (`keycode`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='系统设置表';

-- ----------------------------
-- Records of sys_settings
-- ----------------------------

-- ----------------------------
-- Table structure for user_info
-- ----------------------------
DROP TABLE IF EXISTS `user_info`;
CREATE TABLE `user_info` (
  `user_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '用户id',
  `role_id` int(11) NOT NULL COMMENT '角色id',
  `user_name` varchar(50) NOT NULL COMMENT '用户名',
  `real_name` varchar(50) NOT NULL COMMENT '昵称',
  `signature` varchar(20) DEFAULT NULL COMMENT '个性签名',
  `user_pwd` varchar(50) DEFAULT NULL COMMENT '密码:6~18位',
  `head_pic_code` varchar(50) DEFAULT NULL COMMENT '头像照片代码',
  `head_portrait` int(11) DEFAULT NULL COMMENT '头像',
  `user_mobile` varchar(20) DEFAULT NULL COMMENT '移动电话',
  `machine_code` varchar(50) DEFAULT NULL COMMENT '机器码',
  `region_code` int(11) DEFAULT NULL COMMENT '行政区划代码',
  `update_time` datetime DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `delete_flag` int(255) DEFAULT '0',
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='用户基本信息表';

-- ----------------------------
-- Records of user_info
-- ----------------------------
INSERT INTO `user_info` VALUES ('1', '1', 'admin', '111', null, '96e79218965eb72c92a549dd5a330112', null, null, '18792652222', null, null, null, null, '0');
