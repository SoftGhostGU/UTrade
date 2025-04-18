<script setup>
import { ref } from 'vue'

const skills = ref([])
const exchangeOptions = ref([])

const skillOptions = ["PR剪辑", "乒乓球", "摄影", "其他"]
const exchangeItems = ["PR剪辑", "乒乓球", "摄影", "时间币", "其他"]
const iconImages = ref([
 "https://img.icons8.com/badges/48/sport.png",
  "https://img.icons8.com/color/50/sports.png" ,
  "https://img.icons8.com/clouds/50/stack-of-photos.png",
  "https://img.icons8.com/ios-filled/50/salt-bae.png",
  "https://img.icons8.com/plasticine/100/ping-pong--v1.png",
  "https://img.icons8.com/emoji/48/basketball-emoji.png",
  "https://img.icons8.com/emoji/48/martial-arts-uniform-emoji.png",
  "https://img.icons8.com/emoji/48/field-hockey-emoji.png"
])
const iconColors = ref([
  "#FFB6C1",  
  "#87CEFA", 
  "#98FB98",  
  "#DDA0DD",  
  "#FFD700",  
  "#FFA07A",  
  "#E0FFFF",  
  "#D3D3D3"   
])
const uploadImage = () => {
  // 这里用 chooseImage API 来模拟上传图片
  uni.chooseImage({
    count: 1,
    success: (res) => {
      console.log("上传成功：", res.tempFilePaths)
    }
  })
}
</script>

<template>
  <view class="total">
    <!-- 顶部导航 -->
    <view class="back">
      <text class="title">技能发布</text>
    </view>

    <!-- 信息区域（与图标浮层交界） -->
    <view class="info"></view>

    <!-- 技能图标盒子 -->
    <view class="icon-box">
  <!-- 使用图片路径数组循环渲染 -->
  <view 
    class="icon" 
    v-for="(img, index) in iconImages" 
    :key="index"
    
  >
    <img 
      :src="img" 
      :alt="'icon-' + index"
      class="icon-img"
       :style="{ backgroundColor: iconColors[index] }"
    />
  </view>
</view>

    <!-- 内容区域 -->
    <view class="skill-details">
      <!-- 技能 -->
      <view class="section">
        <text class="label">技能</text>
        <picker 
          mode="multiSelector" 
          :range="[skillOptions]" 
          @change="(e) => skills.value = e.detail.value">
          <view class="picker">选择技能</view>
        </picker>
      </view>

      <!-- 想交换 -->
      <view class="section">
        <text class="label">想交换</text>
        <picker 
          mode="multiSelector" 
          :range="[exchangeItems]" 
          @change="(e) => exchangeOptions.value = e.detail.value">
          <view class="picker">选择内容</view>
        </picker>
      </view>

      <!-- 示例图上传 -->
      <view class="section">
        <text class="label">示例图</text>
        <view class="upload-box" @click="uploadImage">
          <text class="plus">+</text>
        </view>
      </view>

      <!-- 发布按钮 -->
      <button class="publish-btn">立即发布</button>
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
  height: 5rem;
}

.icon-box {
  position: absolute;
  top: 6rem;
  left: 10%;
  right: 10%;
  height: 8rem; /* 提高高度 */
  background-color: #fffffd;
  border-radius: 1rem;
  box-shadow: 0 2px 6px rgba(0,0,0,0.1);
  display: flex;
  flex-wrap: wrap; /* 允许换行 */
  justify-content: space-around;
  align-items: center;
  padding: 0.5rem 1rem;
  z-index: 10;
}

.icon {
  width: 2.5rem;
  height: 2.5rem;
  background-color: #eee;
  border-radius: 0.5rem;
  margin: 0.3rem 0.5rem; /* 间距设置 */
  overflow: hidden; /* 隐藏溢出部分 */
  position: relative; /* 为图片定位提供参考 */
}
.icon-img {
  width: 100%;
  height: 100%;
  object-fit: cover; /* 保持比例填充容器 */
  border-radius: 0.5rem; /* 继承父容器圆角 */
  display: block; /* 消除图片底部间隙 */
}
.skill-details {
  width: 100%;
  height: calc(100vh - 10rem);
  background-color: #fefefc;
  border-radius: 1.5rem 1.5rem 0 0;
  padding: 6.5rem 1.5rem 0;
  box-sizing: border-box;
  z-index: 1;
}

.section {
  margin-bottom: 2rem;
}

.label {
  font-size: 1rem;
  font-weight: 600;
  margin-bottom: 0.5rem;
  display: block;
}

.picker {
  background-color: #f5f5f6;
  padding: 0.6rem;
  border-radius: 1.5rem;
  color: #888;
}

.upload-box {
  width: 6rem;
  height: 6rem;
  border: 2px dashed #ccc;
  border-radius: 1rem;
  display: flex;
  justify-content: center;
  align-items: center;
  color: #888;
  font-size: 2rem;
  margin-top: 0.5rem;
}

.publish-btn {
  margin-top: 2rem;
  width: 100%;
  background: linear-gradient(to right, #8a8ce7, #de80f3);
  color: white;
  font-weight: bold;
  font-size: 1rem;
  padding: 0.8rem;
  border-radius: 1.5rem;
}
</style>
