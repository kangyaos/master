/*
Navicat MySQL Data Transfer

Source Server         : 199_copy
Source Server Version : 50505
Source Host           : 172.16.99.199:3306
Source Database       : test

Target Server Type    : MYSQL
Target Server Version : 50505
File Encoding         : 65001

Date: 2020-10-23 18:15:00
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for certificate
-- ----------------------------
DROP TABLE IF EXISTS `certificate`;
CREATE TABLE `certificate` (
  `certificate_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NOT NULL,
  `course_id` int(11) DEFAULT NULL,
  `create_time` datetime NOT NULL,
  `url` varchar(255) CHARACTER SET utf8 NOT NULL COMMENT '证书图片路径',
  `type` int(1) DEFAULT NULL COMMENT '证书 类型 1帮扶  2学习',
  `remark` varchar(255) CHARACTER SET utf8 DEFAULT NULL COMMENT '证书内容',
  `delete_flag` int(1) unsigned zerofill DEFAULT '0' COMMENT '0',
  `index_show` int(1) DEFAULT '0' COMMENT '是否在首页显示 0否 1是',
  PRIMARY KEY (`certificate_id`)
) ENGINE=InnoDB AUTO_INCREMENT=69 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of certificate
-- ----------------------------
INSERT INTO `certificate` VALUES ('49', '2', null, '2020-10-17 13:22:03', '1602912123251.jpg', '1', '测试', '0', null);
INSERT INTO `certificate` VALUES ('50', '3', null, '2020-10-17 13:22:29', '1602912149169.jpg', '1', '测试', '0', null);
INSERT INTO `certificate` VALUES ('51', '5', null, '2020-10-17 13:22:41', '1602912161152.jpg', '1', '测试', '0', null);
INSERT INTO `certificate` VALUES ('52', '6', null, '2020-10-17 13:22:56', '1602912176014.jpg', '1', '测试', '0', null);
INSERT INTO `certificate` VALUES ('53', '7', null, '2020-10-17 13:23:07', '1602912187584.jpg', '1', '测试', '0', null);
INSERT INTO `certificate` VALUES ('54', '8', null, '2020-10-17 13:23:16', '1602912196820.jpg', '1', '测试', '0', null);
INSERT INTO `certificate` VALUES ('55', '9', null, '2020-10-17 13:23:24', '1602912204950.jpg', '1', '测试', '0', null);
INSERT INTO `certificate` VALUES ('56', '1', null, '2020-10-17 13:56:56', '1602914216923.jpg', '2', '测试', '0', null);
INSERT INTO `certificate` VALUES ('57', '5', null, '2020-10-17 13:57:43', '1602914263730.jpg', '2', '测试', '0', null);
INSERT INTO `certificate` VALUES ('58', '2', null, '2020-10-17 13:58:36', '1602914316145.jpg', '2', '测试', '0', null);
INSERT INTO `certificate` VALUES ('59', '1', null, '2020-10-19 17:18:22', '1603099102469.jpg', '1', '测试', '0', null);
INSERT INTO `certificate` VALUES ('60', '1', null, '2020-10-19 17:21:39', '1603099299840.jpg', '2', '测试', '0', null);
INSERT INTO `certificate` VALUES ('61', '1', null, '2020-10-19 17:21:44', '1603099304960.jpg', '2', '测试', '0', null);
INSERT INTO `certificate` VALUES ('62', '1', null, '2020-10-19 17:21:49', '1603099309222.jpg', '2', '测试', '0', null);
INSERT INTO `certificate` VALUES ('63', '1', '15', '2020-10-19 17:27:48', '1603099668364.jpg', '2', '测试', '0', null);
INSERT INTO `certificate` VALUES ('64', '1', '14', '2020-10-19 17:27:53', '1603099673563.jpg', '2', '测试', '0', null);
INSERT INTO `certificate` VALUES ('65', '1', '13', '2020-10-19 17:27:54', '1603099674281.jpg', '2', '测试', '0', null);
INSERT INTO `certificate` VALUES ('66', '7', '15', '2020-10-19 17:39:15', '1603100355661.jpg', '2', '测试', '0', null);
INSERT INTO `certificate` VALUES ('67', '7', '14', '2020-10-19 17:39:17', '1603100357242.jpg', '2', '测试', '0', null);
INSERT INTO `certificate` VALUES ('68', '7', '13', '2020-10-19 17:39:17', '1603100357948.jpg', '2', '测试', '0', null);

-- ----------------------------
-- Table structure for course_info
-- ----------------------------
DROP TABLE IF EXISTS `course_info`;
CREATE TABLE `course_info` (
  `course_id` int(11) NOT NULL AUTO_INCREMENT,
  `course_release_num` varchar(16) CHARACTER SET utf8 DEFAULT NULL COMMENT '课程发布版本号',
  `course_name` varchar(255) CHARACTER SET utf8 DEFAULT NULL,
  `course_type` int(255) DEFAULT NULL,
  `courseware_type` int(255) DEFAULT NULL COMMENT '课程类型  1视频  2 word 3 excel 4 ppt',
  `summary` varchar(255) CHARACTER SET utf8 DEFAULT NULL,
  `pic` varchar(255) CHARACTER SET utf8 DEFAULT NULL,
  `source_new` varchar(255) CHARACTER SET utf8 DEFAULT NULL,
  `source` varchar(255) CHARACTER SET utf8 DEFAULT NULL,
  `fujian_new` varchar(255) CHARACTER SET utf8 DEFAULT NULL,
  `fujian` varchar(255) CHARACTER SET utf8 DEFAULT NULL,
  `lecturer_id` int(11) DEFAULT NULL,
  `lecturer` varchar(255) CHARACTER SET utf8 DEFAULT NULL,
  `publish_state` int(255) unsigned zerofill DEFAULT NULL COMMENT '发布状态   或者审核状态   0、未审核；1、审核通过；2、审核未通过；100下架',
  `publish_time` datetime DEFAULT NULL COMMENT '发布时间/审核时间',
  `verifier` int(255) DEFAULT NULL COMMENT '审核人',
  `verify_memo` varchar(255) CHARACTER SET utf8 DEFAULT NULL COMMENT '审核意见',
  `sort` int(255) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `delete_flag` int(1) DEFAULT NULL,
  `video_time` int(255) DEFAULT NULL,
  `content` text CHARACTER SET utf8,
  `click_num` int(11) DEFAULT NULL,
  `index_show` int(1) DEFAULT NULL COMMENT '是否在首页显示 0否 1是',
  PRIMARY KEY (`course_id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of course_info
-- ----------------------------
INSERT INTO `course_info` VALUES ('3', null, '小小科学家', '0', null, '学生第一次接触科学，心中充满好奇，但是又不清楚到底科学是什么，希望借助谈话，提问的方式，让孩子们从自己口中和别人口中认识“科学”，拉近科学家和“小小科学家”间的距离。', 'xiaoxiao.png', 'xiaoxiao.pptx', '小小科学家.pptx', null, null, null, '', '000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000001', null, '1', '', '1', '2020-09-30 14:09:47', '2020-10-17 16:36:30', '0', null, '<p>\r\n	<p class=\"MsoNormal\">\r\n		一、游戏导入：通过说反话游戏引入课题；\r\n	</p>\r\n	<p class=\"MsoNormal\">\r\n		二、探究新知：\r\n	</p>\r\n	<p class=\"MsoNormal\">\r\n		（一）、理解题意，提出问题；（二）、初步探究数量关系；<span lang=\"EN-US\"><o:p></o:p></span>\r\n	</p>\r\n	<p class=\"MsoNormal\">\r\n		（三）、方法宝盒，进行小结；<span lang=\"EN-US\"><o:p></o:p></span>\r\n	</p>\r\n	<p class=\"MsoNormal\">\r\n		三、小试牛刀，学以致用；<span lang=\"EN-US\"><o:p></o:p></span>\r\n	</p>\r\n	<p class=\"MsoNormal\">\r\n		四、方法宝盒，再次总结；<span lang=\"EN-US\"><o:p></o:p></span>\r\n	</p>\r\n	<p class=\"MsoNormal\">\r\n		五、认知冲突，活学活用；<span lang=\"EN-US\"><o:p></o:p></span>\r\n	</p>\r\n六、我的收获，课堂总结。\r\n</p>', null, null);
INSERT INTO `course_info` VALUES ('4', null, '11科学学科《玩转小水轮》', '0', null, '知道水有力量，并尝试通过实验发现水流量的大小、水位高低会影响小水轮转动的快慢。', 'QQ截图20200930141235.png', 'wanzhuanshuilun.pptx', '科学学科《玩转小水轮》邸娟ppt.pptx', null, null, null, '', '000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000001', null, '1', '', '2', '2020-09-30 14:22:24', '2020-10-17 16:36:30', '0', null, '', null, null);
INSERT INTO `course_info` VALUES ('5', null, '二年级科学《认识常见材料》', '0', null, '本课为苏教版小学科学二年级下册《它们是什么做的》单元的起始课，该单元共有三课，分别是《认识常见材料》、《各种各样的杯子》、《神奇的新材料》，可见该单元的研究都是围绕“材料”展开的，因而第一课时对于常见材料的认识既是基础部分，也是重要部分。', 'QQ截图20200930143543.png', 'cailiao.pptx', '二下科学《认识常见材料》课件.pptx', null, null, null, '邸娟', '000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000001', null, '1', '', '3', '2020-09-30 14:36:41', '2020-10-17 16:36:30', '0', null, '', null, null);
INSERT INTO `course_info` VALUES ('6', null, '什么是面积', '0', null, '', 'QQ截图202009301438021.png', 'mianji.mp4', '高珊珊《什么是面积》录播课.mp4', null, null, null, '邸娟', '000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000001', null, '1', '', '4', '2020-09-30 14:51:13', '2020-10-17 16:36:30', '0', null, '', null, null);
INSERT INTO `course_info` VALUES ('7', null, '一天的时间', '0', null, '', 'QQ截图202009301438423.png', 'oneday.ppt', '数学三上《一天的时间》课件.ppt', null, null, null, '高珊珊', '000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000001', null, '1', '', '5', '2020-09-30 14:52:14', '2020-10-17 16:36:30', '0', null, '', null, null);
INSERT INTO `course_info` VALUES ('8', null, '秋天的图画', '0', null, '秋天是个美丽的季节，是一个丰收的季节，是一个令人欣喜的季节，是一个充满希望的季节。今天我们一同来学习一篇关于秋天的课文，《秋天的图画》（板书课题）请同学们跟我一起书空课题。', '', 'qiutian.doc', '《秋天的图画》教学设计(1).doc', null, null, null, '杨欢', '000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000001', null, '1', '', '6', '2020-09-30 14:53:25', '2020-10-17 16:36:30', '0', null, '', null, null);
INSERT INTO `course_info` VALUES ('9', null, '祖父的园子', '0', null, '作者为什么能将她的童年生活写得那样有趣，真实，吸引读者？', 'QQ截图20200930145352.png', 'zufudeyuanzikejian.ppt', '《祖父的园子》课件.ppt', null, null, null, '杨欢', '000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000001', null, '1', '', '7', '2020-09-30 14:54:39', '2020-10-17 16:36:30', '0', null, '', null, null);
INSERT INTO `course_info` VALUES ('10', null, '比例尺', '1', null, '《比例尺》是在学生学习了比例的意义及其基本性质的基础上进行教学的。这一部分内容对学生来说比较陌生、抽象，难以理解，且与实际生活较远，不易让学生直观的理解。因此我在设计教学环节时，仔细分析了教材的设计意图，同时又思考如何将这样一节概念教学恰到好处的与学生的生活实际联系起来。在接下来的练习中计算比例尺，比如计算比例尺时，要让学生知道只有图上距离和实际距离单位统一才能写出比。从而达到教学目标，掌握知识。', 'bilichi.png', '20160317.mp4', '20160317比例尺.mp4', null, null, null, '拜石茹', '000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000001', null, '1', '', '8', '2020-09-30 14:56:06', '2020-10-17 16:36:30', '0', null, '', null, null);
INSERT INTO `course_info` VALUES ('11', null, '《船》', '1', null, '疫情期间，通过本节微课的学习让孩子们在家也可以通过网络学习“停课不停学”。本节微课介绍了不同时期船的结构特点、用途，使学生知道船是人们生活中不可缺少的交通工具。全课通过大量的图片资料，让学生认识船、了解船，通过观察欣赏，提高学生对船的认识，激发学生对船产生浓厚的兴趣，点然他们创造的激情。', 'chuan.png', 'chuan.mp4', '吴佟微课《船》.mp4', null, null, null, '吴佟', '000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000001', null, '1', '', '9', '2020-09-30 14:57:13', '2020-10-17 16:36:30', '0', null, '', null, null);
INSERT INTO `course_info` VALUES ('12', null, '搭一搭', '1', null, '本节课是在认识除法和余数的基础上，进一步巩固对有余数除法意义的认识，学习竖式的书写格式。本微课是在操作的基础上，结合搭房子的过程，理解竖式各部分的意思，并学会用自己的语言解释，培养学生利用所学知识解决实际问题的能力。', 'dayida.png', 'dayida.mp4', '搭一搭（二）.闫红雪.mp4', null, null, null, '闫红雪', '000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000001', null, '1', '', '10', '2020-09-30 14:58:30', '2020-10-17 16:36:30', '0', null, '', null, null);
INSERT INTO `course_info` VALUES ('13', null, '体感切水果游戏', '1', null, '在新型冠状病毒疫情爆发伊始，工信部科技司就发布了《充分发挥人工智能赋能效用 协力抗击新型冠状病毒感染的肺炎疫情倡议书》，倡议进一步发挥人工智能赋能效用，组织科研和生产力量，把加快有效支撑疫情防控的相关产品攻关和应用作为优先工作。在人工智能技术中，有一种增强现实技术在这次抗击疫情中发挥了重要作用。在这一背景下应用增强现实技术开发了《好玩的体感切水果游戏》，在疫情期间作为线上课程让学生学习人工智能技术。', 'qieshuiguo.png', 'tigan.mp4', '参数作品_体感切水果游戏.mp4', null, null, null, '赵文安', '000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000001', null, '1', '', '11', '2020-09-30 14:59:42', '2020-10-17 16:36:30', '0', null, '', null, null);
INSERT INTO `course_info` VALUES ('14', null, '解决“求比一个数多（少）几“的问题', '1', null, '', 'jiejueshu.png', 'jiejueshu.mp4', '交大附小李丹微课《解决“求比一个数多（少）几“的问题》.mp4', null, null, null, '李丹', '000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000001', null, '1', '', '12', '2020-09-30 15:01:41', '2020-10-17 16:36:30', '0', null, '<p>\r\n	<p class=\"MsoNormal\">\r\n		一、游戏导入：通过说反话游戏引入课题；\r\n	</p>\r\n	<p class=\"MsoNormal\">\r\n		二、探究新知：\r\n	</p>\r\n	<p class=\"MsoNormal\">\r\n		（一）、理解题意，提出问题；（二）、初步探究数量关系；<span lang=\"EN-US\"><o:p></o:p></span>\r\n	</p>\r\n	<p class=\"MsoNormal\">\r\n		（三）、方法宝盒，进行小结；<span lang=\"EN-US\"><o:p></o:p></span>\r\n	</p>\r\n	<p class=\"MsoNormal\">\r\n		三、小试牛刀，学以致用；<span lang=\"EN-US\"><o:p></o:p></span>\r\n	</p>\r\n	<p class=\"MsoNormal\">\r\n		四、方法宝盒，再次总结；<span lang=\"EN-US\"><o:p></o:p></span>\r\n	</p>\r\n	<p class=\"MsoNormal\">\r\n		五、认知冲突，活学活用；<span lang=\"EN-US\"><o:p></o:p></span>\r\n	</p>\r\n六、我的收获，课堂总结。\r\n</p>', null, null);
INSERT INTO `course_info` VALUES ('15', null, '口字旁书法', '1', null, '本课为北师大版书法教学指导四年级下册第一单元偏旁部首学习的第一课《口字旁》，偏旁部首是字形结构的重要组成部分，其形态基本上是固定的，只是根据偏旁部首以外的组成部分变化，适当的在高、低、宽、窄、大、小、轻、重等方面做出相应的调整。在上学期基本笔画的学习基础上，这学期继续偏旁部首的学习。重点让学生掌握口字旁的形态及写法，以及在结字时的变化和搭配要领，规范书写。', 'kouzipang.png', 'shufa.mp4', '口字旁+书法+碑林区+西安交通大学附属小学+李心茹.mp4', null, null, null, '李心茹', '000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000001', null, '1', '', '13', '2020-09-30 15:02:42', '2020-10-17 16:36:30', '0', null, '', null, null);

-- ----------------------------
-- Table structure for course_info_history
-- ----------------------------
DROP TABLE IF EXISTS `course_info_history`;
CREATE TABLE `course_info_history` (
  `course_release_num` varchar(16) CHARACTER SET utf8 NOT NULL COMMENT '课程发布版本号',
  `course_id` int(11) NOT NULL,
  `course_name` varchar(255) CHARACTER SET utf8 NOT NULL,
  `course_type` int(255) NOT NULL,
  `courseware_type` int(255) DEFAULT NULL COMMENT '课程类型  1视频  2 word 3 excel 4 ppt',
  `summary` varchar(255) CHARACTER SET utf8 DEFAULT NULL,
  `pic` varchar(255) CHARACTER SET utf8 DEFAULT NULL,
  `source_new` varchar(255) CHARACTER SET utf8 DEFAULT NULL,
  `source` varchar(255) CHARACTER SET utf8 DEFAULT NULL,
  `fujian_new` varchar(255) CHARACTER SET utf8 DEFAULT NULL,
  `fujian` varchar(255) CHARACTER SET utf8 DEFAULT NULL,
  `lecturer_id` int(11) DEFAULT NULL,
  `lecturer` varchar(255) CHARACTER SET utf8 DEFAULT NULL,
  `publish_state` int(255) DEFAULT NULL COMMENT '发布状态   或者审核状态   0、未审核；1、审核通过；2、审核未通过；',
  `publish_time` datetime DEFAULT NULL COMMENT '发布时间/审核时间',
  `verifier` int(255) DEFAULT NULL COMMENT '审核人',
  `verify_memo` varchar(255) CHARACTER SET utf8 DEFAULT NULL COMMENT '审核意见',
  `sort` int(255) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `delete_flag` varchar(255) CHARACTER SET utf8 DEFAULT NULL,
  `video_time` int(255) DEFAULT NULL,
  `content` text CHARACTER SET utf8,
  PRIMARY KEY (`course_release_num`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of course_info_history
-- ----------------------------
INSERT INTO `course_info_history` VALUES ('1011602923702574', '10', '比例尺', '1', null, '《比例尺》是在学生学习了比例的意义及其基本性质的基础上进行教学的。这一部分内容对学生来说比较陌生、抽象，难以理解，且与实际生活较远，不易让学生直观的理解。因此我在设计教学环节时，仔细分析了教材的设计意图，同时又思考如何将这样一节概念教学恰到好处的与学生的生活实际联系起来。在接下来的练习中计算比例尺，比如计算比例尺时，要让学生知道只有图上距离和实际距离单位统一才能写出比。从而达到教学目标，掌握知识。', 'bilichi.png', '20160317.mp4', '20160317比例尺.mp4', null, null, null, '拜石茹', '1', '2020-10-17 16:35:02', '1', '', '8', '2020-09-30 14:56:06', '0', null, '');
INSERT INTO `course_info_history` VALUES ('1111602923702604', '11', '《船》', '1', null, '疫情期间，通过本节微课的学习让孩子们在家也可以通过网络学习“停课不停学”。本节微课介绍了不同时期船的结构特点、用途，使学生知道船是人们生活中不可缺少的交通工具。全课通过大量的图片资料，让学生认识船、了解船，通过观察欣赏，提高学生对船的认识，激发学生对船产生浓厚的兴趣，点然他们创造的激情。', 'chuan.png', 'chuan.mp4', '吴佟微课《船》.mp4', null, null, null, '吴佟', '1', '2020-10-17 16:35:02', '1', '', '9', '2020-09-30 14:57:13', '0', null, '');
INSERT INTO `course_info_history` VALUES ('1211602923702619', '12', '搭一搭', '1', null, '本节课是在认识除法和余数的基础上，进一步巩固对有余数除法意义的认识，学习竖式的书写格式。本微课是在操作的基础上，结合搭房子的过程，理解竖式各部分的意思，并学会用自己的语言解释，培养学生利用所学知识解决实际问题的能力。', 'dayida.png', 'dayida.mp4', '搭一搭（二）.闫红雪.mp4', null, null, null, '闫红雪', '1', '2020-10-17 16:35:02', '1', '', '10', '2020-09-30 14:58:30', '0', null, '');
INSERT INTO `course_info_history` VALUES ('1311602923702639', '13', '体感切水果游戏', '1', null, '在新型冠状病毒疫情爆发伊始，工信部科技司就发布了《充分发挥人工智能赋能效用 协力抗击新型冠状病毒感染的肺炎疫情倡议书》，倡议进一步发挥人工智能赋能效用，组织科研和生产力量，把加快有效支撑疫情防控的相关产品攻关和应用作为优先工作。在人工智能技术中，有一种增强现实技术在这次抗击疫情中发挥了重要作用。在这一背景下应用增强现实技术开发了《好玩的体感切水果游戏》，在疫情期间作为线上课程让学生学习人工智能技术。', 'qieshuiguo.png', 'tigan.mp4', '参数作品_体感切水果游戏.mp4', null, null, null, '赵文安', '1', '2020-10-17 16:35:02', '1', '', '11', '2020-09-30 14:59:42', '0', null, '');
INSERT INTO `course_info_history` VALUES ('1411602923702657', '14', '解决“求比一个数多（少）几“的问题', '1', null, '', 'jiejueshu.png', 'jiejueshu.mp4', '交大附小李丹微课《解决“求比一个数多（少）几“的问题》.mp4', null, null, null, '李丹', '1', '2020-10-17 16:35:02', '1', '', '12', '2020-09-30 15:01:41', '0', null, '<p>\r\n	<p class=\"MsoNormal\">\r\n		一、游戏导入：通过说反话游戏引入课题；\r\n	</p>\r\n	<p class=\"MsoNormal\">\r\n		二、探究新知：\r\n	</p>\r\n	<p class=\"MsoNormal\">\r\n		（一）、理解题意，提出问题；（二）、初步探究数量关系；<span lang=\"EN-US\"><o:p></o:p></span>\r\n	</p>\r\n	<p class=\"MsoNormal\">\r\n		（三）、方法宝盒，进行小结；<span lang=\"EN-US\"><o:p></o:p></span>\r\n	</p>\r\n	<p class=\"MsoNormal\">\r\n		三、小试牛刀，学以致用；<span lang=\"EN-US\"><o:p></o:p></span>\r\n	</p>\r\n	<p class=\"MsoNormal\">\r\n		四、方法宝盒，再次总结；<span lang=\"EN-US\"><o:p></o:p></span>\r\n	</p>\r\n	<p class=\"MsoNormal\">\r\n		五、认知冲突，活学活用；<span lang=\"EN-US\"><o:p></o:p></span>\r\n	</p>\r\n六、我的收获，课堂总结。\r\n</p>');
INSERT INTO `course_info_history` VALUES ('1511602755949953', '48', '333', '1', null, '3', '', '', '', '', '', '2', '杨欢', '1', '2020-10-15 17:58:10', null, null, '14', '2020-10-15 17:58:10', '0', null, '3');
INSERT INTO `course_info_history` VALUES ('1511602923702673', '15', '口字旁书法', '1', null, '本课为北师大版书法教学指导四年级下册第一单元偏旁部首学习的第一课《口字旁》，偏旁部首是字形结构的重要组成部分，其形态基本上是固定的，只是根据偏旁部首以外的组成部分变化，适当的在高、低、宽、窄、大、小、轻、重等方面做出相应的调整。在上学期基本笔画的学习基础上，这学期继续偏旁部首的学习。重点让学生掌握口字旁的形态及写法，以及在结字时的变化和搭配要领，规范书写。', 'kouzipang.png', 'shufa.mp4', '口字旁+书法+碑林区+西安交通大学附属小学+李心茹.mp4', null, null, null, '李心茹', '1', '2020-10-17 16:35:02', '1', '', '13', '2020-09-30 15:02:42', '0', null, '');
INSERT INTO `course_info_history` VALUES ('301602920460024', '3', '小小科学家', '0', null, '学生第一次接触科学，心中充满好奇，但是又不清楚到底科学是什么，希望借助谈话，提问的方式，让孩子们从自己口中和别人口中认识“科学”，拉近科学家和“小小科学家”间的距离。', 'xiaoxiao.png', 'xiaoxiao.pptx', '小小科学家.pptx', null, null, null, '', '1', '2020-10-17 15:40:59', '1', '', '1', '2020-09-30 14:09:47', '0', null, '<p>\r\n	<p class=\"MsoNormal\">\r\n		一、游戏导入：通过说反话游戏引入课题；\r\n	</p>\r\n	<p class=\"MsoNormal\">\r\n		二、探究新知：\r\n	</p>\r\n	<p class=\"MsoNormal\">\r\n		（一）、理解题意，提出问题；（二）、初步探究数量关系；<span lang=\"EN-US\"><o:p></o:p></span>\r\n	</p>\r\n	<p class=\"MsoNormal\">\r\n		（三）、方法宝盒，进行小结；<span lang=\"EN-US\"><o:p></o:p></span>\r\n	</p>\r\n	<p class=\"MsoNormal\">\r\n		三、小试牛刀，学以致用；<span lang=\"EN-US\"><o:p></o:p></span>\r\n	</p>\r\n	<p class=\"MsoNormal\">\r\n		四、方法宝盒，再次总结；<span lang=\"EN-US\"><o:p></o:p></span>\r\n	</p>\r\n	<p class=\"MsoNormal\">\r\n		五、认知冲突，活学活用；<span lang=\"EN-US\"><o:p></o:p></span>\r\n	</p>\r\n六、我的收获，课堂总结。\r\n</p>');
INSERT INTO `course_info_history` VALUES ('401602923702357', '4', '11科学学科《玩转小水轮》', '0', null, '知道水有力量，并尝试通过实验发现水流量的大小、水位高低会影响小水轮转动的快慢。', 'QQ截图20200930141235.png', 'wanzhuanshuilun.pptx', '科学学科《玩转小水轮》邸娟ppt.pptx', null, null, null, '', '1', '2020-10-17 16:35:02', '1', '', '2', '2020-09-30 14:22:24', '0', null, '');
INSERT INTO `course_info_history` VALUES ('4811602755963372', '49', '222', '1', null, '2', '', '', '', '', '', '6', '赵悦芳', '1', '2020-10-15 17:59:23', null, null, '15', '2020-10-15 17:59:23', '0', null, '2');
INSERT INTO `course_info_history` VALUES ('501602923702399', '5', '二年级科学《认识常见材料》', '0', null, '本课为苏教版小学科学二年级下册《它们是什么做的》单元的起始课，该单元共有三课，分别是《认识常见材料》、《各种各样的杯子》、《神奇的新材料》，可见该单元的研究都是围绕“材料”展开的，因而第一课时对于常见材料的认识既是基础部分，也是重要部分。', 'QQ截图20200930143543.png', 'cailiao.pptx', '二下科学《认识常见材料》课件.pptx', null, null, null, '邸娟', '1', '2020-10-17 16:35:02', '1', '', '3', '2020-09-30 14:36:41', '0', null, '');
INSERT INTO `course_info_history` VALUES ('5111602912136195', '52', '111', '1', null, '111', '', '', '', '', '', '2', '杨欢', '1', '2020-10-17 13:22:02', null, null, '17', '2020-10-17 13:22:02', '0', null, '');
INSERT INTO `course_info_history` VALUES ('5211602912149951', '53', '2222', '1', null, '2222', '', '', '', '', '', '3', '高珊珊', '1', '2020-10-17 13:22:29', null, null, '18', '2020-10-17 13:22:29', '0', null, '');
INSERT INTO `course_info_history` VALUES ('5311602912161805', '54', '3333', '1', null, '333', '', '', '', '', '', '5', '邸娟', '1', '2020-10-17 13:22:41', null, null, '19', '2020-10-17 13:22:41', '0', null, '');
INSERT INTO `course_info_history` VALUES ('5411602912177111', '55', '444', '1', null, '4', '', '', '', '', '', '6', '赵悦芳', '1', '2020-10-17 13:22:55', null, null, '20', '2020-10-17 13:22:55', '0', null, '');
INSERT INTO `course_info_history` VALUES ('5511602912188266', '56', '333', '1', null, '333', '', '', '', '', '', '7', '肖珂', '1', '2020-10-17 13:23:07', null, null, '21', '2020-10-17 13:23:07', '0', null, '');
INSERT INTO `course_info_history` VALUES ('5611602912197457', '57', '5555', '1', null, '', '', '', '', '', '', '8', '赵文安', '1', '2020-10-17 13:23:16', null, null, '22', '2020-10-17 13:23:16', '0', null, '');
INSERT INTO `course_info_history` VALUES ('5711602912205557', '58', '222', '1', null, '', '', '', '', '', '', '9', '秦楠', '1', '2020-10-17 13:23:24', null, null, '23', '2020-10-17 13:23:24', '0', null, '');
INSERT INTO `course_info_history` VALUES ('601602923702455', '6', '什么是面积', '0', null, '', 'QQ截图202009301438021.png', 'mianji.mp4', '高珊珊《什么是面积》录播课.mp4', null, null, null, '邸娟', '1', '2020-10-17 16:35:02', '1', '', '4', '2020-09-30 14:51:13', '0', null, '');
INSERT INTO `course_info_history` VALUES ('701602923702503', '7', '一天的时间', '0', null, '', 'QQ截图202009301438423.png', 'oneday.ppt', '数学三上《一天的时间》课件.ppt', null, null, null, '高珊珊', '1', '2020-10-17 16:35:02', '1', '', '5', '2020-09-30 14:52:14', '0', null, '');
INSERT INTO `course_info_history` VALUES ('801602923702525', '8', '秋天的图画', '0', null, '秋天是个美丽的季节，是一个丰收的季节，是一个令人欣喜的季节，是一个充满希望的季节。今天我们一同来学习一篇关于秋天的课文，《秋天的图画》（板书课题）请同学们跟我一起书空课题。', '', 'qiutian.doc', '《秋天的图画》教学设计(1).doc', null, null, null, '杨欢', '1', '2020-10-17 16:35:02', '1', '', '6', '2020-09-30 14:53:25', '0', null, '');
INSERT INTO `course_info_history` VALUES ('901602923702544', '9', '祖父的园子', '0', null, '作者为什么能将她的童年生活写得那样有趣，真实，吸引读者？', 'QQ截图20200930145352.png', 'zufudeyuanzikejian.ppt', '《祖父的园子》课件.ppt', null, null, null, '杨欢', '1', '2020-10-17 16:35:02', '1', '', '7', '2020-09-30 14:54:39', '0', null, '');

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
) ENGINE=InnoDB AUTO_INCREMENT=27 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='操作日志';

-- ----------------------------
-- Records of log_operation
-- ----------------------------
INSERT INTO `log_operation` VALUES ('1', '1', '2020-10-16 16:12:26', '1', 'admin', '0:0:0:0:0:0:0:1', '', '删除', '3;');
INSERT INTO `log_operation` VALUES ('2', '1', '2020-10-16 16:13:11', '1', 'admin', '0:0:0:0:0:0:0:1', '新增模块信息', '更新', '{\"moduleId\":null,\"appId\":1,\"moduleName\":\"操作日志\",\"moduleCode\":\"\",\"moduleClass\":\"\",\"modulePath\":\"logbilloperationlist.html\",\"moduleDescription\":\"\",\"moduleParent\":0,\"moduleSort\":1,\"moduleIsdisable\":0,\"createTime\":1602835991815,\"updateTime\":1602835991815,\"deleteFlag\":0};');
INSERT INTO `log_operation` VALUES ('3', '1', '2020-10-17 16:36:18', '1', 'admin', '0:0:0:0:0:0:0:1', '批量下架课程', '更新', '{};[4,5,6,7,8,9,10,11,12,13,14,15,3];');
INSERT INTO `log_operation` VALUES ('4', '1', '2020-10-19 11:49:11', '1', 'admin', '172.16.99.198', '新增模块信息', '更新', '{\"moduleId\":null,\"appId\":1,\"moduleName\":\"教师管理\",\"moduleCode\":\"\",\"moduleClass\":\"\",\"modulePath\":\"teacherlist\",\"moduleDescription\":\"\",\"moduleParent\":193,\"moduleSort\":1,\"moduleIsdisable\":0,\"createTime\":1603079351336,\"updateTime\":1603079351336,\"deleteFlag\":0};');
INSERT INTO `log_operation` VALUES ('5', '1', '2020-10-19 11:50:25', '1', 'admin', '172.16.99.198', '新增模块信息', '更新', '{\"moduleId\":null,\"appId\":1,\"moduleName\":\"用户管理\",\"moduleCode\":\"\",\"moduleClass\":\"\",\"modulePath\":\"userlist.html\",\"moduleDescription\":\"\",\"moduleParent\":193,\"moduleSort\":1,\"moduleIsdisable\":0,\"createTime\":1603079425668,\"updateTime\":1603079425668,\"deleteFlag\":0};');
INSERT INTO `log_operation` VALUES ('6', '1', '2020-10-19 11:50:48', '1', 'admin', '172.16.99.198', '模块排序', '更新', '208;0;3;');
INSERT INTO `log_operation` VALUES ('7', '1', '2020-10-19 11:50:51', '1', 'admin', '172.16.99.198', '模块排序', '更新', '208;193;0;');
INSERT INTO `log_operation` VALUES ('8', '1', '2020-10-19 13:42:33', '1', 'admin', '172.16.99.198', '重置密码', '更新', '34;');
INSERT INTO `log_operation` VALUES ('9', '1', '2020-10-19 17:20:25', '1', 'admin', '172.16.99.198', '生成证书', '更新', '1;1;');
INSERT INTO `log_operation` VALUES ('10', '1', '2020-10-19 17:21:49', '1', 'admin', '172.16.99.198', '生成证书', '更新', '1;2;[15,14,13];');
INSERT INTO `log_operation` VALUES ('11', '1', '2020-10-19 17:27:55', '1', 'admin', '172.16.99.198', '生成证书', '更新', '1;2;[15,14,13];');
INSERT INTO `log_operation` VALUES ('12', '1', '2020-10-19 17:39:18', '1', 'admin', '172.16.99.198', '生成证书', '更新', '7;[15,14,13];');
INSERT INTO `log_operation` VALUES ('13', '1', '2020-10-20 14:35:53', '1', 'admin', '0:0:0:0:0:0:0:1', '移除老师', '删除', '8;');
INSERT INTO `log_operation` VALUES ('14', '1', '2020-10-22 09:15:37', '1', 'admin', '0:0:0:0:0:0:0:1', '新增模块信息', '更新', '{\"moduleId\":null,\"appId\":1,\"moduleName\":\"问卷管理\",\"moduleCode\":\"\",\"moduleClass\":\"\",\"modulePath\":\"\",\"moduleDescription\":\"\",\"moduleParent\":0,\"moduleSort\":4,\"moduleIsdisable\":0,\"createTime\":1603329337881,\"updateTime\":1603329337881,\"deleteFlag\":0};');
INSERT INTO `log_operation` VALUES ('15', '1', '2020-10-22 09:16:02', '1', 'admin', '0:0:0:0:0:0:0:1', '新增模块信息', '更新', '{\"moduleId\":null,\"appId\":1,\"moduleName\":\"问卷中心\",\"moduleCode\":\"\",\"moduleClass\":\"\",\"modulePath\":\"\",\"moduleDescription\":\"\",\"moduleParent\":209,\"moduleSort\":1,\"moduleIsdisable\":0,\"createTime\":1603329362341,\"updateTime\":1603329362341,\"deleteFlag\":0};');
INSERT INTO `log_operation` VALUES ('16', '1', '2020-10-22 09:16:22', '1', 'admin', '0:0:0:0:0:0:0:1', '新增模块信息', '更新', '{\"moduleId\":null,\"appId\":1,\"moduleName\":\"问题列表\",\"moduleCode\":\"\",\"moduleClass\":\"\",\"modulePath\":\"\",\"moduleDescription\":\"\",\"moduleParent\":209,\"moduleSort\":2,\"moduleIsdisable\":0,\"createTime\":1603329382423,\"updateTime\":1603329382423,\"deleteFlag\":0};');
INSERT INTO `log_operation` VALUES ('17', '1', '2020-10-22 09:17:29', '1', 'admin', '0:0:0:0:0:0:0:1', '新增模块信息', '更新', '{\"moduleId\":null,\"appId\":1,\"moduleName\":\"用户答卷列表\",\"moduleCode\":\"\",\"moduleClass\":\"\",\"modulePath\":\"answerrecordlist.html\",\"moduleDescription\":\"\",\"moduleParent\":209,\"moduleSort\":1,\"moduleIsdisable\":0,\"createTime\":1603329449333,\"updateTime\":1603329449333,\"deleteFlag\":0};');
INSERT INTO `log_operation` VALUES ('18', '1', '2020-10-22 09:17:38', '1', 'admin', '0:0:0:0:0:0:0:1', '模块排序', '更新', '212;209;2;');
INSERT INTO `log_operation` VALUES ('19', '1', '2020-10-22 17:07:47', '1', 'admin', '0:0:0:0:0:0:0:1', 'Excel导入用户信息', '更新', '');
INSERT INTO `log_operation` VALUES ('20', '1', '2020-10-22 17:09:52', '1', 'admin', '0:0:0:0:0:0:0:1', 'Excel导入用户信息', '更新', '');
INSERT INTO `log_operation` VALUES ('21', '1', '2020-10-22 17:10:28', '1', 'admin', '0:0:0:0:0:0:0:1', 'Excel导入用户信息', '更新', '');
INSERT INTO `log_operation` VALUES ('22', '1', '2020-10-22 17:11:21', '1', 'admin', '0:0:0:0:0:0:0:1', 'Excel导入用户信息', '更新', '');
INSERT INTO `log_operation` VALUES ('23', '1', '2020-10-22 17:12:28', '1', 'admin', '0:0:0:0:0:0:0:1', 'Excel导入用户信息', '更新', '');
INSERT INTO `log_operation` VALUES ('24', '1', '2020-10-22 17:13:45', '1', 'admin', '0:0:0:0:0:0:0:1', 'Excel导入用户信息', '更新', '');
INSERT INTO `log_operation` VALUES ('25', '1', '2020-10-22 17:14:55', '1', 'admin', '0:0:0:0:0:0:0:1', 'Excel导入用户信息', '更新', '');
INSERT INTO `log_operation` VALUES ('26', '1', '2020-10-23 09:51:25', '1', 'admin', '0:0:0:0:0:0:0:1', '新增模块信息', '更新', '{\"moduleId\":null,\"appId\":1,\"moduleName\":\"题库管理\",\"moduleCode\":\"\",\"moduleClass\":\"\",\"modulePath\":\"\",\"moduleDescription\":\"\",\"moduleParent\":209,\"moduleSort\":1,\"moduleIsdisable\":0,\"createTime\":1603417885801,\"updateTime\":1603417885801,\"deleteFlag\":0};');

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
  `publish_url` varchar(500) CHARACTER SET utf8mb4 DEFAULT NULL COMMENT '发布地址',
  `publish_time` datetime NOT NULL COMMENT '发布时间',
  `publish_state` int(11) DEFAULT '0' COMMENT '发布状态：0、未发布 ；1、已发布 ',
  `tumb_pic_code` varchar(50) DEFAULT NULL COMMENT '内容列表缩略图',
  `tumb_pic_code2` varchar(50) DEFAULT NULL COMMENT '内容列表缩略图',
  `tumb_pic_code3` varchar(50) DEFAULT NULL COMMENT '内容列表缩略图',
  `tumb` varchar(500) DEFAULT NULL COMMENT '缩略图',
  `video_address` varchar(500) DEFAULT NULL COMMENT '视频地址',
  `click_num` int(11) DEFAULT '0' COMMENT '点击量',
  `sort` int(11) DEFAULT NULL COMMENT '排序',
  `index_show` int(11) DEFAULT '0' COMMENT '是否在首页显示 0否 1是',
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
INSERT INTO `operate_article` VALUES ('2763', '1', '明月照我心 天涯共此时——五年级组自主活动报道', '中华传统文化源远流长，为弘扬中华民族的优秀传统文化，增强中华文化自信，培育具有民族精神的未来人才，我们五年级组特举行“明月照我心天涯共此时”优秀手抄报展示活动。', '未知', '五年级班主任', null, '<p style=\"padding:0px;margin:0cm 0cm 0pt;line-height:21px;color:#333333;font-family:宋体;font-size:14px;white-space:normal;text-indent:24pt;\">\r\n	<span style=\"font-family:宋体;\">中华传统文化源远流长，为弘扬中华民族的优秀传统文化，增强中华文化自信，培育具有民族精神的未来人才，我们五年级组特举行“明月照我心天涯共此时”优秀手抄报展示活动。</span>\r\n</p>\r\n<p align=\"center\" style=\"padding:0px;margin:0cm 0cm 0pt;line-height:21px;color:#333333;font-family:宋体;font-size:14px;white-space:normal;text-align:center;\">\r\n	<span lang=\"EN-US\"><img height=\"425\" src=\"http://www.xajdfx.com/UploadFiles/xxxw/2020/9/202009251638344445.jpg\" width=\"567\" style=\"padding:0px;margin:0px;max-width:600px;height:auto;\" /></span>\r\n</p>\r\n<p class=\"MsoNormal\" style=\"padding:0px;margin:0cm 0cm 0pt;line-height:21px;color:#333333;font-family:宋体;font-size:14px;white-space:normal;text-indent:24pt;\">\r\n	<span style=\"line-height:24px;font-size:12pt;\">本次活动本着人人参与的原则，旨在培养学生的传统文化素养及爱国情怀，陶冶学生的艺术情操。激发同学们通过传统节日的习俗等相关知识的了解来表达自己对祖国的传统文化的热爱之情。<span lang=\"EN-US\"></span></span>\r\n</p>\r\n<p class=\"MsoNormal\" style=\"padding:0px;margin:0cm 0cm 0pt;line-height:21px;color:#333333;font-family:宋体;font-size:14px;white-space:normal;text-indent:24pt;\">\r\n	<span lang=\"EN-US\" style=\"line-height:24px;font-size:12pt;\"><img height=\"430\" src=\"http://www.xajdfx.com/UploadFiles/xxxw/2020/9/202009251638348738.jpg\" width=\"567\" style=\"padding:0px;margin:0px;max-width:600px;height:auto;\" /></span>\r\n</p>\r\n<p class=\"MsoNormal\" style=\"padding:0px;margin:0cm 0cm 0pt;line-height:21px;color:#333333;font-family:宋体;font-size:14px;white-space:normal;text-indent:24.1pt;\">\r\n	<b><span lang=\"EN-US\" style=\"line-height:24px;font-size:12pt;\"><img height=\"425\" src=\"http://www.xajdfx.com/UploadFiles/xxxw/2020/9/202009251638348351.jpg\" width=\"567\" style=\"padding:0px;margin:0px;max-width:600px;height:auto;\" /></span></b>\r\n</p>\r\n<p class=\"MsoNormal\" style=\"padding:0px;margin:0cm 0cm 0pt;line-height:21px;color:#333333;font-family:宋体;font-size:14px;white-space:normal;text-indent:24.1pt;\">\r\n	<b><span lang=\"EN-US\" style=\"line-height:24px;font-size:12pt;\"><img height=\"422\" src=\"http://www.xajdfx.com/UploadFiles/xxxw/2020/9/202009251638341239.jpg\" width=\"567\" style=\"padding:0px;margin:0px;max-width:600px;height:auto;\" /></span></b>\r\n</p>\r\n<p class=\"MsoNormal\" style=\"padding:0px;margin:0cm 0cm 0pt;line-height:21px;color:#333333;font-family:宋体;font-size:14px;white-space:normal;text-indent:24.1pt;\">\r\n	<b><span lang=\"EN-US\" style=\"line-height:24px;font-size:12pt;\"><img height=\"424\" src=\"http://www.xajdfx.com/UploadFiles/xxxw/2020/9/202009251638344389.jpg\" width=\"567\" style=\"padding:0px;margin:0px;max-width:600px;height:auto;\" /></span></b><span lang=\"EN-US\" style=\"line-height:24px;font-size:12pt;\"></span>\r\n</p>\r\n<p class=\"MsoNormal\" style=\"padding:0px;margin:0cm 0cm 0pt;line-height:21px;color:#333333;font-family:宋体;font-size:14px;white-space:normal;text-indent:24pt;\">\r\n	<span style=\"line-height:24px;font-size:12pt;\">本次展示活动前期准备充足，同学们能够认真搜集资料，认真制作手抄报。展示过程中，同学们能够一边参观，一边学习。<span lang=\"EN-US\"></span></span>\r\n</p>\r\n<p class=\"MsoNormal\" style=\"padding:0px;margin:0cm 0cm 0pt;line-height:21px;color:#333333;font-family:宋体;font-size:14px;white-space:normal;text-indent:24pt;\">\r\n	<span lang=\"EN-US\" style=\"line-height:24px;font-size:12pt;\"><img height=\"421\" src=\"http://www.xajdfx.com/UploadFiles/xxxw/2020/9/202009251638346919.jpg\" width=\"567\" style=\"padding:0px;margin:0px;max-width:600px;height:auto;\" /></span>\r\n</p>\r\n<p class=\"MsoNormal\" style=\"padding:0px;margin:0cm 0cm 0pt;line-height:21px;color:#333333;font-family:宋体;font-size:14px;white-space:normal;text-indent:24pt;\">\r\n	<span lang=\"EN-US\" style=\"line-height:24px;font-size:12pt;\"><img height=\"417\" src=\"http://www.xajdfx.com/UploadFiles/xxxw/2020/9/202009251638341100.jpg\" width=\"567\" style=\"padding:0px;margin:0px;max-width:600px;height:auto;\" /></span>\r\n</p>\r\n<p class=\"MsoNormal\" style=\"padding:0px;margin:0cm 0cm 0pt;line-height:21px;color:#333333;font-family:宋体;font-size:14px;white-space:normal;text-indent:24pt;\">\r\n	<span style=\"line-height:24px;font-size:12pt;\">通过这样有序的组织，也使孩子们在这次活动中对于传统文化有了进一步的认识，更是增强了民族自豪感和爱国情怀。<span lang=\"EN-US\"></span></span>\r\n</p>\r\n<p class=\"MsoNormal\" style=\"padding:0px;margin:0cm 0cm 0pt;line-height:21px;color:#333333;font-family:宋体;font-size:14px;white-space:normal;text-indent:24pt;\">\r\n	<span lang=\"EN-US\" style=\"line-height:24px;font-size:12pt;\">&nbsp;</span>\r\n</p>\r\n<p class=\"MsoNormal\" style=\"padding:0px;margin:0cm 0cm 0pt;line-height:21px;color:#333333;font-family:宋体;font-size:14px;white-space:normal;text-indent:24pt;\">\r\n	<span lang=\"EN-US\" style=\"line-height:24px;font-size:12pt;\">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span><span style=\"line-height:24px;font-size:12pt;\">文字：高伟<span lang=\"EN-US\">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span>图片：五年级班主任</span>\r\n</p>', null, '2020-09-26 12:10:50', '1', '202009251638344445.jpg', null, null, null, null, '1129', null, '0', '0', '0', null, '2020-09-26 11:52:41', '2020-09-26 11:52:41', '0');
INSERT INTO `operate_article` VALUES ('2764', '1', '交大附小第32个全国爱牙日健康知识讲座进课堂', '', '葛睿瑞', '葛睿瑞', null, '<p class=\"MsoNormal\" style=\"padding:0px;margin:0cm 0cm 0pt;line-height:21px;color:#333333;font-family:宋体;font-size:14px;white-space:normal;text-indent:24pt;\">\r\n	<span style=\"line-height:24px;font-size:12pt;\">随着生活质量的提高，人们饮食结构多样化，随之而来的牙齿健康问题也不容忽视，学龄期儿童口腔问题尤为突出，为了更好的培养我校学生爱护牙齿的好习惯，<span lang=\"EN-US\">9</span>月<span lang=\"EN-US\">21</span>日，在第<span lang=\"EN-US\">32</span>个“全国爱牙日”之际我校保健室为三年级部分班级进行爱牙护牙科普知识讲座。</span>\r\n</p>\r\n<p class=\"MsoNormal\" style=\"padding:0px;margin:0cm 0cm 0pt;line-height:21px;color:#333333;font-family:宋体;font-size:14px;white-space:normal;\">\r\n	<span lang=\"EN-US\" style=\"line-height:24px;font-size:12pt;\"><img height=\"417\" src=\"http://www.xajdfx.com/UploadFiles/xxxw/2020/9/202009251636365068.png\" width=\"554\" style=\"padding:0px;margin:0px;max-width:600px;height:auto;\" /></span>\r\n</p>\r\n<p class=\"MsoNormal\" style=\"padding:0px;margin:0cm 0cm 0pt;line-height:21px;color:#333333;font-family:宋体;font-size:14px;white-space:normal;text-indent:24pt;\">\r\n	<span style=\"line-height:24px;font-size:12pt;\">我校保健室王春莉医生用生动形象的<span lang=\"EN-US\">PPT</span>为学生们讲解了基本的口腔知识、常见口腔疾病、尤其是对牙列不齐、牙齿外伤及发生牙齿外伤后该怎么办？什么是六龄牙，并且如何来保护六龄牙做了详细讲解。</span>\r\n</p>\r\n<p class=\"MsoNormal\" style=\"padding:0px;margin:0cm 0cm 0pt;line-height:21px;color:#333333;font-family:宋体;font-size:14px;white-space:normal;\">\r\n	<span lang=\"EN-US\" style=\"line-height:24px;font-size:12pt;\"><img height=\"415\" src=\"http://www.xajdfx.com/UploadFiles/xxxw/2020/9/202009251636363406.jpg\" width=\"554\" style=\"padding:0px;margin:0px;max-width:600px;height:auto;\" /></span>\r\n</p>\r\n<p class=\"MsoNormal\" style=\"padding:0px;margin:0cm 0cm 0pt;line-height:21px;color:#333333;font-family:宋体;font-size:14px;white-space:normal;\">\r\n	<span lang=\"EN-US\" style=\"line-height:24px;font-size:12pt;\"><img height=\"415\" src=\"http://www.xajdfx.com/UploadFiles/xxxw/2020/9/202009251636365703.png\" width=\"554\" style=\"padding:0px;margin:0px;max-width:600px;height:auto;\" /></span>\r\n</p>\r\n<p class=\"MsoNormal\" style=\"padding:0px;margin:0cm 0cm 0pt;line-height:21px;color:#333333;font-family:宋体;font-size:14px;white-space:normal;text-indent:24pt;\">\r\n	<span style=\"line-height:24px;font-size:12pt;\">讲解中用动画的形式为同学们演示了牙齿的结构、龋齿形成的过程、口腔保健的方法以及如何正确刷牙。</span>\r\n</p>\r\n<p class=\"MsoNormal\" style=\"padding:0px;margin:0cm 0cm 0pt;line-height:21px;color:#333333;font-family:宋体;font-size:14px;white-space:normal;\">\r\n	<span lang=\"EN-US\" style=\"line-height:24px;font-size:12pt;\"><img height=\"415\" src=\"http://www.xajdfx.com/UploadFiles/xxxw/2020/9/202009251636362090.png\" width=\"554\" style=\"padding:0px;margin:0px;max-width:600px;height:auto;\" /></span>\r\n</p>\r\n<p class=\"MsoNormal\" style=\"padding:0px;margin:0cm 0cm 0pt;line-height:21px;color:#333333;font-family:宋体;font-size:14px;white-space:normal;\">\r\n	<span lang=\"EN-US\" style=\"line-height:24px;font-size:12pt;\">&nbsp;</span>\r\n</p>\r\n<p class=\"MsoNormal\" style=\"padding:0px;margin:0cm 0cm 0pt;line-height:21px;color:#333333;font-family:宋体;font-size:14px;white-space:normal;\">\r\n	<span lang=\"EN-US\" style=\"line-height:24px;font-size:12pt;\"><img height=\"395\" src=\"http://www.xajdfx.com/UploadFiles/xxxw/2020/9/202009251636363958.png\" width=\"553\" style=\"padding:0px;margin:0px;max-width:600px;height:auto;\" /></span>\r\n</p>\r\n<p class=\"MsoNormal\" style=\"padding:0px;margin:0cm 0cm 0pt;line-height:21px;color:#333333;font-family:宋体;font-size:14px;white-space:normal;text-indent:24pt;\">\r\n	<span style=\"line-height:24px;font-size:12pt;\">最后，王春莉医生给同学们普查了口腔卫生，给存在口腔牙齿问题的同学提出中肯的治疗建议和预防牙齿疾病的方法。</span>\r\n</p>\r\n<p class=\"MsoNormal\" style=\"padding:0px;margin:0cm 0cm 0pt;line-height:21px;color:#333333;font-family:宋体;font-size:14px;white-space:normal;text-indent:24pt;\">\r\n	<span style=\"line-height:24px;font-size:12pt;\">此次爱牙护牙知识讲座，让同学们深刻认识到牙齿健康的重要性，懂得了如何从小保护好牙齿，为孩子们的口腔健康保驾护航。</span>\r\n</p>\r\n<p align=\"right\" class=\"MsoNormal\" style=\"padding:0px;margin:0cm 32pt 0pt 0cm;line-height:21px;color:#333333;font-family:宋体;font-size:14px;white-space:normal;text-align:right;text-indent:24pt;\">\r\n	<span style=\"line-height:24px;font-size:12pt;\">文字：葛睿瑞<span lang=\"EN-US\">&nbsp;&nbsp;&nbsp;</span>图片：葛睿瑞</span>\r\n</p>', null, '2020-09-26 12:10:50', '1', '202009251636365068.png', null, null, null, null, '25', null, '0', '0', '0', null, '2020-09-26 11:58:59', '2020-09-26 11:58:59', '0');
INSERT INTO `operate_article` VALUES ('2768', '1', '乘风破浪踏刃起，科技扬帆谱新章——西安交通大学附属小学党支部中国西部科技创新港“科创月”活动报道', '', '未知', '卞益婷', null, '<p class=\"MsoNormal\" style=\"padding:0px;margin:0cm 0cm 0pt;line-height:21px;color:#333333;font-family:宋体;font-size:14px;white-space:normal;text-indent:24pt;\">\r\n	<span style=\"line-height:24px;font-size:12pt;\">为了更好的传承和弘扬<span lang=\"EN-US\">“</span>西迁精神<span lang=\"EN-US\">”</span>，深入了解交大创新港所体现的科技创新魅力，引领基础教育改革方向。<span lang=\"EN-US\">9</span>月<span lang=\"EN-US\">17</span>日下午，西安交大附小党支部组织党员代表赴中国西部科技创新港参观学习，西安交大附小校长雷玲，西安交大附小党支部副书记戴宇飞，及来自西安交大附小的党员们参加了本次活动。<br />\r\n<span lang=\"EN-US\">&nbsp;&nbsp;</span>在宣传部李老师的带领和解说下，党员们沿着西迁大道，先后走进数字展厅、涵英楼楼顶花园、影随轩、阅览中心、米兰学院、材料科研平台等标志性建筑和网红打卡地，宏大的格局、优美的环境、高端的设计无不展现着这座新型科研创新和人才培养基地的气势与风采。<br />\r\n<span lang=\"EN-US\">&nbsp;&nbsp;</span>首先工作人员向党员们详细介绍中国西部科技创新港以“国家使命担当、全球科教高地、服务陕西引擎、创新驱动平台、智慧学镇示范”为目标，在<span lang=\"EN-US\">4</span>个领域上建立了<span lang=\"EN-US\">8</span>大平台、<span lang=\"EN-US\">29</span>个研究院和<span lang=\"EN-US\">300</span>多个科研基地，服务于学校研究生培养。宏伟的战略蓝图激发出大家对大西安美好未来的无限憧憬。</span>\r\n</p>\r\n<p align=\"center\" class=\"MsoNormal\" style=\"padding:0px;margin:0cm 0cm 0pt 0.05pt;line-height:21px;color:#333333;font-family:宋体;font-size:14px;white-space:normal;text-align:center;\">\r\n	<span lang=\"EN-US\" style=\"line-height:24px;font-size:12pt;\"><img height=\"350\" src=\"http://www.xajdfx.com/UploadFiles/xxxw/2020/9/202009251613089507.png\" width=\"567\" style=\"padding:0px;margin:0px;max-width:600px;height:auto;\" /></span>\r\n</p>\r\n<p align=\"center\" class=\"MsoNormal\" style=\"padding:0px;margin:0cm 0cm 0pt;line-height:21px;color:#333333;font-family:宋体;font-size:14px;white-space:normal;text-align:center;\">\r\n	<span lang=\"EN-US\" style=\"line-height:24px;font-size:12pt;\"><img height=\"429\" src=\"http://www.xajdfx.com/UploadFiles/xxxw/2020/9/202009251613085752.png\" width=\"566\" style=\"padding:0px;margin:0px;max-width:600px;height:auto;\" /></span>\r\n</p>\r\n<p align=\"center\" class=\"MsoNormal\" style=\"padding:0px;margin:0cm 0cm 0pt;line-height:21px;color:#333333;font-family:宋体;font-size:14px;white-space:normal;text-align:center;\">\r\n	<span lang=\"EN-US\" style=\"line-height:24px;font-size:12pt;\"><img height=\"425\" src=\"http://www.xajdfx.com/UploadFiles/xxxw/2020/9/202009251613082130.png\" width=\"567\" style=\"padding:0px;margin:0px;max-width:600px;height:auto;\" /></span>\r\n</p>\r\n<p align=\"center\" class=\"MsoNormal\" style=\"padding:0px;margin:0cm 0cm 0pt;line-height:21px;color:#333333;font-family:宋体;font-size:14px;white-space:normal;text-align:center;\">\r\n	<span lang=\"EN-US\" style=\"line-height:24px;font-size:12pt;\"><img height=\"318\" src=\"http://www.xajdfx.com/UploadFiles/xxxw/2020/9/202009251613090554.jpg\" width=\"566\" style=\"padding:0px;margin:0px;max-width:600px;height:auto;\" /></span>\r\n</p>\r\n<p align=\"center\" class=\"MsoNormal\" style=\"padding:0px;margin:0cm 0cm 0pt;line-height:21px;color:#333333;font-family:宋体;font-size:14px;white-space:normal;text-align:center;\">\r\n	<span lang=\"EN-US\" style=\"line-height:24px;font-size:12pt;\"><img height=\"382\" src=\"http://www.xajdfx.com/UploadFiles/xxxw/2020/9/202009251613099743.jpg\" width=\"566\" style=\"padding:0px;margin:0px;max-width:600px;height:auto;\" /></span>\r\n</p>\r\n<p align=\"center\" class=\"MsoNormal\" style=\"padding:0px;margin:0cm 0cm 0pt;line-height:21px;color:#333333;font-family:宋体;font-size:14px;white-space:normal;text-align:center;\">\r\n	<span lang=\"EN-US\" style=\"line-height:24px;font-size:12pt;\"><img height=\"318\" src=\"http://www.xajdfx.com/UploadFiles/xxxw/2020/9/202009251613091130.jpg\" width=\"566\" style=\"padding:0px;margin:0px;max-width:600px;height:auto;\" /></span>\r\n</p>\r\n<p align=\"center\" class=\"MsoNormal\" style=\"padding:0px;margin:0cm 0cm 0pt;line-height:21px;color:#333333;font-family:宋体;font-size:14px;white-space:normal;text-align:center;\">\r\n	<span lang=\"EN-US\" style=\"line-height:24px;font-size:12pt;\"><img height=\"380\" src=\"http://www.xajdfx.com/UploadFiles/xxxw/2020/9/202009251613099471.jpg\" width=\"566\" style=\"padding:0px;margin:0px;max-width:600px;height:auto;\" /><img height=\"319\" src=\"http://www.xajdfx.com/UploadFiles/xxxw/2020/9/202009251613097769.jpg\" width=\"566\" style=\"padding:0px;margin:0px;max-width:600px;height:auto;\" /></span><br />\r\n<span lang=\"EN-US\" style=\"line-height:24px;font-size:12pt;\">&nbsp;&nbsp;</span><span style=\"line-height:24px;font-size:12pt;\">作为中国西部最大的智慧学镇，西安交通大学致力于将创新港打造成世界级科技中心和国家级科技成果研发转换平台。在<span lang=\"EN-US\">“</span>双一流<span lang=\"EN-US\">”</span>建设的伟大新征程中，西安交通大学坚持<span lang=\"EN-US\">“</span>扎根西部、服务国家、世界一流<span lang=\"EN-US\">”</span>办学定位，以<span lang=\"EN-US\">“</span>探索一流大学新形态、塑造立德树人新构架、构筑科教融合新高地、创新国际合作新模式、打造一流学科新格局<span lang=\"EN-US\">”</span>的<span lang=\"EN-US\">“</span>五新战略<span lang=\"EN-US\">”</span>，矢志在祖国西部大地上，率先建成中国特色世界一流大学，用实际行动给出了<span lang=\"EN-US\">“</span>双一流<span lang=\"EN-US\">”</span>建设的<span lang=\"EN-US\">“</span>交大方案<span lang=\"EN-US\">”</span>。</span>\r\n</p>\r\n<p align=\"center\" class=\"MsoNormal\" style=\"padding:0px;margin:0cm 0cm 0pt;line-height:21px;color:#333333;font-family:宋体;font-size:14px;white-space:normal;text-align:center;\">\r\n	<span lang=\"EN-US\" style=\"line-height:24px;font-size:12pt;\">&nbsp;</span>\r\n</p>\r\n<p align=\"center\" class=\"MsoNormal\" style=\"padding:0px;margin:0cm 0cm 0pt;line-height:21px;color:#333333;font-family:宋体;font-size:14px;white-space:normal;text-align:center;\">\r\n	<span lang=\"EN-US\" style=\"line-height:24px;font-size:12pt;\"><img height=\"344\" src=\"http://www.xajdfx.com/UploadFiles/xxxw/2020/9/202009251613098434.jpg\" width=\"567\" style=\"padding:0px;margin:0px;max-width:600px;height:auto;\" /><img height=\"307\" src=\"http://www.xajdfx.com/UploadFiles/xxxw/2020/9/202009251613091487.jpg\" width=\"567\" style=\"padding:0px;margin:0px;max-width:600px;height:auto;\" /><img height=\"316\" src=\"http://www.xajdfx.com/UploadFiles/xxxw/2020/9/202009251613099247.jpg\" width=\"567\" style=\"padding:0px;margin:0px;max-width:600px;height:auto;\" /></span>\r\n</p>\r\n<p align=\"center\" class=\"MsoNormal\" style=\"padding:0px;margin:0cm 0cm 0pt;line-height:21px;color:#333333;font-family:宋体;font-size:14px;white-space:normal;text-align:center;\">\r\n	<span lang=\"EN-US\" style=\"line-height:24px;font-size:12pt;\"><img height=\"318\" src=\"http://www.xajdfx.com/UploadFiles/xxxw/2020/9/202009251613095267.jpg\" width=\"566\" style=\"padding:0px;margin:0px;max-width:600px;height:auto;\" /></span>\r\n</p>\r\n<p align=\"center\" class=\"MsoNormal\" style=\"padding:0px;margin:0cm 0cm 0pt;line-height:21px;color:#333333;font-family:宋体;font-size:14px;white-space:normal;text-align:center;\">\r\n	<span lang=\"EN-US\" style=\"line-height:24px;font-size:12pt;\"><img height=\"318\" src=\"http://www.xajdfx.com/UploadFiles/xxxw/2020/9/202009251613096316.jpg\" width=\"566\" style=\"padding:0px;margin:0px;max-width:600px;height:auto;\" /></span>\r\n</p>\r\n<p align=\"center\" class=\"MsoNormal\" style=\"padding:0px;margin:0cm 0cm 0pt;line-height:21px;color:#333333;font-family:宋体;font-size:14px;white-space:normal;text-align:center;\">\r\n	<span lang=\"EN-US\" style=\"line-height:24px;font-size:12pt;\"><img height=\"297\" src=\"http://www.xajdfx.com/UploadFiles/xxxw/2020/9/202009251613092099.jpg\" width=\"567\" style=\"padding:0px;margin:0px;max-width:600px;height:auto;\" /><img height=\"336\" src=\"http://www.xajdfx.com/UploadFiles/xxxw/2020/9/202009251613094906.jpg\" width=\"566\" style=\"padding:0px;margin:0px;max-width:600px;height:auto;\" /><img height=\"349\" src=\"http://www.xajdfx.com/UploadFiles/xxxw/2020/9/202009251613097691.jpg\" width=\"567\" style=\"padding:0px;margin:0px;max-width:600px;height:auto;\" /></span>\r\n</p>\r\n<p align=\"center\" class=\"MsoNormal\" style=\"padding:0px;margin:0cm 0cm 0pt;line-height:21px;color:#333333;font-family:宋体;font-size:14px;white-space:normal;text-align:center;\">\r\n	<span lang=\"EN-US\" style=\"line-height:24px;font-size:12pt;\"><img height=\"318\" src=\"http://www.xajdfx.com/UploadFiles/xxxw/2020/9/202009251613093500.jpg\" width=\"566\" style=\"padding:0px;margin:0px;max-width:600px;height:auto;\" /></span>\r\n</p>\r\n<p align=\"center\" class=\"MsoNormal\" style=\"padding:0px;margin:0cm 0cm 0pt;line-height:21px;color:#333333;font-family:宋体;font-size:14px;white-space:normal;text-align:center;\">\r\n	<span lang=\"EN-US\" style=\"line-height:24px;font-size:12pt;\"><img height=\"319\" src=\"http://www.xajdfx.com/UploadFiles/xxxw/2020/9/202009251613092846.jpg\" width=\"566\" style=\"padding:0px;margin:0px;max-width:600px;height:auto;\" /><img height=\"319\" src=\"http://www.xajdfx.com/UploadFiles/xxxw/2020/9/202009251613093628.jpg\" width=\"566\" style=\"padding:0px;margin:0px;max-width:600px;height:auto;\" /><img height=\"375\" src=\"http://www.xajdfx.com/UploadFiles/xxxw/2020/9/202009251613099083.jpg\" width=\"567\" style=\"padding:0px;margin:0px;max-width:600px;height:auto;\" /><img height=\"378\" src=\"http://www.xajdfx.com/UploadFiles/xxxw/2020/9/202009251613092967.jpg\" width=\"567\" style=\"padding:0px;margin:0px;max-width:600px;height:auto;\" /><img height=\"425\" src=\"http://www.xajdfx.com/UploadFiles/xxxw/2020/9/202009251613092234.jpg\" width=\"567\" style=\"padding:0px;margin:0px;max-width:600px;height:auto;\" /></span><br />\r\n<span lang=\"EN-US\" style=\"line-height:24px;font-size:12pt;\">&nbsp;&nbsp;</span><span style=\"line-height:24px;font-size:12pt;\">在参观过程中，老师们被创新港呈现出的<span lang=\"EN-US\">“</span>交大力量<span lang=\"EN-US\">”</span>深深震撼与折服。西安交大附小校长雷玲对于瀑布流电子图书借阅系统，材料科研平台的材料研制等产生浓厚的兴趣，表示希望将优质资源引进西安交大附小，依托西安交通大学的创新理念，引领交大附小所有成员</span>\r\n</p>\r\n<p align=\"left\" class=\"MsoNormal\" style=\"padding:0px;margin:0cm 0cm 0pt;line-height:21px;color:#333333;font-family:宋体;font-size:14px;white-space:normal;\">\r\n	<span style=\"line-height:24px;font-size:12pt;\">校的蓬勃发展。</span>\r\n</p>\r\n<p align=\"center\" class=\"MsoNormal\" style=\"padding:0px;margin:0cm 0cm 0pt;line-height:21px;color:#333333;font-family:宋体;font-size:14px;white-space:normal;text-align:center;\">\r\n	<span lang=\"EN-US\" style=\"line-height:24px;font-size:12pt;\">&nbsp;</span>\r\n</p>\r\n<p align=\"center\" class=\"MsoNormal\" style=\"padding:0px;margin:0cm 0cm 0pt;line-height:21px;color:#333333;font-family:宋体;font-size:14px;white-space:normal;text-align:center;\">\r\n	<span lang=\"EN-US\" style=\"line-height:24px;font-size:12pt;\"><img height=\"319\" src=\"http://www.xajdfx.com/UploadFiles/xxxw/2020/9/202009251613092871.jpg\" width=\"566\" style=\"padding:0px;margin:0px;max-width:600px;height:auto;\" /><img height=\"358\" src=\"http://www.xajdfx.com/UploadFiles/xxxw/2020/9/202009251613095216.jpg\" width=\"567\" style=\"padding:0px;margin:0px;max-width:600px;height:auto;\" /></span>\r\n</p>\r\n<p align=\"center\" class=\"MsoNormal\" style=\"padding:0px;margin:0cm 0cm 0pt;line-height:21px;color:#333333;font-family:宋体;font-size:14px;white-space:normal;text-align:center;\">\r\n	<span lang=\"EN-US\" style=\"line-height:24px;font-size:12pt;\"><img height=\"319\" src=\"http://www.xajdfx.com/UploadFiles/xxxw/2020/9/202009251613090648.jpg\" width=\"566\" style=\"padding:0px;margin:0px;max-width:600px;height:auto;\" /><img height=\"319\" src=\"http://www.xajdfx.com/UploadFiles/xxxw/2020/9/202009251613092468.jpg\" width=\"566\" style=\"padding:0px;margin:0px;max-width:600px;height:auto;\" /><img height=\"319\" src=\"http://www.xajdfx.com/UploadFiles/xxxw/2020/9/202009251613096613.jpg\" width=\"566\" style=\"padding:0px;margin:0px;max-width:600px;height:auto;\" /></span><br />\r\n<span lang=\"EN-US\" style=\"line-height:24px;font-size:12pt;\">&nbsp;&nbsp;</span><span style=\"line-height:24px;font-size:12pt;\">创新港建设是学校发展的历史机遇，也是西迁精神的重要实践，通过这次参观学习，党员们反响强烈，大家对创新港的建设赞不绝口，表示进一步加深了自己对基础教育的初心和使命的理解，作为新时代的交大人，西迁精神的内涵和实质一直激励着大家前行，一定立足本职，潜心教学，努力工作，用实际行动践行西迁精神，努力为基础教育建设发展贡献力量。</span>\r\n</p>', null, '2020-09-26 21:52:45', '0', '202009251613089507.png', null, null, null, null, '23', null, '0', '0', '0', null, '2020-09-26 21:52:45', '2020-09-26 21:52:45', '0');
INSERT INTO `operate_article` VALUES ('2769', '1', '诵读美丽中国 抒发爱国情怀——三年级推普周活动报道', '', '未知', '孟婧暄', null, '<p align=\"center\" class=\"MsoNormal\" style=\"padding:0px;margin:0cm 0cm 0pt;line-height:27px;color:#333333;font-family:宋体;font-size:14px;white-space:normal;text-align:center;\">\r\n	&nbsp;\r\n</p>\r\n<p align=\"left\" class=\"MsoNormal\" style=\"padding:0px;margin:0cm 0cm 0pt;line-height:17.5px;color:#333333;font-family:宋体;font-size:14px;white-space:normal;text-indent:24pt;\">\r\n	<span style=\"line-height:20px;font-size:12pt;\">金秋九月，充满了清新与美丽，蕴含了朦胧与传奇，它是一支画笔，勾勒大江山河；它是半盏墨香，蕴育了五千年文明大国源远流长。普通话是我国法定的最标准的交际用语，我国把每年九月的第三个星期定为<span lang=\"EN-US\">“</span>推广普通话宣传周<span lang=\"EN-US\">”</span>。<span lang=\"EN-US\">2020</span>年<span lang=\"EN-US\">9</span>月<span lang=\"EN-US\">14</span>日至<span lang=\"EN-US\">18</span>日，是第<span lang=\"EN-US\">23</span>届全国推广普通话宣传周，今年的主题是“同讲普通话，携手进小康”。三年级师生开展了以“诵读中国”为主题的诗歌朗诵会。</span>\r\n</p>\r\n<p align=\"center\" class=\"MsoNormal\" style=\"padding:0px;margin:0cm 0cm 0pt 0.05pt;line-height:17.5px;color:#333333;font-family:宋体;font-size:14px;white-space:normal;text-align:center;\">\r\n	<span lang=\"EN-US\" style=\"line-height:20px;font-size:12pt;\"><img height=\"400\" src=\"http://www.xajdfx.com/UploadFiles/xxxw/2020/9/202009251039433180.jpg\" width=\"533\" style=\"padding:0px;margin:0px;max-width:600px;height:auto;\" /></span>\r\n</p>\r\n<p align=\"left\" class=\"MsoNormal\" style=\"padding:0px;margin:0cm 0cm 0pt;line-height:17.5px;color:#333333;font-family:宋体;font-size:14px;white-space:normal;text-indent:24pt;\">\r\n	<span style=\"line-height:20px;font-size:12pt;\">三年级各班学生在周末准备了自己最喜爱的爱国诗词，并利用两天假期练习朗诵，在周一的队会课上进行展示。周一下午，各班班主任老师先在队会课上强调了讲好普通话的重要性，紧接着各班学生齐诵了班主任准备的爱国诗歌《我们爱祖国》。</span>\r\n</p>\r\n<p align=\"center\" class=\"MsoNormal\" style=\"padding:0px;margin:0cm 0cm 0pt;line-height:17.5px;color:#333333;font-family:宋体;font-size:14px;white-space:normal;text-align:center;\">\r\n	<span lang=\"EN-US\" style=\"line-height:20px;font-size:12pt;\"><img height=\"400\" src=\"http://www.xajdfx.com/UploadFiles/xxxw/2020/9/202009251039438036.jpg\" width=\"533\" style=\"padding:0px;margin:0px;max-width:600px;height:auto;\" /></span>\r\n</p>\r\n<p align=\"left\" class=\"MsoNormal\" style=\"padding:0px;margin:0cm 0cm 0pt;line-height:17.5px;color:#333333;font-family:宋体;font-size:14px;white-space:normal;text-indent:24pt;\">\r\n	<span style=\"line-height:20px;font-size:12pt;\">学生们在朗诵时声情并茂、字正腔圆，“她是蓝天里飞翔的白鸽，她是国徽在阳光下闪烁，她是夜晚的万家灯火，她是熊熊燃烧的奥运圣火。”在孩子们深情地诵读下，课件上的文字变成了一幅幅动人的画卷，配上抒情的背景音乐，更激发了孩子们爱国之情。</span>\r\n</p>\r\n<p align=\"center\" class=\"MsoNormal\" style=\"padding:0px;margin:0cm 0cm 0pt;line-height:17.5px;color:#333333;font-family:宋体;font-size:14px;white-space:normal;text-align:center;\">\r\n	<span lang=\"EN-US\" style=\"line-height:20px;font-size:12pt;\"><img height=\"400\" src=\"http://www.xajdfx.com/UploadFiles/xxxw/2020/9/202009251039436510.jpg\" width=\"533\" style=\"padding:0px;margin:0px;max-width:600px;height:auto;\" /></span>\r\n</p>\r\n<p align=\"left\" class=\"MsoNormal\" style=\"padding:0px;margin:0cm 0cm 0pt;line-height:17.5px;color:#333333;font-family:宋体;font-size:14px;white-space:normal;text-indent:24pt;\">\r\n	<span style=\"line-height:20px;font-size:12pt;\">接下来，各班的学生诵读了各自准备的爱国诗词。从岳飞的“三十功名尘与土，八千里路云和月”，到陆游的“王师北定中原日，家祭无忘告乃翁”，再到文天祥的“人生自古谁无死，留取丹心照汗青”。读者心潮澎湃，听者热血沸腾，仿佛能看到诗人、词人那坚毅的脸庞和炽热的忠心。这些诗词世界里的呐喊，激励着后人永葆爱国之心。</span>\r\n</p>\r\n<p align=\"center\" class=\"MsoNormal\" style=\"padding:0px;margin:0cm 0cm 0pt;line-height:17.5px;color:#333333;font-family:宋体;font-size:14px;white-space:normal;text-align:center;\">\r\n	<span lang=\"EN-US\" style=\"line-height:20px;font-size:12pt;\"><img height=\"400\" src=\"http://www.xajdfx.com/UploadFiles/xxxw/2020/9/202009251039432093.jpg\" width=\"533\" style=\"padding:0px;margin:0px;max-width:600px;height:auto;\" /></span>\r\n</p>\r\n<p align=\"left\" class=\"MsoNormal\" style=\"padding:0px;margin:0cm 0cm 0pt;line-height:17.5px;color:#333333;font-family:宋体;font-size:14px;white-space:normal;text-indent:24pt;\">\r\n	<span style=\"line-height:20px;font-size:12pt;\">这次的活动让学生了解了普通话的重要性，更深深地托起了孩子们的爱国情怀，培育了学生们的民族精神。希望我们附小学子都能说好普通话，做好中国人。</span>\r\n</p>\r\n<p align=\"left\" class=\"MsoNormal\" style=\"padding:0px;margin:0cm 0cm 0pt;line-height:17.5px;color:#333333;font-family:宋体;font-size:14px;white-space:normal;text-indent:24pt;\">\r\n	<span lang=\"EN-US\" style=\"line-height:20px;font-size:12pt;\">&nbsp;</span>\r\n</p>\r\n<p align=\"right\" class=\"MsoNormal\" style=\"padding:0px;margin:0cm 0cm 0pt;line-height:27px;color:#333333;font-family:宋体;font-size:14px;white-space:normal;text-align:right;\">\r\n	<span style=\"font-size:12pt;\">文字：孟婧暄&nbsp;&nbsp;&nbsp;摄影：三年级各班班主任</span>\r\n</p>', null, '2020-09-26 21:53:16', '0', '202009251039433180.jpg', null, null, null, null, '6', null, '0', '0', '0', null, '2020-09-26 21:53:16', '2020-09-26 21:53:16', '0');
INSERT INTO `operate_article` VALUES ('2770', '1', '五年级语文教研组活动报道', '《计划》中指出，本学期，教研组建设要实现两个转变，一是教研组由事务型组织走向学习型组织，二是由应付性研究走向发展性研究，实现教学与研究的一体化。每个教研组以观课议课为操作平台开展课例研究，以研究促发展。每位老师在教学中要认真研读教材，精心设计作业，在“减负”的同时积极探索“增效”的新途径。随后，老师们对《计划》发表了自己的见解并讨论了实施的方法。', '五年级组', '王荣荣', null, '<p class=\"MsoNormal\" align=\"center\" style=\"padding:0px;margin-top:0px;margin-bottom:15px;line-height:21px;color:#333333;font-family:宋体;font-size:14px;white-space:normal;text-indent:21.75pt;\">\r\n	<span style=\"font-size:12pt;line-height:24px;\"><img src=\"http://www.xajdfx.com/UploadFile/201198133557953.jpg\" border=\"0\" style=\"padding:0px;margin:0px;max-width:600px;height:auto;\" /></span>\r\n</p>\r\n<p class=\"MsoNormal\" style=\"padding:0px;margin-top:0px;margin-bottom:15px;line-height:21px;color:#333333;font-family:宋体;font-size:14px;white-space:normal;text-indent:21.75pt;\">\r\n	绵绵的秋雨驱走了残留的炎热，却驱不走老师们高涨的工作热情。<span lang=\"EN-US\" style=\"font-size:12pt;line-height:24px;\"><o:p></o:p></span>\r\n</p>\r\n<p class=\"MsoNormal\" style=\"padding:0px;margin-top:0px;margin-bottom:15px;line-height:21px;color:#333333;font-family:宋体;font-size:14px;white-space:normal;text-indent:21.75pt;\">\r\n	<span style=\"font-size:12pt;line-height:24px;\">开学伊始，组长<st1:personname productid=\"曹瑞娜\" w:st=\"on\">曹瑞娜</st1:personname>老师趁召开年级组会议之际，组织<st1:personname productid=\"全组\" w:st=\"on\">全组</st1:personname>老师学习并讨论了本学期《学校教学工作计划》。</span><span lang=\"EN-US\" style=\"font-size:12pt;line-height:24px;\"><o:p></o:p></span>\r\n</p>\r\n<p class=\"MsoNormal\" style=\"padding:0px;margin-top:0px;margin-bottom:15px;line-height:21px;color:#333333;font-family:宋体;font-size:14px;white-space:normal;text-indent:21.75pt;\">\r\n	<span style=\"font-size:12pt;line-height:24px;\">《计划》中指出，本学期，教研组建设要实现两个转变，一是教研组由事务型组织走向学习型组织，二是由应付性研究走向发展性研究，实现教学与研究的一体化。每个教研组以观课议课为操作平台开展课例研究，以研究促发展。每位老师在教学中要认真研读教材，精心设计作业，在“减负”的同时积极探索“增效”的新途径。随后，老师们对《计划》发表了自己的见解并讨论了实施的方法。</span><span lang=\"EN-US\" style=\"font-size:12pt;line-height:24px;\"><o:p></o:p></span>\r\n</p>\r\n<p class=\"MsoNormal\" style=\"padding:0px;margin-top:0px;margin-bottom:15px;line-height:21px;color:#333333;font-family:宋体;font-size:14px;white-space:normal;text-indent:28.5pt;\">\r\n	<span style=\"font-size:12pt;line-height:24px;\">老师们将以学校的教学工作计划为引领，积极参加各种教学活动，促进自身专业发展，提高课堂教学质量。</span>\r\n</p>', null, '2020-09-26 22:17:44', '0', '', null, null, null, null, '6', null, '0', '0', '0', null, '2020-09-26 22:17:44', '2020-09-26 22:17:44', '0');

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
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 COMMENT='新闻栏目表';

-- ----------------------------
-- Records of operate_article_category
-- ----------------------------
INSERT INTO `operate_article_category` VALUES ('1', '学校新闻', null, null, '1', '0', null, '0', '0', '2020-09-26 11:00:31', '0');
INSERT INTO `operate_article_category` VALUES ('2', '通知公告', null, null, '3', '0', null, '0', '0', '2020-09-26 11:01:18', '0');
INSERT INTO `operate_article_category` VALUES ('3', '媒体报道', null, null, '3', '0', null, '0', '0', '2020-09-26 11:04:23', '0');
INSERT INTO `operate_article_category` VALUES ('4', '', null, null, '10000', '0', null, '0', '0', '2020-10-22 09:46:50', '0');
INSERT INTO `operate_article_category` VALUES ('5', '', null, null, '10000', '0', null, '0', '0', '2020-10-22 18:03:10', '0');

-- ----------------------------
-- Table structure for questionnaire
-- ----------------------------
DROP TABLE IF EXISTS `questionnaire`;
CREATE TABLE `questionnaire` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `remark` varchar(1000) DEFAULT NULL,
  `question_num` int(11) DEFAULT NULL COMMENT '问题',
  `create_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `start_time` datetime DEFAULT NULL,
  `end_time` datetime DEFAULT NULL,
  `delete_flag` int(1) DEFAULT '0',
  `score` int(3) DEFAULT NULL COMMENT '足够多少分发证书',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='调查卷';

-- ----------------------------
-- Records of questionnaire
-- ----------------------------
INSERT INTO `questionnaire` VALUES ('1', '附小支部2020年9月党纪法规知识测试题', null, null, '2020-10-23 16:37:05', '2020-10-23 16:37:05', '2020-10-12 16:45:35', '2020-11-06 16:45:38', '0', null);

-- ----------------------------
-- Table structure for questionnaire_question
-- ----------------------------
DROP TABLE IF EXISTS `questionnaire_question`;
CREATE TABLE `questionnaire_question` (
  `naire_id` int(11) NOT NULL,
  `question_id` int(11) NOT NULL,
  `score` int(2) DEFAULT NULL,
  `title` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`naire_id`,`question_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of questionnaire_question
-- ----------------------------
INSERT INTO `questionnaire_question` VALUES ('1', '1', '1', null);
INSERT INTO `questionnaire_question` VALUES ('1', '2', '1', null);
INSERT INTO `questionnaire_question` VALUES ('1', '3', '1', null);
INSERT INTO `questionnaire_question` VALUES ('1', '4', '1', null);
INSERT INTO `questionnaire_question` VALUES ('1', '5', '1', null);
INSERT INTO `questionnaire_question` VALUES ('1', '6', '1', null);
INSERT INTO `questionnaire_question` VALUES ('1', '7', '1', null);
INSERT INTO `questionnaire_question` VALUES ('1', '8', '1', null);
INSERT INTO `questionnaire_question` VALUES ('1', '9', '1', null);
INSERT INTO `questionnaire_question` VALUES ('1', '10', '1', null);
INSERT INTO `questionnaire_question` VALUES ('1', '11', '1', null);
INSERT INTO `questionnaire_question` VALUES ('1', '12', '1', null);
INSERT INTO `questionnaire_question` VALUES ('1', '13', '1', null);
INSERT INTO `questionnaire_question` VALUES ('1', '14', '1', null);
INSERT INTO `questionnaire_question` VALUES ('1', '15', '1', null);
INSERT INTO `questionnaire_question` VALUES ('1', '16', '1', null);
INSERT INTO `questionnaire_question` VALUES ('1', '17', '1', null);
INSERT INTO `questionnaire_question` VALUES ('1', '18', '1', null);
INSERT INTO `questionnaire_question` VALUES ('1', '19', '1', null);
INSERT INTO `questionnaire_question` VALUES ('1', '20', '1', null);
INSERT INTO `questionnaire_question` VALUES ('1', '21', '1', null);
INSERT INTO `questionnaire_question` VALUES ('1', '22', '1', null);
INSERT INTO `questionnaire_question` VALUES ('1', '23', '1', null);
INSERT INTO `questionnaire_question` VALUES ('1', '24', '1', null);
INSERT INTO `questionnaire_question` VALUES ('1', '25', '1', null);
INSERT INTO `questionnaire_question` VALUES ('1', '26', '1', null);
INSERT INTO `questionnaire_question` VALUES ('1', '27', '1', null);
INSERT INTO `questionnaire_question` VALUES ('1', '28', '1', null);
INSERT INTO `questionnaire_question` VALUES ('1', '29', '1', null);
INSERT INTO `questionnaire_question` VALUES ('1', '30', '1', null);
INSERT INTO `questionnaire_question` VALUES ('1', '31', '1', null);
INSERT INTO `questionnaire_question` VALUES ('1', '32', '1', null);
INSERT INTO `questionnaire_question` VALUES ('1', '33', '1', null);
INSERT INTO `questionnaire_question` VALUES ('1', '34', null, null);
INSERT INTO `questionnaire_question` VALUES ('1', '35', null, null);
INSERT INTO `questionnaire_question` VALUES ('1', '36', null, null);
INSERT INTO `questionnaire_question` VALUES ('1', '37', null, null);
INSERT INTO `questionnaire_question` VALUES ('1', '38', null, null);
INSERT INTO `questionnaire_question` VALUES ('1', '39', null, null);
INSERT INTO `questionnaire_question` VALUES ('1', '40', null, null);
INSERT INTO `questionnaire_question` VALUES ('1', '41', null, null);
INSERT INTO `questionnaire_question` VALUES ('1', '42', null, null);
INSERT INTO `questionnaire_question` VALUES ('1', '43', null, null);
INSERT INTO `questionnaire_question` VALUES ('1', '44', null, null);
INSERT INTO `questionnaire_question` VALUES ('1', '45', null, null);
INSERT INTO `questionnaire_question` VALUES ('1', '46', null, null);
INSERT INTO `questionnaire_question` VALUES ('1', '47', null, null);
INSERT INTO `questionnaire_question` VALUES ('1', '48', null, null);
INSERT INTO `questionnaire_question` VALUES ('1', '49', null, null);
INSERT INTO `questionnaire_question` VALUES ('1', '50', null, null);
INSERT INTO `questionnaire_question` VALUES ('1', '51', null, null);
INSERT INTO `questionnaire_question` VALUES ('1', '52', null, null);
INSERT INTO `questionnaire_question` VALUES ('1', '53', null, null);
INSERT INTO `questionnaire_question` VALUES ('1', '54', null, null);
INSERT INTO `questionnaire_question` VALUES ('1', '55', null, null);
INSERT INTO `questionnaire_question` VALUES ('1', '56', null, null);
INSERT INTO `questionnaire_question` VALUES ('1', '57', null, null);
INSERT INTO `questionnaire_question` VALUES ('1', '58', null, null);
INSERT INTO `questionnaire_question` VALUES ('1', '59', null, null);
INSERT INTO `questionnaire_question` VALUES ('1', '60', null, null);
INSERT INTO `questionnaire_question` VALUES ('1', '61', null, null);
INSERT INTO `questionnaire_question` VALUES ('1', '62', null, null);
INSERT INTO `questionnaire_question` VALUES ('1', '63', null, null);
INSERT INTO `questionnaire_question` VALUES ('1', '64', null, null);
INSERT INTO `questionnaire_question` VALUES ('1', '65', null, null);
INSERT INTO `questionnaire_question` VALUES ('1', '66', null, null);
INSERT INTO `questionnaire_question` VALUES ('1', '67', null, null);
INSERT INTO `questionnaire_question` VALUES ('1', '68', null, null);
INSERT INTO `questionnaire_question` VALUES ('1', '69', null, null);
INSERT INTO `questionnaire_question` VALUES ('1', '70', null, null);
INSERT INTO `questionnaire_question` VALUES ('1', '71', null, null);
INSERT INTO `questionnaire_question` VALUES ('1', '72', null, null);
INSERT INTO `questionnaire_question` VALUES ('1', '73', null, null);
INSERT INTO `questionnaire_question` VALUES ('1', '74', null, null);
INSERT INTO `questionnaire_question` VALUES ('1', '75', null, null);
INSERT INTO `questionnaire_question` VALUES ('1', '76', null, null);
INSERT INTO `questionnaire_question` VALUES ('1', '77', null, null);
INSERT INTO `questionnaire_question` VALUES ('1', '78', null, null);
INSERT INTO `questionnaire_question` VALUES ('1', '79', null, null);
INSERT INTO `questionnaire_question` VALUES ('1', '80', null, null);
INSERT INTO `questionnaire_question` VALUES ('1', '81', null, null);
INSERT INTO `questionnaire_question` VALUES ('1', '82', null, null);
INSERT INTO `questionnaire_question` VALUES ('1', '83', null, null);
INSERT INTO `questionnaire_question` VALUES ('1', '84', null, null);
INSERT INTO `questionnaire_question` VALUES ('1', '85', null, null);
INSERT INTO `questionnaire_question` VALUES ('1', '86', null, null);
INSERT INTO `questionnaire_question` VALUES ('1', '87', null, null);
INSERT INTO `questionnaire_question` VALUES ('1', '88', null, null);
INSERT INTO `questionnaire_question` VALUES ('1', '89', null, null);
INSERT INTO `questionnaire_question` VALUES ('1', '90', null, null);
INSERT INTO `questionnaire_question` VALUES ('1', '91', null, null);
INSERT INTO `questionnaire_question` VALUES ('1', '92', null, null);
INSERT INTO `questionnaire_question` VALUES ('1', '93', null, null);
INSERT INTO `questionnaire_question` VALUES ('1', '94', null, null);

-- ----------------------------
-- Table structure for question_bank
-- ----------------------------
DROP TABLE IF EXISTS `question_bank`;
CREATE TABLE `question_bank` (
  `bank_id` int(11) NOT NULL AUTO_INCREMENT,
  `bank_name` varchar(255) DEFAULT NULL,
  `bank_remark` varchar(1000) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `delete_flag` int(1) DEFAULT NULL,
  PRIMARY KEY (`bank_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of question_bank
-- ----------------------------

-- ----------------------------
-- Table structure for question_chapter
-- ----------------------------
DROP TABLE IF EXISTS `question_chapter`;
CREATE TABLE `question_chapter` (
  `chapter_id` int(11) NOT NULL AUTO_INCREMENT,
  `chapter_name` varchar(255) DEFAULT NULL,
  `chapter_remark` varchar(1000) DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `delete_flag` int(1) unsigned zerofill DEFAULT '0',
  `bank_id` int(11) DEFAULT NULL COMMENT '题库id',
  PRIMARY KEY (`chapter_id`)
) ENGINE=InnoDB AUTO_INCREMENT=63 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of question_chapter
-- ----------------------------
INSERT INTO `question_chapter` VALUES ('1', '中国共产党党章知识', null, '2020-10-22 16:43:07', '0', null);
INSERT INTO `question_chapter` VALUES ('2', '《中国共产党纪律处分条例》知识', null, '2020-10-23 16:37:12', '0', null);
INSERT INTO `question_chapter` VALUES ('3', '《中国共产党纪律处分条例》知识', null, '2020-10-23 16:37:12', '0', null);
INSERT INTO `question_chapter` VALUES ('4', '《中国共产党纪律处分条例》知识', null, '2020-10-23 16:37:12', '0', null);
INSERT INTO `question_chapter` VALUES ('5', '《中国共产党纪律处分条例》知识', null, '2020-10-23 16:37:12', '0', null);
INSERT INTO `question_chapter` VALUES ('6', '《中国共产党纪律处分条例》知识', null, '2020-10-23 16:37:12', '0', null);
INSERT INTO `question_chapter` VALUES ('7', '《中国共产党纪律处分条例》知识', null, '2020-10-23 16:37:12', '0', null);
INSERT INTO `question_chapter` VALUES ('8', '《中国共产党纪律处分条例》知识', null, '2020-10-23 16:37:12', '0', null);
INSERT INTO `question_chapter` VALUES ('9', '《中国共产党纪律处分条例》知识', null, '2020-10-23 16:37:12', '0', null);
INSERT INTO `question_chapter` VALUES ('10', '《中国共产党纪律处分条例》知识', null, '2020-10-23 16:37:12', '0', null);
INSERT INTO `question_chapter` VALUES ('11', '《中国共产党纪律处分条例》知识', null, '2020-10-23 16:37:12', '0', null);
INSERT INTO `question_chapter` VALUES ('12', '《中国共产党纪律处分条例》知识', null, '2020-10-23 16:37:12', '0', null);
INSERT INTO `question_chapter` VALUES ('13', '《中华人民共和国监察法》知识', null, '2020-10-23 16:37:15', '0', null);
INSERT INTO `question_chapter` VALUES ('14', '《中华人民共和国监察法》知识', null, '2020-10-23 16:37:15', '0', null);
INSERT INTO `question_chapter` VALUES ('15', '《中华人民共和国监察法》知识', null, '2020-10-23 16:37:15', '0', null);
INSERT INTO `question_chapter` VALUES ('16', '《中华人民共和国监察法》知识', null, '2020-10-23 16:37:15', '0', null);
INSERT INTO `question_chapter` VALUES ('17', '《中华人民共和国监察法》知识', null, '2020-10-23 16:37:15', '0', null);
INSERT INTO `question_chapter` VALUES ('18', '《中华人民共和国监察法》知识', null, '2020-10-23 16:37:15', '0', null);
INSERT INTO `question_chapter` VALUES ('19', '《中华人民共和国监察法》知识', null, '2020-10-23 16:37:15', '0', null);
INSERT INTO `question_chapter` VALUES ('20', '《中华人民共和国监察法》知识', null, '2020-10-23 16:37:15', '0', null);
INSERT INTO `question_chapter` VALUES ('21', '《中华人民共和国监察法》知识', null, '2020-10-23 16:37:15', '0', null);
INSERT INTO `question_chapter` VALUES ('22', '《中华人民共和国监察法》知识', null, '2020-10-23 16:37:15', '0', null);
INSERT INTO `question_chapter` VALUES ('23', '《中华人民共和国监察法》知识', null, '2020-10-23 16:37:15', '0', null);
INSERT INTO `question_chapter` VALUES ('24', '《中华人民共和国监察法》知识', null, '2020-10-23 16:37:15', '0', null);
INSERT INTO `question_chapter` VALUES ('25', '《中华人民共和国监察法》知识', null, '2020-10-23 16:37:15', '0', null);
INSERT INTO `question_chapter` VALUES ('26', '《中华人民共和国监察法》知识', null, '2020-10-23 16:37:15', '0', null);
INSERT INTO `question_chapter` VALUES ('27', '《中华人民共和国监察法》知识', null, '2020-10-23 16:37:15', '0', null);
INSERT INTO `question_chapter` VALUES ('28', '《中华人民共和国监察法》知识', null, '2020-10-23 16:37:15', '0', null);
INSERT INTO `question_chapter` VALUES ('29', '《中华人民共和国监察法》知识', null, '2020-10-23 16:37:15', '0', null);
INSERT INTO `question_chapter` VALUES ('30', '《中华人民共和国监察法》知识', null, '2020-10-23 16:37:15', '0', null);
INSERT INTO `question_chapter` VALUES ('31', '《中华人民共和国监察法》知识', null, '2020-10-23 16:37:15', '0', null);
INSERT INTO `question_chapter` VALUES ('32', '《中华人民共和国监察法》知识', null, '2020-10-23 16:37:15', '0', null);
INSERT INTO `question_chapter` VALUES ('33', '《中华人民共和国监察法》知识', null, '2020-10-23 16:37:15', '0', null);
INSERT INTO `question_chapter` VALUES ('34', '《中华人民共和国监察法》知识', null, '2020-10-23 16:37:15', '0', null);
INSERT INTO `question_chapter` VALUES ('35', '《中华人民共和国监察法》知识', null, '2020-10-23 16:37:15', '0', null);
INSERT INTO `question_chapter` VALUES ('36', '《中华人民共和国监察法》知识', null, '2020-10-23 16:37:15', '0', null);
INSERT INTO `question_chapter` VALUES ('37', '《中华人民共和国监察法》知识', null, '2020-10-23 16:37:15', '0', null);
INSERT INTO `question_chapter` VALUES ('38', '《中华人民共和国监察法》知识', null, '2020-10-23 16:37:15', '0', null);
INSERT INTO `question_chapter` VALUES ('39', '《中华人民共和国监察法》知识', null, '2020-10-23 16:37:15', '0', null);
INSERT INTO `question_chapter` VALUES ('40', '《中华人民共和国监察法》知识', null, '2020-10-23 16:37:15', '0', null);
INSERT INTO `question_chapter` VALUES ('41', '《中华人民共和国监察法》知识', null, '2020-10-23 16:37:15', '0', null);
INSERT INTO `question_chapter` VALUES ('42', '《中华人民共和国监察法》知识', null, '2020-10-23 16:37:15', '0', null);
INSERT INTO `question_chapter` VALUES ('43', '《中华人民共和国监察法》知识', null, '2020-10-23 16:37:15', '0', null);
INSERT INTO `question_chapter` VALUES ('44', '《中华人民共和国监察法》知识', null, '2020-10-23 16:37:15', '0', null);
INSERT INTO `question_chapter` VALUES ('45', '《中华人民共和国监察法》知识', null, '2020-10-23 16:37:15', '0', null);
INSERT INTO `question_chapter` VALUES ('46', '《中华人民共和国监察法》知识', null, '2020-10-23 16:37:15', '0', null);
INSERT INTO `question_chapter` VALUES ('47', '《中华人民共和国监察法》知识', null, '2020-10-23 16:37:15', '0', null);
INSERT INTO `question_chapter` VALUES ('48', '《中华人民共和国监察法》知识', null, '2020-10-23 16:37:15', '0', null);
INSERT INTO `question_chapter` VALUES ('49', '《中华人民共和国监察法》知识', null, '2020-10-23 16:37:15', '0', null);
INSERT INTO `question_chapter` VALUES ('50', '《中华人民共和国监察法》知识', null, '2020-10-23 16:37:15', '0', null);
INSERT INTO `question_chapter` VALUES ('51', '《中华人民共和国监察法》知识', null, '2020-10-23 16:37:15', '0', null);
INSERT INTO `question_chapter` VALUES ('52', '《中华人民共和国监察法》知识', null, '2020-10-23 16:37:15', '0', null);
INSERT INTO `question_chapter` VALUES ('53', '《中华人民共和国监察法》知识', null, '2020-10-23 16:37:15', '0', null);
INSERT INTO `question_chapter` VALUES ('54', '《中华人民共和国监察法》知识', null, '2020-10-23 16:37:15', '0', null);
INSERT INTO `question_chapter` VALUES ('55', '《中华人民共和国监察法》知识', null, '2020-10-23 16:37:15', '0', null);
INSERT INTO `question_chapter` VALUES ('56', '《中华人民共和国监察法》知识', null, '2020-10-23 16:37:15', '0', null);
INSERT INTO `question_chapter` VALUES ('57', '《中华人民共和国监察法》知识', null, '2020-10-23 16:37:15', '0', null);
INSERT INTO `question_chapter` VALUES ('58', '《中华人民共和国监察法》知识', null, '2020-10-23 16:37:15', '0', null);
INSERT INTO `question_chapter` VALUES ('59', '《中华人民共和国监察法》知识', null, '2020-10-23 16:37:15', '0', null);
INSERT INTO `question_chapter` VALUES ('60', '《中华人民共和国监察法》知识', null, '2020-10-23 16:37:15', '0', null);
INSERT INTO `question_chapter` VALUES ('61', '《中华人民共和国监察法》知识', null, '2020-10-23 16:37:15', '0', null);
INSERT INTO `question_chapter` VALUES ('62', '《中华人民共和国监察法》知识', null, '2020-10-23 16:37:15', '0', null);

-- ----------------------------
-- Table structure for question_info
-- ----------------------------
DROP TABLE IF EXISTS `question_info`;
CREATE TABLE `question_info` (
  `question_id` int(11) NOT NULL AUTO_INCREMENT,
  `question_type` int(1) DEFAULT NULL,
  `question` varchar(255) DEFAULT NULL,
  `option_num` int(1) DEFAULT NULL,
  `option_a` varchar(255) DEFAULT NULL,
  `option_b` varchar(255) DEFAULT NULL,
  `option_c` varchar(255) DEFAULT NULL,
  `option_d` varchar(255) DEFAULT NULL,
  `option_e` varchar(255) DEFAULT NULL,
  `article_1` text,
  `article_2` text,
  `article_3` text,
  `answer` varchar(255) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `delete_flag` int(1) DEFAULT NULL,
  `chapter_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`question_id`)
) ENGINE=InnoDB AUTO_INCREMENT=95 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of question_info
-- ----------------------------
INSERT INTO `question_info` VALUES ('1', '0', '《党章》规定，中国共产党的宗旨是__。', '4', 'A.实现社会主义现代化', 'B.全心全意为人民服务', 'C.坚持党的基本路线和基本纲领不动摇', 'D.坚持群众路线', null, null, null, null, '2', '2020-10-23 16:37:26', '2020-10-23 16:37:26', '0', '1');
INSERT INTO `question_info` VALUES ('2', '0', '《党章》规定，党的中央委员会每届任期__年。', '4', 'A.三', 'B.四', 'C.五', 'D.六', null, null, null, null, '3', '2020-10-23 16:37:26', '2020-10-23 16:37:26', '0', '1');
INSERT INTO `question_info` VALUES ('3', '0', '《党章》规定,党员如果没有正当理由，连续_ _不参加党的组织生活，或不交纳党费，或不做党所分配的工作，就被认为是自行脱党。', '4', 'A.3个月', 'B.6个月', 'C.12个月', 'D.24个月', null, null, null, null, '2', '2020-10-23 16:37:26', '2020-10-23 16:37:26', '0', '1');
INSERT INTO `question_info` VALUES ('4', '0', '《党章》规定，党员个人服从党的组织，少数服从多数，下级组织服从上级组织，全党各个组织和全体党员服从党的全国代表大会和__。', '4', 'A.中央政治局', 'B.人民代表大会', 'C.党代会', 'D.中央委员会', null, null, null, null, '4', '2020-10-23 16:37:26', '2020-10-23 16:37:26', '0', '1');
INSERT INTO `question_info` VALUES ('5', '0', '《党章》规定，党组织对违犯党的纪律的党员，应当本着__的精神，按照错误性质和情节轻重，给以批评教育直至纪律处分。', '4', 'A.从严治党', 'B.批评与自我批评', 'C.惩前毖后，治病救人', 'D.严肃纪律', null, null, null, null, '3', '2020-10-23 16:37:26', '2020-10-23 16:37:26', '0', '1');
INSERT INTO `question_info` VALUES ('6', '0', '《党章》第二十九条规定，企业、农村、机关、学校、科研院所、街道社区、社会组织、人民解放军连队和其他基层单位,凡是有_ _以上的，都应当成立党基层组织。', '4', 'A.预备和正式党员三人', 'B.正式党员三人', 'C.预备或正式党员三人', 'D.预备党员三人', null, null, null, null, '2', '2020-10-23 16:37:26', '2020-10-23 16:37:26', '0', '1');
INSERT INTO `question_info` VALUES ('7', '0', '中共江西省委《关于加强作风建设营造良好从政环境的意见》规定，任何个人不得违反组织程序、议事决策规则直接决定应由__讨论决定的事项，不得超越权限办事，不得以推进工作为名授意、指使、强令有关部门和人员违规违法办事。', '3', 'A.上级机关', 'B.党委(党组)或集体', 'C.集体', '', null, null, null, null, '2', '2020-10-23 16:37:26', '2020-10-23 16:37:26', '0', '1');
INSERT INTO `question_info` VALUES ('8', '0', '中共江西省委《关于加强作风建设营造良好从政环境的意见》规定，党委(党组)书记要切实履行选人用人__的责任，带头遵守组织人事制度，该坚持的标准决不降低，该有的步骤、环节决不能少，该按规矩办的决不能搞例外。', '4', 'A.主要领导人', 'B.第一责任人', 'C.重要领导人', 'D.以上都不是', null, null, null, null, '2', '2020-10-23 16:37:26', '2020-10-23 16:37:26', '0', '1');
INSERT INTO `question_info` VALUES ('9', '0', '中共江西省委《关于加强作风建设营造良好从政环境的意见》规定，坚持有腐必反、有贪必肃。始终保持惩治腐败高压态势，用最坚决的态度减少腐败存量，用最果断的措施遏制腐败__。', '4', 'A.增量', 'B.数量', 'C.总量', 'D.总数', null, null, null, null, '1', '2020-10-23 16:37:26', '2020-10-23 16:37:26', '0', '1');
INSERT INTO `question_info` VALUES ('10', '0', '中共江西省委《关于加强作风建设营造良好从政环境的意见》规定，带头尊法、学法、守法、用法，提高运用__和_ _推动工作的能力。', '4', 'A.法治思维 法治方式', 'B.法律思维 法律方式', 'C.法制思维 法制方式', 'D.纪律思维 纪律方式', null, null, null, null, '1', '2020-10-23 16:37:26', '2020-10-23 16:37:26', '0', '1');
INSERT INTO `question_info` VALUES ('11', '0', '中共江西省委《关于加强作风建设营造良好从政环境的意见》规定，不得允许、纵容配偶、子女及其配偶、特定关系人在本人__个人从事可能与公共利益发生冲突的经商、办企业、社会中介服务等活动，坚决杜绝各类违反廉洁从政规定的行为发生。', '4', 'A.任职范围内', 'B.管辖的地区', 'C.业务范围内', 'D.管辖的地区和业务范围内', null, null, null, null, '4', '2020-10-23 16:37:26', '2020-10-23 16:37:26', '0', '1');
INSERT INTO `question_info` VALUES ('12', '0', '中共江西省委《关于加强作风建设营造良好从政环境的意见》规定，坚持__事项集体研究决定，不得以议事协调机构或其他形式的组织代替党委常委会(党组会)或政府常务会(部门行政会)等进行决策。', '4', 'A.人事任免', 'B.三重一大', 'C.重要决策', 'D.以上都不是', null, null, null, null, '2', '2020-10-23 16:37:26', '2020-10-23 16:37:26', '0', '1');
INSERT INTO `question_info` VALUES ('13', '0', '《习近平关于严明党的纪律和规矩论述摘编》指出，我们党是靠革命理想和铁的纪律组织起来的马克思主义政党，组织严密、__是党的光荣传统和政治优势。', '4', 'A.纪律严明', 'B.遵纪守法', 'C.作风严谨', 'D.民主集中', null, null, null, null, '1', '2020-10-23 16:37:26', '2020-10-23 16:37:26', '0', '1');
INSERT INTO `question_info` VALUES ('14', '0', '《习近平关于严明党的纪律和规矩论述摘编》指出，维护中央权威，贯彻落实党的理论和路线方针政策，是__。', '4', 'A.政治纪律', 'B.工作纪律', 'C.群众纪律', 'D.以上都是', null, null, null, null, '1', '2020-10-23 16:37:26', '2020-10-23 16:37:26', '0', '1');
INSERT INTO `question_info` VALUES ('15', '0', '《习近平关于严明党的纪律和规矩论述摘编》指出，严肃党内生活，最根本的是认真执行党的__，着力解决发扬民主不够，正确集中不够、开展批评不够、严肃纪律不够等问题。', '4', 'A.民主集中制', 'B.少数服从多数', 'C.批评与自我批评', 'D.下级服从上级', null, null, null, null, '1', '2020-10-23 16:37:26', '2020-10-23 16:37:26', '0', '1');
INSERT INTO `question_info` VALUES ('16', '0', '《习近平关于严明党的纪律和规矩论述摘编》提出，党纪就是红线，处分就是__。', '4', 'A.惩戒', 'B.处罚', 'C.提醒', 'D.防线', null, null, null, null, '1', '2020-10-23 16:37:26', '2020-10-23 16:37:26', '0', '1');
INSERT INTO `question_info` VALUES ('17', '0', '《习近平关于严明党的纪律和规矩论述摘编》指出，各级领导干部要带头依法办事，带头遵守法律，始终对宪法和法律保持敬畏之心，牢固确立__不能触碰，法律底线不能逾越的观念，不要去行使依法不该由自己行使的权利，更不能以言代法、以权压法、徇私枉法。', '4', 'A.纪律高线', 'B.规矩高线', 'C.规矩规定', 'D法律红线', null, null, null, null, '4', '2020-10-23 16:37:26', '2020-10-23 16:37:26', '0', '1');
INSERT INTO `question_info` VALUES ('18', '0', '《中国共产党廉洁自律准则》，第五条廉洁从政，__，', '4', 'A.自觉保持人民公仆本色', 'B.自觉维护人民根本利益', 'C.自觉提升思想道德境界', 'D.自觉带头树立良好家风', null, null, null, null, '1', '2020-10-23 16:37:26', '2020-10-23 16:37:26', '0', '1');
INSERT INTO `question_info` VALUES ('19', '0', '《中国共产党廉洁自律准则》第七条廉洁修身，__。', '4', 'A.自觉保持人民公仆本色', 'B.自觉维护人民根本利益', 'C.自觉提升思想道德境界', 'D.自觉带头树立良好家风', null, null, null, null, '3', '2020-10-23 16:37:26', '2020-10-23 16:37:26', '0', '1');
INSERT INTO `question_info` VALUES ('20', '0', '2015年10月18日，中共中央印发了《中国共产党纪律处分条例》，并发出通知要求，各级纪委(纪检组)要认真履行监督执纪_ _职责，加大查处违反《条例》行为的力度，进一步探索建立不敢腐、不能腐、不想腐的有效机制。', '4', 'A.追责', 'B.处分', 'C.审查', 'D.问责', null, null, null, null, '4', '2020-10-23 16:37:26', '2020-10-23 16:37:26', '0', '1');
INSERT INTO `question_info` VALUES ('21', '0', '2015年10月18日，中共中央印发了《中国共产党纪律处分条例》，并发出通知要求，广大党员要牢固_ _党章党规党纪意识，严格遵守国家法律法规，守住纪律“底线”，自觉做守纪律、讲规矩的模范。', '4', 'A.坚持', 'B.树立', 'C.做到', 'D.促进', null, null, null, null, '2', '2020-10-23 16:37:26', '2020-10-23 16:37:26', '0', '1');
INSERT INTO `question_info` VALUES ('22', '0', '遇到国家财产和群众生命财产受到_ _时，能救而不救，情节较重的，给予警告、严重警告或者撤销党内职务处分;情节严重的，给予留党察看或者开除党籍处分。', '4', 'A.危害', 'B.严重威胁', 'C.危险', 'D.损失', null, null, null, null, '2', '2020-10-23 16:37:26', '2020-10-23 16:37:26', '0', '1');
INSERT INTO `question_info` VALUES ('23', '0', '违背社会_ _，在公共场所有不当行为，造成不良影响的，给予警告或者严重警告处分;情节较重的，给予撤销党内职务或者留党察看处分;情节严重的，给予开除党籍处分。', '4', 'A.诚实信用', 'B.职业道德', 'C.公序良俗', 'D.家庭美德', null, null, null, null, '3', '2020-10-23 16:37:26', '2020-10-23 16:37:26', '0', '1');
INSERT INTO `question_info` VALUES ('24', '0', '实事求是。对党组织和党员违犯党纪的行为，应当以_ _为依据，以党章、其他党内法规和国家法律法规为准绳，准确认定违纪性质，区别不同情况，恰当予以处理。', '4', 'A.证据', 'B.纪律', 'C.事实', 'D.交代', null, null, null, null, '3', '2020-10-23 16:37:26', '2020-10-23 16:37:26', '0', '1');
INSERT INTO `question_info` VALUES ('25', '0', '党组织和党员违反党章和其他党内法规，违反国家法律法规，违反党和国家政策，违反_ _道德，危害党、国家和人民利益的行为，依照规定应当给予纪律处理或者处分的，都必须受到追究。', '4', 'A.国家', 'B.家庭', 'C.职业', 'D.社会主义', null, null, null, null, '4', '2020-10-23 16:37:26', '2020-10-23 16:37:26', '0', '1');
INSERT INTO `question_info` VALUES ('26', '0', '党员受到严重警告处分_ _内，不得在党内提升职务和向党外组织推荐担任高于其原任职务的党外职务。', '4', 'A.一年', 'B.一年半', 'C.二年', 'D.三年', null, null, null, null, '2', '2020-10-23 16:37:26', '2020-10-23 16:37:26', '0', '1');
INSERT INTO `question_info` VALUES ('27', '0', '党员受到留党察看处分，其党内职务_ _撤销。', '4', 'A.应当', 'B.必须', 'C.自然', 'D.可以', null, null, null, null, '3', '2020-10-23 16:37:26', '2020-10-23 16:37:26', '0', '1');
INSERT INTO `question_info` VALUES ('28', '0', '受到改组处理的党组织领导机构成员，除应当受到撤销党内职务以上(含撤销党内职务)处分的外，均_ _免职。', '4', 'A.应当', 'B.必须', 'C.自然', 'D.可以', null, null, null, null, '3', '2020-10-23 16:37:26', '2020-10-23 16:37:26', '0', '1');
INSERT INTO `question_info` VALUES ('29', '0', '党组织在纪律审查中发现党员有_ _，虽不涉及犯罪但须追究党纪责任的，应当视具体情节给予警告直至开除党籍处分。', '4', 'A.法律规定的行为', 'B.其他违法行为', 'C.刑法规定的行为', 'D.刑法规定的行为涉嫌犯罪的', null, null, null, null, '3', '2020-10-23 16:37:26', '2020-10-23 16:37:26', '0', '1');
INSERT INTO `question_info` VALUES ('30', '0', '党组织作出党纪处分或者组织处理决定后，司法机关、行政机关等依法改变原生效判决、裁定、决定等，对原党纪处分或者组织处理决定产生影响的，党组织应当根据改变后的生效判决、裁定、决定等_ _作出相应处理。', '4', 'A.另行', 'B.重新', 'C.不再', 'D.需要', null, null, null, null, '2', '2020-10-23 16:37:26', '2020-10-23 16:37:26', '0', '1');
INSERT INTO `question_info` VALUES ('31', '0', '通过信息网络、广播、电视、报刊、书籍、讲座、论坛、报告会、座谈会等方式，公开发表坚持资产阶级自由化立场、反对四项基本原则、反对党的改革开放决策的文章、演说、宣言、声明等的，给予__处分。', '4', 'A.警告', 'B.严重警告', 'C.留党察看', 'D.开除党籍', null, null, null, null, '4', '2020-10-23 16:37:26', '2020-10-23 16:37:26', '0', '1');
INSERT INTO `question_info` VALUES ('32', '0', '组织、参加反对党的基本理论、基本路线、基本纲领、基本经验、基本要求或者重大方针政策的集会、游行、示威等活动的，或者以组织讲座、论坛、报告会、座谈会等方式，反对党的基本理论、基本路线、基本纲领、基本经验、基本要求或者重大方针政策，造成_ _的，对策划者、组织者和骨干分子，给予开除党籍处分。', '4', 'A.不好影响', 'B.很坏影响', 'C.严重不良影响', 'D.一定影响', null, null, null, null, '3', '2020-10-23 16:37:26', '2020-10-23 16:37:26', '0', '1');
INSERT INTO `question_info` VALUES ('33', '0', '在干部选拔任用工作中，违反干部选拔任用规定，对直接责任者和领导责任者，情节较轻的，给予警告或者_ _处分;情节较重的，给予撤销党内职务或者留党察看处分;情节严重的，给予开除党籍处分。', '4', 'A.警告', 'B.严重警告', 'C.撤销党内职务', 'D.留党察看', null, null, null, null, '2', '2020-10-23 16:37:26', '2020-10-23 16:37:26', '0', '1');
INSERT INTO `question_info` VALUES ('34', '0', '1.党员受到警告处分的，(  )内不得在党内提升职务。', '4', 'A、1年', 'B、2年', 'C、3年', 'D、4年', null, null, null, null, '1', '2020-10-23 16:37:29', '2020-10-23 16:37:29', '0', null);
INSERT INTO `question_info` VALUES ('35', '0', '2.受到留党察看处分的党员，在恢复党员权利后(  )内,不得在党内担任和向党外组织推荐担任与其原任职务相当或者高于其原任职务的职务。', '4', 'A.六个月', 'B.一年', 'C.两年', 'D.三年', null, null, null, null, '1', '2020-10-23 16:37:29', '2020-10-23 16:37:29', '0', null);
INSERT INTO `question_info` VALUES ('36', '0', '3.在干部选拔任用工作中，有任人唯亲、排斥异己、封官许愿、说情干预、跑官要官、突击提拔或者调整干部等违反干部选拔任用规定行为，情节严重的，给予(  )处分。', '4', 'A.严重警告', 'B.撤销党内职务', 'C.留党察看', 'D.开除党籍', null, null, null, null, '1', '2020-10-23 16:37:29', '2020-10-23 16:37:29', '0', null);
INSERT INTO `question_info` VALUES ('37', '0', '4.利用职务.上的便利,占用公物归个人使用，时间超过(  )，情节较重的,给予警告或者严重警告处分;情节严重的，给予撤销党内职务处分。', '4', 'A.一个月', 'B.三个月', 'C.六个月', 'D.一年', null, null, null, null, '1', '2020-10-23 16:37:29', '2020-10-23 16:37:29', '0', null);
INSERT INTO `question_info` VALUES ('38', '0', '5.在考试、录取工作中，有泄露试题、考场舞弊、涂改考卷、违规录取等违反有关规定行为的，给予警告或者严重警告处分;情节较重的，(  );情节严重的，给予开除党籍处分。', '4', 'A.给予警告或者严重警告处分', 'B.给予撤销党内职务或者留党察看处分', 'C.给予留党察看或者开除党籍处分', 'D.不追究其责任', null, null, null, null, '1', '2020-10-23 16:37:29', '2020-10-23 16:37:29', '0', null);
INSERT INTO `question_info` VALUES ('39', '0', '6.临时出国(境)团(组)或者人员中的党员，擅自延长在国(境)外期限，或者擅自变更路线的，对直接责任者和领导责任者，给予(  )。', '4', 'A.警告或者严重警告处分', 'B.行政处分', 'C.撤销党内职务或留党察看', 'D.开除党籍', null, null, null, null, '1', '2020-10-23 16:37:29', '2020-10-23 16:37:29', '0', null);
INSERT INTO `question_info` VALUES ('40', '0', '7.在民主推荐、民主测评、组织考察和党内选举中搞拉票、助选等非组织活动的，给予(  )。', '4', 'A.通报批评', 'B.警告或者严重警告', 'C.撤销党内职务或者留党察看', 'D.开除党籍', null, null, null, null, '1', '2020-10-23 16:37:29', '2020-10-23 16:37:29', '0', null);
INSERT INTO `question_info` VALUES ('41', '0', '8.在特殊时期或者紧急状况下，拒不执行党组织决定的，给予(  )。', '4', 'A.通报批评', 'B.警告或者严重警告', 'C.撤销党内职务或者留党察看', 'D.留党察看或者开除党籍', null, null, null, null, '1', '2020-10-23 16:37:29', '2020-10-23 16:37:29', '0', null);
INSERT INTO `question_info` VALUES ('42', '0', '9.违反公务接待管理规定，超标准、超范围接待或者借机大吃大喝，对直接责任者和领导责任者，情节较重的，给予警告或者严重警告处分;情节严重的，给予(  )处分。', '4', 'A.撤销党内职务', 'B.留党察看', 'C.撤销党内职务', 'D.留党察看或者开除党籍', null, null, null, null, '1', '2020-10-23 16:37:29', '2020-10-23 16:37:29', '0', null);
INSERT INTO `question_info` VALUES ('43', '0', '10.收受可能影响公正执行公务的礼品、礼金、消费卡和有价证券、股权、其他金融产品等财物，情节较重的，给予(  )处分。', '4', 'A.严重警告', 'B.留党察看', 'C.开除党籍', 'D.撤销党内职务或者留党察看', null, null, null, null, '1', '2020-10-23 16:37:29', '2020-10-23 16:37:29', '0', null);
INSERT INTO `question_info` VALUES ('44', '0', '11.党的各级代表大会的代表受到(  )以上(含留党察看)处分的，党组织应当终止其代表资格。', '4', 'A.警告', 'B.严重警告', 'C.撤销党内职务', 'D.留党察看', null, null, null, null, '1', '2020-10-23 16:37:29', '2020-10-23 16:37:29', '0', null);
INSERT INTO `question_info` VALUES ('45', '0', '1.《中华人民共和国监察法》自_________起施行。', '4', 'A.2018年3月3日', 'B.2018年3月15日', 'C.2018年3月20日', 'D.2018年3月25日', null, null, null, null, '1', '2020-10-23 16:37:32', '2020-10-23 16:37:32', '0', null);
INSERT INTO `question_info` VALUES ('46', '0', '2.为了深化国家监察体制改革，加强对所有行使_____的____的监督，实现国家监察全面覆盖。', '4', 'A.权力    公职人员', 'B.公权力    公职人员', 'C.公权力    公务员', 'D.职权    公务员', null, null, null, null, '1', '2020-10-23 16:37:32', '2020-10-23 16:37:32', '0', null);
INSERT INTO `question_info` VALUES ('47', '0', '3.监察机关办理职务违法和职务犯罪案件，应当与审判机关、检察机关、______相互配合，互相制约。', '4', 'A.执法机关', 'B.公安机关', 'C.行政机关', 'D.执法部门', null, null, null, null, '1', '2020-10-23 16:37:32', '2020-10-23 16:37:32', '0', null);
INSERT INTO `question_info` VALUES ('48', '0', '4.国家监察委员会主任由_____选举，副主任、委员由国家监察委员会主任提请_______任免。', '4', 'A.全国人民代表大会常委委员   全国人民代表大会常委委员会', 'B.全国人民代表大会   全国人民代表大会', 'C.全国人民代表大会常务委员会    全国人民代表大会', 'D.全国人民代表大会   全国人民代表大会常务委员会', null, null, null, null, '1', '2020-10-23 16:37:32', '2020-10-23 16:37:32', '0', null);
INSERT INTO `question_info` VALUES ('49', '0', '5.中华人民共和国国家监察委员会是最高______机关。', '4', 'A.监督', 'B.调查', 'C.监察', 'D.督查', null, null, null, null, '1', '2020-10-23 16:37:32', '2020-10-23 16:37:32', '0', null);
INSERT INTO `question_info` VALUES ('50', '0', '6.地方各级监察委员会对本级___和___负责，并接受其监督。', '4', 'A.党委    上一级监察委员会', 'B.人民政府     上一级监察委员会主任', 'C.人民代表大会及其常务委员会   上一级监察委员会', 'D.监察委员会主任    上一级监察委员会主任', null, null, null, null, '1', '2020-10-23 16:37:32', '2020-10-23 16:37:32', '0', null);
INSERT INTO `question_info` VALUES ('51', '0', '7.上级监察委员会____下级监察委员会的工作。', '4', 'A.指导', 'B.领导', 'C.监督', 'D.指导监督', null, null, null, null, '1', '2020-10-23 16:37:32', '2020-10-23 16:37:32', '0', null);
INSERT INTO `question_info` VALUES ('52', '0', '8.监察委员会依照____和有关法律规定履行相关职责。', '4', 'A.宪法', 'B.党章', 'C.刑法', 'D.监察法', null, null, null, null, '1', '2020-10-23 16:37:32', '2020-10-23 16:37:32', '0', null);
INSERT INTO `question_info` VALUES ('53', '0', '9.各级监察委员会派驻或者派出的监察机构、监察专员，根据授权，按照管理权限依法对公职人员进行监督，提出监察建议，依法对公职人员进行_______________。', '4', 'A.调查、处置', 'B.监督、调查、处置', 'C.监督、处置', 'D.监督、调查', null, null, null, null, '1', '2020-10-23 16:37:32', '2020-10-23 16:37:32', '0', null);
INSERT INTO `question_info` VALUES ('54', '0', '10.下列哪类人员不是监察对象？', '4', 'A.公立中学教务处主任', 'B.民营医院院长', 'C.协助乡政府办理贫困户就业贷款的村民兵营长', 'D.受交警支队委托从事交通事故勘验的协警', null, null, null, null, '1', '2020-10-23 16:37:32', '2020-10-23 16:37:32', '0', null);
INSERT INTO `question_info` VALUES ('55', '0', '11.监察机关行使监督、调查职权，_____依法向有关单位和个人了解情况，收集、调取证据。', '4', 'A.经授权', 'B.经审批', 'C.有权', 'D.经请示', null, null, null, null, '1', '2020-10-23 16:37:32', '2020-10-23 16:37:32', '0', null);
INSERT INTO `question_info` VALUES ('56', '0', '12.对可能发生职务违法的监察对象，监察机关按照____，可以直接或者委托有关机关、人员进行谈话或者要求说明情况。', '4', 'A.管理权限', 'B.法律规定', 'C.领导指示', 'D.会议研究决定', null, null, null, null, '1', '2020-10-23 16:37:32', '2020-10-23 16:37:32', '0', null);
INSERT INTO `question_info` VALUES ('57', '0', '13.在调查过程中，对涉嫌职务违法的被调查人，监察机关可以要求其就涉嫌违法行为作出陈述,必要时向被调查人出具___。', '4', 'A.函询通知', 'B.书面通知', 'C.谈话通知', 'D.书面说明', null, null, null, null, '1', '2020-10-23 16:37:32', '2020-10-23 16:37:32', '0', null);
INSERT INTO `question_info` VALUES ('58', '0', '14.对涉嫌贪污贿赂、失职渎职等职务犯罪的被调查人，监察机关可以进行_____，要求其如实供述涉嫌犯罪的情况。', '4', 'A.询问', 'B.质问', 'C.讯问', 'D.训问', null, null, null, null, '1', '2020-10-23 16:37:32', '2020-10-23 16:37:32', '0', null);
INSERT INTO `question_info` VALUES ('59', '0', '15.在调查过程中，监察机关可以_____证人等人员。', '4', 'A.询问', 'B.质问', 'C.讯问', 'D.训问', null, null, null, null, '1', '2020-10-23 16:37:32', '2020-10-23 16:37:32', '0', null);
INSERT INTO `question_info` VALUES ('60', '0', '16.对涉嫌行贿犯罪或者共同职务犯罪的涉案人员，监察机关可以依照规定采取_____措施。', '4', 'A.留置', 'B.拘留', 'C.逮捕', 'D.监视居住', null, null, null, null, '1', '2020-10-23 16:37:32', '2020-10-23 16:37:32', '0', null);
INSERT INTO `question_info` VALUES ('61', '0', '17.监察机关调查涉嫌贪污贿赂、失职渎职等严重职务违法或者职务犯罪，根据工作需要，可以依照规定_____涉案单位和个人的存款、汇款、债券、股票、基金份额等财产。', '4', 'A.查封、划拨', 'B.冻结、扣押', 'C.查封、扣押', 'D.查询、冻结', null, null, null, null, '1', '2020-10-23 16:37:32', '2020-10-23 16:37:32', '0', null);
INSERT INTO `question_info` VALUES ('62', '0', '18.冻结的财产经查明与案件无关的，应当在查明后____内解除冻结，予以退还。', '4', 'A.7日', 'B.3日', 'C.5日', 'D.15日', null, null, null, null, '1', '2020-10-23 16:37:32', '2020-10-23 16:37:32', '0', null);
INSERT INTO `question_info` VALUES ('63', '0', '19.监察机关可以对涉嫌职务犯罪的被调查人以及可能隐藏被调查人或者犯罪证据的人的身体、物品、____和其他有关地方进行搜查。', '4', 'A.单位', 'B.住处', 'C.房间', 'D.档案局', null, null, null, null, '1', '2020-10-23 16:37:32', '2020-10-23 16:37:32', '0', null);
INSERT INTO `question_info` VALUES ('64', '0', '20.采取调取、查封、扣押措施，应当收集原物原件，会同持有人或者保管人_____，当面逐一拍照、登记、编号，开列清单，由在场人员当场核对、签名，并将清单副本交财物、文件的持有人或者保管人。', '4', 'A.证人', 'B.使用人', 'C.见证人', 'D.律师', null, null, null, null, '1', '2020-10-23 16:37:32', '2020-10-23 16:37:32', '0', null);
INSERT INTO `question_info` VALUES ('65', '0', '21.查封、扣押的财物、文件经查明与案件无关的，应当在查明后____内解除查封、扣押，予以退还。', '4', 'A.10日', 'B.7日', 'C.5日', 'D.3日', null, null, null, null, '1', '2020-10-23 16:37:32', '2020-10-23 16:37:32', '0', null);
INSERT INTO `question_info` VALUES ('66', '0', '22.监察机关在调查过程中，可以直接或者指派、聘请具有专门知识、资格的人员_____进行勘验检查。', '4', 'A.直接', 'B.经审批后', 'C.在司法机关安排下', 'D.在调查人员主持下', null, null, null, null, '1', '2020-10-23 16:37:32', '2020-10-23 16:37:32', '0', null);
INSERT INTO `question_info` VALUES ('67', '0', '23.监察机关对于案件中的___问题，可以采取鉴定措施。', '4', 'A.一般性', 'B.专门性', 'C.特殊性', 'D.普遍性', null, null, null, null, '1', '2020-10-23 16:37:32', '2020-10-23 16:37:32', '0', null);
INSERT INTO `question_info` VALUES ('68', '0', '24.留置时间不得超过三个月。在特殊情况下，可以延长一次，延长时间不得超过___。', '4', 'A.一个月', 'B.二个月', 'C.三个月', 'D.六个月', null, null, null, null, '1', '2020-10-23 16:37:32', '2020-10-23 16:37:32', '0', null);
INSERT INTO `question_info` VALUES ('69', '0', '25.对被调查人采取留置措施后，应当在___以内，通知被留置人员所在单位和家属，但有可能毁灭、伪造证据，干扰证人作证或者串供等有碍调查情形的除外。有碍调查的情形消失后，应当立即通知被留置人员所在单位和家属。', '4', 'A.12小时', 'B.24小时', 'C.36小时', 'D.48小时', null, null, null, null, '1', '2020-10-23 16:37:32', '2020-10-23 16:37:32', '0', null);
INSERT INTO `question_info` VALUES ('70', '0', '26.职务违法犯罪的涉案人员揭发有关被调查人职务违法犯罪行为，查证属实的，或者提供重要线索，有助于调查其他案件的，监察机关经领导人员集体研究，并报上一级监察机关批准，可以在移送人民检察院时提出___处罚的建议。', '4', 'A.从轻', 'B.减轻', 'C.从宽', 'D.免除', null, null, null, null, '1', '2020-10-23 16:37:32', '2020-10-23 16:37:32', '0', null);
INSERT INTO `question_info` VALUES ('71', '0', '27.监察机关在收集、固定、审查、运用证据时，应当与____关于证据的要求和标准相一致。', '4', 'A.刑事审判', 'B.民事审判', 'C.行政审判', 'D.刑事诉讼', null, null, null, null, '1', '2020-10-23 16:37:32', '2020-10-23 16:37:32', '0', null);
INSERT INTO `question_info` VALUES ('72', '0', '28.监察机关对于报案或者举报，应当接受并按照有关规定处理。对于不属于本机关管辖的，应当移送____处理。', '4', 'A.有关机关', 'B.主管机关', 'C.相关机关', 'D.有关部门', null, null, null, null, '1', '2020-10-23 16:37:32', '2020-10-23 16:37:32', '0', null);
INSERT INTO `question_info` VALUES ('73', '0', '29.经过初步____，对监察对象涉嫌职务违法犯罪，需要追究法律责任的，监察机关应当按照规定的权限和程序办理立案手续。', '4', 'A.核查', 'B.核实', 'C.调查', 'D.审查', null, null, null, null, '1', '2020-10-23 16:37:32', '2020-10-23 16:37:32', '0', null);
INSERT INTO `question_info` VALUES ('74', '0', '30.人民检察院经审查，认为需要补充核实的，应当退回监察机关补充调查，必要时可以自行补充侦查。对于补充调查的案件，应当在___个月内补充调查完毕。补充调查以___次为限。', '4', 'A.一,二', 'B.一,一', 'C.二,一', 'D.二,二', null, null, null, null, '1', '2020-10-23 16:37:32', '2020-10-23 16:37:32', '0', null);
INSERT INTO `question_info` VALUES ('75', '0', '31.人民检察院对于有《中华人民共和国刑事诉讼法》规定的不起诉的情形的，经_____批准，依法作出不起诉的决定。', '4', 'A.上一级人民检察院', 'B.省级人民检察院', 'C.上级人民检察院', 'D.同级监察机关', null, null, null, null, '1', '2020-10-23 16:37:32', '2020-10-23 16:37:32', '0', null);
INSERT INTO `question_info` VALUES ('76', '0', '32.被调查人逃匿，在通缉___后不能到案，或者死亡的，由监察机关提请人民检察院依照法定程序，向人民法院提出没收违法所得的申请。', '4', 'A.一年', 'B.半年', 'C.两年', 'D.一年半', null, null, null, null, '1', '2020-10-23 16:37:32', '2020-10-23 16:37:32', '0', null);
INSERT INTO `question_info` VALUES ('77', '0', '33.监察对象对监察机关作出的涉及本人的处理决定不服的，可以在收到处理决定之日起___个月内，向作出决定的监察机关申请复审，复审机关应当在___个月内作出复审决定。', '4', 'A.一,二', 'B.一,一', 'C.二,一', 'D.二,二', null, null, null, null, '1', '2020-10-23 16:37:32', '2020-10-23 16:37:32', '0', null);
INSERT INTO `question_info` VALUES ('78', '0', '34.监察委员会依照法律规定独立行使监察权，不受_____、社会团体和个人的干涉。', '4', 'A.国家机关', 'B.行政机关', 'C.政府机关', 'D.党群机关', null, null, null, null, '1', '2020-10-23 16:37:32', '2020-10-23 16:37:32', '0', null);
INSERT INTO `question_info` VALUES ('79', '0', '35.监察机关依照本法规定收集的物证、书证、证人证言、____供述和辩解、视听资料、电子数据等证据材料，在刑事诉讼中可以作为证据使用。', '4', 'A.犯罪嫌疑人', 'B.被调查人', 'C.被核查人', 'D.违法嫌疑人', null, null, null, null, '1', '2020-10-23 16:37:32', '2020-10-23 16:37:32', '0', null);
INSERT INTO `question_info` VALUES ('80', '0', '36.被调查人既涉嫌严重职务违法或者职务犯罪，又涉嫌其他违法犯罪的，一般应当由____为主调查，其他机关予以协助。', '4', 'A.监察机关', 'B.检察机关', 'C.公安机关', 'D.国家安全机关', null, null, null, null, '1', '2020-10-23 16:37:32', '2020-10-23 16:37:32', '0', null);
INSERT INTO `question_info` VALUES ('81', '0', '37.监察机关应当严格按照程序开展工作，建立问题线索处置、调查、审理各部门相互____、相互制约的工作机制。', '4', 'A.配合', 'B.协调', 'C.合作', 'D.协作', null, null, null, null, '1', '2020-10-23 16:37:32', '2020-10-23 16:37:32', '0', null);
INSERT INTO `question_info` VALUES ('82', '0', '38.需要采取初步核实方式处置问题线索的，监察机关应当依法履行审批程序，成立____。', '4', 'A.核查组', 'B.调查组', 'C.初查组', 'D.审查组', null, null, null, null, '1', '2020-10-23 16:37:32', '2020-10-23 16:37:32', '0', null);
INSERT INTO `question_info` VALUES ('83', '0', '39.被留置人员涉嫌犯罪移送司法机关后，被依法判处管制、拘役和有期徒刑的，留置一日折抵管制____日，折抵拘役、有期徒刑____日。', '4', 'A.一,二', 'B.一,一', 'C.二,一', 'D.二,二', null, null, null, null, '1', '2020-10-23 16:37:32', '2020-10-23 16:37:32', '0', null);
INSERT INTO `question_info` VALUES ('84', '0', '40.监察人员辞职、退休___年内，不得从事与监察和司法工作相关联且可能发生利益冲突的职业。', '4', 'A.一', 'B.二', 'C.三', 'D.四', null, null, null, null, '1', '2020-10-23 16:37:32', '2020-10-23 16:37:32', '0', null);
INSERT INTO `question_info` VALUES ('85', '0', '41.受理申诉的监察机关应当在受理申诉之日起___个月内作出处理决定。', '4', 'A.一', 'B.二', 'C.三', 'D.四', null, null, null, null, '1', '2020-10-23 16:37:32', '2020-10-23 16:37:32', '0', null);
INSERT INTO `question_info` VALUES ('86', '0', '42.对调查工作结束后发现立案依据不充分或者失实，案件处置出现重大失误，监察人员严重违法的，应当追究负有责任的____的责任。', '4', 'A.领导人员', 'B.直接责任人员', 'C.领导人员和直接责任人员', 'D.部门负责人', null, null, null, null, '1', '2020-10-23 16:37:32', '2020-10-23 16:37:32', '0', null);
INSERT INTO `question_info` VALUES ('87', '0', '43.监察机关之间对监察事项的管辖有争议的，由________ 确定。', '4', 'A.省级监察机关', 'B.上级监察机关', 'C.市级监察机关', 'D.共同的上级监察机关', null, null, null, null, '1', '2020-10-23 16:37:32', '2020-10-23 16:37:32', '0', null);
INSERT INTO `question_info` VALUES ('88', '0', '44.监察机关____依法批准立案后，应当主持召开专题会议，研究确定调查方案，决定需要采取的调查措施。', '4', 'A.主要负责人', 'B.相关负责人', 'C.主要领导', 'D.分管领导', null, null, null, null, '1', '2020-10-23 16:37:32', '2020-10-23 16:37:32', '0', null);
INSERT INTO `question_info` VALUES ('89', '0', '45.留置场所的设置、管理和监督依照国家有关____执行。', '4', 'A.法律', 'B.法规', 'C.规定', 'D.规章', null, null, null, null, '1', '2020-10-23 16:37:32', '2020-10-23 16:37:32', '0', null);
INSERT INTO `question_info` VALUES ('90', '0', '46.搜查女性身体，应当由____进行。', '4', 'A.医师', 'B.女医师', 'C.调查人员', 'D.女性工作人员', null, null, null, null, '1', '2020-10-23 16:37:32', '2020-10-23 16:37:32', '0', null);
INSERT INTO `question_info` VALUES ('91', '0', '47.监察机关进行搜查时，可以根据工作需要提请____配合。', '4', 'A.公安机关', 'B.检察机关', 'C.法院', 'D.司法机关', null, null, null, null, '1', '2020-10-23 16:37:32', '2020-10-23 16:37:32', '0', null);
INSERT INTO `question_info` VALUES ('92', '0', '48.监察机关调查涉嫌重大贪污贿赂等职务犯罪，根据需要，经过严格的批准手续，可以采取技术调查措施，按照规定交有关机关执行。批准决定应当明确采取技术调查措施的种类和____，自签发之日起三个月以内有效。', '4', 'A.适用条件', 'B.适用情形', 'C.适用对象', 'D.适用方式', null, null, null, null, '1', '2020-10-23 16:37:32', '2020-10-23 16:37:32', '0', null);
INSERT INTO `question_info` VALUES ('93', '0', '49.依法应当留置的被调查人如果在逃，监察机关可以决定在本行政区域内通缉，由____发布通缉令，追捕归案。通缉范围超出本行政区域的，应当报请有权决定的上级监察机关决定。', '4', 'A.公安机关', 'B.检察机关', 'C.法院', 'D.司法机关', null, null, null, null, '1', '2020-10-23 16:37:32', '2020-10-23 16:37:32', '0', null);
INSERT INTO `question_info` VALUES ('94', '0', '50.中国人民解放军和中国人民武装警察部队开展监察工作，由____根据本法制定具体规定。', '4', 'A.中央纪律检查委员会', 'B.国家监察委员会', 'C.全国人大常委会', 'D.中央军事委员会', null, null, null, null, '1', '2020-10-23 16:37:32', '2020-10-23 16:37:32', '0', null);

-- ----------------------------
-- Table structure for sys_modules
-- ----------------------------
DROP TABLE IF EXISTS `sys_modules`;
CREATE TABLE `sys_modules` (
  `module_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '模块id',
  `app_id` int(1) unsigned zerofill NOT NULL DEFAULT '0' COMMENT '0 后台 1网站 ',
  `module_name` varchar(100) DEFAULT NULL COMMENT '模块名称',
  `module_code` varchar(100) DEFAULT NULL COMMENT '模块编码',
  `module_class` varchar(100) DEFAULT NULL COMMENT '图标样式',
  `module_path` varchar(200) DEFAULT NULL COMMENT '链接路径',
  `module_description` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_spanish2_ci DEFAULT NULL COMMENT '功能描述',
  `module_parent` int(11) DEFAULT NULL COMMENT '上级模块',
  `module_sort` int(11) DEFAULT NULL COMMENT '排序',
  `module_isdisable` int(11) DEFAULT NULL COMMENT '是否禁用',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `delete_flag` int(11) DEFAULT '0' COMMENT '删除标记：0，未删除；1、已删除',
  PRIMARY KEY (`module_id`)
) ENGINE=InnoDB AUTO_INCREMENT=214 DEFAULT CHARSET=utf8 COMMENT='系统模块表';

-- ----------------------------
-- Records of sys_modules
-- ----------------------------
INSERT INTO `sys_modules` VALUES ('1', '0', '首页', '', '', 'index.html', '', '0', '1', '0', '2020-09-29 15:31:23', '2020-09-29 15:31:23', '0');
INSERT INTO `sys_modules` VALUES ('2', '0', '课程', '', '', 'trainingcourse.html', '', '0', '2', '0', '2020-09-29 15:32:05', '2020-09-29 15:32:05', '0');
INSERT INTO `sys_modules` VALUES ('3', '0', '教师', '', '', 'teacher.html', '', '0', '3', '0', '2020-09-29 15:32:35', '2020-09-29 15:32:35', '0');
INSERT INTO `sys_modules` VALUES ('4', '0', '证书', '', '', 'certificate.html', '', '0', '4', '0', '2020-09-29 15:33:10', '2020-09-29 15:33:10', '0');
INSERT INTO `sys_modules` VALUES ('5', '0', '新闻', '', '', 'news.html', '', '0', '5', '0', '2020-09-29 15:33:48', '2020-09-29 15:33:48', '0');
INSERT INTO `sys_modules` VALUES ('6', '0', '联系', '', '', 'contact.html', '', '0', '6', '0', '2020-09-29 16:03:11', '2020-09-29 16:03:11', '0');
INSERT INTO `sys_modules` VALUES ('192', '1', '系统管理', '', '', '', '', '0', '1', '0', '2020-09-29 15:31:23', '2020-09-29 15:31:23', '0');
INSERT INTO `sys_modules` VALUES ('193', '1', '用户管理', '', '', '', '', '0', '2', '0', '2020-09-29 15:32:05', '2020-09-29 15:32:05', '0');
INSERT INTO `sys_modules` VALUES ('194', '1', '新闻中心', '', '', 'articlelist.html', '', '0', '3', '0', '2020-09-29 15:32:35', '2020-09-29 15:32:35', '0');
INSERT INTO `sys_modules` VALUES ('195', '1', '课程中心', '', '', 'courselist.html', '', '205', '1', '0', '2020-09-29 15:33:10', '2020-09-29 15:33:10', '0');
INSERT INTO `sys_modules` VALUES ('196', '1', '模块管理', '', '', 'modulelist.html', '', '192', '1', '0', '2020-09-29 15:33:48', '2020-09-29 15:33:48', '0');
INSERT INTO `sys_modules` VALUES ('197', '1', '角色管理', '', '', 'rolelist.html', '', '192', '1', '0', '2020-09-29 16:03:11', '2020-09-29 16:03:11', '0');
INSERT INTO `sys_modules` VALUES ('198', '1', '系统设置', '', '', 'settinglist.html', '', '192', '5', '0', '2020-10-14 17:58:02', '2020-10-14 17:58:02', '0');
INSERT INTO `sys_modules` VALUES ('205', '1', '课程管理', '', '', '', '', '0', '1', '0', '2020-10-15 11:49:02', '2020-10-15 11:49:02', '0');
INSERT INTO `sys_modules` VALUES ('206', '1', '操作日志', '', '', 'logbilloperationlist.html', '', '192', '4', '0', '2020-10-16 16:13:11', '2020-10-16 16:13:11', '0');
INSERT INTO `sys_modules` VALUES ('207', '1', '教师管理', '', '', 'teacherlist.html', '', '193', '2', '0', '2020-10-19 11:49:11', '2020-10-19 11:49:11', '0');
INSERT INTO `sys_modules` VALUES ('208', '1', '用户管理', '', '', 'userlist.html', '', '193', '1', '0', '2020-10-19 11:50:25', '2020-10-19 11:50:25', '0');
INSERT INTO `sys_modules` VALUES ('209', '1', '问卷管理', '', '', '', '', '0', '4', '0', '2020-10-22 09:15:37', '2020-10-22 09:15:37', '0');
INSERT INTO `sys_modules` VALUES ('210', '1', '问卷中心', '', '', 'nairelist.html', '', '209', '1', '0', '2020-10-22 09:16:02', '2020-10-22 09:16:02', '0');
INSERT INTO `sys_modules` VALUES ('211', '1', '题库列表', '', '', 'questionlist.html', '', '209', '2', '0', '2020-10-22 09:16:22', '2020-10-22 09:16:22', '0');
INSERT INTO `sys_modules` VALUES ('212', '1', '用户答卷列表', '', '', 'answerrecordlist.html', '', '209', '3', '0', '2020-10-22 09:17:29', '2020-10-22 09:17:29', '0');
INSERT INTO `sys_modules` VALUES ('213', '1', '题库管理', '', '', '', '', '209', '1', '0', '2020-10-23 09:51:25', '2020-10-23 09:51:25', '0');

-- ----------------------------
-- Table structure for sys_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_role`;
CREATE TABLE `sys_role` (
  `role_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '角色ID',
  `role_name` varchar(30) COLLATE utf8_bin NOT NULL COMMENT '角色名称',
  `role_key` varchar(100) COLLATE utf8_bin DEFAULT NULL COMMENT '角色权限字符串',
  `role_sort` int(4) DEFAULT NULL COMMENT '显示顺序',
  `data_scope` char(1) COLLATE utf8_bin DEFAULT '1' COMMENT '数据范围（1：全部数据权限 2：自定数据权限 3：本部门数据权限 4：本部门及以下数据权限）',
  `status` char(1) COLLATE utf8_bin NOT NULL COMMENT '角色状态（0正常 1停用）',
  `del_flag` char(1) COLLATE utf8_bin DEFAULT '0' COMMENT '删除标志（0代表存在 2代表删除）',
  `create_by` varchar(64) COLLATE utf8_bin DEFAULT '' COMMENT '创建者',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(64) COLLATE utf8_bin DEFAULT '' COMMENT '更新者',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(500) COLLATE utf8_bin DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`role_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COLLATE=utf8_bin ROW_FORMAT=COMPACT COMMENT='角色信息表';

-- ----------------------------
-- Records of sys_role
-- ----------------------------
INSERT INTO `sys_role` VALUES ('1', '系统管理员', null, null, '1', '0', '0', '', null, '', '2020-10-07 18:18:03', '222');
INSERT INTO `sys_role` VALUES ('2', '教师', null, null, '1', '0', '0', '', '2020-10-07 18:20:13', '', '2020-10-07 18:20:13', '222');
INSERT INTO `sys_role` VALUES ('3', '普通用户', null, null, '1', '0', '0', '', '2020-10-07 18:20:32', '', '2020-10-07 18:20:32', '333');

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
INSERT INTO `sys_role_modules` VALUES ('1', '192', '5');
INSERT INTO `sys_role_modules` VALUES ('1', '195', '4');
INSERT INTO `sys_role_modules` VALUES ('1', '196', '2');
INSERT INTO `sys_role_modules` VALUES ('1', '197', '1');
INSERT INTO `sys_role_modules` VALUES ('1', '198', '3');
INSERT INTO `sys_role_modules` VALUES ('2', '192', '5');
INSERT INTO `sys_role_modules` VALUES ('2', '195', '4');
INSERT INTO `sys_role_modules` VALUES ('2', '196', '2');
INSERT INTO `sys_role_modules` VALUES ('2', '197', '1');
INSERT INTO `sys_role_modules` VALUES ('2', '198', '3');
INSERT INTO `sys_role_modules` VALUES ('3', '192', '1');
INSERT INTO `sys_role_modules` VALUES ('3', '193', '8');
INSERT INTO `sys_role_modules` VALUES ('3', '194', '9');
INSERT INTO `sys_role_modules` VALUES ('3', '195', '7');
INSERT INTO `sys_role_modules` VALUES ('3', '196', '2');
INSERT INTO `sys_role_modules` VALUES ('3', '197', '3');
INSERT INTO `sys_role_modules` VALUES ('3', '198', '5');
INSERT INTO `sys_role_modules` VALUES ('3', '205', '6');
INSERT INTO `sys_role_modules` VALUES ('3', '206', '4');

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
INSERT INTO `sys_settings` VALUES ('', '1370XX123@qq.com', '邮箱', null, null, '0');
INSERT INTO `sys_settings` VALUES ('web_address', '西安市碑林区咸宁西路28号', '联系页地址', '2020-10-15 09:49:28', '2020-10-15 09:49:31', '0');
INSERT INTO `sys_settings` VALUES ('web_chuanzhen', '029-82669018', '传真', '2020-10-15 09:51:13', '2020-10-15 09:51:13', '0');
INSERT INTO `sys_settings` VALUES ('web_phone', '029-82668189', '电话', '2020-10-15 09:51:13', '2020-10-15 09:51:13', '0');

-- ----------------------------
-- Table structure for user_answer_record
-- ----------------------------
DROP TABLE IF EXISTS `user_answer_record`;
CREATE TABLE `user_answer_record` (
  `naire_id` int(11) NOT NULL,
  `user_id` int(11) NOT NULL,
  `create_time` datetime DEFAULT NULL,
  `submit_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `content` text,
  `delete_flag` int(1) DEFAULT '0',
  `score` int(3) DEFAULT NULL,
  `certificate_state` int(1) DEFAULT NULL COMMENT '是否获得证书',
  PRIMARY KEY (`naire_id`,`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user_answer_record
-- ----------------------------
INSERT INTO `user_answer_record` VALUES ('1', '1', '2020-10-23 18:00:33', '2020-10-23 18:00:33', '2020-10-23 18:00:33', '[\"{\\\"questionNumber\\\":\\\"1\\\", \\\"userAnswer\\\":\\\"2\\\"}\",\"{\\\"questionNumber\\\":\\\"2\\\", \\\"userAnswer\\\":\\\"4\\\"}\",\"{\\\"questionNumber\\\":\\\"3\\\", \\\"userAnswer\\\":\\\"2\\\"}\",\"{\\\"questionNumber\\\":\\\"4\\\", \\\"userAnswer\\\":\\\"2\\\"}\",\"{\\\"questionNumber\\\":\\\"5\\\", \\\"userAnswer\\\":\\\"2\\\"}\",\"{\\\"questionNumber\\\":\\\"6\\\", \\\"userAnswer\\\":\\\"3\\\"}\",\"{\\\"questionNumber\\\":\\\"7\\\", \\\"userAnswer\\\":\\\"2\\\"}\",\"{\\\"questionNumber\\\":\\\"8\\\", \\\"userAnswer\\\":\\\"2\\\"}\"]', '0', '50', null);

-- ----------------------------
-- Table structure for user_info
-- ----------------------------
DROP TABLE IF EXISTS `user_info`;
CREATE TABLE `user_info` (
  `user_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '用户id',
  `role_id` int(11) NOT NULL COMMENT '角色id',
  `user_name` varchar(50) NOT NULL COMMENT '用户名',
  `real_name` varchar(50) NOT NULL COMMENT '昵称',
  `user_pwd` varchar(50) DEFAULT NULL COMMENT '密码:6~18位',
  `head_pic_code` varchar(50) DEFAULT NULL COMMENT '头像照片代码',
  `user_mobile` varchar(20) DEFAULT NULL COMMENT '移动电话',
  `machine_code` varchar(50) DEFAULT NULL COMMENT '机器码',
  `remark` varchar(2000) DEFAULT NULL COMMENT '简介',
  `update_time` datetime DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `index_show` int(1) DEFAULT '0' COMMENT '是否在首页显示 0否 1是',
  `delete_flag` int(255) DEFAULT '0',
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=35 DEFAULT CHARSET=utf8 COMMENT='用户基本信息表';

-- ----------------------------
-- Records of user_info
-- ----------------------------
INSERT INTO `user_info` VALUES ('1', '1', 'admin', '111', '96e79218965eb72c92a549dd5a330112', null, '18792652222', null, null, null, null, null, '0');
INSERT INTO `user_info` VALUES ('2', '2', 'yanghuan', '杨欢', '96e79218965eb72c92a549dd5a330112', '1602124021749.png', '', null, '杨欢，西安交通大学附属小学语文教师，教研组长，小学高级教师，陕西省骨干教师，先后被授予“西安市教学能手”“陕西省优秀教学能手”“陕西省学科带头人”，碑林区阳光育人工程“优秀教师”。连续多年担任陕西省国培计划主讲教师、指导教师团队成员，先后赴宝鸡、咸阳、铜川、商洛、兰州等地送教培训，主持参与国家级、省级课题10余个，主持“陕西省教学能手工作站”和“学科带头人工作坊”课题研究工作。', '2020-10-08 10:27:04', '2020-10-08 10:27:04', null, '0');
INSERT INTO `user_info` VALUES ('3', '2', 'gaosahnshan', '高珊珊', '96e79218965eb72c92a549dd5a330112', '1602123846661.png', '', null, '高珊珊，女，本科学历，现任职于西安交通大学附属小学，任教数学学科，为陕西省教学能手，陕西省第四批学科带头人。一直从事小学数学教学与研究，执教的现场课和课堂实录，及多篇设计论文在省市教学成果评选中获奖，主持过2项省级课题，多次担任国培或省培的主讲教师和指导教师。', '2020-10-08 10:24:18', '2020-10-08 10:24:18', null, '0');
INSERT INTO `user_info` VALUES ('5', '2', 'dijuan', '邸娟', '96e79218965eb72c92a549dd5a330112', '1602123668710.png', '18792652222', null, '邸娟，科学教师，交大附小综合组教研组长，中小学一级教师，碑林区“阳光教师”、碑林区“优秀教科研先进个人”、2018年获得“西安市教学能手”称号、2016年获得“碑林区教学能手”称号，校级“优秀教科研先进个人”，所带领的教研组多次评为校级“先进教科研教研组”、“优秀教研组”。多年致力于科学教学工作，撰写的教学设计和论文多次荣获市级、省级、国家级一、二等奖；2014年完成国家级课题《课堂结构可视化的研究》、2017年完成西安市小课题《借助“思维导图”提升小学科学课堂教学质量的实践研究》。2018年申报陕西省课题《小学STEAM创新教育与学科融合初探》已立项，在省、市级科技创新大赛、环球自然日、DI创新思维大赛、宋庆龄少年儿童创新发明活动中多次被评为“优秀辅导教师”、“优秀领队”、“优秀裁判”、“优秀园丁奖”、“优秀指导教师”、“优秀辅导员”等荣誉称号，2019年获得陕西省教学能手称号。', '2020-10-08 10:21:34', '2020-10-08 10:21:34', null, '0');
INSERT INTO `user_info` VALUES ('6', '2', 'zhaoyuefang', '赵悦芳', '96e79218965eb72c92a549dd5a330112', '1602124051541.png', '', null, '交大附小人工智能老师，人工智能社团指导老师，研究生学历，于2019年7月毕业于陕西师范大学现代教育技术专业，研究方向为人工智能教育。', '2020-10-08 10:28:00', '2020-10-08 10:28:00', null, '0');
INSERT INTO `user_info` VALUES ('7', '2', 'xiaoke', '肖珂', '96e79218965eb72c92a549dd5a330112', '1602124109984.png', '', null, '肖珂，西安交通大学附属小学音乐教师，陕西省教学能手，陕西省第六批学科带头人培养对象组建肖珂工作坊，立项陕西省专项课题“基于人工智能技术的小学音乐教学实践的研究”正在研究中。', '2020-10-08 10:29:37', '2020-10-08 10:29:37', null, '0');
INSERT INTO `user_info` VALUES ('8', '3', 'zhaowenan', '赵文安', '96e79218965eb72c92a549dd5a330112', '1602124202179.png', '', null, '赵文安，信息技术专业，大学本科学历，工程硕士学位，中学高级教师，从事小学信息技术教学30多年。目前从事人工智能教育的研究和教学工作。从教30多年来，辅导的学生多次在全国小学生电脑大赛上获奖。', '2020-10-20 14:35:53', '2020-10-08 10:30:24', null, '0');
INSERT INTO `user_info` VALUES ('9', '2', 'qinnan', '秦楠', '96e79218965eb72c92a549dd5a330112', '1602123937773.jpg', '', null, '\r\n秦楠，男，汉族，现任西安交通大学附属小学少先队大队辅导员，中共党员。2013年毕业于北京大学心理与认知科学学院，获学士学位。曾被评为碑林区优秀大队辅导员，碑林区心理健康学科教研员，西安市德育精品课一等奖获得者，西安市教学能手，陕西省教育能手。', '2020-10-08 10:25:57', '2020-10-08 10:25:57', null, '0');
INSERT INTO `user_info` VALUES ('19', '3', '1111', '11', '96e79218965eb72c92a549dd5a330112', '', '18792652286', null, '', '2020-10-16 10:28:55', '2020-10-16 10:28:55', null, '0');
INSERT INTO `user_info` VALUES ('20', '3', '111111', '11', '96e79218965eb72c92a549dd5a330112', '', '18792652286', null, '', '2020-10-16 10:32:51', '2020-10-16 10:32:51', null, '0');
INSERT INTO `user_info` VALUES ('21', '3', '1212', 'ky', '96e79218965eb72c92a549dd5a330112', '', '18792652286', null, '', '2020-10-16 10:34:34', '2020-10-16 10:34:34', null, '0');
INSERT INTO `user_info` VALUES ('22', '3', '233', '11', '96e79218965eb72c92a549dd5a330112', '', '18792652286', null, '', '2020-10-16 10:37:37', '2020-10-16 10:37:37', null, '0');
INSERT INTO `user_info` VALUES ('23', '3', '2356345', '11', '96e79218965eb72c92a549dd5a330112', '', '18792652286', null, '', '2020-10-16 10:43:17', '2020-10-16 10:43:17', null, '0');
INSERT INTO `user_info` VALUES ('24', '3', '11111', '11', '96e79218965eb72c92a549dd5a330112', '', '18792652286', null, '', '2020-10-16 11:03:09', '2020-10-16 11:03:09', null, '0');
INSERT INTO `user_info` VALUES ('25', '3', '11343', '111', '96e79218965eb72c92a549dd5a330112', '', '18792652286', null, '', '2020-10-16 11:09:42', '2020-10-16 11:09:42', null, '0');
INSERT INTO `user_info` VALUES ('26', '3', 'admin452343', '11', '96e79218965eb72c92a549dd5a330112', '', '18792652286', null, '', '2020-10-16 11:21:23', '2020-10-16 11:21:23', null, '0');
INSERT INTO `user_info` VALUES ('27', '3', 'admin11', '11', '96e79218965eb72c92a549dd5a330112', '', '18792652286', null, '', '2020-10-16 14:03:24', '2020-10-16 14:03:24', null, '0');
INSERT INTO `user_info` VALUES ('28', '3', 'admin222', '11', '96e79218965eb72c92a549dd5a330112', '', '18792652286', null, '', '2020-10-16 14:05:06', '2020-10-16 14:05:06', null, '0');
INSERT INTO `user_info` VALUES ('29', '3', 'admin222', '11', '96e79218965eb72c92a549dd5a330112', '', '18792652286', null, '', '2020-10-16 14:05:13', '2020-10-16 14:05:13', null, '0');
INSERT INTO `user_info` VALUES ('30', '3', 'admin345', '11', '96e79218965eb72c92a549dd5a330112', '', '18792652286', null, '', '2020-10-16 14:07:51', '2020-10-16 14:07:51', null, '0');
INSERT INTO `user_info` VALUES ('31', '3', 'admin44554', '111111', '96e79218965eb72c92a549dd5a330112', '', '18792652286', null, '', '2020-10-16 14:08:23', '2020-10-16 14:08:23', null, '0');
INSERT INTO `user_info` VALUES ('32', '3', 'admin43324', 'ky', '96e79218965eb72c92a549dd5a330112', '', '18792652286', null, '', '2020-10-16 14:12:11', '2020-10-16 14:12:11', null, '0');
INSERT INTO `user_info` VALUES ('33', '3', 'admin的都是多', '11', '96e79218965eb72c92a549dd5a330112', '', '18792652286', null, '', '2020-10-16 14:23:28', '2020-10-16 14:23:28', null, '0');
INSERT INTO `user_info` VALUES ('34', '3', 'admin12撒都有', '11', '96e79218965eb72c92a549dd5a330112', '', '18792652286', null, '', '2020-10-16 14:37:58', '2020-10-16 14:37:58', null, '0');

-- ----------------------------
-- Table structure for user_info_copy
-- ----------------------------
DROP TABLE IF EXISTS `user_info_copy`;
CREATE TABLE `user_info_copy` (
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
-- Records of user_info_copy
-- ----------------------------
INSERT INTO `user_info_copy` VALUES ('1', '1', 'admin', '111', null, '96e79218965eb72c92a549dd5a330112', null, null, '18792652222', null, null, null, null, '0');

-- ----------------------------
-- Table structure for user_learn_record
-- ----------------------------
DROP TABLE IF EXISTS `user_learn_record`;
CREATE TABLE `user_learn_record` (
  `course_id` int(11) NOT NULL,
  `user_id` int(11) NOT NULL,
  `keshi` int(11) NOT NULL,
  `create_time` datetime NOT NULL,
  `learn_time` int(11) DEFAULT NULL,
  `complete_state` int(255) DEFAULT NULL,
  PRIMARY KEY (`course_id`,`user_id`,`keshi`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of user_learn_record
-- ----------------------------
INSERT INTO `user_learn_record` VALUES ('3', '1', '1', '2020-10-10 10:50:13', null, null);
INSERT INTO `user_learn_record` VALUES ('4', '1', '1', '2020-10-10 10:50:23', null, null);
INSERT INTO `user_learn_record` VALUES ('5', '1', '1', '2020-10-10 15:54:49', null, null);
INSERT INTO `user_learn_record` VALUES ('5', '2', '1', '2020-10-17 13:58:19', null, null);
INSERT INTO `user_learn_record` VALUES ('6', '1', '1', '2020-10-10 11:05:14', null, null);
INSERT INTO `user_learn_record` VALUES ('7', '1', '1', '2020-10-10 15:55:19', null, null);
INSERT INTO `user_learn_record` VALUES ('8', '1', '1', '2020-10-10 15:55:26', null, null);
INSERT INTO `user_learn_record` VALUES ('9', '1', '1', '2020-10-10 16:09:04', null, null);
INSERT INTO `user_learn_record` VALUES ('10', '1', '1', '2020-10-12 14:14:21', '1', '1');
INSERT INTO `user_learn_record` VALUES ('10', '5', '1', '2020-10-13 17:06:28', '1', '1');
INSERT INTO `user_learn_record` VALUES ('10', '7', '1', '2020-10-12 14:32:24', '1', '1');
INSERT INTO `user_learn_record` VALUES ('11', '2', '1', '2020-10-17 13:58:35', '1', '1');
INSERT INTO `user_learn_record` VALUES ('11', '5', '1', '2020-10-12 14:40:10', '1', '1');
INSERT INTO `user_learn_record` VALUES ('12', '5', '1', '2020-10-12 14:40:18', '1', '1');
INSERT INTO `user_learn_record` VALUES ('13', '1', '1', '2020-10-10 16:09:28', null, null);
INSERT INTO `user_learn_record` VALUES ('14', '1', '1', '2020-10-10 16:09:23', null, null);
