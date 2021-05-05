DROP TABLE `user_info` ;


CREATE TABLE `user_info` (
  `id` BIGINT(20) NOT NULL AUTO_INCREMENT COMMENT '自增主键',
  `open_id` varchar(127) NOT NULL DEFAULT '' COMMENT '用户OPENID',
  `nick_name` varchar(30) NOT NULL DEFAULT '' COMMENT '用户昵称',
  `gender` tinyint(4) NOT NULL DEFAULT '0' COMMENT '性别，0：未知，1：男，2：女',
  `avata_url` varchar(300) NOT NULL DEFAULT '' COMMENT '用户头像地址',
  `language` varchar(50) NOT NULL DEFAULT '' COMMENT '语言',
  `country` varchar(127) NOT NULL DEFAULT '' COMMENT '国家',
  `city` varchar(127) NOT NULL DEFAULT '' COMMENT '城市',
  `province` varchar(127) NOT NULL DEFAULT '' COMMENT '省份',
  `email` varchar(127) NOT NULL DEFAULT '' COMMENT '用户EMAIL',
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '修改时间，一般情况为EMAIL修改',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '用户注册时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8 COMMENT='用户信息表';

CREATE TABLE `author_info` (
  `id` BIGINT(20) NOT NULL AUTO_INCREMENT COMMENT '自增主键',
  `author_id` VARCHAR(127) NOT NULL DEFAULT '' COMMENT '作者ID',
  `name` VARCHAR(127) NOT NULL DEFAULT '' COMMENT '作者名',
  `introduce` TEXT NOT NULL DEFAULT '' COMMENT '作者介绍',
  `dynasty` VARCHAR(127) NOT NULL DEFAULT '' COMMENT '朝代',
  `create_time` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  PRIMARY KEY(`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8 COMMENT='作者表';

CREATE TABLE `article_category_index`(
  `id` BIGINT(20) NOT NULL AUTO_INCREMENT COMMENT '自增主键',
  `category_id` VARCHAR(127) NOT NULL DEFAULT '' COMMENT '文章类型ID',
  `category_name` VARCHAR(127) NOT NULL DEFAULT '' COMMENT '文章类型名',
  `category_level` TINYINT(4) NOT NULL DEFAULT 0 COMMENT '类型等级，1：一级目录，2：二级目录，0：默认',
  `father_category` VARCHAR(127) NOT NULL DEFAULT '' COMMENT '父目录ID',
  `create_time` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `status` TINYINT(4) NOT NULL DEFAULT 0 COMMENT '可用状态，1：可用，2：不可用，0：默认状态',
  PRIMARY KEY(`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8 COMMENT='文章类目索引表';

CREATE TABLE `article_index`(
  `id` BIGINT(20) NOT NULL AUTO_INCREMENT COMMENT '自增主键',
  `article_id` VARCHAR(127) NOT NULL DEFAULT '' COMMENT '文章ID，古籍ID',
  `title` VARCHAR(1023) NOT NULL DEFAULT '' COMMENT '文章名，古籍名',
  `author_id` VARCHAR(127) NOT NULL DEFAULT '' COMMENT '作者ID',
  `author_name` VARCHAR(127) NOT NULL DEFAULT '' COMMENT '作者名',
  `category_id` VARCHAR(127) NOT NULL DEFAULT '' COMMENT '类目ID',
  `chapter_id_list` TEXT NOT NULL DEFAULT '' COMMENT '章节ID列表，有序',
  `status` TINYINT(4) NOT NULL DEFAULT 0 COMMENT '可用状态' ,
  `create_time` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8 COMMENT='文章索引表';

CREATE TABLE `article_chapter`(
  `id` BIGINT(20) NOT NULL AUTO_INCREMENT COMMENT '自增主键',
  `chapter_id` VARCHAR(127) NOT NULL DEFAULT '' COMMENT '章节ID',
  `title` VARCHAR(127) NOT NULL DEFAULT '' COMMENT '章节名',
  `field` TEXT NOT NULL DEFAULT '' COMMENT '段落JSON，有序',
  `belong_to` VARCHAR(127) NOT NULL DEFAULT '' COMMENT '所属文章ID',
  `marked_field` TEXT NOT NULL DEFAULT '' COMMENT '标注段落JSON，有序',
  `interpretation` TEXT NOT NULL DEFAULT '' COMMENT '解释JSON，有序',
  `create_time` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8 COMMENT='文章信息表';

CREATE TABLE `font_index`(
    `id` BIGINT(20) NOT NULL AUTO_INCREMENT COMMENT '自增主键',
    `font_id` VARCHAR(127) NOT NULL DEFAULT '' COMMENT '字体ID',
    `name` VARCHAR(127) NOT NULL DEFAULT '' COMMENT '字体名',
    `status` TINYINT NOT NULL DEFAULT 0 COMMENT '字体是否可用，0：不可用，1：可用' ,
    `create_time` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8 COMMENT='书法字体总表';

CREATE TABLE `calligrapher_info`(
  `id` BIGINT(20) NOT NULL AUTO_INCREMENT COMMENT '自增主键',
  `calligrapher_id` VARCHAR(127) NOT NULL DEFAULT '' COMMENT '书法家ID',
  `name` VARCHAR(127) NOT NULL DEFAULT '' COMMENT '书法家名',
  `introduce` TEXT NOT NULL DEFAULT '' COMMENT '书法家简介',
  `dynasty` VARCHAR(127) NOT NULL DEFAULT '' COMMENT '书法家朝代',
  `create_time` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8 COMMENT='书法家信息表';

CREATE TABLE `calligrapher_extension`(
  `id` BIGINT(20) NOT NULL AUTO_INCREMENT COMMENT '自增主键',
  `calligrapher_id` VARCHAR(127) NOT NULL DEFAULT '' COMMENT '书法家ID',
  `font_id` VARCHAR(127) NOT NULL DEFAULT '' COMMENT '字体ID',
  `url` TEXT NOT NULL DEFAULT '' COMMENT '字体加载地址',
  `status` TINYINT NOT NULL DEFAULT 0 COMMENT '字体是否可用，0：不可用，1：可用' ,
  `weight` TINYINT(4) NOT NULL DEFAULT 4 COMMENT '排序权重，越大越靠前,最小0，最大7',
  `create_time` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8 COMMENT='书法家字体表';

CREATE TABLE `user_feedback`(
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '自增主键',
  `open_id` varchar(127) NOT NULL DEFAULT '' COMMENT '用户ID',
  `title` text COMMENT '反馈标题',
  `content` text COMMENT '反馈内容',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '反馈提交时间',
  `response_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '反馈回复时间',
  `response_status` tinyint(4) NOT NULL DEFAULT '0' COMMENT '回复状态',
  `response_text` text COMMENT '回复内容',
  `read_status` tinyint(4) NOT NULL DEFAULT '0' COMMENT '已读状态，0：未读，1：已读',
  `feedback_type` tinyint(4) NOT NULL DEFAULT '0' COMMENT '反馈类型，0：默认反馈类型，1：用户反馈类型，2：试题错误反馈类型',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8 COMMENT='用户反馈表';

CREATE TABLE `user_browse_article_record`(
    `id` BIGINT(20) NOT NULL AUTO_INCREMENT COMMENT '自增主键',
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8 COMMENT='用户浏览文章记录表';

CREATE TABLE `user_browse_calligraphy_record`(
    `id` BIGINT(20) NOT NULL AUTO_INCREMENT COMMENT '自增主键',
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8 COMMENT='用户使用字体记录表';

CREATE TABLE `user_collect_article_record`(
    `id` BIGINT(20) NOT NULL AUTO_INCREMENT COMMENT '自增主键',
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8 COMMENT='用户收藏文章记录表';

CREATE TABLE `user_collect_calligraphy_record`(
    `id` BIGINT(20) NOT NULL AUTO_INCREMENT COMMENT '自增主键',
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8 COMMENT='用户收藏字体记录表';

