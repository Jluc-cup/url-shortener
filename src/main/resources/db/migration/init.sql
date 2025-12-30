CREATE TABLE IF NOT EXISTS `user` (
    `id` INT AUTO_INCREMENT PRIMARY KEY,
    `email` VARCHAR(255) NOT NULL UNIQUE,
    `password` VARCHAR(255) NOT NULL,
    `created` TIMESTAMP NOT NULL
);


CREATE TABLE IF NOT EXISTS `url` (
    `id` INT AUTO_INCREMENT PRIMARY KEY,
    `original_url` VARCHAR(2048) NOT NULL,
    `domain` VARCHAR(255),
    `region` VARCHAR(255),
    `created` TIMESTAMP NOT NULL
);


CREATE TABLE IF NOT EXISTS `url_short` (
    `id` INT AUTO_INCREMENT PRIMARY KEY,
    `user_id` INT NOT NULL,
    `url_id` INT NOT NULL,
    `original_url` VARCHAR(2048) NOT NULL,
    `custom_alias` VARCHAR(120),
    `short_url` VARCHAR(255) NOT NULL UNIQUE,
    `click_count` INT DEFAULT 0,
    `created` TIMESTAMP NOT NULL,
    `deleted` TIMESTAMP DEFAULT NULL,
    CONSTRAINT `fk_url_short_user_id` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`),
    CONSTRAINT `fk_url_short_url_id` FOREIGN KEY (`url_id`) REFERENCES `url` (`id`)
);


CREATE TABLE IF NOT EXISTS `url_short_click` (
    `id` INT AUTO_INCREMENT PRIMARY KEY,
    `url_short_id` INT NOT NULL,
    `ip_address` VARCHAR(45),
    `country_code` VARCHAR(2),
    `device_type` VARCHAR(50),
    `browser` VARCHAR(255),
    `created` TIMESTAMP NOT NULL,
    CONSTRAINT `fk_url_short_click_url_short_id` FOREIGN KEY (`url_short_id`) REFERENCES `url_short` (`id`)
);

CREATE TABLE IF NOT EXISTS `token` (
    `id` INT AUTO_INCREMENT PRIMARY KEY,
    `user_id` INT NOT NULL,
    `token` VARCHAR(512) NOT NULL UNIQUE,
    `created` TIMESTAMP NOT NULL,
    CONSTRAINT `fk_token_user_id` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`)
);
