/*
 Navicat Premium Data Transfer

 Source Server         : localMySql
 Source Server Type    : MySQL
 Source Server Version : 50710
 Source Host           : localhost:3307
 Source Schema         : bg

 Target Server Type    : MySQL
 Target Server Version : 50710
 File Encoding         : 65001

 Date: 13/10/2020 12:48:04
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for banner
-- ----------------------------
DROP TABLE IF EXISTS `banner`;
CREATE TABLE `banner`  (
  `banner_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '广告id',
  `title` varchar(10) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '模块标题',
  `title_sm` varchar(100) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '模块子标题',
  `file_id` bigint(100) NOT NULL COMMENT '广告图片文件信息',
  `is_use` varchar(64) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL DEFAULT '0' COMMENT '是否在使用',
  `create_time` datetime(0) NOT NULL COMMENT '创建时间',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`banner_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for group_composition
-- ----------------------------
DROP TABLE IF EXISTS `group_composition`;
CREATE TABLE `group_composition`  (
  `composition_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `title` varchar(10) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '模块标题',
  `title_sm` varchar(30) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '模块子标题',
  `file_id` bigint(100) NOT NULL COMMENT '图片文件信息',
  `is_use` int(1) NOT NULL COMMENT '是否在使用',
  `create_time` datetime(0) NOT NULL COMMENT '创建时间',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`composition_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_bin COMMENT = '集团构成' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for group_info
-- ----------------------------
DROP TABLE IF EXISTS `group_info`;
CREATE TABLE `group_info`  (
  `info_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '简介id',
  `title` varchar(10) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '模块标题',
  `title_sm` varchar(100) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '模块子标题',
  `content` varchar(1024) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '内容',
  `file_id` bigint(100) NOT NULL COMMENT '简介图片文件信息',
  `in_mode` varchar(64) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '在某个模块使用',
  `is_use` varchar(64) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL DEFAULT '0' COMMENT '是否在使用',
  `create_time` datetime(0) NOT NULL COMMENT '创建时间',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`info_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_bin COMMENT = '集团简介' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for news
-- ----------------------------
DROP TABLE IF EXISTS `news`;
CREATE TABLE `news`  (
  `news_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '新闻id',
  `title` varchar(10) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '标题',
  `title_sm` varchar(100) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '子标题',
  `content` text CHARACTER SET utf8 COLLATE utf8_bin NULL COMMENT '新闻内容',
  `create_time` datetime(0) NOT NULL COMMENT '创建时间',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`news_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_bin COMMENT = '新闻' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for partner
-- ----------------------------
DROP TABLE IF EXISTS `partner`;
CREATE TABLE `partner`  (
  `p_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `title` varchar(32) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '标题',
  `title_sm` varchar(64) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '子标题',
  `file_id` bigint(100) NULL DEFAULT NULL COMMENT '文件id',
  `is_use` varchar(64) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT '1' COMMENT '元素状态 1正在使用 0未使用',
  `create_time` datetime(0) NOT NULL COMMENT '创建时间',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`p_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 10 CHARACTER SET = utf8 COLLATE = utf8_bin COMMENT = '合作伙伴' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for sys_dict_data
-- ----------------------------
DROP TABLE IF EXISTS `sys_dict_data`;
CREATE TABLE `sys_dict_data`  (
  `data_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '字典数据id',
  `dict_type` varchar(64) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '字典类型',
  `label` varchar(64) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '标签',
  `value` varchar(64) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '值',
  `create_time` datetime(0) NOT NULL COMMENT '创建时间',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '修改时间',
  `remark` varchar(1024) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '数据描述',
  PRIMARY KEY (`data_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 7 CHARACTER SET = utf8 COLLATE = utf8_bin COMMENT = '字典数据表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for sys_dict_type
-- ----------------------------
DROP TABLE IF EXISTS `sys_dict_type`;
CREATE TABLE `sys_dict_type`  (
  `dict_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `dict_type` varchar(64) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '字典类型',
  `dict_name` varchar(32) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '字典名称',
  `is_disabled` varchar(64) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL DEFAULT '0' COMMENT '是否禁用',
  `remark` varchar(1024) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '字典描述',
  `create_time` datetime(0) NOT NULL COMMENT '创建时间',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`dict_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_bin COMMENT = '字典类型表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for sys_file
-- ----------------------------
DROP TABLE IF EXISTS `sys_file`;
CREATE TABLE `sys_file`  (
  `file_id` bigint(100) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `original_name` varchar(200) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '原文件名',
  `name` char(40) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '文件名',
  `content_type` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '文件类型',
  `file_type` varchar(20) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '文件类型',
  `path` varchar(1024) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '文件路径',
  `file_size` varchar(20) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '文件大小',
  `MD5` varchar(32) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '文件MD5摘要',
  `create_time` datetime(0) NOT NULL COMMENT '创建时间',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '修改时间',
  `is_delete` varchar(64) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL DEFAULT '0' COMMENT '是否被删除',
  PRIMARY KEY (`file_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 16 CHARACTER SET = utf8 COLLATE = utf8_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for sys_icon
-- ----------------------------
DROP TABLE IF EXISTS `sys_icon`;
CREATE TABLE `sys_icon`  (
  `icon_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '图标id',
  `class_name` varchar(32) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '图标class',
  `create_time` datetime(0) NOT NULL COMMENT '创建时间',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`icon_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 281 CHARACTER SET = utf8 COLLATE = utf8_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for sys_menu
-- ----------------------------
DROP TABLE IF EXISTS `sys_menu`;
CREATE TABLE `sys_menu`  (
  `menu_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `parent_id` bigint(20) NULL DEFAULT NULL COMMENT '父菜单id',
  `parent_ids` varchar(32) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '父菜单ids',
  `order_num` int(32) NOT NULL COMMENT '排序',
  `type` char(1) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '菜单类型(M 菜单 B按钮)',
  `name` varchar(16) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '菜单名',
  `icon` varchar(32) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '菜单图标',
  `component` varchar(64) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '组件路径',
  `path` varchar(32) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '路由路径',
  `target` varchar(16) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '目标窗口',
  `status` varchar(64) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL DEFAULT '1' COMMENT '菜单状态',
  `create_time` datetime(0) NOT NULL COMMENT '创建日期',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '修改日期',
  PRIMARY KEY (`menu_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 12 CHARACTER SET = utf8 COLLATE = utf8_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for sys_user
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user`  (
  `user_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '用户id',
  `nickname` varchar(16) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '昵称',
  `sex` char(1) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '用户性别',
  `portrait` bigint(100) NULL DEFAULT NULL COMMENT '头像',
  `login_name` varchar(20) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '登陆账号',
  `e_mail` varchar(20) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '邮箱',
  `number` char(11) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '手机号',
  `password` varchar(32) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '密码',
  `salt` char(4) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '盐值',
  `status` int(1) NOT NULL DEFAULT 0 COMMENT '状态 （0 正常 1禁用）',
  `create_time` datetime(0) NOT NULL COMMENT '创建时间',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`user_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for trait
-- ----------------------------
DROP TABLE IF EXISTS `trait`;
CREATE TABLE `trait`  (
  `trait_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '特点id',
  `title` varchar(10) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '标题',
  `title_sm` varchar(100) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '子标题',
  `content` varchar(64) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '内容',
  `file_id` bigint(100) NULL DEFAULT NULL COMMENT '图片文件信息',
  `is_use` varchar(64) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL DEFAULT '0' COMMENT '是否使用',
  `create_time` datetime(0) NOT NULL COMMENT '创建时间',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`trait_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 14 CHARACTER SET = utf8 COLLATE = utf8_bin ROW_FORMAT = Dynamic;

SET FOREIGN_KEY_CHECKS = 1;
