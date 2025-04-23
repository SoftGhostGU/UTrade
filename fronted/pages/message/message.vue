<script setup>
import { ref } from 'vue'

const uploadImage = () => {
  uni.chooseImage({
    count: 1,
    success: (res) => {
      console.log("上传成功：", res.tempFilePaths)
    }
  })
}
const guideToExchangeRequests = () => {
  uni.navigateTo({ url: '/pages/ExchangeRequests/ExchangeRequests' })
}
const guideToSystemNotifications = () => {
  uni.navigateTo({ url: '/pages/SystemNotifications/SystemNotifications' })
}
const guideToRewardReminders = () => {
  uni.navigateTo({ url: '/pages/RewardReminders/RewardReminders' })
}
const guideToCommentReminders = () => {
  uni.navigateTo({ url: '/pages/CommentReminders/CommentReminders' })
}
</script>


<template>
    <view class="total">
      <img class="back-icon" @click="$router.back()" width="40" height="40" src="https://img.icons8.com/badges/48/left.png" alt="left" />
  
      <!-- 顶部导航 -->
      <view class="back">
        <text class="title">消息中心</text>
      </view>
  
      <!-- 信息区域 -->
      <view class="info">
        <input class="search-box" type="text" placeholder="消息通知" />
      </view>
  
      <!-- 内容区域 -->
      <view class="skill-details">
        <!-- 通知项列表 -->
        <view class="notice-box" @click="guideToExchangeRequests">
          <img class="notice-icon" src="https://img.icons8.com/?size=100&id=qrlvHfwzH-EG&format=png&color=000000" alt="icon" style="background-color: white;" />
          <text class="notice-text">交换请求</text>
        </view>
        <view class="notice-box" @click="guideToSystemNotifications">
          <img class="notice-icon" src="https://img.icons8.com/?size=100&id=11668&format=png&color=FFFFFF" alt="icon" style="background-color: black;"/>
          <text class="notice-text">系统通知</text>
        </view>
        <view class="notice-box" @click="guideToRewardReminders">
            <img class="notice-icon" src="https://img.icons8.com/ios/50/FFFFFF/us-dollar-circled--v2.png" alt="icon" style="background-color: #f7b962;"/>
          <text class="notice-text">奖励通知</text>
        </view>
        <view class="notice-box" @click="guideToCommentReminders">
          <img class="notice-icon" src="https://img.icons8.com/?size=100&id=wcAdzrSxP9X7&format=png&color=000000" alt="icon" style="background-color: #e2e5f8;"/>
          <text class="notice-text">回复提醒</text>
        </view>
  
        <!-- 发布按钮 -->
        <button class="publish-btn">私信</button>
      </view>
    </view>
  </template>
  

<style scoped>
.total {
  width: 100vw;
  height: 100vh;
  background: linear-gradient(to bottom, #a160f6, #420df3);
  display: flex;
  flex-direction: column;
  position: relative;
}

.back-icon {
  position: absolute;
  top: 1rem;
  left: 1rem;
}

.back {
  width: 100%;
  height: 3rem;
  margin-top: 2rem;
  display: flex;
  justify-content: center;
  align-items: center;
}

.title {
  color: white;
  font-size: 1.2rem;
  font-weight: bold;
}

.info {
  width: 100%;
  padding: 1rem 0;
  display: flex;
  justify-content: center; /* 水平居中 */
}

.search-box {
  width: 80%; /* 设置搜索框宽度 */
  padding: 0.6rem 1rem;
  border-radius: 1.5rem;
  border: none;
  font-size: 1rem;
  color: #333;
  background-color: #f0f2f1;
  box-shadow: 0 1px 3px rgba(0,0,0,0.1);
}

.skill-details {
  width: 100%;
  height: calc(100vh - 9rem);
  background-color: #fefefc;
  border-radius: 1.5rem 1.5rem 0 0;
  padding: 2rem 1.5rem;
  box-sizing: border-box;
  z-index: 1;
}

.notice-box {
  background-color: #f0f2f1;
  border-radius: 1rem;
  padding: 1rem;
  display: flex;
  align-items: center;
  margin-top: 2rem;
  margin-bottom: 2rem;
}

.notice-icon {
  width: 1.8rem;
  height: 1.8rem;
  border-radius: 50%;
  background-color: #dcdcdc;
  margin-right: 1rem;
}

.notice-text {
  font-weight: bold;
  font-size: 1.1rem;
}

.publish-btn {
  margin-top: 6rem;
  width: 100%;
  background: linear-gradient(to right, #8a8ce7, #de80f3);
  color: white;
  font-weight: bold;
  font-size: 1rem;
  padding: 0.8rem;
  border-radius: 1.5rem;
}

</style>
