/*
Navicat MySQL Data Transfer

Source Server         : 199_copy
Source Server Version : 50505
Source Host           : 172.16.99.199:3306
Source Database       : test

Target Server Type    : MYSQL
Target Server Version : 50505
File Encoding         : 65001

Date: 2020-10-21 14:30:22
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
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='操作日志';

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
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COMMENT='新闻栏目表';

-- ----------------------------
-- Records of operate_article_category
-- ----------------------------
INSERT INTO `operate_article_category` VALUES ('1', '学校新闻', null, null, '1', '0', null, '0', '0', '2020-09-26 11:00:31', '0');
INSERT INTO `operate_article_category` VALUES ('2', '通知公告', null, null, '3', '0', null, '0', '0', '2020-09-26 11:01:18', '0');
INSERT INTO `operate_article_category` VALUES ('3', '媒体报道', null, null, '3', '0', null, '0', '0', '2020-09-26 11:04:23', '0');

-- ----------------------------
-- Table structure for questionnaire
-- ----------------------------
DROP TABLE IF EXISTS `questionnaire`;
CREATE TABLE `questionnaire` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `reamrk` varchar(1000) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `start_time` datetime DEFAULT NULL,
  `end_time` datetime DEFAULT NULL,
  `delete_flag` int(1) DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='调查卷';

-- ----------------------------
-- Records of questionnaire
-- ----------------------------
INSERT INTO `questionnaire` VALUES ('1', '大学生压力来源及解压方式调查', '为了了解大学生压力来源及解压方法，我们正在做一份有关调查，希望您在百忙之中抽出一点点时间为我们填一下，诚挚的感谢！', '2020-10-21 13:46:06', '2020-10-21 13:46:09', '2020-10-20 13:46:10', '2020-11-05 13:46:13', '0');

-- ----------------------------
-- Table structure for questionnaire_question
-- ----------------------------
DROP TABLE IF EXISTS `questionnaire_question`;
CREATE TABLE `questionnaire_question` (
  `naire_id` int(11) NOT NULL,
  `question_id` int(11) NOT NULL,
  PRIMARY KEY (`naire_id`,`question_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of questionnaire_question
-- ----------------------------
INSERT INTO `questionnaire_question` VALUES ('1', '0');
INSERT INTO `questionnaire_question` VALUES ('1', '2');
INSERT INTO `questionnaire_question` VALUES ('1', '3');
INSERT INTO `questionnaire_question` VALUES ('1', '4');
INSERT INTO `questionnaire_question` VALUES ('1', '5');

-- ----------------------------
-- Table structure for question_info
-- ----------------------------
DROP TABLE IF EXISTS `question_info`;
CREATE TABLE `question_info` (
  `question_id` int(255) NOT NULL AUTO_INCREMENT,
  `question_type` int(255) DEFAULT '0' COMMENT '试题类型  0单选 1多选',
  `question` varchar(255) DEFAULT NULL COMMENT '题干',
  `option_num` int(11) DEFAULT NULL COMMENT '选项数',
  `option_a` varchar(255) DEFAULT NULL,
  `option_b` varchar(255) DEFAULT NULL,
  `option_c` varchar(255) DEFAULT NULL,
  `option_d` varchar(255) DEFAULT NULL,
  `option_e` varchar(255) DEFAULT NULL,
  `answer` varchar(255) DEFAULT NULL COMMENT '答案   多选时,号隔开',
  `create_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `delete_flag` int(1) unsigned zerofill DEFAULT '0',
  PRIMARY KEY (`question_id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of question_info
-- ----------------------------
INSERT INTO `question_info` VALUES ('1', '0', '请问你的性别是?', '2', '男', '女', null, null, null, null, '2020-10-21 13:41:31', '2020-10-21 13:41:31', '0');
INSERT INTO `question_info` VALUES ('2', '0', '请问你的年级是?', '4', '大一', '大二', '大三', '大四', null, null, '2020-10-21 13:41:31', '2020-10-21 13:41:31', '0');
INSERT INTO `question_info` VALUES ('3', '0', '你觉得上大学后，所承受的压力跟以前相比有何变化?', '3', '一点点', '有', '没有', null, null, null, '2020-10-21 13:41:31', '2020-10-21 13:41:31', '0');
INSERT INTO `question_info` VALUES ('4', '1', '总的来说，你认为给你带来最大压力的是哪个方面? [多选题]', '4', '学习', '生活', '情感', '其他', null, null, '2020-10-21 13:41:31', '2020-10-21 13:41:31', '0');
INSERT INTO `question_info` VALUES ('5', '1', '家庭方面：你认为以下给你带来较大压力的有? [多选题]', '4', '学习', '其他1', '其他2', '其他', null, null, '2020-10-21 13:41:31', '2020-10-21 13:41:31', '0');

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
) ENGINE=InnoDB AUTO_INCREMENT=209 DEFAULT CHARSET=utf8 COMMENT='系统模块表';

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
  PRIMARY KEY (`naire_id`,`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user_answer_record
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
