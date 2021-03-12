/*
 Navicat MySQL Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 80023
 Source Host           : localhost:3306
 Source Schema         : library_manager_system

 Target Server Type    : MySQL
 Target Server Version : 80023
 File Encoding         : 65001

 Date: 11/03/2021 21:12:25
*/


SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;
CREATE DATABASE IF NOT EXISTS library_manager_system DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci;
USE library_manager_system;
-- ----------------------------
-- Table structure for admin
-- ----------------------------
DROP TABLE IF EXISTS `admin`;
CREATE TABLE `admin`  (
  `admin_id` int NOT NULL AUTO_INCREMENT,
  `admin_name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL unique,
  `admin_pwd` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `admin_email` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`admin_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of admin
-- ----------------------------
INSERT INTO `admin` VALUES (1, 'admin', 'admin', '501455447@qq.com');

-- ----------------------------
-- Table structure for book
-- ----------------------------
DROP TABLE IF EXISTS `book`;
CREATE TABLE `book`  (
  `book_id` int NOT NULL AUTO_INCREMENT,
  `book_name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `book_author` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `book_publish` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `book_category` int NULL DEFAULT NULL,
  `book_price` double NULL DEFAULT NULL,
  `book_introduction` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`book_id`) USING BTREE,
  INDEX `book_category`(`book_category`) USING BTREE,
  CONSTRAINT `book_ibfk_1` FOREIGN KEY (`book_category`) REFERENCES `book_category` (`category_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 72 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of book
-- ----------------------------
INSERT INTO `book` VALUES (1, '巨人的陨落', '肯.福莱特', '江苏凤凰文艺出版社', 1, 129, '在第一次世界大战中发生的故事');
INSERT INTO `book` VALUES (2, '三体', '刘慈欣', '南京大学出版社', 1, 68, '科幻小说');
INSERT INTO `book` VALUES (3, '复活', '列夫.托尔斯泰', '上海译文出版社', 1, 19, '俄国小说');
INSERT INTO `book` VALUES (6, '平凡的世界', '路遥', '上海文艺出版社', 1, 88, '孙少平和孙少安两兄弟...');
INSERT INTO `book` VALUES (15, '白鹿原', '陈忠实', '南京出版社', 1, 36, '当代小说');
INSERT INTO `book` VALUES (16, '计算机网络', '谢希仁', '电子工业出版社', 2, 49, '计算机专业书籍');
INSERT INTO `book` VALUES (17, '霍乱时期的爱情', '加西亚·马尔克斯', '译林出版社', 4, 39, '外国小说');
INSERT INTO `book` VALUES (18, '天才在左疯子在右', '高铭', '北京联合出版公司', 1, 39.8, '心理学');
INSERT INTO `book` VALUES (19, '废都', '贾平凹', '商务印书馆', 3, 29, '当代小说');
INSERT INTO `book` VALUES (20, 'jQuery', 'Ryan', '中国电力出版社', 2, 78, 'js库');
INSERT INTO `book` VALUES (21, 'python数据爬虫', '张博文', '清华大学出版社', 2, 52, '带你走进爬虫的世界');
INSERT INTO `book` VALUES (22, '入门python可视化', 'variation', '电子大学出版社', 3, 61, '探究数据背后的秘密');
INSERT INTO `book` VALUES (71, 'Springboot从入门到实践', '筱威', '北京大学出版社', 2, 78, '带你走进spirngboot');

-- ----------------------------
-- Table structure for book_category
-- ----------------------------
DROP TABLE IF EXISTS `book_category`;
CREATE TABLE `book_category`  (
  `category_id` int NOT NULL AUTO_INCREMENT,
  `category_name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL unique,
  PRIMARY KEY (`category_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 18 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of book_category
-- ----------------------------
INSERT INTO `book_category` VALUES (1, '小说');
INSERT INTO `book_category` VALUES (2, '计算机');
INSERT INTO `book_category` VALUES (3, '中国文学');
INSERT INTO `book_category` VALUES (4, '外国文学');

-- ----------------------------
-- Table structure for borrowingbooks
-- ----------------------------
DROP TABLE IF EXISTS `borrowingbooks`;
CREATE TABLE `borrowingbooks`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `user_id` int NULL DEFAULT NULL,
  `book_id` int NULL DEFAULT NULL,
  `date` date NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `user_id`(`user_id`) USING BTREE,
  INDEX `book_id`(`book_id`) USING BTREE,
  CONSTRAINT `borrowingbooks_ibfk_1` FOREIGN KEY (`book_id`) REFERENCES `book` (`book_id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `borrowingbooks_ibfk_2` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 64 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of borrowingbooks
-- ----------------------------

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `user_id` int NOT NULL AUTO_INCREMENT,
  `user_name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL unique,
  `user_pwd` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `user_email` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`user_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 23 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (1, 'user1', 'user1', '501455447@qq.com');

SET FOREIGN_KEY_CHECKS = 1;
