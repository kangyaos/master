/*
Navicat MySQL Data Transfer

Source Server         : 199_copy
Source Server Version : 50505
Source Host           : 172.16.99.199:3306
Source Database       : test

Target Server Type    : MYSQL
Target Server Version : 50505
File Encoding         : 65001

Date: 2020-09-25 17:03:47
*/

SET FOREIGN_KEY_CHECKS=0;

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
) ENGINE=InnoDB AUTO_INCREMENT=2763 DEFAULT CHARSET=utf8 COMMENT='新闻文章基本信息表';

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
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8 COMMENT='新闻栏目表';

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
-- Table structure for user_info
-- ----------------------------
DROP TABLE IF EXISTS `user_info`;
CREATE TABLE `user_info` (
  `user_id` int(11) NOT NULL COMMENT '用户id',
  `role_id` int(11) NOT NULL COMMENT '角色id',
  `user_name` varchar(50) NOT NULL COMMENT '用户名',
  `nickname` varchar(50) NOT NULL COMMENT '昵称',
  `signature` varchar(20) DEFAULT NULL COMMENT '个性签名',
  `user_pwd` varchar(50) DEFAULT NULL COMMENT '密码:6~18位',
  `head_pic_code` varchar(50) DEFAULT NULL COMMENT '头像照片代码',
  `head_portrait` int(11) DEFAULT NULL COMMENT '头像',
  `user_mobile` varchar(20) DEFAULT NULL COMMENT '移动电话',
  `machine_code` varchar(50) DEFAULT NULL COMMENT '机器码',
  `region_code` int(11) DEFAULT NULL COMMENT '行政区划代码',
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户基本信息表';
