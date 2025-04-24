package com.ghost.backend.pojo;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.security.Timestamp;

public class User {

    private int userId;

    @NotNull(message = "OpenID 不能为空")
    @Size(max = 255, message = "OpenID 不能超过 255 个字符")
    private String openID;

    @NotNull(message = "Nickname 不能为空")
    @Size(max = 255, message = "Nickname 不能超过 255 个字符")
    private String nickname;

    @Size(max = 255, message = "AvatarURL 不能超过 255 个字符")
    private String avatarURL;

    @Email(message = "Email 格式不正确")
    @Size(max = 255, message = "Email 不能超过 255 个字符")
    private String email;

    @NotNull(message = "Password 不能为空")
    @Size(min = 6, max = 255, message = "Password 长度必须在 6 到 255 个字符之间")
    private String password;

    private Timestamp registrationDate;

    public User() {
    }

    public User(int userId, String openID, String nickname, String avatarURL, String email, String password, Timestamp registrationDate) {
        this.userId = userId;
        this.openID = openID;
        this.nickname = nickname;
        this.avatarURL = avatarURL;
        this.email = email;
        this.password = password;
        this.registrationDate = registrationDate;
    }

    /**
     * 获取
     * @return userId
     */
    public int getUserId() {
        return userId;
    }

    /**
     * 设置
     * @param userId
     */
    public void setUserId(int userId) {
        this.userId = userId;
    }

    /**
     * 获取
     * @return openID
     */
    public String getOpenID() {
        return openID;
    }

    /**
     * 设置
     * @param openID
     */
    public void setOpenID(String openID) {
        this.openID = openID;
    }

    /**
     * 获取
     * @return nickname
     */
    public String getNickname() {
        return nickname;
    }

    /**
     * 设置
     * @param nickname
     */
    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    /**
     * 获取
     * @return avatarURL
     */
    public String getAvatarURL() {
        return avatarURL;
    }

    /**
     * 设置
     * @param avatarURL
     */
    public void setAvatarURL(String avatarURL) {
        this.avatarURL = avatarURL;
    }

    /**
     * 获取
     * @return email
     */
    public String getEmail() {
        return email;
    }

    /**
     * 设置
     * @param email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * 获取
     * @return password
     */
    public String getPassword() {
        return password;
    }

    /**
     * 设置
     * @param password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * 获取
     * @return registrationDate
     */
    public Timestamp getRegistrationDate() {
        return registrationDate;
    }

    /**
     * 设置
     * @param registrationDate
     */
    public void setRegistrationDate(Timestamp registrationDate) {
        this.registrationDate = registrationDate;
    }

    public String toString() {
        return "User{userId = " + userId + ", openID = " + openID + ", nickname = " + nickname + ", avatarURL = " + avatarURL + ", email = " + email + ", password = " + password + ", registrationDate = " + registrationDate + "}";
    }
}
