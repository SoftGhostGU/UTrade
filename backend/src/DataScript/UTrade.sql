-- 创建数据库
CREATE DATABASE IF NOT EXISTS utrade;

-- 使用数据库
USE utrade;

-- 创建用户表
CREATE TABLE IF NOT EXISTS Users
(
    UserID           INT AUTO_INCREMENT PRIMARY KEY,
    Nickname         VARCHAR(255) NOT NULL,
    AvatarURL        VARCHAR(255),
    Email            VARCHAR(255) UNIQUE,
    Password         VARCHAR(255) NOT NULL,
    RegistrationDate TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- 添加用户
INSERT INTO Users (Nickname, AvatarURL, Email, Password)
VALUES ('user1', 'https://s21.ax1x.com/2025/03/02/pEGVjw4.jpg', 'user1@example.com', 'encrypted_password1'),
       ('user2', 'https://s21.ax1x.com/2025/03/02/pEGVjw4.jpg', 'user2@example.com', 'encrypted_password2'),
       ('user3', 'https://s21.ax1x.com/2025/03/02/pEGVjw4.jpg', 'user3@example.com', 'encrypted_password3');


-- 创建技能表
CREATE TABLE IF NOT EXISTS Skills
(
    SkillID       INT AUTO_INCREMENT PRIMARY KEY,
    UserID        INT          NOT NULL,
    Title         VARCHAR(255) NOT NULL,
    Description   TEXT,
    Category      VARCHAR(255),
    Tags          VARCHAR(255),
    TimeCoin      INT,
    AvailableTime VARCHAR(255),
    CreatedAt     TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (UserID) REFERENCES Users (UserID)
);

-- 添加技能
INSERT INTO Skills (UserID, Title, Description, Category, Tags, TimeCoin, AvailableTime)
VALUES (1, 'PPT制作', '精通PPT设计，可制作专业演示文稿', '办公技能', 'PPT,设计', 2, '每周一三晚上'),
       (2, '美工', '熟练掌握Photoshop，可进行图像编辑和设计', '设计类', 'Photoshop,美工', 3, '周末全天'),
       (3, '剪辑', '视频剪辑，可制作短视频和宣传片', '视频类', '剪辑,视频', 1, '工作日白天');


-- 创建交换请求表
CREATE TABLE IF NOT EXISTS ExchangeRequests
(
    RequestID    INT AUTO_INCREMENT PRIMARY KEY,
    SkillID      INT NOT NULL,
    TargetUserID INT NOT NULL,
    Message      TEXT,
    Status       ENUM ('Pending', 'Accepted', 'Rejected') DEFAULT 'Pending',
    CreatedAt    TIMESTAMP                                DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (SkillID) REFERENCES Skills (SkillID),
    FOREIGN KEY (TargetUserID) REFERENCES Users (UserID)
);

-- 添加交换请求
INSERT INTO ExchangeRequests (SkillID, TargetUserID, Message)
VALUES (1, 3, '你好，我对你的剪辑技能很感兴趣，我们可以交换PPT制作技能吗？'),
       (2, 1, '我对你的PPT制作技能感兴趣，愿意用美工技能交换。');

-- 创建时间币表
CREATE TABLE IF NOT EXISTS TimeCoins
(
    UserID  INT NOT NULL,
    Balance INT DEFAULT 0,
    FOREIGN KEY (UserID) REFERENCES Users (UserID)
);

-- 添加时间币
INSERT INTO TimeCoins (UserID, Balance)
VALUES (1, 10),
       (2, 15),
       (3, 5);

-- 创建消息表
CREATE TABLE IF NOT EXISTS Notifications
(
    NotificationID INT AUTO_INCREMENT PRIMARY KEY,
    UserID         INT          NOT NULL,
    Type           VARCHAR(255) NOT NULL,
    Content        TEXT         NOT NULL,
    IsRead         BOOLEAN   DEFAULT FALSE,
    CreatedAt      TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (UserID) REFERENCES Users (UserID)
);

-- 添加消息通知
INSERT INTO Notifications (UserID, Type, Content, IsRead)
VALUES (1, 'exchange_request', '你收到了一个技能交换请求', FALSE),
       (2, 'exchange_request', '你收到了一个技能交换请求', FALSE),
       (3, 'system', '你的技能被用户2收藏了', FALSE);

-- 创建收藏表
CREATE TABLE IF NOT EXISTS Favorites
(
    FavoriteID INT AUTO_INCREMENT PRIMARY KEY,
    UserID     INT NOT NULL,
    SkillID    INT NOT NULL,
    FOREIGN KEY (UserID) REFERENCES Users (UserID),
    FOREIGN KEY (SkillID) REFERENCES Skills (SkillID)
);

-- 添加收藏
INSERT INTO Favorites (UserID, SkillID)
VALUES (2, 1),
       (3, 2);
