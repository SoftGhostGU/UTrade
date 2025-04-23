<template>
    <view class="container">
      <view class="header">
        <image
          class="back-icon"
          @click="goBack"
          src="https://img.icons8.com/badges/48/left.png"
          mode="widthFix"
        />
        <view class="title">评论互动</view>
      </view>
      <view class="notification-list">
        <view
          class="notification-item"
          v-for="(cmt, index) in comments"
          :key="index"
        >
          <view class="icon">💬</view>
          <view class="content">{{ cmt }}</view>
        </view>
      </view>
      <view v-if="!comments.length" class="empty-state">
        暂无新的回复哦～
      </view>
    </view>
  </template>
  
  <script>
  export default {
    data() {
      return {
        comments: [
          '用户E 回复了你的评论：“我也有类似问题！”',
          '用户F 提到了你：“@你 你之前的思路很有帮助”',
          '用户G 回复了你提出的建议。'
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
    background-color: #f8f8f8; /* Light grey background for better contrast */
    min-height: 100vh; /* Ensure the background covers the whole viewport */
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
    color: #333; /* Darker text for better readability */
  }
  
  .notification-list {
    /* No specific styling here yet, will style the items */
  }
  
  .notification-item {
    background-color: #fff; /* White background for each notification */
    padding: 25rpx;
    border-radius: 16rpx; /* More rounded corners */
    margin-bottom: 20rpx;
    display: flex;
    align-items: center;
    box-shadow: 0 2rpx 8rpx rgba(0, 0, 0, 0.08); /* Subtle shadow for depth */
  }
  
  .icon {
    font-size: 36rpx;
    margin-right: 20rpx;
    color: #007bff; /* A nice blue for the icon */
  }
  
  .content {
    font-size: 30rpx;
    color: #555; /* Slightly lighter text for the content */
    line-height: 1.5; /* Improved line spacing for readability */
  }
  
  .empty-state {
    text-align: center;
    color: #999;
    font-size: 28rpx;
    margin-top: 40rpx;
  }
  </style>