/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 80012
 Source Host           : localhost:3306
 Source Schema         : pbs_admin

 Target Server Type    : MySQL
 Target Server Version : 80012
 File Encoding         : 65001

 Date: 15/10/2020 21:22:25
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for cluster_master
-- ----------------------------
DROP TABLE IF EXISTS `cluster_master`;
CREATE TABLE `cluster_master`  (
  `id` varchar(63) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `cluster_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '集群名称',
  `master_ip` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '管理节点IP',
  `user_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '用户名',
  `user_pwd` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '密码',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of cluster_master
-- ----------------------------
INSERT INTO `cluster_master` VALUES ('028ec6cdf0454e128e8121904c15fce7', '青岛', '192.168.10.121', 'user1', 'zxy1997');
INSERT INTO `cluster_master` VALUES ('e1c029d5b0df479ba6b38bbf953f8044', '烟台', '10.9.10.11', 'admin', '123qwe');
INSERT INTO `cluster_master` VALUES ('fdf1625eac184458a8042dbaef8f7b1f', '济南', '10.8.7.11', 'root', '123456');

-- ----------------------------
-- Table structure for script_info
-- ----------------------------
DROP TABLE IF EXISTS `script_info`;
CREATE TABLE `script_info`  (
  `id` varchar(63) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `module_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '所属模块',
  `script_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '脚本名',
  `path` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '路径',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `modify_time` datetime(0) NULL DEFAULT NULL COMMENT '修改时间（最后一次）',
  `status` int(11) NULL DEFAULT NULL COMMENT '状态：0-禁用，1-可用',
  `remarks` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of script_info
-- ----------------------------
INSERT INTO `script_info` VALUES ('38ea12a5d7e04b42bfdade0587621d03', '2', 'test.sh', 'D:/root/pbs-admin/2/2020/1012/test.sh', '2020-10-12 19:07:02', NULL, 1, NULL);
INSERT INTO `script_info` VALUES ('39e76a733d24407493781fc4b68aacef', 'test', 'test.sh', 'D:/root/file/pbs-admin/test1/2020/1011/test.sh', '2020-10-11 10:56:16', NULL, 1, NULL);
INSERT INTO `script_info` VALUES ('8fadc8d7852e46a8acaf0d00127c4ad2', 'test', 'test.sh', 'D:/root/file/pbs-admin/111/2020/1012/test.sh', '2020-10-12 15:30:21', NULL, 1, NULL);

-- ----------------------------
-- Table structure for template
-- ----------------------------
DROP TABLE IF EXISTS `template`;
CREATE TABLE `template`  (
  `id` varchar(63) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `template_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '模板名',
  `content` longtext CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL COMMENT '模板内容',
  `remarks` text CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL COMMENT '备注',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of template
-- ----------------------------
INSERT INTO `template` VALUES ('376c135199d7482e9eb4fbf883e70b46', 't1', '#!/bin/sh #PBS -N test #PBS -M ltq.yaliang@stu.xjtu.edu.cn #PBS -m bae cd /home/yaliang/mpi //程序所在的路径 mpdboot -n 10 -f host mpicc -o mpi mpi.c mpiexec -machinefile host -n 2 ./mpi', '');
INSERT INTO `template` VALUES ('8fdac056a0bf49878d7ce1290fd7ea99', 'qstat', 'qstat', 'qstat');

SET FOREIGN_KEY_CHECKS = 1;
