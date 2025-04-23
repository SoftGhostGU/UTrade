<template>
    <view class="container">
      <view class="header">
        <image
          class="back-icon"
          @click="goBack"
          src="https://img.icons8.com/badges/48/left.png"
          mode="widthFix"
        />
        <view class="title">交换请求</view>
      </view>
      <view class="exchange-list">
        <view class="exchange-card" v-for="(item, index) in exchangeList" :key="index">
          <view class="card-content">
            <view class="message">🤝 {{ item.message }}</view>
            <view class="status" :class="{'status-pending': item.status === '待处理', 'status-accepted': item.status === '已接受', 'status-rejected': item.status === '已拒绝'}">{{ item.status }}</view>
          </view>
          <view class="card-actions" v-if="item.status === '待处理'">
            <button class="accept-button" @click="accept(index)">接受</button>
            <button class="reject-button" @click="reject(index)">拒绝</button>
          </view>
        </view>
      </view>
      <view v-if="!exchangeList.length" class="empty-state">
        暂无交换请求～
      </view>
    </view>
  </template>
  
  <script>
  export default {
    data() {
      return {
        exchangeList: [
          { message: '用户A 向你发起交换请求', status: '待处理' },
          { message: '用户B 提交了修改后的交换方案', status: '已处理' }
        ]
      }
    },
    methods: {
      goBack() {
        uni.navigateBack();
      },
      accept(index) {
        this.exchangeList[index].status = '已接受';
      },
      reject(index) {
        this.exchangeList[index].status = '已拒绝';
      }
    }
  }
  </script>
  
  <style scoped>
  .container {
    padding: 30rpx;
    background-color: #f4f7f6; /* 浅绿色背景，暗示协作 */
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
  
  .exchange-list {
    /* 用于管理交换请求列表 */
  }
  
  .exchange-card {
    background-color: #fff;
    padding: 25rpx;
    border-radius: 16rpx;
    margin-bottom: 20rpx;
    box-shadow: 0 2rpx 10rpx rgba(0, 0, 0, 0.08); /* 更明显的阴影 */
    display: flex;
    flex-direction: column; /* 让内容和操作垂直排列 */
  }
  
  .card-content {
    margin-bottom: 20rpx; /* 为内容和操作按钮之间留出空间 */
  }
  
  .message {
    font-size: 32rpx;
    color: #333;
    line-height: 1.4;
    margin-bottom: 10rpx;
  }
  
  .status {
    font-size: 28rpx;
    font-style: italic;
  }
  
  .status-pending {
    color: #ff9800; /* 橙色，表示待处理 */
  }
  
  .status-accepted {
    color: #4caf50; /* 绿色，表示已接受 */
  }
  
  .status-rejected {
    color: #f44336; /* 红色，表示已拒绝 */
  }
  
  .card-actions {
    display: flex;
    gap: 20rpx; /* 使用 gap 属性设置按钮之间的间距 */
  }
  
  .accept-button {
    flex-grow: 1; /* 使按钮尽可能平分剩余空间 */
    background-color: #4caf50;
    color: #fff;
    border: none;
    padding: 15rpx 20rpx;
    border-radius: 10rpx;
    font-size: 28rpx;
  }
  
  .reject-button {
    flex-grow: 1;
    background-color: #f44336;
    color: #fff;
    border: none;
    padding: 15rpx 20rpx;
    border-radius: 10rpx;
    font-size: 28rpx;
  }
  
  .empty-state {
    text-align: center;
    color: #999;
    font-size: 28rpx;
    margin-top: 40rpx;
  }
  </style>