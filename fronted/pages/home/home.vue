<script setup>
import { ref } from 'vue';

const searchText = ref('');
const emit = defineEmits(['showTabBar']);

const skills = [
  {
    cover: '/static/PR.png',
    label: '推荐',
    title: 'PR剪辑',
    avater: '/static/PRer.png',
    username: '张伟',
  },
  {
    cover: '/static/pic.png',
    label: '直播中',
    title: '摄影',
    avater: '/static/picer.png',
    username: '李华',
  },
  {
    cover: '/static/cook.png',
    label: '热门',
    title: '厨艺',
    avater: '/static/cooker.png',
    username: '赵敏',
  },
  {
    cover: '/static/tatennis.png',
    label: '推荐',
    title: '乒乓球',
    avater: '/static/tatenniser.png',
    username: '王强',
  }
];

// 根据 label 设置背景色
const getLabelBackgroundColor = (label) => {
  switch (label) {
    case '热门':
      return '#efc958';
    case '直播中':
      return '#f46d60';
    case '推荐':
      return '#4ac58e';
    default:
      return '#ccc'; // 默认背景色
  }
};

</script>

<template>
  <view class="home">
    <!-- 头部导航栏 -->
    <header>
      <div class="header-content">
        <div class="logo">
          <strong style="color: white;" class="Ulogo">U</strong>
          <strong style="color: white;">Trade</strong>
          ————大学生技能交换市场
        </div>
      </div>
      <view class="search-bar">
        <view class="search-icon">
          <svg xmlns="http://www.w3.org/2000/svg" x="0px" y="0px" width="60" height="20" viewBox="0 0 30 30">
            <path d="M 13 3 C 7.4889971 3 3 7.4889971 3 13 C 3 18.511003 7.4889971 23 13 23 C 15.396508 23 17.597385 22.148986 19.322266 20.736328 L 25.292969 26.707031 A 1.0001 1.0001 0 1 0 26.707031 25.292969 L 20.736328 19.322266 C 22.148986 17.597385 23 15.396508 23 13 C 23 7.4889971 18.511003 3 13 3 z M 13 5 C 17.430123 5 21 8.5698774 21 13 C 21 17.430123 17.430123 21 13 21 C 8.5698774 21 5 17.430123 5 13 C 5 8.5698774 8.5698774 5 13 5 z"></path>
          </svg>
        </view>
        <input type="text" v-model="searchText" placeholder="技能发布" style="flex: 1; border: none; outline: none; font-size: 16px; color: black;">
      </view>
      <text class="header-left">技能发布</text>
    </header>

    <!-- 页面主体 -->
    <view class="main">
      <h3>热门技能</h3>

      <!-- 热门技能展示 -->
      <view class="skill-cards">
        <view
          v-for="(skill, index) in skills"
          :key="index"
          class="card"
        >
          <view class="card-cover">
            <image :src="skill.cover" mode="aspectFill" style="width: 100%; height: 200px;"></image>
            <view class="card-label" :style="{ backgroundColor: getLabelBackgroundColor(skill.label) }">
              {{ skill.label }}
            </view>
          </view>
          <h4>{{ skill.title }}</h4>
          <view class="profile">
            <view class="avatar">
              <img :src="skill.avater" style="width: 100%; height: 100%; border-radius: 50%;">
            </view>
            <span>{{ skill.username }}</span>
          </view>
        </view>
      </view>
    </view>
  </view>
</template>



<style>
/* 全局样式 */
.home {
  max-width: 600px;
  margin: 0 auto;
  min-height: 100vh;
  background-color: #f5f5f5;
}

/* 头部样式 */
header {
  background: linear-gradient(to bottom, #855aec, #63a6f6);
  height: 200px;
  clip-path: ellipse(100% 100% at 50% 0%);
  padding: 10px 20px;
  display: flex;
  flex-direction: column;
  justify-content: space-around;
  align-items: center;
  color: white;
}

.header-content {
  display: flex;
  justify-content: space-between;
}

.header-left {
  color: white; 
  font-size: 1.2rem; 
  align-self: flex-start;
  font-family: '华文琥珀';
  margin: 0 0 1rem 1.5rem;
  position: relative;
}

.header-left::after {
  content: '';
  position: absolute;
  left: 50%;
  transform: translate(-50%, -50%);
  bottom: -0.6rem; 
  width: 60%;
  height: 0.25rem; 
  background-color: #ecc483; 
  border-radius: 2px; 
}

.logo {
  font-size: 32rpx;
  font-weight: 500;
  font-family: 'Franklin Gothic Medium', 'Arial Narrow', Arial, sans-serif;
}

.logo strong {
  font-size: 60rpx;
  font-weight: 1000;
}

.logo .Ulogo {
  font-size: 80rpx;
  font-weight: 1000;
  font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
}

/* 搜索栏样式 */
.search-bar {
  width: 80vw;
  background-color: #fff;
  padding: 10px 10px;
  border-radius: 19px;
  display: flex;
  align-items: center;
}

.search-icon {
  width: 30px;
  display: flex;
  align-items: center;
  margin-right: 10px;
}

h3 {
  margin-bottom: 1rem;
}

/* 页面主体样式 */
.main {
  padding: 20px;
}

.skill-cards {
  display: grid;
  grid-template-columns: repeat(2, 1fr);
  gap: 20px;
}

.card {
  border-radius: 10px;
  box-shadow: 0 4px 6px rgba(0, 0, 0, 0.1);
}

.card-cover {
  position: relative;
  overflow: hidden;
  aspect-ratio: 1/1;
  background-color: #7e67f4;
  border-radius: 1rem;
}

.card-label {
  position: absolute;
  top: 10px;
  left: 10px;
  color: white;
  padding: 5px 10px;
  border-radius: 5px;
  font-size: 12px;
}

.card-badge {
  position: absolute;
  bottom: 10px;
  right: 10px;
  color: #6a59ca;
  font-size: 16px;
}

.card h4 {
  padding: 10px;
  font-size: 16px;
  color: #333;
}

.profile {
  padding: 10px;
  display: flex;
  align-items: center;
}

.profile span {
  font-size: 0.8rem;
}

.avatar {
  width: 30px;
  height: 30px;
  border-radius: 50%;
  background-color: #ccc;
  overflow: hidden; /* 确保图像内容不会超出圆形 */
  margin-right: 10px;
}

.avatar img {
  width: 100%;
  height: 100%;
  border-radius: 50%;
  object-fit: cover; /* 确保图像内容覆盖整个圆形 */
}
</style>
