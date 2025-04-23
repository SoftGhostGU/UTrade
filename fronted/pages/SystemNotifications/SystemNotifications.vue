<template>
    <view class="container">
      <view class="header">
        <image
          class="back-icon"
          @click="goBack"
          src="https://img.icons8.com/badges/48/left.png"
          mode="widthFix"
        />
        <view class="title">系统通知</view>
      </view>
      <view class="notice-list">
        <view class="notice-item" v-for="(item, index) in notices" :key="index">
          <view class="icon">📢</view>
          <view class="content">{{ item }}</view>
        </view>
      </view>
      <view v-if="!notices.length" class="empty-state">
        暂无系统通知～
      </view>
    </view>
  </template>
  
  <script>
  export default {
    data() {
      return {
        notices: [
          '系统将在 4 月 25 日 0:00-6:00 进行维护，期间部分功能不可用。',
          '恭喜你完成“本周任务”，已获得奖励金币 ×50！',
          '新版本已上线，点击查看更新日志。'
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
    background-color: #f5f5f5; /* 浅灰色背景，简洁大气 */
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
  
  .notice-list {
    /* 用于管理通知列表的样式 */
  }
  
  .notice-item {
    background-color: #fff;
    padding: 25rpx;
    border-radius: 16rpx;
    margin-bottom: 20rpx;
    display: flex;
    align-items: center;
    box-shadow: 0 2rpx 8rpx rgba(0, 0, 0, 0.08); /* 轻微阴影增加层次感 */
    border-left: 6rpx solid #007bff; /* 蓝色侧边栏，突出系统通知 */
  }
  
  .icon {
    font-size: 36rpx;
    margin-right: 20rpx;
    color: #007bff; /* 蓝色通知图标，醒目 */
  }
  
  .content {
    font-size: 30rpx;
    color: #444; /* 稍微深一点的灰色，更专业 */
    line-height: 1.6; /* 增加行高，提高阅读舒适度 */
  }
  
  .empty-state {
    text-align: center;
    color: #999;
    font-size: 28rpx;
    margin-top: 40rpx;
  }
  </style>