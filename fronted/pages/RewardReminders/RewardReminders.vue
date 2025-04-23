<template>
    <view class="container">
      <view class="header">
        <image
          class="back-icon"
          @click="goBack"
          src="https://img.icons8.com/badges/48/left.png"
          mode="widthFix"
        />
        <view class="title">金币奖励通知</view>
      </view>
      <view class="message-list">
        <view class="message-item" v-for="(msg, index) in messages" :key="index">
          <view class="icon">💰</view>
          <view class="content">{{ msg }}</view>
        </view>
      </view>
      <view v-if="!messages.length" class="empty-state">
        暂无新的金币奖励通知哦～
      </view>
    </view>
  </template>
  
  <script>
  export default {
    data() {
      return {
        messages: [
          '用户C 回复了你的帖子《XXX问题》，你获得了奖励金币 ×10。',
          '用户D 给你的回复点赞，你获得金币 ×5。',
          '你的回答被设为“最佳解答”，金币 ×20 奖励已到账。'
        ]
      }
    },
    methods: {
      goBack() {
        uni.navigateBack();
      }
    }
  }
  </script>
  
  <style scoped>
  .container {
    padding: 30rpx;
    background-color: #f4faff; /* 浅蓝色背景，营造奖励的氛围 */
    min-height: 100vh;
  }
  
  .header {
    display: flex;
    align-items: center;
    margin-bottom: 30rpx;
  }
  
  .back-icon {
    width: 40rpx;
    height: 40rpx;
    margin-right: 20rpx;
  }
  
  .title {
    font-size: 40rpx;
    font-weight: bold;
    color: #333;
  }
  
  .message-list {
    /* 用于管理消息列表的样式 */
  }
  
  .message-item {
    background-color: #fff;
    padding: 25rpx;
    border-radius: 16rpx;
    margin-bottom: 20rpx;
    display: flex;
    align-items: center;
    box-shadow: 0 2rpx 8rpx rgba(0, 0, 0, 0.08); /* 增加轻微阴影 */
    border-left: 6rpx solid #ffc107; /* 增加一个金色的侧边栏，强调奖励 */
  }
  
  .icon {
    font-size: 36rpx;
    margin-right: 20rpx;
    color: #ffc107; /* 使用金色突出金币图标 */
  }
  
  .content {
    font-size: 30rpx;
    color: #555;
    line-height: 1.5;
  }
  
  .empty-state {
    text-align: center;
    color: #999;
    font-size: 28rpx;
    margin-top: 40rpx;
  }
  </style>