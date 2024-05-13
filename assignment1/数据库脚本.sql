/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 80032
Source Host           : localhost:3306
Source Database       : xiaoshou

Target Server Type    : MYSQL
Target Server Version : 80032
File Encoding         : 65001

Date: 2023-05-11 10:27:07
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for t_shangping
-- ----------------------------
DROP TABLE IF EXISTS `t_shangping`;
CREATE TABLE `t_shangping` (
  `tiaoma` varchar(255) NOT NULL,
  `mingcheng` varchar(255) DEFAULT NULL,
  `danjia` decimal(10,2) DEFAULT NULL,
  `gongyingshang` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`tiaoma`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of t_shangping
-- ----------------------------
INSERT INTO `t_shangping` VALUES ('100001', '手机', '4500.00', '华为');
INSERT INTO `t_shangping` VALUES ('100002', '鼠标', '61.00', '华为');
INSERT INTO `t_shangping` VALUES ('100003', '矿泉水', '2.50', '农夫山泉');
INSERT INTO `t_shangping` VALUES ('100004', '香烟', '20.00', '武汉卷烟厂');
INSERT INTO `t_shangping` VALUES ('100005', '牙膏', '4.50', '中华牙膏厂');
INSERT INTO `t_shangping` VALUES ('200001', '电脑', '4300.00', 'dell');
INSERT INTO `t_shangping` VALUES ('200002', '小明同学', '5.50', '武汉饮料集团');

-- ----------------------------
-- Table structure for t_shouyinmingxi
-- ----------------------------
DROP TABLE IF EXISTS `t_shouyinmingxi`;
CREATE TABLE `t_shouyinmingxi` (
  `liushuihao` varchar(255) NOT NULL,
  `tiaoma` varchar(255) DEFAULT NULL,
  `mingcheng` varchar(255) DEFAULT NULL,
  `danjia` decimal(10,0) DEFAULT NULL,
  `shuliang` int DEFAULT NULL,
  `shouyinyuan` varchar(255) DEFAULT NULL,
  `xiaoshoushijian` datetime DEFAULT NULL,
  PRIMARY KEY (`liushuihao`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of t_shouyinmingxi
-- ----------------------------

-- ----------------------------
-- Table structure for t_yonghu
-- ----------------------------
DROP TABLE IF EXISTS `t_yonghu`;
CREATE TABLE `t_yonghu` (
  `yonghuming` varchar(255) NOT NULL,
  `mima` varchar(255) DEFAULT NULL,
  `xingming` varchar(255) DEFAULT NULL,
  `juese` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`yonghuming`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of t_yonghu
-- ----------------------------
INSERT INTO `t_yonghu` VALUES ('niegang', null, '聂刚', '管理员');
INSERT INTO `t_yonghu` VALUES ('wangyuxin', null, '王玉欣', '收银员');
INSERT INTO `t_yonghu` VALUES ('xiaowang', null, '小王', '收银员');
