## init article
INSERT INTO `toyBlog`.`article`(`article_id`, `article_authors`, `article_content`, `article_input_date`, `article_name`, `article_reading_time`, `is_enable`, `is_top`) VALUES (1, 'dalaoyang', '这是第一篇博客的摘要。这是第一篇博客的摘要。这是第一篇博客的摘要。这是第一篇博客的摘要。这是第一篇博客的摘要。这是第一篇博客的摘要。这是第一篇博客的摘要。', '2019-01-01 00:00:00', '第一篇博客', 1, 1, 1);
INSERT INTO `toyBlog`.`article`(`article_id`, `article_authors`, `article_content`, `article_input_date`, `article_name`, `article_reading_time`, `is_enable`, `is_top`) VALUES (2, 'dalaoyang', '这是第二篇博客的摘要。这是第二篇博客的摘要。这是第二篇博客的摘要。这是第二篇博客的摘要。这是第二篇博客的摘要。这是第二篇博客的摘要。这是第二篇博客的摘要。', '2019-01-01 00:00:00', '第二篇博客', 1, 1, 1);
INSERT INTO `toyBlog`.`article`(`article_id`, `article_authors`, `article_content`, `article_input_date`, `article_name`, `article_reading_time`, `is_enable`, `is_top`) VALUES (3, 'dalaoyang', '这是第三篇博客的摘要。这是第三篇博客的摘要。这是第三篇博客的摘要。这是第三篇博客的摘要。这是第三篇博客的摘要。这是第三篇博客的摘要。这是第三篇博客的摘要。', '2019-01-01 00:00:00', '第三篇博客', 1, 1, 1);
INSERT INTO `toyBlog`.`article`(`article_id`, `article_authors`, `article_content`, `article_input_date`, `article_name`, `article_reading_time`, `is_enable`, `is_top`) VALUES (4, 'dalaoyang', '这是第四篇博客的摘要。这是第四篇博客的摘要。这是第四篇博客的摘要。这是第四篇博客的摘要。这是第四篇博客的摘要。这是第四篇博客的摘要。这是第四篇博客的摘要。', '2019-01-01 00:00:00', '第四篇博客', 1, 1, 1);
INSERT INTO `toyBlog`.`article`(`article_id`, `article_authors`, `article_content`, `article_input_date`, `article_name`, `article_reading_time`, `is_enable`, `is_top`) VALUES (5, 'dalaoyang', '这是第五篇博客的摘要。这是第五篇博客的摘要。这是第五篇博客的摘要。这是第五篇博客的摘要。这是第五篇博客的摘要。这是第五篇博客的摘要。这是第五篇博客的摘要。', '2019-01-01 00:00:00', '第五篇博客', 1, 1, 1);
INSERT INTO `toyBlog`.`article`(`article_id`, `article_authors`, `article_content`, `article_input_date`, `article_name`, `article_reading_time`, `is_enable`, `is_top`) VALUES (6, 'dalaoyang', '这是第六篇博客的摘要。这是第六篇博客的摘要。这是第六篇博客的摘要。这是第六篇博客的摘要。这是第六篇博客的摘要。这是第六篇博客的摘要。这是第六篇博客的摘要。', '2019-01-01 00:00:00', '第六篇博客', 1, 1, 1);
INSERT INTO `toyBlog`.`article`(`article_id`, `article_authors`, `article_content`, `article_input_date`, `article_name`, `article_reading_time`, `is_enable`, `is_top`) VALUES (7, 'dalaoyang', '大家好，我是TOY BLOG的作者蔡鹏飞，感谢大家对我的支持，谢谢。\n\n', '2019-12-15', 'About CAI PENGFEI!\n\n', 0, 0, 0);
## init link
INSERT INTO `toyBlog`.`link`(`link_id`, `link_name`, `link_url`, `remark`) VALUES (1, 'GITHUB', 'https://github.com/ElectroMaster-level5', 'GITHUB地址');
INSERT INTO `toyBlog`.`link`(`link_id`, `link_name`, `link_url`, `remark`) VALUES (2, 'GITLAB', 'https://gitlab.com/ElectroMaster', 'GITLAB地址');
## init tag
INSERT INTO `toyBlog`.`tag`(`tag_id`, `tag_name`) VALUES (1, 'SpringBoot');
INSERT INTO `toyBlog`.`tag`(`tag_id`, `tag_name`) VALUES (2, 'SpringCloud');
INSERT INTO `toyBlog`.`tag`(`tag_id`, `tag_name`) VALUES (3, 'Nginx');
INSERT INTO `toyBlog`.`tag`(`tag_id`, `tag_name`) VALUES (4, 'Linux');
INSERT INTO `toyBlog`.`tag`(`tag_id`, `tag_name`) VALUES (5, 'Tomcat');
INSERT INTO `toyBlog`.`tag`(`tag_id`, `tag_name`) VALUES (6, 'Java');
## init article_tag
INSERT INTO `toyBlog`.`article_tag`(`article_id`, `tag_id`) VALUES (1, 1);
INSERT INTO `toyBlog`.`article_tag`(`article_id`, `tag_id`) VALUES (1, 3);
INSERT INTO `toyBlog`.`article_tag`(`article_id`, `tag_id`) VALUES (2, 3);
INSERT INTO `toyBlog`.`article_tag`(`article_id`, `tag_id`) VALUES (2, 6);
INSERT INTO `toyBlog`.`article_tag`(`article_id`, `tag_id`) VALUES (3, 1);
INSERT INTO `toyBlog`.`article_tag`(`article_id`, `tag_id`) VALUES (4, 2);
INSERT INTO `toyBlog`.`article_tag`(`article_id`, `tag_id`) VALUES (5, 1);
INSERT INTO `toyBlog`.`article_tag`(`article_id`, `tag_id`) VALUES (6, 2);

## maybe error----------
##init website_config
INSERT INTO `toyBlog`.`website_config`(`id`, `about_page_article_id`, `author_name`, `blog_name`, `email_username`,  `domain_name`, `record_number`) VALUES (1, 7, 'CAI PENGFEI', 'TOY BLOG', 'caipengfei_ecpkn@outlook.com',  'MoonRabbit.com', 'xxxxxxxxxx');
##init website_access
INSERT INTO `toyBlog`.`website_access`(`id`, `access_count`, `access_date`) VALUES (1, 0, now());
